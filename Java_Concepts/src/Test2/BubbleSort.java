package Test2;

public class BubbleSort {

	static int temp = 0;

	private static void sortAscending(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {

			for (int j = 0; j < array.length - 1 - i; j++) {

				if (array[j] > array[j + 1]) {

					temp = array[j];

					array[j] = array[j + 1];

					array[j + 1] = temp;

				}

			}

		}

		for (int num : array) {

			System.out.print(num + " ");

		}

	}

	public static void sortDescending(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {

			for (int j = 0; j < array.length - 1 - i; j++) {

				if (array[j] < array[j + 1]) {

					temp = array[j];

					array[j] = array[j + 1];

					array[j + 1] = temp;

				}

			}

		}

		for (int num : array) {

			System.out.print(num + " ");
		}

	}

	public static void main(String[] args) {

		int Array[] = { 12, 223, 323, 323, 44, 45, 2, 0, 89, 21, 99 };

		BubbleSort.sortAscending(Array);

		System.out.println(" ");

		BubbleSort.sortDescending(Array);

	}

}
