package compiler;

import java.util.ArrayList;
import java.util.LinkedList;

import factories.NodeFactory;
import nodes.Node;
import tokenizer.Identifier;
import tokenizer.Token;
import virtualMachine.Variable;

public class CompileConstant extends CompiledStatement {

	@Override
	public LinkedList<Node> compile(Compiler compiler) {
		// TODO Auto-generated method stub
		String content = compiler.currentToken.getValue();
		ArrayList<Variable> parameters = new ArrayList<Variable>();
		parameters.add(new Variable(compiler.currentToken.getIdentifier(), content));
		
		output.add(NodeFactory.createNode("DirectFunctionCall", "ConstantToReturn", parameters));
		return output;
	}

	@Override
	public boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		return currentToken.getIdentifier().equals(Identifier.NUMBER) || currentToken.getIdentifier().equals(Identifier.STRING);
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return null;
	}

}
