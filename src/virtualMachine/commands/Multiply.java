package virtualMachine.commands;

import tokenizer.Identifier;
import virtualMachine.Variable;
import virtualMachine.VirtualMachine;

import java.util.List;

public class Multiply extends AbstractCommand{
    @Override
    public void Execute(VirtualMachine vm, List<Variable> parameters) {
        // TODO Auto-generated method stub
        Object returnWaarde;
        Variable left = vm.variables.get(parameters.get(0).getWaarde());
        Variable right = vm.variables.get(parameters.get(1).getWaarde());
        if(isIntGeneric(left) && isIntGeneric(right)) {
            int intLeft = toInt(left);
            int intRight = toInt(right);
            returnWaarde = intLeft * intRight;
            vm.returnValue = new Variable(Identifier.NUMBER, returnWaarde);
        }
        else {
            try {
                throw new Exception("BEEDOOBEEDOO - Can only Multiply numbers");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isInt(Variable v)
    {
        try{
            Integer.parseInt((String)v.getWaarde());
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }

    @Override
    AbstractCommand copy() {
        // TODO Auto-generated method stub
        return new Multiply();
    }
}
