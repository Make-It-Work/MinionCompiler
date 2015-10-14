package compiler;

import java.util.LinkedList;

import nodes.ConditionalJump;
import nodes.DoNothing;
import nodes.Jump;
import nodes.Node;
import tokenizer.Token;

public class CompileWhile extends CompiledStatement{

	@Override
	public
	boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompileWhile();
	}


	@Override
	public LinkedList<Node> compile(Compiler compiler) {
		LinkedList<Node> compiledNodes = new LinkedList<Node>();
		int level = 0;

		LinkedList<Node> compiledCondition = new LinkedList<Node>();
		LinkedList<Node> compiledBody = new LinkedList<Node>();
		
		//first we start with a do nothing node
		DoNothing nothingStart = new DoNothing();
		compiledNodes.add(nothingStart);
		//jump for the condition
		ConditionalJump ifJump = new ConditionalJump();
		//destination for the true
		DoNothing nothingTrue = new DoNothing();
		compiledNodes.add(nothingTrue);
		//Jump back to the condition
		Jump backJump = new Jump();
		backJump.setNext(ifJump);
		compiledNodes.add(backJump);
		//destination for false/done
		DoNothing nothingDone = new DoNothing();
		compiledNodes.add(nothingDone);
		
		
		while(compiler.currentToken.hasNext())
		{
			compiler.currentToken.printToken();
			if(compiler.currentToken.getIdentifier().needsClosing())
				level++;
			else if(compiler.currentToken.getIdentifier().isClosing())
				level--;
			if(level > 0){//condition or body
				if(compiledCondition == null){
					//generate the condition from the factory
				}else{
					//generate the body from the factory
				}
			}
			
			
			compiler.currentToken = compiler.currentToken.getNext();
		}

		ifJump.setTrueNode(nothingTrue);
		ifJump.setFalseNode(nothingDone);
		compiledNodes.add(ifJump);
		
		return compiledNodes;
	}

}