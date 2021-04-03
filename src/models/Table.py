from typing import List


class Table:
    def __init__(self, full_path: str, name: str, alias: str = '', headers: List[str] = []) -> None:
        self.full_path = full_path
        self.name = name
        self.alias = alias
        self.headers = headers
