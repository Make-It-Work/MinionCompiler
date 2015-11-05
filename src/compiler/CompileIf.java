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

		DoNothing doNothingBeforeIf = (DoNothing) NodeFactory.createNode("DoNothing");
		DoNothing doNothingInsideIf = new DoNothing();
		DoNothing doNothingAfterIf = new DoNothing();
		output.add(doNothingBeforeIf);
		ConditionalJump ifJump = new ConditionalJump();
		ifJump.setTrueNode(doNothingInsideIf);
		ifJump.setFalseNode(doNothingAfterIf);

		boolean compilingCondition = true;
		while(compiler.currentToken != null && compiler.currentToken.hasNext())
		{
			//compiler.currentToken.printToken();
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
