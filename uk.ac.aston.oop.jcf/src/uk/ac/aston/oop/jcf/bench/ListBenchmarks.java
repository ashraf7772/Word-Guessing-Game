package uk.ac.aston.oop.jcf.bench;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import uk.ac.aston.oop.jcf.todo.ToDoItem;

/**
 * Runs microbenchmarks for adding a number of elements at the beginning and end
 * of a list, for the ArrayList and LinkedList implementations of the JCF List
 * interfaces.
 */
public class ListBenchmarks {

	protected static final int ELEMENTS = 100;

	/*
	 * TODO Add @Benchmark methods to:
	 * 
	 * 1. Add ELEMENTS elements to the end of an ArrayList 2. Add ELEMENTS elements
	 * to the end of a LinkedList 3. Add ELEMENTS elements to the beginning of an
	 * ArrayList 4. Add ELEMENTS elements to the beginning of a LinkedList
	 */

	public static void main(String[] args) throws RunnerException {
		Options options = new OptionsBuilder().include(ListBenchmarks.class.getSimpleName()).forks(1).build();
		new Runner(options).run();
	}

	protected void addToEnd(List<Integer> l, int n) {
		for (int i = 0; i < n; i++) {
			l.add(i);
		}
	}

	protected void addToBeginning(List<Integer> l, int n) {
		for (int i = 0; i < n; i++) {
			l.add(0, i);
		}
	}

	@Benchmark
	public void addToEndArrayList() {
		List<Integer> l = new ArrayList<>();
		addToEnd(l, ELEMENTS);
	}

	@Benchmark
	public void addToEndLinkedList() {
		List<Integer> l = new LinkedList<>();
		addToEnd(l, ELEMENTS);
	}

	@Benchmark
	public void addToBeginningArrayList() {
		List<Integer> l = new ArrayList<>();
		addToBeginning(l, ELEMENTS);
	}
	
	@Benchmark
	public void addToBeginningLinkedList() {
		List<Integer> l = new LinkedList<>();
		addToBeginning(l, ELEMENTS);
	}

}
