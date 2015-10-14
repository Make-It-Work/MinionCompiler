package nodes;

import virtualMachine.Variable;
import java.util.*;

public abstract class AbstractFunctionCall extends Node {

	protected List<Variable> parameters;
	
	public List<Variable> getParameters() {
		return parameters;
	}

	public void setParameters(List<Variable> parameters) {
		this.parameters = parameters;
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
		
	}

	@Override
	public abstract boolean isMatch(String nodeType);

}
