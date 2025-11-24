package newEmptyPackage;

import java.util.HashMap;
import java.util.HashSet;

public class collections {

	public static void main(String[] args) {

		// map is faster both speed complexity is o(1)
		HashMap<Integer, String> hp = new HashMap<>();

//		Hashtable<Integer, String> hp = new Hashtable<Integer, String>();

		hp.put(1, "Ravi");
		hp.put(2, "nishant");
		hp.put(3, "Ravi");

		HashSet<String> hp1 = new HashSet<>();
		hp1.add("Dua");
		hp1.add("Ravi");
		hp1.add("Rohit");

		System.out.println(hp);
		System.out.println(hp1);

	}

}
