package ast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import datastructures.IsiSymbol;
import datastructures.IsiSymbolTable;

public class IsiProgram {
	private IsiSymbolTable varTable;
	private ArrayList<AbstractCommand> comandos;
	private String programName;
	
	public IsiSymbolTable getVariable() {
		return varTable;
	}

	public void setVarTable(IsiSymbolTable varTable) {
		this.varTable = varTable;
	}

	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}

	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public void generateTarget() {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Scanner;\n");
		str.append("public class MainClass{\n");
		str.append("  public static void main(String args[]){\n");
		str.append("    Scanner _key = new Scanner(System.in);\n");
		for(IsiSymbol symbol: varTable.getAll()) {
			str.append(symbol.generateJavaCode()+"\n");
		}
		for(AbstractCommand command: comandos) {
			str.append(command.generateJavaCode()+"\n");
		}
		str.append("  }");
		str.append("}");
		
		try {
			FileWriter fr = new FileWriter(new File("MainClass.java"));
			fr.write(str.toString());
			fr.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void generateC() {
		StringBuilder str = new StringBuilder();
		str.append("#include <stdio.h>\n");
		str.append("#include \"set.h\"\n");
		str.append("int main(){\n");
		
		for(IsiSymbol symbol: varTable.getAll()) {
			str.append("  "+symbol.generateCCode()+"\n");
		}
		for(AbstractCommand command: comandos) {
			str.append("  "+command.generateCCode()+"\n");
		}
		str.append("  return 0;\n");
		str.append("}\n");
		
		try {
			FileWriter fr = new FileWriter(new File("prog.c"));
			fr.write(str.toString());
			fr.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
