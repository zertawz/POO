package model.world;

public class Time {
	
	private static boolean isNight = false;
	
	public Time() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isNight() {
		return isNight;
	}

	public static void setNight(boolean isNight) {
		Time.isNight = isNight;
	}

}
