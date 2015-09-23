import java.io.*;
import java.util.ArrayList;

public class Tokenizer {
	private static ArrayList<Token> tokenList = new ArrayList<Token>();
	public static void main(String [] args) {
		int lineCounter = 0;
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
            	int charCounter = 0;
            	lineCounter++;
                String[] tokens = line.split(" ");
                for (String item : tokens) {
                	charCounter++;
                    Identifier i = isInIdentifiers(item);
                    if(i != null) {
                    	Token t = new Token(lineCounter, charCounter, item, i, 1);
                    	tokenList.add(t);
                    }
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
    			return i;
    		}
    	}
    	return null;
    }
}
