package Test2;

public class ReverseOddIndexedWords {

	public static void main(String[] args) {

		String input = "This moment we own it";
		String[] test = input.split(" ");

		String out = ""; // Reset 'out' for each word

		String anw = "";

		for (int i = 0; i < test.length; i++) {

			// Check if the index is odd
			if (i % 2 != 0) {

				String words = test[i];

				// Reverse the word at odd index
				for (int j = words.length() - 1; j >= 0; j--) {
					out += words.charAt(j);
				}

				anw += out + " "; // Add the reversed word to 'anw'

			} else {
				anw += test[i] + " "; // Add the unchanged word to 'anw'
			}

		}

		// Print the final output
		System.out.println(anw); // Remove the trailing space
	}

}
