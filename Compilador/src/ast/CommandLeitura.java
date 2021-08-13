package ast;

import datastructures.IsiVariable;

public class CommandLeitura extends AbstractCommand{
	
	private String id;
	private int type;
	
	public CommandLeitura (String id, int type) {
		this.id=id;
		this.type=type;
	}
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return id +"= _key." + (type==IsiVariable.DECIMAL? "nextDouble();": "nextLine();");
	}

	@Override
	public String generateCCode() {
		String flag="";
		switch(type){
			case IsiVariable.DECIMAL:
				flag="\"%lf\", &";
			break;
			case IsiVariable.INTEGER:
				flag="\"%d\", &";
			break;
			case IsiVariable.TEXT:
				flag="\"%s\", ";
			break;
		}
		return "scanf(" + flag+id+");";
	}
	@Override
	public String toString() {
		return "CommandLeitura [id=" + id + "]";
	}

}
