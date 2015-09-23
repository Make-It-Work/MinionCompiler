
public class Token {
	private int lineNumber;
	private int linePosition;
	private String content;
	private Identifier identifier;
	private int level;
	private int partner;
	
	public Token(int lineNumber) {
		this.lineNumber = lineNumber;
	}
}
