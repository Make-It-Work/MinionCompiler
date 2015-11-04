package nodes;


public class Jump extends Node {

	private Node jumpNode;
	
	
	
	public Node getJumpNode() {
		return jumpNode;
	}

	public void setJumpNode(Node jumpNode) {
		this.jumpNode = jumpNode;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.Visit(this);
	}

	@Override
	public boolean isMatch(String nodeType) {
		// TODO Auto-generated method stub
		return nodeType.equals("Jump");
	}

	@Override
	public Node copy() {
		// TODO Auto-generated method stub
		return new Jump();
	}

}
