from typing import Dict, List


class Database:
    def __init__(self):
        self.schema: Dict[str, List[str]] = {}

    def add_table(self, name: str, header: List[str]):
        self.schema[name] = header

    def __str__(self):
        db_str = ''

        def append_item(name, header):
            nonlocal db_str
            db_str += '\r\n"' + name + '"' + ' : [\r\n\t'
            if len(header) > 0:
                db_str += '"'+header[0]+'"'
                for col in header[1:]:
                    db_str += ', \r\n\t' + '"'+col+'"'
            db_str += '\r\n]'
        if len(self.schema.items()):
            append_item(*(list(self.schema.items())[0]))
            for name, header in list(self.schema.items())[1:]:
                db_str += ',\r\n'
                append_item(name, header)

        return db_str
