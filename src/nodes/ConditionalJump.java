package nodes;


public class ConditionalJump extends Node {

	private boolean conditionResult;
	private Node trueNode;
	private Node falseNode;
	
	
	public Node getTrueNode() {
		return trueNode;
	}


	public void setTrueNode(Node trueNode) {
		this.trueNode = trueNode;
	}


	public Node getFalseNode() {
		return falseNode;
	}


	public void setFalseNode(Node falseNode) {
		this.falseNode = falseNode;
	}


	@Override
	public void accept(NodeVisitor visitor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isMatch(String nodeType) {
		// TODO Auto-generated method stub
		return nodeType.equals("ConditionalJump");
	}


	@Override
	public Node copy() {
		// TODO Auto-generated method stub
		return new ConditionalJump();
	}

}
