package compiler;
import java.util.*;

import nodes.Node;
import tokenizer.Token;

public abstract class CompiledStatement {
	protected LinkedList<Node> output = new LinkedList<Node>();
	public abstract LinkedList<Node> compile(Compiler compiler);
	public abstract boolean isMatch(Token currentToken);
	abstract CompiledStatement copy();
}
