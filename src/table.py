class Table:
    def __init__(self, table_name=None, table_alias=None):
        self.table_name: str = table_name
        self.table_alias: str = table_alias

    def __str__(self):
        return (self.table_name + ' ' + (self.table_alias or '')).strip()
