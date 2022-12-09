public class lessonOne
{
	public static void main(String[] args)
	{
		int thisYear = 2019;
		String birthdayMonth = "June";
		int firstDay = 3;
		//Etape 1
		int daysInWeek = 7;
		//Etape 2
		firstDay += daysInWeek;
		//Etape 3
		final int STARTINGDAY = firstDay;
		System.out.println("There are " + daysInWeek + "days in a week.\nYour starting day in the month is: " + STARTINGDAY);
	}
}

