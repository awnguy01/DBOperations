from enum import Enum


class JoinType(Enum):
    INNER = 1
    LEFT = 2
    RIGHT = 3
    FULL = 4


class Join:
    def __init__(self, left: str = None) -> None:
        self.left: str = left
        self.right: str = None
        self.join_type: JoinType = None
        self.left_attribute: str = None
        self.right_attribute: str = None
