package ast;

import java.util.ArrayList;

public class CommandRepeticao extends AbstractCommand{
	
	private String id;
	private String lowerLimit;
	private String upperLimit;
	private ArrayList<AbstractCommand> cmds;
	
	public CommandRepeticao(String id, String lowerLimit, String upperLimit, ArrayList<AbstractCommand> cmds) {
		this.id=id;
		this.lowerLimit=lowerLimit;
		this.upperLimit=upperLimit;
		this.cmds=cmds;
	}

	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateCCode() {
		StringBuilder str = new StringBuilder();
		str.append("for("+id+"="+lowerLimit+";"+id+"<="+upperLimit+";"+id+"="+id+"+1){\n");
		for(AbstractCommand cmd: cmds) {
			str.append("    "+cmd.generateCCode()+"\n");
		}
		str.append("  }\n");
		return str.toString();
	}

}
