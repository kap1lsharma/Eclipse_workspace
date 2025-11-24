package Test2;

public class sortingNonZero {

	public static void main(String[] args) {

		int array[] = { 12, 0, 9, 0, 8, 0, 76, 2 };

		for (int i = 0; i < array.length-1; i++) {

			int temp = 0;

			if (array[i]!=0) {

				temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;

			}

		}

		System.out.println(array);

	}

}
