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
			return Integer.parseInt((String)waarde);
		}
		//String is suited for all types
		return waarde;
	}

	public void setWaarde(Object waarde) {
		this.waarde = waarde;
	}

	public void setType(Identifier type) {
		if (type == Identifier.BOOL) {
			this.type = type;
		} else {
			try {
				Integer.parseInt((String) this.waarde);
				type = Identifier.NUMBER;
			} catch (NumberFormatException e) {
				type = Identifier.STRING;
			}
			this.type = type;
		}
	}

	public Identifier getType() {
		return this.type;
	}
	
}
