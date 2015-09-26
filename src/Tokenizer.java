import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Tokenizer {
	private static ArrayList<Token> tokenList = new ArrayList<Token>();
	private static Deque<Token> stack = new ArrayDeque<Token>();
	private static int level = 0;
	private static int lineCounter = 0;
	private static int charCounter = 0;
	
	public static void main(String [] args) {
		
        // The name of the file to open.
        String fileName = "src/minion.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	charCounter = 0;
            	lineCounter++;
                String[] tokens = line.split(" ");
                for (String item : tokens) {
                	charCounter++;
                    Identifier i = isInIdentifiers(item);
                    charCounter += item.length();
                }
            }

            // Always close files.
            bufferedReader.close();
            
            for (Token t : tokenList) {
            	t.printToken();
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
             ex.printStackTrace();
        }
    }
	
	public static Identifier isInIdentifiers(String isIn) {
    	for(Identifier i : Identifier.values()) {
    		if (i.toString().equals(isIn)) {
    			Token t = new Token(lineCounter, charCounter, isIn, i, level);
            	tokenList.add(t);
    			if (i.isOpener()) {
    				if(i.name().equals("QUOTE") && stack.peek() != null && stack.peek().getIdentifier().name().equals("QUOTE")) {
            			stack.pop();
            			level--;
            		} else {
            			stack.push(t);
            			level++;
            		}
    			} else if (i.isClosing()) {
    				Token openToken = stack.pop();
    				if (i.isMatching(openToken.getIdentifier())) {
    					t.setPartner(openToken);
    					openToken.setPartner(t);
    				} else if(openToken.getIdentifier().name().equals("UNDERWEAR")) {
    					Token newOpenToken = stack.pop();
    					level--;
    					if (i.isMatching(newOpenToken.getIdentifier())) {
        					t.setPartner(newOpenToken);
        					newOpenToken.setPartner(t);
        				} else {
        					System.out.println("BEEDOOBEEDOO");
        				}
    				}
    				level--;
    			}
    			return i;
    		}
    	}
    	return null;
    }
}
