import java.util.*;

public class Date {
	
	public static void main(String[] args) {		
		Calendar cal = Calendar.getInstance();		
		// Stop date
		cal.set(2000, 12, 31);	
		java.util.Date endDate = cal.getTime();		
		// Start date
		cal.set(1901, 1, 1);			
		int n = 0;		
		while (cal.getTime().before(endDate)) {
			cal.add(Calendar.MONTH, 1);
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) n++;
		}		
		System.out.println("Number of sundays: " + n);
	}
}
