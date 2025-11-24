package latest092025;

public class palindrome {

	public static void main(String[] args) {

		String org = "We are checking palindrome";
		String org2 = "DAD";

		char chr[] = org2.toCharArray();

		String check = "";

		for (int i = 0; i <= org2.length() - 1; i++) {

			check = org2.charAt(i) + check;

			if (check.equals(org2)) {

				System.out.println(org2 + " is palindrome");
			}

		}

	}

}
