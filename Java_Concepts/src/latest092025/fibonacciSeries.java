package latest092025;

public class fibonacciSeries {

	public static void main(String[] args) {

		int n0 = 0, n1 = 1;

		for (int i = 0; i < 10; i++) {

			System.out.print(n0 + " ");
			int next = n0 + n1;

			n0 = n1;
			n1 = next;

		}

	}

}
