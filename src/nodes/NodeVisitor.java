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
    	
    }
    public void Visit(DirectFunctionCall node) {
    	
    }	
    public void Visit(FunctionCall node) {
		
    }

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}
