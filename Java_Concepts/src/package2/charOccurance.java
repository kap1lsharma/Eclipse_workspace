package package2;

import java.util.HashMap;

public class charOccurance {

	public static void main(String[] args) {

		String str = "My name is Kao what about you??";
		char chrr[] = str.toCharArray();

		HashMap<Character, Integer> countTheChar = new HashMap<>();

		for (char c : chrr) {
			if (countTheChar.containsKey(c)) {
				countTheChar.put(c, countTheChar.get(c) + 1);
			} else {
				countTheChar.put(c, 1);
			}
		}

		for (char c : countTheChar.keySet()) {
			System.out.println("Character is :" + c + ", Count is : " + countTheChar.get(c));
		}
	}
}
