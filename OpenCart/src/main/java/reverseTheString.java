import org.openqa.selenium.WebDriver;

public class reverseTheString {

	public static void main(String[] args) {

		String str = "This is a java program";

//		char[] chr = str.toCharArray();

//		int x = chr.length; // applied on array
		int y = str.length(); // applied on class

		String reversed = "";
		String reversed2 = "";

//		System.out.println(x);
		System.out.println(y);

		for (int i = str.length() - 1; i >= 0; i--) {

//			reversed += chr[i];
			reversed2 += str.charAt(i);

		}

		System.out.println(reversed2);

	}

}
