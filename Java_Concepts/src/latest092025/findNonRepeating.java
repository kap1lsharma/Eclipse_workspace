package latest092025;

import java.util.LinkedHashMap;
import java.util.Map;

public class findNonRepeating {

	public static void main(String[] args) {

		String originalString = "My name is Kap My";

		Map<Character, Integer> count = new LinkedHashMap<>();

		for (char c : originalString.toCharArray()) {

			count.put(c, count.getOrDefault(c, 0) + 1);

		}

		System.out.println("Character frequencies:");
		for (Map.Entry<Character, Integer> entry : count.entrySet()) {
			System.out.println("'" + entry.getKey() + "': " + entry.getValue());
		}

		System.out.print("Non-repeating characters: ");

		for (Map.Entry<Character, Integer> entry : count.entrySet()) {

			if (entry.getValue() == 1) {

				System.out.print(entry.getKey() + " ");
			}

		}

	}

}
