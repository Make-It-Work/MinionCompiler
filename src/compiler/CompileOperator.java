package compiler;

import java.util.ArrayList;

import nodes.Node;
import tokenizer.Token;

public class CompileOperator extends CompiledStatement{

	@Override
	public
	boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompileOperator();
	}

	@Override
	public ArrayList<Node> compile(Token currentToken) {
		// TODO Auto-generated method stub
		return null;
	}

}
