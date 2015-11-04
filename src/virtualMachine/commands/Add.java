package virtualMachine.commands;

import java.util.List;

import virtualMachine.Variable;
import virtualMachine.VirtualMachine;
import tokenizer.Identifier;

public class Add extends AbstractCommand {

	@Override
	public void Execute(VirtualMachine vm, List<Variable> parameters) {
		// TODO Auto-generated method stub
		Object returnWaarde;
		Variable left = vm.variables.get(parameters.get(0).getWaarde());
		Variable right = vm.variables.get(parameters.get(1).getWaarde());
		if(isIntGeneric(left) && isIntGeneric(right)) {
			int intLeft = toInt(left);
			int intRight = toInt(right);
			returnWaarde = intLeft + intRight;
			vm.returnValue = new Variable(Identifier.STRING, returnWaarde);
		} else {
			returnWaarde = left.getWaarde().toString() + right.getWaarde().toString();
			vm.returnValue = new Variable(Identifier.STRING, returnWaarde);
		}
	}
	
	private boolean isInt(Variable v)
	{
		try{
			Integer.parseInt((String)v.getWaarde());
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	AbstractCommand copy() {
		// TODO Auto-generated method stub
		return new Add();
	}

}
