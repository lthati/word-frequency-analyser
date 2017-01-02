import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordCounter {

    public boolean validateFile(File inputFile) {
        boolean isValid = false;
        try {
            FileReader file = new FileReader(inputFile);
            
            // if file exists, we check the type
            String fileType = "undetermined";

            try {
                fileType = Files.probeContentType(inputFile.toPath());
                // print filetype
                
                if (fileType.equals("text/plain")) {
                    isValid = true;
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(WordCounter.class.getName()).log(Level.SEVERE, "file type is not supported, only .txt files are allowed", ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(WordCounter.class.getName()).log(Level.SEVERE, "given file does not exist", ex);
        }
        
        return isValid;

    }

    public static void main(String args[]) throws Exception {
    	
        Scanner in = new Scanner(System.in);
    	
        //Get the file name and open it
    	System.out.println("Enter fileName : ");
    	String fileName = in.nextLine();
        File file = new File(fileName);
        
        //Create a new WordCounter Object to parse this file
        WordCounter wordCounter = new WordCounter();
            			
        //if the file doesn't exist or not in right format throw error
        boolean isvalid = wordCounter.validateFile(file);
        
        // If the file is valid then start the analysis
        if (isvalid) {
        	
            // initialize frequency analysis.
        	WordFrequencyCollection coll = wordCounter.doFrequencyAnalysis(file);
        	
        	//print the analyzed info*/
        	printWordFrequency(coll);
        	        	   
        }

        //close the scanner object
        in.close();
    }
    
    public WordFrequencyCollection doFrequencyAnalysis(File inputFile) {
    	WordFrequencyAnalyser analyser = new WordFrequencyAnalyser();
    	analyser.analyseText(inputFile);
    	return analyser.getResults();
    }
   
    public static void printWordFrequency(WordFrequencyCollection collection)
    {
    	Iterator<String> sortedIterator = collection.iterator();
		while(sortedIterator.hasNext())
		{
			String word = sortedIterator.next();
			System.out.println(word+"="+collection.getFrequency(word));
		}
    }
}
