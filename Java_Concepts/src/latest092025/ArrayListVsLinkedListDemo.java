package latest092025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedListDemo {

	public static void main(String[] args) {
		int n = 100000; // number of elements

		// ArrayList test
		List<Integer> arrayList = new ArrayList<>();
		long start = System.nanoTime();
		for (int i = 0; i < n; i++) {
			arrayList.add(i);
		}
		long end = System.nanoTime();
		System.out.println("ArrayList insertion at end: " + (end - start) / 1_000_000 + " ms");

		// LinkedList test
		List<Integer> linkedList = new LinkedList<>();
		start = System.nanoTime();
		for (int i = 0; i < n; i++) {
			linkedList.add(i);
		}
		end = System.nanoTime();
		System.out.println("LinkedList insertion at end: " + (end - start) / 1_000_000 + " ms");

		// Insert at the beginning
		start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			arrayList.add(0, i);
		}
		end = System.nanoTime();
		System.out.println("ArrayList insertion at beginning: " + (end - start) / 1_000_000 + " ms");

		start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			linkedList.add(0, i);
		}
		end = System.nanoTime();
		System.out.println("LinkedList insertion at beginning: " + (end - start) / 1_000_000 + " ms");

		// Access elements
		start = System.nanoTime();
		for (int i = 0; i < n; i++) {
			arrayList.get(i);
		}
		end = System.nanoTime();
		System.out.println("ArrayList random access: " + (end - start) / 1_000_000 + " ms");

		start = System.nanoTime();
		for (int i = 0; i < n; i++) {
			linkedList.get(i);
		}
		end = System.nanoTime();
		System.out.println("LinkedList random access: " + (end - start) / 1_000_000 + " ms");
	}
}