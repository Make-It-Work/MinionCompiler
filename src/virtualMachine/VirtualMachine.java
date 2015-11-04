package virtualMachine;

import java.util.HashMap;
import java.util.LinkedList;

import nodes.AbstractFunctionCall;
import nodes.Node;
import nodes.NodeVisitor;
import virtualMachine.commands.AbstractCommand;
import virtualMachine.commands.CommandFactory;

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
        	Node action = (Node) currentNode;
//        	if (action != null)
//            {
//    			String name = (String)action.getParameters().get(0).getWaarde();
//    			AbstractCommand command = CommandFactory.create(name);
//     			command.Execute(this, action.getParameters());
//            }
        	
        	currentNode.accept(visitor);
        	//currentNode = currentNode.
            currentNode = visitor.getNextNode();
        }
    }
}
