class Result_Column:
    def __init__(self):
        self.table_name: str = None
        self.is_star = False
        self.column_name: str = None
        self.column_alias: str = None

    def __str__(self):
        buf = ''
        if self.table_name:
            buf += self.table_name + '.'
        if self.is_star:
            buf += '*'
        elif self.column_name:
            buf += self.column_name
        if self.column_alias:
            buf += ' ' + self.column_alias
        return buf
