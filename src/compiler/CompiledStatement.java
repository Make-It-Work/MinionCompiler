package compiler;
import java.util.*;
import tokenizer.Token;

public abstract class CompiledStatement {

	public abstract boolean isMatch(Token currentToken);
	abstract CompiledStatement copy();
}
