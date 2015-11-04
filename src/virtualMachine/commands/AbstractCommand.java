package virtualMachine.commands;

import java.util.List;

import virtualMachine.*;

public abstract class AbstractCommand {
	public abstract void Execute(VirtualMachine vm, List<Variable> parameters);
	abstract AbstractCommand copy();
	

	
	protected int toInt(Variable v)
	{
		int intRet;
		if(isInt(v))
			intRet = (int)v.getWaarde();
		else if(isIntString(v))
			intRet = Integer.parseInt((String)v.getWaarde());
		else
			return -1;
		return intRet;
	}
	
	protected boolean isIntGeneric(Variable v)
	{
		return (isInt(v) || isIntString(v));
	}
	
	private boolean isInt(Variable v)
	{
		try{
			int i = (int) v.getWaarde();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	private boolean isIntString(Variable v)
	{
		try{
			Integer.parseInt((String)v.getWaarde());
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
}
