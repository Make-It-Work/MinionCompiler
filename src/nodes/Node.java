package nodes;

import java.util.List;

import tokenizer.Token;
import virtualMachine.Variable;

public abstract class Node {
	private Node next;
	protected List<Token> tokens;
	protected String functionIdentifier;
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public boolean hasNext()
	{
		return (next != null);
	}
	
	public abstract void accept(NodeVisitor visitor);
	public abstract boolean isMatch(String nodeType);
	public abstract Node copy();
	public void setParameters(List<Variable> params) {}

	public void setIdentifier(String functionIdentifier) {
		// TODO Auto-generated method stub
		this.functionIdentifier = functionIdentifier;
	}
	
	public String getIdentifier() {
		return this.functionIdentifier;
	}

}
