package virtualMachine.commands;

import java.util.List;

import virtualMachine.Variable;
import virtualMachine.VirtualMachine;

public class DeclareVariable extends AbstractCommand {

	@Override
	void Execute(VirtualMachine vm, List<Variable> parameters) {
		// TODO Auto-generated method stub
		if (vm.variables.containsKey(parameters.get(0).getWaarde().toString())) {
			try {
				throw new Exception ("BEEDOOBEEDOO - Double declaration of variable " + (parameters.get(0).getWaarde().toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			vm.variables.put((parameters.get(0).getWaarde().toString()), null);
		}
	}

	@Override
	AbstractCommand copy() {
		// TODO Auto-generated method stub
		return new DeclareVariable();
	}

}
