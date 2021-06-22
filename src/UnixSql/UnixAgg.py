import re
from typing import List, Tuple


def compute_agg_command(targets: List[str], src_headers: List[str]) -> str:
    """
    Modular function for translating any aggregate functions in the SQL statement into UNIX commands
    """
    # Call agg.py with python3 (path to agg.py is stored as a global constant in sql_executor.py)
    args = ['python3 "{AGG_PATH}"']
    # Append arguments to specify header (program will always generate a header even if there is no
    # header in the original source table) and field delimiter (default to comma for now)
    args.append('-h -s ","')

    # Separate aggregate function from its corresponding column into a tuple (i.e. max(#1) -> (max, #1))
    agg_fn_pairs: List[Tuple[str, str]] = [
        re.findall(r'(.+)\((.+)\)', target)
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

    # Replace any header names with field references
    for i, header in enumerate(src_headers):
        attributes_arg = re.sub(fr'\b{header}\b', f'#{i + 1}',
                                attributes_arg, flags=re.IGNORECASE)

    args.append(f"-a '{attributes_arg}'")
    args.append(f"-f '{fns_arg}'")

    return ' '.join(args)
