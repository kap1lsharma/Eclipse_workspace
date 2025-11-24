package test;

public class returnTest {

	// input values are arguments
	// methods have input parameter

	public static int sum() {

		System.out.println("This is sum block");

		int sum = 10 + 20;

		return sum;

	}

	public static int multiplication(int a, int b, int c) {

		int mul = a * b * c;

		return mul;
	}

	public static void main(String[] args) {

		int sumValue = returnTest.sum();

		System.out.println(sumValue);

		int mulResult = returnTest.multiplication(sumValue, sumValue, sumValue);

		System.out.println(mulResult);

	}
}
