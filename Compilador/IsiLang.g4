grammar IsiLang;

@header{
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
}

@members{
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
}

prog	: 'programa' decl bloco 'fimprog;'
		  {program.setVarTable(symbolTable);
		   program.setComandos(stack.pop());
		   for(IsiSymbol s: unused){
		   	System.out.println("Warning: symbol " + s.getName() + " declared but not used\n");
		   } 
		  }
		;
decl	: (declaravar)+
		;
declaravar	: tipo ID {
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
			  (VIR 
			  ID {
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
			  )* SC
			  | 'vetor' {_tipo = IsiVariable.ARRAY;}
			    ID {_varName = _input.LT(-1).getText();}
			    INTEGER
			    	{
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
			    (VIR 
			    ID {_varName = _input.LT(-1).getText();}
			    INTEGER
			    	{
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
			    )* SC
			    | 'conjunto' {_tipo = IsiVariable.SET;}
			      ID 
			      	{
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
			      (VIR
			      ID 
			      	{
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
			      )* SC
		;
tipo	: 'inteiro' {_tipo = IsiVariable.INTEGER;}
		| 'decimal' {_tipo = IsiVariable.DECIMAL;}
		| 'texto' {_tipo = IsiVariable.TEXT;}
		;
bloco	:	{currThread = new ArrayList<AbstractCommand>();
			 stack.push(currThread);
			}
		  (cmd)+
		;
cmd		: cmdLeitura | cmdescrita | cmdattrib | cmdselecao | cmdrepeticao | cmdsetattrib | cmdenquanto | cmdsetloop
		;
cmdLeitura	: 'leia' AP 
					 (ID
					 	{
					 		verificaID(_input.LT(-1));
					 		_readID = _input.LT(-1).getText();
					 		IsiVariable var = (IsiVariable) symbolTable.get(_readID);
							unused.remove(var);
					 		_readType = var.getType();
					 		if(_readType == IsiVariable.ARRAY || _readType == IsiVariable.SET){
					 			throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Cannot read type "+type(_readType)+"\n");
					 		}
					 	}
					 |arrayaccess
					 	{
					 		_readID=_arrayAccessContent;
					 		_readType=IsiVariable.INTEGER;
					 	}
					 ) 
					 FP 
					 SC
					 {
					 	CommandLeitura cmd = new CommandLeitura(_readID, _readType);
					 	stack.peek().add(cmd);
					 }
			;
cmdescrita	: 'escreva' AP (ID {verificaID(_input.LT(-1));
							    _writeID=_input.LT(-1).getText();
							    IsiVariable var = (IsiVariable) symbolTable.get(_writeID);
							    if(unused.contains(var)){
							    	System.out.println("Warning: " + tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" was not initialized\n");
							    }
				  				unused.remove(var);
							    _writeType = var.getType();
							   }
						   |arrayaccess{
						   				_writeID=_arrayAccessContent;
						   				_writeType=IsiVariable.INTEGER;
						   			   }
						   )	
						   FP
						   SC
						   {
						   		CommandEscrita cmd = new CommandEscrita(_writeID, _writeType);
						   		stack.peek().add(cmd);
						   }
			| 'espaco' AP FP SC
				{
					CommandEscrita cmd = new CommandEscrita("\" \"", CommandEscrita.SPACE);
					stack.peek().add(cmd);
				}
			| 'linha' AP FP SC
				{
					CommandEscrita cmd = new CommandEscrita("\"\\n\"", CommandEscrita.nLINE);
					stack.peek().add(cmd);
				}
			;
cmdattrib	: (ID {verificaID(_input.LT(-1));
				   _exprID=_input.LT(-1).getText();
				   IsiVariable var = (IsiVariable) symbolTable.get(_exprID);
				   _expType=var.getType();
				  }
			  |arrayaccess {
			  				_exprID=_arrayAccessContent;
			  				_expType=IsiVariable.INTEGER;
			  			   }
			  ) 
			  ATTR {_exprContent="";}
			  (expr
			  	{
			  		if(_expType==IsiVariable.TEXT||_expType==IsiVariable.ARRAY||_expType==IsiVariable.SET){
			  			throw new IsiSemanticException("line "+_input.LT(-1).getLine()+" cannot assign expression to "+type(_expType)+"\n");
			  		}
			  	}
			  |array 
			  	{
			  		_colecAttrib=true;
			  		if(_expType!=IsiVariable.ARRAY){
			  			throw new IsiSemanticException("line "+_input.LT(-1).getLine()+" Symbol "+_exprID+" is not a vetor\n");
			  		}
			  		IsiVariable var = (IsiVariable) symbolTable.get(_exprID);
			  		_expAuxData = var.getValue();
			  	}
			  |set
			  	{
			  		_colecAttrib=true;
			  		if(_expType!=IsiVariable.SET){
			  			throw new IsiSemanticException("line "+_input.LT(-1).getLine()+" Symbol "+_exprID+" is not a conjunto\n");
			  		}
			  	}
			  )
			  SC
			  {
				IsiVariable var = (IsiVariable) symbolTable.get(_exprID);
				unused.remove(var);
				if(_colecAttrib){
					_expAuxData=_setSize+"";
				}
			  	CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent, _expType, _expAuxData);
			  	stack.peek().add(cmd);
			  }
			;
cmdselecao  : 'se' 
					
					{
						_exprContent="";
						_boolExp="";
					}
				   AP 
				   boolexp
				   FP {boolExpStack.push(_boolExp);}
				   ACH 
				   {currThread = new ArrayList<AbstractCommand>();
				    stack.push(currThread);
				   }
				   (cmd)+
				    FCH
				    {
				     listaTrue=stack.pop();
				    }
			  ('senao' 
			   ACH
			   {
			   	currThread = new ArrayList<AbstractCommand>();
			   	stack.push(currThread);
			   } 
			   (cmd)+ 
			   FCH
			   {
			    listaFalse = stack.pop();
			   }
			   )?
			    {
			     CommandDecisao cmd = new CommandDecisao(boolExpStack.pop(), listaTrue, listaFalse);
			     stack.peek().add(cmd);
			    }
			;
cmdrepeticao: 'para' 
			  ID {
				  	  verificaID(_input.LT(-1));
				 	  IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
				  	  if(var.getType() != IsiVariable.INTEGER && var.getType() != IsiVariable.DECIMAL){
				  		  throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible. Expected inteiro or decimal, found "+type(var.getType())+"\n");
				  	  }
				  	  repIDstack.push(_input.LT(-1).getText());
					  unused.remove(var);
			  	 } 
			  'de' (ID
			  			{
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
			  		|INTEGER|DECIMAL) {lowLimitStack.push(_input.LT(-1).getText());}
			  'ate' (ID
			  			{
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
			  		|INTEGER|DECIMAL) {upLimitStack.push(_input.LT(-1).getText());}
			  'faca' 
			  ACH {
			  		currThread = new ArrayList<AbstractCommand>();
				    stack.push(currThread);
			  	  } 
			  (cmd)+ 
			  FCH {
			  		listaRep=stack.pop();
			  		CommandRepeticao cmd = new CommandRepeticao(repIDstack.pop(), lowLimitStack.pop(), upLimitStack.pop(), listaRep);
			  		stack.peek().add(cmd);
			  	  }
			;
cmdsetattrib: ID
			  	{
			  		verificaID(_input.LT(-1));
			  		_setOpID=_input.LT(-1).getText();
			 		IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
			  		if(var.getType() != IsiVariable.SET){
			  			throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible with expression. Expected conjunto, found "+type(var.getType())+"\n");
			  		}
			  	}
			  ':=' 
			  ID
			  	 {
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
			  	}
			  ('+' {_setOp=CommandOperacaoConjunto.UNION;}
			  |'*' {_setOp=CommandOperacaoConjunto.INTERSECTION;}
			  |'-' {_setOp=CommandOperacaoConjunto.DIFFERENCE;}
			  |'<<'{_setOp=CommandOperacaoConjunto.INCLUDE;}
			  ) 
			  (ID
			  	 {
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
			  |INTEGER
			  			{
			  				if(_setOp != CommandOperacaoConjunto.INCLUDE){
			  					throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+_input.LT(-1).getText()+" type is not compatible with expression. Expected conjunto, found inteiro\n");
			  				}
			  				_sOp=_input.LT(-1).getText();
			  			}
			  )	
			  SC
			  	{
			 		var = (IsiVariable) symbolTable.get(_setOpID);
					unused.remove(var);
			  		CommandOperacaoConjunto cmd = new CommandOperacaoConjunto(_setOpID, _fOp, _sOp, _setOp);
			  		stack.peek().add(cmd);
			  	}
			;
cmdenquanto	: 'enquanto' 
						{
							_exprContent="";
							_boolExp="";
						}
			  '(' boolexp ')' {boolExpStack.push(_boolExp);}
			  ACH
				   {
				   	currThread = new ArrayList<AbstractCommand>();
				    stack.push(currThread);
				   }
			  (cmd)+
			  FCH
			    {
			    	listaWhile=stack.pop();
			     	CommandEnquanto cmd = new CommandEnquanto(boolExpStack.pop(), listaWhile);
			     	stack.peek().add(cmd);
			    }
			;
cmdsetloop	:	'para' 
				ID 
					{
						verificaID(_input.LT(-1));
			  			IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
			  			if(var.getType() != IsiVariable.INTEGER){
			  				throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible with expression. Expected inteiro, found "+type(var.getType())+"\n");
			  			}
						unused.remove(var);
						loopIDstack.push(_input.LT(-1).getText());
					}
				'em' 
				ID 
					{
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
					}
				'faca' 
				ACH
				    {
				   		currThread = new ArrayList<AbstractCommand>();
				    	stack.push(currThread);
				    }
				(cmd)+
				FCH
				    {
				    	_loopID  = loopIDstack.pop();
				    	_loopSet = loopSetStack.pop();
				    	listaSetLoop=stack.pop();
				     	CommandLoopConjunto cmd = new CommandLoopConjunto(_loopID, _loopSet, listaSetLoop);
				     	stack.peek().add(cmd);
				    }
			;
expr		: termo ( 
			  ('+'|'-'|'*'|'/') {_exprContent += _input.LT(-1).getText();}
			  termo
			  )*
			  | (ID
			  		{
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
			    |INTEGER) { _exprContent += _input.LT(-1).getText();} 
			    '%'			 { _exprContent += _input.LT(-1).getText();}	
			    (ID
			  		{
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
			    |INTEGER) { _exprContent += _input.LT(-1).getText();}
			;
termo		: ID {verificaID(_input.LT(-1));
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
			| (INTEGER|DECIMAL){_exprContent += _input.LT(-1).getText();}
			| arrayaccess {_exprContent += _arrayAccessContent;}
			;
boolexp		: expr {_boolExp+=_exprContent;}
			  OPREL 
			  		{
			  			_boolExp+=_input.LT(-1).getText();
			  			_exprContent="";
			  		}
			  expr {_boolExp+=_exprContent;}
			;
array	: ACH { _exprContent += _input.LT(-1).getText();}
		  INTEGER 
		  	{
		  		_exprContent += _input.LT(-1).getText();
		  		_setSize=1;
		  	}
		  (VIR { _exprContent += _input.LT(-1).getText();}
		  INTEGER 
		  	{
		  		_exprContent += _input.LT(-1).getText();
		  		_setSize+=1;
		  	}
		  )* 
		  FCH { _exprContent += _input.LT(-1).getText();}
		;
arrayaccess	: ID 
				{
					verificaID(_input.LT(-1));
					IsiVariable var = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
					if(var.getType() != IsiVariable.ARRAY){
						throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var.getName()+" type is not compatible. Expected vetor found " + type(var.getType()));
					}
					unused.remove(var);
					_arrayAccessContent=_input.LT(-1).getText();
				}
			  ACT {_arrayAccessContent+=_input.LT(-1).getText();}
			  (ID 
				{
					verificaID(_input.LT(-1));
					IsiVariable var2 = (IsiVariable) symbolTable.get(_input.LT(-1).getText());
					if(var2.getType() != IsiVariable.INTEGER){
						throw new IsiSemanticException(tokenPosition(_input.LT(-1))+" Symbol "+var2.getName()+" type is not compatible. Expected inteiro found " + type(var2.getType()));
					}
				  if(unused.contains(var2)){
				  	System.out.println("Warning: " + tokenPosition(_input.LT(-1))+" Symbol "+var2.getName()+" was not initialized\n");
				  }
				}
			  |INTEGER
			  ) {_arrayAccessContent+=_input.LT(-1).getText();}
			  FCT {_arrayAccessContent+=_input.LT(-1).getText();}
			;
set	: ACT FCT 
	| ACT 
	  INTEGER 
	  	{
	  		_exprContent += _input.LT(-1).getText();
	  		_setSize=1;
	  	}
	  (VIR    { _exprContent += _input.LT(-1).getText();}
	  INTEGER 
	  	{
	  		_exprContent += _input.LT(-1).getText();
	  		_setSize+=1;
	  	}
	  )* FCT
	;
AP	: '('
	;
FP	: ')'
	;
VIR : ','
	;
SC	: ';'
	;
ACH	: '{'
	;
FCH	: '}'
	;
ACT	: '['
	;
FCT	: ']'
	;
OP	: '+' | '-' | '*' | '/'
	;
OPREL	: '>' | '<' | '>=' | '<=' | '==' | '!='
		;	
ATTR: '='
	;
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
INTEGER	: [0-9]+
		;
DECIMAL	: [0-9]+ ('.' [0-9]+)?
		;
WS	: (' ' | '\t' | '\n' | '\r') -> skip;

