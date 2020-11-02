import java.util.Scanner;
import java.text.DateFormat; 
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.InputMismatchException; 
public class DayOfTheWeek {
	public static int askYear(Scanner keys) {
		System.out.println("Enter the year.");
		int year = keys.nextInt();
		keys.nextLine();
		if (0>=year) {
			System.out.println("Don't try to be a smartass and answer the damn question.");
			askYear(keys);
		}
		return year;
	}
	public static int askMonth(Scanner keys) {
		System.out.println("Enter the month(Number).");
		int month = keys.nextInt();
		keys.nextLine();
		if (0>=month || month>12) {
			System.out.println("Don't try to be a smartass and answer the damn question.");
			askMonth(keys);
		}
		return month;
	}
	public static int askDay(Scanner keys, int month, int year) {
		System.out.println("Enter the day.");
		int day = keys.nextInt();
		keys.nextLine();
		if (!(((month/8+month)%2+30>=day && month!=2||day<=28||(day==29 && year%4 == 0)))) {
			System.out.println("Don't try to be a smartass and answer the damn question.");
			askDay(keys,month,year);
		}
		return day;
	}
	public static void main(String[] args) {
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		int[] Doomdays = {0,-4,0,0,-3,-5,-1,-3,-6,-2,-4,0,-2};
		Scanner keys = new Scanner(System.in);
		int year = askYear(keys);
		int month = askMonth(keys);
		int day = askDay(keys,month,year);
		System.out.println("That day "+ ppf(month,day,year) +" a " + days[((year%400/100*5+2)+(year%100/12)+(year%100%12)+(year%100%12/4)+(day - Doomdays[month]))%7]);
	}
	public static String ppf(int m, int d, int y) {
        long miliSec = System.currentTimeMillis(); 
        DateFormat dd = new SimpleDateFormat("dd"); 
        DateFormat mm = new SimpleDateFormat("M"); 
        DateFormat simple = new SimpleDateFormat("yyyy"); 
        Date result = new Date(miliSec); 
        if (Integer.parseInt(simple.format(result))>y) {
			return "was";
		}else if (Integer.parseInt(simple.format(result))<y) {
			return "will be";
		}else {
			if (Integer.parseInt(mm.format(result))>m) {
				return "was";
			} else if (Integer.parseInt(mm.format(result))<m) {
				return "will be";
			} else {
				if (Integer.parseInt(dd.format(result))>d) {
					return "was";
				} else if (Integer.parseInt(dd.format(result))<d) {
					return "will be";
				} else {
					return "is";
				}
			}
		}
	}
}
