package by.epam.lab.calendar.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import by.epam.lab.calendar.beans.DayOfWeek;
import by.epam.lab.calendar.beans.Month;

public class PrinterCalendar {
	
	public void printNameOFDays() {
		for(DayOfWeek day: DayOfWeek.values()) {
			System.out.printf("%4s", day.toString());
		}
	}
	
	/////////////////////////////////////////////////////////////////
	
	public void printWeek(Calendar calendar, int month) {
		int dayOfWeek;
		dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek == 1) {
			dayOfWeek = 7;
		}else {
			dayOfWeek--;
		}
				
		if(dayOfWeek > 1) {
			for(int i = 1; i < dayOfWeek; i++) {
				System.out.printf("%4s", "");
			}
		}
		
		while((calendar.get(Calendar.MONTH) == month) && (dayOfWeek <= 7)) {
			System.out.printf ("% 4d", calendar.get(Calendar.DAY_OF_MONTH));
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			dayOfWeek++;
		}
		
		while(dayOfWeek <= 7) {
			System.out.printf("%4s", "");
			dayOfWeek++;
		}
	}
	
	/////////////////////////////////////////////////////////////////
		
	public void printMonth(int year, int month) {
		Calendar calendar = new GregorianCalendar(year, month, 1);
		
		System.out.printf("%28s",Month.values()[month]);
		System.out.println();
		
		printNameOFDays();
		System.out.println();

		while(calendar.get(Calendar.MONTH) == month) {
			printWeek(calendar,month);
			System.out.println();			
		}
	}
	
	/////////////////////////////////////////////////////////////////
	
	public void printYear(int year) {		
		for(int i = 0; i < 3; i++) {
			printRowOfMonths(year, (i*4));
			System.out.println();
		}
	}
	
	/////////////////////////////////////////////////////////////////
	
	public void printRowOfMonths(int year, int startMonth) {
		Month[] nameOfMonth = Month.values();
		for(int i = startMonth; i < (startMonth + 4); i++) {
			System.out.printf("%28s",nameOfMonth[i]);
			System.out.printf("%8s","");
		}
		System.out.println();
		
		for(int i = 0; i < 4; i++) {
			printNameOFDays();
			System.out.printf("%8s","");
		}
		System.out.println();
		
		Calendar[] calendar = new GregorianCalendar[4];
		for(int i = 0; i < 4; i++) {
			calendar[i] = new GregorianCalendar(year, startMonth + i, 1);
		}
		
		while(isRequiredMonths(calendar, startMonth)) {
			for(int i = 0; i < 4; i++) {
				printWeek(calendar[i], (startMonth + i));
				System.out.printf("%8s","");
			}
			System.out.println();
		}
	}
	
	
	private boolean isRequiredMonths(Calendar[] calendar, int month) {
		for(int i = 0; i < calendar.length; i++) {
			if(calendar[i].get(Calendar.MONTH) == (month + i)){
				return true;				
			}
		}
		return false;
	}
}