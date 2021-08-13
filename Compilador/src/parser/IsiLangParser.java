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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
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
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdLeitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_cmdrepeticao = 10, RULE_cmdsetattrib = 11, RULE_cmdenquanto = 12, 
		RULE_cmdsetloop = 13, RULE_expr = 14, RULE_termo = 15, RULE_boolexp = 16, 
		RULE_array = 17, RULE_arrayaccess = 18, RULE_set = 19;
	public static final String[] ruleNames = {
		"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdLeitura", "cmdescrita", 
		"cmdattrib", "cmdselecao", "cmdrepeticao", "cmdsetattrib", "cmdenquanto", 
		"cmdsetloop", "expr", "termo", "boolexp", "array", "arrayaccess", "set"
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

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__0);
			setState(41);
			decl();
			setState(42);
			bloco();
			setState(43);
			match(T__1);
			program.setVarTable(symbolTable);
					   program.setComandos(stack.pop());
					   for(IsiSymbol s: unused){
					   	System.out.println("Warning: symbol " + s.getName() + " declared but not used\n");
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

	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				declaravar();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6))) != 0) );
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

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(IsiLangParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(IsiLangParser.INTEGER, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				tipo();
				setState(52);
				match(ID);

										_varName = _input.LT(-1).getText();
										_varValue = null;
										symbol = new IsiVariable(_varName, _tipo, _varValue);
										if(!symbolTable.exists(_varName)){
											symbolTable.add(symbol);
										}
										else{
											throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+_varName+" already declared");
										}
										unused.add(symbol);
									  
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(54);
					match(VIR);
					setState(55);
					match(ID);

										_varName = _input.LT(-1).getText();
										_varValue = null;
										symbol = new IsiVariable(_varName, _tipo, _varValue);
										if(!symbolTable.exists(_varName)){
											symbolTable.add(symbol);
										}
										else{
											throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+_varName+" already declared");
										}
										unused.add(symbol);
									 
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(62);
				match(SC);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(T__2);
				_tipo = IsiVariable.ARRAY;
				setState(66);
				match(ID);
				_varName = _input.LT(-1).getText();
				setState(68);
				match(INTEGER);

							    		_varValue = _input.LT(-1).getText();
										symbol = new IsiVariable(_varName, _tipo, _varValue);
										if(!symbolTable.exists(_varName)){
											symbolTable.add(symbol);
										}
										else{
											throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+_varName+" already declared");
										}
										unused.add(symbol);
							    	
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(70);
					match(VIR);
					setState(71);
					match(ID);
					_varName = _input.LT(-1).getText();
					setState(73);
					match(INTEGER);

								    		_varValue = _input.LT(-1).getText();
											symbol = new IsiVariable(_varName, _tipo, _varValue);
											if(!symbolTable.exists(_varName)){
												symbolTable.add(symbol);
											}
											else{
												throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+_varName+" already declared");
											}
											unused.add(symbol);
								    	
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(80);
				match(SC);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(T__3);
				_tipo = IsiVariable.SET;
				setState(83);
				match(ID);

							      		_varName = _input.LT(-1).getText();
							      		symbol = new IsiVariable(_varName, _tipo, null);
							      		if(!symbolTable.exists(_varName)){
							      			symbolTable.add(symbol);
							      		}
							      		else{
							      			throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+_varName+" already declared");
							      		}
							      		unused.add(symbol);
							      	
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(85);
					match(VIR);
					setState(86);
					match(ID);

								      		_varName = _input.LT(-1).getText();
								      		symbol = new IsiVariable(_varName, _tipo, null);
								      		if(!symbolTable.exists(_varName)){
								      			symbolTable.add(symbol);
								      		}
								      		else{
								      			throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+_varName+" already declared");
								      		}
								      		unused.add(symbol);
								      	
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(93);
				match(SC);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(T__4);
				_tipo = IsiVariable.INTEGER;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(T__5);
				_tipo = IsiVariable.DECIMAL;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				match(T__6);
				_tipo = IsiVariable.TEXT;
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

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			currThread = new ArrayList<AbstractCommand>();
						 stack.push(currThread);
						
			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(105);
				cmd();
				}
				}
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__22) | (1L << ID))) != 0) );
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

	public static class CmdContext extends ParserRuleContext {
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdrepeticaoContext cmdrepeticao() {
			return getRuleContext(CmdrepeticaoContext.class,0);
		}
		public CmdsetattribContext cmdsetattrib() {
			return getRuleContext(CmdsetattribContext.class,0);
		}
		public CmdenquantoContext cmdenquanto() {
			return getRuleContext(CmdenquantoContext.class,0);
		}
		public CmdsetloopContext cmdsetloop() {
			return getRuleContext(CmdsetloopContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				cmdLeitura();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				cmdescrita();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				cmdattrib();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				cmdselecao();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(114);
				cmdrepeticao();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(115);
				cmdsetattrib();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(116);
				cmdenquanto();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(117);
				cmdsetloop();
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

	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public ArrayaccessContext arrayaccess() {
			return getRuleContext(ArrayaccessContext.class,0);
		}
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__7);
			setState(121);
			match(AP);
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(122);
				match(ID);

									 		verificaID(_input.LT(-1));
									 		_readID = _input.LT(-1).getText();
									 		IsiVariable var = (IsiVariable) symbolTable.get(_readID);
											unused.remove(var);
									 		_readType = var.getType();
									 		if(_readType == IsiVariable.ARRAY || _readType == IsiVariable.SET){
									 			throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Cannot read type "+type(_readType)+"\n");
									 		}
									 	
				}
				break;
			case 2:
				{
				setState(124);
				arrayaccess();

									 		_readID=_arrayAccessContent;
									 		_readType=IsiVariable.INTEGER;
									 	
				}
				break;
			}
			setState(129);
			match(FP);
			setState(130);
			match(SC);

								 	CommandLeitura cmd = new CommandLeitura(_readID, _readType);
								 	stack.peek().add(cmd);
								 
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

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public ArrayaccessContext arrayaccess() {
			return getRuleContext(ArrayaccessContext.class,0);
		}
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				match(T__8);
				setState(134);
				match(AP);
				setState(140);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(135);
					match(ID);
					verificaID(_input.LT(-1));
												    _writeID=_input.LT(-1).getText();
												    IsiVariable var = (IsiVariable) symbolTable.get(_writeID);
												    if(unused.contains(var)){
												    	System.out.println("Warning: " + tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" was not initialized\n");
												    }
									  				unused.remove(var);
												    _writeType = var.getType();
												   
					}
					break;
				case 2:
					{
					setState(137);
					arrayaccess();

											   				_writeID=_arrayAccessContent;
											   				_writeType=IsiVariable.INTEGER;
											   			   
					}
					break;
				}
				setState(142);
				match(FP);
				setState(143);
				match(SC);

										   		CommandEscrita cmd = new CommandEscrita(_writeID, _writeType);
										   		stack.peek().add(cmd);
										   
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(T__9);
				setState(146);
				match(AP);
				setState(147);
				match(FP);
				setState(148);
				match(SC);

									CommandEscrita cmd = new CommandEscrita("\" \"", CommandEscrita.SPACE);
									stack.peek().add(cmd);
								
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				match(T__10);
				setState(151);
				match(AP);
				setState(152);
				match(FP);
				setState(153);
				match(SC);

									CommandEscrita cmd = new CommandEscrita("\"\\n\"", CommandEscrita.nLINE);
									stack.peek().add(cmd);
								
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

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public ArrayaccessContext arrayaccess() {
			return getRuleContext(ArrayaccessContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(157);
				match(ID);
				verificaID(_input.LT(-1));
								   _exprID=_input.LT(-1).getText();
								   IsiVariable var = (IsiVariable) symbolTable.get(_exprID);
								   _expType=var.getType();
								  
				}
				break;
			case 2:
				{
				setState(159);
				arrayaccess();

							  				_exprID=_arrayAccessContent;
							  				_expType=IsiVariable.INTEGER;
							  			   
				}
				break;
			}
			setState(164);
			match(ATTR);
			_exprContent="";
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case INTEGER:
			case DECIMAL:
				{
				setState(166);
				expr();

							  		if(_expType==IsiVariable.TEXT||_expType==IsiVariable.ARRAY||_expType==IsiVariable.SET){
							  			throw new IsiSemanticException("line "+_input.LT(-1).getLine()+" cannot assign expression to "+type(_expType)+"\n");
							  		}
							  	
				}
				break;
			case ACH:
				{
				setState(169);
				array();

							  		_colecAttrib=true;
							  		if(_expType!=IsiVariable.ARRAY){
							  			throw new IsiSemanticException("line "+_input.LT(-1).getLine()+" Symbol "+_exprID+" is not a vetor\n");
							  		}
							  		IsiVariable var = (IsiVariable) symbolTable.get(_exprID);
							  		_expAuxData = var.getValue();
							  	
				}
				break;
			case ACT:
				{
				setState(172);
				set();

							  		_colecAttrib=true;
							  		if(_expType!=IsiVariable.SET){
							  			throw new IsiSemanticException("line "+_input.LT(-1).getLine()+" Symbol "+_exprID+" is not a conjunto\n");
							  		}
							  	
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(177);
			match(SC);

							IsiVariable var = (IsiVariable) symbolTable.get(_exprID);
							unused.remove(var);
							if(_colecAttrib){
								_expAuxData=_setSize+"";
							}
						  	CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent, _expType, _expAuxData);
						  	stack.peek().add(cmd);
						  
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

	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public BoolexpContext boolexp() {
			return getRuleContext(BoolexpContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__11);

									_exprContent="";
									_boolExp="";
								
			setState(182);
			match(AP);
			setState(183);
			boolexp();
			setState(184);
			match(FP);
			boolExpStack.push(_boolExp);
			setState(186);
			match(ACH);
			currThread = new ArrayList<AbstractCommand>();
							    stack.push(currThread);
							   
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(188);
				cmd();
				}
				}
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__22) | (1L << ID))) != 0) );
			setState(193);
			match(FCH);

							     listaTrue=stack.pop();
							    
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(195);
				match(T__12);
				setState(196);
				match(ACH);

							   	currThread = new ArrayList<AbstractCommand>();
							   	stack.push(currThread);
							   
				setState(199); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(198);
					cmd();
					}
					}
					setState(201); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__22) | (1L << ID))) != 0) );
				setState(203);
				match(FCH);

							    listaFalse = stack.pop();
							   
				}
			}


						     CommandDecisao cmd = new CommandDecisao(boolExpStack.pop(), listaTrue, listaFalse);
						     stack.peek().add(cmd);
						    
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

	public static class CmdrepeticaoContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(IsiLangParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(IsiLangParser.INTEGER, i);
		}
		public List<TerminalNode> DECIMAL() { return getTokens(IsiLangParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(IsiLangParser.DECIMAL, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdrepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdrepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdrepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdrepeticao(this);
		}
	}

	public final CmdrepeticaoContext cmdrepeticao() throws RecognitionException {
		CmdrepeticaoContext _localctx = new CmdrepeticaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdrepeticao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__13);
			setState(211);
			match(ID);

							  	  verificaID(_input.LT(-1));
							 	  IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
							  	  if(var.getType() != IsiVariable.INTEGER && var.getType() != IsiVariable.DECIMAL){
							  		  throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible. Expected inteiro or decimal, found "+type(var.getType())+"\n");
							  	  }
							  	  repIDstack.push(_input.LT(-1).getText());
								  unused.remove(var);
						  	 
			setState(213);
			match(T__14);
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(214);
				match(ID);

							  				verificaID(_input.LT(-1));
											var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
									  	    if(var.getType() != IsiVariable.INTEGER && var.getType() != IsiVariable.DECIMAL){
									  			throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible. Expected inteiro or decimal, found "+type(var.getType())+"\n");
									  	    }
											if(unused.contains(var)){
												System.out.println("Warning: " + tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" was not initialized\n");
											}
											unused.remove(var);
							  			
				}
				break;
			case INTEGER:
				{
				setState(216);
				match(INTEGER);
				}
				break;
			case DECIMAL:
				{
				setState(217);
				match(DECIMAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			lowLimitStack.push(_input.LT(-1).getText());
			setState(221);
			match(T__15);
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(222);
				match(ID);

							  				verificaID(_input.LT(-1));
											var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
									  	    if(var.getType() != IsiVariable.INTEGER && var.getType() != IsiVariable.DECIMAL){
									  			throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible. Expected inteiro or decimal, found "+type(var.getType())+"\n");
									  	    }
											if(unused.contains(var)){
												System.out.println("Warning: " + tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" was not initialized\n");
											}
											unused.remove(var);
							  			
				}
				break;
			case INTEGER:
				{
				setState(224);
				match(INTEGER);
				}
				break;
			case DECIMAL:
				{
				setState(225);
				match(DECIMAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			upLimitStack.push(_input.LT(-1).getText());
			setState(229);
			match(T__16);
			setState(230);
			match(ACH);

						  		currThread = new ArrayList<AbstractCommand>();
							    stack.push(currThread);
						  	  
			setState(233); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(232);
				cmd();
				}
				}
				setState(235); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__22) | (1L << ID))) != 0) );
			setState(237);
			match(FCH);

						  		listaRep=stack.pop();
						  		CommandRepeticao cmd = new CommandRepeticao(repIDstack.pop(), lowLimitStack.pop(), upLimitStack.pop(), listaRep);
						  		stack.peek().add(cmd);
						  	  
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

	public static class CmdsetattribContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode INTEGER() { return getToken(IsiLangParser.INTEGER, 0); }
		public CmdsetattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdsetattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdsetattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdsetattrib(this);
		}
	}

	public final CmdsetattribContext cmdsetattrib() throws RecognitionException {
		CmdsetattribContext _localctx = new CmdsetattribContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdsetattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(ID);

						  		verificaID(_input.LT(-1));
						  		_setOpID=_input.LT(-1).getText();
						 		IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
						  		if(var.getType() != IsiVariable.SET){
						  			throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible with expression. Expected conjunto, found "+type(var.getType())+"\n");
						  		}
						  	
			setState(242);
			match(T__17);
			setState(243);
			match(ID);

						  		verificaID(_input.LT(-1));
						  		_fOp=_input.LT(-1).getText();
						 		var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
						  		if(var.getType() != IsiVariable.SET){
						  			throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible with expression. Expected conjunto, found "+type(var.getType())+"\n");
						  		}
						  		if(unused.contains(var)){
									System.out.println("Warning: " + tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" was not initialized\n");
								}
								unused.remove(var);
						  	
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				{
				setState(245);
				match(T__18);
				_setOp=CommandOperacaoConjunto.UNION;
				}
				break;
			case T__19:
				{
				setState(247);
				match(T__19);
				_setOp=CommandOperacaoConjunto.INTERSECTION;
				}
				break;
			case T__20:
				{
				setState(249);
				match(T__20);
				_setOp=CommandOperacaoConjunto.DIFFERENCE;
				}
				break;
			case T__21:
				{
				setState(251);
				match(T__21);
				_setOp=CommandOperacaoConjunto.INCLUDE;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(259);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(255);
				match(ID);

							  		verificaID(_input.LT(-1));
							  		_sOp=_input.LT(-1).getText();
							 		var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
							  		if(var.getType() != IsiVariable.SET && _setOp != CommandOperacaoConjunto.INCLUDE){
							  			throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible with expression. Expected conjunto, found "+type(var.getType())+"\n");
							  		}
							  		if(_setOp == CommandOperacaoConjunto.INCLUDE && var.getType() != IsiVariable.INTEGER){
							  			throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible with expression. Expected inteiro, found "+type(var.getType())+"\n");
							  		}
							  		if(unused.contains(var)){
										System.out.println("Warning: " + tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" was not initialized\n");
									}
									unused.remove(var);
							  	
				}
				break;
			case INTEGER:
				{
				setState(257);
				match(INTEGER);

							  				if(_setOp != CommandOperacaoConjunto.INCLUDE){
							  					throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+_input.LT(-1).getText()+" type is not compatible with expression. Expected conjunto, found inteiro\n");
							  				}
							  				_sOp=_input.LT(-1).getText();
							  			
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(261);
			match(SC);

						 		var = (IsiVariable) symbolTable.get(_setOpID);
								unused.remove(var);
						  		CommandOperacaoConjunto cmd = new CommandOperacaoConjunto(_setOpID, _fOp, _sOp, _setOp);
						  		stack.peek().add(cmd);
						  	
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

	public static class CmdenquantoContext extends ParserRuleContext {
		public BoolexpContext boolexp() {
			return getRuleContext(BoolexpContext.class,0);
		}
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdenquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdenquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdenquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdenquanto(this);
		}
	}

	public final CmdenquantoContext cmdenquanto() throws RecognitionException {
		CmdenquantoContext _localctx = new CmdenquantoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmdenquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(T__22);

										_exprContent="";
										_boolExp="";
									
			setState(266);
			match(AP);
			setState(267);
			boolexp();
			setState(268);
			match(FP);
			boolExpStack.push(_boolExp);
			setState(270);
			match(ACH);

							   	currThread = new ArrayList<AbstractCommand>();
							    stack.push(currThread);
							   
			setState(273); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(272);
				cmd();
				}
				}
				setState(275); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__22) | (1L << ID))) != 0) );
			setState(277);
			match(FCH);

						    	listaWhile=stack.pop();
						     	CommandEnquanto cmd = new CommandEnquanto(boolExpStack.pop(), listaWhile);
						     	stack.peek().add(cmd);
						    
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

	public static class CmdsetloopContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdsetloopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdsetloop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdsetloop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdsetloop(this);
		}
	}

	public final CmdsetloopContext cmdsetloop() throws RecognitionException {
		CmdsetloopContext _localctx = new CmdsetloopContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cmdsetloop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(T__13);
			setState(281);
			match(ID);

									verificaID(_input.LT(-1));
						  			IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
						  			if(var.getType() != IsiVariable.INTEGER){
						  				throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible with expression. Expected inteiro, found "+type(var.getType())+"\n");
						  			}
									unused.remove(var);
									loopIDstack.push(_input.LT(-1).getText());
								
			setState(283);
			match(T__23);
			setState(284);
			match(ID);

									verificaID(_input.LT(-1));
						  			var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
						  			if(var.getType() != IsiVariable.SET){
						  				throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible with expression. Expected conjunto, found "+type(var.getType())+"\n");
						  			}
									if(unused.contains(var)){
										System.out.println("Warning: " + tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" was not initialized\n");
									}
									unused.remove(var);
									loopSetStack.push(_input.LT(-1).getText());
								
			setState(286);
			match(T__16);
			setState(287);
			match(ACH);

							   		currThread = new ArrayList<AbstractCommand>();
							    	stack.push(currThread);
							    
			setState(290); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(289);
				cmd();
				}
				}
				setState(292); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__22) | (1L << ID))) != 0) );
			setState(294);
			match(FCH);

							    	_loopID  = loopIDstack.pop();
							    	_loopSet = loopSetStack.pop();
							    	listaSetLoop=stack.pop();
							     	CommandLoopConjunto cmd = new CommandLoopConjunto(_loopID, _loopSet, listaSetLoop);
							     	stack.peek().add(cmd);
							    
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
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(IsiLangParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(IsiLangParser.INTEGER, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expr);
		int _la;
		try {
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				termo();
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__24))) != 0)) {
					{
					{
					setState(298);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__24))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					_exprContent += _input.LT(-1).getText();
					setState(300);
					termo();
					}
					}
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(306);
					match(ID);

								  			verificaID(_input.LT(-1));
								  			IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
								  			if(var.getType() != IsiVariable.INTEGER){
								  				throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible with expression. Expected inteiro, found "+type(var.getType())+"\n");
								  			}
											if(unused.contains(var)){
												System.out.println("Warning: " + tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" was not initialized\n");
											}
											unused.remove(var);
								  		
					}
					break;
				case INTEGER:
					{
					setState(308);
					match(INTEGER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				 _exprContent += _input.LT(-1).getText();
				setState(312);
				match(T__25);
				 _exprContent += _input.LT(-1).getText();
				setState(317);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(314);
					match(ID);

								  			verificaID(_input.LT(-1));
								  			IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
								  			if(var.getType() != IsiVariable.INTEGER){
								  				throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible with expression. Expected inteiro, found "+type(var.getType())+"\n");
								  			}
											if(unused.contains(var)){
												System.out.println("Warning: " + tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" was not initialized\n");
											}
											unused.remove(var);
								  		
					}
					break;
				case INTEGER:
					{
					setState(316);
					match(INTEGER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				 _exprContent += _input.LT(-1).getText();
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode INTEGER() { return getToken(IsiLangParser.INTEGER, 0); }
		public TerminalNode DECIMAL() { return getToken(IsiLangParser.DECIMAL, 0); }
		public ArrayaccessContext arrayaccess() {
			return getRuleContext(ArrayaccessContext.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_termo);
		int _la;
		try {
			setState(329);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				match(ID);
				verificaID(_input.LT(-1));
								  IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
								  if(!isTypeCompatible(_expType, var.getType())){
								  	throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible with expression. Expected: "+type(_expType)+", found "+type(var.getType())+"\n");
								  }
								  if(unused.contains(var)){
								  	System.out.println("Warning: " + tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" was not initialized\n");
								  }
								  unused.remove(var);
								  _exprContent += _input.LT(-1).getText();
								 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				_la = _input.LA(1);
				if ( !(_la==INTEGER || _la==DECIMAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				_exprContent += _input.LT(-1).getText();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(326);
				arrayaccess();
				_exprContent += _arrayAccessContent;
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

	public static class BoolexpContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public BoolexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBoolexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBoolexp(this);
		}
	}

	public final BoolexpContext boolexp() throws RecognitionException {
		BoolexpContext _localctx = new BoolexpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_boolexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			expr();
			_boolExp+=_exprContent;
			setState(333);
			match(OPREL);

						  			_boolExp+=_input.LT(-1).getText();
						  			_exprContent="";
						  		
			setState(335);
			expr();
			_boolExp+=_exprContent;
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

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(IsiLangParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(IsiLangParser.INTEGER, i);
		}
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(ACH);
			 _exprContent += _input.LT(-1).getText();
			setState(340);
			match(INTEGER);

					  		_exprContent += _input.LT(-1).getText();
					  		_setSize=1;
					  	
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(342);
				match(VIR);
				 _exprContent += _input.LT(-1).getText();
				setState(344);
				match(INTEGER);

						  		_exprContent += _input.LT(-1).getText();
						  		_setSize+=1;
						  	
				}
				}
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(351);
			match(FCH);
			 _exprContent += _input.LT(-1).getText();
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

	public static class ArrayaccessContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode ACT() { return getToken(IsiLangParser.ACT, 0); }
		public TerminalNode FCT() { return getToken(IsiLangParser.FCT, 0); }
		public TerminalNode INTEGER() { return getToken(IsiLangParser.INTEGER, 0); }
		public ArrayaccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayaccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterArrayaccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitArrayaccess(this);
		}
	}

	public final ArrayaccessContext arrayaccess() throws RecognitionException {
		ArrayaccessContext _localctx = new ArrayaccessContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arrayaccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(ID);

								verificaID(_input.LT(-1));
								IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
								if(var.getType() != IsiVariable.ARRAY){
									throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible. Expected vetor found " + type(var.getType()));
								}
								unused.remove(var);
								_arrayAccessContent=_input.LT(-1).getText();
							
			setState(356);
			match(ACT);
			_arrayAccessContent+=_input.LT(-1).getText();
			setState(361);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(358);
				match(ID);

									verificaID(_input.LT(-1));
									IsiVariable var2 = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
									if(var2.getType() != IsiVariable.INTEGER){
										throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var2.getName()+" type is not compatible. Expected inteiro found " + type(var2.getType()));
									}
								  if(unused.contains(var2)){
								  	System.out.println("Warning: " + tokenPosition(_input.LT(-1))+" Symbol "+var2.getName()+" was not initialized\n");
								  }
								
				}
				break;
			case INTEGER:
				{
				setState(360);
				match(INTEGER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_arrayAccessContent+=_input.LT(-1).getText();
			setState(364);
			match(FCT);
			_arrayAccessContent+=_input.LT(-1).getText();
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

	public static class SetContext extends ParserRuleContext {
		public TerminalNode ACT() { return getToken(IsiLangParser.ACT, 0); }
		public TerminalNode FCT() { return getToken(IsiLangParser.FCT, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(IsiLangParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(IsiLangParser.INTEGER, i);
		}
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitSet(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_set);
		int _la;
		try {
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				match(ACT);
				setState(368);
				match(FCT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
				match(ACT);
				setState(370);
				match(INTEGER);

					  		_exprContent += _input.LT(-1).getText();
					  		_setSize=1;
					  	
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(372);
					match(VIR);
					 _exprContent += _input.LT(-1).getText();
					setState(374);
					match(INTEGER);

						  		_exprContent += _input.LT(-1).getText();
						  		_setSize+=1;
						  	
					}
					}
					setState(380);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(381);
				match(FCT);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u0183\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3\62\n\3"+
		"\r\3\16\3\63\3\4\3\4\3\4\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4N\n\4\f\4\16\4Q\13\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4[\n\4\f\4\16\4^\13\4\3\4\5\4a\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5i\n\5\3\6\3\6\6\6m\n\6\r\6\16\6n\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7y\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0082\n\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008f\n\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u009e\n\t\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u00a5\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b2"+
		"\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u00c0"+
		"\n\13\r\13\16\13\u00c1\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u00ca\n\13\r"+
		"\13\16\13\u00cb\3\13\3\13\3\13\5\13\u00d1\n\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u00dd\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e5\n\f"+
		"\3\f\3\f\3\f\3\f\3\f\6\f\u00ec\n\f\r\f\16\f\u00ed\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0100\n\r\3\r\3\r\3\r"+
		"\3\r\5\r\u0106\n\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\6\16\u0114\n\16\r\16\16\16\u0115\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u0125\n\17\r\17\16\17\u0126\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u0130\n\20\f\20\16\20\u0133\13\20"+
		"\3\20\3\20\3\20\5\20\u0138\n\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0140"+
		"\n\20\3\20\5\20\u0143\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u014c"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u015d\n\23\f\23\16\23\u0160\13\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u016c\n\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u017b\n\25\f\25\16\25\u017e"+
		"\13\25\3\25\5\25\u0181\n\25\3\25\2\2\26\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(\2\4\4\2\25\27\33\33\3\2)*\2\u019d\2*\3\2\2\2\4\61\3\2"+
		"\2\2\6`\3\2\2\2\bh\3\2\2\2\nj\3\2\2\2\fx\3\2\2\2\16z\3\2\2\2\20\u009d"+
		"\3\2\2\2\22\u00a4\3\2\2\2\24\u00b6\3\2\2\2\26\u00d4\3\2\2\2\30\u00f2\3"+
		"\2\2\2\32\u010a\3\2\2\2\34\u011a\3\2\2\2\36\u0142\3\2\2\2 \u014b\3\2\2"+
		"\2\"\u014d\3\2\2\2$\u0154\3\2\2\2&\u0164\3\2\2\2(\u0180\3\2\2\2*+\7\3"+
		"\2\2+,\5\4\3\2,-\5\n\6\2-.\7\4\2\2./\b\2\1\2/\3\3\2\2\2\60\62\5\6\4\2"+
		"\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\5\3\2\2\2"+
		"\65\66\5\b\5\2\66\67\7(\2\2\67=\b\4\1\289\7\37\2\29:\7(\2\2:<\b\4\1\2"+
		";8\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7 \2\2"+
		"Aa\3\2\2\2BC\7\5\2\2CD\b\4\1\2DE\7(\2\2EF\b\4\1\2FG\7)\2\2GO\b\4\1\2H"+
		"I\7\37\2\2IJ\7(\2\2JK\b\4\1\2KL\7)\2\2LN\b\4\1\2MH\3\2\2\2NQ\3\2\2\2O"+
		"M\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2Ra\7 \2\2ST\7\6\2\2TU\b\4\1\2U"+
		"V\7(\2\2V\\\b\4\1\2WX\7\37\2\2XY\7(\2\2Y[\b\4\1\2ZW\3\2\2\2[^\3\2\2\2"+
		"\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_a\7 \2\2`\65\3\2\2\2`B\3\2"+
		"\2\2`S\3\2\2\2a\7\3\2\2\2bc\7\7\2\2ci\b\5\1\2de\7\b\2\2ei\b\5\1\2fg\7"+
		"\t\2\2gi\b\5\1\2hb\3\2\2\2hd\3\2\2\2hf\3\2\2\2i\t\3\2\2\2jl\b\6\1\2km"+
		"\5\f\7\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2o\13\3\2\2\2py\5\16\b"+
		"\2qy\5\20\t\2ry\5\22\n\2sy\5\24\13\2ty\5\26\f\2uy\5\30\r\2vy\5\32\16\2"+
		"wy\5\34\17\2xp\3\2\2\2xq\3\2\2\2xr\3\2\2\2xs\3\2\2\2xt\3\2\2\2xu\3\2\2"+
		"\2xv\3\2\2\2xw\3\2\2\2y\r\3\2\2\2z{\7\n\2\2{\u0081\7\35\2\2|}\7(\2\2}"+
		"\u0082\b\b\1\2~\177\5&\24\2\177\u0080\b\b\1\2\u0080\u0082\3\2\2\2\u0081"+
		"|\3\2\2\2\u0081~\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7\36\2\2\u0084"+
		"\u0085\7 \2\2\u0085\u0086\b\b\1\2\u0086\17\3\2\2\2\u0087\u0088\7\13\2"+
		"\2\u0088\u008e\7\35\2\2\u0089\u008a\7(\2\2\u008a\u008f\b\t\1\2\u008b\u008c"+
		"\5&\24\2\u008c\u008d\b\t\1\2\u008d\u008f\3\2\2\2\u008e\u0089\3\2\2\2\u008e"+
		"\u008b\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7\36\2\2\u0091\u0092\7"+
		" \2\2\u0092\u009e\b\t\1\2\u0093\u0094\7\f\2\2\u0094\u0095\7\35\2\2\u0095"+
		"\u0096\7\36\2\2\u0096\u0097\7 \2\2\u0097\u009e\b\t\1\2\u0098\u0099\7\r"+
		"\2\2\u0099\u009a\7\35\2\2\u009a\u009b\7\36\2\2\u009b\u009c\7 \2\2\u009c"+
		"\u009e\b\t\1\2\u009d\u0087\3\2\2\2\u009d\u0093\3\2\2\2\u009d\u0098\3\2"+
		"\2\2\u009e\21\3\2\2\2\u009f\u00a0\7(\2\2\u00a0\u00a5\b\n\1\2\u00a1\u00a2"+
		"\5&\24\2\u00a2\u00a3\b\n\1\2\u00a3\u00a5\3\2\2\2\u00a4\u009f\3\2\2\2\u00a4"+
		"\u00a1\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7\'\2\2\u00a7\u00b1\b\n"+
		"\1\2\u00a8\u00a9\5\36\20\2\u00a9\u00aa\b\n\1\2\u00aa\u00b2\3\2\2\2\u00ab"+
		"\u00ac\5$\23\2\u00ac\u00ad\b\n\1\2\u00ad\u00b2\3\2\2\2\u00ae\u00af\5("+
		"\25\2\u00af\u00b0\b\n\1\2\u00b0\u00b2\3\2\2\2\u00b1\u00a8\3\2\2\2\u00b1"+
		"\u00ab\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7 "+
		"\2\2\u00b4\u00b5\b\n\1\2\u00b5\23\3\2\2\2\u00b6\u00b7\7\16\2\2\u00b7\u00b8"+
		"\b\13\1\2\u00b8\u00b9\7\35\2\2\u00b9\u00ba\5\"\22\2\u00ba\u00bb\7\36\2"+
		"\2\u00bb\u00bc\b\13\1\2\u00bc\u00bd\7!\2\2\u00bd\u00bf\b\13\1\2\u00be"+
		"\u00c0\5\f\7\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7\"\2\2\u00c4"+
		"\u00d0\b\13\1\2\u00c5\u00c6\7\17\2\2\u00c6\u00c7\7!\2\2\u00c7\u00c9\b"+
		"\13\1\2\u00c8\u00ca\5\f\7\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\7\""+
		"\2\2\u00ce\u00cf\b\13\1\2\u00cf\u00d1\3\2\2\2\u00d0\u00c5\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\13\1\2\u00d3\25\3\2\2"+
		"\2\u00d4\u00d5\7\20\2\2\u00d5\u00d6\7(\2\2\u00d6\u00d7\b\f\1\2\u00d7\u00dc"+
		"\7\21\2\2\u00d8\u00d9\7(\2\2\u00d9\u00dd\b\f\1\2\u00da\u00dd\7)\2\2\u00db"+
		"\u00dd\7*\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2"+
		"\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\b\f\1\2\u00df\u00e4\7\22\2\2\u00e0"+
		"\u00e1\7(\2\2\u00e1\u00e5\b\f\1\2\u00e2\u00e5\7)\2\2\u00e3\u00e5\7*\2"+
		"\2\u00e4\u00e0\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6"+
		"\3\2\2\2\u00e6\u00e7\b\f\1\2\u00e7\u00e8\7\23\2\2\u00e8\u00e9\7!\2\2\u00e9"+
		"\u00eb\b\f\1\2\u00ea\u00ec\5\f\7\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00f0\7\"\2\2\u00f0\u00f1\b\f\1\2\u00f1\27\3\2\2\2\u00f2\u00f3\7(\2\2"+
		"\u00f3\u00f4\b\r\1\2\u00f4\u00f5\7\24\2\2\u00f5\u00f6\7(\2\2\u00f6\u00ff"+
		"\b\r\1\2\u00f7\u00f8\7\25\2\2\u00f8\u0100\b\r\1\2\u00f9\u00fa\7\26\2\2"+
		"\u00fa\u0100\b\r\1\2\u00fb\u00fc\7\27\2\2\u00fc\u0100\b\r\1\2\u00fd\u00fe"+
		"\7\30\2\2\u00fe\u0100\b\r\1\2\u00ff\u00f7\3\2\2\2\u00ff\u00f9\3\2\2\2"+
		"\u00ff\u00fb\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0105\3\2\2\2\u0101\u0102"+
		"\7(\2\2\u0102\u0106\b\r\1\2\u0103\u0104\7)\2\2\u0104\u0106\b\r\1\2\u0105"+
		"\u0101\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\7 "+
		"\2\2\u0108\u0109\b\r\1\2\u0109\31\3\2\2\2\u010a\u010b\7\31\2\2\u010b\u010c"+
		"\b\16\1\2\u010c\u010d\7\35\2\2\u010d\u010e\5\"\22\2\u010e\u010f\7\36\2"+
		"\2\u010f\u0110\b\16\1\2\u0110\u0111\7!\2\2\u0111\u0113\b\16\1\2\u0112"+
		"\u0114\5\f\7\2\u0113\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\7\"\2\2\u0118"+
		"\u0119\b\16\1\2\u0119\33\3\2\2\2\u011a\u011b\7\20\2\2\u011b\u011c\7(\2"+
		"\2\u011c\u011d\b\17\1\2\u011d\u011e\7\32\2\2\u011e\u011f\7(\2\2\u011f"+
		"\u0120\b\17\1\2\u0120\u0121\7\23\2\2\u0121\u0122\7!\2\2\u0122\u0124\b"+
		"\17\1\2\u0123\u0125\5\f\7\2\u0124\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126"+
		"\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\7\""+
		"\2\2\u0129\u012a\b\17\1\2\u012a\35\3\2\2\2\u012b\u0131\5 \21\2\u012c\u012d"+
		"\t\2\2\2\u012d\u012e\b\20\1\2\u012e\u0130\5 \21\2\u012f\u012c\3\2\2\2"+
		"\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0143"+
		"\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\7(\2\2\u0135\u0138\b\20\1\2\u0136"+
		"\u0138\7)\2\2\u0137\u0134\3\2\2\2\u0137\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u013a\b\20\1\2\u013a\u013b\7\34\2\2\u013b\u013f\b\20\1\2\u013c"+
		"\u013d\7(\2\2\u013d\u0140\b\20\1\2\u013e\u0140\7)\2\2\u013f\u013c\3\2"+
		"\2\2\u013f\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0143\b\20\1\2\u0142"+
		"\u012b\3\2\2\2\u0142\u0137\3\2\2\2\u0143\37\3\2\2\2\u0144\u0145\7(\2\2"+
		"\u0145\u014c\b\21\1\2\u0146\u0147\t\3\2\2\u0147\u014c\b\21\1\2\u0148\u0149"+
		"\5&\24\2\u0149\u014a\b\21\1\2\u014a\u014c\3\2\2\2\u014b\u0144\3\2\2\2"+
		"\u014b\u0146\3\2\2\2\u014b\u0148\3\2\2\2\u014c!\3\2\2\2\u014d\u014e\5"+
		"\36\20\2\u014e\u014f\b\22\1\2\u014f\u0150\7&\2\2\u0150\u0151\b\22\1\2"+
		"\u0151\u0152\5\36\20\2\u0152\u0153\b\22\1\2\u0153#\3\2\2\2\u0154\u0155"+
		"\7!\2\2\u0155\u0156\b\23\1\2\u0156\u0157\7)\2\2\u0157\u015e\b\23\1\2\u0158"+
		"\u0159\7\37\2\2\u0159\u015a\b\23\1\2\u015a\u015b\7)\2\2\u015b\u015d\b"+
		"\23\1\2\u015c\u0158\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015f\u0161\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162\7\""+
		"\2\2\u0162\u0163\b\23\1\2\u0163%\3\2\2\2\u0164\u0165\7(\2\2\u0165\u0166"+
		"\b\24\1\2\u0166\u0167\7#\2\2\u0167\u016b\b\24\1\2\u0168\u0169\7(\2\2\u0169"+
		"\u016c\b\24\1\2\u016a\u016c\7)\2\2\u016b\u0168\3\2\2\2\u016b\u016a\3\2"+
		"\2\2\u016c\u016d\3\2\2\2\u016d\u016e\b\24\1\2\u016e\u016f\7$\2\2\u016f"+
		"\u0170\b\24\1\2\u0170\'\3\2\2\2\u0171\u0172\7#\2\2\u0172\u0181\7$\2\2"+
		"\u0173\u0174\7#\2\2\u0174\u0175\7)\2\2\u0175\u017c\b\25\1\2\u0176\u0177"+
		"\7\37\2\2\u0177\u0178\b\25\1\2\u0178\u0179\7)\2\2\u0179\u017b\b\25\1\2"+
		"\u017a\u0176\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d"+
		"\3\2\2\2\u017d\u017f\3\2\2\2\u017e\u017c\3\2\2\2\u017f\u0181\7$\2\2\u0180"+
		"\u0171\3\2\2\2\u0180\u0173\3\2\2\2\u0181)\3\2\2\2\"\63=O\\`hnx\u0081\u008e"+
		"\u009d\u00a4\u00b1\u00c1\u00cb\u00d0\u00dc\u00e4\u00ed\u00ff\u0105\u0115"+
		"\u0126\u0131\u0137\u013f\u0142\u014b\u015e\u016b\u017c\u0180";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}