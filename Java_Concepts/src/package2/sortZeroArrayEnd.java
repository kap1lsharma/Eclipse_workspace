package package2;

public class sortZeroArrayEnd {

	public static void main(String[] args) {
		int arr[] = { 1, 0, 123, 45, 0, 4, 89, 0 , 7 };
		int temp = 0;

		int len = arr.length;
		int indexOfNonZero = 0;

		for (int i = 0; i < len; i++) {

			if (arr[i] != 0) {

				arr[indexOfNonZero] = arr[i];
				indexOfNonZero++;

			}

		}

		while (indexOfNonZero < len) {

			arr[indexOfNonZero] = 0;

			indexOfNonZero++;

		}

		for (int j = 0; j < len; j++) {

			System.out.println(arr[j]);

		}

	}

}
