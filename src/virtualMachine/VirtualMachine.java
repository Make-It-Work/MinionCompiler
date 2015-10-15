package virtualMachine;

import java.util.LinkedList;
import java.util.HashMap;

import nodes.AbstractFunctionCall;
import nodes.Node;
import nodes.NodeVisitor;

public class VirtualMachine {
	public Variable returnValue;
	public HashMap<String, Variable> variables;
	
	public void Run(LinkedList<Node> list)
    {
        Node currentNode = list.getFirst();
        NodeVisitor visitor = new NodeVisitor();
        while (currentNode != null)
        {
        	System.out.println(currentNode.getIdentifier());
//        	AbstractFunctionCall action = (AbstractFunctionCall) currentNode;
//        	if (action != null)
//            {
//    			//String name = (String)action.getParameters().get(0).getWaarde();
//     			//_commands[name].Execute(this, action.getParameters());
//            }
//        	
        	currentNode.accept(visitor);
        	currentNode = currentNode.getNext();
            //currentNode = visitor.getNextNode();
        }
    }
}
