package package2;

public class sortZero {

	public static void main(String[] args) {

		int test[] = { 1, 4, 66, 0, 0, 3, 0, 4, 5 };
		int indexOfNonZero = 0;

		for (int k = 0; k < test.length; k++) {

			if (test[k] != 0) {
				test[indexOfNonZero] = test[k];
				indexOfNonZero++;
			}

		}
		while (indexOfNonZero < test.length) {
			test[indexOfNonZero] = 0;
			indexOfNonZero++;
		}
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}

	}
}
