from typing import List


class Table:
    def __init__(self, full_path: str, name: str, alias: str = '', delimiter: str = ',', headers: List[str] = [], has_header_row: bool = False) -> None:
        self.full_path = full_path
        self.name = name
        self.alias = alias
        self.delimiter = delimiter
        self.headers = headers
        self.has_header_row = has_header_row
