package compiler;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ServiceLoader;

import tokenizer.Token;

public class CompiledStatementFactory {
	private static final Map<String, CompiledStatement> statements;
	private static final ServiceLoader<CompiledStatement> loader;
	
	static {
		statements = new HashMap<String, CompiledStatement>();
		loader = ServiceLoader.load(CompiledStatement.class);
		
		for (CompiledStatement statement : loader) {
			statements.put(statement.getClass().getSimpleName(), statement);
		}
	}
	
	public static final CompiledStatement createStatement(Token currentToken) {
		for (Entry<String, CompiledStatement> cs : statements.entrySet()) {
			if (cs.getValue().isMatch(currentToken)) {
				System.out.println("Found Match");
				return cs.getValue().copy();
			}
		}
		return null;
	}
}
