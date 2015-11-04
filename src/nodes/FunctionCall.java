package nodes;


public class FunctionCall extends AbstractFunctionCall {

	@Override
	public void accept(NodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.Visit(this);
	}

	@Override
	public boolean isMatch(String nodeType) {
		// TODO Auto-generated method stub
		return nodeType.equals("FunctionCall");
	}

	@Override
	public Node copy() {
		// TODO Auto-generated method stub
		return new FunctionCall();
	}

}
