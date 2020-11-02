import java.util.Scanner;

// Stephen Schuster

public class FeetToMeters {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the number of feet.");
		
		double feet = keyboard.nextDouble();
		
		double meters = feet*0.3048;
		
		System.out.println(feet + " feet is equal to " + meters + " meters.");
	}
}