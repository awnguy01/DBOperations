from typing import List, Tuple
import re


def compute_order_by_command(targets: List[str], src_headers: List[Tuple[str, str]]) -> str:
    args = [f'sort -V -t ","']
    fields = ' '.join(targets)
    for i, header in enumerate(src_headers):
        fields = re.sub(fr'\b({header[0]}|{header[1]})\b', f'-k {i + 1},{i + 1}',
                        fields, flags=re.IGNORECASE)
    args.append(fields)
    return ' '.join(args)
