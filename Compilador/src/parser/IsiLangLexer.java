// Generated from IsiLang.g4 by ANTLR 4.7.1
package parser;

	import datastructures.IsiSymbol;
	import datastructures.IsiVariable;
	import datastructures.IsiSymbolTable;
	import exceptions.IsiSemanticException;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;
	import ast.IsiProgram;
	import ast.AbstractCommand;
	import ast.CommandLeitura;
	import ast.CommandEscrita;
	import ast.CommandAtribuicao;
	import ast.CommandDecisao;
	import ast.CommandRepeticao;
	import ast.CommandOperacaoConjunto;
	import ast.CommandEnquanto;
	import ast.CommandLoopConjunto;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, AP=27, FP=28, VIR=29, SC=30, ACH=31, FCH=32, ACT=33, 
		FCT=34, OP=35, OPREL=36, ATTR=37, ID=38, INTEGER=39, DECIMAL=40, WS=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "AP", "FP", "VIR", "SC", "ACH", "FCH", "ACT", "FCT", "OP", "OPREL", 
		"ATTR", "ID", "INTEGER", "DECIMAL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'vetor'", "'conjunto'", "'inteiro'", 
		"'decimal'", "'texto'", "'leia'", "'escreva'", "'espaco'", "'linha'", 
		"'se'", "'senao'", "'para'", "'de'", "'ate'", "'faca'", "':='", "'+'", 
		"'*'", "'-'", "'<<'", "'enquanto'", "'em'", "'/'", "'%'", "'('", "')'", 
		"','", "';'", "'{'", "'}'", "'['", "']'", null, null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "AP", "FP", "VIR", "SC", "ACH", "FCH", "ACT", "FCT", 
		"OP", "OPREL", "ATTR", "ID", "INTEGER", "DECIMAL", "WS"
	};
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


		private int _tipo;
		private int _writeType;
		private int _readType;
		private int _expType;
		private int _setSize;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private ArrayList<IsiSymbol> unused = new ArrayList<IsiSymbol>();
		IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> currThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private String _expAuxData;
		private boolean _colecAttrib;
		private String _repID;
		private Stack<String> repIDstack = new Stack<String>();
		private String _lowLimit;
		private Stack<String> lowLimitStack = new Stack<String>();
		private String _upLimit;
		private Stack<String> upLimitStack = new Stack<String>();
		private String _setOpID;
		private String _fOp;
		private String _sOp;
		private int _setOp;
		private String _boolExp;
		private Stack<String> boolExpStack = new Stack<String>();
		private String _loopID;
		private Stack<String> loopIDstack = new Stack<String>();
		private String _loopSet;
		private Stack<String> loopSetStack = new Stack<String>();
		private String _arrayAccessContent;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		private ArrayList<AbstractCommand> listaRep;
		private ArrayList<AbstractCommand> listaWhile;
		private ArrayList<AbstractCommand> listaSetLoop;
		
		public void verificaID(Token tk){
			String id=tk.getText();
			if(!symbolTable.exists(id)){
				throw new IsiSemanticException(tokenPosition(tk)+" Symbol "+id+" not declared\n");
			}
		}
		
		public boolean isTypeCompatible(int expType, int varType){
			if(expType == IsiVariable.TEXT) 
				return varType == IsiVariable.TEXT;
			else
				return varType == IsiVariable.INTEGER | varType == IsiVariable.DECIMAL;
		}
		
		public String type(int t){
			switch(t){
				case IsiVariable.TEXT:
					return "texto";
				case IsiVariable.INTEGER:
					return "inteiro";
				case IsiVariable.DECIMAL:
					return "decimal";
				case IsiVariable.ARRAY:
					return "vetor";
				case IsiVariable.SET:
					return "conjunto";
			}
			return "";
		}
		
		public String tokenPosition(Token tk){
			return "line "+tk.getLine()+":"+tk.getCharPositionInLine();
		}
		
		public void exibeComandos(){
			for(AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			//program.generateTarget();
			program.generateC();
		}


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u0118\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u00f8\n"+
		"%\3&\3&\3\'\3\'\7\'\u00fe\n\'\f\'\16\'\u0101\13\'\3(\6(\u0104\n(\r(\16"+
		"(\u0105\3)\6)\u0109\n)\r)\16)\u010a\3)\3)\6)\u010f\n)\r)\16)\u0110\5)"+
		"\u0113\n)\3*\3*\3*\3*\2\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+\3\2\b\5\2,-//\61"+
		"\61\4\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u0120\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3"+
		"\2\2\2\5^\3\2\2\2\7g\3\2\2\2\tm\3\2\2\2\13v\3\2\2\2\r~\3\2\2\2\17\u0086"+
		"\3\2\2\2\21\u008c\3\2\2\2\23\u0091\3\2\2\2\25\u0099\3\2\2\2\27\u00a0\3"+
		"\2\2\2\31\u00a6\3\2\2\2\33\u00a9\3\2\2\2\35\u00af\3\2\2\2\37\u00b4\3\2"+
		"\2\2!\u00b7\3\2\2\2#\u00bb\3\2\2\2%\u00c0\3\2\2\2\'\u00c3\3\2\2\2)\u00c5"+
		"\3\2\2\2+\u00c7\3\2\2\2-\u00c9\3\2\2\2/\u00cc\3\2\2\2\61\u00d5\3\2\2\2"+
		"\63\u00d8\3\2\2\2\65\u00da\3\2\2\2\67\u00dc\3\2\2\29\u00de\3\2\2\2;\u00e0"+
		"\3\2\2\2=\u00e2\3\2\2\2?\u00e4\3\2\2\2A\u00e6\3\2\2\2C\u00e8\3\2\2\2E"+
		"\u00ea\3\2\2\2G\u00ec\3\2\2\2I\u00f7\3\2\2\2K\u00f9\3\2\2\2M\u00fb\3\2"+
		"\2\2O\u0103\3\2\2\2Q\u0108\3\2\2\2S\u0114\3\2\2\2UV\7r\2\2VW\7t\2\2WX"+
		"\7q\2\2XY\7i\2\2YZ\7t\2\2Z[\7c\2\2[\\\7o\2\2\\]\7c\2\2]\4\3\2\2\2^_\7"+
		"h\2\2_`\7k\2\2`a\7o\2\2ab\7r\2\2bc\7t\2\2cd\7q\2\2de\7i\2\2ef\7=\2\2f"+
		"\6\3\2\2\2gh\7x\2\2hi\7g\2\2ij\7v\2\2jk\7q\2\2kl\7t\2\2l\b\3\2\2\2mn\7"+
		"e\2\2no\7q\2\2op\7p\2\2pq\7l\2\2qr\7w\2\2rs\7p\2\2st\7v\2\2tu\7q\2\2u"+
		"\n\3\2\2\2vw\7k\2\2wx\7p\2\2xy\7v\2\2yz\7g\2\2z{\7k\2\2{|\7t\2\2|}\7q"+
		"\2\2}\f\3\2\2\2~\177\7f\2\2\177\u0080\7g\2\2\u0080\u0081\7e\2\2\u0081"+
		"\u0082\7k\2\2\u0082\u0083\7o\2\2\u0083\u0084\7c\2\2\u0084\u0085\7n\2\2"+
		"\u0085\16\3\2\2\2\u0086\u0087\7v\2\2\u0087\u0088\7g\2\2\u0088\u0089\7"+
		"z\2\2\u0089\u008a\7v\2\2\u008a\u008b\7q\2\2\u008b\20\3\2\2\2\u008c\u008d"+
		"\7n\2\2\u008d\u008e\7g\2\2\u008e\u008f\7k\2\2\u008f\u0090\7c\2\2\u0090"+
		"\22\3\2\2\2\u0091\u0092\7g\2\2\u0092\u0093\7u\2\2\u0093\u0094\7e\2\2\u0094"+
		"\u0095\7t\2\2\u0095\u0096\7g\2\2\u0096\u0097\7x\2\2\u0097\u0098\7c\2\2"+
		"\u0098\24\3\2\2\2\u0099\u009a\7g\2\2\u009a\u009b\7u\2\2\u009b\u009c\7"+
		"r\2\2\u009c\u009d\7c\2\2\u009d\u009e\7e\2\2\u009e\u009f\7q\2\2\u009f\26"+
		"\3\2\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7p\2\2\u00a3"+
		"\u00a4\7j\2\2\u00a4\u00a5\7c\2\2\u00a5\30\3\2\2\2\u00a6\u00a7\7u\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8\32\3\2\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7g\2\2\u00ab"+
		"\u00ac\7p\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7q\2\2\u00ae\34\3\2\2\2\u00af"+
		"\u00b0\7r\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3\7c\2\2"+
		"\u00b3\36\3\2\2\2\u00b4\u00b5\7f\2\2\u00b5\u00b6\7g\2\2\u00b6 \3\2\2\2"+
		"\u00b7\u00b8\7c\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7g\2\2\u00ba\"\3\2"+
		"\2\2\u00bb\u00bc\7h\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7e\2\2\u00be\u00bf"+
		"\7c\2\2\u00bf$\3\2\2\2\u00c0\u00c1\7<\2\2\u00c1\u00c2\7?\2\2\u00c2&\3"+
		"\2\2\2\u00c3\u00c4\7-\2\2\u00c4(\3\2\2\2\u00c5\u00c6\7,\2\2\u00c6*\3\2"+
		"\2\2\u00c7\u00c8\7/\2\2\u00c8,\3\2\2\2\u00c9\u00ca\7>\2\2\u00ca\u00cb"+
		"\7>\2\2\u00cb.\3\2\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf"+
		"\7s\2\2\u00cf\u00d0\7w\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7p\2\2\u00d2"+
		"\u00d3\7v\2\2\u00d3\u00d4\7q\2\2\u00d4\60\3\2\2\2\u00d5\u00d6\7g\2\2\u00d6"+
		"\u00d7\7o\2\2\u00d7\62\3\2\2\2\u00d8\u00d9\7\61\2\2\u00d9\64\3\2\2\2\u00da"+
		"\u00db\7\'\2\2\u00db\66\3\2\2\2\u00dc\u00dd\7*\2\2\u00dd8\3\2\2\2\u00de"+
		"\u00df\7+\2\2\u00df:\3\2\2\2\u00e0\u00e1\7.\2\2\u00e1<\3\2\2\2\u00e2\u00e3"+
		"\7=\2\2\u00e3>\3\2\2\2\u00e4\u00e5\7}\2\2\u00e5@\3\2\2\2\u00e6\u00e7\7"+
		"\177\2\2\u00e7B\3\2\2\2\u00e8\u00e9\7]\2\2\u00e9D\3\2\2\2\u00ea\u00eb"+
		"\7_\2\2\u00ebF\3\2\2\2\u00ec\u00ed\t\2\2\2\u00edH\3\2\2\2\u00ee\u00f8"+
		"\t\3\2\2\u00ef\u00f0\7@\2\2\u00f0\u00f8\7?\2\2\u00f1\u00f2\7>\2\2\u00f2"+
		"\u00f8\7?\2\2\u00f3\u00f4\7?\2\2\u00f4\u00f8\7?\2\2\u00f5\u00f6\7#\2\2"+
		"\u00f6\u00f8\7?\2\2\u00f7\u00ee\3\2\2\2\u00f7\u00ef\3\2\2\2\u00f7\u00f1"+
		"\3\2\2\2\u00f7\u00f3\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8J\3\2\2\2\u00f9"+
		"\u00fa\7?\2\2\u00faL\3\2\2\2\u00fb\u00ff\t\4\2\2\u00fc\u00fe\t\5\2\2\u00fd"+
		"\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100N\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0104\t\6\2\2\u0103\u0102"+
		"\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"P\3\2\2\2\u0107\u0109\t\6\2\2\u0108\u0107\3\2\2\2\u0109\u010a\3\2\2\2"+
		"\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0112\3\2\2\2\u010c\u010e"+
		"\7\60\2\2\u010d\u010f\t\6\2\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2"+
		"\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112\u010c"+
		"\3\2\2\2\u0112\u0113\3\2\2\2\u0113R\3\2\2\2\u0114\u0115\t\7\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u0117\b*\2\2\u0117T\3\2\2\2\n\2\u00f7\u00fd\u00ff"+
		"\u0105\u010a\u0110\u0112\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}