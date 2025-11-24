
package package2;

public class positiveNegativeNumber {

	public static void main(String[] args) {

		// Write a program that checks if a number is positive, negative, or zero.

		int arr[] = { 1, 0, 23, 10, 11, -11, -22, 22, 0 };

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > 0) {

				System.out.println("Number is positive" + " " + arr[i]);

			}

			if (arr[i] < 0) {

				System.out.println("Number is Negative" + " " + arr[i]);

			}

			if (arr[i] == 0) {

				System.out.println("Number is zero" + " " + arr[i]);
			}

		}

	}

}
