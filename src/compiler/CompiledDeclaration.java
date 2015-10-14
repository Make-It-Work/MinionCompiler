package compiler;

import java.util.ArrayList;
import java.util.LinkedList;

import factories.NodeFactory;
import nodes.Node;
import tokenizer.Identifier;
import tokenizer.Token;
import virtualMachine.Variable;

public class CompiledDeclaration extends CompiledStatement{

	@Override
	public
	boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		if (currentToken.getIdentifier().equals(Identifier.POKA)) {
			return true;
		}
		return false;
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompiledDeclaration();
	}

	@Override
	public LinkedList<Node> compile(Compiler compiler) {
		// TODO Auto-generated method stub		
		compiler.currentToken = compiler.currentToken.getNext();
		String variableName = compiler.currentToken.getValue();
		ArrayList<Variable> parameters = new ArrayList<Variable>();
		parameters.add(new Variable(compiler.currentToken.getIdentifier(), variableName));
		
		output.add(NodeFactory.createNode("DirectFunctionCall", "DeclareVariable", parameters));
		
		return output;
	}

}
