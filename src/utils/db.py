import os
import glob

from models.Table import Table


def find_table(searchname: str):
    cmp_name = searchname.upper()
    allfiles = glob.glob(os.getcwd() + '/*.csv')
    for fname in allfiles:
        basename = os.path.splitext(os.path.basename(fname))[0]
        if basename.upper() == cmp_name:
            return Table(fname, basename)
    return None
