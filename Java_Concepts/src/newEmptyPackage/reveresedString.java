package newEmptyPackage;

public class reveresedString {

	public static void main(String[] args) {

		String original = "My Name Is Kapil";

		String reversed = "";
//
//		for (int i = original.length() - 1; i >= 0; i--) {
//
//			reversed = reversed + original.charAt(i);
//
//		}
//
//		System.out.println(reversed + "1");

		for (int j = 0; j < original.length(); j++) {

			reversed = original.charAt(j) + reversed;

		}

		System.out.println(reversed);

	}

}
