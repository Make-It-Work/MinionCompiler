package factories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ServiceLoader;
import java.util.Set;

import nodes.Node;
import virtualMachine.Variable;

public class NodeFactory {
	private static final Map<String, Node> nodes;
	private static final ServiceLoader<Node> loader;
	
	static {
		nodes = new HashMap<String, Node>();
		loader = ServiceLoader.load(Node.class);
		
		for (Node node : loader) {
			nodes.put(node.getClass().getSimpleName(), node);
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
	
	public static final Node createNode(String nodeType) {
		return createNode(nodeType, "", null);
	}
	
	public static final Node createNode(String nodeType, String functionIdentifier, List<Variable> parameters) {
		Set<Entry<String, Node>> entrySet = nodes.entrySet();
		for(Entry<String, Node> entry : entrySet) {
		    String key = entry.getKey();
		    Node node = entry.getValue();
		    
		    if(node.isMatch(nodeType)) {
		    	Node n = node.copy();
				if (parameters != null)
					System.out.println(parameters.size());
				n.setParameters(parameters);
		    	n.setIdentifier(functionIdentifier);
		    	return n;
		    	//Doe iets
		    }
		}
		try {
			throw new Exception("BEEDOOBEEDOO - NodeType doesnt exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
