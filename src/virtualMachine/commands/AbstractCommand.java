package virtualMachine.commands;

import java.util.List;

import virtualMachine.*;

public abstract class AbstractCommand {
	public abstract void Execute(VirtualMachine vm, List<Variable> parameters);
	abstract AbstractCommand copy();
}
