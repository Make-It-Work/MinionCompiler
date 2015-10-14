package compiler;

import java.util.ArrayList;
import java.util.LinkedList;

import factories.NodeFactory;
import nodes.Node;
import tokenizer.Identifier;
import tokenizer.Token;
import virtualMachine.Variable;

public class CompiledAssignment extends CompiledStatement {

	@Override
	public LinkedList<Node> compile(Compiler compiler) {
		// TODO Auto-generated method stub
		Token varName = compiler.currentToken.getPrevious();
		
		//Compile alles tot aan je EOL
		while (!compiler.currentToken.getNext().getIdentifier().equals(Identifier.SEMICOLON)) {
			CompiledStatement cs = CompiledStatementFactory.createStatement(compiler.currentToken.getNext());
			output.addAll(cs.compile(compiler));
			
			ArrayList<Variable> parameters = new ArrayList<Variable>();
			parameters.add(new Variable(varName.getIdentifier(), varName.getValue()));
			
			output.add(NodeFactory.createNode("DirectFunctionCall", "ReturnToValue", parameters));
		}
		return output;
	}

	@Override
	public boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		return currentToken.getIdentifier().equals(Identifier.BECOMES);
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompiledAssignment();
	}

}
