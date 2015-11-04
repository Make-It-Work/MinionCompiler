package nodes;

import java.util.HashMap;
import java.util.List;

import tokenizer.Token;
import virtualMachine.Variable;

public abstract class Node {
	private Node previous;
	private Node next;
	protected List<Token> tokens;
	protected List<Variable> parameters;
	protected String functionIdentifier;
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public Node getPrevious() {
		return this.previous;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	public boolean hasNext()
	{
		return (next != null);
	}
	
	public abstract void accept(NodeVisitor visitor);
	public abstract boolean isMatch(String nodeType);
	public abstract Node copy();
	public void setParameters(List<Variable> params) {
		this.parameters = params;
	}

    public List<Variable> getParameters() {
        return parameters;
    }

    public void setIdentifier(String functionIdentifier) {
		// TODO Auto-generated method stub
		this.functionIdentifier = functionIdentifier;
	}
	
	public String getIdentifier() {
		return this.functionIdentifier;
	}

	public void printString() {
		System.out.println(functionIdentifier);
		if (this.parameters != null) {
			for (Variable v : this.parameters) {
				System.out.println(v.getWaarde());
			}
		}
		System.out.println("___");
	}
}
