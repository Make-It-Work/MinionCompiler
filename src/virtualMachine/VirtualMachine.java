package virtualMachine;

import java.util.ArrayList;
import java.util.HashMap;

import nodes.AbstractFunctionCall;
import nodes.Node;
import nodes.NodeVisitor;

public class VirtualMachine {
	public Variable returnValue;
	public HashMap<String, Variable> variables;
	
	public void Run(ArrayList<Node> list)
    {
        Node currentNode = list.get(0);
        NodeVisitor visitor = new NodeVisitor();
        while (currentNode != null)
        {
        	AbstractFunctionCall action = (AbstractFunctionCall) currentNode;
        	if (action != null)
            {
    			//String name = (String)action.getParameters().get(0).getWaarde();
     			//_commands[name].Execute(this, action.getParameters());
            }
        	
        	currentNode.accept(visitor);
            currentNode = visitor.getNextNode();
        }
    }
}
