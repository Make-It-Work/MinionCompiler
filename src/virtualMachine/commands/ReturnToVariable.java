package virtualMachine.commands;

import java.util.List;

import virtualMachine.Variable;
import virtualMachine.VirtualMachine;

public class ReturnToVariable extends AbstractCommand {

	@Override
	void Execute(VirtualMachine vm, List<Variable> parameters) {
		// TODO Auto-generated method stub
			vm.variables.put(parameters.get(0).getWaarde().toString(), vm.returnValue);
		
	}

}
