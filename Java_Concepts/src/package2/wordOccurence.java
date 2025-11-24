package package2;

import java.util.HashMap;

public class wordOccurence {

	public static void main(String[] args) {

		String test = "This is me this is kap kap is cool";

		String[] test2 = test.split(" ");

		HashMap<String, Integer> countTheWord = new HashMap<>();

		for (String c : test2) {
			if (countTheWord.containsKey(c)) {
				countTheWord.put(c, countTheWord.get(c) + 1);
			} else {
				countTheWord.put(c, 1);
			}
		}

		for (String c : countTheWord.keySet()) {
			System.out.println("Word :" + c + ", count :" + countTheWord.get(c));
		}
	}
}
