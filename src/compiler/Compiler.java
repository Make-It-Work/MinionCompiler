package compiler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
		System.out.println("Running Compiler");
        System.out.println("_________________");
		outPut.add(NodeFactory.createNode("DoNothing"));
		currentToken = tokens.get(0);
		
		while(currentToken != null) {
			
			CompiledStatement cs = CompiledStatementFactory.createStatement(currentToken);
			if (cs != null) {
				LinkedList<Node> csCompiled = cs.compile(this);
                this.addAllToOutput(csCompiled);
			}
			if(currentToken != null && currentToken.hasNext())
				currentToken = currentToken.getNext();
			else
				break;
		}
//
//		int counter = 0;
//        while (counter<outPut.size()) {
//            outPut.get(counter).printString();
//            counter++;
//        }

		VirtualMachine vm = new VirtualMachine();
		vm.Run(outPut);
		
	}
	
	private void addAllToOutput(List<Node> newNodes) {
		for (Node newNode : newNodes) {
			Node lastNode = outPut.getLast();
			lastNode.setNext(newNode);
			newNode.setPrevious(lastNode);
			outPut.removeLast();
			outPut.addLast(lastNode);
			outPut.addLast(newNode);
		}
	}
	
	public void getLastToken()
	{
		
	}
	
	public LinkedList<Node> getOutput()
	{
		return outPut;
	}
}
