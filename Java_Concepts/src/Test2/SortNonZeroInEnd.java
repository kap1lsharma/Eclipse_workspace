package Test2;

public class SortNonZeroInEnd {

	public static void main(String[] args) {

		int[] array = { 1, 0, 9, 34, 2, 0, 33, 0, 1234 };

		int len = array.length;

		int arrayOfNonZeroindex = 0;

		for (int i = 0; i < len; i++) {

			if (array[i] != 0) {
				array[arrayOfNonZeroindex] = array[i];
				arrayOfNonZeroindex++;
			}
		}

		while (arrayOfNonZeroindex < len) {
			array[arrayOfNonZeroindex] = 0;
			arrayOfNonZeroindex++;
		}

		for (int i = 0; i < len; i++) {

			System.out.print(array[i] + " ");

		}

	}

}
