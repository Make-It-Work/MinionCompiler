package compiler;
import java.util.*;

import nodes.Node;
import tokenizer.Token;

public abstract class CompiledStatement {
	public abstract ArrayList<Node> compile(Token currentToken);
	public abstract boolean isMatch(Token currentToken);
	abstract CompiledStatement copy();
}
