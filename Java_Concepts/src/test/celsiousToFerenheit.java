package test;

public class celsiousToFerenheit {

	public static void main(String[] args) {

		double ferenheit = 0;
		double celsius = 1789782;

		ferenheit = celsiusToFerenheit(celsius);

		System.out.println(ferenheit);

	}

	public static double celsiusToFerenheit(double celsius) {

		return (celsius * 9 / 5) + 32;

	}

}
