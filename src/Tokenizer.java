import java.io.*;

public class Tokenizer {
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
            	lineCounter++;
                String[] tokens = line.split(" ");
                for (String item : tokens) {
                    System.out.println(item);
                    if(isInIdentifiers(item)) {
                    	System.out.println("TOKEN");
                    	Token t = new Token(lineCounter);
                    }
                }
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
             ex.printStackTrace();
        }
    }
	
	public static boolean isInIdentifiers(String isIn) {
    	for(Identifier i : Identifier.values()) {
    		if (i.toString().equals(isIn)) {
    			return true;
    		}
    	}
    	return false;
    }
}
