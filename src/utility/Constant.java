package utility;

import org.openqa.selenium.WebDriver;

public class Constant {
	    public static final String URL = "http://tutorialsninja.com/demo/";
	    public static final String Username = "testuser_1";
	    public static final String Password ="Test@123";
		public static final String Path_TestData = "C:\\Users\\Mukesh\\git\\OnlineStore\\src\\testData\\TestData.xlsx";
		//public static final String File_TestData = "TestData.xlsx";
		public static final String RegisterAccount_Page= "http://tutorialsninja.com/demo/index.php?route=account/register";
		
		public static final String[] SystemMenu_elements= {"Desktops", "Laptops & Notebooks", "Components", "Tablets", "Software", "Phones & PDAs", "Cameras", "MP3 Players", "Promit"};
		public static final String Contact_No= "http://tutorialsninja.com/demo/index.php?route=information/contact";
		public static final String[] MyAccount_elements= {"Register", "Login"};
		public static final String Login_Page= "http://tutorialsninja.com/demo/index.php?route=account/login";
		
		public static final String RegisterAccount_msg= "If you already have an account with us, please login at the ";
		public static final String NewCustomer_msg= "By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.";
		//Test Data Sheet Columns
		public static final int Col_TestCaseName = 0;	
		public static final int Col_Test_Data =1 ;
		public static final int Col_Result = 2;
		public static final String Path_ScreenShot = "D://ToolsQA//OnlineStore//src//Screenshots//";
	}
