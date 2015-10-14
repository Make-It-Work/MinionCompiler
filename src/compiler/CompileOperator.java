package compiler;

import java.util.ArrayList;
import java.util.LinkedList;

import factories.NodeFactory;
import nodes.Node;
import tokenizer.Identifier;
import tokenizer.Token;
import virtualMachine.Variable;

public class CompileOperator extends CompiledStatement{

	@Override
	public
	boolean isMatch(Token currentToken) {
		// TODO Auto-generated method stub
		return	currentToken.getIdentifier().equals(Identifier.DIVIDE) ||
				currentToken.getIdentifier().equals(Identifier.EQUALS) ||
				currentToken.getIdentifier().equals(Identifier.GREATERTHAN) ||
				currentToken.getIdentifier().equals(Identifier.LESSTHAN) ||
				currentToken.getIdentifier().equals(Identifier.GREATERTHANEQUALS) ||
				currentToken.getIdentifier().equals(Identifier.LESSTHANEQUALS) ||
				currentToken.getIdentifier().equals(Identifier.MINUS) ||
				currentToken.getIdentifier().equals(Identifier.NOTEQUALS) ||
				currentToken.getIdentifier().equals(Identifier.PLUS) ||
				currentToken.getIdentifier().equals(Identifier.TIMES)
				;
	}

	@Override
	CompiledStatement copy() {
		// TODO Auto-generated method stub
		return new CompileOperator();
	}

	@Override
	public LinkedList<Node> compile(Compiler compiler) {
		// TODO Auto-generated method stub
		String leftHandVariableName = "$0001";
		String rightHandVariableName = "$0002";
		
		Identifier curIdentifier = compiler.currentToken.getIdentifier();
		
		//Pak de linkervalue van de returnValue (al gecompileerd)
		ArrayList<Variable> parametersLefthand = new ArrayList<Variable>();
		parametersLefthand.add(new Variable(Identifier.NUMBER,leftHandVariableName));
		output.add(NodeFactory.createNode("DirectFunctionCall", "ReturnToVariable", parametersLefthand));
		
		//Zorg dat de righthandvalue de volgende compilerslag wordt overgeslagen
		compiler.currentToken = compiler.currentToken.getNext();
		
		//Compileer de rechterkant (zet het al op de returnValue)
		CompiledStatement cs = CompiledStatementFactory.createStatement(compiler.currentToken);
		output.addAll(cs.compile(compiler));
		
		//Pak de linkervalue van de returnValue (al gecompileerd)
		ArrayList<Variable> parametersRighthand = new ArrayList<Variable>();
		parametersRighthand.add(new Variable(Identifier.NUMBER,rightHandVariableName));
		output.add(NodeFactory.createNode("DirectFunctionCall", "ReturnToVariable", parametersRighthand));
		
		//Tenslotte roep je Add aan met de linker en rechterkant
		ArrayList<Variable> parametersAdd = new ArrayList<Variable>();
		parametersAdd.add(new Variable(Identifier.NUMBER, leftHandVariableName));
		parametersAdd.add(new Variable(Identifier.NUMBER, rightHandVariableName));
		
		switch (curIdentifier) {
		case PLUS:
			output.add(NodeFactory.createNode("FunctionCall", "Add", parametersAdd));
			break;
		case MINUS:
			output.add(NodeFactory.createNode("FunctionCall", "Subtract", parametersAdd));
			break;
		case TIMES:
			output.add(NodeFactory.createNode("FunctionCall", "Multiply", parametersAdd));
			break;
		case DIVIDE:
			output.add(NodeFactory.createNode("FunctionCall", "Divide", parametersAdd));
			break;
		case EQUALS:
			output.add(NodeFactory.createNode("FunctionCall", "Equals", parametersAdd));
			break;
		case GREATERTHAN:
			output.add(NodeFactory.createNode("FunctionCall", "GreaterThan", parametersAdd));
			break;
		case GREATERTHANEQUALS:
			output.add(NodeFactory.createNode("FunctionCall", "GreaterThanEquals", parametersAdd));
			break;
		case LESSTHAN:
			output.add(NodeFactory.createNode("FunctionCall", "LessThan", parametersAdd));
			break;
		case LESSTHANEQUALS:
			output.add(NodeFactory.createNode("FunctionCall", "LessThanEquals", parametersAdd));
			break;
		case NOTEQUALS:
			output.add(NodeFactory.createNode("FunctionCall", "NotEquals", parametersAdd));
			break;
		default:
			try {
				throw new Exception("BEEDOOBEEDOO - Invalid Operator");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		
		
		return output;
	}

}
