package virtualMachine.commands;

import java.util.List;

import virtualMachine.Variable;
import virtualMachine.VirtualMachine;
import tokenizer.Identifier;

public class Add extends AbstractCommand {

	@Override
	void Execute(VirtualMachine vm, List<Variable> parameters) {
		// TODO Auto-generated method stub
		Object returnWaarde;
		Variable left = vm.variables.get(parameters.get(0).getWaarde());
		Variable right = vm.variables.get(parameters.get(1).getWaarde());
		if(left.getType().equals(Identifier.NUMBER) && right.getType().equals(Identifier.NUMBER)) {
			returnWaarde = ((int)left.getWaarde()) + ((int)right.getWaarde());
			vm.returnValue = new Variable(Identifier.NUMBER, returnWaarde);
		} else {
			returnWaarde = left.getWaarde().toString() + right.getWaarde().toString();
			vm.returnValue = new Variable(Identifier.STRING, returnWaarde);
		}
	}

	@Override
	AbstractCommand copy() {
		// TODO Auto-generated method stub
		return new Add();
	}

}
