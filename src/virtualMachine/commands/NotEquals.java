package virtualMachine.commands;

import tokenizer.Identifier;
import virtualMachine.Variable;
import virtualMachine.VirtualMachine;

import java.util.List;

/**
 * Created by Suzanne on 5-11-2015.
 */
public class NotEquals extends AbstractCommand {
    @Override
    public void Execute(VirtualMachine vm, List<Variable> parameters) {
        // TODO Auto-generated method stub
        Variable left = vm.variables.get(parameters.get(0).getWaarde());
        Variable right = vm.variables.get(parameters.get(1).getWaarde());
        boolean result = !left.getWaarde().equals(right.getWaarde());
        vm.returnValue = new Variable(Identifier.BOOL, result);
    }

    @Override
    AbstractCommand copy() {
        // TODO Auto-generated method stub
        return new NotEquals();
    }
}
