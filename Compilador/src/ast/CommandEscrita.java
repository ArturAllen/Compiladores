package ast;

import datastructures.IsiVariable;

public class CommandEscrita extends AbstractCommand{
	
	private String id;
	private int type;
	public static final int SPACE = 254;
	public static final int nLINE = 255;
	
	public CommandEscrita(String id, int type) {
		this.id=id;
		this.type=type;
	}
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return "System.out.println("+id+");";
	}
	@Override
	public String generateCCode() {
		String flag="";
		switch(this.type){
			case IsiVariable.DECIMAL:
				flag="\"%lf\", ";
			break;
			case IsiVariable.INTEGER:
				flag="\"%d\", ";
			break;
			case IsiVariable.TEXT:
				flag="\"%s\", ";
			break;
			case IsiVariable.SET:
				return "printset("+id+");";
		}
		return "printf("+flag+id+");";
	}
	@Override
	public String toString() {
		return "CommandEscrita [id=" + id + "]";
	}
	
}
