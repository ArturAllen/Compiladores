package ast;

import java.util.ArrayList;

public class CommandEnquanto extends AbstractCommand{

	private String condition;
	private ArrayList<AbstractCommand> commands;
	
	public CommandEnquanto(String condition, ArrayList<AbstractCommand> commands) {
		this.condition=condition;
		this.commands=commands;
	}

	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateCCode() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("while("+condition+") {\n");
		for (AbstractCommand cmd : commands) {
			str.append("    "+cmd.generateCCode()+"\n");
		}
		str.append("  }\n");
		return str.toString();
	}
	
	
}
