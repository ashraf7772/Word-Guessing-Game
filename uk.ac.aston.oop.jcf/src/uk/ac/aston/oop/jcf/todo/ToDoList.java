package uk.ac.aston.oop.jcf.todo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * To-do list, implemented through a JCF List.
 */
public class ToDoList implements Iterable<ToDoItem> {

	protected final List<ToDoItem> items = new ArrayList<>();

	@Override
	public Iterator<ToDoItem> iterator() {
		return items.iterator();
	}

	/**
	 * Returns <code>true</code> if the list is empty, <code>false</code> otherwise.
	 * 
	 * @return true if the list is empty, false if not.
	 */
	public boolean isEmpty() {
		return items.isEmpty();
	}

	/**
	 * Adds an item at the end of the list.
	 *
	 * @param toDoItem Item to be added.
	 */
	public void add(ToDoItem toDoItem) {
		items.add(toDoItem);
	}

	/**
	 * Returns the number of items of the list.
	 *
	 * @return Number of items in the list.
	 */
	public int size() {
		return items.size();
	}

	/**
	 * Marks the <code>i</code>-th item in the list as done.
	 *
	 * @param i Position of the item, starting at 0.
	 */
	public void markDone(int i) {
		items.get(i).setDone(true);

		// TODO needs to be implemented
	}

	/**
	 * Removes the <code>i</code>-th item from the list.
	 *
	 * @param i Position of the item, starting at 0.
	 */
	public void remove(int i) {
		items.remove(i);
	}

	/**
	 * Removes all entries whose description contains the specified
	 * <code>substring</code>.
	 * 
	 * @param substring Search string.
	 */
	public void removeAllContaining(String substring) {
		Iterator<ToDoItem> it = iterator();
		while (it.hasNext()) {
			ToDoItem item = it.next();
			if (item.getDescription().contains(substring)) {
				it.remove();
			}

		}
	}

	/**
	 * Remove all items marked as done.
	 */
	public void removeAllDone() {
		Iterator<ToDoItem> it = iterator();
		while (it.hasNext()) {
			ToDoItem item = it.next();
			if (item.isDone()) {
				it.remove();
			}

		}	
		
	}

	/**
	 * Moves the <code>i</code>-th item to the first position of the list.
	 *
	 * @param i Position of the item, starting at 0.
	 */
	public void moveToTop(int i) {
		if (i > 0) {
			//Iterator<ToDoItem> it = iterator();
			ToDoItem item = items.remove(i);
			items.add(0,item);
			}

	}

	/**
	 * Shuffles the list by visiting each position and swapping the element at that
	 * position with the element at another random position.
	 */
	public void shuffle(Random rnd) {
		// TODO needs to be implemented
		for (int i = 0; i < items.size(); i++) {
			 ToDoItem item = items.get(i);
			 int otherPosition = rnd.nextInt(items.size());
			 ToDoItem otherItem = items.get(otherPosition);
			 items.set(i, otherItem);
			 items.set(otherPosition, item);

			}
	}

}
