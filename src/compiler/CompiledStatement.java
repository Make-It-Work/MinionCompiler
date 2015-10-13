package compiler;
import java.util.*;
import tokenizer.Token;

abstract class CompiledStatement {

	abstract boolean isMatch(LinkedList<Token> currentToken);
	abstract CompiledStatement copy();
}
