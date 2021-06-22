from os import path
import re
from models.Attribute import Attribute
from typing import List, Tuple
from models.Table import Table

AGG_PATH = path.join(path.dirname(__file__), '..', 'agg.py')


def compute_agg_command(targets: List[Attribute], src: Table) -> str:
    """
    Modular function for translating any aggregate functions in the SQL statement into UNIX commands
    """
    # Call agg.py with python3
    args = [f'python3 "{AGG_PATH}"']
    # Append argument to specify field delimiter (using escaped character for tab delimiters).
    # Use the escaped character for tab delimiters.
    delimiter = '\\t' if src.delimiter == '\t' else src.delimiter
    args.append(f'-s "{delimiter}"')

    # Separate aggregate function from its corresponding column into a tuple (i.e. max(#1) -> (max, #1))
    agg_fn_pairs: List[Tuple[str, str]] = [
        re.findall(r'(.+)\((.+)\)', target.name)[0]
        for target
        in targets
    ]

    fn_arg_list: List[str] = []
    attribute_arg_list: List[str] = []

    # Iterate through list of aggregate tuples and split them into individual lists (needed for formatting of arguments for agg.py)
    for pair in agg_fn_pairs:
        fn_arg_list.append(pair[0].lower())
        attribute_arg_list.append(pair[1].upper())

    # Format aggregate function list and column list into command line arguments
    fns_arg = ','.join(fn_arg_list)
    attributes_arg = ','.join(attribute_arg_list)

    # Replace any header names with field references (zero-indexed to match agg.py argument formatting)
    for i, header in enumerate(src.headers):
        attributes_arg = re.sub(fr'{header}\b', f'#{i}',
                                attributes_arg, flags=re.IGNORECASE)

    args.append(f"-a '{attributes_arg}'")
    args.append(f"-f '{fns_arg}'")
    args.append('| tail -n+2')

    return ' '.join(args)
