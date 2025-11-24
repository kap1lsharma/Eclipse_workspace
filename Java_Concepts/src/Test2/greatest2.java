package Test2;

public class greatest2 {

	public static void main(String[] args) {

		String test = "My name is kapil";

		String out = "";
		char[] chrr = test.toCharArray();

		for (int i = chrr.length - 1; i >= 0; i--) {

			out = out + chrr[i];

		}

		System.out.println(out);
	}

}
