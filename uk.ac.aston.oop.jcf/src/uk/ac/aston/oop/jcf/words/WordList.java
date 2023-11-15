package uk.ac.aston.oop.jcf.words;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Reads the words from a Hunspell word list file.
 * Ignores suffixes, and organizes by first letter.
 *
 * TODO change to use a Map<Character, Set<String>>
 * that already has words grouped by first letter.
 */
public class WordList {

	//private Set<String> words;
	Map<Character, Set<String>> wordsByLetter;

	public WordList(InputStream is) throws IOException {
		try (Scanner sc = new Scanner(is)) {
			readWords(sc);
		}
	}

	private void readWords(Scanner sc) {
		// Ignore first line with number of words
		sc.nextLine();
		wordsByLetter = new HashMap<>();

		while (sc.hasNextLine()) {
			String line = sc.nextLine();

			/*
			 * Words may have a suffix ("word/suffix") or not.
			 * We split the word by / and take the first part. 
			 */
			String[] parts = line.split("/");
			char firstLetter = parts[0].charAt(0);
			Set<String> words = wordsByLetter.get(firstLetter);
			if(words==null) {
				words = new HashSet<String>();
				wordsByLetter.put(firstLetter, words);
				
				
			}
			words.add(parts[0]);
		}
	}

	public Set<String> searchWords(char firstLetter, String substring) {
		final Set<String> results = new HashSet<>();
		Set<String> words = wordsByLetter.get(firstLetter);
		if (words != null) {
			for (String w : words) {
				if (w.startsWith(firstLetter + "") && w.contains(substring)) {
					results.add(w);
				}
			}
		}else{
			
			
		}
		
		return results;
	}

}
