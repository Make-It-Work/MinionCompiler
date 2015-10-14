package factories;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ServiceLoader;

import compiler.CompiledStatement;

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
//	
//	public static final CompiledStatement create(final String name) {
//		if (statements.containsKey(name)) {
//			return statements.get(name).copy();
//		}
//		
//		final String message = String.format("Command '%s' was not found, is the services file up to date?", name);
//		throw new IllegalArgumentException(message);
//	}
	
	public static final void createStatement(Token currentToken) {
		//Map<String, CompiledStatement> check = statements;
		for(Entry<String, CompiledStatement> entry : statements.entrySet()) {
		    String key = entry.getKey();
		    CompiledStatement cs = entry.getValue();
		    
		    if(cs.isMatch(currentToken)) {
		    	System.out.println("FoundMatch");
		    	return;
		    	//Doe iets
		    }

		    // do what you have to do here
		    // In your case, an other loop.
		}
	}
	
}
