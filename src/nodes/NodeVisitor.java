package nodes;

public class NodeVisitor {
	private Node nextNode;
    
	public void Visit(DoNothing node) {
		nextNode = node.getNext();
   }
	
    public void Visit(Jump node) {
    	nextNode = node.getJumpNode();
    }
    
    public void Visit(ConditionalJump node){
    	nextNode = node.getNext();
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
