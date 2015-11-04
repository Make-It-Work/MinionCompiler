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
	public HashMap<String, Variable> variables = new HashMap<String, Variable>();
	
	public void Run(LinkedList<Node> list)
    {
        Node currentNode = list.getFirst();
        NodeVisitor visitor = new NodeVisitor(this);
        while (currentNode != null)
        {
        	//System.out.println(currentNode.getIdentifier());
        	Node action = currentNode;
        	System.out.println(action.getIdentifier());
        	if (action != null && action.getParameters() != null)
            {
                if(action.getParameters().size() > 0) {
                    String name = (String) action.getIdentifier();
                    AbstractCommand command = CommandFactory.create(name);
                    command.Execute(this, action.getParameters());
                }
                
        		
            }
        	currentNode.accept(visitor);
        	if(visitor.getNextNode() == currentNode)
        	{
        		System.out.println();
        	}
            currentNode = visitor.getNextNode();
        }
    }
}
