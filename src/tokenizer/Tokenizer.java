package tokenizer;
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import compiler.Compiler;

public class Tokenizer {
	private static ArrayList<Token> tokenList = new ArrayList<Token>();
	private static Deque<Token> stack = new ArrayDeque<Token>();
	private static HashMap<String, Identifier> identifiersMap;
	private static int level = 0;
	private static int lineCounter = 0;
	private static int charCounter = 0;
	static Token previous = null;
    static Token first = null;
	
	public static void main(String [] args) throws Exception {
		System.out.println("Running tokenizer");
		System.out.println("________________");
		identifiersMap = fillHashmap();
		
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
                	Tokenize(item);
                    charCounter += item.length();
                }
            }
            
            ArrayList<Token> tl = tokenList;
            
            for (Token t : tokenList) {
            	t.printToken();
            }

            // Always close files.
            bufferedReader.close();
            
            isAllClosed();
            
            Compiler c = new Compiler(tokenList);
            c.toString();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
             ex.printStackTrace();
        }
    }
	
	public static void Tokenize(String isIn) throws Exception {
		//map[isIn.toLowerCase()];
		if(stack.peek() != null && stack.peek().getIdentifier().equals(Identifier.QUOTE) && !isIn.equals("'")) {
			Identifier i = Identifier.STRING;
			Token t = new Token(lineCounter, charCounter, isIn, i, level, previous);
			if(first == null) {
				first = t;
			}
			findPartner(t, i);
			if(!t.getIdentifier().equals(Identifier.QUOTE)) {
				tokenList.add(t);
				if(previous != null) {
					previous.setNext(t);
				}
				previous = t;
			}
		}
		else {
			if (identifiersMap.containsKey(isIn)) {
				Identifier i = identifiersMap.get(isIn);
				Token t = new Token(lineCounter, charCounter, isIn, identifiersMap.get(isIn), level, previous);
				if(first == null) {
					first = t;
				}

				findPartner(t, i);
				if(!t.getIdentifier().equals(Identifier.QUOTE)) {
					tokenList.add(t);
					if(previous != null) {
						previous.setNext(t);
					}
					previous = t;
				}
			}
			else {
				try {
					Identifier i = Identifier.NUMBER;
					Token t = new Token(lineCounter, charCounter, isIn, i, level, previous);
				    double d = Double.parseDouble(isIn);
				    if(first == null) {
						first = t;
					}

					findPartner(t, i);
				    if(!t.getIdentifier().equals(Identifier.QUOTE)) {
						tokenList.add(t);
						if(previous != null) {
							previous.setNext(t);
						}
						previous = t;
					}
				}  
				catch(NumberFormatException nfe)  
				{  
					Identifier i = Identifier.IDENTITY;
					Token t = new Token(lineCounter, charCounter, isIn, i, level, previous);
					if(first == null) {
						first = t;
					}

					findPartner(t, i);
					if(!t.getIdentifier().equals(Identifier.QUOTE)) {
						tokenList.add(t);
						if(previous != null) {
							previous.setNext(t);
						}
						previous = t;
					}
				} 
			}
		}	
    }
	
	public static void findPartner(Token t, Identifier i) throws Exception {
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
			} else if(!openToken.getIdentifier().needsClosing()) {
				Token newOpenToken = stack.pop();
				level--;
				if (i.isMatching(newOpenToken.getIdentifier())) {
					t.setPartner(newOpenToken);
					newOpenToken.setPartner(t);
				}
			} else {
				throw new Exception("BEEDOOBEEDOO - No closing for " + openToken.getIdentifier() + " detected at line " + openToken.getLineNumber());
			}
			level--;
		}
	}
	
	public static boolean isAllClosed() throws Exception {
		while(!stack.isEmpty()) {
			Token t = stack.pop();
			if (t.getIdentifier().needsClosing()) {
				throw new Exception("BEEDOOBEEDOO - Necessary closing avoided");
			}
		}
		return true;
	}
	
	public static HashMap<String, Identifier> fillHashmap() {
		HashMap<String, Identifier> hm = new HashMap<String, Identifier>();
		for(Identifier i : Identifier.values()) {
			hm.put(i.toString(), i);
		}
		return hm;
	}
}
