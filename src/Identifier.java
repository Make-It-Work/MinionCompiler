
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
	EQUALS("==", false, false, false);
	
	private String value;
    private Identifier(String value, boolean isOpener, boolean isClosing, boolean needsClosing )
    {
       this.value = value;
    }

    public String toString()
    {
       return this.value; //will return , or ' instead of COMMA or APOSTROPHE
    }
}
