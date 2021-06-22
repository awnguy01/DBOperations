from typing import List
from models.Table import Table
import re


def compute_order_by_command(targets: List[str], src: Table) -> str:
    """
    Modular function for translating any ORDER BY clauses in the SQL statement into UNIX commands
    """
    delimiter = "$'\\t'" if src.delimiter == '\t' else f'"{src.delimiter}"'
    args = [f'sort -V -t {delimiter}']
    fields = ' '.join(targets)
    for i, header in enumerate(src.headers):
        fields = re.sub(fr'{header}\b', f'-k {i + 1},{i + 1}',
                        fields, flags=re.IGNORECASE)
    args.append(fields)
    return ' '.join(args)
