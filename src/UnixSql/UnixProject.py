from typing import List
from models.Table import Table
from models.Attribute import Attribute
import re

STRIP_FN_REGEX = r'\b(SUM|COUNT|AVG|MIN|MAX)\(|\)'


def find_all_projections_for_source(attributes: List[Attribute], source: Table):
    return sorted((
        projection
        for projection
        in dict.fromkeys([
            re.sub(
                STRIP_FN_REGEX, '', attribute.name, flags=re.IGNORECASE)
            for attribute
            in attributes
            if attribute.source.name == source.name
        ])), key=(lambda projection: source.headers.index(projection)))
