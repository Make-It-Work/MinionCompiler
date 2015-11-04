package nodes;


public class DoNothing extends Node {

	@Override
	public void accept(NodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.Visit(this);
	}

	@Override
	public boolean isMatch(String nodeType) {
		// TODO Auto-generated method stub
		return nodeType.equals("DoNothing");
	}

	@Override
	public Node copy() {
		// TODO Auto-generated method stub
		return new DoNothing();
	}

}
