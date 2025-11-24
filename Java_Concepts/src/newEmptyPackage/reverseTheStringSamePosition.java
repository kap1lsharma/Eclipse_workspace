package newEmptyPackage;

public class reverseTheStringSamePosition {

	public static void main(String[] args) {

		String original = "This is too short";
		String splited[] = original.split(" ");
		String reveresedString = "";

		for (int i = 0; i < splited.length; i++) {

			String word = splited[i];

			for (int j = word.length() - 1; j >= 0; j--) {

				reveresedString += word.charAt(j);

			}

			reveresedString = reveresedString + " ";

		}

		System.out.println(reveresedString.trim());

	}

}
