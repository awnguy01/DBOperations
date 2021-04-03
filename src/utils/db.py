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
        return map(lambda c: c.upper(),
                   f.readline().strip().split(sep=','))
