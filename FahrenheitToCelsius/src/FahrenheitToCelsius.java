public class FahrenheitToCelsius{
	public static void main(String[] args) {
		int saturdayFahrenheit = 78;
		int sundayFahrenheit = 81;
		double saturdayCelsius = (5.0/9)*(saturdayFahrenheit - 32);
		double sundayCelsius = (5.0/9) * (sundayFahrenheit - 32);
		
		System.out.println("Weekends Averages");
		System.out.println("Saturday:" + saturdayCelsius);
		System.out.println("Sunday:" + sundayCelsius);
	}
}