package compiler;

import java.util.ArrayList;
import java.util.LinkedList;

import factories.NodeFactory;
import nodes.Node;
import tokenizer.Identifier;
import tokenizer.Token;
import virtualMachine.Variable;

public class CompileIdentities extends CompiledStatement{

	@Override
	public LinkedList<Node> compile(Compiler compiler) {
		// TODO Auto-generated method stub
		Variable varName = new Variable(compiler.currentToken.getIdentifier(), compiler.currentToken.getValue());
		ArrayList<Variable> parameters = new ArrayList<Variable>();
		parameters.add(varName);
		output.add(NodeFactory.createNode("DirectFunctionCall", "VariableToReturn", parameters));
		return output;
	}

	@Override
	public boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		return currentToken.getIdentifier().equals(Identifier.IDENTITY);
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompileIdentities();
	}

}
