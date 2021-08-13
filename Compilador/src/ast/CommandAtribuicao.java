package ast;

import datastructures.IsiVariable;

public class CommandAtribuicao extends AbstractCommand{

	private String id;
	private String expr;
	private String auxData;
	private int type;
	
	public CommandAtribuicao(String id, String expr, int type, String auxData) {
		this.id=id;
		this.expr=expr;
		this.type=type;
		this.auxData=auxData;
	}
	@Override
	public String generateJavaCode() {
		return id+"="+expr+";";
	}
	@Override
	public String generateCCode() {
		// TODO Auto-generated method stub
		if(type == IsiVariable.SET) {
			if(expr.isEmpty()) {
				return id+"=emptySet();";
			}
			String arrayName=id.toUpperCase()+"_RELATED_ARRAY";
			StringBuilder str = new StringBuilder();
			str.append("int "+arrayName+"["+auxData+"]");
			str.append("=");
			str.append("{");
			str.append(expr);
			str.append("};\n");
			str.append("  "+id+"=mkset("+arrayName+", "+auxData+");");
			return str.toString();
		}
		if(type == IsiVariable.ARRAY) {
			String arrayName=id.toUpperCase()+"_RELATED_ARRAY";
			StringBuilder str = new StringBuilder();
			str.append("int "+arrayName+"["+auxData+"]");
			str.append("=");
			str.append(expr);
			str.append(";\n");
			str.append("  "+"cpyArray("+arrayName+", "+id+", "+auxData+");");
			return str.toString();
		}
		return id+"="+expr+";";
	}
	@Override
	public String toString() {
		return "CommandAtribuicao [id=" + id + ", expr=" + expr + "]";
	}

}
