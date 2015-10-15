package compiler;

import java.util.ArrayList;
import java.util.LinkedList;

import factories.NodeFactory;
import nodes.Node;
import tokenizer.Identifier;
import tokenizer.Token;
import virtualMachine.Variable;

public class CompileTom extends CompiledStatement {

	@Override
	public
	boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		return currentToken.getIdentifier().equals(Identifier.TOM);
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompileTom();
	}

	@Override
	public LinkedList<Node> compile(Compiler compiler) {
		// TODO Auto-generated method stub		
		
		if (compiler.currentToken.getNext().getIdentifier().equals(Identifier.ELLIPSEOPEN)) {
			compiler.currentToken = compiler.currentToken.getNext().getNext();
			//ArrayList<Variable> parameters = new ArrayList<Variable>();
			while (!compiler.currentToken.getNext().getIdentifier().equals(Identifier.ELLIPSECLOSE)) {
				compiler.currentToken = compiler.currentToken.getNext();
				CompiledStatement cs = CompiledStatementFactory.createStatement(compiler.currentToken);
				addAllToOutput(cs.compile(compiler));
			}
			
			ArrayList<Variable> paramsTom = new ArrayList<Variable>();
			
			for (int i = 0; i < output.size(); i++) {
				String varName = "$000" + i;
				ArrayList<Variable> parametersLefthand = new ArrayList<Variable>();
				Variable v = new Variable(Identifier.NUMBER, varName);
				parametersLefthand.add(v);
				paramsTom.add(v);
				output.add(NodeFactory.createNode("DirectFunctionCall", "ReturnToVariable", parametersLefthand));
			}
			
			output.add(NodeFactory.createNode("DirectFunctionCall", "PrintCommand", paramsTom));
			compiler.currentToken = compiler.currentToken.getNext().getNext();
		} else {
			try {
				throw new Exception("BEEDOOBEEDOO - Expected ( after identifier 'tom'");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return output;
	}

}
