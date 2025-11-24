package newEmptyPackage;

public class BinaryGap {
	public static void main(String[] args) {

		int number = 529;
		String BinaryString = Integer.toBinaryString(number);
		int maxGap = 0;
		int currentGap = 0;
		Boolean counting = false;
		for (char c : BinaryString.toCharArray()) {
			if (c == '1') {
				maxGap = Math.max(maxGap, currentGap);
				currentGap = 0;
				counting = true;
			} else if (counting) {
				currentGap++;
			}
		}
		System.out.println("Max Gap is : " + maxGap);
	}

}
