package nodes;

import java.util.List;
import virtualMachine.Variable;


public class DirectFunctionCall extends AbstractFunctionCall {

	@Override
	public void accept(NodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.Visit(this);
	}

	@Override
	public boolean isMatch(String nodeType) {
		// TODO Auto-generated method stub
		return nodeType.equals("DirectFunctionCall");
	}

	@Override
	public Node copy() {
		// TODO Auto-generated method stub
		return new DirectFunctionCall();
	}


}
