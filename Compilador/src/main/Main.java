package main;

import org.antlr.v4.runtime.CommonTokenStream;

import exceptions.IsiSemanticException;

import org.antlr.v4.runtime.CharStreams;

import parser.IsiLangLexer;
import parser.IsiLangParser;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			IsiLangLexer lexer;
			IsiLangParser parser;
			
			lexer = new IsiLangLexer(CharStreams.fromFileName("input.isi"));
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			parser = new IsiLangParser(tokenStream);
			
			parser.prog();
			
			System.out.println("Compilation Successful");
			
			parser.generateCode();
		}
		catch(IsiSemanticException ex) {
			System.err.println("Semantic error - "+ex.getMessage());
		}
		catch(Exception ex){
			System.err.println("ERROR " + ex.getMessage());
		}
	}

}
