package virtualMachine.commands;

import tokenizer.Identifier;
import virtualMachine.Variable;
import virtualMachine.VirtualMachine;

import java.util.List;

/**
 * Created by Suzanne on 5-11-2015.
 */
public class LessThan extends AbstractCommand {
    @Override
    public void Execute(VirtualMachine vm, List<Variable> parameters) {
        // TODO Auto-generated method stub
        Object returnWaarde;
        Variable left = vm.variables.get(parameters.get(0).getWaarde());
        Variable right = vm.variables.get(parameters.get(1).getWaarde());
        if(isIntGeneric(left) && isIntGeneric(right)) {
            int intLeft = toInt(left);
            int intRight = toInt(right);
            returnWaarde = intLeft < intRight;
            vm.returnValue = new Variable(Identifier.BOOL, returnWaarde);
        }
        else {
            try {
                throw new Exception("BEEDOOBEEDOO - Can only Compare numbers");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    AbstractCommand copy() {
        // TODO Auto-generated method stub
        return new LessThanEquals();
    }
}
