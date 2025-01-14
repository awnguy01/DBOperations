import argparse
import sys
import re
import copy
from typing import List
from prettytable import PrettyTable
from sys import intern


def user_interface():
    resultlist = []
    parser = argparse.ArgumentParser(conflict_handler="resolve")
    parser.add_argument("-a", "--attributes", help="group by attributes")
    parser.add_argument("-f", "--function", help="aggregate functions")
    parser.add_argument("-i", "--input", help="input file")
    parser.add_argument("-o", "--output", help="output file")
    parser.add_argument("-h", "--header", default=False,
                        action="store_true", help="whether input file has header")
    parser.add_argument("-s", "--split", default=',', help="line separator")
    args = parser.parse_args()
    resultlist.append(args.attributes)
    resultlist.append(args.input)
    resultlist.append(args.output)
    resultlist.append(args.header)
    resultlist.append(args.split)
    resultlist.append(args.function)
    return resultlist


def column_offset_validation(arguments):
    """
This function is to validate the column offset and return user friendly errors
It also returns the line against which it performs the column reference validation
:param : arguments - args provided by the user to the program
:return: returns the first line of the input stream (file or stdin)
"""

    aggattrlist = []

    for func in arguments[5].split(','):
        aggattrlist.append(re.search(r'\((.*?)\)', func).group(1))

    groupingattributes = arguments[0].split(',')
    inputfile = arguments[1]
    header = inputfile.readline()
    splitter = '\t' if arguments[4] == '\\t' else arguments[4]
    attributesCount = len(header.split(splitter))
    # operands = arguments[0].split(',')
    operands = aggattrlist
    hasheader = arguments[3]
    if hasheader:
        for operand in operands:
            if operand.startswith('#'):
                # if you are here the column offset can be a integer or string
                if operand[1:].isdecimal():
                    data_error_handler(
                        operand, attributesCount, arguments, type="aggregation")
                else:
                    # This block of code is executed for float or string
                    if operand[1:] not in header.split(splitter):
                        print(operand[1:])
                        print(
                            f'aggregate column reference {operand} entered is incorrect')
                        free_resources(arguments)
                        sys.exit(-1)
            else:
                print(
                    f' {operand} aggregate column reference should start with "#"')
                free_resources(arguments)
                sys.exit(-1)

        for attr in groupingattributes:
            if attr.startswith('#'):
                if attr[1:].isdecimal():
                    data_error_handler(attr, attributesCount,
                                       arguments, type="grouping")
                else:
                    # This block of code is executed for float or string
                    if attr[1:] not in header.split(splitter):
                        print(
                            f'grouping column reference {attr} entered is incorrect')
                        free_resources(arguments)
                        sys.exit(-1)
            else:
                print(f' {attr} grouping column reference should start with "#"')
                free_resources(arguments)
                sys.exit(-1)

    else:
        # no header so setting the file pointer back to first line
        # if inputtype != None: (while going back is an option in files not for stdin)
        #    inputfile.seek(0)
        for operand in operands:
            if operand.startswith('#'):
                if operand[1:].isdecimal():
                    data_error_handler(
                        operand, attributesCount, arguments, type="aggregation")
                else:
                    print(
                        f'grouping column reference {operand} cannot be a string or float, perhaps you forgot to pass "-h" arg')
                    free_resources(arguments)
                    sys.exit(-1)
            else:
                print(
                    f' {operand} aggregate column reference should start with "#"')
                free_resources(arguments)
                sys.exit(-1)

        # print(groupingattributes)
        for attr in groupingattributes:
            if attr.startswith('#'):
                if attr[1:].isdecimal():
                    data_error_handler(attr, attributesCount,
                                       arguments, type="grouping")
                else:
                    # This block of code is executed for float or string
                    print(
                        f'aggregate column reference {operand} cannot be a string or float, perhaps you forgot to pass "-h" arg')
                    free_resources(arguments)
                    sys.exit(-1)
            else:
                print(f' {attr} grouping column reference should start with "#"')
                free_resources(arguments)
                sys.exit(-1)

    return header


def data_error_handler(data, attributesCount, arguments, type):
    """
Function performs validation of the input data
Checks if the data is string or integer
If the data is integer it further checks if it's contained within a range
:param data: data to validate for errors
:param attributesCount: number of columns in the input
:param arguments: args provided by the user to the program
:return: void
"""
    # if you are here that means the column offset should always be an integer

    if not data[1:].isdecimal():
        print(f'The column offset {data}  in {type} should be an integer')
        free_resources(arguments)
        sys.exit(-1)
    # the column offset should be between 0...(attributesCount - 1)
    if int(data[1:]) not in range(1, attributesCount + 1):
        print(
            f'The column offset {data} in {type} should be in the range (1, {attributesCount - 1}) ')
        free_resources(arguments)
        sys.exit(-1)


def free_resources(arguments):
    """
Function to close the input and output file or stdin/out references
:param arguments:
:return: void
"""
    arguments[1].close()
    arguments[2].close()


def set_input_output(arguments):
    '''
    function to set the input(file or stdin)and output(file or stdout) references
    :param arguments: args provided by the user to the program
    :return: arguments with output and input references updated
    '''
    if (arguments[1]):
        try:
            infile = open(arguments[1])
        except IOError:
            print('There was an error opening the input file!')
            exit(-1)
    else:
        infile = sys.stdin
    arguments[1] = infile
    if (arguments[2]):
        try:
            outfile = open(arguments[2], mode='w')
        except IOError:
            print('There was an error opening the output file!')
            exit(-1)
    else:
        outfile = sys.stdout
    arguments[2] = outfile
    return arguments


def myeval(op, line, arguments):
    '''
    Extracts the column value from the line, converts column value and constant into appropriate python types
    :param op: op can be column reference or constant
    :param line: line read from the input data file
    :return: column and constant converted into appropriate types
    '''
    splitter = '\t' if arguments[4] == '\\t' else arguments[4]
    fields = line.strip('\n').split(splitter)
    index = op[1:]
    # if a column is referred by a number
    if index.isdecimal():
        index = int(index)
        cvalue = fields[index - 1]
        # return get_type(cvalue)
        return type_conversion(cvalue)
    # if a column is referred by its name
    else:
        cvalue = fields[arguments[-1][index]]
        return type_conversion(cvalue)


def type_conversion(val):
    '''
    Function to convert the input string to int or float, if not either of them will throw an exception and exit
    :param val: value of type string
    :return: int or float,
    '''
    if val.isdecimal():
        return int(val)
    else:
        try:
            return float(val)
        except:
            print("Aggregations on string data type cannot be performed")
            sys.exit(-1)


def aggregate_func(aggfunc, line, args, attr, init):
    '''
    Function to perform simple aggregations conditionally
    :param aggfunc: is a list of aggregations user wants to apply on the input
    :param line: current line we are performing the aggregations on
    :param args: all the args user provided on command line
    :param attr: attribute that we are interested in the line
    :param init: an array to keep track of previous aggregations
    :return: aggregation result
    '''
    if aggfunc == 'sum':
        return myeval(attr, line, args) + init
    elif aggfunc == 'count':
        return init + 1
    elif aggfunc == 'avg':
        init[0] = init[0] + 1
        init[1] = myeval(attr, line, args) + init[1]
        init[2] = init[1] / init[0]
        return init
    elif aggfunc == 'min':
        val = myeval(attr, line, args)
        if init[1] and val > init[0]:
            return (init[0], True)
        return (val, True)
    elif aggfunc == 'max':
        val = myeval(attr, line, args)
        if init[1] and val < init[0]:
            return (init[0], True)
        return (val, True)
    else:
        print("Unsupported aggregate Operation")
        free_resources(args)
        sys.exit(-1)


def group_by_hash(args, firstline):
    '''
    Performing aggregations in groups using a dictionary
    :param args:
    :param firstline:
    :return: results
    '''
    attributes, input, output, hasheader, split, aggfunc = args
    split = '\t' if split == '\\t' else split
    aggfunclists = aggfunc.split(',')
    attrlist = [attr[1:] for attr in attributes.split(',')]

    aggattrlist = []
    aggfunclist = []

    for func in aggfunclists:
        aggattrlist.append(re.search(r'\((.*?)\)', func).group(1))
        aggfunclist.append(func.split('(')[0])

    # a dct to hold the aggregation values
    results = {}

    if hasheader:
        # This path is taken when the user passes header argument
        # cols holds the header name and its index in a dict for later use
        cols = {}
        for idx, col in enumerate(firstline.split(split)):
            cols[col.strip('\n')] = idx

        args.append(cols)

        for idx, attr in enumerate(attrlist):
            try:
                int(attr)
            except:
                attrlist[idx] = cols[attr] + 1

        # converting attrlist to hold integers only ahead of time
        attrlist = [int(attr) for attr in attrlist]
        # aggregating the rest of the lines in file or stdin reading line by line
        for line in input:
            datalist = line.split(split)
            groupingstring = "|".join([datalist[attr - 1]
                                      for attr in attrlist])

            if groupingstring in results:
                # Performing aggregations to an existing group
                for index in range(0, len(aggattrlist)):
                    results[groupingstring][index] = aggregate_func(aggfunclist[index], line, args, aggattrlist[index],
                                                                    results[groupingstring][index])

            else:
                # Performing aggregations to a new group
                results[groupingstring] = reset_init(aggfunclist, args)
                for index in range(0, len(aggattrlist)):
                    results[groupingstring][index] = aggregate_func(aggfunclist[index], line, args, aggattrlist[index],
                                                                    results[groupingstring][index])

    else:
        # attrlist to hold integers ahead of time
        attrlist = [int(attr) for attr in attrlist]
        # performing multiple aggregations on first line to ensure the results are accurate
        datalist = firstline.split(split)
        groupingstring = "|".join([datalist[attr - 1] for attr in attrlist])
        results[groupingstring] = reset_init(aggfunclist, args)

        for index in range(0, len(aggattrlist)):
            results[groupingstring][index] = aggregate_func(aggfunclist[index], firstline, args, aggattrlist[index],
                                                            results[groupingstring][index])
        # performing multiple aggregations per line and store the results in dict
        for line in input:
            datalist = line.split(split)
            groupingstring = "|".join([datalist[attr - 1]
                                      for attr in attrlist])

            if groupingstring in results:
                # Performing aggregations on an existing groupgroupingstring = intern(groupingstring)
                for index in range(0, len(aggattrlist)):
                    results[groupingstring][index] = aggregate_func(aggfunclist[index], line, args, aggattrlist[index],
                                                                    results[groupingstring][index])
            else:
                # Performing aggregations on a new group
                results[groupingstring] = reset_init(aggfunclist, args)
                for index in range(0, len(aggattrlist)):
                    results[groupingstring][index] = aggregate_func(aggfunclist[index], line, args, aggattrlist[index],
                                                                    results[groupingstring][index])

    return results


def reset_init(aggfunclist, args):
    '''
    Resetting the init
    :param aggfunclist: list of aggregate functions
    :param args:
    :return:
    '''
    init = []
    for aggfunc in aggfunclist:
        if aggfunc == 'sum' or aggfunc == 'count':
            init.append(0)
        elif aggfunc == 'min' or aggfunc == 'max':
            init.append((0, False))
        elif aggfunc == 'avg':
            init.append([0, 0, 0])
        else:
            print("Unsupported Aggregate function")
            free_resources(args)
            sys.exit(-1)
    return copy.deepcopy(init)


def pretty_print(results, args):
    '''
    This function is  to print the final results to std output
    This is an expensive operation in terms of memory usage that we are temporarily relying on
    :param results:
    :param args:
    :return: void
    '''
    if args[3]:
        attributes, input, output, hasheader, split, aggfunc, _ = args
    else:
        attributes, input, output, hasheader, split, aggfunc = args

    aggfunclists = aggfunc.split(',')
    aggattrlist = []
    aggfunclist = []

    for func in aggfunclists:
        aggattrlist.append(re.search(r'\((.*?)\)', func).group(1))
        aggfunclist.append(func.split('(')[0])

    aggfunclists.insert(0, 'GroupBy')
    t = PrettyTable(aggfunclists)
    for k, v in results.items():
        drow = []
        drow.append(k)
        for idx, value in enumerate(v):
            if aggfunclist[idx] == 'sum' or aggfunclist[idx] == 'count':
                drow.append(value)
            elif aggfunclist[idx] == 'min' or aggfunclist[idx] == 'max':
                drow.append(value[0])
            elif aggfunclist[idx] == 'avg':
                drow.append(value[2])
        t.add_row(drow)
    print(t)


def normal_print(results, args):
    out = args[2]
    aggs = args[5]

    aggfunclists = aggs.split(',')
    aggattrlist = []
    aggfunclist = []

    for func in aggfunclists:
        aggattrlist.append(re.search(r'\((.*?)\)', func).group(1))
        aggfunclist.append(func.split('(')[0])

    aggfunclists.insert(0, 'GroupBy')

    out.write(f'{",".join(aggfunclists)}\n')

    for k, v in results.items():
        row: List[str] = [k]
        for idx, value in enumerate(v):
            if aggfunclist[idx] == 'sum' or aggfunclist[idx] == 'count':
                row.append(str(round(value, 9)))
            elif aggfunclist[idx] == 'min' or aggfunclist[idx] == 'max':
                row.append(str(round(value[0], 9)))
            elif aggfunclist[idx] == 'avg':
                row.append(str(round(value[2], 9)))
        out.write(f'{",".join(row)}\n')

def main():
    args = user_interface()
    args = set_input_output(args)
    firstline = column_offset_validation(args)
    results = group_by_hash(args, firstline)

    # pretty_print(results, args)
    normal_print(results, args)


main()
