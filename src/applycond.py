import re
import sys


def get_type(op):
    '''
    Handles type conversion (all columns are read as strings)
    Supports conversion to int, float, string
    :param op: input is plain string
    :return: returns input with appropriate type conversion
    '''
    if op.isdecimal():
        return int(op)
    else:
        if re.match(r'\d+\.\d+', op):
            return float(op)
        else:
            return op
        # try:
        #     return float(op)
        # except:
        #     return op


def myeval(op, line, headers, data_type):
    '''
    Extracts the column value from the line, converts column value and constant into appropriate python types
    :param op: op can be column reference or constant
    :param line: line read from the input data file
    :return: column and constant converted into appropriate types
    '''
    fields = line.split(',')
    # if a column is referred by a number
    if op[1:].isdecimal():
        cvalue = fields[int(op[1:]) - 1]
        return type_conversion(cvalue, data_type)
    # if a column is referred by its name
    else:
        cvalue = fields[headers.index(op.upper())]
        return type_conversion(cvalue, data_type)


def type_conversion(val, data_type):
    if data_type in [int, float]:
        return float(val)
    elif data_type == str:
        return val
    else:
        print('Unrecognized data type')
        sys.exit(-1)


def apply_condition(condition, line, headers):
    '''
    Returns evaluation of a condition on a line from the input data file
    :param condition: condition to apply on the operands
    :param line: line read from the input data file
    :return: True or False
    '''
    if condition[0] == '':
        return False
    elif (condition[0] == '>'):
        return (myeval(condition[1], line, headers, type(condition[2])) > condition[2])
    elif (condition[0] == '<'):
        return (myeval(condition[1], line, headers, type(condition[2])) < condition[2])
    elif (condition[0] == '<='):
        return (myeval(condition[1], line, headers, type(condition[2])) <= condition[2])
    elif (condition[0] == '>='):
        return (myeval(condition[1], line, headers, type(condition[2])) >= condition[2])
    elif (condition[0] == '=='):
        return (myeval(condition[1], line, headers, type(condition[2])) == condition[2])
    elif (condition[0] == '!='):
        return (myeval(condition[1], line, headers, type(condition[2])) != condition[2])
    else:
        print("wrong or unallowed operator!")
        exit(-1)


def apply_logicalop(condition: str, op1, op2=False):
    '''
    Evaluates Logical Operation between two logical inputs
    :param condition:
    :param op1: Boolean
    :param op2: Optional Boolean
    :return: returns evaluation of op1,op2 as Boolean
    '''
    if condition.upper() == 'AND':
        return op1 and op2
    elif condition.upper() == "OR":
        return op1 or op2
    elif condition.upper() == 'NOT':
        return not (op1)
    else:
        print("invalid logical operator")
