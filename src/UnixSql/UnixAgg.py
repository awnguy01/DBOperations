import re
from typing import List, Tuple


def compute_agg_command(targets: List[str], src_headers: List[str]) -> str:
    args = ['python3 "{AGG_PATH}"']
    args.append('-h -s ","')

    agg_fn_pairs: Tuple[str, str] = [
        re.findall(r'(.+)\((.+)\)', target)
        for target
        in targets
    ]

    fn_arg_list: List[str] = []
    attribute_arg_list: List[str] = []

    for pair in agg_fn_pairs:
        fn_arg_list.append(pair[0].lower())
        attribute_arg_list.append(pair[1].upper())

    fns_arg = ','.join(fn_arg_list)
    attributes_arg = ','.join(attribute_arg_list)

    for i, header in enumerate(src_headers):
        attributes_arg = re.sub(fr'\b{header}\b', f'#{i + 1}',
                                attributes_arg, flags=re.IGNORECASE)

    args.append(f"-a '{attributes_arg}'")
    args.append(f"-f '{fns_arg}'")

    return ' '.join(args)