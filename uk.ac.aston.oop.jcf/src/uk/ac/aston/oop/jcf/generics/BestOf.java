package uk.ac.aston.oop.jcf.generics;

/**
 * Container which only holds the best N items out of all
 * the items that have been added so far. We will develop
 * this class in several rounds:
 * 
 * 1. First, with just Comparable (no generics and warnings).
 * 2. Then, we will add a type parameter.
 * 3. Finally, we will use type bounds to ensure it's
 *    completely safe to use.
 */
public class BestOf {
	
	public static void main(String[] args) {
		/*
		 * Sample code using the first complete version of this class.
		 * Uncomment when it is ready.
		 */

		/*
		final BestOf bestScores = new BestOf(3);
		bestScores.add(3000);
		bestScores.add(4200);
		bestScores.add(2600);
		bestScores.add(1500);

		for (Comparable c : bestScores.getItems()) {
			System.out.println(c);
		}
		*/
	}
}
