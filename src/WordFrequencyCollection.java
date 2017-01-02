import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class WordFrequencyCollection implements FrequencyCollection, Iterable<String> {

	private HashMap<String, Integer> wordsDict;

	public WordFrequencyCollection() {
		wordsDict = new HashMap<>();
	}

	public void add(String word) {
		// if the word exists -- then increment the value
		// if it does'nt exists --- add a new key
		if (wordsDict.containsKey(word)) {
			wordsDict.put(word, wordsDict.get(word) + 1);
			return;
		}
		wordsDict.put(word, 1);

	}
	
	public void put(String word, int frequency) {
		wordsDict.put(word, frequency);
	}

	public int getFrequency(String word) {
		return wordsDict.get(word);
	}

	public String toString() {
		return wordsDict.toString();
	}

	public int size() {
		return wordsDict.size();
	}

	HashMap<String, Integer> getCollection() {
		return this.wordsDict;
	}
	
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>()
				{
		List<String> keys = Arrays.asList( wordsDict.keySet().toArray(new String[0]));
		ListIterator<String> keyIterator = keys.listIterator();
		
		{
			Collections.sort(keys, new Comparator<String>() {

				//sort the hashmap
				@Override
				public int compare(String key1, String key2) {
					//comparing the frequency of keys
					int compare = wordsDict.get(key2)-wordsDict.get(key1);
					if(compare==0)
					{
						return key1.compareTo(key2);
					}
					return compare;
				}
			
			});
		};
		
		@Override
		public boolean hasNext() {
			return keyIterator.hasNext();
			
		}

		@Override
		public String next() {
			return keyIterator.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	};
	}
}
