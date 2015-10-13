package compiler;

import java.util.ArrayList;

import nodes.Node;
import tokenizer.Token;

public class Compiler {
	
	protected ArrayList<Node> outPut;
	
	public void compile(
			ArrayList<Token> tokens,
			Token begin,
			Token end
			)
	{
		
	}
	
	public void getLastToken()
	{
		
	}
	
	public ArrayList<Node> getOutput()
	{
		return outPut;
	}
}
