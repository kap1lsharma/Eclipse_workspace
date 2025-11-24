package package2;

public class reverseTheString {

	public static void main(String[] args) {

		String abc = "Kapil Sharma is damn good";
		String[] abc3 = abc.split(" ");
		int len = abc3.length;

		for (int i = 0; i < len; i++) { // iterate over each word
			String word = abc3[i];
			char[] chars = word.toCharArray();

			for (int j = chars.length - 1; j >= 0; j--) { // reverse each word
				System.out.print(chars[j]);
			}
			System.out.print(" "); // add space after each word
		}

	}

}
