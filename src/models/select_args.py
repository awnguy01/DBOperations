from typing import List


class SelectArgs:
    def __init__(self, condition='', table_file='', splitter=',', projections=[]) -> None:
        self.condition: str = condition
        self.table_file: str = table_file
        self.splitter: str = splitter
        self.projections: List[str] = projections
