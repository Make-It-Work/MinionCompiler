package nodes;

import java.util.List;

import tokenizer.Token;

public abstract class Node {
	private Node next;
	protected List<Token> tokens;
	
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
}
