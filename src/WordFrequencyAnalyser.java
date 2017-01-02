
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordFrequencyAnalyser {
	private WordFrequencyCollection wordFrequencyCollection;

	public WordFrequencyAnalyser() {
		wordFrequencyCollection = new WordFrequencyCollection();
	}

	public void analyseText(File file) {

		try {
			// To change body of generated methods, choose Tools | Templates.
			Scanner fileScanner = new Scanner(file);
			String delims = " \n\r\t,.'-;:!?"; // all delimiters
			while (fileScanner.hasNext()) {
				// apply parsing rules here and add words to dict

				String word = fileScanner.next();

				StringTokenizer tokenizer = new StringTokenizer(word, delims);

				while (tokenizer.hasMoreTokens()) {

					wordFrequencyCollection.add(tokenizer.nextToken());
				}
			}
		} catch (

		FileNotFoundException ex)

		{
			Logger.getLogger(WordFrequencyAnalyser.class.getName()).log(Level.SEVERE, "file not found", ex);
		}

	}

	WordFrequencyCollection getResults() {
		return wordFrequencyCollection;
	}

}
