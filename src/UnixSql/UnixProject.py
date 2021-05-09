from typing import List
from models.Table import Table
from models.Attribute import Attribute
import re

STRIP_FN_REGEX = r'\b(SUM|COUNT|AVG|MIN|MAX)\(|\)'


def compute_project_command(projection_list: List[str], source: Table, initial: bool) -> str:
    pipes: List[str] = []

    if set(source.headers).issubset(projection_list):
        pipes.append('cat ' + f'"{source.full_path}"' if initial else '')
    else:
        cut_args = ['cut']
        projections = re.sub('#', '', ','.join(projection_list))
        for i, header in enumerate(source.headers):
            projections = re.sub(fr'\b{header}\b', str(
                i + 1), projections, flags=re.IGNORECASE)
        if initial:
            cut_args.append(f'"{source.full_path}"')
        cut_args.append(f'-d "{source.delimiter}" -f "{projections}"')
        pipes.append(' '.join(cut_args))

    if initial and type(source.headers[0]) is str:
        pipes.append('tail -n+2')

    return ' | '.join(pipes)


def find_all_projections_for_source(attributes: List[Attribute], source: Table):
    return sorted((
        projection
        for projection
        in dict.fromkeys([
            re.sub(
                STRIP_FN_REGEX, '', attribute.name, flags=re.IGNORECASE)
            for attribute
            in attributes
            if attribute.source.name == source.name
        ])), 
        key=(lambda projection: int(projection[1:])))
        # key=(lambda projection: int(projection[1:]) if projection[0] == '#' else source.headers.index(projection)))
