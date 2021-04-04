import os
import glob
from typing import Dict, List

from models.Table import Table


def find_table(search_name: str) -> Table:
    cmp_name = search_name.upper()
    allfiles = glob.glob(os.getcwd() + '/*.csv')
    for fpath in allfiles:
        basename = os.path.splitext(os.path.basename(fpath))[0]
        if basename.upper() == cmp_name:
            table = Table(fpath, basename)
            table.headers = read_table_header(fpath)
            return table

    return None


def read_table_header(path: str) -> List[str]:
    with open(path) as f:
        return list(map(lambda c: c.upper(),
                   f.readline().strip().split(sep=',')))


def ref_field_in_bounds(projection: str, source: Table):
    return projection[1:].isdigit() and int(projection[1:]) <= len(list(source.headers))


def col_name_found(projection: str, source: Table):
    return projection.upper() in map(lambda header: header.upper(), source.headers)
