package virtualMachine.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import virtualMachine.commands.AbstractCommand;

public class CommandFactory {
	private static final Map<String, AbstractCommand> commands;
	private static final ServiceLoader<AbstractCommand> loader;
	
	static {
		commands = new HashMap<String, AbstractCommand>();
		loader = ServiceLoader.load(AbstractCommand.class);
		
		for (AbstractCommand comm : loader) {
			commands.put(comm.getClass().getSimpleName(), comm);
		}
	}
	
	public static final AbstractCommand create(final String name) {
		if (commands.containsKey(name)) {
			AbstractCommand comm = commands.get(name).copy();
			//System.out.println("created " + name);
			return comm;
		}
		
		final String message = String.format("Command '%s' was not found, is the services file up to date?", name);
		throw new IllegalArgumentException(message);
	}
}
