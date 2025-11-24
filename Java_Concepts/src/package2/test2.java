package package2;

import test.test1;

public class test2 {

	public test2(int a) {
	}

	public test2(int b, String av) {
	}

	public test2(int c, String ab, String am) {
	}

	public test2(int c, int b) {

		System.out.println("This will be called");
	}

	public test2() {
	}

	static int ab = 1;

	public static void main(String[] args) {

		test2 ob = new test2(4, 5);

		int ac = test2.ab;

		System.out.println(ac);

	}

}
