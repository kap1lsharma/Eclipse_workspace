package Test2;

public class greatestNumber {

	public static void main(String[] args) {

		int[] test = { 12, 29, 22, 77, 89, 22, 9, 0 };

		int temp = 0;

		for (int i = 0; i < test.length; i++) {

			if (temp < test[i]) {

				temp = test[i];

			}

		}

		System.out.println(temp + " is greatest");

	}

}
