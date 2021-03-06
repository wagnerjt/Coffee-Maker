package test;

/**
 * Holds Constants for Testing purposes.
 * @author wagner, Tyler; 03-28/17
 */
public final class Constants
{
	//Global Constants
	public static final String STRING_EMPTY = "";
	
	//Recipe Values
	public static final String RECIPE_NAME_DEFAULT = "Brews with Booze";
	public static final String RECIPE_NAME_DEFAULT_CAPS = "BREWS WITH BOOZE";
	public static final String RECIPE_NAME_NEW = "Espresso";
	
	public static final int RECIPE_PRICE_DEFAULT = 3;
	public static final int RECIPE_AMTCOFFEE_DEFAULT = 1;
	public static final int RECIPE_AMTMILK_DEFAULT = 0;
	public static final int RECIPE_AMTSUGAR_DEFAULT = 0;
	public static final int RECIPE_AMTCHOCOLATE_DEFAULT = 10;
	
	//RecipeBook
	public static final int RECIPE_BOOK_SIZE = 3;
	
	
	//Items in Databases
	public static final int NUMBER_EMPLOYEES = 7;
	public static final int NUMBER_ROOMS = 7;
	
	//Database Locations
	public static final String DATABASE_EMPLOYEE = "resources/employees.json";
	public static final String DATABASE_ROOM = "resources/rooms.json";
	public static final String DATABASE_MEETINGS = "/.Meat/meetings.json";
	
	//File / Directory.
	public static final String TEST_FILE = ".testFile.txt";
	public static final String TEST_SCRIPT = "src/resources/sampleScript.json";
	public static final String TEST_DIR = ".test/";
	
	//Dates and Times
	public static final String DATE_VALID_BEFORE = "11292016";
	public static final String DATE_VALID_AFTER = "12012016";
	public static final String DATE_VALID_IN_RANGE = "11302016";
	public static final String DATE_VALID_OUT_OF_RANGE = "01012017";
	public static final String DATE_INVALID = "11312016";	//Past Date
	public static final String DATE_INVALID_LENGTH = "123456789";
	public static final String DATE_INVALID_CHARACTERS = "MMDDYYYY";
		
	public static final String TIME_VALID_BEFORE = "12:00";
	public static final String TIME_VALID_AFTER = "12:15";
	public static final String TIME_INVALID = "12:99";
	public static final String TIME_INVALID_LENGTH = "12:009";
	public static final String TIME_INVALID_CHARACTERS = "HH:MM";
}//Constants class