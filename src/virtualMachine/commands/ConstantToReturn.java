package virtualMachine.commands;

import java.util.List;

import virtualMachine.Variable;
import virtualMachine.VirtualMachine;

public class ConstantToReturn extends AbstractCommand {

	@Override
	public void Execute(VirtualMachine vm, List<Variable> parameters) {
		// TODO Auto-generated method stub
		vm.returnValue = parameters.get(0);
	}

	@Override
	AbstractCommand copy() {
		// TODO Auto-generated method stub
		return new ConstantToReturn();
	}

}
