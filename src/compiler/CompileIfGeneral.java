package compiler;

import java.util.LinkedList;

import tokenizer.Token;

public class CompileIfGeneral extends CompiledStatement {

	@Override
	boolean isMatch(LinkedList<Token> currentToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompileIfGeneral();
	}

}
