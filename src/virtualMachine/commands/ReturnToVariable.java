package virtualMachine.commands;

import java.util.List;

import virtualMachine.Variable;
import virtualMachine.VirtualMachine;

public class ReturnToVariable extends AbstractCommand {

	@Override
	public void Execute(VirtualMachine vm, List<Variable> parameters) {
		// TODO Auto-generated method stub
			vm.variables.put(parameters.get(0).getWaarde().toString(), vm.returnValue);
		
	}

	@Override
	AbstractCommand copy() {
		// TODO Auto-generated method stub
		return new ReturnToVariable();
	}

}
