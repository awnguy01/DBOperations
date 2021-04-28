from enum import Enum
from models import Table


class AttributeType(Enum):
    SELECT = 1
    AGG = 2
    JOIN = 3
    WHERE = 4
    GROUP_BY = 5
    ORDER_BY = 6


class Attribute:
    def __init__(self, name: str, alias: str, source: Table, association: AttributeType) -> None:
        self.name: str = name
        self.alias: str = alias
        self.source: Table = source
        self.association: AttributeType = association
