package by.epam.lab.calendar.main;

import by.epam.lab.calendar.view.PrinterCalendar;

public class Main {

	public static void main(String[] args) {
		PrinterCalendar printer = new PrinterCalendar();
		
		printer.printMonth(2020, 5);// JUNE 2020
		printer.printYear(2020);// 2020, 4 month in row
	}
}