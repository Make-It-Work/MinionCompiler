package virtualMachine;

import tokenizer.Identifier;

public class Variable {
	private Identifier type;
	private Object waarde;
	
	public Variable (Identifier type, Object waarde) {
		this.setType(type);
		this.setWaarde(waarde);
	}
	
	public Object getWaarde() {
		if (type == Identifier.NUMBER) {
			return (int) waarde;
		}
		//String is suited for all types
		return (String) waarde;
	}

	public void setWaarde(Object waarde) {
		this.waarde = waarde;
	}

	public void setType(Identifier type) {
		this.type = type;
	}

	public Identifier getType() {
		return this.type;
	}
	
}
