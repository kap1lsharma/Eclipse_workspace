package test;

public class NonZeroValueInbeginning {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 0, 8, 3, 0, 33, 23, 0 };

		int len = arr.length;

		int IndexOfNonZero = len - 1;

		for (int i = len - 1; i >= 0; i--) {

			if (arr[i] != 0) {

				arr[IndexOfNonZero] = arr[i];

				IndexOfNonZero--;

			}

		}

		for (int i = 0; i <= IndexOfNonZero; i++) {

			arr[i] = 0;

		}

		for (int i = 0; i < len; i++) {

			System.out.println(arr[i]);
		}

	}

}
