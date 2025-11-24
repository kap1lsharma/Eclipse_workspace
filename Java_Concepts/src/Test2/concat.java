package Test2;

import java.util.ArrayList;

public class concat {

	public static void main(String[] args) {

		String str1 = "Text"; // pool memory
		String str2 = new String("Text"); // heap memory

		String str3 = "Text";

		System.out.println(str1.concat(str2));

		System.out.println(str1 == str2);

		System.out.println(str1 == str3);

		// whenever we do comparison bw strings then we use .equals method
		System.out.println(str1.equals(str2));

		int num[] = { 1, 2, 3, 4 };

		// container
		ArrayList<String> al = new ArrayList<>();

		al.add(str3);
		al.add(str2);
		al.add(str1);
		al.add(null);

		System.out.println(al);
		
		
		

	}

}
