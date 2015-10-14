package compiler;

import java.util.LinkedList;

import nodes.Node;
import tokenizer.Identifier;
import tokenizer.Token;

public class CompilePlus extends CompiledStatement{

	@Override
	public
	boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		return currentToken.getIdentifier().equals(Identifier.PLUS);
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompilePlus();
	}

	@Override
	public LinkedList<Node> compile(Compiler compiler) {
		// TODO Auto-generated method stub
		return null;
	}

}
