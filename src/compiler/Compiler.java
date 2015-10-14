package compiler;

import java.util.ArrayList;
import java.util.LinkedList;

import factories.NodeFactory;
import nodes.Node;
import tokenizer.Token;
import virtualMachine.VirtualMachine;

public class Compiler {
	
	protected ArrayList<Token> tokens;
	protected LinkedList<Node> outPut;
	public Token currentToken;
	
	public Compiler(ArrayList<Token> tokens) {
		this.tokens = tokens;
		this.outPut = new LinkedList<Node>();
		compile();
	}
	
	public void compile(
//			ArrayList<Token> tokens,
//			Token begin,
//			Token end
			)
	{
		outPut.add(NodeFactory.createNode("DoNothing"));
		currentToken = tokens.get(0);
		while(currentToken.hasNext()) {
			CompiledStatement cs = CompiledStatementFactory.createStatement(currentToken);
			if (cs != null) {
				LinkedList<Node> csCompiled = cs.compile(this);
				this.outPut.addAll(csCompiled);
			}
			currentToken = currentToken.getNext();
		}
		System.out.println("bah");
		VirtualMachine vm = new VirtualMachine();
		vm.Run(outPut);
		
	}
	
	public void getLastToken()
	{
		
	}
	
	public LinkedList<Node> getOutput()
	{
		return outPut;
	}
}
