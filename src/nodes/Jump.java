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
		
	}

}
