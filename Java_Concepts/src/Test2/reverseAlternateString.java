package Test2;

public class reverseAlternateString {

	public static void main(String[] args) {

		// reverse the string at own place

		String input = "Elon musk is genius";
		String out = "";

		String[] test = input.split(" ");

		for (int i = 0; i < test.length; i++) {

			for (int j = test[i].length() - 1; j >= 0; j--) {
				out = out + test[i].charAt(j);
			}
			out = out + " ";

		}

		System.out.println(out + " ");

	}

}
