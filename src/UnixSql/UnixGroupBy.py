from os import path
import re
from typing import List
from utils.db import STRIP_FN_REGEX, replace_columns_with_field_refs
from models.Attribute import Attribute
from models.Table import Table

GROUP_PATH = path.join(path.dirname(__file__), '..', 'group.py')


def compute_group_by_command(targets: List[Attribute], src: Table) -> str:
    """
    Modular function for translating any GROUP BY clauses in the SQL statement into UNIX commands
    """
    # Sort command with a -u command effectively performs the equivalent to a GROUP BY
    delimiter = "$'\\t'" if src.delimiter == '\t' else f'\'{src.delimiter}\''
    args = [f'sort -V -u -t {delimiter}']
    fields = ' '.join([target.name for target in targets])

    # Replace any header names with field references
    for i, header in enumerate(src.headers):
        fields = re.sub(fr'\b{header}\b', f'-k {i + 1},{i + 1}',
                        fields, flags=re.IGNORECASE)
    args.append(fields)
    return ' '.join(args)


def compute_group_by_with_agg_command(targets: List[Attribute], src: Table) -> str:
    """
    Modular function for translating any GROUP BY clauses with aggregate functions in the SQL statement into UNIX commands
    """
    # Call group.py with python3
    args = [f'python3 "{GROUP_PATH}"']
    # Add argument for the field delimiter
    delimiter = '\\t' if src.delimiter == '\t' else src.delimiter
    args.append(f'-s \'{delimiter}\'')

    # Generate argument including only columns needed for the GROUP BY
    attributes_arg = ','.join([f'#{src.headers.index(target.name) + 1}'
                               for target
                               in targets
                               if '(' not in target.name])

    # Generate argument including only aggregate functions
    fns: List[str] = [
        target.name
        for target
        in targets
        if '(' in target.name
    ]

    # Replace column names in aggregate functions with their appropriate field references
    for i in range(len(fns)):
        col_name = re.sub(STRIP_FN_REGEX, '', fns[i])
        fns[i] = re.sub(
            col_name, f'#{src.headers.index(col_name) + 1}', fns[i])

    fns_arg = ','.join(fns).lower()
    # Replace any remaining column names in the arguments with field references
    attributes_arg, fns_arg = replace_columns_with_field_refs(
        src.headers,
        [attributes_arg, fns_arg])

    args.append(f"-a '{attributes_arg}'")
    args.append(f"-f '{fns_arg}'")

    return ' '.join(args)
