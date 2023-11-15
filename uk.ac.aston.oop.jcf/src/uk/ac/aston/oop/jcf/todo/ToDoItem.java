package uk.ac.aston.oop.jcf.todo;

public class ToDoItem {

	private final String description;
	private boolean done = false;

	public ToDoItem(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getDescription() {
		return description;
	}
	
}
