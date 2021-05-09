from os import path
import re
from typing import List
from utils.db import STRIP_FN_REGEX
from models.Attribute import Attribute

GROUP_PATH = path.join(path.dirname(__file__), '..', 'group.py')

def compute_group_by_command(targets: List[str], src_headers: List[str]) -> str:
    args = ["sort -V -u -t ','"]
    fields = ' '.join(targets)
    for i, header in enumerate(src_headers):
        fields = re.sub(fr'\b{header}\b', f'-k {i + 1},{i + 1}',
                        fields, flags=re.IGNORECASE)
    args.append(fields)
    return ' '.join(args)

def compute_group_by_with_agg_command(targets: List[Attribute], src_headers: List[str]) -> str:
    args = [f'python3 "{GROUP_PATH}"']
    args.append("-s ','")
    attributes_arg = ','.join([f'#{src_headers.index(target.name) + 1}'
                               for target
                               in targets
                               if '(' not in target.name])
    fns: List[str] = [
        target.name
        for target
        in targets
        if '(' in target.name
    ]

    for i in range(len(fns)):
        col_name = re.sub(STRIP_FN_REGEX, '', fns[i])
        fns[i] = re.sub(col_name, f'#{src_headers.index(col_name) + 1}', fns[i])

    fns_arg = ','.join(fns).lower()

    for i, header in enumerate(src_headers):
        attributes_arg = re.sub(fr'\b{header}\b', f'#{i + 1}',
                                attributes_arg, flags=re.IGNORECASE)
        fns_arg = re.sub(fr'\b{header}\b', f'#{i + 1}',
                         fns_arg, flags=re.IGNORECASE)

    args.append(f"-a '{attributes_arg}'")
    args.append(f"-f '{fns_arg}'")

    return ' '.join(args)