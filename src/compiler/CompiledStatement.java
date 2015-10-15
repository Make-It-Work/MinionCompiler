package compiler;
import java.util.*;

import nodes.Node;
import tokenizer.Token;

public abstract class CompiledStatement {
	protected LinkedList<Node> output = new LinkedList<Node>();
	public abstract LinkedList<Node> compile(Compiler compiler);
	public abstract boolean isMatch(Token currentToken);
	abstract CompiledStatement copy();
	
	protected void addAllToOutput(List<Node> newNodes) {
		for (Node newNode : newNodes) {
			if (!output.isEmpty()) {
				Node lastNode = output.getLast();
				lastNode.setNext(newNode);
				newNode.setPrevious(lastNode);
				output.removeLast();
				output.addLast(lastNode);
			}
			output.addLast(newNode);
		}
	}
}
