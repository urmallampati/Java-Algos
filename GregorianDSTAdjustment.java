package subpkg;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class GregorianDSTAdjustment {
	public static void main(String args[]) {
		TimeZone tz = TimeZone.getTimeZone("CST");

		printStandardDSTTime(new Date(), tz);

		printStandardDSTTime(new Date(1514781036000l), tz); // Randomly
		// creating
		// Date object
		// for
		// jan 01 2018
		// (No
		// effect of day
		// ligght
		// savings

		tz = TimeZone.getTimeZone("PST");
		printStandardDSTTime(new Date(), tz);

		printStandardDSTTime(new Date(1514781036000l), tz);
	}

	static void printStandardDSTTime(Date date, TimeZone tz) {

		Calendar calendar = new GregorianCalendar(tz);
		if (tz.useDaylightTime() && tz.inDaylightTime(date)) {
			calendar.add(Calendar.MILLISECOND, -tz.getDSTSavings());
		}
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int year = calendar.get(Calendar.YEAR);
		System.out.printf(tz.getID() + " time: %02d:%02d:%02d %02d\n", hour, minute, second, year);
	}

}
