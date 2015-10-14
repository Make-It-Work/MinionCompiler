package virtualMachine.commands;

import java.util.List;

import virtualMachine.*;

public abstract class AbstractCommand {
	abstract void Execute(VirtualMachine vm, List<Variable> parameters);
}
