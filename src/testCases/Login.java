package testCases;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pageObjects.Landing_Page;
import pageObjects.RegisterAccount_Page;
import pageObjects.LogIn_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utility.CommonFunctionandEvents;
import utility.ExtentManager;
import utility.Utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utility.Log;
import utility.Constant;
import utility.ExcelUtils;

public class Login {

	WebDriver driver;
	LogIn_Page Login;
	LandingPage LPage;
	int y;
	ExtentReports Report;
	ExtentTest Test;
	boolean Result;
	String Str;
	String[] S;

	@BeforeClass
	public void fnCheck_RegisterAccount_page() {

		try {

			if (driver == null) {
				driver = Utils.Return_driver();
				Login = new LogIn_Page(driver);
				//LPage= new LandingPage();
				Report= LandingPage.Return_Report();

				if (driver.getTitle().contains("Account Login")) {

				} else {
					driver.navigate().to(Constant.Login_Page);

				}
			} else {
				if (driver.getTitle().contains("Account Login")) {

				} else {

					driver.navigate().to(Constant.Login_Page);

				}
			}
			ExcelUtils.setExcelFile(Constant.Path_TestData, "Login");

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}

	}

	@AfterClass
	public void fnDelete_PageObject() {
		try {
			Login = null;
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}

	}

	@BeforeMethod
	public void Before_method(Method test_method) {

		try {
			Test = Report.startTest(test_method.getName());
			if (driver.getTitle().contains("Account Login")) {
				Log.info("User on Login page");
				Test.log(LogStatus.INFO, "User on Login page");

			} else {
				Log.info("User not on Login page");
				Test.log(LogStatus.INFO, "User not on Login page");
				driver.navigate().to(Constant.Login_Page);
				Log.info("User navigated to Login page");
				Test.log(LogStatus.INFO, "User navigated to Login page");

			}
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Log.startTestCase(test_method.getName());
			
			for(int i=0; i<ExcelUtils.getRowUsed();i++) {
				if (ExcelUtils.getCellData(i, Constant.Col_TestCaseName).contentEquals(test_method.getName())) {
					Str= ExcelUtils.getCellData(i, Constant.Col_Test_Data);
					break;
				}
			}
			
			if (Str.contains(",")) {
				S=CommonFunctionandEvents.fnStringSplit(Str, ",");
			}

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@AfterMethod
	public void After_method(Method test_method) {
		try {
			Log.endTestCase(test_method.getName());
			Report.endTest(Test);
			Report.flush();
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}

	}

	@Test
	public void TC41_fnCheck_Login_Page_Home_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.Home_menu)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementAttribute(Login.Home_menu, "class"), Str)) {
					Result= true;
					Log.info("Home menu is being displyed correctly");
					Test.log(LogStatus.PASS, "Home menu is being displyed correctly");
					
					
				} else {
					Result= false;
					Log.info("Incorrect name of Home menu is being displyed");
					Test.log(LogStatus.FAIL, "Incorrect name of Home menu is being displyed");
					
				}
			} else {
				Result= false;
				Log.info("Home menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Home menu is not getting displayed");
				
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC42_fnCheck_Login_Page_Home_menu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.Home_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, Login.Home_menu)) {
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result= true;
						Log.info("User navigated to Landing page upon clicking on Home menu");
						Test.log(LogStatus.PASS, "User navigated to Landing page upon clicking on Home menu");
					} else {
						Result= false; 
						Log.info("User navigated to incorrect page upon clicking on Home menu");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page upon clicking on Home menu");
					}
				} else {
					Result= false;
					Log.info("Shopping Cart menu is not clickable");
					Test.log(LogStatus.FAIL, "Shopping Cart menu is not clickable");
				}
			} else {
				Result= false;
				Log.info("Home menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Home menu is not getting displayed");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC43_fnCheck_Login_Page_Account_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.Account_menu)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(Login.Account_menu),
						Str)) {
					Result= true;
					Log.info("Account menu is being displyed correctly");
					Test.log(LogStatus.PASS, "Account menu is being displyed correctly");
				} else {
					Result= false;
					Log.info("Incorrect name of Account menu is being displyed");
					Test.log(LogStatus.FAIL, "Incorrect name of Account menu is being displyed");
				}
			} else {
				Result= false;
				Log.info("Account menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Account menu is not getting displayed");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC44_fnCheck_Login_Page_Account_menu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.Account_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, Login.Account_menu)) {
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result= true;
						Log.info("User navigated to Login page upon clicking on Account menu");
						Test.log(LogStatus.PASS, "User navigated to Login page upon clicking on Account menu");
					} else {
						Result= false;
						Log.info("User navigated to incorrect page upon clicking on Account menu");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page upon clicking on Account menu");
					}
				} else {
					Result= false;
					Log.info("Account menu is not clickable");
					Test.log(LogStatus.FAIL, "Account menu is not clickable");
				}
			} else {
				Result= false;
				Log.info("Account menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Account menu is not getting displayed");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC45_fnCheck_Login_Page_Login_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.Login_menu)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(Login.Login_menu),
						Str)) {
					Result= true;
					Log.info("Login menu is being displyed correctly");
					Test.log(LogStatus.PASS, "Login menu is being displyed correctly");
				} else {
					Result= false;
					Log.info("Incorrect name of Login menu is being displyed");
					Test.log(LogStatus.FAIL, "Incorrect name of Login menu is being displyed");
				}
			} else {
				Result= false;
				Log.info("Login menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Login menu is not getting displayed");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC46_fnCheck_Login_Page_Home_menu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.Login_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, Login.Login_menu)) {
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result= true;
						Log.info("User navigated to Login page upon clicking on Login menu");
						Test.log(LogStatus.PASS, "User navigated to Login page upon clicking on Login menu");
					} else {
						Result= false;
						Log.info("User navigated to incorrect page upon clicking on Login menu");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page upon clicking on Login menu");
					}
				} else {
					Result= false;
					Log.info("Login menu is not clickable");
					Test.log(LogStatus.FAIL, "Login menu is not clickable");
				}
			} else {
				Result= false;
				Log.info("Login menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Login menu is not getting displayed");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}
	
	@Test
	public void TC47_fnCheck_Login_Page_NewCustomer_section() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.NewCustomer_menu)) {
				Result= true;
				Log.info("New Customer section getting displayed");
				Test.log(LogStatus.PASS, "New Customer section getting displayed");
			} else {
				Result= false;
				Log.info("New Customer section not getting displayed");
				Test.log(LogStatus.FAIL, "New Customer section not getting displayed");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}
	
	@Test
	public void TC48_fnCheck_Login_Page_NewCustomer_section_header() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.NewCustomer_header)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementText(Login.NewCustomer_header),
						Str)) {
					Result= true;
					Log.info("New Customer section header getting displayed");
					Test.log(LogStatus.PASS, "New Customer section header getting displayed");
				} else {
					Result= false;
					Log.info("Incorrect New Customer section header getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect New Customer section header getting displayed");
				}

			} else {
				Result= false;
				Log.info("New Customer section header not getting displayed");
				Test.log(LogStatus.FAIL, "New Customer section header not getting displayed");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC49_fnCheck_Login_Page_NewCustomer_section_RegisterAccount_label() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.RegisterAccount_label)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementText(Login.RegisterAccount_label),
						Str)) {
					Result= true;
					Log.info("New Customer section Register Account label getting displayed");
					Test.log(LogStatus.PASS, "New Customer section Register Account label getting displayed");
				} else {
					Result= false;
					Log.info("Incorrect New Customer section Register Account label getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect New Customer section Register Account label getting displayed");
				}

			} else {
				Result= false;
				Log.info("New Customer section Register Account label not getting displayed");
				Test.log(LogStatus.FAIL, "New Customer section Register Account label  not getting displayed");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC50_fnCheck_Login_Page_NewCustomer_section_text() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.NewCustomer_text)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementText(Login.NewCustomer_text),
						Constant.NewCustomer_msg)) {
					Result= true;
					Log.info("New Customer section text getting displayed");
					Test.log(LogStatus.PASS, "New Customer section text getting displayed");
				} else {
					Result= false;
					Log.info("Incorrect New Customer section text getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect New Customer section text getting displayed");
				}

			} else {
				Result= false;
				Log.info("New Customer section text not getting displayed");
				Test.log(LogStatus.FAIL, "New Customer section text not getting displayed");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}
	
	@Test
	public void TC51_fnCheck_Login_Page_NewCustomer_section_Continue_button() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.Continue_button)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementText(Login.Continue_button),
						Str)) {
					Result= true;
					Log.info("Continue button in New Customer section getting displayed");
					Test.log(LogStatus.PASS, "Continue button in New Customer section getting displayed");
				} else {
					Result= false;
					Log.info("Incorrect name of Continue button in New Customer section getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect name of Continue button in New Customer section getting displayed");
				}

			} else {
				Result= false;
				Log.info("Continue button in New Customer section not getting displayed");
				Test.log(LogStatus.FAIL, "Continue button in New Customer section not getting displayed");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC52_fnCheck_Login_Page_NewCustomer_section_Continue_button_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.Continue_button)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, Login.Continue_button)) {
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result= true;
						Log.info("User navigated to Register Account page upon clicking on Continue button");
						Test.log(LogStatus.PASS, "User navigated to Login page upon clicking on Login menu");
					} else {
						Result= false;
						Log.info("User navigated to incorrect page upon clicking on Continue button");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page upon clicking on Continue button");
					}
				} else {
					Result= false;
					Log.info("Continue button is not clickable");
					Test.log(LogStatus.FAIL, "Continue button is not clickable");
				}
			} else {
				Result= false;
				Log.info("Continue button in New Customer section not getting displayed");
				Test.log(LogStatus.FAIL, "Continue button in New Customer section not getting displayed");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}



}
