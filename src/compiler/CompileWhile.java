package compiler;

import java.util.LinkedList;
import java.util.List;

import factories.NodeFactory;
import nodes.ConditionalJump;
import nodes.DoNothing;
import nodes.Jump;
import nodes.Node;
import tokenizer.Identifier;
import tokenizer.Token;

public class CompileWhile extends CompiledStatement{

	private LinkedList<Node> _compiledStatement;
	private LinkedList<Node> _condition;
	private LinkedList<Node> _body;
	
	public CompileWhile() {}
	
	@Override
	public
	boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		return currentToken.getIdentifier().equals(Identifier.TYELAS);
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompileWhile();
	}

	public LinkedList<Node> compile(Compiler compiler) {
		output = new LinkedList<Node>();
		int level = 0;

		_condition = new LinkedList<Node>();
		_body = new LinkedList<Node>();

		//first we start with a do nothing node (optioneel)
		DoNothing doNothingBeforeIf = (DoNothing) NodeFactory.createNode("DoNothing");
		DoNothing doNothingInsideIf = new DoNothing();
		Jump jumpAfterIf = new Jump();
		jumpAfterIf.setJumpNode(doNothingBeforeIf);
		DoNothing doNothingAfterIf = new DoNothing();
		output.add(doNothingBeforeIf);
		ConditionalJump ifJump = new ConditionalJump();
		ifJump.setTrueNode(doNothingInsideIf);
		ifJump.setFalseNode(doNothingAfterIf);
		boolean compilingCondition = true;
		while(compiler.currentToken != null && compiler.currentToken.hasNext())
		{
			if (compiler.currentToken.getIdentifier().equals(Identifier.ELLIPSECLOSE)) {
				compilingCondition = false;
			}
			else if (level > 0){//condition or body
				if(compilingCondition){
					CompiledStatement cs = CompiledStatementFactory.createStatement(compiler.currentToken);
                    _condition.addAll(cs.compile(compiler));
				} else {
					if (!compiler.currentToken.getIdentifier().equals(Identifier.BELLO)) {
						CompiledStatement cs = CompiledStatementFactory.createStatement(compiler.currentToken);
                        _body.addAll(cs.compile(compiler));
					}
				}
			}

			if(compiler.currentToken.getIdentifier().needsClosing())
				level++;
			else if(compiler.currentToken.getIdentifier().isClosing())
				level--;

			compiler.currentToken = compiler.currentToken.getNext();
		}

        output.addAll(_condition);
        output.add(ifJump);
        output.add(doNothingInsideIf);
        output.addAll(_body);
        output.add(jumpAfterIf);
		output.add(doNothingAfterIf);
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
