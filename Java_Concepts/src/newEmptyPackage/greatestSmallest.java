package newEmptyPackage;

public class greatestSmallest {

	public static void main(String[] args) {

		int[] array = { 1, 9, 4, 8, 4, 88, 34, 11 };

		int max = array[0], small = array[0];

		for (int i = 0; i < array.length; i++) {

			if (array[i] > max) {

				max = array[i];

			}

			if (array[i] < small) {

			}

		}
		System.out.println(max);
		System.out.println(small);
	}

}
