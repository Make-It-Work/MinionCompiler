package virtualMachine.commands;

import java.util.List;

import virtualMachine.Variable;
import virtualMachine.VirtualMachine;

public class VariableToReturn extends AbstractCommand {

	@Override
	void Execute(VirtualMachine vm, List<Variable> parameters) {
		// TODO Auto-generated method stub
		vm.returnValue = vm.variables.get(parameters.get(0).getWaarde().toString());
	}

	@Override
	AbstractCommand copy() {
		// TODO Auto-generated method stub
		return new VariableToReturn();
	}

}
