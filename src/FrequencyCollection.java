import java.util.Iterator;

public interface FrequencyCollection {
	
	// Adds a new word to the collection or increments the value of the word if it alredy exists	
	public void add(String word) ;
	
	// returns the frequency of the particular word
	public int getFrequency(String word);
	
	// returns the complete collection in string format i.e.  ---> key	value
	public String toString();
	
	// returns the size of the collection
	public int size();
	
	// sorts the collection 1. based on the frequency of word; 2. if frequency is same, then
	// sorts based on the alphabetical order of the word
	//public void sort();
	 
	// iterates through the collection
	public Iterator<String> iterator();

}
