from typing import List
from models.Table import Table
from models.Attribute import Attribute
import re

STRIP_FN_REGEX = r'\b(SUM|COUNT|AVG|MIN|MAX)\(|\)'


def compute_project_command(projection_list: List[str], source: Table, initial: bool) -> str:
    """
    Modular function for translating any projections in the SQL statement into UNIX commands.
    This function can be applied multiple times to reduce size of the result set.
    """
    pipes: List[str] = []

    if set(source.headers).issubset(projection_list):
        # If all the source table headers are included in the projection list, append only the cat command
        pipes.append('cat ' + f'"{source.full_path}"' if initial else '')
    else:
        # If some source table headers are not included in the projection list, append the cut command
        cut_args = ['cut']
        projections = ','.join(projection_list)
        # Replace any column names with field references
        for i, header in enumerate(source.headers):
            projections = re.sub(fr'\b{header}\b', str(
                i + 1), projections, flags=re.IGNORECASE)
        # Use field reference numbers as the arguments for cut
        projections = re.sub('#', '', projections)
        if initial:
            # Append the full path to the source table if this is the first time the table is printed to stdout,
            # otherwise, assume the table is already printed by a previous piped command
            cut_args.append(f'"{source.full_path}"')
        delimiter = "$'\\t'" if source.delimiter == '\t' else f'"{source.delimiter}"'
        cut_args.append(f'-d {delimiter} -f "{projections}"')
        pipes.append(' '.join(cut_args))

    if initial and source.has_header_row:
        # If the original source table has a header row, use tail to ignore it in lieu of the program-generated header
        pipes.append('tail -n+2')

    return ' | '.join(pipes)


def find_all_projections_for_source(attributes: List[Attribute], source: Table):
    """
    Find all the remaining relevant columns in the source table by searching the given attributes list
    """
    projected_attributes = dict.fromkeys([
        re.sub(
            STRIP_FN_REGEX, '', attribute.name, flags=re.IGNORECASE)
        for attribute
        in attributes
        if attribute.source.name == source.name
    ])
    return [header for header in source.headers if any(attribute in header for attribute in projected_attributes)]
