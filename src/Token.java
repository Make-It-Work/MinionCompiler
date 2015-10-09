
public class Token {
	private int lineNumber;
	private int linePosition;
	private String content;
	private Identifier identifier;
	private int level;
	private Token partner;
	
	public Token(int lineNumber, int linePosition, String content, Identifier identifier, int level) {
		this.lineNumber = lineNumber;
		this.linePosition = linePosition;
		this.content = content;
		this.identifier = identifier;
		this.level = level;
	}
	
	public void setPartner(Token partner) {
		this.partner = partner;
	}
	
	public void printToken() {
		System.out.print("LineNumber: " + lineNumber + " linePosition: " + linePosition + System.lineSeparator());
		System.out.println("Content: " + content);
		System.out.println("Level: " + level);
		if(partner != null) {
			System.out.println("Partner: " + partner.content);
		}
		System.out.println("__________");
	}
	
	public Identifier getIdentifier() {
		return this.identifier;
	}
	
	public int getLineNumber() {
		return this.lineNumber;
	}
}
