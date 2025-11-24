package Test2;

public class reverseString {

	public static void main(String[] args) {

		String test = "This is kap";

		char[] testarry = test.toCharArray();

		String temp = "";

		for (int i = testarry.length - 1; i >= 0; i--) {

			temp = temp + testarry[i];

		}

		System.out.println(temp);

	}

}
