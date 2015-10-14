package compiler;

import tokenizer.Token;

public class CompileFunction extends CompiledStatement {

	@Override
	public
	boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompileFunction();
	}

}
