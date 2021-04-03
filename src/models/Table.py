class Table:
    def __init__(self, full_path: str, name: str, alias: str = '') -> None:
        self.full_path = full_path
        self.name = name
        self.alias = alias
