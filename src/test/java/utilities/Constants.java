package utilities;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class Constants 
{
	static Random r = new Random();
	static int randomInt = r.nextInt(1000);
	//DATA FOR REGISDTRATION PROCESS

	private static String prefix = RandomStringUtils.randomAlphanumeric(8);
	private static String postfix = RandomStringUtils.randomAlphanumeric(8);
	private static String lastNameRandom = RandomStringUtils.randomAlphanumeric(12);
	private static String addressRandom = RandomStringUtils.randomAlphanumeric(15) + " " + randomInt;
	
	
	public static final String EMAIL_ADDRESS_GENERATED =  prefix +"@test." +postfix ;
	
	
	public static final String FIRST_NAME ="Edzio";
	public static final String SEC_NAME = "Laura" + lastNameRandom;
	public static final String PASSWORD ="test123";
	public static final String ADDRESS = addressRandom;
	public static final String CITY = "Dublin";
	public static final String STATE = "Iowa";
	public static final String POSTCODE= "00000";
 	public static final String COUNTRY ="United States";
 	public static final String PHONE_NUMBER ="34500000";
	
 	///////////////////////////////////////
 	public static final String EXCEL_DIRECTORY ="//TestData.xlsx";
 	public static final String EXCEL_FIRST_TAB="reg";
	public static final String EXCEL_SEC_TAB="log";
 	
}
