package ast;

import java.util.ArrayList;

public class CommandLoopConjunto extends AbstractCommand{

	private String loopID;
	private String conjunto;
	private ArrayList<AbstractCommand> commands;
	
	public CommandLoopConjunto(String loopID, String conjunto, ArrayList<AbstractCommand> commands) {
		this.loopID=loopID;
		this.conjunto=conjunto;
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
		str.append("for("+loopID+"=firstElement("+conjunto+"); "+loopID+"<256; "+loopID+"=nextElement("+conjunto+", "+loopID+")"+") {\n");
		for (AbstractCommand cmd : commands) {
			str.append("    "+cmd.generateCCode()+"\n");
		}
		str.append("  }\n");
		return str.toString();
	}
	
	
}
