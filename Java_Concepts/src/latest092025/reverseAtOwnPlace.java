package latest092025;

public class reverseAtOwnPlace {

	public static void main(String[] args) {

		String org = "First Second Third Fourth";

		String strOrgArray[] = org.split(" ");

		String out = "";

		for (int i = 0; i <= strOrgArray.length; i++) {

			if (i % 2 == 0) {

				for (int j = i; j >= 0; j--) {

					out = strOrgArray[j] + out;

				}

			}

		}

		System.out.println(out);

	}

}
