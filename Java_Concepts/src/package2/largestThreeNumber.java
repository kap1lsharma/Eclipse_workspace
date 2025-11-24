package package2;

public class largestThreeNumber {

	public static void main(String[] args) {

		// Create a Java program to find the largest of three numbers using if-else
		// statements.
		int num1 = 31;
		int num2 = 90;
		int num3 = 33;

		if (num1 >= num2 & num1 >= num3) {

			System.out.println("Greatest is : " + num1);
		}

		if (num2 >= num3 & num2 >= num1) {

			System.out.println("Greatest is : " + num2);
		}

		else {

			System.out.println("Greatest is : " + num3);

		}

	}

}
