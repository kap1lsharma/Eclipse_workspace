package newEmptyPackage;

public class sortTheNumber {

	public static void main(String[] args) {

		int array[] = { 1, 8, 0, 33, 0, 2, 9, 0, 3 };

		int temp = 0;

		for (int i = 0; i <= array.length - 1; i++) {

			if (array[i] != temp) {

				temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;

			}

			System.out.print(array[i] + " ");
		}

	}

}
