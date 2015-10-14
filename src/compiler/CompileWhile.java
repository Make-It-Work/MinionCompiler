package compiler;

import tokenizer.Token;

public class CompileWhile extends CompiledStatement{

	@Override
	public
	boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompileWhile();
	}

}
