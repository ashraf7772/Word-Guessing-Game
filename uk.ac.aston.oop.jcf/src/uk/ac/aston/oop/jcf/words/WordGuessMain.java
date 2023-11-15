package uk.ac.aston.oop.jcf.words;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

public class WordGuessMain {
	/*
	 * Path to resource with the Hunspell British English dictionary,
	 * with -ise word endings:
	 *
	 * http://wordlist.aspell.net/dicts/
	 */
	private static final String DICT_RESOURCE_PATH = "/en_GB-ise.dic";

	private final WordList wordList;
	private final Scanner sc;

	private char firstLetter;
	private Set<String> candidates;

	public WordGuessMain(WordList wl, Scanner sc) {
		this.wordList = wl;
		this.sc = sc;
	}
	
	public void run() {
		buildCandidateSet();
		askUserToGuess();
	}

	protected void buildCandidateSet() {
		firstLetter = promptCharacter("Enter the first letter: ");
		String initialSearch = promptString("Enter an initial search: ");
		candidates = wordList.searchWords(firstLetter, initialSearch);

		boolean done = false;
		while (!done) {
			System.out.println(candidates.size() + " candidates currently selected");
			String pattern = promptString(
				"Enter a command (+WORD, -WORD, *WORD) or enter an empty line to switch to guessing\n>");
			done = processLine(pattern);
		}
	}

	protected void askUserToGuess() {
		if (candidates.isEmpty()) {
			 System.out.println("No candidates left.");
			} else {
			  String s = promptString("Make a guess:");
			  if (candidates.contains(s)) {
					 System.out.println("Correct");
					} else {
						 System.out.println("Incorrect");

						for(String c:candidates) {
						 System.out.println( c);
						}
					}
			}
	}

	protected boolean processLine(String pattern) {
		if (pattern.isEmpty()) {
			 return true;
			 //char cmd = pattern.getChars(0, 0, null, firstLetter););
			 //char cmd = pattern.getChars().charAt(0);
					 
		}
				char cmd = pattern.charAt(0);
				String substring = pattern.substring(1);
				if(cmd == '+') {
					candidates.addAll(wordList.searchWords(firstLetter, substring));
					
				} else if (cmd == '-'){
					candidates.removeAll(wordList.searchWords(firstLetter, substring));
				} else if (cmd == '*'){
					candidates.retainAll(wordList.searchWords(firstLetter, substring));

				} else {
					 System.out.println(cmd + "not recognized");

				}
			 
			  
			
		return false;
	}

	private char promptCharacter(String question) {
		System.out.print(question);

		// Read a single character and throw away the rest of the line
		char c = sc.findInLine(".").charAt(0);
		sc.nextLine();
		return c;
	}

	private String promptString(String question) {
		System.out.print(question);
		return sc.nextLine().strip();
	}

	public static void main(String[] args) {
		final InputStream dictStream =
			WordGuessMain.class.getResourceAsStream(DICT_RESOURCE_PATH);

		try (Scanner sc = new Scanner(System.in)) {
			final WordList wl = new WordList(dictStream);
			new WordGuessMain(wl, sc).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
