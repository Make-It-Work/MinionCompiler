package virtualMachine.commands;

import java.util.List;

import tokenizer.Identifier;
import virtualMachine.Variable;
import virtualMachine.VirtualMachine;

public class PrintCommand extends AbstractCommand {

	@Override
	void Execute(VirtualMachine vm, List<Variable> parameters) {

		Variable left = vm.variables.get(parameters.get(0).getWaarde());
		Variable right = vm.variables.get(parameters.get(1).getWaarde());
		String printval;
		if(left.getType().equals(Identifier.NUMBER) && right.getType().equals(Identifier.NUMBER)) {
			printval = Integer.toString(((int)left.getWaarde()) + ((int)right.getWaarde()));
		} else {
			printval = left.getWaarde().toString() + right.getWaarde().toString();
		}
		System.out.println(printval);
	}

	@Override
	AbstractCommand copy() {
		return new PrintCommand();
	}

}