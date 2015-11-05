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
        System.out.println("Running Virtual Machine");
        System.out.println("_________________");
        Node currentNode = list.getFirst();
        NodeVisitor visitor = new NodeVisitor(this);
        while (currentNode != null)
        {

            String name = (String) currentNode.getIdentifier();
            if(name != null && !name.equals("")) {
                AbstractCommand command = CommandFactory.create(name);
                command.Execute(this, currentNode.getParameters());
            }
            currentNode.accept(visitor);
            if(visitor.getNextNode() == currentNode)
            {
                System.out.println("Next is current");
            }
            currentNode = visitor.getNextNode();
        }
    }
}
