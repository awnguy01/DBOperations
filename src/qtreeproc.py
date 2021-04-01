from applycond import apply_logicalop, apply_condition


def run1_query_tree(tree, line, headers):
    '''
    Returns a boolean after applying the query tree on the input line
    :param tree: Query  tree
    :param line: line read from the input data file
    :return: applies conditional operators to return a Boolean
    '''
    root, lefttree, righttree = ['', '', '']

    if type(tree) in [tuple, list]:
        root, lefttree, righttree = tree

    root = root.upper()

    if root != 'AND' and root != 'OR' and root != 'NOT':
        return apply_condition((root, lefttree, righttree), line, headers)

    # evaluate left tree

    left_value = run1_query_tree(lefttree, line, headers)

    # evaluate right tree

    # Pruning the Query Tree to minimize the operations
    if root == 'AND' and left_value == False:
        right_value = left_value
    elif root == 'OR' and left_value == True:
        right_value = left_value
    else:
        right_value = run1_query_tree(righttree, line, headers)

    return apply_logicalop(root, left_value, right_value)
