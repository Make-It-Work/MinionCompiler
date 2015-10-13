package tokenizer;

public enum Identifier {
	ELLIPSEOPEN("(", true, false, true),
	ELLIPSECLOSE(")", false, true, false),
	QUOTE("'", true, true, true),
	BELLO("bello", true, false, true), //{
	POOPAYE("poopaye", false, true, false), //}
	PWEDA("pweda", true, false, false), //Comment
	TOM("tom", false, false, false), //Print
	TYELAS("tyelas", false, false, false), //Function
	PARATU("paratu", false, false, false), //Return
	POKA("poka", false, false, false), //var
	PARA("para", false, false, false), //for
	UNDERWEAR("underwear", true, false, false), //if
	SALAKA("salaka", false, true, false), //else
	STUPA("stupa", false, false, false), //break
	BECOMES("=", false, false, false),
	EQUALS("==", false, false, false),
	NUMBER("", false, false, false),
	IDENTITY("", false, false, false);
	
	private String value;
	private boolean isOpener;
	private boolean isClosing;
	private boolean needsClosing;
    private Identifier(String value, boolean isOpener, boolean isClosing, boolean needsClosing )
    {
       this.value = value;
       this.isOpener = isOpener;
       this.isClosing = isClosing;
       this.needsClosing = needsClosing;
    }

    public String toString()
    {
       return this.value; //will return , or ' instead of COMMA or APOSTROPHE
    }
    
    public boolean isOpener() {
    	return this.isOpener;
    }
    public boolean isClosing() {
    	return this.isClosing;
    }
    public boolean needsClosing() {
    	return this.needsClosing;
    }
    public boolean isMatching(Identifier open) {
    	if(open.name().equals("BELLO") && this.name().equals("POOPAYE")) {
    		return true;
    	} else if(open.name().equals("ELLIPSEOPEN") && this.name().equals("ELLIPSECLOSE")) {
    		return true;
    	} else if(this.name().equals("SALAKA") && open.name().equals("UNDERWEAR")) {
    		return true;
    	}
    	return false;
    }
}
