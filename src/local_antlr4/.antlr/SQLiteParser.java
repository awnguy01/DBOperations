// Generated from /media/andrew/Shared/UofL_Spring_2021/CSE Project/DBOperations/src/antlr4/SQLiteParser.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLiteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SCOL=1, DOT=2, OPEN_PAR=3, CLOSE_PAR=4, COMMA=5, ASSIGN=6, STAR=7, HASH=8, 
		PLUS=9, MINUS=10, TILDE=11, PIPE2=12, DIV=13, MOD=14, LT2=15, GT2=16, 
		AMP=17, PIPE=18, LT=19, LT_EQ=20, GT=21, GT_EQ=22, EQ=23, NOT_EQ1=24, 
		NOT_EQ2=25, ABORT=26, ACTION=27, ADD=28, AFTER=29, ALL=30, ALTER=31, ANALYZE=32, 
		AND=33, AS=34, ASC=35, ATTACH=36, AUTOINCREMENT=37, BEFORE=38, BEGIN=39, 
		BETWEEN=40, BY=41, CASCADE=42, CASE=43, CAST=44, CHECK=45, COLLATE=46, 
		COLUMN=47, COMMIT=48, CONFLICT=49, CONSTRAINT=50, CREATE=51, CROSS=52, 
		CURRENT_DATE=53, CURRENT_TIME=54, CURRENT_TIMESTAMP=55, DATABASE=56, DEFAULT=57, 
		DEFERRABLE=58, DEFERRED=59, DELETE=60, DESC=61, DETACH=62, DISTINCT=63, 
		DROP=64, EACH=65, ELSE=66, END=67, ESCAPE=68, EXCEPT=69, EXCLUSIVE=70, 
		EXISTS=71, EXPLAIN=72, FAIL=73, FOR=74, FOREIGN=75, FROM=76, FULL=77, 
		GLOB=78, GROUP=79, HAVING=80, IF=81, IGNORE=82, IMMEDIATE=83, IN=84, INDEX=85, 
		INDEXED=86, INITIALLY=87, INNER=88, INSERT=89, INSTEAD=90, INTERSECT=91, 
		INTO=92, IS=93, ISNULL=94, JOIN=95, KEY=96, LEFT=97, LIKE=98, LIMIT=99, 
		MATCH=100, NATURAL=101, NO=102, NOT=103, NOTNULL=104, NULL_=105, OF=106, 
		OFFSET=107, ON=108, OR=109, ORDER=110, OUTER=111, PLAN=112, PRAGMA=113, 
		PRIMARY=114, QUERY=115, RAISE=116, RECURSIVE=117, REFERENCES=118, REGEXP=119, 
		REINDEX=120, RELEASE=121, RENAME=122, REPLACE=123, RESTRICT=124, RIGHT=125, 
		ROLLBACK=126, ROW=127, ROWS=128, SAVEPOINT=129, SELECT=130, SET=131, TABLE=132, 
		TEMP=133, TEMPORARY=134, THEN=135, TO=136, TRANSACTION=137, TRIGGER=138, 
		UNION=139, UNIQUE=140, UPDATE=141, USING=142, VACUUM=143, VALUES=144, 
		VIEW=145, VIRTUAL=146, WHEN=147, WHERE=148, WITH=149, WITHOUT=150, FIRST_VALUE=151, 
		OVER=152, PARTITION=153, RANGE=154, PRECEDING=155, UNBOUNDED=156, CURRENT=157, 
		FOLLOWING=158, CUME_DIST=159, DENSE_RANK=160, LAG=161, LAST_VALUE=162, 
		LEAD=163, NTH_VALUE=164, NTILE=165, PERCENT_RANK=166, RANK=167, ROW_NUMBER=168, 
		GENERATED=169, ALWAYS=170, STORED=171, TRUE_=172, FALSE_=173, WINDOW=174, 
		NULLS=175, FIRST=176, LAST=177, FILTER=178, GROUPS=179, EXCLUDE=180, TIES=181, 
		OTHERS=182, DO=183, NOTHING=184, IDENTIFIER=185, NUMERIC_LITERAL=186, 
		REF_FIELD=187, BIND_PARAMETER=188, STRING_LITERAL=189, BLOB_LITERAL=190, 
		SINGLE_LINE_COMMENT=191, MULTILINE_COMMENT=192, SPACES=193, UNEXPECTED_CHAR=194;
	public static final int
		RULE_parse = 0, RULE_error = 1, RULE_sql_stmt_list = 2, RULE_sql_stmt = 3, 
		RULE_alter_table_stmt = 4, RULE_analyze_stmt = 5, RULE_attach_stmt = 6, 
		RULE_begin_stmt = 7, RULE_commit_stmt = 8, RULE_rollback_stmt = 9, RULE_savepoint_stmt = 10, 
		RULE_release_stmt = 11, RULE_create_index_stmt = 12, RULE_indexed_column = 13, 
		RULE_create_table_stmt = 14, RULE_column_def = 15, RULE_type_name = 16, 
		RULE_column_constraint = 17, RULE_signed_number = 18, RULE_table_constraint = 19, 
		RULE_foreign_key_clause = 20, RULE_conflict_clause = 21, RULE_create_trigger_stmt = 22, 
		RULE_create_view_stmt = 23, RULE_create_virtual_table_stmt = 24, RULE_with_clause = 25, 
		RULE_cte_table_name = 26, RULE_recursive_cte = 27, RULE_common_table_expression = 28, 
		RULE_delete_stmt = 29, RULE_delete_stmt_limited = 30, RULE_detach_stmt = 31, 
		RULE_drop_stmt = 32, RULE_expr = 33, RULE_raise_function = 34, RULE_literal_value = 35, 
		RULE_insert_stmt = 36, RULE_upsert_clause = 37, RULE_pragma_stmt = 38, 
		RULE_pragma_value = 39, RULE_reindex_stmt = 40, RULE_select_stmt = 41, 
		RULE_join_clause = 42, RULE_select_core = 43, RULE_where_clause = 44, 
		RULE_group_by_clause = 45, RULE_having_clause = 46, RULE_factored_select_stmt = 47, 
		RULE_simple_select_stmt = 48, RULE_compound_select_stmt = 49, RULE_table_or_subquery = 50, 
		RULE_result_column = 51, RULE_join_operator = 52, RULE_join_constraint = 53, 
		RULE_compound_operator = 54, RULE_update_stmt = 55, RULE_column_name_list = 56, 
		RULE_update_stmt_limited = 57, RULE_qualified_table_name = 58, RULE_vacuum_stmt = 59, 
		RULE_filter_clause = 60, RULE_window_defn = 61, RULE_over_clause = 62, 
		RULE_frame_spec = 63, RULE_frame_clause = 64, RULE_simple_function_invocation = 65, 
		RULE_aggregate_function_invocation = 66, RULE_window_function_invocation = 67, 
		RULE_common_table_stmt = 68, RULE_order_by_stmt = 69, RULE_limit_stmt = 70, 
		RULE_ordering_term = 71, RULE_asc_desc = 72, RULE_frame_left = 73, RULE_frame_right = 74, 
		RULE_frame_single = 75, RULE_window_function = 76, RULE_offset = 77, RULE_default_value = 78, 
		RULE_partition_by = 79, RULE_order_by_expr = 80, RULE_order_by_expr_asc_desc = 81, 
		RULE_expr_asc_desc = 82, RULE_initial_select = 83, RULE_recursive_select = 84, 
		RULE_unary_operator = 85, RULE_error_message = 86, RULE_module_argument = 87, 
		RULE_column_alias = 88, RULE_keyword = 89, RULE_name = 90, RULE_function_name = 91, 
		RULE_schema_name = 92, RULE_table_name = 93, RULE_table_or_index_name = 94, 
		RULE_new_table_name = 95, RULE_column_name = 96, RULE_collation_name = 97, 
		RULE_foreign_table = 98, RULE_index_name = 99, RULE_trigger_name = 100, 
		RULE_view_name = 101, RULE_module_name = 102, RULE_pragma_name = 103, 
		RULE_savepoint_name = 104, RULE_table_alias = 105, RULE_transaction_name = 106, 
		RULE_window_name = 107, RULE_alias = 108, RULE_filename = 109, RULE_base_window_name = 110, 
		RULE_simple_func = 111, RULE_aggregate_func = 112, RULE_table_function_name = 113, 
		RULE_any_name = 114;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "error", "sql_stmt_list", "sql_stmt", "alter_table_stmt", "analyze_stmt", 
			"attach_stmt", "begin_stmt", "commit_stmt", "rollback_stmt", "savepoint_stmt", 
			"release_stmt", "create_index_stmt", "indexed_column", "create_table_stmt", 
			"column_def", "type_name", "column_constraint", "signed_number", "table_constraint", 
			"foreign_key_clause", "conflict_clause", "create_trigger_stmt", "create_view_stmt", 
			"create_virtual_table_stmt", "with_clause", "cte_table_name", "recursive_cte", 
			"common_table_expression", "delete_stmt", "delete_stmt_limited", "detach_stmt", 
			"drop_stmt", "expr", "raise_function", "literal_value", "insert_stmt", 
			"upsert_clause", "pragma_stmt", "pragma_value", "reindex_stmt", "select_stmt", 
			"join_clause", "select_core", "where_clause", "group_by_clause", "having_clause", 
			"factored_select_stmt", "simple_select_stmt", "compound_select_stmt", 
			"table_or_subquery", "result_column", "join_operator", "join_constraint", 
			"compound_operator", "update_stmt", "column_name_list", "update_stmt_limited", 
			"qualified_table_name", "vacuum_stmt", "filter_clause", "window_defn", 
			"over_clause", "frame_spec", "frame_clause", "simple_function_invocation", 
			"aggregate_function_invocation", "window_function_invocation", "common_table_stmt", 
			"order_by_stmt", "limit_stmt", "ordering_term", "asc_desc", "frame_left", 
			"frame_right", "frame_single", "window_function", "offset", "default_value", 
			"partition_by", "order_by_expr", "order_by_expr_asc_desc", "expr_asc_desc", 
			"initial_select", "recursive_select", "unary_operator", "error_message", 
			"module_argument", "column_alias", "keyword", "name", "function_name", 
			"schema_name", "table_name", "table_or_index_name", "new_table_name", 
			"column_name", "collation_name", "foreign_table", "index_name", "trigger_name", 
			"view_name", "module_name", "pragma_name", "savepoint_name", "table_alias", 
			"transaction_name", "window_name", "alias", "filename", "base_window_name", 
			"simple_func", "aggregate_func", "table_function_name", "any_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "'('", "')'", "','", "'='", "'*'", "'#'", "'+'", 
			"'-'", "'~'", "'||'", "'/'", "'%'", "'<<'", "'>>'", "'&'", "'|'", "'<'", 
			"'<='", "'>'", "'>='", "'=='", "'!='", "'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SCOL", "DOT", "OPEN_PAR", "CLOSE_PAR", "COMMA", "ASSIGN", "STAR", 
			"HASH", "PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT2", "GT2", 
			"AMP", "PIPE", "LT", "LT_EQ", "GT", "GT_EQ", "EQ", "NOT_EQ1", "NOT_EQ2", 
			"ABORT", "ACTION", "ADD", "AFTER", "ALL", "ALTER", "ANALYZE", "AND", 
			"AS", "ASC", "ATTACH", "AUTOINCREMENT", "BEFORE", "BEGIN", "BETWEEN", 
			"BY", "CASCADE", "CASE", "CAST", "CHECK", "COLLATE", "COLUMN", "COMMIT", 
			"CONFLICT", "CONSTRAINT", "CREATE", "CROSS", "CURRENT_DATE", "CURRENT_TIME", 
			"CURRENT_TIMESTAMP", "DATABASE", "DEFAULT", "DEFERRABLE", "DEFERRED", 
			"DELETE", "DESC", "DETACH", "DISTINCT", "DROP", "EACH", "ELSE", "END", 
			"ESCAPE", "EXCEPT", "EXCLUSIVE", "EXISTS", "EXPLAIN", "FAIL", "FOR", 
			"FOREIGN", "FROM", "FULL", "GLOB", "GROUP", "HAVING", "IF", "IGNORE", 
			"IMMEDIATE", "IN", "INDEX", "INDEXED", "INITIALLY", "INNER", "INSERT", 
			"INSTEAD", "INTERSECT", "INTO", "IS", "ISNULL", "JOIN", "KEY", "LEFT", 
			"LIKE", "LIMIT", "MATCH", "NATURAL", "NO", "NOT", "NOTNULL", "NULL_", 
			"OF", "OFFSET", "ON", "OR", "ORDER", "OUTER", "PLAN", "PRAGMA", "PRIMARY", 
			"QUERY", "RAISE", "RECURSIVE", "REFERENCES", "REGEXP", "REINDEX", "RELEASE", 
			"RENAME", "REPLACE", "RESTRICT", "RIGHT", "ROLLBACK", "ROW", "ROWS", 
			"SAVEPOINT", "SELECT", "SET", "TABLE", "TEMP", "TEMPORARY", "THEN", "TO", 
			"TRANSACTION", "TRIGGER", "UNION", "UNIQUE", "UPDATE", "USING", "VACUUM", 
			"VALUES", "VIEW", "VIRTUAL", "WHEN", "WHERE", "WITH", "WITHOUT", "FIRST_VALUE", 
			"OVER", "PARTITION", "RANGE", "PRECEDING", "UNBOUNDED", "CURRENT", "FOLLOWING", 
			"CUME_DIST", "DENSE_RANK", "LAG", "LAST_VALUE", "LEAD", "NTH_VALUE", 
			"NTILE", "PERCENT_RANK", "RANK", "ROW_NUMBER", "GENERATED", "ALWAYS", 
			"STORED", "TRUE_", "FALSE_", "WINDOW", "NULLS", "FIRST", "LAST", "FILTER", 
			"GROUPS", "EXCLUDE", "TIES", "OTHERS", "DO", "NOTHING", "IDENTIFIER", 
			"NUMERIC_LITERAL", "REF_FIELD", "BIND_PARAMETER", "STRING_LITERAL", "BLOB_LITERAL", 
			"SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", "UNEXPECTED_CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SQLiteParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLiteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SQLiteParser.EOF, 0); }
		public List<Sql_stmt_listContext> sql_stmt_list() {
			return getRuleContexts(Sql_stmt_listContext.class);
		}
		public Sql_stmt_listContext sql_stmt_list(int i) {
			return getRuleContext(Sql_stmt_listContext.class,i);
		}
		public List<ErrorContext> error() {
			return getRuleContexts(ErrorContext.class);
		}
		public ErrorContext error(int i) {
			return getRuleContext(ErrorContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (SCOL - 1)) | (1L << (ALTER - 1)) | (1L << (ANALYZE - 1)) | (1L << (ATTACH - 1)) | (1L << (BEGIN - 1)) | (1L << (COMMIT - 1)) | (1L << (CREATE - 1)) | (1L << (DEFAULT - 1)) | (1L << (DELETE - 1)) | (1L << (DETACH - 1)) | (1L << (DROP - 1)))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (END - 67)) | (1L << (EXPLAIN - 67)) | (1L << (INSERT - 67)) | (1L << (PRAGMA - 67)) | (1L << (REINDEX - 67)) | (1L << (RELEASE - 67)) | (1L << (REPLACE - 67)) | (1L << (ROLLBACK - 67)) | (1L << (SAVEPOINT - 67)) | (1L << (SELECT - 67)))) != 0) || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (UPDATE - 141)) | (1L << (VACUUM - 141)) | (1L << (VALUES - 141)) | (1L << (WITH - 141)) | (1L << (UNEXPECTED_CHAR - 141)))) != 0)) {
				{
				setState(232);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SCOL:
				case ALTER:
				case ANALYZE:
				case ATTACH:
				case BEGIN:
				case COMMIT:
				case CREATE:
				case DEFAULT:
				case DELETE:
				case DETACH:
				case DROP:
				case END:
				case EXPLAIN:
				case INSERT:
				case PRAGMA:
				case REINDEX:
				case RELEASE:
				case REPLACE:
				case ROLLBACK:
				case SAVEPOINT:
				case SELECT:
				case UPDATE:
				case VACUUM:
				case VALUES:
				case WITH:
					{
					setState(230);
					sql_stmt_list();
					}
					break;
				case UNEXPECTED_CHAR:
					{
					setState(231);
					error();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(237);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ErrorContext extends ParserRuleContext {
		public TerminalNode UNEXPECTED_CHAR() { return getToken(SQLiteParser.UNEXPECTED_CHAR, 0); }
		public ErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error; }
	}

	public final ErrorContext error() throws RecognitionException {
		ErrorContext _localctx = new ErrorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_error);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(UNEXPECTED_CHAR);
			 
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_stmt_listContext extends ParserRuleContext {
		public List<Sql_stmtContext> sql_stmt() {
			return getRuleContexts(Sql_stmtContext.class);
		}
		public Sql_stmtContext sql_stmt(int i) {
			return getRuleContext(Sql_stmtContext.class,i);
		}
		public List<TerminalNode> SCOL() { return getTokens(SQLiteParser.SCOL); }
		public TerminalNode SCOL(int i) {
			return getToken(SQLiteParser.SCOL, i);
		}
		public Sql_stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt_list; }
	}

	public final Sql_stmt_listContext sql_stmt_list() throws RecognitionException {
		Sql_stmt_listContext _localctx = new Sql_stmt_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sql_stmt_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SCOL) {
				{
				{
				setState(242);
				match(SCOL);
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
			sql_stmt();
			setState(257);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(250); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(249);
						match(SCOL);
						}
						}
						setState(252); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SCOL );
					setState(254);
					sql_stmt();
					}
					} 
				}
				setState(259);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(263);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(260);
					match(SCOL);
					}
					} 
				}
				setState(265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_stmtContext extends ParserRuleContext {
		public Alter_table_stmtContext alter_table_stmt() {
			return getRuleContext(Alter_table_stmtContext.class,0);
		}
		public Analyze_stmtContext analyze_stmt() {
			return getRuleContext(Analyze_stmtContext.class,0);
		}
		public Attach_stmtContext attach_stmt() {
			return getRuleContext(Attach_stmtContext.class,0);
		}
		public Begin_stmtContext begin_stmt() {
			return getRuleContext(Begin_stmtContext.class,0);
		}
		public Commit_stmtContext commit_stmt() {
			return getRuleContext(Commit_stmtContext.class,0);
		}
		public Create_index_stmtContext create_index_stmt() {
			return getRuleContext(Create_index_stmtContext.class,0);
		}
		public Create_table_stmtContext create_table_stmt() {
			return getRuleContext(Create_table_stmtContext.class,0);
		}
		public Create_trigger_stmtContext create_trigger_stmt() {
			return getRuleContext(Create_trigger_stmtContext.class,0);
		}
		public Create_view_stmtContext create_view_stmt() {
			return getRuleContext(Create_view_stmtContext.class,0);
		}
		public Create_virtual_table_stmtContext create_virtual_table_stmt() {
			return getRuleContext(Create_virtual_table_stmtContext.class,0);
		}
		public Delete_stmtContext delete_stmt() {
			return getRuleContext(Delete_stmtContext.class,0);
		}
		public Delete_stmt_limitedContext delete_stmt_limited() {
			return getRuleContext(Delete_stmt_limitedContext.class,0);
		}
		public Detach_stmtContext detach_stmt() {
			return getRuleContext(Detach_stmtContext.class,0);
		}
		public Drop_stmtContext drop_stmt() {
			return getRuleContext(Drop_stmtContext.class,0);
		}
		public Insert_stmtContext insert_stmt() {
			return getRuleContext(Insert_stmtContext.class,0);
		}
		public Pragma_stmtContext pragma_stmt() {
			return getRuleContext(Pragma_stmtContext.class,0);
		}
		public Reindex_stmtContext reindex_stmt() {
			return getRuleContext(Reindex_stmtContext.class,0);
		}
		public Release_stmtContext release_stmt() {
			return getRuleContext(Release_stmtContext.class,0);
		}
		public Rollback_stmtContext rollback_stmt() {
			return getRuleContext(Rollback_stmtContext.class,0);
		}
		public Savepoint_stmtContext savepoint_stmt() {
			return getRuleContext(Savepoint_stmtContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Update_stmtContext update_stmt() {
			return getRuleContext(Update_stmtContext.class,0);
		}
		public Update_stmt_limitedContext update_stmt_limited() {
			return getRuleContext(Update_stmt_limitedContext.class,0);
		}
		public Vacuum_stmtContext vacuum_stmt() {
			return getRuleContext(Vacuum_stmtContext.class,0);
		}
		public TerminalNode EXPLAIN() { return getToken(SQLiteParser.EXPLAIN, 0); }
		public TerminalNode QUERY() { return getToken(SQLiteParser.QUERY, 0); }
		public TerminalNode PLAN() { return getToken(SQLiteParser.PLAN, 0); }
		public Sql_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt; }
	}

	public final Sql_stmtContext sql_stmt() throws RecognitionException {
		Sql_stmtContext _localctx = new Sql_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sql_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPLAIN) {
				{
				setState(266);
				match(EXPLAIN);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUERY) {
					{
					setState(267);
					match(QUERY);
					setState(268);
					match(PLAN);
					}
				}

				}
			}

			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(273);
				alter_table_stmt();
				}
				break;
			case 2:
				{
				setState(274);
				analyze_stmt();
				}
				break;
			case 3:
				{
				setState(275);
				attach_stmt();
				}
				break;
			case 4:
				{
				setState(276);
				begin_stmt();
				}
				break;
			case 5:
				{
				setState(277);
				commit_stmt();
				}
				break;
			case 6:
				{
				setState(278);
				create_index_stmt();
				}
				break;
			case 7:
				{
				setState(279);
				create_table_stmt();
				}
				break;
			case 8:
				{
				setState(280);
				create_trigger_stmt();
				}
				break;
			case 9:
				{
				setState(281);
				create_view_stmt();
				}
				break;
			case 10:
				{
				setState(282);
				create_virtual_table_stmt();
				}
				break;
			case 11:
				{
				setState(283);
				delete_stmt();
				}
				break;
			case 12:
				{
				setState(284);
				delete_stmt_limited();
				}
				break;
			case 13:
				{
				setState(285);
				detach_stmt();
				}
				break;
			case 14:
				{
				setState(286);
				drop_stmt();
				}
				break;
			case 15:
				{
				setState(287);
				insert_stmt();
				}
				break;
			case 16:
				{
				setState(288);
				pragma_stmt();
				}
				break;
			case 17:
				{
				setState(289);
				reindex_stmt();
				}
				break;
			case 18:
				{
				setState(290);
				release_stmt();
				}
				break;
			case 19:
				{
				setState(291);
				rollback_stmt();
				}
				break;
			case 20:
				{
				setState(292);
				savepoint_stmt();
				}
				break;
			case 21:
				{
				setState(293);
				select_stmt();
				}
				break;
			case 22:
				{
				setState(294);
				update_stmt();
				}
				break;
			case 23:
				{
				setState(295);
				update_stmt_limited();
				}
				break;
			case 24:
				{
				setState(296);
				vacuum_stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_table_stmtContext extends ParserRuleContext {
		public Column_nameContext old_column_name;
		public Column_nameContext new_column_name;
		public TerminalNode ALTER() { return getToken(SQLiteParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SQLiteParser.TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode RENAME() { return getToken(SQLiteParser.RENAME, 0); }
		public TerminalNode ADD() { return getToken(SQLiteParser.ADD, 0); }
		public Column_defContext column_def() {
			return getRuleContext(Column_defContext.class,0);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode COLUMN() { return getToken(SQLiteParser.COLUMN, 0); }
		public TerminalNode TO() { return getToken(SQLiteParser.TO, 0); }
		public New_table_nameContext new_table_name() {
			return getRuleContext(New_table_nameContext.class,0);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Alter_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_table_stmt; }
	}

	public final Alter_table_stmtContext alter_table_stmt() throws RecognitionException {
		Alter_table_stmtContext _localctx = new Alter_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_alter_table_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(ALTER);
			setState(300);
			match(TABLE);
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(301);
				schema_name();
				setState(302);
				match(DOT);
				}
				break;
			}
			setState(306);
			table_name();
			setState(324);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RENAME:
				{
				setState(307);
				match(RENAME);
				setState(317);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					{
					setState(308);
					match(TO);
					setState(309);
					new_table_name();
					}
					}
					break;
				case 2:
					{
					{
					setState(311);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						setState(310);
						match(COLUMN);
						}
						break;
					}
					setState(313);
					((Alter_table_stmtContext)_localctx).old_column_name = column_name();
					setState(314);
					match(TO);
					setState(315);
					((Alter_table_stmtContext)_localctx).new_column_name = column_name();
					}
					}
					break;
				}
				}
				break;
			case ADD:
				{
				setState(319);
				match(ADD);
				setState(321);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(320);
					match(COLUMN);
					}
					break;
				}
				setState(323);
				column_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Analyze_stmtContext extends ParserRuleContext {
		public TerminalNode ANALYZE() { return getToken(SQLiteParser.ANALYZE, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public Table_or_index_nameContext table_or_index_name() {
			return getRuleContext(Table_or_index_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Analyze_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_analyze_stmt; }
	}

	public final Analyze_stmtContext analyze_stmt() throws RecognitionException {
		Analyze_stmtContext _localctx = new Analyze_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_analyze_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(ANALYZE);
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(327);
				schema_name();
				}
				break;
			case 2:
				{
				setState(331);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(328);
					schema_name();
					setState(329);
					match(DOT);
					}
					break;
				}
				setState(333);
				table_or_index_name();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attach_stmtContext extends ParserRuleContext {
		public TerminalNode ATTACH() { return getToken(SQLiteParser.ATTACH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLiteParser.AS, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DATABASE() { return getToken(SQLiteParser.DATABASE, 0); }
		public Attach_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attach_stmt; }
	}

	public final Attach_stmtContext attach_stmt() throws RecognitionException {
		Attach_stmtContext _localctx = new Attach_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attach_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(ATTACH);
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(337);
				match(DATABASE);
				}
				break;
			}
			setState(340);
			expr(0);
			setState(341);
			match(AS);
			setState(342);
			schema_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Begin_stmtContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(SQLiteParser.BEGIN, 0); }
		public TerminalNode TRANSACTION() { return getToken(SQLiteParser.TRANSACTION, 0); }
		public TerminalNode DEFERRED() { return getToken(SQLiteParser.DEFERRED, 0); }
		public TerminalNode IMMEDIATE() { return getToken(SQLiteParser.IMMEDIATE, 0); }
		public TerminalNode EXCLUSIVE() { return getToken(SQLiteParser.EXCLUSIVE, 0); }
		public Transaction_nameContext transaction_name() {
			return getRuleContext(Transaction_nameContext.class,0);
		}
		public Begin_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begin_stmt; }
	}

	public final Begin_stmtContext begin_stmt() throws RecognitionException {
		Begin_stmtContext _localctx = new Begin_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_begin_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(BEGIN);
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (DEFERRED - 59)) | (1L << (EXCLUSIVE - 59)) | (1L << (IMMEDIATE - 59)))) != 0)) {
				{
				setState(345);
				_la = _input.LA(1);
				if ( !(((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (DEFERRED - 59)) | (1L << (EXCLUSIVE - 59)) | (1L << (IMMEDIATE - 59)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRANSACTION) {
				{
				setState(348);
				match(TRANSACTION);
				setState(350);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(349);
					transaction_name();
					}
					break;
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Commit_stmtContext extends ParserRuleContext {
		public TerminalNode COMMIT() { return getToken(SQLiteParser.COMMIT, 0); }
		public TerminalNode END() { return getToken(SQLiteParser.END, 0); }
		public TerminalNode TRANSACTION() { return getToken(SQLiteParser.TRANSACTION, 0); }
		public Commit_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commit_stmt; }
	}

	public final Commit_stmtContext commit_stmt() throws RecognitionException {
		Commit_stmtContext _localctx = new Commit_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_commit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			_la = _input.LA(1);
			if ( !(_la==COMMIT || _la==END) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRANSACTION) {
				{
				setState(355);
				match(TRANSACTION);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rollback_stmtContext extends ParserRuleContext {
		public TerminalNode ROLLBACK() { return getToken(SQLiteParser.ROLLBACK, 0); }
		public TerminalNode TRANSACTION() { return getToken(SQLiteParser.TRANSACTION, 0); }
		public TerminalNode TO() { return getToken(SQLiteParser.TO, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public TerminalNode SAVEPOINT() { return getToken(SQLiteParser.SAVEPOINT, 0); }
		public Rollback_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rollback_stmt; }
	}

	public final Rollback_stmtContext rollback_stmt() throws RecognitionException {
		Rollback_stmtContext _localctx = new Rollback_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rollback_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(ROLLBACK);
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRANSACTION) {
				{
				setState(359);
				match(TRANSACTION);
				}
			}

			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(362);
				match(TO);
				setState(364);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(363);
					match(SAVEPOINT);
					}
					break;
				}
				setState(366);
				savepoint_name();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Savepoint_stmtContext extends ParserRuleContext {
		public TerminalNode SAVEPOINT() { return getToken(SQLiteParser.SAVEPOINT, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public Savepoint_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_savepoint_stmt; }
	}

	public final Savepoint_stmtContext savepoint_stmt() throws RecognitionException {
		Savepoint_stmtContext _localctx = new Savepoint_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_savepoint_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(SAVEPOINT);
			setState(370);
			savepoint_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Release_stmtContext extends ParserRuleContext {
		public TerminalNode RELEASE() { return getToken(SQLiteParser.RELEASE, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public TerminalNode SAVEPOINT() { return getToken(SQLiteParser.SAVEPOINT, 0); }
		public Release_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_release_stmt; }
	}

	public final Release_stmtContext release_stmt() throws RecognitionException {
		Release_stmtContext _localctx = new Release_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_release_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(RELEASE);
			setState(374);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(373);
				match(SAVEPOINT);
				}
				break;
			}
			setState(376);
			savepoint_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_index_stmtContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SQLiteParser.CREATE, 0); }
		public TerminalNode INDEX() { return getToken(SQLiteParser.INDEX, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode ON() { return getToken(SQLiteParser.ON, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Indexed_columnContext> indexed_column() {
			return getRuleContexts(Indexed_columnContext.class);
		}
		public Indexed_columnContext indexed_column(int i) {
			return getRuleContext(Indexed_columnContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode UNIQUE() { return getToken(SQLiteParser.UNIQUE, 0); }
		public TerminalNode IF() { return getToken(SQLiteParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SQLiteParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SQLiteParser.EXISTS, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode WHERE() { return getToken(SQLiteParser.WHERE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Create_index_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_index_stmt; }
	}

	public final Create_index_stmtContext create_index_stmt() throws RecognitionException {
		Create_index_stmtContext _localctx = new Create_index_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_create_index_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(CREATE);
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(379);
				match(UNIQUE);
				}
			}

			setState(382);
			match(INDEX);
			setState(386);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(383);
				match(IF);
				setState(384);
				match(NOT);
				setState(385);
				match(EXISTS);
				}
				break;
			}
			setState(391);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(388);
				schema_name();
				setState(389);
				match(DOT);
				}
				break;
			}
			setState(393);
			index_name();
			setState(394);
			match(ON);
			setState(395);
			table_name();
			setState(396);
			match(OPEN_PAR);
			setState(397);
			indexed_column();
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(398);
				match(COMMA);
				setState(399);
				indexed_column();
				}
				}
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(405);
			match(CLOSE_PAR);
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(406);
				match(WHERE);
				setState(407);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Indexed_columnContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLLATE() { return getToken(SQLiteParser.COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Asc_descContext asc_desc() {
			return getRuleContext(Asc_descContext.class,0);
		}
		public Indexed_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexed_column; }
	}

	public final Indexed_columnContext indexed_column() throws RecognitionException {
		Indexed_columnContext _localctx = new Indexed_columnContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_indexed_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(410);
				column_name();
				}
				break;
			case 2:
				{
				setState(411);
				expr(0);
				}
				break;
			}
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLLATE) {
				{
				setState(414);
				match(COLLATE);
				setState(415);
				collation_name();
				}
			}

			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(418);
				asc_desc();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_table_stmtContext extends ParserRuleContext {
		public Token rowID;
		public TerminalNode CREATE() { return getToken(SQLiteParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SQLiteParser.TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode IF() { return getToken(SQLiteParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SQLiteParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SQLiteParser.EXISTS, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode TEMP() { return getToken(SQLiteParser.TEMP, 0); }
		public TerminalNode TEMPORARY() { return getToken(SQLiteParser.TEMPORARY, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_defContext> column_def() {
			return getRuleContexts(Column_defContext.class);
		}
		public Column_defContext column_def(int i) {
			return getRuleContext(Column_defContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode AS() { return getToken(SQLiteParser.AS, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public List<Table_constraintContext> table_constraint() {
			return getRuleContexts(Table_constraintContext.class);
		}
		public Table_constraintContext table_constraint(int i) {
			return getRuleContext(Table_constraintContext.class,i);
		}
		public TerminalNode WITHOUT() { return getToken(SQLiteParser.WITHOUT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SQLiteParser.IDENTIFIER, 0); }
		public Create_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_table_stmt; }
	}

	public final Create_table_stmtContext create_table_stmt() throws RecognitionException {
		Create_table_stmtContext _localctx = new Create_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_create_table_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(CREATE);
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(422);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(425);
			match(TABLE);
			setState(429);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(426);
				match(IF);
				setState(427);
				match(NOT);
				setState(428);
				match(EXISTS);
				}
				break;
			}
			setState(434);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(431);
				schema_name();
				setState(432);
				match(DOT);
				}
				break;
			}
			setState(436);
			table_name();
			setState(460);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR:
				{
				{
				setState(437);
				match(OPEN_PAR);
				setState(438);
				column_def();
				setState(443);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(439);
						match(COMMA);
						setState(440);
						column_def();
						}
						} 
					}
					setState(445);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				}
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(446);
					match(COMMA);
					setState(447);
					table_constraint();
					}
					}
					setState(452);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(453);
				match(CLOSE_PAR);
				setState(456);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITHOUT) {
					{
					setState(454);
					match(WITHOUT);
					setState(455);
					((Create_table_stmtContext)_localctx).rowID = match(IDENTIFIER);
					}
				}

				}
				}
				break;
			case AS:
				{
				{
				setState(458);
				match(AS);
				setState(459);
				select_stmt();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_defContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public List<Column_constraintContext> column_constraint() {
			return getRuleContexts(Column_constraintContext.class);
		}
		public Column_constraintContext column_constraint(int i) {
			return getRuleContext(Column_constraintContext.class,i);
		}
		public Column_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_def; }
	}

	public final Column_defContext column_def() throws RecognitionException {
		Column_defContext _localctx = new Column_defContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_column_def);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			column_name();
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(463);
				type_name();
				}
				break;
			}
			setState(469);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(466);
					column_constraint();
					}
					} 
				}
				setState(471);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_nameContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Signed_numberContext> signed_number() {
			return getRuleContexts(Signed_numberContext.class);
		}
		public Signed_numberContext signed_number(int i) {
			return getRuleContext(Signed_numberContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type_name);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(473); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(472);
					name();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(475); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(487);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(477);
				match(OPEN_PAR);
				setState(478);
				signed_number();
				setState(479);
				match(CLOSE_PAR);
				}
				break;
			case 2:
				{
				setState(481);
				match(OPEN_PAR);
				setState(482);
				signed_number();
				setState(483);
				match(COMMA);
				setState(484);
				signed_number();
				setState(485);
				match(CLOSE_PAR);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_constraintContext extends ParserRuleContext {
		public TerminalNode CHECK() { return getToken(SQLiteParser.CHECK, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode DEFAULT() { return getToken(SQLiteParser.DEFAULT, 0); }
		public TerminalNode COLLATE() { return getToken(SQLiteParser.COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Foreign_key_clauseContext foreign_key_clause() {
			return getRuleContext(Foreign_key_clauseContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLiteParser.AS, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLiteParser.CONSTRAINT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode PRIMARY() { return getToken(SQLiteParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(SQLiteParser.KEY, 0); }
		public TerminalNode UNIQUE() { return getToken(SQLiteParser.UNIQUE, 0); }
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public Conflict_clauseContext conflict_clause() {
			return getRuleContext(Conflict_clauseContext.class,0);
		}
		public TerminalNode GENERATED() { return getToken(SQLiteParser.GENERATED, 0); }
		public TerminalNode ALWAYS() { return getToken(SQLiteParser.ALWAYS, 0); }
		public TerminalNode NOT() { return getToken(SQLiteParser.NOT, 0); }
		public TerminalNode NULL_() { return getToken(SQLiteParser.NULL_, 0); }
		public TerminalNode STORED() { return getToken(SQLiteParser.STORED, 0); }
		public TerminalNode VIRTUAL() { return getToken(SQLiteParser.VIRTUAL, 0); }
		public Asc_descContext asc_desc() {
			return getRuleContext(Asc_descContext.class,0);
		}
		public TerminalNode AUTOINCREMENT() { return getToken(SQLiteParser.AUTOINCREMENT, 0); }
		public Column_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_constraint; }
	}

	public final Column_constraintContext column_constraint() throws RecognitionException {
		Column_constraintContext _localctx = new Column_constraintContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(489);
				match(CONSTRAINT);
				setState(490);
				name();
				}
			}

			setState(540);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMARY:
				{
				{
				setState(493);
				match(PRIMARY);
				setState(494);
				match(KEY);
				setState(496);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASC || _la==DESC) {
					{
					setState(495);
					asc_desc();
					}
				}

				setState(499);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(498);
					conflict_clause();
					}
				}

				setState(502);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AUTOINCREMENT) {
					{
					setState(501);
					match(AUTOINCREMENT);
					}
				}

				}
				}
				break;
			case NOT:
			case UNIQUE:
				{
				setState(507);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOT:
					{
					{
					setState(504);
					match(NOT);
					setState(505);
					match(NULL_);
					}
					}
					break;
				case UNIQUE:
					{
					setState(506);
					match(UNIQUE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(509);
					conflict_clause();
					}
				}

				}
				break;
			case CHECK:
				{
				setState(512);
				match(CHECK);
				setState(513);
				match(OPEN_PAR);
				setState(514);
				expr(0);
				setState(515);
				match(CLOSE_PAR);
				}
				break;
			case DEFAULT:
				{
				setState(517);
				match(DEFAULT);
				setState(524);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(518);
					signed_number();
					}
					break;
				case 2:
					{
					setState(519);
					literal_value();
					}
					break;
				case 3:
					{
					{
					setState(520);
					match(OPEN_PAR);
					setState(521);
					expr(0);
					setState(522);
					match(CLOSE_PAR);
					}
					}
					break;
				}
				}
				break;
			case COLLATE:
				{
				setState(526);
				match(COLLATE);
				setState(527);
				collation_name();
				}
				break;
			case REFERENCES:
				{
				setState(528);
				foreign_key_clause();
				}
				break;
			case AS:
			case GENERATED:
				{
				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GENERATED) {
					{
					setState(529);
					match(GENERATED);
					setState(530);
					match(ALWAYS);
					}
				}

				setState(533);
				match(AS);
				setState(534);
				match(OPEN_PAR);
				setState(535);
				expr(0);
				setState(536);
				match(CLOSE_PAR);
				setState(538);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VIRTUAL || _la==STORED) {
					{
					setState(537);
					_la = _input.LA(1);
					if ( !(_la==VIRTUAL || _la==STORED) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_numberContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SQLiteParser.NUMERIC_LITERAL, 0); }
		public TerminalNode PLUS() { return getToken(SQLiteParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SQLiteParser.MINUS, 0); }
		public Signed_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_number; }
	}

	public final Signed_numberContext signed_number() throws RecognitionException {
		Signed_numberContext _localctx = new Signed_numberContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(542);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(545);
			match(NUMERIC_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_constraintContext extends ParserRuleContext {
		public TerminalNode CONSTRAINT() { return getToken(SQLiteParser.CONSTRAINT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Indexed_columnContext> indexed_column() {
			return getRuleContexts(Indexed_columnContext.class);
		}
		public Indexed_columnContext indexed_column(int i) {
			return getRuleContext(Indexed_columnContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode CHECK() { return getToken(SQLiteParser.CHECK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FOREIGN() { return getToken(SQLiteParser.FOREIGN, 0); }
		public TerminalNode KEY() { return getToken(SQLiteParser.KEY, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Foreign_key_clauseContext foreign_key_clause() {
			return getRuleContext(Foreign_key_clauseContext.class,0);
		}
		public TerminalNode PRIMARY() { return getToken(SQLiteParser.PRIMARY, 0); }
		public TerminalNode UNIQUE() { return getToken(SQLiteParser.UNIQUE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Conflict_clauseContext conflict_clause() {
			return getRuleContext(Conflict_clauseContext.class,0);
		}
		public Table_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_constraint; }
	}

	public final Table_constraintContext table_constraint() throws RecognitionException {
		Table_constraintContext _localctx = new Table_constraintContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(547);
				match(CONSTRAINT);
				setState(548);
				name();
				}
			}

			setState(588);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMARY:
			case UNIQUE:
				{
				{
				setState(554);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PRIMARY:
					{
					setState(551);
					match(PRIMARY);
					setState(552);
					match(KEY);
					}
					break;
				case UNIQUE:
					{
					setState(553);
					match(UNIQUE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(556);
				match(OPEN_PAR);
				setState(557);
				indexed_column();
				setState(562);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(558);
					match(COMMA);
					setState(559);
					indexed_column();
					}
					}
					setState(564);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(565);
				match(CLOSE_PAR);
				setState(567);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(566);
					conflict_clause();
					}
				}

				}
				}
				break;
			case CHECK:
				{
				{
				setState(569);
				match(CHECK);
				setState(570);
				match(OPEN_PAR);
				setState(571);
				expr(0);
				setState(572);
				match(CLOSE_PAR);
				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(574);
				match(FOREIGN);
				setState(575);
				match(KEY);
				setState(576);
				match(OPEN_PAR);
				setState(577);
				column_name();
				setState(582);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(578);
					match(COMMA);
					setState(579);
					column_name();
					}
					}
					setState(584);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(585);
				match(CLOSE_PAR);
				setState(586);
				foreign_key_clause();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Foreign_key_clauseContext extends ParserRuleContext {
		public TerminalNode REFERENCES() { return getToken(SQLiteParser.REFERENCES, 0); }
		public Foreign_tableContext foreign_table() {
			return getRuleContext(Foreign_tableContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode DEFERRABLE() { return getToken(SQLiteParser.DEFERRABLE, 0); }
		public List<TerminalNode> ON() { return getTokens(SQLiteParser.ON); }
		public TerminalNode ON(int i) {
			return getToken(SQLiteParser.ON, i);
		}
		public List<TerminalNode> MATCH() { return getTokens(SQLiteParser.MATCH); }
		public TerminalNode MATCH(int i) {
			return getToken(SQLiteParser.MATCH, i);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public List<TerminalNode> DELETE() { return getTokens(SQLiteParser.DELETE); }
		public TerminalNode DELETE(int i) {
			return getToken(SQLiteParser.DELETE, i);
		}
		public List<TerminalNode> UPDATE() { return getTokens(SQLiteParser.UPDATE); }
		public TerminalNode UPDATE(int i) {
			return getToken(SQLiteParser.UPDATE, i);
		}
		public TerminalNode NOT() { return getToken(SQLiteParser.NOT, 0); }
		public TerminalNode INITIALLY() { return getToken(SQLiteParser.INITIALLY, 0); }
		public List<TerminalNode> CASCADE() { return getTokens(SQLiteParser.CASCADE); }
		public TerminalNode CASCADE(int i) {
			return getToken(SQLiteParser.CASCADE, i);
		}
		public List<TerminalNode> RESTRICT() { return getTokens(SQLiteParser.RESTRICT); }
		public TerminalNode RESTRICT(int i) {
			return getToken(SQLiteParser.RESTRICT, i);
		}
		public TerminalNode DEFERRED() { return getToken(SQLiteParser.DEFERRED, 0); }
		public TerminalNode IMMEDIATE() { return getToken(SQLiteParser.IMMEDIATE, 0); }
		public List<TerminalNode> SET() { return getTokens(SQLiteParser.SET); }
		public TerminalNode SET(int i) {
			return getToken(SQLiteParser.SET, i);
		}
		public List<TerminalNode> NO() { return getTokens(SQLiteParser.NO); }
		public TerminalNode NO(int i) {
			return getToken(SQLiteParser.NO, i);
		}
		public List<TerminalNode> ACTION() { return getTokens(SQLiteParser.ACTION); }
		public TerminalNode ACTION(int i) {
			return getToken(SQLiteParser.ACTION, i);
		}
		public List<TerminalNode> NULL_() { return getTokens(SQLiteParser.NULL_); }
		public TerminalNode NULL_(int i) {
			return getToken(SQLiteParser.NULL_, i);
		}
		public List<TerminalNode> DEFAULT() { return getTokens(SQLiteParser.DEFAULT); }
		public TerminalNode DEFAULT(int i) {
			return getToken(SQLiteParser.DEFAULT, i);
		}
		public Foreign_key_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign_key_clause; }
	}

	public final Foreign_key_clauseContext foreign_key_clause() throws RecognitionException {
		Foreign_key_clauseContext _localctx = new Foreign_key_clauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_foreign_key_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			match(REFERENCES);
			setState(591);
			foreign_table();
			setState(603);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(592);
				match(OPEN_PAR);
				setState(593);
				column_name();
				setState(598);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(594);
					match(COMMA);
					setState(595);
					column_name();
					}
					}
					setState(600);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(601);
				match(CLOSE_PAR);
				}
			}

			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MATCH || _la==ON) {
				{
				setState(617);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ON:
					{
					{
					setState(605);
					match(ON);
					setState(606);
					_la = _input.LA(1);
					if ( !(_la==DELETE || _la==UPDATE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(613);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SET:
						{
						{
						setState(607);
						match(SET);
						setState(608);
						_la = _input.LA(1);
						if ( !(_la==DEFAULT || _la==NULL_) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						break;
					case CASCADE:
						{
						setState(609);
						match(CASCADE);
						}
						break;
					case RESTRICT:
						{
						setState(610);
						match(RESTRICT);
						}
						break;
					case NO:
						{
						{
						setState(611);
						match(NO);
						setState(612);
						match(ACTION);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					break;
				case MATCH:
					{
					{
					setState(615);
					match(MATCH);
					setState(616);
					name();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(621);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(630);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(623);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(622);
					match(NOT);
					}
				}

				setState(625);
				match(DEFERRABLE);
				setState(628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INITIALLY) {
					{
					setState(626);
					match(INITIALLY);
					setState(627);
					_la = _input.LA(1);
					if ( !(_la==DEFERRED || _la==IMMEDIATE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conflict_clauseContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SQLiteParser.ON, 0); }
		public TerminalNode CONFLICT() { return getToken(SQLiteParser.CONFLICT, 0); }
		public TerminalNode ROLLBACK() { return getToken(SQLiteParser.ROLLBACK, 0); }
		public TerminalNode ABORT() { return getToken(SQLiteParser.ABORT, 0); }
		public TerminalNode FAIL() { return getToken(SQLiteParser.FAIL, 0); }
		public TerminalNode IGNORE() { return getToken(SQLiteParser.IGNORE, 0); }
		public TerminalNode REPLACE() { return getToken(SQLiteParser.REPLACE, 0); }
		public Conflict_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conflict_clause; }
	}

	public final Conflict_clauseContext conflict_clause() throws RecognitionException {
		Conflict_clauseContext _localctx = new Conflict_clauseContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_conflict_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			match(ON);
			setState(633);
			match(CONFLICT);
			setState(634);
			_la = _input.LA(1);
			if ( !(_la==ABORT || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (FAIL - 73)) | (1L << (IGNORE - 73)) | (1L << (REPLACE - 73)) | (1L << (ROLLBACK - 73)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_trigger_stmtContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SQLiteParser.CREATE, 0); }
		public TerminalNode TRIGGER() { return getToken(SQLiteParser.TRIGGER, 0); }
		public Trigger_nameContext trigger_name() {
			return getRuleContext(Trigger_nameContext.class,0);
		}
		public TerminalNode ON() { return getToken(SQLiteParser.ON, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(SQLiteParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(SQLiteParser.END, 0); }
		public TerminalNode DELETE() { return getToken(SQLiteParser.DELETE, 0); }
		public TerminalNode INSERT() { return getToken(SQLiteParser.INSERT, 0); }
		public TerminalNode IF() { return getToken(SQLiteParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SQLiteParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SQLiteParser.EXISTS, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode BEFORE() { return getToken(SQLiteParser.BEFORE, 0); }
		public TerminalNode AFTER() { return getToken(SQLiteParser.AFTER, 0); }
		public TerminalNode FOR() { return getToken(SQLiteParser.FOR, 0); }
		public TerminalNode EACH() { return getToken(SQLiteParser.EACH, 0); }
		public TerminalNode ROW() { return getToken(SQLiteParser.ROW, 0); }
		public TerminalNode WHEN() { return getToken(SQLiteParser.WHEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> SCOL() { return getTokens(SQLiteParser.SCOL); }
		public TerminalNode SCOL(int i) {
			return getToken(SQLiteParser.SCOL, i);
		}
		public TerminalNode TEMP() { return getToken(SQLiteParser.TEMP, 0); }
		public TerminalNode TEMPORARY() { return getToken(SQLiteParser.TEMPORARY, 0); }
		public TerminalNode UPDATE() { return getToken(SQLiteParser.UPDATE, 0); }
		public TerminalNode INSTEAD() { return getToken(SQLiteParser.INSTEAD, 0); }
		public List<TerminalNode> OF() { return getTokens(SQLiteParser.OF); }
		public TerminalNode OF(int i) {
			return getToken(SQLiteParser.OF, i);
		}
		public List<Update_stmtContext> update_stmt() {
			return getRuleContexts(Update_stmtContext.class);
		}
		public Update_stmtContext update_stmt(int i) {
			return getRuleContext(Update_stmtContext.class,i);
		}
		public List<Insert_stmtContext> insert_stmt() {
			return getRuleContexts(Insert_stmtContext.class);
		}
		public Insert_stmtContext insert_stmt(int i) {
			return getRuleContext(Insert_stmtContext.class,i);
		}
		public List<Delete_stmtContext> delete_stmt() {
			return getRuleContexts(Delete_stmtContext.class);
		}
		public Delete_stmtContext delete_stmt(int i) {
			return getRuleContext(Delete_stmtContext.class,i);
		}
		public List<Select_stmtContext> select_stmt() {
			return getRuleContexts(Select_stmtContext.class);
		}
		public Select_stmtContext select_stmt(int i) {
			return getRuleContext(Select_stmtContext.class,i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Create_trigger_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_trigger_stmt; }
	}

	public final Create_trigger_stmtContext create_trigger_stmt() throws RecognitionException {
		Create_trigger_stmtContext _localctx = new Create_trigger_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_create_trigger_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			match(CREATE);
			setState(638);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(637);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(640);
			match(TRIGGER);
			setState(644);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(641);
				match(IF);
				setState(642);
				match(NOT);
				setState(643);
				match(EXISTS);
				}
				break;
			}
			setState(649);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(646);
				schema_name();
				setState(647);
				match(DOT);
				}
				break;
			}
			setState(651);
			trigger_name();
			setState(656);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(652);
				match(BEFORE);
				}
				break;
			case AFTER:
				{
				setState(653);
				match(AFTER);
				}
				break;
			case INSTEAD:
				{
				{
				setState(654);
				match(INSTEAD);
				setState(655);
				match(OF);
				}
				}
				break;
			case DELETE:
			case INSERT:
			case UPDATE:
				break;
			default:
				break;
			}
			setState(672);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DELETE:
				{
				setState(658);
				match(DELETE);
				}
				break;
			case INSERT:
				{
				setState(659);
				match(INSERT);
				}
				break;
			case UPDATE:
				{
				{
				setState(660);
				match(UPDATE);
				setState(670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(661);
					match(OF);
					setState(662);
					column_name();
					setState(667);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(663);
						match(COMMA);
						setState(664);
						column_name();
						}
						}
						setState(669);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(674);
			match(ON);
			setState(675);
			table_name();
			setState(679);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FOR) {
				{
				setState(676);
				match(FOR);
				setState(677);
				match(EACH);
				setState(678);
				match(ROW);
				}
			}

			setState(683);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(681);
				match(WHEN);
				setState(682);
				expr(0);
				}
			}

			setState(685);
			match(BEGIN);
			setState(694); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(690);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
				case 1:
					{
					setState(686);
					update_stmt();
					}
					break;
				case 2:
					{
					setState(687);
					insert_stmt();
					}
					break;
				case 3:
					{
					setState(688);
					delete_stmt();
					}
					break;
				case 4:
					{
					setState(689);
					select_stmt();
					}
					break;
				}
				setState(692);
				match(SCOL);
				}
				}
				setState(696); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DEFAULT || _la==DELETE || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (INSERT - 89)) | (1L << (REPLACE - 89)) | (1L << (SELECT - 89)) | (1L << (UPDATE - 89)) | (1L << (VALUES - 89)) | (1L << (WITH - 89)))) != 0) );
			setState(698);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_view_stmtContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SQLiteParser.CREATE, 0); }
		public TerminalNode VIEW() { return getToken(SQLiteParser.VIEW, 0); }
		public View_nameContext view_name() {
			return getRuleContext(View_nameContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLiteParser.AS, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode IF() { return getToken(SQLiteParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SQLiteParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SQLiteParser.EXISTS, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode TEMP() { return getToken(SQLiteParser.TEMP, 0); }
		public TerminalNode TEMPORARY() { return getToken(SQLiteParser.TEMPORARY, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Create_view_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_view_stmt; }
	}

	public final Create_view_stmtContext create_view_stmt() throws RecognitionException {
		Create_view_stmtContext _localctx = new Create_view_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_create_view_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
			match(CREATE);
			setState(702);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(701);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(704);
			match(VIEW);
			setState(708);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				{
				setState(705);
				match(IF);
				setState(706);
				match(NOT);
				setState(707);
				match(EXISTS);
				}
				break;
			}
			setState(713);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				{
				setState(710);
				schema_name();
				setState(711);
				match(DOT);
				}
				break;
			}
			setState(715);
			view_name();
			setState(727);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(716);
				match(OPEN_PAR);
				setState(717);
				column_name();
				setState(722);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(718);
					match(COMMA);
					setState(719);
					column_name();
					}
					}
					setState(724);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(725);
				match(CLOSE_PAR);
				}
			}

			setState(729);
			match(AS);
			setState(730);
			select_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_virtual_table_stmtContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SQLiteParser.CREATE, 0); }
		public TerminalNode VIRTUAL() { return getToken(SQLiteParser.VIRTUAL, 0); }
		public TerminalNode TABLE() { return getToken(SQLiteParser.TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode USING() { return getToken(SQLiteParser.USING, 0); }
		public Module_nameContext module_name() {
			return getRuleContext(Module_nameContext.class,0);
		}
		public TerminalNode IF() { return getToken(SQLiteParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SQLiteParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SQLiteParser.EXISTS, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Module_argumentContext> module_argument() {
			return getRuleContexts(Module_argumentContext.class);
		}
		public Module_argumentContext module_argument(int i) {
			return getRuleContext(Module_argumentContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Create_virtual_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_virtual_table_stmt; }
	}

	public final Create_virtual_table_stmtContext create_virtual_table_stmt() throws RecognitionException {
		Create_virtual_table_stmtContext _localctx = new Create_virtual_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_create_virtual_table_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			match(CREATE);
			setState(733);
			match(VIRTUAL);
			setState(734);
			match(TABLE);
			setState(738);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				{
				setState(735);
				match(IF);
				setState(736);
				match(NOT);
				setState(737);
				match(EXISTS);
				}
				break;
			}
			setState(743);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				{
				setState(740);
				schema_name();
				setState(741);
				match(DOT);
				}
				break;
			}
			setState(745);
			table_name();
			setState(746);
			match(USING);
			setState(747);
			module_name();
			setState(759);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(748);
				match(OPEN_PAR);
				setState(749);
				module_argument();
				setState(754);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(750);
					match(COMMA);
					setState(751);
					module_argument();
					}
					}
					setState(756);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(757);
				match(CLOSE_PAR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class With_clauseContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SQLiteParser.WITH, 0); }
		public List<Cte_table_nameContext> cte_table_name() {
			return getRuleContexts(Cte_table_nameContext.class);
		}
		public Cte_table_nameContext cte_table_name(int i) {
			return getRuleContext(Cte_table_nameContext.class,i);
		}
		public List<TerminalNode> AS() { return getTokens(SQLiteParser.AS); }
		public TerminalNode AS(int i) {
			return getToken(SQLiteParser.AS, i);
		}
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public List<Select_stmtContext> select_stmt() {
			return getRuleContexts(Select_stmtContext.class);
		}
		public Select_stmtContext select_stmt(int i) {
			return getRuleContext(Select_stmtContext.class,i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public TerminalNode RECURSIVE() { return getToken(SQLiteParser.RECURSIVE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public With_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_clause; }
	}

	public final With_clauseContext with_clause() throws RecognitionException {
		With_clauseContext _localctx = new With_clauseContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_with_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(761);
			match(WITH);
			setState(763);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				{
				setState(762);
				match(RECURSIVE);
				}
				break;
			}
			setState(765);
			cte_table_name();
			setState(766);
			match(AS);
			setState(767);
			match(OPEN_PAR);
			setState(768);
			select_stmt();
			setState(769);
			match(CLOSE_PAR);
			setState(779);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(770);
				match(COMMA);
				setState(771);
				cte_table_name();
				setState(772);
				match(AS);
				setState(773);
				match(OPEN_PAR);
				setState(774);
				select_stmt();
				setState(775);
				match(CLOSE_PAR);
				}
				}
				setState(781);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cte_table_nameContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Cte_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cte_table_name; }
	}

	public final Cte_table_nameContext cte_table_name() throws RecognitionException {
		Cte_table_nameContext _localctx = new Cte_table_nameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_cte_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(782);
			table_name();
			setState(794);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(783);
				match(OPEN_PAR);
				setState(784);
				column_name();
				setState(789);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(785);
					match(COMMA);
					setState(786);
					column_name();
					}
					}
					setState(791);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(792);
				match(CLOSE_PAR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Recursive_cteContext extends ParserRuleContext {
		public Cte_table_nameContext cte_table_name() {
			return getRuleContext(Cte_table_nameContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLiteParser.AS, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public Initial_selectContext initial_select() {
			return getRuleContext(Initial_selectContext.class,0);
		}
		public TerminalNode UNION() { return getToken(SQLiteParser.UNION, 0); }
		public Recursive_selectContext recursive_select() {
			return getRuleContext(Recursive_selectContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode ALL() { return getToken(SQLiteParser.ALL, 0); }
		public Recursive_cteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recursive_cte; }
	}

	public final Recursive_cteContext recursive_cte() throws RecognitionException {
		Recursive_cteContext _localctx = new Recursive_cteContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_recursive_cte);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(796);
			cte_table_name();
			setState(797);
			match(AS);
			setState(798);
			match(OPEN_PAR);
			setState(799);
			initial_select();
			setState(800);
			match(UNION);
			setState(802);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL) {
				{
				setState(801);
				match(ALL);
				}
			}

			setState(804);
			recursive_select();
			setState(805);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Common_table_expressionContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLiteParser.AS, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Common_table_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_common_table_expression; }
	}

	public final Common_table_expressionContext common_table_expression() throws RecognitionException {
		Common_table_expressionContext _localctx = new Common_table_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_common_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(807);
			table_name();
			setState(819);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(808);
				match(OPEN_PAR);
				setState(809);
				column_name();
				setState(814);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(810);
					match(COMMA);
					setState(811);
					column_name();
					}
					}
					setState(816);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(817);
				match(CLOSE_PAR);
				}
			}

			setState(821);
			match(AS);
			setState(822);
			match(OPEN_PAR);
			setState(823);
			select_stmt();
			setState(824);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_stmtContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(SQLiteParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(SQLiteParser.FROM, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SQLiteParser.WHERE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Delete_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_stmt; }
	}

	public final Delete_stmtContext delete_stmt() throws RecognitionException {
		Delete_stmtContext _localctx = new Delete_stmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_delete_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(827);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(826);
				with_clause();
				}
			}

			setState(829);
			match(DELETE);
			setState(830);
			match(FROM);
			setState(831);
			qualified_table_name();
			setState(834);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(832);
				match(WHERE);
				setState(833);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_stmt_limitedContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(SQLiteParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(SQLiteParser.FROM, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SQLiteParser.WHERE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Limit_stmtContext limit_stmt() {
			return getRuleContext(Limit_stmtContext.class,0);
		}
		public Order_by_stmtContext order_by_stmt() {
			return getRuleContext(Order_by_stmtContext.class,0);
		}
		public Delete_stmt_limitedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_stmt_limited; }
	}

	public final Delete_stmt_limitedContext delete_stmt_limited() throws RecognitionException {
		Delete_stmt_limitedContext _localctx = new Delete_stmt_limitedContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_delete_stmt_limited);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(837);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(836);
				with_clause();
				}
			}

			setState(839);
			match(DELETE);
			setState(840);
			match(FROM);
			setState(841);
			qualified_table_name();
			setState(844);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(842);
				match(WHERE);
				setState(843);
				expr(0);
				}
			}

			setState(850);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT || _la==ORDER) {
				{
				setState(847);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(846);
					order_by_stmt();
					}
				}

				setState(849);
				limit_stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Detach_stmtContext extends ParserRuleContext {
		public TerminalNode DETACH() { return getToken(SQLiteParser.DETACH, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DATABASE() { return getToken(SQLiteParser.DATABASE, 0); }
		public Detach_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_detach_stmt; }
	}

	public final Detach_stmtContext detach_stmt() throws RecognitionException {
		Detach_stmtContext _localctx = new Detach_stmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_detach_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852);
			match(DETACH);
			setState(854);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				setState(853);
				match(DATABASE);
				}
				break;
			}
			setState(856);
			schema_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_stmtContext extends ParserRuleContext {
		public Token object;
		public TerminalNode DROP() { return getToken(SQLiteParser.DROP, 0); }
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TerminalNode INDEX() { return getToken(SQLiteParser.INDEX, 0); }
		public TerminalNode TABLE() { return getToken(SQLiteParser.TABLE, 0); }
		public TerminalNode TRIGGER() { return getToken(SQLiteParser.TRIGGER, 0); }
		public TerminalNode VIEW() { return getToken(SQLiteParser.VIEW, 0); }
		public TerminalNode IF() { return getToken(SQLiteParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SQLiteParser.EXISTS, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Drop_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_stmt; }
	}

	public final Drop_stmtContext drop_stmt() throws RecognitionException {
		Drop_stmtContext _localctx = new Drop_stmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_drop_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(858);
			match(DROP);
			setState(859);
			((Drop_stmtContext)_localctx).object = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (INDEX - 85)) | (1L << (TABLE - 85)) | (1L << (TRIGGER - 85)) | (1L << (VIEW - 85)))) != 0)) ) {
				((Drop_stmtContext)_localctx).object = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(862);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(860);
				match(IF);
				setState(861);
				match(EXISTS);
				}
				break;
			}
			setState(867);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				setState(864);
				schema_name();
				setState(865);
				match(DOT);
				}
				break;
			}
			setState(869);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode BIND_PARAMETER() { return getToken(SQLiteParser.BIND_PARAMETER, 0); }
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(SQLiteParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SQLiteParser.DOT, i);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode STAR() { return getToken(SQLiteParser.STAR, 0); }
		public Filter_clauseContext filter_clause() {
			return getRuleContext(Filter_clauseContext.class,0);
		}
		public Over_clauseContext over_clause() {
			return getRuleContext(Over_clauseContext.class,0);
		}
		public TerminalNode DISTINCT() { return getToken(SQLiteParser.DISTINCT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode CAST() { return getToken(SQLiteParser.CAST, 0); }
		public TerminalNode AS() { return getToken(SQLiteParser.AS, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode EXISTS() { return getToken(SQLiteParser.EXISTS, 0); }
		public TerminalNode NOT() { return getToken(SQLiteParser.NOT, 0); }
		public TerminalNode CASE() { return getToken(SQLiteParser.CASE, 0); }
		public TerminalNode END() { return getToken(SQLiteParser.END, 0); }
		public List<TerminalNode> WHEN() { return getTokens(SQLiteParser.WHEN); }
		public TerminalNode WHEN(int i) {
			return getToken(SQLiteParser.WHEN, i);
		}
		public List<TerminalNode> THEN() { return getTokens(SQLiteParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(SQLiteParser.THEN, i);
		}
		public TerminalNode ELSE() { return getToken(SQLiteParser.ELSE, 0); }
		public Raise_functionContext raise_function() {
			return getRuleContext(Raise_functionContext.class,0);
		}
		public TerminalNode PIPE2() { return getToken(SQLiteParser.PIPE2, 0); }
		public TerminalNode DIV() { return getToken(SQLiteParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SQLiteParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(SQLiteParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SQLiteParser.MINUS, 0); }
		public TerminalNode LT2() { return getToken(SQLiteParser.LT2, 0); }
		public TerminalNode GT2() { return getToken(SQLiteParser.GT2, 0); }
		public TerminalNode AMP() { return getToken(SQLiteParser.AMP, 0); }
		public TerminalNode PIPE() { return getToken(SQLiteParser.PIPE, 0); }
		public TerminalNode LT() { return getToken(SQLiteParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(SQLiteParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(SQLiteParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(SQLiteParser.GT_EQ, 0); }
		public TerminalNode ASSIGN() { return getToken(SQLiteParser.ASSIGN, 0); }
		public TerminalNode EQ() { return getToken(SQLiteParser.EQ, 0); }
		public TerminalNode NOT_EQ1() { return getToken(SQLiteParser.NOT_EQ1, 0); }
		public TerminalNode NOT_EQ2() { return getToken(SQLiteParser.NOT_EQ2, 0); }
		public TerminalNode IS() { return getToken(SQLiteParser.IS, 0); }
		public TerminalNode IN() { return getToken(SQLiteParser.IN, 0); }
		public TerminalNode LIKE() { return getToken(SQLiteParser.LIKE, 0); }
		public TerminalNode GLOB() { return getToken(SQLiteParser.GLOB, 0); }
		public TerminalNode MATCH() { return getToken(SQLiteParser.MATCH, 0); }
		public TerminalNode REGEXP() { return getToken(SQLiteParser.REGEXP, 0); }
		public TerminalNode AND() { return getToken(SQLiteParser.AND, 0); }
		public TerminalNode OR() { return getToken(SQLiteParser.OR, 0); }
		public TerminalNode BETWEEN() { return getToken(SQLiteParser.BETWEEN, 0); }
		public TerminalNode COLLATE() { return getToken(SQLiteParser.COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode ESCAPE() { return getToken(SQLiteParser.ESCAPE, 0); }
		public TerminalNode ISNULL() { return getToken(SQLiteParser.ISNULL, 0); }
		public TerminalNode NOTNULL() { return getToken(SQLiteParser.NOTNULL, 0); }
		public TerminalNode NULL_() { return getToken(SQLiteParser.NULL_, 0); }
		public Table_function_nameContext table_function_name() {
			return getRuleContext(Table_function_nameContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(959);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				{
				setState(872);
				literal_value();
				}
				break;
			case 2:
				{
				setState(873);
				match(BIND_PARAMETER);
				}
				break;
			case 3:
				{
				setState(882);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
				case 1:
					{
					setState(877);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
					case 1:
						{
						setState(874);
						schema_name();
						setState(875);
						match(DOT);
						}
						break;
					}
					setState(879);
					table_name();
					setState(880);
					match(DOT);
					}
					break;
				}
				setState(884);
				column_name();
				}
				break;
			case 4:
				{
				setState(885);
				unary_operator();
				setState(886);
				expr(21);
				}
				break;
			case 5:
				{
				setState(888);
				function_name();
				setState(889);
				match(OPEN_PAR);
				setState(902);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPEN_PAR:
				case PLUS:
				case MINUS:
				case TILDE:
				case ABORT:
				case ACTION:
				case ADD:
				case AFTER:
				case ALL:
				case ALTER:
				case ANALYZE:
				case AND:
				case AS:
				case ASC:
				case ATTACH:
				case AUTOINCREMENT:
				case BEFORE:
				case BEGIN:
				case BETWEEN:
				case BY:
				case CASCADE:
				case CASE:
				case CAST:
				case CHECK:
				case COLLATE:
				case COLUMN:
				case COMMIT:
				case CONFLICT:
				case CONSTRAINT:
				case CREATE:
				case CROSS:
				case CURRENT_DATE:
				case CURRENT_TIME:
				case CURRENT_TIMESTAMP:
				case DATABASE:
				case DEFAULT:
				case DEFERRABLE:
				case DEFERRED:
				case DELETE:
				case DESC:
				case DETACH:
				case DISTINCT:
				case DROP:
				case EACH:
				case ELSE:
				case END:
				case ESCAPE:
				case EXCEPT:
				case EXCLUSIVE:
				case EXISTS:
				case EXPLAIN:
				case FAIL:
				case FOR:
				case FOREIGN:
				case FROM:
				case FULL:
				case GLOB:
				case GROUP:
				case HAVING:
				case IF:
				case IGNORE:
				case IMMEDIATE:
				case IN:
				case INDEX:
				case INDEXED:
				case INITIALLY:
				case INNER:
				case INSERT:
				case INSTEAD:
				case INTERSECT:
				case INTO:
				case IS:
				case ISNULL:
				case JOIN:
				case KEY:
				case LEFT:
				case LIKE:
				case LIMIT:
				case MATCH:
				case NATURAL:
				case NO:
				case NOT:
				case NOTNULL:
				case NULL_:
				case OF:
				case OFFSET:
				case ON:
				case OR:
				case ORDER:
				case OUTER:
				case PLAN:
				case PRAGMA:
				case PRIMARY:
				case QUERY:
				case RAISE:
				case RECURSIVE:
				case REFERENCES:
				case REGEXP:
				case REINDEX:
				case RELEASE:
				case RENAME:
				case REPLACE:
				case RESTRICT:
				case RIGHT:
				case ROLLBACK:
				case ROW:
				case ROWS:
				case SAVEPOINT:
				case SELECT:
				case SET:
				case TABLE:
				case TEMP:
				case TEMPORARY:
				case THEN:
				case TO:
				case TRANSACTION:
				case TRIGGER:
				case UNION:
				case UNIQUE:
				case UPDATE:
				case USING:
				case VACUUM:
				case VALUES:
				case VIEW:
				case VIRTUAL:
				case WHEN:
				case WHERE:
				case WITH:
				case WITHOUT:
				case FIRST_VALUE:
				case OVER:
				case PARTITION:
				case RANGE:
				case PRECEDING:
				case UNBOUNDED:
				case CURRENT:
				case FOLLOWING:
				case CUME_DIST:
				case DENSE_RANK:
				case LAG:
				case LAST_VALUE:
				case LEAD:
				case NTH_VALUE:
				case NTILE:
				case PERCENT_RANK:
				case RANK:
				case ROW_NUMBER:
				case GENERATED:
				case ALWAYS:
				case STORED:
				case TRUE_:
				case FALSE_:
				case WINDOW:
				case NULLS:
				case FIRST:
				case LAST:
				case FILTER:
				case GROUPS:
				case EXCLUDE:
				case IDENTIFIER:
				case NUMERIC_LITERAL:
				case REF_FIELD:
				case BIND_PARAMETER:
				case STRING_LITERAL:
				case BLOB_LITERAL:
					{
					{
					setState(891);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
					case 1:
						{
						setState(890);
						match(DISTINCT);
						}
						break;
					}
					setState(893);
					expr(0);
					setState(898);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(894);
						match(COMMA);
						setState(895);
						expr(0);
						}
						}
						setState(900);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case STAR:
					{
					setState(901);
					match(STAR);
					}
					break;
				case CLOSE_PAR:
					break;
				default:
					break;
				}
				setState(904);
				match(CLOSE_PAR);
				setState(906);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
				case 1:
					{
					setState(905);
					filter_clause();
					}
					break;
				}
				setState(909);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
				case 1:
					{
					setState(908);
					over_clause();
					}
					break;
				}
				}
				break;
			case 6:
				{
				setState(911);
				match(OPEN_PAR);
				setState(912);
				expr(0);
				setState(917);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(913);
					match(COMMA);
					setState(914);
					expr(0);
					}
					}
					setState(919);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(920);
				match(CLOSE_PAR);
				}
				break;
			case 7:
				{
				setState(922);
				match(CAST);
				setState(923);
				match(OPEN_PAR);
				setState(924);
				expr(0);
				setState(925);
				match(AS);
				setState(926);
				type_name();
				setState(927);
				match(CLOSE_PAR);
				}
				break;
			case 8:
				{
				setState(933);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXISTS || _la==NOT) {
					{
					setState(930);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NOT) {
						{
						setState(929);
						match(NOT);
						}
					}

					setState(932);
					match(EXISTS);
					}
				}

				setState(935);
				match(OPEN_PAR);
				setState(936);
				select_stmt();
				setState(937);
				match(CLOSE_PAR);
				}
				break;
			case 9:
				{
				setState(939);
				match(CASE);
				setState(941);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
				case 1:
					{
					setState(940);
					expr(0);
					}
					break;
				}
				setState(948); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(943);
					match(WHEN);
					setState(944);
					expr(0);
					setState(945);
					match(THEN);
					setState(946);
					expr(0);
					}
					}
					setState(950); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(954);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(952);
					match(ELSE);
					setState(953);
					expr(0);
					}
				}

				setState(956);
				match(END);
				}
				break;
			case 10:
				{
				setState(958);
				raise_function();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1080);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1078);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(961);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(962);
						match(PIPE2);
						setState(963);
						expr(21);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(964);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(965);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(966);
						expr(20);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(967);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(968);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(969);
						expr(19);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(970);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(971);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT2) | (1L << GT2) | (1L << AMP) | (1L << PIPE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(972);
						expr(18);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(973);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(974);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(975);
						expr(17);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(976);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(989);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
						case 1:
							{
							setState(977);
							match(ASSIGN);
							}
							break;
						case 2:
							{
							setState(978);
							match(EQ);
							}
							break;
						case 3:
							{
							setState(979);
							match(NOT_EQ1);
							}
							break;
						case 4:
							{
							setState(980);
							match(NOT_EQ2);
							}
							break;
						case 5:
							{
							setState(981);
							match(IS);
							}
							break;
						case 6:
							{
							setState(982);
							match(IS);
							setState(983);
							match(NOT);
							}
							break;
						case 7:
							{
							setState(984);
							match(IN);
							}
							break;
						case 8:
							{
							setState(985);
							match(LIKE);
							}
							break;
						case 9:
							{
							setState(986);
							match(GLOB);
							}
							break;
						case 10:
							{
							setState(987);
							match(MATCH);
							}
							break;
						case 11:
							{
							setState(988);
							match(REGEXP);
							}
							break;
						}
						setState(991);
						expr(16);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(992);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(993);
						match(AND);
						setState(994);
						expr(15);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(995);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(996);
						match(OR);
						setState(997);
						expr(14);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(998);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(999);
						match(IS);
						setState(1001);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
						case 1:
							{
							setState(1000);
							match(NOT);
							}
							break;
						}
						setState(1003);
						expr(7);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1004);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1006);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(1005);
							match(NOT);
							}
						}

						setState(1008);
						match(BETWEEN);
						setState(1009);
						expr(0);
						setState(1010);
						match(AND);
						setState(1011);
						expr(6);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1013);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1014);
						match(COLLATE);
						setState(1015);
						collation_name();
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1016);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1018);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(1017);
							match(NOT);
							}
						}

						setState(1020);
						_la = _input.LA(1);
						if ( !(((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (GLOB - 78)) | (1L << (LIKE - 78)) | (1L << (MATCH - 78)) | (1L << (REGEXP - 78)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1021);
						expr(0);
						setState(1024);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
						case 1:
							{
							setState(1022);
							match(ESCAPE);
							setState(1023);
							expr(0);
							}
							break;
						}
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1026);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1031);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case ISNULL:
							{
							setState(1027);
							match(ISNULL);
							}
							break;
						case NOTNULL:
							{
							setState(1028);
							match(NOTNULL);
							}
							break;
						case NOT:
							{
							{
							setState(1029);
							match(NOT);
							setState(1030);
							match(NULL_);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1033);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1035);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(1034);
							match(NOT);
							}
						}

						setState(1037);
						match(IN);
						setState(1076);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
						case 1:
							{
							{
							setState(1038);
							match(OPEN_PAR);
							setState(1048);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
							case 1:
								{
								setState(1039);
								select_stmt();
								}
								break;
							case 2:
								{
								setState(1040);
								expr(0);
								setState(1045);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==COMMA) {
									{
									{
									setState(1041);
									match(COMMA);
									setState(1042);
									expr(0);
									}
									}
									setState(1047);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
								break;
							}
							setState(1050);
							match(CLOSE_PAR);
							}
							}
							break;
						case 2:
							{
							{
							setState(1054);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
							case 1:
								{
								setState(1051);
								schema_name();
								setState(1052);
								match(DOT);
								}
								break;
							}
							setState(1056);
							table_name();
							}
							}
							break;
						case 3:
							{
							{
							setState(1060);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
							case 1:
								{
								setState(1057);
								schema_name();
								setState(1058);
								match(DOT);
								}
								break;
							}
							setState(1062);
							table_function_name();
							setState(1063);
							match(OPEN_PAR);
							setState(1072);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAR) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << ABORT) | (1L << ACTION) | (1L << ADD) | (1L << AFTER) | (1L << ALL) | (1L << ALTER) | (1L << ANALYZE) | (1L << AND) | (1L << AS) | (1L << ASC) | (1L << ATTACH) | (1L << AUTOINCREMENT) | (1L << BEFORE) | (1L << BEGIN) | (1L << BETWEEN) | (1L << BY) | (1L << CASCADE) | (1L << CASE) | (1L << CAST) | (1L << CHECK) | (1L << COLLATE) | (1L << COLUMN) | (1L << COMMIT) | (1L << CONFLICT) | (1L << CONSTRAINT) | (1L << CREATE) | (1L << CROSS) | (1L << CURRENT_DATE) | (1L << CURRENT_TIME) | (1L << CURRENT_TIMESTAMP) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DETACH) | (1L << DISTINCT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DROP - 64)) | (1L << (EACH - 64)) | (1L << (ELSE - 64)) | (1L << (END - 64)) | (1L << (ESCAPE - 64)) | (1L << (EXCEPT - 64)) | (1L << (EXCLUSIVE - 64)) | (1L << (EXISTS - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FAIL - 64)) | (1L << (FOR - 64)) | (1L << (FOREIGN - 64)) | (1L << (FROM - 64)) | (1L << (FULL - 64)) | (1L << (GLOB - 64)) | (1L << (GROUP - 64)) | (1L << (HAVING - 64)) | (1L << (IF - 64)) | (1L << (IGNORE - 64)) | (1L << (IMMEDIATE - 64)) | (1L << (IN - 64)) | (1L << (INDEX - 64)) | (1L << (INDEXED - 64)) | (1L << (INITIALLY - 64)) | (1L << (INNER - 64)) | (1L << (INSERT - 64)) | (1L << (INSTEAD - 64)) | (1L << (INTERSECT - 64)) | (1L << (INTO - 64)) | (1L << (IS - 64)) | (1L << (ISNULL - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (MATCH - 64)) | (1L << (NATURAL - 64)) | (1L << (NO - 64)) | (1L << (NOT - 64)) | (1L << (NOTNULL - 64)) | (1L << (NULL_ - 64)) | (1L << (OF - 64)) | (1L << (OFFSET - 64)) | (1L << (ON - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OUTER - 64)) | (1L << (PLAN - 64)) | (1L << (PRAGMA - 64)) | (1L << (PRIMARY - 64)) | (1L << (QUERY - 64)) | (1L << (RAISE - 64)) | (1L << (RECURSIVE - 64)) | (1L << (REFERENCES - 64)) | (1L << (REGEXP - 64)) | (1L << (REINDEX - 64)) | (1L << (RELEASE - 64)) | (1L << (RENAME - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RIGHT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (ROW - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ROWS - 128)) | (1L << (SAVEPOINT - 128)) | (1L << (SELECT - 128)) | (1L << (SET - 128)) | (1L << (TABLE - 128)) | (1L << (TEMP - 128)) | (1L << (TEMPORARY - 128)) | (1L << (THEN - 128)) | (1L << (TO - 128)) | (1L << (TRANSACTION - 128)) | (1L << (TRIGGER - 128)) | (1L << (UNION - 128)) | (1L << (UNIQUE - 128)) | (1L << (UPDATE - 128)) | (1L << (USING - 128)) | (1L << (VACUUM - 128)) | (1L << (VALUES - 128)) | (1L << (VIEW - 128)) | (1L << (VIRTUAL - 128)) | (1L << (WHEN - 128)) | (1L << (WHERE - 128)) | (1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (FIRST_VALUE - 128)) | (1L << (OVER - 128)) | (1L << (PARTITION - 128)) | (1L << (RANGE - 128)) | (1L << (PRECEDING - 128)) | (1L << (UNBOUNDED - 128)) | (1L << (CURRENT - 128)) | (1L << (FOLLOWING - 128)) | (1L << (CUME_DIST - 128)) | (1L << (DENSE_RANK - 128)) | (1L << (LAG - 128)) | (1L << (LAST_VALUE - 128)) | (1L << (LEAD - 128)) | (1L << (NTH_VALUE - 128)) | (1L << (NTILE - 128)) | (1L << (PERCENT_RANK - 128)) | (1L << (RANK - 128)) | (1L << (ROW_NUMBER - 128)) | (1L << (GENERATED - 128)) | (1L << (ALWAYS - 128)) | (1L << (STORED - 128)) | (1L << (TRUE_ - 128)) | (1L << (FALSE_ - 128)) | (1L << (WINDOW - 128)) | (1L << (NULLS - 128)) | (1L << (FIRST - 128)) | (1L << (LAST - 128)) | (1L << (FILTER - 128)) | (1L << (GROUPS - 128)) | (1L << (EXCLUDE - 128)) | (1L << (IDENTIFIER - 128)) | (1L << (NUMERIC_LITERAL - 128)) | (1L << (REF_FIELD - 128)) | (1L << (BIND_PARAMETER - 128)) | (1L << (STRING_LITERAL - 128)) | (1L << (BLOB_LITERAL - 128)))) != 0)) {
								{
								setState(1064);
								expr(0);
								setState(1069);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==COMMA) {
									{
									{
									setState(1065);
									match(COMMA);
									setState(1066);
									expr(0);
									}
									}
									setState(1071);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
							}

							setState(1074);
							match(CLOSE_PAR);
							}
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1082);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Raise_functionContext extends ParserRuleContext {
		public TerminalNode RAISE() { return getToken(SQLiteParser.RAISE, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode IGNORE() { return getToken(SQLiteParser.IGNORE, 0); }
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Error_messageContext error_message() {
			return getRuleContext(Error_messageContext.class,0);
		}
		public TerminalNode ROLLBACK() { return getToken(SQLiteParser.ROLLBACK, 0); }
		public TerminalNode ABORT() { return getToken(SQLiteParser.ABORT, 0); }
		public TerminalNode FAIL() { return getToken(SQLiteParser.FAIL, 0); }
		public Raise_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raise_function; }
	}

	public final Raise_functionContext raise_function() throws RecognitionException {
		Raise_functionContext _localctx = new Raise_functionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_raise_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1083);
			match(RAISE);
			setState(1084);
			match(OPEN_PAR);
			setState(1089);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNORE:
				{
				setState(1085);
				match(IGNORE);
				}
				break;
			case ABORT:
			case FAIL:
			case ROLLBACK:
				{
				{
				setState(1086);
				_la = _input.LA(1);
				if ( !(_la==ABORT || _la==FAIL || _la==ROLLBACK) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1087);
				match(COMMA);
				setState(1088);
				error_message();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1091);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Literal_valueContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SQLiteParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public TerminalNode BLOB_LITERAL() { return getToken(SQLiteParser.BLOB_LITERAL, 0); }
		public TerminalNode NULL_() { return getToken(SQLiteParser.NULL_, 0); }
		public TerminalNode TRUE_() { return getToken(SQLiteParser.TRUE_, 0); }
		public TerminalNode FALSE_() { return getToken(SQLiteParser.FALSE_, 0); }
		public TerminalNode CURRENT_TIME() { return getToken(SQLiteParser.CURRENT_TIME, 0); }
		public TerminalNode CURRENT_DATE() { return getToken(SQLiteParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SQLiteParser.CURRENT_TIMESTAMP, 0); }
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_literal_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1093);
			_la = _input.LA(1);
			if ( !(((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & ((1L << (CURRENT_DATE - 53)) | (1L << (CURRENT_TIME - 53)) | (1L << (CURRENT_TIMESTAMP - 53)) | (1L << (NULL_ - 53)))) != 0) || ((((_la - 172)) & ~0x3f) == 0 && ((1L << (_la - 172)) & ((1L << (TRUE_ - 172)) | (1L << (FALSE_ - 172)) | (1L << (NUMERIC_LITERAL - 172)) | (1L << (STRING_LITERAL - 172)) | (1L << (BLOB_LITERAL - 172)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_stmtContext extends ParserRuleContext {
		public TerminalNode INTO() { return getToken(SQLiteParser.INTO, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode INSERT() { return getToken(SQLiteParser.INSERT, 0); }
		public TerminalNode REPLACE() { return getToken(SQLiteParser.REPLACE, 0); }
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode AS() { return getToken(SQLiteParser.AS, 0); }
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public TerminalNode OR() { return getToken(SQLiteParser.OR, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode ROLLBACK() { return getToken(SQLiteParser.ROLLBACK, 0); }
		public TerminalNode ABORT() { return getToken(SQLiteParser.ABORT, 0); }
		public TerminalNode FAIL() { return getToken(SQLiteParser.FAIL, 0); }
		public TerminalNode IGNORE() { return getToken(SQLiteParser.IGNORE, 0); }
		public Upsert_clauseContext upsert_clause() {
			return getRuleContext(Upsert_clauseContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode VALUES() { return getToken(SQLiteParser.VALUES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DEFAULT() { return getToken(SQLiteParser.DEFAULT, 0); }
		public Insert_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_stmt; }
	}

	public final Insert_stmtContext insert_stmt() throws RecognitionException {
		Insert_stmtContext _localctx = new Insert_stmtContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_insert_stmt);
		int _la;
		try {
			setState(1165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INSERT:
			case REPLACE:
			case WITH:
				enterOuterAlt(_localctx, 1);
				{
				setState(1096);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1095);
					with_clause();
					}
				}

				setState(1103);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
				case 1:
					{
					setState(1098);
					match(INSERT);
					}
					break;
				case 2:
					{
					setState(1099);
					match(REPLACE);
					}
					break;
				case 3:
					{
					{
					setState(1100);
					match(INSERT);
					setState(1101);
					match(OR);
					setState(1102);
					_la = _input.LA(1);
					if ( !(_la==ABORT || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (FAIL - 73)) | (1L << (IGNORE - 73)) | (1L << (REPLACE - 73)) | (1L << (ROLLBACK - 73)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				}
				setState(1105);
				match(INTO);
				setState(1109);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
				case 1:
					{
					setState(1106);
					schema_name();
					setState(1107);
					match(DOT);
					}
					break;
				}
				setState(1111);
				table_name();
				setState(1114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1112);
					match(AS);
					setState(1113);
					table_alias();
					}
				}

				setState(1127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN_PAR) {
					{
					setState(1116);
					match(OPEN_PAR);
					setState(1117);
					column_name();
					setState(1122);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1118);
						match(COMMA);
						setState(1119);
						column_name();
						}
						}
						setState(1124);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1125);
					match(CLOSE_PAR);
					}
				}

				{
				setState(1158);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
				case 1:
					{
					{
					setState(1129);
					match(VALUES);
					setState(1130);
					match(OPEN_PAR);
					setState(1131);
					expr(0);
					setState(1136);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1132);
						match(COMMA);
						setState(1133);
						expr(0);
						}
						}
						setState(1138);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1139);
					match(CLOSE_PAR);
					setState(1154);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1140);
						match(COMMA);
						setState(1141);
						match(OPEN_PAR);
						setState(1142);
						expr(0);
						setState(1147);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1143);
							match(COMMA);
							setState(1144);
							expr(0);
							}
							}
							setState(1149);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1150);
						match(CLOSE_PAR);
						}
						}
						setState(1156);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case 2:
					{
					setState(1157);
					select_stmt();
					}
					break;
				}
				setState(1161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(1160);
					upsert_clause();
					}
				}

				}
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1163);
				match(DEFAULT);
				setState(1164);
				match(VALUES);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Upsert_clauseContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SQLiteParser.ON, 0); }
		public TerminalNode CONFLICT() { return getToken(SQLiteParser.CONFLICT, 0); }
		public TerminalNode DO() { return getToken(SQLiteParser.DO, 0); }
		public TerminalNode NOTHING() { return getToken(SQLiteParser.NOTHING, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Indexed_columnContext> indexed_column() {
			return getRuleContexts(Indexed_columnContext.class);
		}
		public Indexed_columnContext indexed_column(int i) {
			return getRuleContext(Indexed_columnContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode UPDATE() { return getToken(SQLiteParser.UPDATE, 0); }
		public TerminalNode SET() { return getToken(SQLiteParser.SET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public List<TerminalNode> WHERE() { return getTokens(SQLiteParser.WHERE); }
		public TerminalNode WHERE(int i) {
			return getToken(SQLiteParser.WHERE, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> EQ() { return getTokens(SQLiteParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(SQLiteParser.EQ, i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<Column_name_listContext> column_name_list() {
			return getRuleContexts(Column_name_listContext.class);
		}
		public Column_name_listContext column_name_list(int i) {
			return getRuleContext(Column_name_listContext.class,i);
		}
		public Upsert_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upsert_clause; }
	}

	public final Upsert_clauseContext upsert_clause() throws RecognitionException {
		Upsert_clauseContext _localctx = new Upsert_clauseContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_upsert_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1167);
			match(ON);
			setState(1168);
			match(CONFLICT);
			setState(1183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(1169);
				match(OPEN_PAR);
				setState(1170);
				indexed_column();
				setState(1175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1171);
					match(COMMA);
					setState(1172);
					indexed_column();
					}
					}
					setState(1177);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1178);
				match(CLOSE_PAR);
				setState(1181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1179);
					match(WHERE);
					setState(1180);
					expr(0);
					}
				}

				}
			}

			setState(1185);
			match(DO);
			setState(1212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTHING:
				{
				setState(1186);
				match(NOTHING);
				}
				break;
			case UPDATE:
				{
				{
				setState(1187);
				match(UPDATE);
				setState(1188);
				match(SET);
				{
				setState(1191);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
				case 1:
					{
					setState(1189);
					column_name();
					}
					break;
				case 2:
					{
					setState(1190);
					column_name_list();
					}
					break;
				}
				setState(1193);
				match(EQ);
				setState(1194);
				expr(0);
				setState(1205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1195);
					match(COMMA);
					setState(1198);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
					case 1:
						{
						setState(1196);
						column_name();
						}
						break;
					case 2:
						{
						setState(1197);
						column_name_list();
						}
						break;
					}
					setState(1200);
					match(EQ);
					setState(1201);
					expr(0);
					}
					}
					setState(1207);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1208);
					match(WHERE);
					setState(1209);
					expr(0);
					}
				}

				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pragma_stmtContext extends ParserRuleContext {
		public TerminalNode PRAGMA() { return getToken(SQLiteParser.PRAGMA, 0); }
		public Pragma_nameContext pragma_name() {
			return getRuleContext(Pragma_nameContext.class,0);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode ASSIGN() { return getToken(SQLiteParser.ASSIGN, 0); }
		public Pragma_valueContext pragma_value() {
			return getRuleContext(Pragma_valueContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public Pragma_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_stmt; }
	}

	public final Pragma_stmtContext pragma_stmt() throws RecognitionException {
		Pragma_stmtContext _localctx = new Pragma_stmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_pragma_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1214);
			match(PRAGMA);
			setState(1218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
			case 1:
				{
				setState(1215);
				schema_name();
				setState(1216);
				match(DOT);
				}
				break;
			}
			setState(1220);
			pragma_name();
			setState(1227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				{
				setState(1221);
				match(ASSIGN);
				setState(1222);
				pragma_value();
				}
				break;
			case OPEN_PAR:
				{
				setState(1223);
				match(OPEN_PAR);
				setState(1224);
				pragma_value();
				setState(1225);
				match(CLOSE_PAR);
				}
				break;
			case EOF:
			case SCOL:
			case ALTER:
			case ANALYZE:
			case ATTACH:
			case BEGIN:
			case COMMIT:
			case CREATE:
			case DEFAULT:
			case DELETE:
			case DETACH:
			case DROP:
			case END:
			case EXPLAIN:
			case INSERT:
			case PRAGMA:
			case REINDEX:
			case RELEASE:
			case REPLACE:
			case ROLLBACK:
			case SAVEPOINT:
			case SELECT:
			case UPDATE:
			case VACUUM:
			case VALUES:
			case WITH:
			case UNEXPECTED_CHAR:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pragma_valueContext extends ParserRuleContext {
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public Pragma_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_value; }
	}

	public final Pragma_valueContext pragma_value() throws RecognitionException {
		Pragma_valueContext _localctx = new Pragma_valueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_pragma_value);
		try {
			setState(1232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1229);
				signed_number();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1230);
				name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1231);
				match(STRING_LITERAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Reindex_stmtContext extends ParserRuleContext {
		public TerminalNode REINDEX() { return getToken(SQLiteParser.REINDEX, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Reindex_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reindex_stmt; }
	}

	public final Reindex_stmtContext reindex_stmt() throws RecognitionException {
		Reindex_stmtContext _localctx = new Reindex_stmtContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_reindex_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1234);
			match(REINDEX);
			setState(1245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,161,_ctx) ) {
			case 1:
				{
				setState(1235);
				collation_name();
				}
				break;
			case 2:
				{
				{
				setState(1239);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
				case 1:
					{
					setState(1236);
					schema_name();
					setState(1237);
					match(DOT);
					}
					break;
				}
				setState(1243);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
				case 1:
					{
					setState(1241);
					table_name();
					}
					break;
				case 2:
					{
					setState(1242);
					index_name();
					}
					break;
				}
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_stmtContext extends ParserRuleContext {
		public List<Select_coreContext> select_core() {
			return getRuleContexts(Select_coreContext.class);
		}
		public Select_coreContext select_core(int i) {
			return getRuleContext(Select_coreContext.class,i);
		}
		public Common_table_stmtContext common_table_stmt() {
			return getRuleContext(Common_table_stmtContext.class,0);
		}
		public List<Compound_operatorContext> compound_operator() {
			return getRuleContexts(Compound_operatorContext.class);
		}
		public Compound_operatorContext compound_operator(int i) {
			return getRuleContext(Compound_operatorContext.class,i);
		}
		public Order_by_stmtContext order_by_stmt() {
			return getRuleContext(Order_by_stmtContext.class,0);
		}
		public Limit_stmtContext limit_stmt() {
			return getRuleContext(Limit_stmtContext.class,0);
		}
		public Select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_stmt; }
	}

	public final Select_stmtContext select_stmt() throws RecognitionException {
		Select_stmtContext _localctx = new Select_stmtContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_select_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1247);
				common_table_stmt();
				}
			}

			setState(1250);
			select_core();
			setState(1256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1251);
					compound_operator();
					setState(1252);
					select_core();
					}
					} 
				}
				setState(1258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			}
			setState(1260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(1259);
				order_by_stmt();
				}
			}

			setState(1263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(1262);
				limit_stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_clauseContext extends ParserRuleContext {
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public List<Join_operatorContext> join_operator() {
			return getRuleContexts(Join_operatorContext.class);
		}
		public Join_operatorContext join_operator(int i) {
			return getRuleContext(Join_operatorContext.class,i);
		}
		public List<Join_constraintContext> join_constraint() {
			return getRuleContexts(Join_constraintContext.class);
		}
		public Join_constraintContext join_constraint(int i) {
			return getRuleContext(Join_constraintContext.class,i);
		}
		public Join_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_clause; }
	}

	public final Join_clauseContext join_clause() throws RecognitionException {
		Join_clauseContext _localctx = new Join_clauseContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_join_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1265);
			table_or_subquery();
			setState(1273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA || _la==CROSS || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (INNER - 88)) | (1L << (JOIN - 88)) | (1L << (LEFT - 88)) | (1L << (NATURAL - 88)))) != 0)) {
				{
				{
				setState(1266);
				join_operator();
				setState(1267);
				table_or_subquery();
				setState(1269);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
				case 1:
					{
					setState(1268);
					join_constraint();
					}
					break;
				}
				}
				}
				setState(1275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_coreContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(SQLiteParser.SELECT, 0); }
		public List<Result_columnContext> result_column() {
			return getRuleContexts(Result_columnContext.class);
		}
		public Result_columnContext result_column(int i) {
			return getRuleContext(Result_columnContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode FROM() { return getToken(SQLiteParser.FROM, 0); }
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Group_by_clauseContext group_by_clause() {
			return getRuleContext(Group_by_clauseContext.class,0);
		}
		public TerminalNode WINDOW() { return getToken(SQLiteParser.WINDOW, 0); }
		public List<Window_nameContext> window_name() {
			return getRuleContexts(Window_nameContext.class);
		}
		public Window_nameContext window_name(int i) {
			return getRuleContext(Window_nameContext.class,i);
		}
		public List<TerminalNode> AS() { return getTokens(SQLiteParser.AS); }
		public TerminalNode AS(int i) {
			return getToken(SQLiteParser.AS, i);
		}
		public List<Window_defnContext> window_defn() {
			return getRuleContexts(Window_defnContext.class);
		}
		public Window_defnContext window_defn(int i) {
			return getRuleContext(Window_defnContext.class,i);
		}
		public TerminalNode DISTINCT() { return getToken(SQLiteParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(SQLiteParser.ALL, 0); }
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(SQLiteParser.VALUES, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public Select_coreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_core; }
	}

	public final Select_coreContext select_core() throws RecognitionException {
		Select_coreContext _localctx = new Select_coreContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_select_core);
		int _la;
		try {
			setState(1352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1276);
				match(SELECT);
				setState(1278);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
				case 1:
					{
					setState(1277);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(1280);
				result_column();
				setState(1285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1281);
					match(COMMA);
					setState(1282);
					result_column();
					}
					}
					setState(1287);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(1288);
					match(FROM);
					setState(1298);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
					case 1:
						{
						setState(1289);
						table_or_subquery();
						setState(1294);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1290);
							match(COMMA);
							setState(1291);
							table_or_subquery();
							}
							}
							setState(1296);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case 2:
						{
						setState(1297);
						join_clause();
						}
						break;
					}
					}
				}

				setState(1303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1302);
					where_clause();
					}
				}

				setState(1306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GROUP) {
					{
					setState(1305);
					group_by_clause();
					}
				}

				setState(1322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WINDOW) {
					{
					setState(1308);
					match(WINDOW);
					setState(1309);
					window_name();
					setState(1310);
					match(AS);
					setState(1311);
					window_defn();
					setState(1319);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1312);
						match(COMMA);
						setState(1313);
						window_name();
						setState(1314);
						match(AS);
						setState(1315);
						window_defn();
						}
						}
						setState(1321);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				}
				break;
			case VALUES:
				enterOuterAlt(_localctx, 2);
				{
				setState(1324);
				match(VALUES);
				setState(1325);
				match(OPEN_PAR);
				setState(1326);
				expr(0);
				setState(1331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1327);
					match(COMMA);
					setState(1328);
					expr(0);
					}
					}
					setState(1333);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1334);
				match(CLOSE_PAR);
				setState(1349);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1335);
					match(COMMA);
					setState(1336);
					match(OPEN_PAR);
					setState(1337);
					expr(0);
					setState(1342);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1338);
						match(COMMA);
						setState(1339);
						expr(0);
						}
						}
						setState(1344);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1345);
					match(CLOSE_PAR);
					}
					}
					setState(1351);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Where_clauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLiteParser.WHERE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1354);
			match(WHERE);
			setState(1355);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Group_by_clauseContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(SQLiteParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(SQLiteParser.BY, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Having_clauseContext having_clause() {
			return getRuleContext(Having_clauseContext.class,0);
		}
		public Group_by_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group_by_clause; }
	}

	public final Group_by_clauseContext group_by_clause() throws RecognitionException {
		Group_by_clauseContext _localctx = new Group_by_clauseContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_group_by_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1357);
			match(GROUP);
			setState(1358);
			match(BY);
			setState(1359);
			expr(0);
			setState(1364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1360);
				match(COMMA);
				setState(1361);
				expr(0);
				}
				}
				setState(1366);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(1367);
				having_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Having_clauseContext extends ParserRuleContext {
		public TerminalNode HAVING() { return getToken(SQLiteParser.HAVING, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Having_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_having_clause; }
	}

	public final Having_clauseContext having_clause() throws RecognitionException {
		Having_clauseContext _localctx = new Having_clauseContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1370);
			match(HAVING);
			setState(1371);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Factored_select_stmtContext extends ParserRuleContext {
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Factored_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factored_select_stmt; }
	}

	public final Factored_select_stmtContext factored_select_stmt() throws RecognitionException {
		Factored_select_stmtContext _localctx = new Factored_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_factored_select_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1373);
			select_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_select_stmtContext extends ParserRuleContext {
		public Select_coreContext select_core() {
			return getRuleContext(Select_coreContext.class,0);
		}
		public Common_table_stmtContext common_table_stmt() {
			return getRuleContext(Common_table_stmtContext.class,0);
		}
		public Order_by_stmtContext order_by_stmt() {
			return getRuleContext(Order_by_stmtContext.class,0);
		}
		public Limit_stmtContext limit_stmt() {
			return getRuleContext(Limit_stmtContext.class,0);
		}
		public Simple_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_select_stmt; }
	}

	public final Simple_select_stmtContext simple_select_stmt() throws RecognitionException {
		Simple_select_stmtContext _localctx = new Simple_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_simple_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1375);
				common_table_stmt();
				}
			}

			setState(1378);
			select_core();
			setState(1380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(1379);
				order_by_stmt();
				}
			}

			setState(1383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(1382);
				limit_stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_select_stmtContext extends ParserRuleContext {
		public List<Select_coreContext> select_core() {
			return getRuleContexts(Select_coreContext.class);
		}
		public Select_coreContext select_core(int i) {
			return getRuleContext(Select_coreContext.class,i);
		}
		public Common_table_stmtContext common_table_stmt() {
			return getRuleContext(Common_table_stmtContext.class,0);
		}
		public Order_by_stmtContext order_by_stmt() {
			return getRuleContext(Order_by_stmtContext.class,0);
		}
		public Limit_stmtContext limit_stmt() {
			return getRuleContext(Limit_stmtContext.class,0);
		}
		public List<TerminalNode> INTERSECT() { return getTokens(SQLiteParser.INTERSECT); }
		public TerminalNode INTERSECT(int i) {
			return getToken(SQLiteParser.INTERSECT, i);
		}
		public List<TerminalNode> EXCEPT() { return getTokens(SQLiteParser.EXCEPT); }
		public TerminalNode EXCEPT(int i) {
			return getToken(SQLiteParser.EXCEPT, i);
		}
		public List<TerminalNode> UNION() { return getTokens(SQLiteParser.UNION); }
		public TerminalNode UNION(int i) {
			return getToken(SQLiteParser.UNION, i);
		}
		public List<TerminalNode> ALL() { return getTokens(SQLiteParser.ALL); }
		public TerminalNode ALL(int i) {
			return getToken(SQLiteParser.ALL, i);
		}
		public Compound_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_select_stmt; }
	}

	public final Compound_select_stmtContext compound_select_stmt() throws RecognitionException {
		Compound_select_stmtContext _localctx = new Compound_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_compound_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1385);
				common_table_stmt();
				}
			}

			setState(1388);
			select_core();
			setState(1398); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1395);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case UNION:
					{
					{
					setState(1389);
					match(UNION);
					setState(1391);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL) {
						{
						setState(1390);
						match(ALL);
						}
					}

					}
					}
					break;
				case INTERSECT:
					{
					setState(1393);
					match(INTERSECT);
					}
					break;
				case EXCEPT:
					{
					setState(1394);
					match(EXCEPT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1397);
				select_core();
				}
				}
				setState(1400); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EXCEPT || _la==INTERSECT || _la==UNION );
			setState(1403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(1402);
				order_by_stmt();
				}
			}

			setState(1406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(1405);
				limit_stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_or_subqueryContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public TerminalNode INDEXED() { return getToken(SQLiteParser.INDEXED, 0); }
		public TerminalNode BY() { return getToken(SQLiteParser.BY, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLiteParser.NOT, 0); }
		public TerminalNode AS() { return getToken(SQLiteParser.AS, 0); }
		public Table_function_nameContext table_function_name() {
			return getRuleContext(Table_function_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Table_or_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_subquery; }
	}

	public final Table_or_subqueryContext table_or_subquery() throws RecognitionException {
		Table_or_subqueryContext _localctx = new Table_or_subqueryContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_table_or_subquery);
		int _la;
		try {
			setState(1472);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1411);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
				case 1:
					{
					setState(1408);
					schema_name();
					setState(1409);
					match(DOT);
					}
					break;
				}
				setState(1413);
				table_name();
				setState(1418);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
				case 1:
					{
					setState(1415);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
					case 1:
						{
						setState(1414);
						match(AS);
						}
						break;
					}
					setState(1417);
					table_alias();
					}
					break;
				}
				setState(1425);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INDEXED:
					{
					{
					setState(1420);
					match(INDEXED);
					setState(1421);
					match(BY);
					setState(1422);
					index_name();
					}
					}
					break;
				case NOT:
					{
					{
					setState(1423);
					match(NOT);
					setState(1424);
					match(INDEXED);
					}
					}
					break;
				case EOF:
				case SCOL:
				case CLOSE_PAR:
				case COMMA:
				case ALTER:
				case ANALYZE:
				case ATTACH:
				case BEGIN:
				case COMMIT:
				case CREATE:
				case CROSS:
				case DEFAULT:
				case DELETE:
				case DETACH:
				case DROP:
				case END:
				case EXCEPT:
				case EXPLAIN:
				case GROUP:
				case INNER:
				case INSERT:
				case INTERSECT:
				case JOIN:
				case LEFT:
				case LIMIT:
				case NATURAL:
				case ON:
				case ORDER:
				case PRAGMA:
				case REINDEX:
				case RELEASE:
				case REPLACE:
				case ROLLBACK:
				case SAVEPOINT:
				case SELECT:
				case UNION:
				case UPDATE:
				case USING:
				case VACUUM:
				case VALUES:
				case WHERE:
				case WITH:
				case WINDOW:
				case UNEXPECTED_CHAR:
					break;
				default:
					break;
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1430);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
				case 1:
					{
					setState(1427);
					schema_name();
					setState(1428);
					match(DOT);
					}
					break;
				}
				setState(1432);
				table_function_name();
				setState(1433);
				match(OPEN_PAR);
				setState(1434);
				expr(0);
				setState(1439);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1435);
					match(COMMA);
					setState(1436);
					expr(0);
					}
					}
					setState(1441);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1442);
				match(CLOSE_PAR);
				setState(1447);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
				case 1:
					{
					setState(1444);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
					case 1:
						{
						setState(1443);
						match(AS);
						}
						break;
					}
					setState(1446);
					table_alias();
					}
					break;
				}
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1449);
				match(OPEN_PAR);
				setState(1459);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
				case 1:
					{
					setState(1450);
					table_or_subquery();
					setState(1455);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1451);
						match(COMMA);
						setState(1452);
						table_or_subquery();
						}
						}
						setState(1457);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(1458);
					join_clause();
					}
					break;
				}
				setState(1461);
				match(CLOSE_PAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(1463);
				match(OPEN_PAR);
				setState(1464);
				select_stmt();
				setState(1465);
				match(CLOSE_PAR);
				setState(1470);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
				case 1:
					{
					setState(1467);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
					case 1:
						{
						setState(1466);
						match(AS);
						}
						break;
					}
					setState(1469);
					table_alias();
					}
					break;
				}
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Result_columnContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(SQLiteParser.STAR, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Column_aliasContext column_alias() {
			return getRuleContext(Column_aliasContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLiteParser.AS, 0); }
		public Result_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result_column; }
	}

	public final Result_columnContext result_column() throws RecognitionException {
		Result_columnContext _localctx = new Result_columnContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_result_column);
		int _la;
		try {
			setState(1486);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1474);
				match(STAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1475);
				table_name();
				setState(1476);
				match(DOT);
				setState(1477);
				match(STAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1479);
				expr(0);
				setState(1484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS || _la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(1481);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(1480);
						match(AS);
						}
					}

					setState(1483);
					column_alias();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_operatorContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public TerminalNode JOIN() { return getToken(SQLiteParser.JOIN, 0); }
		public TerminalNode NATURAL() { return getToken(SQLiteParser.NATURAL, 0); }
		public TerminalNode INNER() { return getToken(SQLiteParser.INNER, 0); }
		public TerminalNode CROSS() { return getToken(SQLiteParser.CROSS, 0); }
		public TerminalNode LEFT() { return getToken(SQLiteParser.LEFT, 0); }
		public TerminalNode OUTER() { return getToken(SQLiteParser.OUTER, 0); }
		public Join_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_operator; }
	}

	public final Join_operatorContext join_operator() throws RecognitionException {
		Join_operatorContext _localctx = new Join_operatorContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_join_operator);
		int _la;
		try {
			setState(1501);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(1488);
				match(COMMA);
				}
				break;
			case CROSS:
			case INNER:
			case JOIN:
			case LEFT:
			case NATURAL:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1490);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NATURAL) {
					{
					setState(1489);
					match(NATURAL);
					}
				}

				setState(1498);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFT:
					{
					{
					setState(1492);
					match(LEFT);
					setState(1494);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==OUTER) {
						{
						setState(1493);
						match(OUTER);
						}
					}

					}
					}
					break;
				case INNER:
					{
					setState(1496);
					match(INNER);
					}
					break;
				case CROSS:
					{
					setState(1497);
					match(CROSS);
					}
					break;
				case JOIN:
					break;
				default:
					break;
				}
				setState(1500);
				match(JOIN);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_constraintContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SQLiteParser.ON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode USING() { return getToken(SQLiteParser.USING, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Join_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_constraint; }
	}

	public final Join_constraintContext join_constraint() throws RecognitionException {
		Join_constraintContext _localctx = new Join_constraintContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_join_constraint);
		int _la;
		try {
			setState(1517);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1503);
				match(ON);
				setState(1504);
				expr(0);
				}
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1505);
				match(USING);
				setState(1506);
				match(OPEN_PAR);
				setState(1507);
				column_name();
				setState(1512);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1508);
					match(COMMA);
					setState(1509);
					column_name();
					}
					}
					setState(1514);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1515);
				match(CLOSE_PAR);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_operatorContext extends ParserRuleContext {
		public TerminalNode UNION() { return getToken(SQLiteParser.UNION, 0); }
		public TerminalNode ALL() { return getToken(SQLiteParser.ALL, 0); }
		public TerminalNode INTERSECT() { return getToken(SQLiteParser.INTERSECT, 0); }
		public TerminalNode EXCEPT() { return getToken(SQLiteParser.EXCEPT, 0); }
		public Compound_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_operator; }
	}

	public final Compound_operatorContext compound_operator() throws RecognitionException {
		Compound_operatorContext _localctx = new Compound_operatorContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_compound_operator);
		int _la;
		try {
			setState(1525);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNION:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1519);
				match(UNION);
				setState(1521);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL) {
					{
					setState(1520);
					match(ALL);
					}
				}

				}
				}
				break;
			case INTERSECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1523);
				match(INTERSECT);
				}
				break;
			case EXCEPT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1524);
				match(EXCEPT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_stmtContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(SQLiteParser.UPDATE, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public TerminalNode SET() { return getToken(SQLiteParser.SET, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(SQLiteParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SQLiteParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<Column_name_listContext> column_name_list() {
			return getRuleContexts(Column_name_listContext.class);
		}
		public Column_name_listContext column_name_list(int i) {
			return getRuleContext(Column_name_listContext.class,i);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode OR() { return getToken(SQLiteParser.OR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode WHERE() { return getToken(SQLiteParser.WHERE, 0); }
		public TerminalNode ROLLBACK() { return getToken(SQLiteParser.ROLLBACK, 0); }
		public TerminalNode ABORT() { return getToken(SQLiteParser.ABORT, 0); }
		public TerminalNode REPLACE() { return getToken(SQLiteParser.REPLACE, 0); }
		public TerminalNode FAIL() { return getToken(SQLiteParser.FAIL, 0); }
		public TerminalNode IGNORE() { return getToken(SQLiteParser.IGNORE, 0); }
		public Update_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_stmt; }
	}

	public final Update_stmtContext update_stmt() throws RecognitionException {
		Update_stmtContext _localctx = new Update_stmtContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_update_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1528);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1527);
				with_clause();
				}
			}

			setState(1530);
			match(UPDATE);
			setState(1533);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
			case 1:
				{
				setState(1531);
				match(OR);
				setState(1532);
				_la = _input.LA(1);
				if ( !(_la==ABORT || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (FAIL - 73)) | (1L << (IGNORE - 73)) | (1L << (REPLACE - 73)) | (1L << (ROLLBACK - 73)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(1535);
			qualified_table_name();
			setState(1536);
			match(SET);
			setState(1539);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,218,_ctx) ) {
			case 1:
				{
				setState(1537);
				column_name();
				}
				break;
			case 2:
				{
				setState(1538);
				column_name_list();
				}
				break;
			}
			setState(1541);
			match(ASSIGN);
			setState(1542);
			expr(0);
			setState(1553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1543);
				match(COMMA);
				setState(1546);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
				case 1:
					{
					setState(1544);
					column_name();
					}
					break;
				case 2:
					{
					setState(1545);
					column_name_list();
					}
					break;
				}
				setState(1548);
				match(ASSIGN);
				setState(1549);
				expr(0);
				}
				}
				setState(1555);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1556);
				match(WHERE);
				setState(1557);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_name_listContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Column_name_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name_list; }
	}

	public final Column_name_listContext column_name_list() throws RecognitionException {
		Column_name_listContext _localctx = new Column_name_listContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1560);
			match(OPEN_PAR);
			setState(1561);
			column_name();
			setState(1566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1562);
				match(COMMA);
				setState(1563);
				column_name();
				}
				}
				setState(1568);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1569);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_stmt_limitedContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(SQLiteParser.UPDATE, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public TerminalNode SET() { return getToken(SQLiteParser.SET, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(SQLiteParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SQLiteParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<Column_name_listContext> column_name_list() {
			return getRuleContexts(Column_name_listContext.class);
		}
		public Column_name_listContext column_name_list(int i) {
			return getRuleContext(Column_name_listContext.class,i);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode OR() { return getToken(SQLiteParser.OR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode WHERE() { return getToken(SQLiteParser.WHERE, 0); }
		public Limit_stmtContext limit_stmt() {
			return getRuleContext(Limit_stmtContext.class,0);
		}
		public TerminalNode ROLLBACK() { return getToken(SQLiteParser.ROLLBACK, 0); }
		public TerminalNode ABORT() { return getToken(SQLiteParser.ABORT, 0); }
		public TerminalNode REPLACE() { return getToken(SQLiteParser.REPLACE, 0); }
		public TerminalNode FAIL() { return getToken(SQLiteParser.FAIL, 0); }
		public TerminalNode IGNORE() { return getToken(SQLiteParser.IGNORE, 0); }
		public Order_by_stmtContext order_by_stmt() {
			return getRuleContext(Order_by_stmtContext.class,0);
		}
		public Update_stmt_limitedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_stmt_limited; }
	}

	public final Update_stmt_limitedContext update_stmt_limited() throws RecognitionException {
		Update_stmt_limitedContext _localctx = new Update_stmt_limitedContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_update_stmt_limited);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1571);
				with_clause();
				}
			}

			setState(1574);
			match(UPDATE);
			setState(1577);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,224,_ctx) ) {
			case 1:
				{
				setState(1575);
				match(OR);
				setState(1576);
				_la = _input.LA(1);
				if ( !(_la==ABORT || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (FAIL - 73)) | (1L << (IGNORE - 73)) | (1L << (REPLACE - 73)) | (1L << (ROLLBACK - 73)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(1579);
			qualified_table_name();
			setState(1580);
			match(SET);
			setState(1583);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
			case 1:
				{
				setState(1581);
				column_name();
				}
				break;
			case 2:
				{
				setState(1582);
				column_name_list();
				}
				break;
			}
			setState(1585);
			match(ASSIGN);
			setState(1586);
			expr(0);
			setState(1597);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1587);
				match(COMMA);
				setState(1590);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,226,_ctx) ) {
				case 1:
					{
					setState(1588);
					column_name();
					}
					break;
				case 2:
					{
					setState(1589);
					column_name_list();
					}
					break;
				}
				setState(1592);
				match(ASSIGN);
				setState(1593);
				expr(0);
				}
				}
				setState(1599);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1602);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1600);
				match(WHERE);
				setState(1601);
				expr(0);
				}
			}

			setState(1608);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT || _la==ORDER) {
				{
				setState(1605);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(1604);
					order_by_stmt();
					}
				}

				setState(1607);
				limit_stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Qualified_table_nameContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode AS() { return getToken(SQLiteParser.AS, 0); }
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public TerminalNode INDEXED() { return getToken(SQLiteParser.INDEXED, 0); }
		public TerminalNode BY() { return getToken(SQLiteParser.BY, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLiteParser.NOT, 0); }
		public Qualified_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_table_name; }
	}

	public final Qualified_table_nameContext qualified_table_name() throws RecognitionException {
		Qualified_table_nameContext _localctx = new Qualified_table_nameContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_qualified_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1613);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,231,_ctx) ) {
			case 1:
				{
				setState(1610);
				schema_name();
				setState(1611);
				match(DOT);
				}
				break;
			}
			setState(1615);
			table_name();
			setState(1618);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(1616);
				match(AS);
				setState(1617);
				alias();
				}
			}

			setState(1625);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INDEXED:
				{
				{
				setState(1620);
				match(INDEXED);
				setState(1621);
				match(BY);
				setState(1622);
				index_name();
				}
				}
				break;
			case NOT:
				{
				{
				setState(1623);
				match(NOT);
				setState(1624);
				match(INDEXED);
				}
				}
				break;
			case EOF:
			case SCOL:
			case ALTER:
			case ANALYZE:
			case ATTACH:
			case BEGIN:
			case COMMIT:
			case CREATE:
			case DEFAULT:
			case DELETE:
			case DETACH:
			case DROP:
			case END:
			case EXPLAIN:
			case INSERT:
			case LIMIT:
			case ORDER:
			case PRAGMA:
			case REINDEX:
			case RELEASE:
			case REPLACE:
			case ROLLBACK:
			case SAVEPOINT:
			case SELECT:
			case SET:
			case UPDATE:
			case VACUUM:
			case VALUES:
			case WHERE:
			case WITH:
			case UNEXPECTED_CHAR:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vacuum_stmtContext extends ParserRuleContext {
		public TerminalNode VACUUM() { return getToken(SQLiteParser.VACUUM, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode INTO() { return getToken(SQLiteParser.INTO, 0); }
		public FilenameContext filename() {
			return getRuleContext(FilenameContext.class,0);
		}
		public Vacuum_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vacuum_stmt; }
	}

	public final Vacuum_stmtContext vacuum_stmt() throws RecognitionException {
		Vacuum_stmtContext _localctx = new Vacuum_stmtContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_vacuum_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1627);
			match(VACUUM);
			setState(1629);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
			case 1:
				{
				setState(1628);
				schema_name();
				}
				break;
			}
			setState(1633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTO) {
				{
				setState(1631);
				match(INTO);
				setState(1632);
				filename();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Filter_clauseContext extends ParserRuleContext {
		public TerminalNode FILTER() { return getToken(SQLiteParser.FILTER, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode WHERE() { return getToken(SQLiteParser.WHERE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public Filter_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter_clause; }
	}

	public final Filter_clauseContext filter_clause() throws RecognitionException {
		Filter_clauseContext _localctx = new Filter_clauseContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1635);
			match(FILTER);
			setState(1636);
			match(OPEN_PAR);
			setState(1637);
			match(WHERE);
			setState(1638);
			expr(0);
			setState(1639);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Window_defnContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode ORDER() { return getToken(SQLiteParser.ORDER, 0); }
		public List<TerminalNode> BY() { return getTokens(SQLiteParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SQLiteParser.BY, i);
		}
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public Base_window_nameContext base_window_name() {
			return getRuleContext(Base_window_nameContext.class,0);
		}
		public TerminalNode PARTITION() { return getToken(SQLiteParser.PARTITION, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Frame_specContext frame_spec() {
			return getRuleContext(Frame_specContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Window_defnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_defn; }
	}

	public final Window_defnContext window_defn() throws RecognitionException {
		Window_defnContext _localctx = new Window_defnContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_window_defn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1641);
			match(OPEN_PAR);
			setState(1643);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
			case 1:
				{
				setState(1642);
				base_window_name();
				}
				break;
			}
			setState(1655);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTITION) {
				{
				setState(1645);
				match(PARTITION);
				setState(1646);
				match(BY);
				setState(1647);
				expr(0);
				setState(1652);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1648);
					match(COMMA);
					setState(1649);
					expr(0);
					}
					}
					setState(1654);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			{
			setState(1657);
			match(ORDER);
			setState(1658);
			match(BY);
			setState(1659);
			ordering_term();
			setState(1664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1660);
				match(COMMA);
				setState(1661);
				ordering_term();
				}
				}
				setState(1666);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(1668);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ROWS - 128)) | (1L << (RANGE - 128)) | (1L << (GROUPS - 128)))) != 0)) {
				{
				setState(1667);
				frame_spec();
				}
			}

			setState(1670);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Over_clauseContext extends ParserRuleContext {
		public TerminalNode OVER() { return getToken(SQLiteParser.OVER, 0); }
		public Window_nameContext window_name() {
			return getRuleContext(Window_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public Base_window_nameContext base_window_name() {
			return getRuleContext(Base_window_nameContext.class,0);
		}
		public TerminalNode PARTITION() { return getToken(SQLiteParser.PARTITION, 0); }
		public List<TerminalNode> BY() { return getTokens(SQLiteParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SQLiteParser.BY, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ORDER() { return getToken(SQLiteParser.ORDER, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public Frame_specContext frame_spec() {
			return getRuleContext(Frame_specContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Over_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_over_clause; }
	}

	public final Over_clauseContext over_clause() throws RecognitionException {
		Over_clauseContext _localctx = new Over_clauseContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_over_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1672);
			match(OVER);
			setState(1706);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,247,_ctx) ) {
			case 1:
				{
				setState(1673);
				window_name();
				}
				break;
			case 2:
				{
				{
				setState(1674);
				match(OPEN_PAR);
				setState(1676);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,241,_ctx) ) {
				case 1:
					{
					setState(1675);
					base_window_name();
					}
					break;
				}
				setState(1688);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1678);
					match(PARTITION);
					setState(1679);
					match(BY);
					setState(1680);
					expr(0);
					setState(1685);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1681);
						match(COMMA);
						setState(1682);
						expr(0);
						}
						}
						setState(1687);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(1690);
					match(ORDER);
					setState(1691);
					match(BY);
					setState(1692);
					ordering_term();
					setState(1697);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1693);
						match(COMMA);
						setState(1694);
						ordering_term();
						}
						}
						setState(1699);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1703);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ROWS - 128)) | (1L << (RANGE - 128)) | (1L << (GROUPS - 128)))) != 0)) {
					{
					setState(1702);
					frame_spec();
					}
				}

				setState(1705);
				match(CLOSE_PAR);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Frame_specContext extends ParserRuleContext {
		public Frame_clauseContext frame_clause() {
			return getRuleContext(Frame_clauseContext.class,0);
		}
		public TerminalNode EXCLUDE() { return getToken(SQLiteParser.EXCLUDE, 0); }
		public TerminalNode GROUP() { return getToken(SQLiteParser.GROUP, 0); }
		public TerminalNode TIES() { return getToken(SQLiteParser.TIES, 0); }
		public TerminalNode NO() { return getToken(SQLiteParser.NO, 0); }
		public TerminalNode OTHERS() { return getToken(SQLiteParser.OTHERS, 0); }
		public TerminalNode CURRENT() { return getToken(SQLiteParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SQLiteParser.ROW, 0); }
		public Frame_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame_spec; }
	}

	public final Frame_specContext frame_spec() throws RecognitionException {
		Frame_specContext _localctx = new Frame_specContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_frame_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1708);
			frame_clause();
			setState(1716);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXCLUDE:
				{
				setState(1709);
				match(EXCLUDE);
				{
				setState(1710);
				match(NO);
				setState(1711);
				match(OTHERS);
				}
				}
				break;
			case CURRENT:
				{
				{
				setState(1712);
				match(CURRENT);
				setState(1713);
				match(ROW);
				}
				}
				break;
			case GROUP:
				{
				setState(1714);
				match(GROUP);
				}
				break;
			case TIES:
				{
				setState(1715);
				match(TIES);
				}
				break;
			case CLOSE_PAR:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Frame_clauseContext extends ParserRuleContext {
		public TerminalNode RANGE() { return getToken(SQLiteParser.RANGE, 0); }
		public TerminalNode ROWS() { return getToken(SQLiteParser.ROWS, 0); }
		public TerminalNode GROUPS() { return getToken(SQLiteParser.GROUPS, 0); }
		public Frame_singleContext frame_single() {
			return getRuleContext(Frame_singleContext.class,0);
		}
		public TerminalNode BETWEEN() { return getToken(SQLiteParser.BETWEEN, 0); }
		public Frame_leftContext frame_left() {
			return getRuleContext(Frame_leftContext.class,0);
		}
		public TerminalNode AND() { return getToken(SQLiteParser.AND, 0); }
		public Frame_rightContext frame_right() {
			return getRuleContext(Frame_rightContext.class,0);
		}
		public Frame_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame_clause; }
	}

	public final Frame_clauseContext frame_clause() throws RecognitionException {
		Frame_clauseContext _localctx = new Frame_clauseContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_frame_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1718);
			_la = _input.LA(1);
			if ( !(((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ROWS - 128)) | (1L << (RANGE - 128)) | (1L << (GROUPS - 128)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1725);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,249,_ctx) ) {
			case 1:
				{
				setState(1719);
				frame_single();
				}
				break;
			case 2:
				{
				setState(1720);
				match(BETWEEN);
				setState(1721);
				frame_left();
				setState(1722);
				match(AND);
				setState(1723);
				frame_right();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_function_invocationContext extends ParserRuleContext {
		public Simple_funcContext simple_func() {
			return getRuleContext(Simple_funcContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode STAR() { return getToken(SQLiteParser.STAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Simple_function_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_function_invocation; }
	}

	public final Simple_function_invocationContext simple_function_invocation() throws RecognitionException {
		Simple_function_invocationContext _localctx = new Simple_function_invocationContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_simple_function_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1727);
			simple_func();
			setState(1728);
			match(OPEN_PAR);
			setState(1738);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR:
			case PLUS:
			case MINUS:
			case TILDE:
			case ABORT:
			case ACTION:
			case ADD:
			case AFTER:
			case ALL:
			case ALTER:
			case ANALYZE:
			case AND:
			case AS:
			case ASC:
			case ATTACH:
			case AUTOINCREMENT:
			case BEFORE:
			case BEGIN:
			case BETWEEN:
			case BY:
			case CASCADE:
			case CASE:
			case CAST:
			case CHECK:
			case COLLATE:
			case COLUMN:
			case COMMIT:
			case CONFLICT:
			case CONSTRAINT:
			case CREATE:
			case CROSS:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DATABASE:
			case DEFAULT:
			case DEFERRABLE:
			case DEFERRED:
			case DELETE:
			case DESC:
			case DETACH:
			case DISTINCT:
			case DROP:
			case EACH:
			case ELSE:
			case END:
			case ESCAPE:
			case EXCEPT:
			case EXCLUSIVE:
			case EXISTS:
			case EXPLAIN:
			case FAIL:
			case FOR:
			case FOREIGN:
			case FROM:
			case FULL:
			case GLOB:
			case GROUP:
			case HAVING:
			case IF:
			case IGNORE:
			case IMMEDIATE:
			case IN:
			case INDEX:
			case INDEXED:
			case INITIALLY:
			case INNER:
			case INSERT:
			case INSTEAD:
			case INTERSECT:
			case INTO:
			case IS:
			case ISNULL:
			case JOIN:
			case KEY:
			case LEFT:
			case LIKE:
			case LIMIT:
			case MATCH:
			case NATURAL:
			case NO:
			case NOT:
			case NOTNULL:
			case NULL_:
			case OF:
			case OFFSET:
			case ON:
			case OR:
			case ORDER:
			case OUTER:
			case PLAN:
			case PRAGMA:
			case PRIMARY:
			case QUERY:
			case RAISE:
			case RECURSIVE:
			case REFERENCES:
			case REGEXP:
			case REINDEX:
			case RELEASE:
			case RENAME:
			case REPLACE:
			case RESTRICT:
			case RIGHT:
			case ROLLBACK:
			case ROW:
			case ROWS:
			case SAVEPOINT:
			case SELECT:
			case SET:
			case TABLE:
			case TEMP:
			case TEMPORARY:
			case THEN:
			case TO:
			case TRANSACTION:
			case TRIGGER:
			case UNION:
			case UNIQUE:
			case UPDATE:
			case USING:
			case VACUUM:
			case VALUES:
			case VIEW:
			case VIRTUAL:
			case WHEN:
			case WHERE:
			case WITH:
			case WITHOUT:
			case FIRST_VALUE:
			case OVER:
			case PARTITION:
			case RANGE:
			case PRECEDING:
			case UNBOUNDED:
			case CURRENT:
			case FOLLOWING:
			case CUME_DIST:
			case DENSE_RANK:
			case LAG:
			case LAST_VALUE:
			case LEAD:
			case NTH_VALUE:
			case NTILE:
			case PERCENT_RANK:
			case RANK:
			case ROW_NUMBER:
			case GENERATED:
			case ALWAYS:
			case STORED:
			case TRUE_:
			case FALSE_:
			case WINDOW:
			case NULLS:
			case FIRST:
			case LAST:
			case FILTER:
			case GROUPS:
			case EXCLUDE:
			case IDENTIFIER:
			case NUMERIC_LITERAL:
			case REF_FIELD:
			case BIND_PARAMETER:
			case STRING_LITERAL:
			case BLOB_LITERAL:
				{
				{
				setState(1729);
				expr(0);
				setState(1734);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1730);
					match(COMMA);
					setState(1731);
					expr(0);
					}
					}
					setState(1736);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case STAR:
				{
				setState(1737);
				match(STAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1740);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aggregate_function_invocationContext extends ParserRuleContext {
		public Aggregate_funcContext aggregate_func() {
			return getRuleContext(Aggregate_funcContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode STAR() { return getToken(SQLiteParser.STAR, 0); }
		public Filter_clauseContext filter_clause() {
			return getRuleContext(Filter_clauseContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DISTINCT() { return getToken(SQLiteParser.DISTINCT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Aggregate_function_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate_function_invocation; }
	}

	public final Aggregate_function_invocationContext aggregate_function_invocation() throws RecognitionException {
		Aggregate_function_invocationContext _localctx = new Aggregate_function_invocationContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_aggregate_function_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1742);
			aggregate_func();
			setState(1743);
			match(OPEN_PAR);
			setState(1756);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR:
			case PLUS:
			case MINUS:
			case TILDE:
			case ABORT:
			case ACTION:
			case ADD:
			case AFTER:
			case ALL:
			case ALTER:
			case ANALYZE:
			case AND:
			case AS:
			case ASC:
			case ATTACH:
			case AUTOINCREMENT:
			case BEFORE:
			case BEGIN:
			case BETWEEN:
			case BY:
			case CASCADE:
			case CASE:
			case CAST:
			case CHECK:
			case COLLATE:
			case COLUMN:
			case COMMIT:
			case CONFLICT:
			case CONSTRAINT:
			case CREATE:
			case CROSS:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DATABASE:
			case DEFAULT:
			case DEFERRABLE:
			case DEFERRED:
			case DELETE:
			case DESC:
			case DETACH:
			case DISTINCT:
			case DROP:
			case EACH:
			case ELSE:
			case END:
			case ESCAPE:
			case EXCEPT:
			case EXCLUSIVE:
			case EXISTS:
			case EXPLAIN:
			case FAIL:
			case FOR:
			case FOREIGN:
			case FROM:
			case FULL:
			case GLOB:
			case GROUP:
			case HAVING:
			case IF:
			case IGNORE:
			case IMMEDIATE:
			case IN:
			case INDEX:
			case INDEXED:
			case INITIALLY:
			case INNER:
			case INSERT:
			case INSTEAD:
			case INTERSECT:
			case INTO:
			case IS:
			case ISNULL:
			case JOIN:
			case KEY:
			case LEFT:
			case LIKE:
			case LIMIT:
			case MATCH:
			case NATURAL:
			case NO:
			case NOT:
			case NOTNULL:
			case NULL_:
			case OF:
			case OFFSET:
			case ON:
			case OR:
			case ORDER:
			case OUTER:
			case PLAN:
			case PRAGMA:
			case PRIMARY:
			case QUERY:
			case RAISE:
			case RECURSIVE:
			case REFERENCES:
			case REGEXP:
			case REINDEX:
			case RELEASE:
			case RENAME:
			case REPLACE:
			case RESTRICT:
			case RIGHT:
			case ROLLBACK:
			case ROW:
			case ROWS:
			case SAVEPOINT:
			case SELECT:
			case SET:
			case TABLE:
			case TEMP:
			case TEMPORARY:
			case THEN:
			case TO:
			case TRANSACTION:
			case TRIGGER:
			case UNION:
			case UNIQUE:
			case UPDATE:
			case USING:
			case VACUUM:
			case VALUES:
			case VIEW:
			case VIRTUAL:
			case WHEN:
			case WHERE:
			case WITH:
			case WITHOUT:
			case FIRST_VALUE:
			case OVER:
			case PARTITION:
			case RANGE:
			case PRECEDING:
			case UNBOUNDED:
			case CURRENT:
			case FOLLOWING:
			case CUME_DIST:
			case DENSE_RANK:
			case LAG:
			case LAST_VALUE:
			case LEAD:
			case NTH_VALUE:
			case NTILE:
			case PERCENT_RANK:
			case RANK:
			case ROW_NUMBER:
			case GENERATED:
			case ALWAYS:
			case STORED:
			case TRUE_:
			case FALSE_:
			case WINDOW:
			case NULLS:
			case FIRST:
			case LAST:
			case FILTER:
			case GROUPS:
			case EXCLUDE:
			case IDENTIFIER:
			case NUMERIC_LITERAL:
			case REF_FIELD:
			case BIND_PARAMETER:
			case STRING_LITERAL:
			case BLOB_LITERAL:
				{
				{
				setState(1745);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
				case 1:
					{
					setState(1744);
					match(DISTINCT);
					}
					break;
				}
				setState(1747);
				expr(0);
				setState(1752);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1748);
					match(COMMA);
					setState(1749);
					expr(0);
					}
					}
					setState(1754);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case STAR:
				{
				setState(1755);
				match(STAR);
				}
				break;
			case CLOSE_PAR:
				break;
			default:
				break;
			}
			setState(1758);
			match(CLOSE_PAR);
			setState(1760);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FILTER) {
				{
				setState(1759);
				filter_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Window_function_invocationContext extends ParserRuleContext {
		public Window_functionContext window_function() {
			return getRuleContext(Window_functionContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode OVER() { return getToken(SQLiteParser.OVER, 0); }
		public Window_defnContext window_defn() {
			return getRuleContext(Window_defnContext.class,0);
		}
		public Window_nameContext window_name() {
			return getRuleContext(Window_nameContext.class,0);
		}
		public TerminalNode STAR() { return getToken(SQLiteParser.STAR, 0); }
		public Filter_clauseContext filter_clause() {
			return getRuleContext(Filter_clauseContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Window_function_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_function_invocation; }
	}

	public final Window_function_invocationContext window_function_invocation() throws RecognitionException {
		Window_function_invocationContext _localctx = new Window_function_invocationContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_window_function_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1762);
			window_function();
			setState(1763);
			match(OPEN_PAR);
			setState(1773);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR:
			case PLUS:
			case MINUS:
			case TILDE:
			case ABORT:
			case ACTION:
			case ADD:
			case AFTER:
			case ALL:
			case ALTER:
			case ANALYZE:
			case AND:
			case AS:
			case ASC:
			case ATTACH:
			case AUTOINCREMENT:
			case BEFORE:
			case BEGIN:
			case BETWEEN:
			case BY:
			case CASCADE:
			case CASE:
			case CAST:
			case CHECK:
			case COLLATE:
			case COLUMN:
			case COMMIT:
			case CONFLICT:
			case CONSTRAINT:
			case CREATE:
			case CROSS:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DATABASE:
			case DEFAULT:
			case DEFERRABLE:
			case DEFERRED:
			case DELETE:
			case DESC:
			case DETACH:
			case DISTINCT:
			case DROP:
			case EACH:
			case ELSE:
			case END:
			case ESCAPE:
			case EXCEPT:
			case EXCLUSIVE:
			case EXISTS:
			case EXPLAIN:
			case FAIL:
			case FOR:
			case FOREIGN:
			case FROM:
			case FULL:
			case GLOB:
			case GROUP:
			case HAVING:
			case IF:
			case IGNORE:
			case IMMEDIATE:
			case IN:
			case INDEX:
			case INDEXED:
			case INITIALLY:
			case INNER:
			case INSERT:
			case INSTEAD:
			case INTERSECT:
			case INTO:
			case IS:
			case ISNULL:
			case JOIN:
			case KEY:
			case LEFT:
			case LIKE:
			case LIMIT:
			case MATCH:
			case NATURAL:
			case NO:
			case NOT:
			case NOTNULL:
			case NULL_:
			case OF:
			case OFFSET:
			case ON:
			case OR:
			case ORDER:
			case OUTER:
			case PLAN:
			case PRAGMA:
			case PRIMARY:
			case QUERY:
			case RAISE:
			case RECURSIVE:
			case REFERENCES:
			case REGEXP:
			case REINDEX:
			case RELEASE:
			case RENAME:
			case REPLACE:
			case RESTRICT:
			case RIGHT:
			case ROLLBACK:
			case ROW:
			case ROWS:
			case SAVEPOINT:
			case SELECT:
			case SET:
			case TABLE:
			case TEMP:
			case TEMPORARY:
			case THEN:
			case TO:
			case TRANSACTION:
			case TRIGGER:
			case UNION:
			case UNIQUE:
			case UPDATE:
			case USING:
			case VACUUM:
			case VALUES:
			case VIEW:
			case VIRTUAL:
			case WHEN:
			case WHERE:
			case WITH:
			case WITHOUT:
			case FIRST_VALUE:
			case OVER:
			case PARTITION:
			case RANGE:
			case PRECEDING:
			case UNBOUNDED:
			case CURRENT:
			case FOLLOWING:
			case CUME_DIST:
			case DENSE_RANK:
			case LAG:
			case LAST_VALUE:
			case LEAD:
			case NTH_VALUE:
			case NTILE:
			case PERCENT_RANK:
			case RANK:
			case ROW_NUMBER:
			case GENERATED:
			case ALWAYS:
			case STORED:
			case TRUE_:
			case FALSE_:
			case WINDOW:
			case NULLS:
			case FIRST:
			case LAST:
			case FILTER:
			case GROUPS:
			case EXCLUDE:
			case IDENTIFIER:
			case NUMERIC_LITERAL:
			case REF_FIELD:
			case BIND_PARAMETER:
			case STRING_LITERAL:
			case BLOB_LITERAL:
				{
				{
				setState(1764);
				expr(0);
				setState(1769);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1765);
					match(COMMA);
					setState(1766);
					expr(0);
					}
					}
					setState(1771);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case STAR:
				{
				setState(1772);
				match(STAR);
				}
				break;
			case CLOSE_PAR:
				break;
			default:
				break;
			}
			setState(1775);
			match(CLOSE_PAR);
			setState(1777);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FILTER) {
				{
				setState(1776);
				filter_clause();
				}
			}

			setState(1779);
			match(OVER);
			setState(1782);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,259,_ctx) ) {
			case 1:
				{
				setState(1780);
				window_defn();
				}
				break;
			case 2:
				{
				setState(1781);
				window_name();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Common_table_stmtContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SQLiteParser.WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public TerminalNode RECURSIVE() { return getToken(SQLiteParser.RECURSIVE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Common_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_common_table_stmt; }
	}

	public final Common_table_stmtContext common_table_stmt() throws RecognitionException {
		Common_table_stmtContext _localctx = new Common_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_common_table_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1784);
			match(WITH);
			setState(1786);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,260,_ctx) ) {
			case 1:
				{
				setState(1785);
				match(RECURSIVE);
				}
				break;
			}
			setState(1788);
			common_table_expression();
			setState(1793);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1789);
				match(COMMA);
				setState(1790);
				common_table_expression();
				}
				}
				setState(1795);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Order_by_stmtContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(SQLiteParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SQLiteParser.BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Order_by_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_by_stmt; }
	}

	public final Order_by_stmtContext order_by_stmt() throws RecognitionException {
		Order_by_stmtContext _localctx = new Order_by_stmtContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_order_by_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1796);
			match(ORDER);
			setState(1797);
			match(BY);
			setState(1798);
			ordering_term();
			setState(1803);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1799);
				match(COMMA);
				setState(1800);
				ordering_term();
				}
				}
				setState(1805);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Limit_stmtContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(SQLiteParser.LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OFFSET() { return getToken(SQLiteParser.OFFSET, 0); }
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Limit_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit_stmt; }
	}

	public final Limit_stmtContext limit_stmt() throws RecognitionException {
		Limit_stmtContext _localctx = new Limit_stmtContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_limit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1806);
			match(LIMIT);
			setState(1807);
			expr(0);
			setState(1810);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA || _la==OFFSET) {
				{
				setState(1808);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==OFFSET) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1809);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ordering_termContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLLATE() { return getToken(SQLiteParser.COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Asc_descContext asc_desc() {
			return getRuleContext(Asc_descContext.class,0);
		}
		public TerminalNode NULLS() { return getToken(SQLiteParser.NULLS, 0); }
		public TerminalNode FIRST() { return getToken(SQLiteParser.FIRST, 0); }
		public TerminalNode LAST() { return getToken(SQLiteParser.LAST, 0); }
		public Ordering_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordering_term; }
	}

	public final Ordering_termContext ordering_term() throws RecognitionException {
		Ordering_termContext _localctx = new Ordering_termContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_ordering_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1812);
			expr(0);
			setState(1815);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLLATE) {
				{
				setState(1813);
				match(COLLATE);
				setState(1814);
				collation_name();
				}
			}

			setState(1818);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(1817);
				asc_desc();
				}
			}

			setState(1822);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULLS) {
				{
				setState(1820);
				match(NULLS);
				setState(1821);
				_la = _input.LA(1);
				if ( !(_la==FIRST || _la==LAST) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Asc_descContext extends ParserRuleContext {
		public TerminalNode ASC() { return getToken(SQLiteParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SQLiteParser.DESC, 0); }
		public Asc_descContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asc_desc; }
	}

	public final Asc_descContext asc_desc() throws RecognitionException {
		Asc_descContext _localctx = new Asc_descContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_asc_desc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1824);
			_la = _input.LA(1);
			if ( !(_la==ASC || _la==DESC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Frame_leftContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRECEDING() { return getToken(SQLiteParser.PRECEDING, 0); }
		public TerminalNode FOLLOWING() { return getToken(SQLiteParser.FOLLOWING, 0); }
		public TerminalNode CURRENT() { return getToken(SQLiteParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SQLiteParser.ROW, 0); }
		public TerminalNode UNBOUNDED() { return getToken(SQLiteParser.UNBOUNDED, 0); }
		public Frame_leftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame_left; }
	}

	public final Frame_leftContext frame_left() throws RecognitionException {
		Frame_leftContext _localctx = new Frame_leftContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_frame_left);
		try {
			setState(1836);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1826);
				expr(0);
				setState(1827);
				match(PRECEDING);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1829);
				expr(0);
				setState(1830);
				match(FOLLOWING);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1832);
				match(CURRENT);
				setState(1833);
				match(ROW);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(1834);
				match(UNBOUNDED);
				setState(1835);
				match(PRECEDING);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Frame_rightContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRECEDING() { return getToken(SQLiteParser.PRECEDING, 0); }
		public TerminalNode FOLLOWING() { return getToken(SQLiteParser.FOLLOWING, 0); }
		public TerminalNode CURRENT() { return getToken(SQLiteParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SQLiteParser.ROW, 0); }
		public TerminalNode UNBOUNDED() { return getToken(SQLiteParser.UNBOUNDED, 0); }
		public Frame_rightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame_right; }
	}

	public final Frame_rightContext frame_right() throws RecognitionException {
		Frame_rightContext _localctx = new Frame_rightContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_frame_right);
		try {
			setState(1848);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,268,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1838);
				expr(0);
				setState(1839);
				match(PRECEDING);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1841);
				expr(0);
				setState(1842);
				match(FOLLOWING);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1844);
				match(CURRENT);
				setState(1845);
				match(ROW);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(1846);
				match(UNBOUNDED);
				setState(1847);
				match(FOLLOWING);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Frame_singleContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRECEDING() { return getToken(SQLiteParser.PRECEDING, 0); }
		public TerminalNode UNBOUNDED() { return getToken(SQLiteParser.UNBOUNDED, 0); }
		public TerminalNode CURRENT() { return getToken(SQLiteParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SQLiteParser.ROW, 0); }
		public Frame_singleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame_single; }
	}

	public final Frame_singleContext frame_single() throws RecognitionException {
		Frame_singleContext _localctx = new Frame_singleContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_frame_single);
		try {
			setState(1857);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,269,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1850);
				expr(0);
				setState(1851);
				match(PRECEDING);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1853);
				match(UNBOUNDED);
				setState(1854);
				match(PRECEDING);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1855);
				match(CURRENT);
				setState(1856);
				match(ROW);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Window_functionContext extends ParserRuleContext {
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public TerminalNode OVER() { return getToken(SQLiteParser.OVER, 0); }
		public Order_by_expr_asc_descContext order_by_expr_asc_desc() {
			return getRuleContext(Order_by_expr_asc_descContext.class,0);
		}
		public TerminalNode FIRST_VALUE() { return getToken(SQLiteParser.FIRST_VALUE, 0); }
		public TerminalNode LAST_VALUE() { return getToken(SQLiteParser.LAST_VALUE, 0); }
		public Partition_byContext partition_by() {
			return getRuleContext(Partition_byContext.class,0);
		}
		public Frame_clauseContext frame_clause() {
			return getRuleContext(Frame_clauseContext.class,0);
		}
		public TerminalNode CUME_DIST() { return getToken(SQLiteParser.CUME_DIST, 0); }
		public TerminalNode PERCENT_RANK() { return getToken(SQLiteParser.PERCENT_RANK, 0); }
		public Order_by_exprContext order_by_expr() {
			return getRuleContext(Order_by_exprContext.class,0);
		}
		public TerminalNode DENSE_RANK() { return getToken(SQLiteParser.DENSE_RANK, 0); }
		public TerminalNode RANK() { return getToken(SQLiteParser.RANK, 0); }
		public TerminalNode ROW_NUMBER() { return getToken(SQLiteParser.ROW_NUMBER, 0); }
		public TerminalNode LAG() { return getToken(SQLiteParser.LAG, 0); }
		public TerminalNode LEAD() { return getToken(SQLiteParser.LEAD, 0); }
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public Default_valueContext default_value() {
			return getRuleContext(Default_valueContext.class,0);
		}
		public TerminalNode NTH_VALUE() { return getToken(SQLiteParser.NTH_VALUE, 0); }
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public TerminalNode NTILE() { return getToken(SQLiteParser.NTILE, 0); }
		public Window_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_function; }
	}

	public final Window_functionContext window_function() throws RecognitionException {
		Window_functionContext _localctx = new Window_functionContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_window_function);
		int _la;
		try {
			setState(1944);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FIRST_VALUE:
			case LAST_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1859);
				_la = _input.LA(1);
				if ( !(_la==FIRST_VALUE || _la==LAST_VALUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1860);
				match(OPEN_PAR);
				setState(1861);
				expr(0);
				setState(1862);
				match(CLOSE_PAR);
				setState(1863);
				match(OVER);
				setState(1864);
				match(OPEN_PAR);
				setState(1866);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1865);
					partition_by();
					}
				}

				setState(1868);
				order_by_expr_asc_desc();
				setState(1870);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ROWS - 128)) | (1L << (RANGE - 128)) | (1L << (GROUPS - 128)))) != 0)) {
					{
					setState(1869);
					frame_clause();
					}
				}

				setState(1872);
				match(CLOSE_PAR);
				}
				break;
			case CUME_DIST:
			case PERCENT_RANK:
				enterOuterAlt(_localctx, 2);
				{
				setState(1874);
				_la = _input.LA(1);
				if ( !(_la==CUME_DIST || _la==PERCENT_RANK) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1875);
				match(OPEN_PAR);
				setState(1876);
				match(CLOSE_PAR);
				setState(1877);
				match(OVER);
				setState(1878);
				match(OPEN_PAR);
				setState(1880);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1879);
					partition_by();
					}
				}

				setState(1883);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(1882);
					order_by_expr();
					}
				}

				setState(1885);
				match(CLOSE_PAR);
				}
				break;
			case DENSE_RANK:
			case RANK:
			case ROW_NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(1886);
				_la = _input.LA(1);
				if ( !(((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (DENSE_RANK - 160)) | (1L << (RANK - 160)) | (1L << (ROW_NUMBER - 160)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1887);
				match(OPEN_PAR);
				setState(1888);
				match(CLOSE_PAR);
				setState(1889);
				match(OVER);
				setState(1890);
				match(OPEN_PAR);
				setState(1892);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1891);
					partition_by();
					}
				}

				setState(1894);
				order_by_expr_asc_desc();
				setState(1895);
				match(CLOSE_PAR);
				}
				break;
			case LAG:
			case LEAD:
				enterOuterAlt(_localctx, 4);
				{
				setState(1897);
				_la = _input.LA(1);
				if ( !(_la==LAG || _la==LEAD) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1898);
				match(OPEN_PAR);
				setState(1899);
				expr(0);
				setState(1901);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
				case 1:
					{
					setState(1900);
					offset();
					}
					break;
				}
				setState(1904);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1903);
					default_value();
					}
				}

				setState(1906);
				match(CLOSE_PAR);
				setState(1907);
				match(OVER);
				setState(1908);
				match(OPEN_PAR);
				setState(1910);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1909);
					partition_by();
					}
				}

				setState(1912);
				order_by_expr_asc_desc();
				setState(1913);
				match(CLOSE_PAR);
				}
				break;
			case NTH_VALUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(1915);
				match(NTH_VALUE);
				setState(1916);
				match(OPEN_PAR);
				setState(1917);
				expr(0);
				setState(1918);
				match(COMMA);
				setState(1919);
				signed_number();
				setState(1920);
				match(CLOSE_PAR);
				setState(1921);
				match(OVER);
				setState(1922);
				match(OPEN_PAR);
				setState(1924);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1923);
					partition_by();
					}
				}

				setState(1926);
				order_by_expr_asc_desc();
				setState(1928);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ROWS - 128)) | (1L << (RANGE - 128)) | (1L << (GROUPS - 128)))) != 0)) {
					{
					setState(1927);
					frame_clause();
					}
				}

				setState(1930);
				match(CLOSE_PAR);
				}
				break;
			case NTILE:
				enterOuterAlt(_localctx, 6);
				{
				setState(1932);
				match(NTILE);
				setState(1933);
				match(OPEN_PAR);
				setState(1934);
				expr(0);
				setState(1935);
				match(CLOSE_PAR);
				setState(1936);
				match(OVER);
				setState(1937);
				match(OPEN_PAR);
				setState(1939);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1938);
					partition_by();
					}
				}

				setState(1941);
				order_by_expr_asc_desc();
				setState(1942);
				match(CLOSE_PAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OffsetContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public OffsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset; }
	}

	public final OffsetContext offset() throws RecognitionException {
		OffsetContext _localctx = new OffsetContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_offset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1946);
			match(COMMA);
			setState(1947);
			signed_number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Default_valueContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Default_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_value; }
	}

	public final Default_valueContext default_value() throws RecognitionException {
		Default_valueContext _localctx = new Default_valueContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_default_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1949);
			match(COMMA);
			setState(1950);
			signed_number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Partition_byContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SQLiteParser.PARTITION, 0); }
		public TerminalNode BY() { return getToken(SQLiteParser.BY, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Partition_byContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition_by; }
	}

	public final Partition_byContext partition_by() throws RecognitionException {
		Partition_byContext _localctx = new Partition_byContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_partition_by);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1952);
			match(PARTITION);
			setState(1953);
			match(BY);
			setState(1955); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1954);
					expr(0);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1957); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,282,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Order_by_exprContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(SQLiteParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SQLiteParser.BY, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Order_by_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_by_expr; }
	}

	public final Order_by_exprContext order_by_expr() throws RecognitionException {
		Order_by_exprContext _localctx = new Order_by_exprContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_order_by_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1959);
			match(ORDER);
			setState(1960);
			match(BY);
			setState(1962); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1961);
				expr(0);
				}
				}
				setState(1964); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAR) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << ABORT) | (1L << ACTION) | (1L << ADD) | (1L << AFTER) | (1L << ALL) | (1L << ALTER) | (1L << ANALYZE) | (1L << AND) | (1L << AS) | (1L << ASC) | (1L << ATTACH) | (1L << AUTOINCREMENT) | (1L << BEFORE) | (1L << BEGIN) | (1L << BETWEEN) | (1L << BY) | (1L << CASCADE) | (1L << CASE) | (1L << CAST) | (1L << CHECK) | (1L << COLLATE) | (1L << COLUMN) | (1L << COMMIT) | (1L << CONFLICT) | (1L << CONSTRAINT) | (1L << CREATE) | (1L << CROSS) | (1L << CURRENT_DATE) | (1L << CURRENT_TIME) | (1L << CURRENT_TIMESTAMP) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DETACH) | (1L << DISTINCT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DROP - 64)) | (1L << (EACH - 64)) | (1L << (ELSE - 64)) | (1L << (END - 64)) | (1L << (ESCAPE - 64)) | (1L << (EXCEPT - 64)) | (1L << (EXCLUSIVE - 64)) | (1L << (EXISTS - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FAIL - 64)) | (1L << (FOR - 64)) | (1L << (FOREIGN - 64)) | (1L << (FROM - 64)) | (1L << (FULL - 64)) | (1L << (GLOB - 64)) | (1L << (GROUP - 64)) | (1L << (HAVING - 64)) | (1L << (IF - 64)) | (1L << (IGNORE - 64)) | (1L << (IMMEDIATE - 64)) | (1L << (IN - 64)) | (1L << (INDEX - 64)) | (1L << (INDEXED - 64)) | (1L << (INITIALLY - 64)) | (1L << (INNER - 64)) | (1L << (INSERT - 64)) | (1L << (INSTEAD - 64)) | (1L << (INTERSECT - 64)) | (1L << (INTO - 64)) | (1L << (IS - 64)) | (1L << (ISNULL - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (MATCH - 64)) | (1L << (NATURAL - 64)) | (1L << (NO - 64)) | (1L << (NOT - 64)) | (1L << (NOTNULL - 64)) | (1L << (NULL_ - 64)) | (1L << (OF - 64)) | (1L << (OFFSET - 64)) | (1L << (ON - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OUTER - 64)) | (1L << (PLAN - 64)) | (1L << (PRAGMA - 64)) | (1L << (PRIMARY - 64)) | (1L << (QUERY - 64)) | (1L << (RAISE - 64)) | (1L << (RECURSIVE - 64)) | (1L << (REFERENCES - 64)) | (1L << (REGEXP - 64)) | (1L << (REINDEX - 64)) | (1L << (RELEASE - 64)) | (1L << (RENAME - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RIGHT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (ROW - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ROWS - 128)) | (1L << (SAVEPOINT - 128)) | (1L << (SELECT - 128)) | (1L << (SET - 128)) | (1L << (TABLE - 128)) | (1L << (TEMP - 128)) | (1L << (TEMPORARY - 128)) | (1L << (THEN - 128)) | (1L << (TO - 128)) | (1L << (TRANSACTION - 128)) | (1L << (TRIGGER - 128)) | (1L << (UNION - 128)) | (1L << (UNIQUE - 128)) | (1L << (UPDATE - 128)) | (1L << (USING - 128)) | (1L << (VACUUM - 128)) | (1L << (VALUES - 128)) | (1L << (VIEW - 128)) | (1L << (VIRTUAL - 128)) | (1L << (WHEN - 128)) | (1L << (WHERE - 128)) | (1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (FIRST_VALUE - 128)) | (1L << (OVER - 128)) | (1L << (PARTITION - 128)) | (1L << (RANGE - 128)) | (1L << (PRECEDING - 128)) | (1L << (UNBOUNDED - 128)) | (1L << (CURRENT - 128)) | (1L << (FOLLOWING - 128)) | (1L << (CUME_DIST - 128)) | (1L << (DENSE_RANK - 128)) | (1L << (LAG - 128)) | (1L << (LAST_VALUE - 128)) | (1L << (LEAD - 128)) | (1L << (NTH_VALUE - 128)) | (1L << (NTILE - 128)) | (1L << (PERCENT_RANK - 128)) | (1L << (RANK - 128)) | (1L << (ROW_NUMBER - 128)) | (1L << (GENERATED - 128)) | (1L << (ALWAYS - 128)) | (1L << (STORED - 128)) | (1L << (TRUE_ - 128)) | (1L << (FALSE_ - 128)) | (1L << (WINDOW - 128)) | (1L << (NULLS - 128)) | (1L << (FIRST - 128)) | (1L << (LAST - 128)) | (1L << (FILTER - 128)) | (1L << (GROUPS - 128)) | (1L << (EXCLUDE - 128)) | (1L << (IDENTIFIER - 128)) | (1L << (NUMERIC_LITERAL - 128)) | (1L << (REF_FIELD - 128)) | (1L << (BIND_PARAMETER - 128)) | (1L << (STRING_LITERAL - 128)) | (1L << (BLOB_LITERAL - 128)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Order_by_expr_asc_descContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(SQLiteParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SQLiteParser.BY, 0); }
		public Order_by_expr_asc_descContext order_by_expr_asc_desc() {
			return getRuleContext(Order_by_expr_asc_descContext.class,0);
		}
		public Order_by_expr_asc_descContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_by_expr_asc_desc; }
	}

	public final Order_by_expr_asc_descContext order_by_expr_asc_desc() throws RecognitionException {
		Order_by_expr_asc_descContext _localctx = new Order_by_expr_asc_descContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_order_by_expr_asc_desc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1966);
			match(ORDER);
			setState(1967);
			match(BY);
			setState(1968);
			order_by_expr_asc_desc();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_asc_descContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<Asc_descContext> asc_desc() {
			return getRuleContexts(Asc_descContext.class);
		}
		public Asc_descContext asc_desc(int i) {
			return getRuleContext(Asc_descContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Expr_asc_descContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_asc_desc; }
	}

	public final Expr_asc_descContext expr_asc_desc() throws RecognitionException {
		Expr_asc_descContext _localctx = new Expr_asc_descContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_expr_asc_desc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1970);
			expr(0);
			setState(1972);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(1971);
				asc_desc();
				}
			}

			setState(1981);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1974);
				match(COMMA);
				setState(1975);
				expr(0);
				setState(1977);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASC || _la==DESC) {
					{
					setState(1976);
					asc_desc();
					}
				}

				}
				}
				setState(1983);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Initial_selectContext extends ParserRuleContext {
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Initial_selectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial_select; }
	}

	public final Initial_selectContext initial_select() throws RecognitionException {
		Initial_selectContext _localctx = new Initial_selectContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_initial_select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1984);
			select_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Recursive_selectContext extends ParserRuleContext {
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Recursive_selectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recursive_select; }
	}

	public final Recursive_selectContext recursive_select() throws RecognitionException {
		Recursive_selectContext _localctx = new Recursive_selectContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_recursive_select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1986);
			select_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SQLiteParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SQLiteParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(SQLiteParser.TILDE, 0); }
		public TerminalNode NOT() { return getToken(SQLiteParser.NOT, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1988);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << TILDE))) != 0) || _la==NOT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Error_messageContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public Error_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error_message; }
	}

	public final Error_messageContext error_message() throws RecognitionException {
		Error_messageContext _localctx = new Error_messageContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_error_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1990);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Module_argumentContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Column_defContext column_def() {
			return getRuleContext(Column_defContext.class,0);
		}
		public Module_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_argument; }
	}

	public final Module_argumentContext module_argument() throws RecognitionException {
		Module_argumentContext _localctx = new Module_argumentContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_module_argument);
		try {
			setState(1994);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,287,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1992);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1993);
				column_def();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_aliasContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLiteParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public Column_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_alias; }
	}

	public final Column_aliasContext column_alias() throws RecognitionException {
		Column_aliasContext _localctx = new Column_aliasContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_column_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1996);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode ABORT() { return getToken(SQLiteParser.ABORT, 0); }
		public TerminalNode ACTION() { return getToken(SQLiteParser.ACTION, 0); }
		public TerminalNode ADD() { return getToken(SQLiteParser.ADD, 0); }
		public TerminalNode AFTER() { return getToken(SQLiteParser.AFTER, 0); }
		public TerminalNode ALL() { return getToken(SQLiteParser.ALL, 0); }
		public TerminalNode ALTER() { return getToken(SQLiteParser.ALTER, 0); }
		public TerminalNode ANALYZE() { return getToken(SQLiteParser.ANALYZE, 0); }
		public TerminalNode AND() { return getToken(SQLiteParser.AND, 0); }
		public TerminalNode AS() { return getToken(SQLiteParser.AS, 0); }
		public TerminalNode ASC() { return getToken(SQLiteParser.ASC, 0); }
		public TerminalNode ATTACH() { return getToken(SQLiteParser.ATTACH, 0); }
		public TerminalNode AUTOINCREMENT() { return getToken(SQLiteParser.AUTOINCREMENT, 0); }
		public TerminalNode BEFORE() { return getToken(SQLiteParser.BEFORE, 0); }
		public TerminalNode BEGIN() { return getToken(SQLiteParser.BEGIN, 0); }
		public TerminalNode BETWEEN() { return getToken(SQLiteParser.BETWEEN, 0); }
		public TerminalNode BY() { return getToken(SQLiteParser.BY, 0); }
		public TerminalNode CASCADE() { return getToken(SQLiteParser.CASCADE, 0); }
		public TerminalNode CASE() { return getToken(SQLiteParser.CASE, 0); }
		public TerminalNode CAST() { return getToken(SQLiteParser.CAST, 0); }
		public TerminalNode CHECK() { return getToken(SQLiteParser.CHECK, 0); }
		public TerminalNode COLLATE() { return getToken(SQLiteParser.COLLATE, 0); }
		public TerminalNode COLUMN() { return getToken(SQLiteParser.COLUMN, 0); }
		public TerminalNode COMMIT() { return getToken(SQLiteParser.COMMIT, 0); }
		public TerminalNode CONFLICT() { return getToken(SQLiteParser.CONFLICT, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLiteParser.CONSTRAINT, 0); }
		public TerminalNode CREATE() { return getToken(SQLiteParser.CREATE, 0); }
		public TerminalNode CROSS() { return getToken(SQLiteParser.CROSS, 0); }
		public TerminalNode CURRENT_DATE() { return getToken(SQLiteParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIME() { return getToken(SQLiteParser.CURRENT_TIME, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SQLiteParser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode DATABASE() { return getToken(SQLiteParser.DATABASE, 0); }
		public TerminalNode DEFAULT() { return getToken(SQLiteParser.DEFAULT, 0); }
		public TerminalNode DEFERRABLE() { return getToken(SQLiteParser.DEFERRABLE, 0); }
		public TerminalNode DEFERRED() { return getToken(SQLiteParser.DEFERRED, 0); }
		public TerminalNode DELETE() { return getToken(SQLiteParser.DELETE, 0); }
		public TerminalNode DESC() { return getToken(SQLiteParser.DESC, 0); }
		public TerminalNode DETACH() { return getToken(SQLiteParser.DETACH, 0); }
		public TerminalNode DISTINCT() { return getToken(SQLiteParser.DISTINCT, 0); }
		public TerminalNode DROP() { return getToken(SQLiteParser.DROP, 0); }
		public TerminalNode EACH() { return getToken(SQLiteParser.EACH, 0); }
		public TerminalNode ELSE() { return getToken(SQLiteParser.ELSE, 0); }
		public TerminalNode END() { return getToken(SQLiteParser.END, 0); }
		public TerminalNode ESCAPE() { return getToken(SQLiteParser.ESCAPE, 0); }
		public TerminalNode EXCEPT() { return getToken(SQLiteParser.EXCEPT, 0); }
		public TerminalNode EXCLUSIVE() { return getToken(SQLiteParser.EXCLUSIVE, 0); }
		public TerminalNode EXISTS() { return getToken(SQLiteParser.EXISTS, 0); }
		public TerminalNode EXPLAIN() { return getToken(SQLiteParser.EXPLAIN, 0); }
		public TerminalNode FAIL() { return getToken(SQLiteParser.FAIL, 0); }
		public TerminalNode FOR() { return getToken(SQLiteParser.FOR, 0); }
		public TerminalNode FOREIGN() { return getToken(SQLiteParser.FOREIGN, 0); }
		public TerminalNode FROM() { return getToken(SQLiteParser.FROM, 0); }
		public TerminalNode FULL() { return getToken(SQLiteParser.FULL, 0); }
		public TerminalNode GLOB() { return getToken(SQLiteParser.GLOB, 0); }
		public TerminalNode GROUP() { return getToken(SQLiteParser.GROUP, 0); }
		public TerminalNode HAVING() { return getToken(SQLiteParser.HAVING, 0); }
		public TerminalNode IF() { return getToken(SQLiteParser.IF, 0); }
		public TerminalNode IGNORE() { return getToken(SQLiteParser.IGNORE, 0); }
		public TerminalNode IMMEDIATE() { return getToken(SQLiteParser.IMMEDIATE, 0); }
		public TerminalNode IN() { return getToken(SQLiteParser.IN, 0); }
		public TerminalNode INDEX() { return getToken(SQLiteParser.INDEX, 0); }
		public TerminalNode INDEXED() { return getToken(SQLiteParser.INDEXED, 0); }
		public TerminalNode INITIALLY() { return getToken(SQLiteParser.INITIALLY, 0); }
		public TerminalNode INNER() { return getToken(SQLiteParser.INNER, 0); }
		public TerminalNode INSERT() { return getToken(SQLiteParser.INSERT, 0); }
		public TerminalNode INSTEAD() { return getToken(SQLiteParser.INSTEAD, 0); }
		public TerminalNode INTERSECT() { return getToken(SQLiteParser.INTERSECT, 0); }
		public TerminalNode INTO() { return getToken(SQLiteParser.INTO, 0); }
		public TerminalNode IS() { return getToken(SQLiteParser.IS, 0); }
		public TerminalNode ISNULL() { return getToken(SQLiteParser.ISNULL, 0); }
		public TerminalNode JOIN() { return getToken(SQLiteParser.JOIN, 0); }
		public TerminalNode KEY() { return getToken(SQLiteParser.KEY, 0); }
		public TerminalNode LEFT() { return getToken(SQLiteParser.LEFT, 0); }
		public TerminalNode LIKE() { return getToken(SQLiteParser.LIKE, 0); }
		public TerminalNode LIMIT() { return getToken(SQLiteParser.LIMIT, 0); }
		public TerminalNode MATCH() { return getToken(SQLiteParser.MATCH, 0); }
		public TerminalNode NATURAL() { return getToken(SQLiteParser.NATURAL, 0); }
		public TerminalNode NO() { return getToken(SQLiteParser.NO, 0); }
		public TerminalNode NOT() { return getToken(SQLiteParser.NOT, 0); }
		public TerminalNode NOTNULL() { return getToken(SQLiteParser.NOTNULL, 0); }
		public TerminalNode NULL_() { return getToken(SQLiteParser.NULL_, 0); }
		public TerminalNode OF() { return getToken(SQLiteParser.OF, 0); }
		public TerminalNode OFFSET() { return getToken(SQLiteParser.OFFSET, 0); }
		public TerminalNode ON() { return getToken(SQLiteParser.ON, 0); }
		public TerminalNode OR() { return getToken(SQLiteParser.OR, 0); }
		public TerminalNode ORDER() { return getToken(SQLiteParser.ORDER, 0); }
		public TerminalNode OUTER() { return getToken(SQLiteParser.OUTER, 0); }
		public TerminalNode PLAN() { return getToken(SQLiteParser.PLAN, 0); }
		public TerminalNode PRAGMA() { return getToken(SQLiteParser.PRAGMA, 0); }
		public TerminalNode PRIMARY() { return getToken(SQLiteParser.PRIMARY, 0); }
		public TerminalNode QUERY() { return getToken(SQLiteParser.QUERY, 0); }
		public TerminalNode RAISE() { return getToken(SQLiteParser.RAISE, 0); }
		public TerminalNode RECURSIVE() { return getToken(SQLiteParser.RECURSIVE, 0); }
		public TerminalNode REFERENCES() { return getToken(SQLiteParser.REFERENCES, 0); }
		public TerminalNode REGEXP() { return getToken(SQLiteParser.REGEXP, 0); }
		public TerminalNode REINDEX() { return getToken(SQLiteParser.REINDEX, 0); }
		public TerminalNode RELEASE() { return getToken(SQLiteParser.RELEASE, 0); }
		public TerminalNode RENAME() { return getToken(SQLiteParser.RENAME, 0); }
		public TerminalNode REPLACE() { return getToken(SQLiteParser.REPLACE, 0); }
		public TerminalNode RESTRICT() { return getToken(SQLiteParser.RESTRICT, 0); }
		public TerminalNode RIGHT() { return getToken(SQLiteParser.RIGHT, 0); }
		public TerminalNode ROLLBACK() { return getToken(SQLiteParser.ROLLBACK, 0); }
		public TerminalNode ROW() { return getToken(SQLiteParser.ROW, 0); }
		public TerminalNode ROWS() { return getToken(SQLiteParser.ROWS, 0); }
		public TerminalNode SAVEPOINT() { return getToken(SQLiteParser.SAVEPOINT, 0); }
		public TerminalNode SELECT() { return getToken(SQLiteParser.SELECT, 0); }
		public TerminalNode SET() { return getToken(SQLiteParser.SET, 0); }
		public TerminalNode TABLE() { return getToken(SQLiteParser.TABLE, 0); }
		public TerminalNode TEMP() { return getToken(SQLiteParser.TEMP, 0); }
		public TerminalNode TEMPORARY() { return getToken(SQLiteParser.TEMPORARY, 0); }
		public TerminalNode THEN() { return getToken(SQLiteParser.THEN, 0); }
		public TerminalNode TO() { return getToken(SQLiteParser.TO, 0); }
		public TerminalNode TRANSACTION() { return getToken(SQLiteParser.TRANSACTION, 0); }
		public TerminalNode TRIGGER() { return getToken(SQLiteParser.TRIGGER, 0); }
		public TerminalNode UNION() { return getToken(SQLiteParser.UNION, 0); }
		public TerminalNode UNIQUE() { return getToken(SQLiteParser.UNIQUE, 0); }
		public TerminalNode UPDATE() { return getToken(SQLiteParser.UPDATE, 0); }
		public TerminalNode USING() { return getToken(SQLiteParser.USING, 0); }
		public TerminalNode VACUUM() { return getToken(SQLiteParser.VACUUM, 0); }
		public TerminalNode VALUES() { return getToken(SQLiteParser.VALUES, 0); }
		public TerminalNode VIEW() { return getToken(SQLiteParser.VIEW, 0); }
		public TerminalNode VIRTUAL() { return getToken(SQLiteParser.VIRTUAL, 0); }
		public TerminalNode WHEN() { return getToken(SQLiteParser.WHEN, 0); }
		public TerminalNode WHERE() { return getToken(SQLiteParser.WHERE, 0); }
		public TerminalNode WITH() { return getToken(SQLiteParser.WITH, 0); }
		public TerminalNode WITHOUT() { return getToken(SQLiteParser.WITHOUT, 0); }
		public TerminalNode FIRST_VALUE() { return getToken(SQLiteParser.FIRST_VALUE, 0); }
		public TerminalNode OVER() { return getToken(SQLiteParser.OVER, 0); }
		public TerminalNode PARTITION() { return getToken(SQLiteParser.PARTITION, 0); }
		public TerminalNode RANGE() { return getToken(SQLiteParser.RANGE, 0); }
		public TerminalNode PRECEDING() { return getToken(SQLiteParser.PRECEDING, 0); }
		public TerminalNode UNBOUNDED() { return getToken(SQLiteParser.UNBOUNDED, 0); }
		public TerminalNode CURRENT() { return getToken(SQLiteParser.CURRENT, 0); }
		public TerminalNode FOLLOWING() { return getToken(SQLiteParser.FOLLOWING, 0); }
		public TerminalNode CUME_DIST() { return getToken(SQLiteParser.CUME_DIST, 0); }
		public TerminalNode DENSE_RANK() { return getToken(SQLiteParser.DENSE_RANK, 0); }
		public TerminalNode LAG() { return getToken(SQLiteParser.LAG, 0); }
		public TerminalNode LAST_VALUE() { return getToken(SQLiteParser.LAST_VALUE, 0); }
		public TerminalNode LEAD() { return getToken(SQLiteParser.LEAD, 0); }
		public TerminalNode NTH_VALUE() { return getToken(SQLiteParser.NTH_VALUE, 0); }
		public TerminalNode NTILE() { return getToken(SQLiteParser.NTILE, 0); }
		public TerminalNode PERCENT_RANK() { return getToken(SQLiteParser.PERCENT_RANK, 0); }
		public TerminalNode RANK() { return getToken(SQLiteParser.RANK, 0); }
		public TerminalNode ROW_NUMBER() { return getToken(SQLiteParser.ROW_NUMBER, 0); }
		public TerminalNode GENERATED() { return getToken(SQLiteParser.GENERATED, 0); }
		public TerminalNode ALWAYS() { return getToken(SQLiteParser.ALWAYS, 0); }
		public TerminalNode STORED() { return getToken(SQLiteParser.STORED, 0); }
		public TerminalNode TRUE_() { return getToken(SQLiteParser.TRUE_, 0); }
		public TerminalNode FALSE_() { return getToken(SQLiteParser.FALSE_, 0); }
		public TerminalNode WINDOW() { return getToken(SQLiteParser.WINDOW, 0); }
		public TerminalNode NULLS() { return getToken(SQLiteParser.NULLS, 0); }
		public TerminalNode FIRST() { return getToken(SQLiteParser.FIRST, 0); }
		public TerminalNode LAST() { return getToken(SQLiteParser.LAST, 0); }
		public TerminalNode FILTER() { return getToken(SQLiteParser.FILTER, 0); }
		public TerminalNode GROUPS() { return getToken(SQLiteParser.GROUPS, 0); }
		public TerminalNode EXCLUDE() { return getToken(SQLiteParser.EXCLUDE, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1998);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABORT) | (1L << ACTION) | (1L << ADD) | (1L << AFTER) | (1L << ALL) | (1L << ALTER) | (1L << ANALYZE) | (1L << AND) | (1L << AS) | (1L << ASC) | (1L << ATTACH) | (1L << AUTOINCREMENT) | (1L << BEFORE) | (1L << BEGIN) | (1L << BETWEEN) | (1L << BY) | (1L << CASCADE) | (1L << CASE) | (1L << CAST) | (1L << CHECK) | (1L << COLLATE) | (1L << COLUMN) | (1L << COMMIT) | (1L << CONFLICT) | (1L << CONSTRAINT) | (1L << CREATE) | (1L << CROSS) | (1L << CURRENT_DATE) | (1L << CURRENT_TIME) | (1L << CURRENT_TIMESTAMP) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DETACH) | (1L << DISTINCT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DROP - 64)) | (1L << (EACH - 64)) | (1L << (ELSE - 64)) | (1L << (END - 64)) | (1L << (ESCAPE - 64)) | (1L << (EXCEPT - 64)) | (1L << (EXCLUSIVE - 64)) | (1L << (EXISTS - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FAIL - 64)) | (1L << (FOR - 64)) | (1L << (FOREIGN - 64)) | (1L << (FROM - 64)) | (1L << (FULL - 64)) | (1L << (GLOB - 64)) | (1L << (GROUP - 64)) | (1L << (HAVING - 64)) | (1L << (IF - 64)) | (1L << (IGNORE - 64)) | (1L << (IMMEDIATE - 64)) | (1L << (IN - 64)) | (1L << (INDEX - 64)) | (1L << (INDEXED - 64)) | (1L << (INITIALLY - 64)) | (1L << (INNER - 64)) | (1L << (INSERT - 64)) | (1L << (INSTEAD - 64)) | (1L << (INTERSECT - 64)) | (1L << (INTO - 64)) | (1L << (IS - 64)) | (1L << (ISNULL - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (MATCH - 64)) | (1L << (NATURAL - 64)) | (1L << (NO - 64)) | (1L << (NOT - 64)) | (1L << (NOTNULL - 64)) | (1L << (NULL_ - 64)) | (1L << (OF - 64)) | (1L << (OFFSET - 64)) | (1L << (ON - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OUTER - 64)) | (1L << (PLAN - 64)) | (1L << (PRAGMA - 64)) | (1L << (PRIMARY - 64)) | (1L << (QUERY - 64)) | (1L << (RAISE - 64)) | (1L << (RECURSIVE - 64)) | (1L << (REFERENCES - 64)) | (1L << (REGEXP - 64)) | (1L << (REINDEX - 64)) | (1L << (RELEASE - 64)) | (1L << (RENAME - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RIGHT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (ROW - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ROWS - 128)) | (1L << (SAVEPOINT - 128)) | (1L << (SELECT - 128)) | (1L << (SET - 128)) | (1L << (TABLE - 128)) | (1L << (TEMP - 128)) | (1L << (TEMPORARY - 128)) | (1L << (THEN - 128)) | (1L << (TO - 128)) | (1L << (TRANSACTION - 128)) | (1L << (TRIGGER - 128)) | (1L << (UNION - 128)) | (1L << (UNIQUE - 128)) | (1L << (UPDATE - 128)) | (1L << (USING - 128)) | (1L << (VACUUM - 128)) | (1L << (VALUES - 128)) | (1L << (VIEW - 128)) | (1L << (VIRTUAL - 128)) | (1L << (WHEN - 128)) | (1L << (WHERE - 128)) | (1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (FIRST_VALUE - 128)) | (1L << (OVER - 128)) | (1L << (PARTITION - 128)) | (1L << (RANGE - 128)) | (1L << (PRECEDING - 128)) | (1L << (UNBOUNDED - 128)) | (1L << (CURRENT - 128)) | (1L << (FOLLOWING - 128)) | (1L << (CUME_DIST - 128)) | (1L << (DENSE_RANK - 128)) | (1L << (LAG - 128)) | (1L << (LAST_VALUE - 128)) | (1L << (LEAD - 128)) | (1L << (NTH_VALUE - 128)) | (1L << (NTILE - 128)) | (1L << (PERCENT_RANK - 128)) | (1L << (RANK - 128)) | (1L << (ROW_NUMBER - 128)) | (1L << (GENERATED - 128)) | (1L << (ALWAYS - 128)) | (1L << (STORED - 128)) | (1L << (TRUE_ - 128)) | (1L << (FALSE_ - 128)) | (1L << (WINDOW - 128)) | (1L << (NULLS - 128)) | (1L << (FIRST - 128)) | (1L << (LAST - 128)) | (1L << (FILTER - 128)) | (1L << (GROUPS - 128)) | (1L << (EXCLUDE - 128)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2000);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2002);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schema_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Schema_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_name; }
	}

	public final Schema_nameContext schema_name() throws RecognitionException {
		Schema_nameContext _localctx = new Schema_nameContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_schema_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2004);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2006);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_or_index_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_or_index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_index_name; }
	}

	public final Table_or_index_nameContext table_or_index_name() throws RecognitionException {
		Table_or_index_nameContext _localctx = new Table_or_index_nameContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_table_or_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2008);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class New_table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public New_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_table_name; }
	}

	public final New_table_nameContext new_table_name() throws RecognitionException {
		New_table_nameContext _localctx = new New_table_nameContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_new_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2010);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2012);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Collation_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Collation_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collation_name; }
	}

	public final Collation_nameContext collation_name() throws RecognitionException {
		Collation_nameContext _localctx = new Collation_nameContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_collation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2014);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Foreign_tableContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Foreign_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign_table; }
	}

	public final Foreign_tableContext foreign_table() throws RecognitionException {
		Foreign_tableContext _localctx = new Foreign_tableContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_foreign_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2016);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_name; }
	}

	public final Index_nameContext index_name() throws RecognitionException {
		Index_nameContext _localctx = new Index_nameContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2018);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trigger_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Trigger_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger_name; }
	}

	public final Trigger_nameContext trigger_name() throws RecognitionException {
		Trigger_nameContext _localctx = new Trigger_nameContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_trigger_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2020);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class View_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public View_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view_name; }
	}

	public final View_nameContext view_name() throws RecognitionException {
		View_nameContext _localctx = new View_nameContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_view_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2022);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Module_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Module_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_name; }
	}

	public final Module_nameContext module_name() throws RecognitionException {
		Module_nameContext _localctx = new Module_nameContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_module_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2024);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pragma_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Pragma_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_name; }
	}

	public final Pragma_nameContext pragma_name() throws RecognitionException {
		Pragma_nameContext _localctx = new Pragma_nameContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_pragma_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2026);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Savepoint_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Savepoint_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_savepoint_name; }
	}

	public final Savepoint_nameContext savepoint_name() throws RecognitionException {
		Savepoint_nameContext _localctx = new Savepoint_nameContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_savepoint_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2028);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_aliasContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_alias; }
	}

	public final Table_aliasContext table_alias() throws RecognitionException {
		Table_aliasContext _localctx = new Table_aliasContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_table_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2030);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Transaction_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Transaction_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transaction_name; }
	}

	public final Transaction_nameContext transaction_name() throws RecognitionException {
		Transaction_nameContext _localctx = new Transaction_nameContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_transaction_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2032);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Window_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Window_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_name; }
	}

	public final Window_nameContext window_name() throws RecognitionException {
		Window_nameContext _localctx = new Window_nameContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_window_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2034);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2036);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilenameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public FilenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filename; }
	}

	public final FilenameContext filename() throws RecognitionException {
		FilenameContext _localctx = new FilenameContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_filename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2038);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_window_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Base_window_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_window_name; }
	}

	public final Base_window_nameContext base_window_name() throws RecognitionException {
		Base_window_nameContext _localctx = new Base_window_nameContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_base_window_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2040);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_funcContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Simple_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_func; }
	}

	public final Simple_funcContext simple_func() throws RecognitionException {
		Simple_funcContext _localctx = new Simple_funcContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_simple_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2042);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aggregate_funcContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Aggregate_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate_func; }
	}

	public final Aggregate_funcContext aggregate_func() throws RecognitionException {
		Aggregate_funcContext _localctx = new Aggregate_funcContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_aggregate_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2044);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_function_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_function_name; }
	}

	public final Table_function_nameContext table_function_name() throws RecognitionException {
		Table_function_nameContext _localctx = new Table_function_nameContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_table_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2046);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLiteParser.IDENTIFIER, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public TerminalNode REF_FIELD() { return getToken(SQLiteParser.REF_FIELD, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_any_name);
		try {
			setState(2056);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2048);
				match(IDENTIFIER);
				}
				break;
			case ABORT:
			case ACTION:
			case ADD:
			case AFTER:
			case ALL:
			case ALTER:
			case ANALYZE:
			case AND:
			case AS:
			case ASC:
			case ATTACH:
			case AUTOINCREMENT:
			case BEFORE:
			case BEGIN:
			case BETWEEN:
			case BY:
			case CASCADE:
			case CASE:
			case CAST:
			case CHECK:
			case COLLATE:
			case COLUMN:
			case COMMIT:
			case CONFLICT:
			case CONSTRAINT:
			case CREATE:
			case CROSS:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DATABASE:
			case DEFAULT:
			case DEFERRABLE:
			case DEFERRED:
			case DELETE:
			case DESC:
			case DETACH:
			case DISTINCT:
			case DROP:
			case EACH:
			case ELSE:
			case END:
			case ESCAPE:
			case EXCEPT:
			case EXCLUSIVE:
			case EXISTS:
			case EXPLAIN:
			case FAIL:
			case FOR:
			case FOREIGN:
			case FROM:
			case FULL:
			case GLOB:
			case GROUP:
			case HAVING:
			case IF:
			case IGNORE:
			case IMMEDIATE:
			case IN:
			case INDEX:
			case INDEXED:
			case INITIALLY:
			case INNER:
			case INSERT:
			case INSTEAD:
			case INTERSECT:
			case INTO:
			case IS:
			case ISNULL:
			case JOIN:
			case KEY:
			case LEFT:
			case LIKE:
			case LIMIT:
			case MATCH:
			case NATURAL:
			case NO:
			case NOT:
			case NOTNULL:
			case NULL_:
			case OF:
			case OFFSET:
			case ON:
			case OR:
			case ORDER:
			case OUTER:
			case PLAN:
			case PRAGMA:
			case PRIMARY:
			case QUERY:
			case RAISE:
			case RECURSIVE:
			case REFERENCES:
			case REGEXP:
			case REINDEX:
			case RELEASE:
			case RENAME:
			case REPLACE:
			case RESTRICT:
			case RIGHT:
			case ROLLBACK:
			case ROW:
			case ROWS:
			case SAVEPOINT:
			case SELECT:
			case SET:
			case TABLE:
			case TEMP:
			case TEMPORARY:
			case THEN:
			case TO:
			case TRANSACTION:
			case TRIGGER:
			case UNION:
			case UNIQUE:
			case UPDATE:
			case USING:
			case VACUUM:
			case VALUES:
			case VIEW:
			case VIRTUAL:
			case WHEN:
			case WHERE:
			case WITH:
			case WITHOUT:
			case FIRST_VALUE:
			case OVER:
			case PARTITION:
			case RANGE:
			case PRECEDING:
			case UNBOUNDED:
			case CURRENT:
			case FOLLOWING:
			case CUME_DIST:
			case DENSE_RANK:
			case LAG:
			case LAST_VALUE:
			case LEAD:
			case NTH_VALUE:
			case NTILE:
			case PERCENT_RANK:
			case RANK:
			case ROW_NUMBER:
			case GENERATED:
			case ALWAYS:
			case STORED:
			case TRUE_:
			case FALSE_:
			case WINDOW:
			case NULLS:
			case FIRST:
			case LAST:
			case FILTER:
			case GROUPS:
			case EXCLUDE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2049);
				keyword();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2050);
				match(STRING_LITERAL);
				}
				break;
			case REF_FIELD:
				enterOuterAlt(_localctx, 4);
				{
				setState(2051);
				match(REF_FIELD);
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(2052);
				match(OPEN_PAR);
				setState(2053);
				any_name();
				setState(2054);
				match(CLOSE_PAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 33:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 20);
		case 1:
			return precpred(_ctx, 19);
		case 2:
			return precpred(_ctx, 18);
		case 3:
			return precpred(_ctx, 17);
		case 4:
			return precpred(_ctx, 16);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 8);
		case 12:
			return precpred(_ctx, 7);
		case 13:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00c4\u080d\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\3\2\3\2\7\2\u00eb"+
		"\n\2\f\2\16\2\u00ee\13\2\3\2\3\2\3\3\3\3\3\3\3\4\7\4\u00f6\n\4\f\4\16"+
		"\4\u00f9\13\4\3\4\3\4\6\4\u00fd\n\4\r\4\16\4\u00fe\3\4\7\4\u0102\n\4\f"+
		"\4\16\4\u0105\13\4\3\4\7\4\u0108\n\4\f\4\16\4\u010b\13\4\3\5\3\5\3\5\5"+
		"\5\u0110\n\5\5\5\u0112\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u012c\n\5\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u0133\n\6\3\6\3\6\3\6\3\6\3\6\5\6\u013a\n\6\3\6\3"+
		"\6\3\6\3\6\5\6\u0140\n\6\3\6\3\6\5\6\u0144\n\6\3\6\5\6\u0147\n\6\3\7\3"+
		"\7\3\7\3\7\3\7\5\7\u014e\n\7\3\7\5\7\u0151\n\7\3\b\3\b\5\b\u0155\n\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\5\t\u015d\n\t\3\t\3\t\5\t\u0161\n\t\5\t\u0163\n"+
		"\t\3\n\3\n\5\n\u0167\n\n\3\13\3\13\5\13\u016b\n\13\3\13\3\13\5\13\u016f"+
		"\n\13\3\13\5\13\u0172\n\13\3\f\3\f\3\f\3\r\3\r\5\r\u0179\n\r\3\r\3\r\3"+
		"\16\3\16\5\16\u017f\n\16\3\16\3\16\3\16\3\16\5\16\u0185\n\16\3\16\3\16"+
		"\3\16\5\16\u018a\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0193\n"+
		"\16\f\16\16\16\u0196\13\16\3\16\3\16\3\16\5\16\u019b\n\16\3\17\3\17\5"+
		"\17\u019f\n\17\3\17\3\17\5\17\u01a3\n\17\3\17\5\17\u01a6\n\17\3\20\3\20"+
		"\5\20\u01aa\n\20\3\20\3\20\3\20\3\20\5\20\u01b0\n\20\3\20\3\20\3\20\5"+
		"\20\u01b5\n\20\3\20\3\20\3\20\3\20\3\20\7\20\u01bc\n\20\f\20\16\20\u01bf"+
		"\13\20\3\20\3\20\7\20\u01c3\n\20\f\20\16\20\u01c6\13\20\3\20\3\20\3\20"+
		"\5\20\u01cb\n\20\3\20\3\20\5\20\u01cf\n\20\3\21\3\21\5\21\u01d3\n\21\3"+
		"\21\7\21\u01d6\n\21\f\21\16\21\u01d9\13\21\3\22\6\22\u01dc\n\22\r\22\16"+
		"\22\u01dd\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u01ea"+
		"\n\22\3\23\3\23\5\23\u01ee\n\23\3\23\3\23\3\23\5\23\u01f3\n\23\3\23\5"+
		"\23\u01f6\n\23\3\23\5\23\u01f9\n\23\3\23\3\23\3\23\5\23\u01fe\n\23\3\23"+
		"\5\23\u0201\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u020f\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u0216\n\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u021d\n\23\5\23\u021f\n\23\3\24\5\24\u0222\n\24"+
		"\3\24\3\24\3\25\3\25\5\25\u0228\n\25\3\25\3\25\3\25\5\25\u022d\n\25\3"+
		"\25\3\25\3\25\3\25\7\25\u0233\n\25\f\25\16\25\u0236\13\25\3\25\3\25\5"+
		"\25\u023a\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\7\25\u0247\n\25\f\25\16\25\u024a\13\25\3\25\3\25\3\25\5\25\u024f\n\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0257\n\26\f\26\16\26\u025a\13\26"+
		"\3\26\3\26\5\26\u025e\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u0268\n\26\3\26\3\26\7\26\u026c\n\26\f\26\16\26\u026f\13\26\3\26\5\26"+
		"\u0272\n\26\3\26\3\26\3\26\5\26\u0277\n\26\5\26\u0279\n\26\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\5\30\u0281\n\30\3\30\3\30\3\30\3\30\5\30\u0287\n\30"+
		"\3\30\3\30\3\30\5\30\u028c\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u0293\n"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u029c\n\30\f\30\16\30\u029f"+
		"\13\30\5\30\u02a1\n\30\5\30\u02a3\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u02aa"+
		"\n\30\3\30\3\30\5\30\u02ae\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u02b5\n"+
		"\30\3\30\3\30\6\30\u02b9\n\30\r\30\16\30\u02ba\3\30\3\30\3\31\3\31\5\31"+
		"\u02c1\n\31\3\31\3\31\3\31\3\31\5\31\u02c7\n\31\3\31\3\31\3\31\5\31\u02cc"+
		"\n\31\3\31\3\31\3\31\3\31\3\31\7\31\u02d3\n\31\f\31\16\31\u02d6\13\31"+
		"\3\31\3\31\5\31\u02da\n\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u02e5\n\32\3\32\3\32\3\32\5\32\u02ea\n\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\7\32\u02f3\n\32\f\32\16\32\u02f6\13\32\3\32\3\32\5\32\u02fa"+
		"\n\32\3\33\3\33\5\33\u02fe\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\7\33\u030c\n\33\f\33\16\33\u030f\13\33\3\34\3\34"+
		"\3\34\3\34\3\34\7\34\u0316\n\34\f\34\16\34\u0319\13\34\3\34\3\34\5\34"+
		"\u031d\n\34\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0325\n\35\3\35\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\36\7\36\u032f\n\36\f\36\16\36\u0332\13\36\3"+
		"\36\3\36\5\36\u0336\n\36\3\36\3\36\3\36\3\36\3\36\3\37\5\37\u033e\n\37"+
		"\3\37\3\37\3\37\3\37\3\37\5\37\u0345\n\37\3 \5 \u0348\n \3 \3 \3 \3 \3"+
		" \5 \u034f\n \3 \5 \u0352\n \3 \5 \u0355\n \3!\3!\5!\u0359\n!\3!\3!\3"+
		"\"\3\"\3\"\3\"\5\"\u0361\n\"\3\"\3\"\3\"\5\"\u0366\n\"\3\"\3\"\3#\3#\3"+
		"#\3#\3#\3#\5#\u0370\n#\3#\3#\3#\5#\u0375\n#\3#\3#\3#\3#\3#\3#\3#\5#\u037e"+
		"\n#\3#\3#\3#\7#\u0383\n#\f#\16#\u0386\13#\3#\5#\u0389\n#\3#\3#\5#\u038d"+
		"\n#\3#\5#\u0390\n#\3#\3#\3#\3#\7#\u0396\n#\f#\16#\u0399\13#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\5#\u03a5\n#\3#\5#\u03a8\n#\3#\3#\3#\3#\3#\3#\5#\u03b0"+
		"\n#\3#\3#\3#\3#\3#\6#\u03b7\n#\r#\16#\u03b8\3#\3#\5#\u03bd\n#\3#\3#\3"+
		"#\5#\u03c2\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u03e0\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\5#\u03ec\n#\3#\3#\3#\5#\u03f1\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u03fd"+
		"\n#\3#\3#\3#\3#\5#\u0403\n#\3#\3#\3#\3#\3#\5#\u040a\n#\3#\3#\5#\u040e"+
		"\n#\3#\3#\3#\3#\3#\3#\7#\u0416\n#\f#\16#\u0419\13#\5#\u041b\n#\3#\3#\3"+
		"#\3#\5#\u0421\n#\3#\3#\3#\3#\5#\u0427\n#\3#\3#\3#\3#\3#\7#\u042e\n#\f"+
		"#\16#\u0431\13#\5#\u0433\n#\3#\3#\5#\u0437\n#\7#\u0439\n#\f#\16#\u043c"+
		"\13#\3$\3$\3$\3$\3$\3$\5$\u0444\n$\3$\3$\3%\3%\3&\5&\u044b\n&\3&\3&\3"+
		"&\3&\3&\5&\u0452\n&\3&\3&\3&\3&\5&\u0458\n&\3&\3&\3&\5&\u045d\n&\3&\3"+
		"&\3&\3&\7&\u0463\n&\f&\16&\u0466\13&\3&\3&\5&\u046a\n&\3&\3&\3&\3&\3&"+
		"\7&\u0471\n&\f&\16&\u0474\13&\3&\3&\3&\3&\3&\3&\7&\u047c\n&\f&\16&\u047f"+
		"\13&\3&\3&\7&\u0483\n&\f&\16&\u0486\13&\3&\5&\u0489\n&\3&\5&\u048c\n&"+
		"\3&\3&\5&\u0490\n&\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u0498\n\'\f\'\16\'\u049b"+
		"\13\'\3\'\3\'\3\'\5\'\u04a0\n\'\5\'\u04a2\n\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\5\'\u04aa\n\'\3\'\3\'\3\'\3\'\3\'\5\'\u04b1\n\'\3\'\3\'\3\'\7\'\u04b6"+
		"\n\'\f\'\16\'\u04b9\13\'\3\'\3\'\5\'\u04bd\n\'\5\'\u04bf\n\'\3(\3(\3("+
		"\3(\5(\u04c5\n(\3(\3(\3(\3(\3(\3(\3(\5(\u04ce\n(\3)\3)\3)\5)\u04d3\n)"+
		"\3*\3*\3*\3*\3*\5*\u04da\n*\3*\3*\5*\u04de\n*\5*\u04e0\n*\3+\5+\u04e3"+
		"\n+\3+\3+\3+\3+\7+\u04e9\n+\f+\16+\u04ec\13+\3+\5+\u04ef\n+\3+\5+\u04f2"+
		"\n+\3,\3,\3,\3,\5,\u04f8\n,\7,\u04fa\n,\f,\16,\u04fd\13,\3-\3-\5-\u0501"+
		"\n-\3-\3-\3-\7-\u0506\n-\f-\16-\u0509\13-\3-\3-\3-\3-\7-\u050f\n-\f-\16"+
		"-\u0512\13-\3-\5-\u0515\n-\5-\u0517\n-\3-\5-\u051a\n-\3-\5-\u051d\n-\3"+
		"-\3-\3-\3-\3-\3-\3-\3-\3-\7-\u0528\n-\f-\16-\u052b\13-\5-\u052d\n-\3-"+
		"\3-\3-\3-\3-\7-\u0534\n-\f-\16-\u0537\13-\3-\3-\3-\3-\3-\3-\7-\u053f\n"+
		"-\f-\16-\u0542\13-\3-\3-\7-\u0546\n-\f-\16-\u0549\13-\5-\u054b\n-\3.\3"+
		".\3.\3/\3/\3/\3/\3/\7/\u0555\n/\f/\16/\u0558\13/\3/\5/\u055b\n/\3\60\3"+
		"\60\3\60\3\61\3\61\3\62\5\62\u0563\n\62\3\62\3\62\5\62\u0567\n\62\3\62"+
		"\5\62\u056a\n\62\3\63\5\63\u056d\n\63\3\63\3\63\3\63\5\63\u0572\n\63\3"+
		"\63\3\63\5\63\u0576\n\63\3\63\6\63\u0579\n\63\r\63\16\63\u057a\3\63\5"+
		"\63\u057e\n\63\3\63\5\63\u0581\n\63\3\64\3\64\3\64\5\64\u0586\n\64\3\64"+
		"\3\64\5\64\u058a\n\64\3\64\5\64\u058d\n\64\3\64\3\64\3\64\3\64\3\64\5"+
		"\64\u0594\n\64\3\64\3\64\3\64\5\64\u0599\n\64\3\64\3\64\3\64\3\64\3\64"+
		"\7\64\u05a0\n\64\f\64\16\64\u05a3\13\64\3\64\3\64\5\64\u05a7\n\64\3\64"+
		"\5\64\u05aa\n\64\3\64\3\64\3\64\3\64\7\64\u05b0\n\64\f\64\16\64\u05b3"+
		"\13\64\3\64\5\64\u05b6\n\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u05be\n"+
		"\64\3\64\5\64\u05c1\n\64\5\64\u05c3\n\64\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\5\65\u05cc\n\65\3\65\5\65\u05cf\n\65\5\65\u05d1\n\65\3\66\3\66\5"+
		"\66\u05d5\n\66\3\66\3\66\5\66\u05d9\n\66\3\66\3\66\5\66\u05dd\n\66\3\66"+
		"\5\66\u05e0\n\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\7\67\u05e9\n\67\f"+
		"\67\16\67\u05ec\13\67\3\67\3\67\5\67\u05f0\n\67\38\38\58\u05f4\n8\38\3"+
		"8\58\u05f8\n8\39\59\u05fb\n9\39\39\39\59\u0600\n9\39\39\39\39\59\u0606"+
		"\n9\39\39\39\39\39\59\u060d\n9\39\39\39\79\u0612\n9\f9\169\u0615\139\3"+
		"9\39\59\u0619\n9\3:\3:\3:\3:\7:\u061f\n:\f:\16:\u0622\13:\3:\3:\3;\5;"+
		"\u0627\n;\3;\3;\3;\5;\u062c\n;\3;\3;\3;\3;\5;\u0632\n;\3;\3;\3;\3;\3;"+
		"\5;\u0639\n;\3;\3;\3;\7;\u063e\n;\f;\16;\u0641\13;\3;\3;\5;\u0645\n;\3"+
		";\5;\u0648\n;\3;\5;\u064b\n;\3<\3<\3<\5<\u0650\n<\3<\3<\3<\5<\u0655\n"+
		"<\3<\3<\3<\3<\3<\5<\u065c\n<\3=\3=\5=\u0660\n=\3=\3=\5=\u0664\n=\3>\3"+
		">\3>\3>\3>\3>\3?\3?\5?\u066e\n?\3?\3?\3?\3?\3?\7?\u0675\n?\f?\16?\u0678"+
		"\13?\5?\u067a\n?\3?\3?\3?\3?\3?\7?\u0681\n?\f?\16?\u0684\13?\3?\5?\u0687"+
		"\n?\3?\3?\3@\3@\3@\3@\5@\u068f\n@\3@\3@\3@\3@\3@\7@\u0696\n@\f@\16@\u0699"+
		"\13@\5@\u069b\n@\3@\3@\3@\3@\3@\7@\u06a2\n@\f@\16@\u06a5\13@\5@\u06a7"+
		"\n@\3@\5@\u06aa\n@\3@\5@\u06ad\n@\3A\3A\3A\3A\3A\3A\3A\3A\5A\u06b7\nA"+
		"\3B\3B\3B\3B\3B\3B\3B\5B\u06c0\nB\3C\3C\3C\3C\3C\7C\u06c7\nC\fC\16C\u06ca"+
		"\13C\3C\5C\u06cd\nC\3C\3C\3D\3D\3D\5D\u06d4\nD\3D\3D\3D\7D\u06d9\nD\f"+
		"D\16D\u06dc\13D\3D\5D\u06df\nD\3D\3D\5D\u06e3\nD\3E\3E\3E\3E\3E\7E\u06ea"+
		"\nE\fE\16E\u06ed\13E\3E\5E\u06f0\nE\3E\3E\5E\u06f4\nE\3E\3E\3E\5E\u06f9"+
		"\nE\3F\3F\5F\u06fd\nF\3F\3F\3F\7F\u0702\nF\fF\16F\u0705\13F\3G\3G\3G\3"+
		"G\3G\7G\u070c\nG\fG\16G\u070f\13G\3H\3H\3H\3H\5H\u0715\nH\3I\3I\3I\5I"+
		"\u071a\nI\3I\5I\u071d\nI\3I\3I\5I\u0721\nI\3J\3J\3K\3K\3K\3K\3K\3K\3K"+
		"\3K\3K\3K\5K\u072f\nK\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\5L\u073b\nL\3M\3M"+
		"\3M\3M\3M\3M\3M\5M\u0744\nM\3N\3N\3N\3N\3N\3N\3N\5N\u074d\nN\3N\3N\5N"+
		"\u0751\nN\3N\3N\3N\3N\3N\3N\3N\3N\5N\u075b\nN\3N\5N\u075e\nN\3N\3N\3N"+
		"\3N\3N\3N\3N\5N\u0767\nN\3N\3N\3N\3N\3N\3N\3N\5N\u0770\nN\3N\5N\u0773"+
		"\nN\3N\3N\3N\3N\5N\u0779\nN\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\5N\u0787"+
		"\nN\3N\3N\5N\u078b\nN\3N\3N\3N\3N\3N\3N\3N\3N\3N\5N\u0796\nN\3N\3N\3N"+
		"\5N\u079b\nN\3O\3O\3O\3P\3P\3P\3Q\3Q\3Q\6Q\u07a6\nQ\rQ\16Q\u07a7\3R\3"+
		"R\3R\6R\u07ad\nR\rR\16R\u07ae\3S\3S\3S\3S\3T\3T\5T\u07b7\nT\3T\3T\3T\5"+
		"T\u07bc\nT\7T\u07be\nT\fT\16T\u07c1\13T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y"+
		"\5Y\u07cd\nY\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^\3_\3_\3`\3`\3a\3a\3b\3b\3"+
		"c\3c\3d\3d\3e\3e\3f\3f\3g\3g\3h\3h\3i\3i\3j\3j\3k\3k\3l\3l\3m\3m\3n\3"+
		"n\3o\3o\3p\3p\3q\3q\3r\3r\3s\3s\3t\3t\3t\3t\3t\3t\3t\3t\5t\u080b\nt\3"+
		"t\4\u01bd\u01dd\3Du\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce"+
		"\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6"+
		"\2\36\5\2==HHUU\4\2\62\62EE\3\2\u0087\u0088\4\2\u0094\u0094\u00ad\u00ad"+
		"\3\2\13\f\4\2>>\u008f\u008f\4\2;;kk\4\2==UU\7\2\34\34KKTT}}\u0080\u0080"+
		"\6\2WW\u0086\u0086\u008c\u008c\u0093\u0093\4\2\t\t\17\20\3\2\21\24\3\2"+
		"\25\30\6\2PPddffyy\5\2\34\34KK\u0080\u0080\7\2\679kk\u00ae\u00af\u00bc"+
		"\u00bc\u00bf\u00c0\4\2  AA\5\2\u0082\u0082\u009c\u009c\u00b5\u00b5\4\2"+
		"\7\7mm\3\2\u00b2\u00b3\4\2%%??\4\2\u0099\u0099\u00a4\u00a4\4\2\u00a1\u00a1"+
		"\u00a8\u00a8\4\2\u00a2\u00a2\u00a9\u00aa\4\2\u00a3\u00a3\u00a5\u00a5\4"+
		"\2\13\rii\4\2\u00bb\u00bb\u00bf\u00bf\3\2\34\u00b6\2\u091f\2\u00ec\3\2"+
		"\2\2\4\u00f1\3\2\2\2\6\u00f7\3\2\2\2\b\u0111\3\2\2\2\n\u012d\3\2\2\2\f"+
		"\u0148\3\2\2\2\16\u0152\3\2\2\2\20\u015a\3\2\2\2\22\u0164\3\2\2\2\24\u0168"+
		"\3\2\2\2\26\u0173\3\2\2\2\30\u0176\3\2\2\2\32\u017c\3\2\2\2\34\u019e\3"+
		"\2\2\2\36\u01a7\3\2\2\2 \u01d0\3\2\2\2\"\u01db\3\2\2\2$\u01ed\3\2\2\2"+
		"&\u0221\3\2\2\2(\u0227\3\2\2\2*\u0250\3\2\2\2,\u027a\3\2\2\2.\u027e\3"+
		"\2\2\2\60\u02be\3\2\2\2\62\u02de\3\2\2\2\64\u02fb\3\2\2\2\66\u0310\3\2"+
		"\2\28\u031e\3\2\2\2:\u0329\3\2\2\2<\u033d\3\2\2\2>\u0347\3\2\2\2@\u0356"+
		"\3\2\2\2B\u035c\3\2\2\2D\u03c1\3\2\2\2F\u043d\3\2\2\2H\u0447\3\2\2\2J"+
		"\u048f\3\2\2\2L\u0491\3\2\2\2N\u04c0\3\2\2\2P\u04d2\3\2\2\2R\u04d4\3\2"+
		"\2\2T\u04e2\3\2\2\2V\u04f3\3\2\2\2X\u054a\3\2\2\2Z\u054c\3\2\2\2\\\u054f"+
		"\3\2\2\2^\u055c\3\2\2\2`\u055f\3\2\2\2b\u0562\3\2\2\2d\u056c\3\2\2\2f"+
		"\u05c2\3\2\2\2h\u05d0\3\2\2\2j\u05df\3\2\2\2l\u05ef\3\2\2\2n\u05f7\3\2"+
		"\2\2p\u05fa\3\2\2\2r\u061a\3\2\2\2t\u0626\3\2\2\2v\u064f\3\2\2\2x\u065d"+
		"\3\2\2\2z\u0665\3\2\2\2|\u066b\3\2\2\2~\u068a\3\2\2\2\u0080\u06ae\3\2"+
		"\2\2\u0082\u06b8\3\2\2\2\u0084\u06c1\3\2\2\2\u0086\u06d0\3\2\2\2\u0088"+
		"\u06e4\3\2\2\2\u008a\u06fa\3\2\2\2\u008c\u0706\3\2\2\2\u008e\u0710\3\2"+
		"\2\2\u0090\u0716\3\2\2\2\u0092\u0722\3\2\2\2\u0094\u072e\3\2\2\2\u0096"+
		"\u073a\3\2\2\2\u0098\u0743\3\2\2\2\u009a\u079a\3\2\2\2\u009c\u079c\3\2"+
		"\2\2\u009e\u079f\3\2\2\2\u00a0\u07a2\3\2\2\2\u00a2\u07a9\3\2\2\2\u00a4"+
		"\u07b0\3\2\2\2\u00a6\u07b4\3\2\2\2\u00a8\u07c2\3\2\2\2\u00aa\u07c4\3\2"+
		"\2\2\u00ac\u07c6\3\2\2\2\u00ae\u07c8\3\2\2\2\u00b0\u07cc\3\2\2\2\u00b2"+
		"\u07ce\3\2\2\2\u00b4\u07d0\3\2\2\2\u00b6\u07d2\3\2\2\2\u00b8\u07d4\3\2"+
		"\2\2\u00ba\u07d6\3\2\2\2\u00bc\u07d8\3\2\2\2\u00be\u07da\3\2\2\2\u00c0"+
		"\u07dc\3\2\2\2\u00c2\u07de\3\2\2\2\u00c4\u07e0\3\2\2\2\u00c6\u07e2\3\2"+
		"\2\2\u00c8\u07e4\3\2\2\2\u00ca\u07e6\3\2\2\2\u00cc\u07e8\3\2\2\2\u00ce"+
		"\u07ea\3\2\2\2\u00d0\u07ec\3\2\2\2\u00d2\u07ee\3\2\2\2\u00d4\u07f0\3\2"+
		"\2\2\u00d6\u07f2\3\2\2\2\u00d8\u07f4\3\2\2\2\u00da\u07f6\3\2\2\2\u00dc"+
		"\u07f8\3\2\2\2\u00de\u07fa\3\2\2\2\u00e0\u07fc\3\2\2\2\u00e2\u07fe\3\2"+
		"\2\2\u00e4\u0800\3\2\2\2\u00e6\u080a\3\2\2\2\u00e8\u00eb\5\6\4\2\u00e9"+
		"\u00eb\5\4\3\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2"+
		"\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ef\u00f0\7\2\2\3\u00f0\3\3\2\2\2\u00f1\u00f2\7\u00c4"+
		"\2\2\u00f2\u00f3\b\3\1\2\u00f3\5\3\2\2\2\u00f4\u00f6\7\3\2\2\u00f5\u00f4"+
		"\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u0103\5\b\5\2\u00fb\u00fd\7\3"+
		"\2\2\u00fc\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\5\b\5\2\u0101\u00fc\3\2"+
		"\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u0109\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0108\7\3\2\2\u0107\u0106\3\2"+
		"\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\7\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010f\7J\2\2\u010d\u010e\7u\2\2\u010e"+
		"\u0110\7r\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2"+
		"\2\2\u0111\u010c\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u012b\3\2\2\2\u0113"+
		"\u012c\5\n\6\2\u0114\u012c\5\f\7\2\u0115\u012c\5\16\b\2\u0116\u012c\5"+
		"\20\t\2\u0117\u012c\5\22\n\2\u0118\u012c\5\32\16\2\u0119\u012c\5\36\20"+
		"\2\u011a\u012c\5.\30\2\u011b\u012c\5\60\31\2\u011c\u012c\5\62\32\2\u011d"+
		"\u012c\5<\37\2\u011e\u012c\5> \2\u011f\u012c\5@!\2\u0120\u012c\5B\"\2"+
		"\u0121\u012c\5J&\2\u0122\u012c\5N(\2\u0123\u012c\5R*\2\u0124\u012c\5\30"+
		"\r\2\u0125\u012c\5\24\13\2\u0126\u012c\5\26\f\2\u0127\u012c\5T+\2\u0128"+
		"\u012c\5p9\2\u0129\u012c\5t;\2\u012a\u012c\5x=\2\u012b\u0113\3\2\2\2\u012b"+
		"\u0114\3\2\2\2\u012b\u0115\3\2\2\2\u012b\u0116\3\2\2\2\u012b\u0117\3\2"+
		"\2\2\u012b\u0118\3\2\2\2\u012b\u0119\3\2\2\2\u012b\u011a\3\2\2\2\u012b"+
		"\u011b\3\2\2\2\u012b\u011c\3\2\2\2\u012b\u011d\3\2\2\2\u012b\u011e\3\2"+
		"\2\2\u012b\u011f\3\2\2\2\u012b\u0120\3\2\2\2\u012b\u0121\3\2\2\2\u012b"+
		"\u0122\3\2\2\2\u012b\u0123\3\2\2\2\u012b\u0124\3\2\2\2\u012b\u0125\3\2"+
		"\2\2\u012b\u0126\3\2\2\2\u012b\u0127\3\2\2\2\u012b\u0128\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012c\t\3\2\2\2\u012d\u012e\7!\2\2"+
		"\u012e\u0132\7\u0086\2\2\u012f\u0130\5\u00ba^\2\u0130\u0131\7\4\2\2\u0131"+
		"\u0133\3\2\2\2\u0132\u012f\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\3\2"+
		"\2\2\u0134\u0146\5\u00bc_\2\u0135\u013f\7|\2\2\u0136\u0137\7\u008a\2\2"+
		"\u0137\u0140\5\u00c0a\2\u0138\u013a\7\61\2\2\u0139\u0138\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\5\u00c2b\2\u013c\u013d"+
		"\7\u008a\2\2\u013d\u013e\5\u00c2b\2\u013e\u0140\3\2\2\2\u013f\u0136\3"+
		"\2\2\2\u013f\u0139\3\2\2\2\u0140\u0147\3\2\2\2\u0141\u0143\7\36\2\2\u0142"+
		"\u0144\7\61\2\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3"+
		"\2\2\2\u0145\u0147\5 \21\2\u0146\u0135\3\2\2\2\u0146\u0141\3\2\2\2\u0147"+
		"\13\3\2\2\2\u0148\u0150\7\"\2\2\u0149\u0151\5\u00ba^\2\u014a\u014b\5\u00ba"+
		"^\2\u014b\u014c\7\4\2\2\u014c\u014e\3\2\2\2\u014d\u014a\3\2\2\2\u014d"+
		"\u014e\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\5\u00be`\2\u0150\u0149"+
		"\3\2\2\2\u0150\u014d\3\2\2\2\u0150\u0151\3\2\2\2\u0151\r\3\2\2\2\u0152"+
		"\u0154\7&\2\2\u0153\u0155\7:\2\2\u0154\u0153\3\2\2\2\u0154\u0155\3\2\2"+
		"\2\u0155\u0156\3\2\2\2\u0156\u0157\5D#\2\u0157\u0158\7$\2\2\u0158\u0159"+
		"\5\u00ba^\2\u0159\17\3\2\2\2\u015a\u015c\7)\2\2\u015b\u015d\t\2\2\2\u015c"+
		"\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u0162\3\2\2\2\u015e\u0160\7\u008b"+
		"\2\2\u015f\u0161\5\u00d6l\2\u0160\u015f\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\u0163\3\2\2\2\u0162\u015e\3\2\2\2\u0162\u0163\3\2\2\2\u0163\21\3\2\2"+
		"\2\u0164\u0166\t\3\2\2\u0165\u0167\7\u008b\2\2\u0166\u0165\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\23\3\2\2\2\u0168\u016a\7\u0080\2\2\u0169\u016b\7"+
		"\u008b\2\2\u016a\u0169\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u0171\3\2\2\2"+
		"\u016c\u016e\7\u008a\2\2\u016d\u016f\7\u0083\2\2\u016e\u016d\3\2\2\2\u016e"+
		"\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0172\5\u00d2j\2\u0171\u016c"+
		"\3\2\2\2\u0171\u0172\3\2\2\2\u0172\25\3\2\2\2\u0173\u0174\7\u0083\2\2"+
		"\u0174\u0175\5\u00d2j\2\u0175\27\3\2\2\2\u0176\u0178\7{\2\2\u0177\u0179"+
		"\7\u0083\2\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2\2"+
		"\2\u017a\u017b\5\u00d2j\2\u017b\31\3\2\2\2\u017c\u017e\7\65\2\2\u017d"+
		"\u017f\7\u008e\2\2\u017e\u017d\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180"+
		"\3\2\2\2\u0180\u0184\7W\2\2\u0181\u0182\7S\2\2\u0182\u0183\7i\2\2\u0183"+
		"\u0185\7I\2\2\u0184\u0181\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0189\3\2"+
		"\2\2\u0186\u0187\5\u00ba^\2\u0187\u0188\7\4\2\2\u0188\u018a\3\2\2\2\u0189"+
		"\u0186\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\5\u00c8"+
		"e\2\u018c\u018d\7n\2\2\u018d\u018e\5\u00bc_\2\u018e\u018f\7\5\2\2\u018f"+
		"\u0194\5\34\17\2\u0190\u0191\7\7\2\2\u0191\u0193\5\34\17\2\u0192\u0190"+
		"\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u0197\3\2\2\2\u0196\u0194\3\2\2\2\u0197\u019a\7\6\2\2\u0198\u0199\7\u0096"+
		"\2\2\u0199\u019b\5D#\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\33"+
		"\3\2\2\2\u019c\u019f\5\u00c2b\2\u019d\u019f\5D#\2\u019e\u019c\3\2\2\2"+
		"\u019e\u019d\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u01a1\7\60\2\2\u01a1\u01a3"+
		"\5\u00c4c\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a5\3\2\2"+
		"\2\u01a4\u01a6\5\u0092J\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6"+
		"\35\3\2\2\2\u01a7\u01a9\7\65\2\2\u01a8\u01aa\t\4\2\2\u01a9\u01a8\3\2\2"+
		"\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01af\7\u0086\2\2\u01ac"+
		"\u01ad\7S\2\2\u01ad\u01ae\7i\2\2\u01ae\u01b0\7I\2\2\u01af\u01ac\3\2\2"+
		"\2\u01af\u01b0\3\2\2\2\u01b0\u01b4\3\2\2\2\u01b1\u01b2\5\u00ba^\2\u01b2"+
		"\u01b3\7\4\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01b1\3\2\2\2\u01b4\u01b5\3\2"+
		"\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01ce\5\u00bc_\2\u01b7\u01b8\7\5\2\2\u01b8"+
		"\u01bd\5 \21\2\u01b9\u01ba\7\7\2\2\u01ba\u01bc\5 \21\2\u01bb\u01b9\3\2"+
		"\2\2\u01bc\u01bf\3\2\2\2\u01bd\u01be\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be"+
		"\u01c4\3\2\2\2\u01bf\u01bd\3\2\2\2\u01c0\u01c1\7\7\2\2\u01c1\u01c3\5("+
		"\25\2\u01c2\u01c0\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4"+
		"\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01ca\7\6"+
		"\2\2\u01c8\u01c9\7\u0098\2\2\u01c9\u01cb\7\u00bb\2\2\u01ca\u01c8\3\2\2"+
		"\2\u01ca\u01cb\3\2\2\2\u01cb\u01cf\3\2\2\2\u01cc\u01cd\7$\2\2\u01cd\u01cf"+
		"\5T+\2\u01ce\u01b7\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\37\3\2\2\2\u01d0"+
		"\u01d2\5\u00c2b\2\u01d1\u01d3\5\"\22\2\u01d2\u01d1\3\2\2\2\u01d2\u01d3"+
		"\3\2\2\2\u01d3\u01d7\3\2\2\2\u01d4\u01d6\5$\23\2\u01d5\u01d4\3\2\2\2\u01d6"+
		"\u01d9\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8!\3\2\2\2"+
		"\u01d9\u01d7\3\2\2\2\u01da\u01dc\5\u00b6\\\2\u01db\u01da\3\2\2\2\u01dc"+
		"\u01dd\3\2\2\2\u01dd\u01de\3\2\2\2\u01dd\u01db\3\2\2\2\u01de\u01e9\3\2"+
		"\2\2\u01df\u01e0\7\5\2\2\u01e0\u01e1\5&\24\2\u01e1\u01e2\7\6\2\2\u01e2"+
		"\u01ea\3\2\2\2\u01e3\u01e4\7\5\2\2\u01e4\u01e5\5&\24\2\u01e5\u01e6\7\7"+
		"\2\2\u01e6\u01e7\5&\24\2\u01e7\u01e8\7\6\2\2\u01e8\u01ea\3\2\2\2\u01e9"+
		"\u01df\3\2\2\2\u01e9\u01e3\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea#\3\2\2\2"+
		"\u01eb\u01ec\7\64\2\2\u01ec\u01ee\5\u00b6\\\2\u01ed\u01eb\3\2\2\2\u01ed"+
		"\u01ee\3\2\2\2\u01ee\u021e\3\2\2\2\u01ef\u01f0\7t\2\2\u01f0\u01f2\7b\2"+
		"\2\u01f1\u01f3\5\u0092J\2\u01f2\u01f1\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3"+
		"\u01f5\3\2\2\2\u01f4\u01f6\5,\27\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2"+
		"\2\2\u01f6\u01f8\3\2\2\2\u01f7\u01f9\7\'\2\2\u01f8\u01f7\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\u021f\3\2\2\2\u01fa\u01fb\7i\2\2\u01fb\u01fe\7k\2"+
		"\2\u01fc\u01fe\7\u008e\2\2\u01fd\u01fa\3\2\2\2\u01fd\u01fc\3\2\2\2\u01fe"+
		"\u0200\3\2\2\2\u01ff\u0201\5,\27\2\u0200\u01ff\3\2\2\2\u0200\u0201\3\2"+
		"\2\2\u0201\u021f\3\2\2\2\u0202\u0203\7/\2\2\u0203\u0204\7\5\2\2\u0204"+
		"\u0205\5D#\2\u0205\u0206\7\6\2\2\u0206\u021f\3\2\2\2\u0207\u020e\7;\2"+
		"\2\u0208\u020f\5&\24\2\u0209\u020f\5H%\2\u020a\u020b\7\5\2\2\u020b\u020c"+
		"\5D#\2\u020c\u020d\7\6\2\2\u020d\u020f\3\2\2\2\u020e\u0208\3\2\2\2\u020e"+
		"\u0209\3\2\2\2\u020e\u020a\3\2\2\2\u020f\u021f\3\2\2\2\u0210\u0211\7\60"+
		"\2\2\u0211\u021f\5\u00c4c\2\u0212\u021f\5*\26\2\u0213\u0214\7\u00ab\2"+
		"\2\u0214\u0216\7\u00ac\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216"+
		"\u0217\3\2\2\2\u0217\u0218\7$\2\2\u0218\u0219\7\5\2\2\u0219\u021a\5D#"+
		"\2\u021a\u021c\7\6\2\2\u021b\u021d\t\5\2\2\u021c\u021b\3\2\2\2\u021c\u021d"+
		"\3\2\2\2\u021d\u021f\3\2\2\2\u021e\u01ef\3\2\2\2\u021e\u01fd\3\2\2\2\u021e"+
		"\u0202\3\2\2\2\u021e\u0207\3\2\2\2\u021e\u0210\3\2\2\2\u021e\u0212\3\2"+
		"\2\2\u021e\u0215\3\2\2\2\u021f%\3\2\2\2\u0220\u0222\t\6\2\2\u0221\u0220"+
		"\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0224\7\u00bc\2"+
		"\2\u0224\'\3\2\2\2\u0225\u0226\7\64\2\2\u0226\u0228\5\u00b6\\\2\u0227"+
		"\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u024e\3\2\2\2\u0229\u022a\7t"+
		"\2\2\u022a\u022d\7b\2\2\u022b\u022d\7\u008e\2\2\u022c\u0229\3\2\2\2\u022c"+
		"\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022f\7\5\2\2\u022f\u0234\5\34"+
		"\17\2\u0230\u0231\7\7\2\2\u0231\u0233\5\34\17\2\u0232\u0230\3\2\2\2\u0233"+
		"\u0236\3\2\2\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0237\3\2"+
		"\2\2\u0236\u0234\3\2\2\2\u0237\u0239\7\6\2\2\u0238\u023a\5,\27\2\u0239"+
		"\u0238\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u024f\3\2\2\2\u023b\u023c\7/"+
		"\2\2\u023c\u023d\7\5\2\2\u023d\u023e\5D#\2\u023e\u023f\7\6\2\2\u023f\u024f"+
		"\3\2\2\2\u0240\u0241\7M\2\2\u0241\u0242\7b\2\2\u0242\u0243\7\5\2\2\u0243"+
		"\u0248\5\u00c2b\2\u0244\u0245\7\7\2\2\u0245\u0247\5\u00c2b\2\u0246\u0244"+
		"\3\2\2\2\u0247\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249"+
		"\u024b\3\2\2\2\u024a\u0248\3\2\2\2\u024b\u024c\7\6\2\2\u024c\u024d\5*"+
		"\26\2\u024d\u024f\3\2\2\2\u024e\u022c\3\2\2\2\u024e\u023b\3\2\2\2\u024e"+
		"\u0240\3\2\2\2\u024f)\3\2\2\2\u0250\u0251\7x\2\2\u0251\u025d\5\u00c6d"+
		"\2\u0252\u0253\7\5\2\2\u0253\u0258\5\u00c2b\2\u0254\u0255\7\7\2\2\u0255"+
		"\u0257\5\u00c2b\2\u0256\u0254\3\2\2\2\u0257\u025a\3\2\2\2\u0258\u0256"+
		"\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025b\3\2\2\2\u025a\u0258\3\2\2\2\u025b"+
		"\u025c\7\6\2\2\u025c\u025e\3\2\2\2\u025d\u0252\3\2\2\2\u025d\u025e\3\2"+
		"\2\2\u025e\u026d\3\2\2\2\u025f\u0260\7n\2\2\u0260\u0267\t\7\2\2\u0261"+
		"\u0262\7\u0085\2\2\u0262\u0268\t\b\2\2\u0263\u0268\7,\2\2\u0264\u0268"+
		"\7~\2\2\u0265\u0266\7h\2\2\u0266\u0268\7\35\2\2\u0267\u0261\3\2\2\2\u0267"+
		"\u0263\3\2\2\2\u0267\u0264\3\2\2\2\u0267\u0265\3\2\2\2\u0268\u026c\3\2"+
		"\2\2\u0269\u026a\7f\2\2\u026a\u026c\5\u00b6\\\2\u026b\u025f\3\2\2\2\u026b"+
		"\u0269\3\2\2\2\u026c\u026f\3\2\2\2\u026d\u026b\3\2\2\2\u026d\u026e\3\2"+
		"\2\2\u026e\u0278\3\2\2\2\u026f\u026d\3\2\2\2\u0270\u0272\7i\2\2\u0271"+
		"\u0270\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u0276\7<"+
		"\2\2\u0274\u0275\7Y\2\2\u0275\u0277\t\t\2\2\u0276\u0274\3\2\2\2\u0276"+
		"\u0277\3\2\2\2\u0277\u0279\3\2\2\2\u0278\u0271\3\2\2\2\u0278\u0279\3\2"+
		"\2\2\u0279+\3\2\2\2\u027a\u027b\7n\2\2\u027b\u027c\7\63\2\2\u027c\u027d"+
		"\t\n\2\2\u027d-\3\2\2\2\u027e\u0280\7\65\2\2\u027f\u0281\t\4\2\2\u0280"+
		"\u027f\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0286\7\u008c"+
		"\2\2\u0283\u0284\7S\2\2\u0284\u0285\7i\2\2\u0285\u0287\7I\2\2\u0286\u0283"+
		"\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u028b\3\2\2\2\u0288\u0289\5\u00ba^"+
		"\2\u0289\u028a\7\4\2\2\u028a\u028c\3\2\2\2\u028b\u0288\3\2\2\2\u028b\u028c"+
		"\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u0292\5\u00caf\2\u028e\u0293\7(\2\2"+
		"\u028f\u0293\7\37\2\2\u0290\u0291\7\\\2\2\u0291\u0293\7l\2\2\u0292\u028e"+
		"\3\2\2\2\u0292\u028f\3\2\2\2\u0292\u0290\3\2\2\2\u0292\u0293\3\2\2\2\u0293"+
		"\u02a2\3\2\2\2\u0294\u02a3\7>\2\2\u0295\u02a3\7[\2\2\u0296\u02a0\7\u008f"+
		"\2\2\u0297\u0298\7l\2\2\u0298\u029d\5\u00c2b\2\u0299\u029a\7\7\2\2\u029a"+
		"\u029c\5\u00c2b\2\u029b\u0299\3\2\2\2\u029c\u029f\3\2\2\2\u029d\u029b"+
		"\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u02a1\3\2\2\2\u029f\u029d\3\2\2\2\u02a0"+
		"\u0297\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a3\3\2\2\2\u02a2\u0294\3\2"+
		"\2\2\u02a2\u0295\3\2\2\2\u02a2\u0296\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4"+
		"\u02a5\7n\2\2\u02a5\u02a9\5\u00bc_\2\u02a6\u02a7\7L\2\2\u02a7\u02a8\7"+
		"C\2\2\u02a8\u02aa\7\u0081\2\2\u02a9\u02a6\3\2\2\2\u02a9\u02aa\3\2\2\2"+
		"\u02aa\u02ad\3\2\2\2\u02ab\u02ac\7\u0095\2\2\u02ac\u02ae\5D#\2\u02ad\u02ab"+
		"\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b8\7)\2\2\u02b0"+
		"\u02b5\5p9\2\u02b1\u02b5\5J&\2\u02b2\u02b5\5<\37\2\u02b3\u02b5\5T+\2\u02b4"+
		"\u02b0\3\2\2\2\u02b4\u02b1\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b4\u02b3\3\2"+
		"\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b7\7\3\2\2\u02b7\u02b9\3\2\2\2\u02b8"+
		"\u02b4\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02b8\3\2\2\2\u02ba\u02bb\3\2"+
		"\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02bd\7E\2\2\u02bd/\3\2\2\2\u02be\u02c0"+
		"\7\65\2\2\u02bf\u02c1\t\4\2\2\u02c0\u02bf\3\2\2\2\u02c0\u02c1\3\2\2\2"+
		"\u02c1\u02c2\3\2\2\2\u02c2\u02c6\7\u0093\2\2\u02c3\u02c4\7S\2\2\u02c4"+
		"\u02c5\7i\2\2\u02c5\u02c7\7I\2\2\u02c6\u02c3\3\2\2\2\u02c6\u02c7\3\2\2"+
		"\2\u02c7\u02cb\3\2\2\2\u02c8\u02c9\5\u00ba^\2\u02c9\u02ca\7\4\2\2\u02ca"+
		"\u02cc\3\2\2\2\u02cb\u02c8\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02cd\3\2"+
		"\2\2\u02cd\u02d9\5\u00ccg\2\u02ce\u02cf\7\5\2\2\u02cf\u02d4\5\u00c2b\2"+
		"\u02d0\u02d1\7\7\2\2\u02d1\u02d3\5\u00c2b\2\u02d2\u02d0\3\2\2\2\u02d3"+
		"\u02d6\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d7\3\2"+
		"\2\2\u02d6\u02d4\3\2\2\2\u02d7\u02d8\7\6\2\2\u02d8\u02da\3\2\2\2\u02d9"+
		"\u02ce\3\2\2\2\u02d9\u02da\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02dc\7$"+
		"\2\2\u02dc\u02dd\5T+\2\u02dd\61\3\2\2\2\u02de\u02df\7\65\2\2\u02df\u02e0"+
		"\7\u0094\2\2\u02e0\u02e4\7\u0086\2\2\u02e1\u02e2\7S\2\2\u02e2\u02e3\7"+
		"i\2\2\u02e3\u02e5\7I\2\2\u02e4\u02e1\3\2\2\2\u02e4\u02e5\3\2\2\2\u02e5"+
		"\u02e9\3\2\2\2\u02e6\u02e7\5\u00ba^\2\u02e7\u02e8\7\4\2\2\u02e8\u02ea"+
		"\3\2\2\2\u02e9\u02e6\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb"+
		"\u02ec\5\u00bc_\2\u02ec\u02ed\7\u0090\2\2\u02ed\u02f9\5\u00ceh\2\u02ee"+
		"\u02ef\7\5\2\2\u02ef\u02f4\5\u00b0Y\2\u02f0\u02f1\7\7\2\2\u02f1\u02f3"+
		"\5\u00b0Y\2\u02f2\u02f0\3\2\2\2\u02f3\u02f6\3\2\2\2\u02f4\u02f2\3\2\2"+
		"\2\u02f4\u02f5\3\2\2\2\u02f5\u02f7\3\2\2\2\u02f6\u02f4\3\2\2\2\u02f7\u02f8"+
		"\7\6\2\2\u02f8\u02fa\3\2\2\2\u02f9\u02ee\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa"+
		"\63\3\2\2\2\u02fb\u02fd\7\u0097\2\2\u02fc\u02fe\7w\2\2\u02fd\u02fc\3\2"+
		"\2\2\u02fd\u02fe\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0300\5\66\34\2\u0300"+
		"\u0301\7$\2\2\u0301\u0302\7\5\2\2\u0302\u0303\5T+\2\u0303\u030d\7\6\2"+
		"\2\u0304\u0305\7\7\2\2\u0305\u0306\5\66\34\2\u0306\u0307\7$\2\2\u0307"+
		"\u0308\7\5\2\2\u0308\u0309\5T+\2\u0309\u030a\7\6\2\2\u030a\u030c\3\2\2"+
		"\2\u030b\u0304\3\2\2\2\u030c\u030f\3\2\2\2\u030d\u030b\3\2\2\2\u030d\u030e"+
		"\3\2\2\2\u030e\65\3\2\2\2\u030f\u030d\3\2\2\2\u0310\u031c\5\u00bc_\2\u0311"+
		"\u0312\7\5\2\2\u0312\u0317\5\u00c2b\2\u0313\u0314\7\7\2\2\u0314\u0316"+
		"\5\u00c2b\2\u0315\u0313\3\2\2\2\u0316\u0319\3\2\2\2\u0317\u0315\3\2\2"+
		"\2\u0317\u0318\3\2\2\2\u0318\u031a\3\2\2\2\u0319\u0317\3\2\2\2\u031a\u031b"+
		"\7\6\2\2\u031b\u031d\3\2\2\2\u031c\u0311\3\2\2\2\u031c\u031d\3\2\2\2\u031d"+
		"\67\3\2\2\2\u031e\u031f\5\66\34\2\u031f\u0320\7$\2\2\u0320\u0321\7\5\2"+
		"\2\u0321\u0322\5\u00a8U\2\u0322\u0324\7\u008d\2\2\u0323\u0325\7 \2\2\u0324"+
		"\u0323\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0326\3\2\2\2\u0326\u0327\5\u00aa"+
		"V\2\u0327\u0328\7\6\2\2\u03289\3\2\2\2\u0329\u0335\5\u00bc_\2\u032a\u032b"+
		"\7\5\2\2\u032b\u0330\5\u00c2b\2\u032c\u032d\7\7\2\2\u032d\u032f\5\u00c2"+
		"b\2\u032e\u032c\3\2\2\2\u032f\u0332\3\2\2\2\u0330\u032e\3\2\2\2\u0330"+
		"\u0331\3\2\2\2\u0331\u0333\3\2\2\2\u0332\u0330\3\2\2\2\u0333\u0334\7\6"+
		"\2\2\u0334\u0336\3\2\2\2\u0335\u032a\3\2\2\2\u0335\u0336\3\2\2\2\u0336"+
		"\u0337\3\2\2\2\u0337\u0338\7$\2\2\u0338\u0339\7\5\2\2\u0339\u033a\5T+"+
		"\2\u033a\u033b\7\6\2\2\u033b;\3\2\2\2\u033c\u033e\5\64\33\2\u033d\u033c"+
		"\3\2\2\2\u033d\u033e\3\2\2\2\u033e\u033f\3\2\2\2\u033f\u0340\7>\2\2\u0340"+
		"\u0341\7N\2\2\u0341\u0344\5v<\2\u0342\u0343\7\u0096\2\2\u0343\u0345\5"+
		"D#\2\u0344\u0342\3\2\2\2\u0344\u0345\3\2\2\2\u0345=\3\2\2\2\u0346\u0348"+
		"\5\64\33\2\u0347\u0346\3\2\2\2\u0347\u0348\3\2\2\2\u0348\u0349\3\2\2\2"+
		"\u0349\u034a\7>\2\2\u034a\u034b\7N\2\2\u034b\u034e\5v<\2\u034c\u034d\7"+
		"\u0096\2\2\u034d\u034f\5D#\2\u034e\u034c\3\2\2\2\u034e\u034f\3\2\2\2\u034f"+
		"\u0354\3\2\2\2\u0350\u0352\5\u008cG\2\u0351\u0350\3\2\2\2\u0351\u0352"+
		"\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u0355\5\u008eH\2\u0354\u0351\3\2\2"+
		"\2\u0354\u0355\3\2\2\2\u0355?\3\2\2\2\u0356\u0358\7@\2\2\u0357\u0359\7"+
		":\2\2\u0358\u0357\3\2\2\2\u0358\u0359\3\2\2\2\u0359\u035a\3\2\2\2\u035a"+
		"\u035b\5\u00ba^\2\u035bA\3\2\2\2\u035c\u035d\7B\2\2\u035d\u0360\t\13\2"+
		"\2\u035e\u035f\7S\2\2\u035f\u0361\7I\2\2\u0360\u035e\3\2\2\2\u0360\u0361"+
		"\3\2\2\2\u0361\u0365\3\2\2\2\u0362\u0363\5\u00ba^\2\u0363\u0364\7\4\2"+
		"\2\u0364\u0366\3\2\2\2\u0365\u0362\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0367"+
		"\3\2\2\2\u0367\u0368\5\u00e6t\2\u0368C\3\2\2\2\u0369\u036a\b#\1\2\u036a"+
		"\u03c2\5H%\2\u036b\u03c2\7\u00be\2\2\u036c\u036d\5\u00ba^\2\u036d\u036e"+
		"\7\4\2\2\u036e\u0370\3\2\2\2\u036f\u036c\3\2\2\2\u036f\u0370\3\2\2\2\u0370"+
		"\u0371\3\2\2\2\u0371\u0372\5\u00bc_\2\u0372\u0373\7\4\2\2\u0373\u0375"+
		"\3\2\2\2\u0374\u036f\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u0376\3\2\2\2\u0376"+
		"\u03c2\5\u00c2b\2\u0377\u0378\5\u00acW\2\u0378\u0379\5D#\27\u0379\u03c2"+
		"\3\2\2\2\u037a\u037b\5\u00b8]\2\u037b\u0388\7\5\2\2\u037c\u037e\7A\2\2"+
		"\u037d\u037c\3\2\2\2\u037d\u037e\3\2\2\2\u037e\u037f\3\2\2\2\u037f\u0384"+
		"\5D#\2\u0380\u0381\7\7\2\2\u0381\u0383\5D#\2\u0382\u0380\3\2\2\2\u0383"+
		"\u0386\3\2\2\2\u0384\u0382\3\2\2\2\u0384\u0385\3\2\2\2\u0385\u0389\3\2"+
		"\2\2\u0386\u0384\3\2\2\2\u0387\u0389\7\t\2\2\u0388\u037d\3\2\2\2\u0388"+
		"\u0387\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038c\7\6"+
		"\2\2\u038b\u038d\5z>\2\u038c\u038b\3\2\2\2\u038c\u038d\3\2\2\2\u038d\u038f"+
		"\3\2\2\2\u038e\u0390\5~@\2\u038f\u038e\3\2\2\2\u038f\u0390\3\2\2\2\u0390"+
		"\u03c2\3\2\2\2\u0391\u0392\7\5\2\2\u0392\u0397\5D#\2\u0393\u0394\7\7\2"+
		"\2\u0394\u0396\5D#\2\u0395\u0393\3\2\2\2\u0396\u0399\3\2\2\2\u0397\u0395"+
		"\3\2\2\2\u0397\u0398\3\2\2\2\u0398\u039a\3\2\2\2\u0399\u0397\3\2\2\2\u039a"+
		"\u039b\7\6\2\2\u039b\u03c2\3\2\2\2\u039c\u039d\7.\2\2\u039d\u039e\7\5"+
		"\2\2\u039e\u039f\5D#\2\u039f\u03a0\7$\2\2\u03a0\u03a1\5\"\22\2\u03a1\u03a2"+
		"\7\6\2\2\u03a2\u03c2\3\2\2\2\u03a3\u03a5\7i\2\2\u03a4\u03a3\3\2\2\2\u03a4"+
		"\u03a5\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03a8\7I\2\2\u03a7\u03a4\3\2"+
		"\2\2\u03a7\u03a8\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03aa\7\5\2\2\u03aa"+
		"\u03ab\5T+\2\u03ab\u03ac\7\6\2\2\u03ac\u03c2\3\2\2\2\u03ad\u03af\7-\2"+
		"\2\u03ae\u03b0\5D#\2\u03af\u03ae\3\2\2\2\u03af\u03b0\3\2\2\2\u03b0\u03b6"+
		"\3\2\2\2\u03b1\u03b2\7\u0095\2\2\u03b2\u03b3\5D#\2\u03b3\u03b4\7\u0089"+
		"\2\2\u03b4\u03b5\5D#\2\u03b5\u03b7\3\2\2\2\u03b6\u03b1\3\2\2\2\u03b7\u03b8"+
		"\3\2\2\2\u03b8\u03b6\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9\u03bc\3\2\2\2\u03ba"+
		"\u03bb\7D\2\2\u03bb\u03bd\5D#\2\u03bc\u03ba\3\2\2\2\u03bc\u03bd\3\2\2"+
		"\2\u03bd\u03be\3\2\2\2\u03be\u03bf\7E\2\2\u03bf\u03c2\3\2\2\2\u03c0\u03c2"+
		"\5F$\2\u03c1\u0369\3\2\2\2\u03c1\u036b\3\2\2\2\u03c1\u0374\3\2\2\2\u03c1"+
		"\u0377\3\2\2\2\u03c1\u037a\3\2\2\2\u03c1\u0391\3\2\2\2\u03c1\u039c\3\2"+
		"\2\2\u03c1\u03a7\3\2\2\2\u03c1\u03ad\3\2\2\2\u03c1\u03c0\3\2\2\2\u03c2"+
		"\u043a\3\2\2\2\u03c3\u03c4\f\26\2\2\u03c4\u03c5\7\16\2\2\u03c5\u0439\5"+
		"D#\27\u03c6\u03c7\f\25\2\2\u03c7\u03c8\t\f\2\2\u03c8\u0439\5D#\26\u03c9"+
		"\u03ca\f\24\2\2\u03ca\u03cb\t\6\2\2\u03cb\u0439\5D#\25\u03cc\u03cd\f\23"+
		"\2\2\u03cd\u03ce\t\r\2\2\u03ce\u0439\5D#\24\u03cf\u03d0\f\22\2\2\u03d0"+
		"\u03d1\t\16\2\2\u03d1\u0439\5D#\23\u03d2\u03df\f\21\2\2\u03d3\u03e0\7"+
		"\b\2\2\u03d4\u03e0\7\31\2\2\u03d5\u03e0\7\32\2\2\u03d6\u03e0\7\33\2\2"+
		"\u03d7\u03e0\7_\2\2\u03d8\u03d9\7_\2\2\u03d9\u03e0\7i\2\2\u03da\u03e0"+
		"\7V\2\2\u03db\u03e0\7d\2\2\u03dc\u03e0\7P\2\2\u03dd\u03e0\7f\2\2\u03de"+
		"\u03e0\7y\2\2\u03df\u03d3\3\2\2\2\u03df\u03d4\3\2\2\2\u03df\u03d5\3\2"+
		"\2\2\u03df\u03d6\3\2\2\2\u03df\u03d7\3\2\2\2\u03df\u03d8\3\2\2\2\u03df"+
		"\u03da\3\2\2\2\u03df\u03db\3\2\2\2\u03df\u03dc\3\2\2\2\u03df\u03dd\3\2"+
		"\2\2\u03df\u03de\3\2\2\2\u03e0\u03e1\3\2\2\2\u03e1\u0439\5D#\22\u03e2"+
		"\u03e3\f\20\2\2\u03e3\u03e4\7#\2\2\u03e4\u0439\5D#\21\u03e5\u03e6\f\17"+
		"\2\2\u03e6\u03e7\7o\2\2\u03e7\u0439\5D#\20\u03e8\u03e9\f\b\2\2\u03e9\u03eb"+
		"\7_\2\2\u03ea\u03ec\7i\2\2\u03eb\u03ea\3\2\2\2\u03eb\u03ec\3\2\2\2\u03ec"+
		"\u03ed\3\2\2\2\u03ed\u0439\5D#\t\u03ee\u03f0\f\7\2\2\u03ef\u03f1\7i\2"+
		"\2\u03f0\u03ef\3\2\2\2\u03f0\u03f1\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03f3"+
		"\7*\2\2\u03f3\u03f4\5D#\2\u03f4\u03f5\7#\2\2\u03f5\u03f6\5D#\b\u03f6\u0439"+
		"\3\2\2\2\u03f7\u03f8\f\13\2\2\u03f8\u03f9\7\60\2\2\u03f9\u0439\5\u00c4"+
		"c\2\u03fa\u03fc\f\n\2\2\u03fb\u03fd\7i\2\2\u03fc\u03fb\3\2\2\2\u03fc\u03fd"+
		"\3\2\2\2\u03fd\u03fe\3\2\2\2\u03fe\u03ff\t\17\2\2\u03ff\u0402\5D#\2\u0400"+
		"\u0401\7F\2\2\u0401\u0403\5D#\2\u0402\u0400\3\2\2\2\u0402\u0403\3\2\2"+
		"\2\u0403\u0439\3\2\2\2\u0404\u0409\f\t\2\2\u0405\u040a\7`\2\2\u0406\u040a"+
		"\7j\2\2\u0407\u0408\7i\2\2\u0408\u040a\7k\2\2\u0409\u0405\3\2\2\2\u0409"+
		"\u0406\3\2\2\2\u0409\u0407\3\2\2\2\u040a\u0439\3\2\2\2\u040b\u040d\f\6"+
		"\2\2\u040c\u040e\7i\2\2\u040d\u040c\3\2\2\2\u040d\u040e\3\2\2\2\u040e"+
		"\u040f\3\2\2\2\u040f\u0436\7V\2\2\u0410\u041a\7\5\2\2\u0411\u041b\5T+"+
		"\2\u0412\u0417\5D#\2\u0413\u0414\7\7\2\2\u0414\u0416\5D#\2\u0415\u0413"+
		"\3\2\2\2\u0416\u0419\3\2\2\2\u0417\u0415\3\2\2\2\u0417\u0418\3\2\2\2\u0418"+
		"\u041b\3\2\2\2\u0419\u0417\3\2\2\2\u041a\u0411\3\2\2\2\u041a\u0412\3\2"+
		"\2\2\u041a\u041b\3\2\2\2\u041b\u041c\3\2\2\2\u041c\u0437\7\6\2\2\u041d"+
		"\u041e\5\u00ba^\2\u041e\u041f\7\4\2\2\u041f\u0421\3\2\2\2\u0420\u041d"+
		"\3\2\2\2\u0420\u0421\3\2\2\2\u0421\u0422\3\2\2\2\u0422\u0437\5\u00bc_"+
		"\2\u0423\u0424\5\u00ba^\2\u0424\u0425\7\4\2\2\u0425\u0427\3\2\2\2\u0426"+
		"\u0423\3\2\2\2\u0426\u0427\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u0429\5\u00e4"+
		"s\2\u0429\u0432\7\5\2\2\u042a\u042f\5D#\2\u042b\u042c\7\7\2\2\u042c\u042e"+
		"\5D#\2\u042d\u042b\3\2\2\2\u042e\u0431\3\2\2\2\u042f\u042d\3\2\2\2\u042f"+
		"\u0430\3\2\2\2\u0430\u0433\3\2\2\2\u0431\u042f\3\2\2\2\u0432\u042a\3\2"+
		"\2\2\u0432\u0433\3\2\2\2\u0433\u0434\3\2\2\2\u0434\u0435\7\6\2\2\u0435"+
		"\u0437\3\2\2\2\u0436\u0410\3\2\2\2\u0436\u0420\3\2\2\2\u0436\u0426\3\2"+
		"\2\2\u0437\u0439\3\2\2\2\u0438\u03c3\3\2\2\2\u0438\u03c6\3\2\2\2\u0438"+
		"\u03c9\3\2\2\2\u0438\u03cc\3\2\2\2\u0438\u03cf\3\2\2\2\u0438\u03d2\3\2"+
		"\2\2\u0438\u03e2\3\2\2\2\u0438\u03e5\3\2\2\2\u0438\u03e8\3\2\2\2\u0438"+
		"\u03ee\3\2\2\2\u0438\u03f7\3\2\2\2\u0438\u03fa\3\2\2\2\u0438\u0404\3\2"+
		"\2\2\u0438\u040b\3\2\2\2\u0439\u043c\3\2\2\2\u043a\u0438\3\2\2\2\u043a"+
		"\u043b\3\2\2\2\u043bE\3\2\2\2\u043c\u043a\3\2\2\2\u043d\u043e\7v\2\2\u043e"+
		"\u0443\7\5\2\2\u043f\u0444\7T\2\2\u0440\u0441\t\20\2\2\u0441\u0442\7\7"+
		"\2\2\u0442\u0444\5\u00aeX\2\u0443\u043f\3\2\2\2\u0443\u0440\3\2\2\2\u0444"+
		"\u0445\3\2\2\2\u0445\u0446\7\6\2\2\u0446G\3\2\2\2\u0447\u0448\t\21\2\2"+
		"\u0448I\3\2\2\2\u0449\u044b\5\64\33\2\u044a\u0449\3\2\2\2\u044a\u044b"+
		"\3\2\2\2\u044b\u0451\3\2\2\2\u044c\u0452\7[\2\2\u044d\u0452\7}\2\2\u044e"+
		"\u044f\7[\2\2\u044f\u0450\7o\2\2\u0450\u0452\t\n\2\2\u0451\u044c\3\2\2"+
		"\2\u0451\u044d\3\2\2\2\u0451\u044e\3\2\2\2\u0452\u0453\3\2\2\2\u0453\u0457"+
		"\7^\2\2\u0454\u0455\5\u00ba^\2\u0455\u0456\7\4\2\2\u0456\u0458\3\2\2\2"+
		"\u0457\u0454\3\2\2\2\u0457\u0458\3\2\2\2\u0458\u0459\3\2\2\2\u0459\u045c"+
		"\5\u00bc_\2\u045a\u045b\7$\2\2\u045b\u045d\5\u00d4k\2\u045c\u045a\3\2"+
		"\2\2\u045c\u045d\3\2\2\2\u045d\u0469\3\2\2\2\u045e\u045f\7\5\2\2\u045f"+
		"\u0464\5\u00c2b\2\u0460\u0461\7\7\2\2\u0461\u0463\5\u00c2b\2\u0462\u0460"+
		"\3\2\2\2\u0463\u0466\3\2\2\2\u0464\u0462\3\2\2\2\u0464\u0465\3\2\2\2\u0465"+
		"\u0467\3\2\2\2\u0466\u0464\3\2\2\2\u0467\u0468\7\6\2\2\u0468\u046a\3\2"+
		"\2\2\u0469\u045e\3\2\2\2\u0469\u046a\3\2\2\2\u046a\u0488\3\2\2\2\u046b"+
		"\u046c\7\u0092\2\2\u046c\u046d\7\5\2\2\u046d\u0472\5D#\2\u046e\u046f\7"+
		"\7\2\2\u046f\u0471\5D#\2\u0470\u046e\3\2\2\2\u0471\u0474\3\2\2\2\u0472"+
		"\u0470\3\2\2\2\u0472\u0473\3\2\2\2\u0473\u0475\3\2\2\2\u0474\u0472\3\2"+
		"\2\2\u0475\u0484\7\6\2\2\u0476\u0477\7\7\2\2\u0477\u0478\7\5\2\2\u0478"+
		"\u047d\5D#\2\u0479\u047a\7\7\2\2\u047a\u047c\5D#\2\u047b\u0479\3\2\2\2"+
		"\u047c\u047f\3\2\2\2\u047d\u047b\3\2\2\2\u047d\u047e\3\2\2\2\u047e\u0480"+
		"\3\2\2\2\u047f\u047d\3\2\2\2\u0480\u0481\7\6\2\2\u0481\u0483\3\2\2\2\u0482"+
		"\u0476\3\2\2\2\u0483\u0486\3\2\2\2\u0484\u0482\3\2\2\2\u0484\u0485\3\2"+
		"\2\2\u0485\u0489\3\2\2\2\u0486\u0484\3\2\2\2\u0487\u0489\5T+\2\u0488\u046b"+
		"\3\2\2\2\u0488\u0487\3\2\2\2\u0489\u048b\3\2\2\2\u048a\u048c\5L\'\2\u048b"+
		"\u048a\3\2\2\2\u048b\u048c\3\2\2\2\u048c\u0490\3\2\2\2\u048d\u048e\7;"+
		"\2\2\u048e\u0490\7\u0092\2\2\u048f\u044a\3\2\2\2\u048f\u048d\3\2\2\2\u0490"+
		"K\3\2\2\2\u0491\u0492\7n\2\2\u0492\u04a1\7\63\2\2\u0493\u0494\7\5\2\2"+
		"\u0494\u0499\5\34\17\2\u0495\u0496\7\7\2\2\u0496\u0498\5\34\17\2\u0497"+
		"\u0495\3\2\2\2\u0498\u049b\3\2\2\2\u0499\u0497\3\2\2\2\u0499\u049a\3\2"+
		"\2\2\u049a\u049c\3\2\2\2\u049b\u0499\3\2\2\2\u049c\u049f\7\6\2\2\u049d"+
		"\u049e\7\u0096\2\2\u049e\u04a0\5D#\2\u049f\u049d\3\2\2\2\u049f\u04a0\3"+
		"\2\2\2\u04a0\u04a2\3\2\2\2\u04a1\u0493\3\2\2\2\u04a1\u04a2\3\2\2\2\u04a2"+
		"\u04a3\3\2\2\2\u04a3\u04be\7\u00b9\2\2\u04a4\u04bf\7\u00ba\2\2\u04a5\u04a6"+
		"\7\u008f\2\2\u04a6\u04a9\7\u0085\2\2\u04a7\u04aa\5\u00c2b\2\u04a8\u04aa"+
		"\5r:\2\u04a9\u04a7\3\2\2\2\u04a9\u04a8\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab"+
		"\u04ac\7\31\2\2\u04ac\u04b7\5D#\2\u04ad\u04b0\7\7\2\2\u04ae\u04b1\5\u00c2"+
		"b\2\u04af\u04b1\5r:\2\u04b0\u04ae\3\2\2\2\u04b0\u04af\3\2\2\2\u04b1\u04b2"+
		"\3\2\2\2\u04b2\u04b3\7\31\2\2\u04b3\u04b4\5D#\2\u04b4\u04b6\3\2\2\2\u04b5"+
		"\u04ad\3\2\2\2\u04b6\u04b9\3\2\2\2\u04b7\u04b5\3\2\2\2\u04b7\u04b8\3\2"+
		"\2\2\u04b8\u04bc\3\2\2\2\u04b9\u04b7\3\2\2\2\u04ba\u04bb\7\u0096\2\2\u04bb"+
		"\u04bd\5D#\2\u04bc\u04ba\3\2\2\2\u04bc\u04bd\3\2\2\2\u04bd\u04bf\3\2\2"+
		"\2\u04be\u04a4\3\2\2\2\u04be\u04a5\3\2\2\2\u04bfM\3\2\2\2\u04c0\u04c4"+
		"\7s\2\2\u04c1\u04c2\5\u00ba^\2\u04c2\u04c3\7\4\2\2\u04c3\u04c5\3\2\2\2"+
		"\u04c4\u04c1\3\2\2\2\u04c4\u04c5\3\2\2\2\u04c5\u04c6\3\2\2\2\u04c6\u04cd"+
		"\5\u00d0i\2\u04c7\u04c8\7\b\2\2\u04c8\u04ce\5P)\2\u04c9\u04ca\7\5\2\2"+
		"\u04ca\u04cb\5P)\2\u04cb\u04cc\7\6\2\2\u04cc\u04ce\3\2\2\2\u04cd\u04c7"+
		"\3\2\2\2\u04cd\u04c9\3\2\2\2\u04cd\u04ce\3\2\2\2\u04ceO\3\2\2\2\u04cf"+
		"\u04d3\5&\24\2\u04d0\u04d3\5\u00b6\\\2\u04d1\u04d3\7\u00bf\2\2\u04d2\u04cf"+
		"\3\2\2\2\u04d2\u04d0\3\2\2\2\u04d2\u04d1\3\2\2\2\u04d3Q\3\2\2\2\u04d4"+
		"\u04df\7z\2\2\u04d5\u04e0\5\u00c4c\2\u04d6\u04d7\5\u00ba^\2\u04d7\u04d8"+
		"\7\4\2\2\u04d8\u04da\3\2\2\2\u04d9\u04d6\3\2\2\2\u04d9\u04da\3\2\2\2\u04da"+
		"\u04dd\3\2\2\2\u04db\u04de\5\u00bc_\2\u04dc\u04de\5\u00c8e\2\u04dd\u04db"+
		"\3\2\2\2\u04dd\u04dc\3\2\2\2\u04de\u04e0\3\2\2\2\u04df\u04d5\3\2\2\2\u04df"+
		"\u04d9\3\2\2\2\u04df\u04e0\3\2\2\2\u04e0S\3\2\2\2\u04e1\u04e3\5\u008a"+
		"F\2\u04e2\u04e1\3\2\2\2\u04e2\u04e3\3\2\2\2\u04e3\u04e4\3\2\2\2\u04e4"+
		"\u04ea\5X-\2\u04e5\u04e6\5n8\2\u04e6\u04e7\5X-\2\u04e7\u04e9\3\2\2\2\u04e8"+
		"\u04e5\3\2\2\2\u04e9\u04ec\3\2\2\2\u04ea\u04e8\3\2\2\2\u04ea\u04eb\3\2"+
		"\2\2\u04eb\u04ee\3\2\2\2\u04ec\u04ea\3\2\2\2\u04ed\u04ef\5\u008cG\2\u04ee"+
		"\u04ed\3\2\2\2\u04ee\u04ef\3\2\2\2\u04ef\u04f1\3\2\2\2\u04f0\u04f2\5\u008e"+
		"H\2\u04f1\u04f0\3\2\2\2\u04f1\u04f2\3\2\2\2\u04f2U\3\2\2\2\u04f3\u04fb"+
		"\5f\64\2\u04f4\u04f5\5j\66\2\u04f5\u04f7\5f\64\2\u04f6\u04f8\5l\67\2\u04f7"+
		"\u04f6\3\2\2\2\u04f7\u04f8\3\2\2\2\u04f8\u04fa\3\2\2\2\u04f9\u04f4\3\2"+
		"\2\2\u04fa\u04fd\3\2\2\2\u04fb\u04f9\3\2\2\2\u04fb\u04fc\3\2\2\2\u04fc"+
		"W\3\2\2\2\u04fd\u04fb\3\2\2\2\u04fe\u0500\7\u0084\2\2\u04ff\u0501\t\22"+
		"\2\2\u0500\u04ff\3\2\2\2\u0500\u0501\3\2\2\2\u0501\u0502\3\2\2\2\u0502"+
		"\u0507\5h\65\2\u0503\u0504\7\7\2\2\u0504\u0506\5h\65\2\u0505\u0503\3\2"+
		"\2\2\u0506\u0509\3\2\2\2\u0507\u0505\3\2\2\2\u0507\u0508\3\2\2\2\u0508"+
		"\u0516\3\2\2\2\u0509\u0507\3\2\2\2\u050a\u0514\7N\2\2\u050b\u0510\5f\64"+
		"\2\u050c\u050d\7\7\2\2\u050d\u050f\5f\64\2\u050e\u050c\3\2\2\2\u050f\u0512"+
		"\3\2\2\2\u0510\u050e\3\2\2\2\u0510\u0511\3\2\2\2\u0511\u0515\3\2\2\2\u0512"+
		"\u0510\3\2\2\2\u0513\u0515\5V,\2\u0514\u050b\3\2\2\2\u0514\u0513\3\2\2"+
		"\2\u0515\u0517\3\2\2\2\u0516\u050a\3\2\2\2\u0516\u0517\3\2\2\2\u0517\u0519"+
		"\3\2\2\2\u0518\u051a\5Z.\2\u0519\u0518\3\2\2\2\u0519\u051a\3\2\2\2\u051a"+
		"\u051c\3\2\2\2\u051b\u051d\5\\/\2\u051c\u051b\3\2\2\2\u051c\u051d\3\2"+
		"\2\2\u051d\u052c\3\2\2\2\u051e\u051f\7\u00b0\2\2\u051f\u0520\5\u00d8m"+
		"\2\u0520\u0521\7$\2\2\u0521\u0529\5|?\2\u0522\u0523\7\7\2\2\u0523\u0524"+
		"\5\u00d8m\2\u0524\u0525\7$\2\2\u0525\u0526\5|?\2\u0526\u0528\3\2\2\2\u0527"+
		"\u0522\3\2\2\2\u0528\u052b\3\2\2\2\u0529\u0527\3\2\2\2\u0529\u052a\3\2"+
		"\2\2\u052a\u052d\3\2\2\2\u052b\u0529\3\2\2\2\u052c\u051e\3\2\2\2\u052c"+
		"\u052d\3\2\2\2\u052d\u054b\3\2\2\2\u052e\u052f\7\u0092\2\2\u052f\u0530"+
		"\7\5\2\2\u0530\u0535\5D#\2\u0531\u0532\7\7\2\2\u0532\u0534\5D#\2\u0533"+
		"\u0531\3\2\2\2\u0534\u0537\3\2\2\2\u0535\u0533\3\2\2\2\u0535\u0536\3\2"+
		"\2\2\u0536\u0538\3\2\2\2\u0537\u0535\3\2\2\2\u0538\u0547\7\6\2\2\u0539"+
		"\u053a\7\7\2\2\u053a\u053b\7\5\2\2\u053b\u0540\5D#\2\u053c\u053d\7\7\2"+
		"\2\u053d\u053f\5D#\2\u053e\u053c\3\2\2\2\u053f\u0542\3\2\2\2\u0540\u053e"+
		"\3\2\2\2\u0540\u0541\3\2\2\2\u0541\u0543\3\2\2\2\u0542\u0540\3\2\2\2\u0543"+
		"\u0544\7\6\2\2\u0544\u0546\3\2\2\2\u0545\u0539\3\2\2\2\u0546\u0549\3\2"+
		"\2\2\u0547\u0545\3\2\2\2\u0547\u0548\3\2\2\2\u0548\u054b\3\2\2\2\u0549"+
		"\u0547\3\2\2\2\u054a\u04fe\3\2\2\2\u054a\u052e\3\2\2\2\u054bY\3\2\2\2"+
		"\u054c\u054d\7\u0096\2\2\u054d\u054e\5D#\2\u054e[\3\2\2\2\u054f\u0550"+
		"\7Q\2\2\u0550\u0551\7+\2\2\u0551\u0556\5D#\2\u0552\u0553\7\7\2\2\u0553"+
		"\u0555\5D#\2\u0554\u0552\3\2\2\2\u0555\u0558\3\2\2\2\u0556\u0554\3\2\2"+
		"\2\u0556\u0557\3\2\2\2\u0557\u055a\3\2\2\2\u0558\u0556\3\2\2\2\u0559\u055b"+
		"\5^\60\2\u055a\u0559\3\2\2\2\u055a\u055b\3\2\2\2\u055b]\3\2\2\2\u055c"+
		"\u055d\7R\2\2\u055d\u055e\5D#\2\u055e_\3\2\2\2\u055f\u0560\5T+\2\u0560"+
		"a\3\2\2\2\u0561\u0563\5\u008aF\2\u0562\u0561\3\2\2\2\u0562\u0563\3\2\2"+
		"\2\u0563\u0564\3\2\2\2\u0564\u0566\5X-\2\u0565\u0567\5\u008cG\2\u0566"+
		"\u0565\3\2\2\2\u0566\u0567\3\2\2\2\u0567\u0569\3\2\2\2\u0568\u056a\5\u008e"+
		"H\2\u0569\u0568\3\2\2\2\u0569\u056a\3\2\2\2\u056ac\3\2\2\2\u056b\u056d"+
		"\5\u008aF\2\u056c\u056b\3\2\2\2\u056c\u056d\3\2\2\2\u056d\u056e\3\2\2"+
		"\2\u056e\u0578\5X-\2\u056f\u0571\7\u008d\2\2\u0570\u0572\7 \2\2\u0571"+
		"\u0570\3\2\2\2\u0571\u0572\3\2\2\2\u0572\u0576\3\2\2\2\u0573\u0576\7]"+
		"\2\2\u0574\u0576\7G\2\2\u0575\u056f\3\2\2\2\u0575\u0573\3\2\2\2\u0575"+
		"\u0574\3\2\2\2\u0576\u0577\3\2\2\2\u0577\u0579\5X-\2\u0578\u0575\3\2\2"+
		"\2\u0579\u057a\3\2\2\2\u057a\u0578\3\2\2\2\u057a\u057b\3\2\2\2\u057b\u057d"+
		"\3\2\2\2\u057c\u057e\5\u008cG\2\u057d\u057c\3\2\2\2\u057d\u057e\3\2\2"+
		"\2\u057e\u0580\3\2\2\2\u057f\u0581\5\u008eH\2\u0580\u057f\3\2\2\2\u0580"+
		"\u0581\3\2\2\2\u0581e\3\2\2\2\u0582\u0583\5\u00ba^\2\u0583\u0584\7\4\2"+
		"\2\u0584\u0586\3\2\2\2\u0585\u0582\3\2\2\2\u0585\u0586\3\2\2\2\u0586\u0587"+
		"\3\2\2\2\u0587\u058c\5\u00bc_\2\u0588\u058a\7$\2\2\u0589\u0588\3\2\2\2"+
		"\u0589\u058a\3\2\2\2\u058a\u058b\3\2\2\2\u058b\u058d\5\u00d4k\2\u058c"+
		"\u0589\3\2\2\2\u058c\u058d\3\2\2\2\u058d\u0593\3\2\2\2\u058e\u058f\7X"+
		"\2\2\u058f\u0590\7+\2\2\u0590\u0594\5\u00c8e\2\u0591\u0592\7i\2\2\u0592"+
		"\u0594\7X\2\2\u0593\u058e\3\2\2\2\u0593\u0591\3\2\2\2\u0593\u0594\3\2"+
		"\2\2\u0594\u05c3\3\2\2\2\u0595\u0596\5\u00ba^\2\u0596\u0597\7\4\2\2\u0597"+
		"\u0599\3\2\2\2\u0598\u0595\3\2\2\2\u0598\u0599\3\2\2\2\u0599\u059a\3\2"+
		"\2\2\u059a\u059b\5\u00e4s\2\u059b\u059c\7\5\2\2\u059c\u05a1\5D#\2\u059d"+
		"\u059e\7\7\2\2\u059e\u05a0\5D#\2\u059f\u059d\3\2\2\2\u05a0\u05a3\3\2\2"+
		"\2\u05a1\u059f\3\2\2\2\u05a1\u05a2\3\2\2\2\u05a2\u05a4\3\2\2\2\u05a3\u05a1"+
		"\3\2\2\2\u05a4\u05a9\7\6\2\2\u05a5\u05a7\7$\2\2\u05a6\u05a5\3\2\2\2\u05a6"+
		"\u05a7\3\2\2\2\u05a7\u05a8\3\2\2\2\u05a8\u05aa\5\u00d4k\2\u05a9\u05a6"+
		"\3\2\2\2\u05a9\u05aa\3\2\2\2\u05aa\u05c3\3\2\2\2\u05ab\u05b5\7\5\2\2\u05ac"+
		"\u05b1\5f\64\2\u05ad\u05ae\7\7\2\2\u05ae\u05b0\5f\64\2\u05af\u05ad\3\2"+
		"\2\2\u05b0\u05b3\3\2\2\2\u05b1\u05af\3\2\2\2\u05b1\u05b2\3\2\2\2\u05b2"+
		"\u05b6\3\2\2\2\u05b3\u05b1\3\2\2\2\u05b4\u05b6\5V,\2\u05b5\u05ac\3\2\2"+
		"\2\u05b5\u05b4\3\2\2\2\u05b6\u05b7\3\2\2\2\u05b7\u05b8\7\6\2\2\u05b8\u05c3"+
		"\3\2\2\2\u05b9\u05ba\7\5\2\2\u05ba\u05bb\5T+\2\u05bb\u05c0\7\6\2\2\u05bc"+
		"\u05be\7$\2\2\u05bd\u05bc\3\2\2\2\u05bd\u05be\3\2\2\2\u05be\u05bf\3\2"+
		"\2\2\u05bf\u05c1\5\u00d4k\2\u05c0\u05bd\3\2\2\2\u05c0\u05c1\3\2\2\2\u05c1"+
		"\u05c3\3\2\2\2\u05c2\u0585\3\2\2\2\u05c2\u0598\3\2\2\2\u05c2\u05ab\3\2"+
		"\2\2\u05c2\u05b9\3\2\2\2\u05c3g\3\2\2\2\u05c4\u05d1\7\t\2\2\u05c5\u05c6"+
		"\5\u00bc_\2\u05c6\u05c7\7\4\2\2\u05c7\u05c8\7\t\2\2\u05c8\u05d1\3\2\2"+
		"\2\u05c9\u05ce\5D#\2\u05ca\u05cc\7$\2\2\u05cb\u05ca\3\2\2\2\u05cb\u05cc"+
		"\3\2\2\2\u05cc\u05cd\3\2\2\2\u05cd\u05cf\5\u00b2Z\2\u05ce\u05cb\3\2\2"+
		"\2\u05ce\u05cf\3\2\2\2\u05cf\u05d1\3\2\2\2\u05d0\u05c4\3\2\2\2\u05d0\u05c5"+
		"\3\2\2\2\u05d0\u05c9\3\2\2\2\u05d1i\3\2\2\2\u05d2\u05e0\7\7\2\2\u05d3"+
		"\u05d5\7g\2\2\u05d4\u05d3\3\2\2\2\u05d4\u05d5\3\2\2\2\u05d5\u05dc\3\2"+
		"\2\2\u05d6\u05d8\7c\2\2\u05d7\u05d9\7q\2\2\u05d8\u05d7\3\2\2\2\u05d8\u05d9"+
		"\3\2\2\2\u05d9\u05dd\3\2\2\2\u05da\u05dd\7Z\2\2\u05db\u05dd\7\66\2\2\u05dc"+
		"\u05d6\3\2\2\2\u05dc\u05da\3\2\2\2\u05dc\u05db\3\2\2\2\u05dc\u05dd\3\2"+
		"\2\2\u05dd\u05de\3\2\2\2\u05de\u05e0\7a\2\2\u05df\u05d2\3\2\2\2\u05df"+
		"\u05d4\3\2\2\2\u05e0k\3\2\2\2\u05e1\u05e2\7n\2\2\u05e2\u05f0\5D#\2\u05e3"+
		"\u05e4\7\u0090\2\2\u05e4\u05e5\7\5\2\2\u05e5\u05ea\5\u00c2b\2\u05e6\u05e7"+
		"\7\7\2\2\u05e7\u05e9\5\u00c2b\2\u05e8\u05e6\3\2\2\2\u05e9\u05ec\3\2\2"+
		"\2\u05ea\u05e8\3\2\2\2\u05ea\u05eb\3\2\2\2\u05eb\u05ed\3\2\2\2\u05ec\u05ea"+
		"\3\2\2\2\u05ed\u05ee\7\6\2\2\u05ee\u05f0\3\2\2\2\u05ef\u05e1\3\2\2\2\u05ef"+
		"\u05e3\3\2\2\2\u05f0m\3\2\2\2\u05f1\u05f3\7\u008d\2\2\u05f2\u05f4\7 \2"+
		"\2\u05f3\u05f2\3\2\2\2\u05f3\u05f4\3\2\2\2\u05f4\u05f8\3\2\2\2\u05f5\u05f8"+
		"\7]\2\2\u05f6\u05f8\7G\2\2\u05f7\u05f1\3\2\2\2\u05f7\u05f5\3\2\2\2\u05f7"+
		"\u05f6\3\2\2\2\u05f8o\3\2\2\2\u05f9\u05fb\5\64\33\2\u05fa\u05f9\3\2\2"+
		"\2\u05fa\u05fb\3\2\2\2\u05fb\u05fc\3\2\2\2\u05fc\u05ff\7\u008f\2\2\u05fd"+
		"\u05fe\7o\2\2\u05fe\u0600\t\n\2\2\u05ff\u05fd\3\2\2\2\u05ff\u0600\3\2"+
		"\2\2\u0600\u0601\3\2\2\2\u0601\u0602\5v<\2\u0602\u0605\7\u0085\2\2\u0603"+
		"\u0606\5\u00c2b\2\u0604\u0606\5r:\2\u0605\u0603\3\2\2\2\u0605\u0604\3"+
		"\2\2\2\u0606\u0607\3\2\2\2\u0607\u0608\7\b\2\2\u0608\u0613\5D#\2\u0609"+
		"\u060c\7\7\2\2\u060a\u060d\5\u00c2b\2\u060b\u060d\5r:\2\u060c\u060a\3"+
		"\2\2\2\u060c\u060b\3\2\2\2\u060d\u060e\3\2\2\2\u060e\u060f\7\b\2\2\u060f"+
		"\u0610\5D#\2\u0610\u0612\3\2\2\2\u0611\u0609\3\2\2\2\u0612\u0615\3\2\2"+
		"\2\u0613\u0611\3\2\2\2\u0613\u0614\3\2\2\2\u0614\u0618\3\2\2\2\u0615\u0613"+
		"\3\2\2\2\u0616\u0617\7\u0096\2\2\u0617\u0619\5D#\2\u0618\u0616\3\2\2\2"+
		"\u0618\u0619\3\2\2\2\u0619q\3\2\2\2\u061a\u061b\7\5\2\2\u061b\u0620\5"+
		"\u00c2b\2\u061c\u061d\7\7\2\2\u061d\u061f\5\u00c2b\2\u061e\u061c\3\2\2"+
		"\2\u061f\u0622\3\2\2\2\u0620\u061e\3\2\2\2\u0620\u0621\3\2\2\2\u0621\u0623"+
		"\3\2\2\2\u0622\u0620\3\2\2\2\u0623\u0624\7\6\2\2\u0624s\3\2\2\2\u0625"+
		"\u0627\5\64\33\2\u0626\u0625\3\2\2\2\u0626\u0627\3\2\2\2\u0627\u0628\3"+
		"\2\2\2\u0628\u062b\7\u008f\2\2\u0629\u062a\7o\2\2\u062a\u062c\t\n\2\2"+
		"\u062b\u0629\3\2\2\2\u062b\u062c\3\2\2\2\u062c\u062d\3\2\2\2\u062d\u062e"+
		"\5v<\2\u062e\u0631\7\u0085\2\2\u062f\u0632\5\u00c2b\2\u0630\u0632\5r:"+
		"\2\u0631\u062f\3\2\2\2\u0631\u0630\3\2\2\2\u0632\u0633\3\2\2\2\u0633\u0634"+
		"\7\b\2\2\u0634\u063f\5D#\2\u0635\u0638\7\7\2\2\u0636\u0639\5\u00c2b\2"+
		"\u0637\u0639\5r:\2\u0638\u0636\3\2\2\2\u0638\u0637\3\2\2\2\u0639\u063a"+
		"\3\2\2\2\u063a\u063b\7\b\2\2\u063b\u063c\5D#\2\u063c\u063e\3\2\2\2\u063d"+
		"\u0635\3\2\2\2\u063e\u0641\3\2\2\2\u063f\u063d\3\2\2\2\u063f\u0640\3\2"+
		"\2\2\u0640\u0644\3\2\2\2\u0641\u063f\3\2\2\2\u0642\u0643\7\u0096\2\2\u0643"+
		"\u0645\5D#\2\u0644\u0642\3\2\2\2\u0644\u0645\3\2\2\2\u0645\u064a\3\2\2"+
		"\2\u0646\u0648\5\u008cG\2\u0647\u0646\3\2\2\2\u0647\u0648\3\2\2\2\u0648"+
		"\u0649\3\2\2\2\u0649\u064b\5\u008eH\2\u064a\u0647\3\2\2\2\u064a\u064b"+
		"\3\2\2\2\u064bu\3\2\2\2\u064c\u064d\5\u00ba^\2\u064d\u064e\7\4\2\2\u064e"+
		"\u0650\3\2\2\2\u064f\u064c\3\2\2\2\u064f\u0650\3\2\2\2\u0650\u0651\3\2"+
		"\2\2\u0651\u0654\5\u00bc_\2\u0652\u0653\7$\2\2\u0653\u0655\5\u00dan\2"+
		"\u0654\u0652\3\2\2\2\u0654\u0655\3\2\2\2\u0655\u065b\3\2\2\2\u0656\u0657"+
		"\7X\2\2\u0657\u0658\7+\2\2\u0658\u065c\5\u00c8e\2\u0659\u065a\7i\2\2\u065a"+
		"\u065c\7X\2\2\u065b\u0656\3\2\2\2\u065b\u0659\3\2\2\2\u065b\u065c\3\2"+
		"\2\2\u065cw\3\2\2\2\u065d\u065f\7\u0091\2\2\u065e\u0660\5\u00ba^\2\u065f"+
		"\u065e\3\2\2\2\u065f\u0660\3\2\2\2\u0660\u0663\3\2\2\2\u0661\u0662\7^"+
		"\2\2\u0662\u0664\5\u00dco\2\u0663\u0661\3\2\2\2\u0663\u0664\3\2\2\2\u0664"+
		"y\3\2\2\2\u0665\u0666\7\u00b4\2\2\u0666\u0667\7\5\2\2\u0667\u0668\7\u0096"+
		"\2\2\u0668\u0669\5D#\2\u0669\u066a\7\6\2\2\u066a{\3\2\2\2\u066b\u066d"+
		"\7\5\2\2\u066c\u066e\5\u00dep\2\u066d\u066c\3\2\2\2\u066d\u066e\3\2\2"+
		"\2\u066e\u0679\3\2\2\2\u066f\u0670\7\u009b\2\2\u0670\u0671\7+\2\2\u0671"+
		"\u0676\5D#\2\u0672\u0673\7\7\2\2\u0673\u0675\5D#\2\u0674\u0672\3\2\2\2"+
		"\u0675\u0678\3\2\2\2\u0676\u0674\3\2\2\2\u0676\u0677\3\2\2\2\u0677\u067a"+
		"\3\2\2\2\u0678\u0676\3\2\2\2\u0679\u066f\3\2\2\2\u0679\u067a\3\2\2\2\u067a"+
		"\u067b\3\2\2\2\u067b\u067c\7p\2\2\u067c\u067d\7+\2\2\u067d\u0682\5\u0090"+
		"I\2\u067e\u067f\7\7\2\2\u067f\u0681\5\u0090I\2\u0680\u067e\3\2\2\2\u0681"+
		"\u0684\3\2\2\2\u0682\u0680\3\2\2\2\u0682\u0683\3\2\2\2\u0683\u0686\3\2"+
		"\2\2\u0684\u0682\3\2\2\2\u0685\u0687\5\u0080A\2\u0686\u0685\3\2\2\2\u0686"+
		"\u0687\3\2\2\2\u0687\u0688\3\2\2\2\u0688\u0689\7\6\2\2\u0689}\3\2\2\2"+
		"\u068a\u06ac\7\u009a\2\2\u068b\u06ad\5\u00d8m\2\u068c\u068e\7\5\2\2\u068d"+
		"\u068f\5\u00dep\2\u068e\u068d\3\2\2\2\u068e\u068f\3\2\2\2\u068f\u069a"+
		"\3\2\2\2\u0690\u0691\7\u009b\2\2\u0691\u0692\7+\2\2\u0692\u0697\5D#\2"+
		"\u0693\u0694\7\7\2\2\u0694\u0696\5D#\2\u0695\u0693\3\2\2\2\u0696\u0699"+
		"\3\2\2\2\u0697\u0695\3\2\2\2\u0697\u0698\3\2\2\2\u0698\u069b\3\2\2\2\u0699"+
		"\u0697\3\2\2\2\u069a\u0690\3\2\2\2\u069a\u069b\3\2\2\2\u069b\u06a6\3\2"+
		"\2\2\u069c\u069d\7p\2\2\u069d\u069e\7+\2\2\u069e\u06a3\5\u0090I\2\u069f"+
		"\u06a0\7\7\2\2\u06a0\u06a2\5\u0090I\2\u06a1\u069f\3\2\2\2\u06a2\u06a5"+
		"\3\2\2\2\u06a3\u06a1\3\2\2\2\u06a3\u06a4\3\2\2\2\u06a4\u06a7\3\2\2\2\u06a5"+
		"\u06a3\3\2\2\2\u06a6\u069c\3\2\2\2\u06a6\u06a7\3\2\2\2\u06a7\u06a9\3\2"+
		"\2\2\u06a8\u06aa\5\u0080A\2\u06a9\u06a8\3\2\2\2\u06a9\u06aa\3\2\2\2\u06aa"+
		"\u06ab\3\2\2\2\u06ab\u06ad\7\6\2\2\u06ac\u068b\3\2\2\2\u06ac\u068c\3\2"+
		"\2\2\u06ad\177\3\2\2\2\u06ae\u06b6\5\u0082B\2\u06af\u06b0\7\u00b6\2\2"+
		"\u06b0\u06b1\7h\2\2\u06b1\u06b7\7\u00b8\2\2\u06b2\u06b3\7\u009f\2\2\u06b3"+
		"\u06b7\7\u0081\2\2\u06b4\u06b7\7Q\2\2\u06b5\u06b7\7\u00b7\2\2\u06b6\u06af"+
		"\3\2\2\2\u06b6\u06b2\3\2\2\2\u06b6\u06b4\3\2\2\2\u06b6\u06b5\3\2\2\2\u06b6"+
		"\u06b7\3\2\2\2\u06b7\u0081\3\2\2\2\u06b8\u06bf\t\23\2\2\u06b9\u06c0\5"+
		"\u0098M\2\u06ba\u06bb\7*\2\2\u06bb\u06bc\5\u0094K\2\u06bc\u06bd\7#\2\2"+
		"\u06bd\u06be\5\u0096L\2\u06be\u06c0\3\2\2\2\u06bf\u06b9\3\2\2\2\u06bf"+
		"\u06ba\3\2\2\2\u06c0\u0083\3\2\2\2\u06c1\u06c2\5\u00e0q\2\u06c2\u06cc"+
		"\7\5\2\2\u06c3\u06c8\5D#\2\u06c4\u06c5\7\7\2\2\u06c5\u06c7\5D#\2\u06c6"+
		"\u06c4\3\2\2\2\u06c7\u06ca\3\2\2\2\u06c8\u06c6\3\2\2\2\u06c8\u06c9\3\2"+
		"\2\2\u06c9\u06cd\3\2\2\2\u06ca\u06c8\3\2\2\2\u06cb\u06cd\7\t\2\2\u06cc"+
		"\u06c3\3\2\2\2\u06cc\u06cb\3\2\2\2\u06cd\u06ce\3\2\2\2\u06ce\u06cf\7\6"+
		"\2\2\u06cf\u0085\3\2\2\2\u06d0\u06d1\5\u00e2r\2\u06d1\u06de\7\5\2\2\u06d2"+
		"\u06d4\7A\2\2\u06d3\u06d2\3\2\2\2\u06d3\u06d4\3\2\2\2\u06d4\u06d5\3\2"+
		"\2\2\u06d5\u06da\5D#\2\u06d6\u06d7\7\7\2\2\u06d7\u06d9\5D#\2\u06d8\u06d6"+
		"\3\2\2\2\u06d9\u06dc\3\2\2\2\u06da\u06d8\3\2\2\2\u06da\u06db\3\2\2\2\u06db"+
		"\u06df\3\2\2\2\u06dc\u06da\3\2\2\2\u06dd\u06df\7\t\2\2\u06de\u06d3\3\2"+
		"\2\2\u06de\u06dd\3\2\2\2\u06de\u06df\3\2\2\2\u06df\u06e0\3\2\2\2\u06e0"+
		"\u06e2\7\6\2\2\u06e1\u06e3\5z>\2\u06e2\u06e1\3\2\2\2\u06e2\u06e3\3\2\2"+
		"\2\u06e3\u0087\3\2\2\2\u06e4\u06e5\5\u009aN\2\u06e5\u06ef\7\5\2\2\u06e6"+
		"\u06eb\5D#\2\u06e7\u06e8\7\7\2\2\u06e8\u06ea\5D#\2\u06e9\u06e7\3\2\2\2"+
		"\u06ea\u06ed\3\2\2\2\u06eb\u06e9\3\2\2\2\u06eb\u06ec\3\2\2\2\u06ec\u06f0"+
		"\3\2\2\2\u06ed\u06eb\3\2\2\2\u06ee\u06f0\7\t\2\2\u06ef\u06e6\3\2\2\2\u06ef"+
		"\u06ee\3\2\2\2\u06ef\u06f0\3\2\2\2\u06f0\u06f1\3\2\2\2\u06f1\u06f3\7\6"+
		"\2\2\u06f2\u06f4\5z>\2\u06f3\u06f2\3\2\2\2\u06f3\u06f4\3\2\2\2\u06f4\u06f5"+
		"\3\2\2\2\u06f5\u06f8\7\u009a\2\2\u06f6\u06f9\5|?\2\u06f7\u06f9\5\u00d8"+
		"m\2\u06f8\u06f6\3\2\2\2\u06f8\u06f7\3\2\2\2\u06f9\u0089\3\2\2\2\u06fa"+
		"\u06fc\7\u0097\2\2\u06fb\u06fd\7w\2\2\u06fc\u06fb\3\2\2\2\u06fc\u06fd"+
		"\3\2\2\2\u06fd\u06fe\3\2\2\2\u06fe\u0703\5:\36\2\u06ff\u0700\7\7\2\2\u0700"+
		"\u0702\5:\36\2\u0701\u06ff\3\2\2\2\u0702\u0705\3\2\2\2\u0703\u0701\3\2"+
		"\2\2\u0703\u0704\3\2\2\2\u0704\u008b\3\2\2\2\u0705\u0703\3\2\2\2\u0706"+
		"\u0707\7p\2\2\u0707\u0708\7+\2\2\u0708\u070d\5\u0090I\2\u0709\u070a\7"+
		"\7\2\2\u070a\u070c\5\u0090I\2\u070b\u0709\3\2\2\2\u070c\u070f\3\2\2\2"+
		"\u070d\u070b\3\2\2\2\u070d\u070e\3\2\2\2\u070e\u008d\3\2\2\2\u070f\u070d"+
		"\3\2\2\2\u0710\u0711\7e\2\2\u0711\u0714\5D#\2\u0712\u0713\t\24\2\2\u0713"+
		"\u0715\5D#\2\u0714\u0712\3\2\2\2\u0714\u0715\3\2\2\2\u0715\u008f\3\2\2"+
		"\2\u0716\u0719\5D#\2\u0717\u0718\7\60\2\2\u0718\u071a\5\u00c4c\2\u0719"+
		"\u0717\3\2\2\2\u0719\u071a\3\2\2\2\u071a\u071c\3\2\2\2\u071b\u071d\5\u0092"+
		"J\2\u071c\u071b\3\2\2\2\u071c\u071d\3\2\2\2\u071d\u0720\3\2\2\2\u071e"+
		"\u071f\7\u00b1\2\2\u071f\u0721\t\25\2\2\u0720\u071e\3\2\2\2\u0720\u0721"+
		"\3\2\2\2\u0721\u0091\3\2\2\2\u0722\u0723\t\26\2\2\u0723\u0093\3\2\2\2"+
		"\u0724\u0725\5D#\2\u0725\u0726\7\u009d\2\2\u0726\u072f\3\2\2\2\u0727\u0728"+
		"\5D#\2\u0728\u0729\7\u00a0\2\2\u0729\u072f\3\2\2\2\u072a\u072b\7\u009f"+
		"\2\2\u072b\u072f\7\u0081\2\2\u072c\u072d\7\u009e\2\2\u072d\u072f\7\u009d"+
		"\2\2\u072e\u0724\3\2\2\2\u072e\u0727\3\2\2\2\u072e\u072a\3\2\2\2\u072e"+
		"\u072c\3\2\2\2\u072f\u0095\3\2\2\2\u0730\u0731\5D#\2\u0731\u0732\7\u009d"+
		"\2\2\u0732\u073b\3\2\2\2\u0733\u0734\5D#\2\u0734\u0735\7\u00a0\2\2\u0735"+
		"\u073b\3\2\2\2\u0736\u0737\7\u009f\2\2\u0737\u073b\7\u0081\2\2\u0738\u0739"+
		"\7\u009e\2\2\u0739\u073b\7\u00a0\2\2\u073a\u0730\3\2\2\2\u073a\u0733\3"+
		"\2\2\2\u073a\u0736\3\2\2\2\u073a\u0738\3\2\2\2\u073b\u0097\3\2\2\2\u073c"+
		"\u073d\5D#\2\u073d\u073e\7\u009d\2\2\u073e\u0744\3\2\2\2\u073f\u0740\7"+
		"\u009e\2\2\u0740\u0744\7\u009d\2\2\u0741\u0742\7\u009f\2\2\u0742\u0744"+
		"\7\u0081\2\2\u0743\u073c\3\2\2\2\u0743\u073f\3\2\2\2\u0743\u0741\3\2\2"+
		"\2\u0744\u0099\3\2\2\2\u0745\u0746\t\27\2\2\u0746\u0747\7\5\2\2\u0747"+
		"\u0748\5D#\2\u0748\u0749\7\6\2\2\u0749\u074a\7\u009a\2\2\u074a\u074c\7"+
		"\5\2\2\u074b\u074d\5\u00a0Q\2\u074c\u074b\3\2\2\2\u074c\u074d\3\2\2\2"+
		"\u074d\u074e\3\2\2\2\u074e\u0750\5\u00a4S\2\u074f\u0751\5\u0082B\2\u0750"+
		"\u074f\3\2\2\2\u0750\u0751\3\2\2\2\u0751\u0752\3\2\2\2\u0752\u0753\7\6"+
		"\2\2\u0753\u079b\3\2\2\2\u0754\u0755\t\30\2\2\u0755\u0756\7\5\2\2\u0756"+
		"\u0757\7\6\2\2\u0757\u0758\7\u009a\2\2\u0758\u075a\7\5\2\2\u0759\u075b"+
		"\5\u00a0Q\2\u075a\u0759\3\2\2\2\u075a\u075b\3\2\2\2\u075b\u075d\3\2\2"+
		"\2\u075c\u075e\5\u00a2R\2\u075d\u075c\3\2\2\2\u075d\u075e\3\2\2\2\u075e"+
		"\u075f\3\2\2\2\u075f\u079b\7\6\2\2\u0760\u0761\t\31\2\2\u0761\u0762\7"+
		"\5\2\2\u0762\u0763\7\6\2\2\u0763\u0764\7\u009a\2\2\u0764\u0766\7\5\2\2"+
		"\u0765\u0767\5\u00a0Q\2\u0766\u0765\3\2\2\2\u0766\u0767\3\2\2\2\u0767"+
		"\u0768\3\2\2\2\u0768\u0769\5\u00a4S\2\u0769\u076a\7\6\2\2\u076a\u079b"+
		"\3\2\2\2\u076b\u076c\t\32\2\2\u076c\u076d\7\5\2\2\u076d\u076f\5D#\2\u076e"+
		"\u0770\5\u009cO\2\u076f\u076e\3\2\2\2\u076f\u0770\3\2\2\2\u0770\u0772"+
		"\3\2\2\2\u0771\u0773\5\u009eP\2\u0772\u0771\3\2\2\2\u0772\u0773\3\2\2"+
		"\2\u0773\u0774\3\2\2\2\u0774\u0775\7\6\2\2\u0775\u0776\7\u009a\2\2\u0776"+
		"\u0778\7\5\2\2\u0777\u0779\5\u00a0Q\2\u0778\u0777\3\2\2\2\u0778\u0779"+
		"\3\2\2\2\u0779\u077a\3\2\2\2\u077a\u077b\5\u00a4S\2\u077b\u077c\7\6\2"+
		"\2\u077c\u079b\3\2\2\2\u077d\u077e\7\u00a6\2\2\u077e\u077f\7\5\2\2\u077f"+
		"\u0780\5D#\2\u0780\u0781\7\7\2\2\u0781\u0782\5&\24\2\u0782\u0783\7\6\2"+
		"\2\u0783\u0784\7\u009a\2\2\u0784\u0786\7\5\2\2\u0785\u0787\5\u00a0Q\2"+
		"\u0786\u0785\3\2\2\2\u0786\u0787\3\2\2\2\u0787\u0788\3\2\2\2\u0788\u078a"+
		"\5\u00a4S\2\u0789\u078b\5\u0082B\2\u078a\u0789\3\2\2\2\u078a\u078b\3\2"+
		"\2\2\u078b\u078c\3\2\2\2\u078c\u078d\7\6\2\2\u078d\u079b\3\2\2\2\u078e"+
		"\u078f\7\u00a7\2\2\u078f\u0790\7\5\2\2\u0790\u0791\5D#\2\u0791\u0792\7"+
		"\6\2\2\u0792\u0793\7\u009a\2\2\u0793\u0795\7\5\2\2\u0794\u0796\5\u00a0"+
		"Q\2\u0795\u0794\3\2\2\2\u0795\u0796\3\2\2\2\u0796\u0797\3\2\2\2\u0797"+
		"\u0798\5\u00a4S\2\u0798\u0799\7\6\2\2\u0799\u079b\3\2\2\2\u079a\u0745"+
		"\3\2\2\2\u079a\u0754\3\2\2\2\u079a\u0760\3\2\2\2\u079a\u076b\3\2\2\2\u079a"+
		"\u077d\3\2\2\2\u079a\u078e\3\2\2\2\u079b\u009b\3\2\2\2\u079c\u079d\7\7"+
		"\2\2\u079d\u079e\5&\24\2\u079e\u009d\3\2\2\2\u079f\u07a0\7\7\2\2\u07a0"+
		"\u07a1\5&\24\2\u07a1\u009f\3\2\2\2\u07a2\u07a3\7\u009b\2\2\u07a3\u07a5"+
		"\7+\2\2\u07a4\u07a6\5D#\2\u07a5\u07a4\3\2\2\2\u07a6\u07a7\3\2\2\2\u07a7"+
		"\u07a5\3\2\2\2\u07a7\u07a8\3\2\2\2\u07a8\u00a1\3\2\2\2\u07a9\u07aa\7p"+
		"\2\2\u07aa\u07ac\7+\2\2\u07ab\u07ad\5D#\2\u07ac\u07ab\3\2\2\2\u07ad\u07ae"+
		"\3\2\2\2\u07ae\u07ac\3\2\2\2\u07ae\u07af\3\2\2\2\u07af\u00a3\3\2\2\2\u07b0"+
		"\u07b1\7p\2\2\u07b1\u07b2\7+\2\2\u07b2\u07b3\5\u00a4S\2\u07b3\u00a5\3"+
		"\2\2\2\u07b4\u07b6\5D#\2\u07b5\u07b7\5\u0092J\2\u07b6\u07b5\3\2\2\2\u07b6"+
		"\u07b7\3\2\2\2\u07b7\u07bf\3\2\2\2\u07b8\u07b9\7\7\2\2\u07b9\u07bb\5D"+
		"#\2\u07ba\u07bc\5\u0092J\2\u07bb\u07ba\3\2\2\2\u07bb\u07bc\3\2\2\2\u07bc"+
		"\u07be\3\2\2\2\u07bd\u07b8\3\2\2\2\u07be\u07c1\3\2\2\2\u07bf\u07bd\3\2"+
		"\2\2\u07bf\u07c0\3\2\2\2\u07c0\u00a7\3\2\2\2\u07c1\u07bf\3\2\2\2\u07c2"+
		"\u07c3\5T+\2\u07c3\u00a9\3\2\2\2\u07c4\u07c5\5T+\2\u07c5\u00ab\3\2\2\2"+
		"\u07c6\u07c7\t\33\2\2\u07c7\u00ad\3\2\2\2\u07c8\u07c9\7\u00bf\2\2\u07c9"+
		"\u00af\3\2\2\2\u07ca\u07cd\5D#\2\u07cb\u07cd\5 \21\2\u07cc\u07ca\3\2\2"+
		"\2\u07cc\u07cb\3\2\2\2\u07cd\u00b1\3\2\2\2\u07ce\u07cf\t\34\2\2\u07cf"+
		"\u00b3\3\2\2\2\u07d0\u07d1\t\35\2\2\u07d1\u00b5\3\2\2\2\u07d2\u07d3\5"+
		"\u00e6t\2\u07d3\u00b7\3\2\2\2\u07d4\u07d5\5\u00e6t\2\u07d5\u00b9\3\2\2"+
		"\2\u07d6\u07d7\5\u00e6t\2\u07d7\u00bb\3\2\2\2\u07d8\u07d9\5\u00e6t\2\u07d9"+
		"\u00bd\3\2\2\2\u07da\u07db\5\u00e6t\2\u07db\u00bf\3\2\2\2\u07dc\u07dd"+
		"\5\u00e6t\2\u07dd\u00c1\3\2\2\2\u07de\u07df\5\u00e6t\2\u07df\u00c3\3\2"+
		"\2\2\u07e0\u07e1\5\u00e6t\2\u07e1\u00c5\3\2\2\2\u07e2\u07e3\5\u00e6t\2"+
		"\u07e3\u00c7\3\2\2\2\u07e4\u07e5\5\u00e6t\2\u07e5\u00c9\3\2\2\2\u07e6"+
		"\u07e7\5\u00e6t\2\u07e7\u00cb\3\2\2\2\u07e8\u07e9\5\u00e6t\2\u07e9\u00cd"+
		"\3\2\2\2\u07ea\u07eb\5\u00e6t\2\u07eb\u00cf\3\2\2\2\u07ec\u07ed\5\u00e6"+
		"t\2\u07ed\u00d1\3\2\2\2\u07ee\u07ef\5\u00e6t\2\u07ef\u00d3\3\2\2\2\u07f0"+
		"\u07f1\5\u00e6t\2\u07f1\u00d5\3\2\2\2\u07f2\u07f3\5\u00e6t\2\u07f3\u00d7"+
		"\3\2\2\2\u07f4\u07f5\5\u00e6t\2\u07f5\u00d9\3\2\2\2\u07f6\u07f7\5\u00e6"+
		"t\2\u07f7\u00db\3\2\2\2\u07f8\u07f9\5\u00e6t\2\u07f9\u00dd\3\2\2\2\u07fa"+
		"\u07fb\5\u00e6t\2\u07fb\u00df\3\2\2\2\u07fc\u07fd\5\u00e6t\2\u07fd\u00e1"+
		"\3\2\2\2\u07fe\u07ff\5\u00e6t\2\u07ff\u00e3\3\2\2\2\u0800\u0801\5\u00e6"+
		"t\2\u0801\u00e5\3\2\2\2\u0802\u080b\7\u00bb\2\2\u0803\u080b\5\u00b4[\2"+
		"\u0804\u080b\7\u00bf\2\2\u0805\u080b\7\u00bd\2\2\u0806\u0807\7\5\2\2\u0807"+
		"\u0808\5\u00e6t\2\u0808\u0809\7\6\2\2\u0809\u080b\3\2\2\2\u080a\u0802"+
		"\3\2\2\2\u080a\u0803\3\2\2\2\u080a\u0804\3\2\2\2\u080a\u0805\3\2\2\2\u080a"+
		"\u0806\3\2\2\2\u080b\u00e7\3\2\2\2\u0123\u00ea\u00ec\u00f7\u00fe\u0103"+
		"\u0109\u010f\u0111\u012b\u0132\u0139\u013f\u0143\u0146\u014d\u0150\u0154"+
		"\u015c\u0160\u0162\u0166\u016a\u016e\u0171\u0178\u017e\u0184\u0189\u0194"+
		"\u019a\u019e\u01a2\u01a5\u01a9\u01af\u01b4\u01bd\u01c4\u01ca\u01ce\u01d2"+
		"\u01d7\u01dd\u01e9\u01ed\u01f2\u01f5\u01f8\u01fd\u0200\u020e\u0215\u021c"+
		"\u021e\u0221\u0227\u022c\u0234\u0239\u0248\u024e\u0258\u025d\u0267\u026b"+
		"\u026d\u0271\u0276\u0278\u0280\u0286\u028b\u0292\u029d\u02a0\u02a2\u02a9"+
		"\u02ad\u02b4\u02ba\u02c0\u02c6\u02cb\u02d4\u02d9\u02e4\u02e9\u02f4\u02f9"+
		"\u02fd\u030d\u0317\u031c\u0324\u0330\u0335\u033d\u0344\u0347\u034e\u0351"+
		"\u0354\u0358\u0360\u0365\u036f\u0374\u037d\u0384\u0388\u038c\u038f\u0397"+
		"\u03a4\u03a7\u03af\u03b8\u03bc\u03c1\u03df\u03eb\u03f0\u03fc\u0402\u0409"+
		"\u040d\u0417\u041a\u0420\u0426\u042f\u0432\u0436\u0438\u043a\u0443\u044a"+
		"\u0451\u0457\u045c\u0464\u0469\u0472\u047d\u0484\u0488\u048b\u048f\u0499"+
		"\u049f\u04a1\u04a9\u04b0\u04b7\u04bc\u04be\u04c4\u04cd\u04d2\u04d9\u04dd"+
		"\u04df\u04e2\u04ea\u04ee\u04f1\u04f7\u04fb\u0500\u0507\u0510\u0514\u0516"+
		"\u0519\u051c\u0529\u052c\u0535\u0540\u0547\u054a\u0556\u055a\u0562\u0566"+
		"\u0569\u056c\u0571\u0575\u057a\u057d\u0580\u0585\u0589\u058c\u0593\u0598"+
		"\u05a1\u05a6\u05a9\u05b1\u05b5\u05bd\u05c0\u05c2\u05cb\u05ce\u05d0\u05d4"+
		"\u05d8\u05dc\u05df\u05ea\u05ef\u05f3\u05f7\u05fa\u05ff\u0605\u060c\u0613"+
		"\u0618\u0620\u0626\u062b\u0631\u0638\u063f\u0644\u0647\u064a\u064f\u0654"+
		"\u065b\u065f\u0663\u066d\u0676\u0679\u0682\u0686\u068e\u0697\u069a\u06a3"+
		"\u06a6\u06a9\u06ac\u06b6\u06bf\u06c8\u06cc\u06d3\u06da\u06de\u06e2\u06eb"+
		"\u06ef\u06f3\u06f8\u06fc\u0703\u070d\u0714\u0719\u071c\u0720\u072e\u073a"+
		"\u0743\u074c\u0750\u075a\u075d\u0766\u076f\u0772\u0778\u0786\u078a\u0795"+
		"\u079a\u07a7\u07ae\u07b6\u07bb\u07bf\u07cc\u080a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}