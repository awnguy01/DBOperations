# SQL to Unix Pipeline Conversion Tool

## User Guide

### Purpose

This tool was designed to facilitate querying table file data in a Unix filesystem with SQL. This program accepts a simplified SQL `SELECT` query as user input and outputs a command pipeline that can be executed in any Unix-like terminal.

### Prerequisites 

To use this tool, you must have Python 3. By default, the program looks for `python3` in the directory `/usr/bin`, but the program can be explicitly run with any Python 3 install. 

### Running the Program

To run the program, navigate to the directory containing the data files. Invoke the program with `<SQL_HOME>/sql.py` where `<SQL_HOME>` is the absolute or relative path to the program directory. If your Python 3 is in a location other than `/usr/bin`, invoke the program with `<PYTHON_HOME>/python3 <SQL_HOME>/sql.py` where `<PYTHON_HOME>` is the Python 3 installation directory.


### Accepted File Formats

This program is intended for querying plaintext, table-like files with each line representing a single record and an optional header line. Each row must also be field-delimited. Accepted delimiters include 

- commas ","
- pipes "|"
- spaces " "
- tabs "&emsp;"

An example file structure would be 
```
Name,Age,Salary,
Jim John,38,85382
Mickey Donald,44,119283
RB,55,90382
```
### Input SQL Format

The input SQL must represent an SQL `SELECT` statement with no subqueries. The query must have at least a `SELECT` and a `FROM` clause. The accepted format is as follows:

```
SELECT <attribute>,...
FROM <file>...
WHERE <condition>
GROUP BY <attribute>...
ORDER BY <attribute>...
LIMIT <n>
```
- `<attribute>` can be a column name, field reference (# followed by a column number), or aggregation on one of the columns. Column names and field references can be preceded with a table name to resolve ambiguity.
- `<file>` can be any valid table file within the current working directory. File extensions are not included in the query (i.e. `EMPLOYEES` is accepted but `EMPLOYEES.csv` is not)
- `<condition>` can include any combination of unary (`-`), binary (`==`, `<`, `<=`, `>`, `>=`), and logical (`AND`, `OR`, `NOT`) operators. Conditions with subqueries are NOT accepted. 
- `<n>` is any non-decimal positive number. 0 is also allowed.

## Development/Testing Guide

### Prerequisites

- Python 3 https://www.python.org/
- Java 8 https://java.com/
- Antlr4 https://www.antlr.org/

### Compiling Grammar Files

This program uses `Antlr4` to generate lexers and parsers for SQL. To do this, Antlr4 compiles grammar files with the `.g4` extension into Python 3 modules that can be integrated called from the code. To modify the parsing logic, follow these steps:
- Install `Antlr4` following directions from the download site
- Add the path to your installation as an alias called `antlr4` in `~/.bash_profile`
- Make any desired modifications to the files `src/validators/antlr4/SQLiteLexer.g4` and `src/validators/antlr4/SQLiteParser.g4`
- Run the bash script `src/validators/antlr4/build_antlr4.sh`

### Testing

All tests are run using the `pytest` framework, which can be installed using `pip3 install pytest`. To execute the automated tests, run `pytest` from the project root.