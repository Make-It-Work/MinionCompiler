package virtualMachine.commands;

import java.util.List;

import virtualMachine.Variable;
import virtualMachine.VirtualMachine;

public class ConstantToReturn extends AbstractCommand {

	@Override
	void Execute(VirtualMachine vm, List<Variable> parameters) {
		// TODO Auto-generated method stub
		vm.returnValue = parameters.get(0);
	}

}
