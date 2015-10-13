package compiler;

import java.util.ArrayList;
import java.util.LinkedList;

import nodes.Node;
import tokenizer.Token;

public class Compiler {
	
	protected LinkedList<Token> tokens;
	protected ArrayList<Node> outPut;
	
	public Compiler(LinkedList<Token> tokens) {
		this.tokens = tokens;
		compile();
	}
	
	public void compile(
//			ArrayList<Token> tokens,
//			Token begin,
//			Token end
			)
	{
		tokens.getFirst().printToken();
	}
	
	public void getLastToken()
	{
		
	}
	
	public ArrayList<Node> getOutput()
	{
		return outPut;
	}
}
