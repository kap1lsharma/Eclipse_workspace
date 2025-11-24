package Test2;

public class fibonacciSeries {

	public static void getData() {

		int n1 = 0, n2 = 1, sum;

		System.out.print(n1 + " " + n2);

		for (int i = 0; i < 20; i++) {

			sum = n1 + n2;

			System.out.print(" " + sum + " ");

			n1 = n2;
			n2 = sum;

		}

	}

	public static void main(String[] args) {

		fibonacciSeries.getData();

	}

}
