package nodes;

import tokenizer.Identifier;
import virtualMachine.VirtualMachine;

public class NodeVisitor { 

	private Node nextNode;
	private VirtualMachine vm;
	
	public NodeVisitor(VirtualMachine vm)
	{
		this.vm = vm;
	}
    
	public void Visit(DoNothing node) {
		nextNode = node.getNext();
   }
	
    public void Visit(Jump node) {
    	nextNode = node.getJumpNode();
    }
    
    public void Visit(ConditionalJump node){
    	if(vm.returnValue.getType() == Identifier.BOOL) {
			if (vm.returnValue.getWaarde().equals(true)) {
				nextNode = node.getTrueNode();
			} else {
				nextNode = node.getFalseNode();
			}
		}

    }
    public void Visit(DirectFunctionCall node) {
    	nextNode = node.getNext();
    }
	public void Visit(AbstractFunctionCall node) {
		nextNode = node.getNext();
	}
    public void Visit(FunctionCall node) {
		nextNode = node.getNext();
    }

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}
