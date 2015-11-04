package compiler;

import java.util.LinkedList;
import java.util.List;

import factories.NodeFactory;
import nodes.ConditionalJump;
import nodes.DoNothing;
import nodes.Jump;
import nodes.Node;
import tokenizer.*;

public class CompileIf extends CompiledStatement{


	private LinkedList<Node> _condition;
	private LinkedList<Node> _body;
	
	@Override
	public
	boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		return currentToken.getValue().equals("underwear") ;
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompileIf();
	}

	@Override
	public LinkedList<Node> compile(Compiler compiler) {
		output = new LinkedList<Node>();
		int level = 0;

		_condition = new LinkedList<Node>();
		_body = new LinkedList<Node>();
		
		//first we start with a do nothing node
		DoNothing nothingStart = (DoNothing) NodeFactory.createNode("DoNothing");
		output.add(nothingStart);
		//jump for the condition
		ConditionalJump ifJump = new ConditionalJump();
		//destination for the true
		DoNothing nothingTrue = new DoNothing();
		output.add(nothingTrue);
		//destination for false/done
		DoNothing nothingDone = new DoNothing();
		output.add(nothingDone);
		
		boolean compilingCondition = true;
		while(compiler.currentToken != null && compiler.currentToken.hasNext())
		{
			compiler.currentToken.printToken();
			if (compiler.currentToken.getIdentifier().equals(Identifier.ELLIPSECLOSE)) {
				compilingCondition = false;
				//compiler.currentToken = compiler.currentToken.getNext();
			}
			else if (level > 0){//condition or body
				if(compilingCondition){
					compiler.currentToken = compiler.currentToken.getNext();
					CompiledStatement cs = CompiledStatementFactory.createStatement(compiler.currentToken);
					addAllToCondition(cs.compile(compiler));
				} else {
					if (!compiler.currentToken.getIdentifier().equals(Identifier.BELLO)) {
						CompiledStatement cs = CompiledStatementFactory.createStatement(compiler.currentToken);
						addAllToBody(cs.compile(compiler));
					}
				}
			}
			
			if(compiler.currentToken.getIdentifier().needsClosing())
				level++;
			else if(compiler.currentToken.getIdentifier().isClosing())
				level--;
			
			compiler.currentToken = compiler.currentToken.getNext();
		}

		ifJump.setTrueNode(nothingTrue);
		ifJump.setFalseNode(nothingDone);
		output.add(ifJump);
		
		return output;
	}

	private void addAllToCondition(List<Node> newNodes) {
		for (Node newNode : newNodes) {
			if (!_condition.isEmpty()) {
				Node lastNode = _condition.getLast();
				lastNode.setNext(newNode);
				newNode.setPrevious(lastNode);
				_condition.removeLast();
				_condition.addLast(lastNode);
			}
			_condition.addLast(newNode);
		}
	}
	
	private void addAllToBody(List<Node> newNodes) {
		for (Node newNode : newNodes) {
			if (!_body.isEmpty() ) {
				Node lastNode = _body.getLast();
				lastNode.setNext(newNode);
				newNode.setPrevious(lastNode);
				_body.removeLast();
				_body.addLast(lastNode);
			}
			_body.addLast(newNode);
		}
	}
}
