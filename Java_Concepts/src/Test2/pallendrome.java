package Test2;

import java.util.Scanner;

public class pallendrome {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = sc.next();

		String out = "";

		char[] charInput = input.toCharArray();

		for (int i = charInput.length - 1; i >= 0; i--) {

			out = out + charInput[i];

		}

		if (input.equalsIgnoreCase(out)) {

			System.out.println(out + "  is pallendrome");

		}

		else {

			System.out.println(out + " is not pallendrome");
			sc.close();
		}

	}

}
