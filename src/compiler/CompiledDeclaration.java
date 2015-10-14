package compiler;

import java.util.LinkedList;

import tokenizer.Identifier;
import tokenizer.Token;

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

}
