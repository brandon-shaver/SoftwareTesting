package softwareTesting;

public class TestCaseEvaluator {
	
	/*
	 * Pre-condition: Lengths must be between 5 and 205 for each side
	 * 
	 */
	
	public static String evalTriangle(int[] inputs) {	//What are the three side lengths?
		int a, b, c;
		boolean c1, c2, c3;
		boolean IsATriangle;
		
		a = inputs[0];	//First input
		b = inputs[1];	//Second input
		c = inputs[2];	//Third input
		
		IsATriangle = ((a < (b + c)) && (b < (a + c)) && (c < (a + b)));
		
		c1 = ((5 <= a) && (a <= 205));	//Side A is between 5-205		
		c2 = ((5 <= b) && (b <= 205));	//Side B is between 5-205
		c3 = ((5 <= c) && (c <= 205));	//Side C is between 5-205
				
		if ((c1 == true) && (c2 == true) && (c3 == true)) {	//All conditions were met
		
			if (IsATriangle = true) { 
				if (a == b && b ==c) {	//All side lengths are equal
					return ("Equilateral Triangle");	//Then it's equilateral
				}

				else if ((a != b) && (a != c) && (b != c))	//All sides have different lengths
				{
					return ("Scalene Triangle");	//Then it's scalene
				}else {
					return ("Isosceles Triangle");	//Otherwise it has to be isosceles
				}
			}
			else {	//If it isn't any of the above, it is not a triangle
				return ("Not a Triangle");
			}
			
		}
			else if ((c1 == false) || (c2 == false) || (c3 == false)) {	
				if (c1 == false) {
					return ("Invalid Input");
				}
				if (c2 == false) {
					return ("Invalid Input");
				}
				if (c3 == false) {
					return ("Invalid Input");
				}
		}
			return ("");
	}

	/*
	 * Pre-condition: 	Day must be between 1-31
	 * 					Month must be between 1-12
	 * 					Year must be between 1801-2021
	 */
	
	public static String evalDate(int[] inputs) {	//Input date

		int tomorrowDay, tomorrowMonth, tomorrowYear;
		int day, month, year;
		boolean c1, c2, c3;
		boolean isLeapYear;
		
		month = inputs[0];	//First input
		tomorrowMonth = inputs[0];	//First input
		day = inputs[1];	//Second input
		tomorrowDay = inputs[1];	//Second input
		year = inputs[2];	//Third input
		tomorrowYear = inputs[2];	//Third input
		
		c1 = ((1 <= day) && (day <= 31));	//Day must be between 1-31
		c2 = ((1 <= month) && (month <= 12));	//Month must be between 1-12
		c3 = ((1801 <= year) && (year <= 2021));	//Year must be between 1801-2021
		
		isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));	//Leap year?
		
		if (c1 == false) {
			return ("Invalid Input");	//Invalid day
		}
		if (c2 == false) {
			return ("Invalid Input");	//Invalid month
		}
		if (c3 == false) {
			return ("Invalid Input");	//Invalid year
		}
		
		if ((c1 == true) && (c2 == true) && (c3 == true)) {	//All conditions are met
			switch (month) {	//Switch case for months
			//31 day months
			case 1:	//January
			case 3:	//March
			case 5:	//May
			case 7:	//July
			case 8:	//August
			case 10://October
				if (day < 31) {	//If day is less than 31
					tomorrowDay = day + 1;
					return ("" +tomorrowMonth +"-" +tomorrowDay +"-" +tomorrowYear);
				}
				else {	//Day is 31
					tomorrowDay = 1;	//Tomorrow is the 1st of the next month
					tomorrowMonth = month + 1;
					return ("" +tomorrowMonth +"-" +tomorrowDay +"-" +tomorrowYear);
				}
			//30 day months
			case 4:	//April
			case 6:	//June
			case 9:	//September
			case 11://November
				if (day < 30) {	//If day is less than 30
					tomorrowDay = day + 1;
					return ("" +tomorrowMonth +"-" +tomorrowDay +"-" +tomorrowYear);
				}
				else if (day == 30) {
					tomorrowDay = 1;	//Tomorrow is the 1st of the next month
					tomorrowMonth = month + 1;
					return ("" +tomorrowMonth +"-" +tomorrowDay +"-" +tomorrowYear);
				}
				else { //Can't have 31 days in these months
					return ("Invalid Input");
				}
			//New years
			case 12:	//December
				if (day < 31) {	//If day is less than 31
					tomorrowDay = day + 1;
					return ("" +tomorrowMonth +"-" +tomorrowDay +"-" +tomorrowYear);
				}
				else if (day == 31) {	//If day is New Years Eve
					tomorrowDay = 1;	//Next day is the 1st
					tomorrowMonth = 1;	//Month is January
					tomorrowYear = year + 1;	//New year
					return ("" +tomorrowMonth +"-" +tomorrowDay +"-" +tomorrowYear);
				}
			break;
			//Leap Year
			case 2: 
				if (day < 28) {	//Day is less than 28
					tomorrowDay = day + 1;
					return ("" +tomorrowMonth +"-" +tomorrowDay +"-" +tomorrowYear);
				}
				else if (day == 28) {	//Day is 28th
						if (isLeapYear == true) {	//Year is a leap year
							tomorrowDay = 29;	
							return ("" +tomorrowMonth +"-" +tomorrowDay +"-" +tomorrowYear);
						}
						else {	//Not a leap year
							tomorrowDay = 1;	//Next month
							tomorrowMonth = 3;
							return ("" +tomorrowMonth +"-" +tomorrowDay +"-" +tomorrowYear);
						}
					}
				else if (day == 29) {	//Day is 29th
						if (isLeapYear == true) {	//Year is leap year
							tomorrowDay = 1;	//Next month
							tomorrowMonth = 3;
							return ("" +tomorrowMonth +"-" +tomorrowDay +"-" +tomorrowYear);
						}
				}
				else if (day > 29) {	//Can't have more than 29 days in February
							return ("Invalid Input");
				}
				break;
			}
		}
		return ("");
	}
	
	/*
	 * Pre-condition: 	Must sell at least 1 and up to a max of 77 locks
	 * 					Must sell at least 1 and up to a max of 88 stocks
	 * 					Must sell at least 1 and up to a max of 99 barrels
	 */
	
	public static String evalCommission(int[] inputs) { 	//How many of each part was sold?
		int locks, stocks, barrels;
		double lockSales, stockSales, barrelSales;
		double sales, commission;
		boolean c1, c2, c3;
		
		double lockPrice = 35.0;
		double stockPrice = 25.0;
		double barrelPrice = 20.0;
		int totalLocks = 0;
		int totalStocks = 0;
		int totalBarrels = 0;
		
		locks = inputs[0];	//First input
		stocks = inputs[1];	//Second input
		barrels = inputs[2];	//3rd input
		
		c1 = (0 < locks) && (locks <= 77);	//Locks must be between 1-77
		c2 = (0 < stocks) && (stocks <= 88);	//Stocks must be between 1-88
		c3 = (0 < barrels) && (barrels <= 99);	//Barrels must be between 1-99
		
		if (locks == -1) {
			return ("End of Data");	//-1 = End of data
		}
		else if (c1 == true && c2 == true && c3 == true) {	//All conditions pass
		totalLocks = totalLocks + locks;	//Total locks
		totalStocks = totalStocks + stocks;	//Total stocks
		totalBarrels = totalBarrels + barrels;	//Total barrels
				
		lockSales = lockPrice * totalLocks;	//Lock sales
		stockSales = stockPrice * totalStocks;	//Stock sales
		barrelSales = barrelPrice * totalBarrels;	//Barrel sales
		sales = lockSales + stockSales + barrelSales;	//Total sales
		
		if (sales > 1800.0) {	//If sales is greater than $1800
			commission = (.1 * 1000);	//%10 commission first $1000 sales
			commission = commission + (.15 * 800);	//Plus %15 commission next $800 sales
			commission = commission + (.2 * (sales - 1800));	//Plus %20 commission rest of sales
		} else if (sales > 1000) {	//If sales is greater than 1000 but less than $1800
			commission = .1 * 1000;	//%10 commission first $1000
			commission = commission + (.15 * (sales - 1000));	//Plus %15 commission rest of sales
		} else { //If sales are less than 1000
			commission = (.1 * sales);	//%10 commission on all sales
		}
		
		return ("$" +commission);	//Output commission
		}
		else {
			return ("Invalid Input");	//Rules each month
		}
	}



}
