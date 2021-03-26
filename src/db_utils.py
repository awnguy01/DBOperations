from typing import Dict, List
from database import Database
import os
import glob


def scan_directory():
    db: Database = Database()
    cwd: str = os.getcwd() + '/*.csv'
    files = glob.glob(cwd)
    for fname in files:
        path, ext = os.path.splitext(fname)
        try:
            if ext == '.csv':
                with open(fname) as f:
                    header: List[str] = f.readline().strip().split(sep=',')
                    db.add_table(os.path.basename(path), header)
        except:
            raise Exception('Failed to read database from directory')
    return db


# def peek_file_headers(infiles: List[Tuple(str, bool)]):
#     header_map: Dict[str, List[str]] = dict()
#     for infile in infiles:
#         fname = infile[0]
#         has_headers = infile[1]
#         try:
#             file = open(fname)
#         except IOError:
#             raise Exception('Failed to open file named ' + fname)
#         if has_headers:
#             header_map[fname] = file.readline().split()
#         else:
#             counter = 0
#             header_map[fname] = map(
#                 lambda _: '#' + str(++counter),  file.readline().split())
#     return header_map
