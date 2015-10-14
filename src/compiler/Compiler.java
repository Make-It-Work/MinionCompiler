package compiler;

import java.util.ArrayList;
import java.util.LinkedList;

import nodes.Node;
import tokenizer.Token;

public class Compiler {
	
	protected ArrayList<Token> tokens;
	protected ArrayList<Node> outPut;
	protected Token currentToken;
	
	public Compiler(ArrayList<Token> tokens) {
		this.tokens = tokens;
		compile();
	}
	
	public void compile(
//			ArrayList<Token> tokens,
//			Token begin,
//			Token end
			)
	{
		currentToken = tokens.get(0);
		while(currentToken.hasNext()) {
			CompiledStatementFactory.createStatement(currentToken);
			currentToken = currentToken.getNext();
		}
		
	}
	
	public void getLastToken()
	{
		
	}
	
	public ArrayList<Node> getOutput()
	{
		return outPut;
	}
}
