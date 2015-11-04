package nodes;

import virtualMachine.Variable;
import java.util.*;

public abstract class AbstractFunctionCall extends Node {

	protected List<Variable> parameters;
	
	public List<Variable> getParameters() {
		return parameters;
	}

	public AbstractFunctionCall() {
		functionIdentifier = "";
		parameters = new ArrayList<Variable>();
	}
	
	public AbstractFunctionCall(String fi, List<Variable> vars) {
		functionIdentifier = fi;
		parameters = vars;
	}
	@Override
	public void accept(NodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.Visit(this);
	}

	@Override
	public abstract boolean isMatch(String nodeType);

}
