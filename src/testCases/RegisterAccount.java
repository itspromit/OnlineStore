package testCases;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pageObjects.Landing_Page;
import pageObjects.RegisterAccount_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class RegisterAccount {

	WebDriver driver;
	RegisterAccount_Page R_Acc;
	LandingPage LPage;
	int y;
	ExtentReports Report;
	ExtentTest Test;

	@BeforeClass
	public void fnCheck_RegisterAccount_page() {

		try {

			if (driver == null) {
				driver = Utils.Return_driver();
				R_Acc = new RegisterAccount_Page(driver);
				// LPage= new LandingPage();
				Report = LandingPage.Return_Report();

				if (driver.getTitle().contains("Register Account")) {

				} else {

					driver.navigate().to(Constant.RegisterAccount_Page);

				}
			} else {
				if (driver.getTitle().contains("Register Account")) {

				} else {

					driver.navigate().to(Constant.RegisterAccount_Page);

				}
			}

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}

	}

	@AfterClass
	public void fnDelete_PageObject() {
		try {
			R_Acc = null;
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}

	}

	@BeforeMethod
	public void Before_method(Method test_method) {
		try {
			Test = Report.startTest(test_method.getName());
			if (driver.getTitle().contains("Register Account")) {
				Log.info("User on Register Account page");
				Test.log(LogStatus.INFO, "User on Register Account page");

			} else {
				Log.info("User not on RegisterAccount page");
				Test.log(LogStatus.INFO, "User not on RegisterAccount page");
				driver.navigate().to(Constant.RegisterAccount_Page);
				Log.info("User now navigated to Register Account page");
				Test.log(LogStatus.INFO, "User now navigated to Register Account page");

			}
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Log.startTestCase(test_method.getName());

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
	public void TC20_fnCheck_RegisterAccount_Page_title() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Page_Header)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Page_Header),
						"Register Account")) {
					Log.info("Page title is being displyed correctly");
					Test.log(LogStatus.PASS, "Page title is being displyed correctly");
				} else {
					Log.info("Incorrect Page title is being displyed");
					Test.log(LogStatus.FAIL, "Incorrect Page title is being displyed");
				}
			} else {
				Log.info("Page title is not getting displayed");
				Test.log(LogStatus.FAIL, "Page title is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC21_fnCheck_RegisterAccount_Page_Home_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Home_menu)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementAttribute(R_Acc.Home_menu, "class"), "fa fa-home")) {
					Log.info("Home menu is being displyed correctly");
					Test.log(LogStatus.PASS, "Home menu is being displyed correctly");
				} else {
					Log.info("Incorrect name of Home menu is being displyed");
					Test.log(LogStatus.FAIL, "Incorrect name of Home menu is being displyed");
				}
			} else {
				Log.info("Home menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Home menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC22_fnCheck_RegisterAccount_Page_Home_menu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Home_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, R_Acc.Home_menu)) {
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), "Your Store")) {
						Log.info("User navigated to Landing page upon clicking on Home menu");
						Test.log(LogStatus.PASS, "User navigated to Landing page upon clicking on Home menu");
					} else {
						Log.info("User navigated to incorrect page upon clicking on Home menu");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page upon clicking on Home menu");
					}
				} else {
					Log.info("Home menu is not clickable");
					Test.log(LogStatus.FAIL, "Home menu is not clickable");
				}
			} else {
				Log.info("Home menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Home menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC23_fnCheck_RegisterAccount_Page_Account_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Account_menu)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Account_menu),
						"Account")) {
					Log.info("Account menu is being displyed correctly");
					Test.log(LogStatus.PASS, "Account menu is being displyed correctly");
				} else {
					Log.info("Incorrect name of Account menu is being displyed");
					Test.log(LogStatus.FAIL, "Incorrect name of Account menu is being displyed");
				}
			} else {
				Log.info("Account menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Account menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC24_fnCheck_RegisterAccount_Page_Account_menu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Account_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, R_Acc.Account_menu)) {
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), "Account Login")) {
						Log.info("User navigated to Login page upon clicking on Account menu");
						Test.log(LogStatus.PASS, "User navigated to Login page upon clicking on Account menu");
					} else {
						Log.info("User navigated to incorrect page upon clicking on Account menu");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page upon clicking on Account menu");
					}
				} else {
					Log.info("Account menu is not clickable");
					Test.log(LogStatus.FAIL, "Account menu is not clickable");
				}
			} else {
				Log.info("Account menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Account menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC25_fnCheck_RegisterAccount_Page_Register_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Register_menu)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Register_menu), "Register")) {
					Log.info("Register menu is being displyed correctly");
					Test.log(LogStatus.PASS, "Register menu is being displyed correctly");
				} else {
					Log.info("Incorrect name of Register menu is being displyed");
					Test.log(LogStatus.FAIL, "Incorrect name of Register menu is being displyed");
				}
			} else {
				Log.info("Register menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Register menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC26_fnCheck_RegisterAccount_Page_Home_menu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Register_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, R_Acc.Register_menu)) {
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), "Register Account")) {
						Log.info("User navigated to Register Account page upon clicking on Register menu");
						Test.log(LogStatus.PASS,
								"User navigated to Register Account page upon clicking on Register menu");
					} else {
						Log.info("User navigated to incorrect page upon clicking on Register menu");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page upon clicking on Register menu");
					}
				} else {
					Log.info("Register menu is not clickable");
					Test.log(LogStatus.FAIL, "Register menu is not clickable");
				}
			} else {
				Log.info("Register menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Register menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC27_fnCheck_RegisterAccount_Page_RegisterAccount_msg() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Register_Account_msg)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementText(R_Acc.Register_Account_msg),
						Constant.RegisterAccount_msg)) {
					Log.info("Register Account message getting displayed");
					Test.log(LogStatus.PASS, "Register Account message getting displayed");
				} else {
					Log.info("Incorrect Register Account message getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Register Account message getting displayed");
				}

			} else {
				Log.info("Register Account message not getting displayed");
				Test.log(LogStatus.FAIL, "Register Account message not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC28_fnCheck_RegisterAccount_Page_LoginPage_Link() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.LoginPage_link)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementText(R_Acc.Register_Account_msg),
						Constant.RegisterAccount_msg)) {
					Log.info("Login Page link getting displayed");
					Test.log(LogStatus.PASS, "Login Page link getting displayed");
				} else {
					Log.info("Incorrect name of Login Page link getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect name of Login Page link getting displayed");
				}

			} else {
				Log.info("Login Page link not getting displayed");
				Test.log(LogStatus.FAIL, "Login Page link not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC29_fnCheck_RegisterAccount_Page_LoginPage_Link_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.LoginPage_link)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, R_Acc.LoginPage_link)) {
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), "Account Login")) {
						Log.info("User navigated to Login page upon clicking on Login Page link");
						Test.log(LogStatus.PASS, "User navigated to Login page upon clicking on Login Page link");
					} else {
						Log.info("User navigated to incorrect page upon clicking on Login Page link");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page upon clicking on Login Page link");
					}
				} else {
					Log.info("Login Page link is not clickable");
					Test.log(LogStatus.FAIL, "Login Page link is not clickable");
				}
			} else {
				Log.info("Login Page link is not getting displayed");
				Test.log(LogStatus.FAIL, "Login Page link is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC30_fnCheck_RegisterAccount_Page_PersonalDetails_section() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.PersonalDetails_section)) {
				Log.info("Personal Details section getting displayed");
				Test.log(LogStatus.PASS, "Personal Details section getting displayed");
			} else {
				Log.info("Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "Personal Details section not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC31_fnCheck_RegisterAccount_Page_PersonalDetails_section_Header() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.PersonalDetails_header)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementText(R_Acc.PersonalDetails_header),
						"Your Personal Details")) {
					Log.info("Personal Details section header getting displayed");
					Test.log(LogStatus.PASS, "Personal Details section header getting displayed");
				} else {
					Log.info("Incorrect Personal Details section header getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Personal Details section header getting displayed");
				}

			} else {
				Log.info("Personal Details section header not getting displayed");
				Test.log(LogStatus.FAIL, "Personal Details section header not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC32_fnCheck_RegisterAccount_Page_PersonalDetails_section_FirstName_label() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.FirstName_label)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementText(R_Acc.FirstName_label),
						"First Name")) {
					Log.info("First Name field label in Personal Details section getting displayed");
					Test.log(LogStatus.PASS, "First Name field label in Personal Details section getting displayed");
				} else {
					Log.info("Incorrect First Name field label in Personal Details section getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect First Name field label in Personal Details section getting displayed");
				}

			} else {
				Log.info("First Name field label in Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "First Name field label in Personal Details section not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC33_fnCheck_RegisterAccount_Page_PersonalDetails_section_FirstName_field() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.FirstName_field)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementAttribute(R_Acc.FirstName_field, "placeholder"),
						"First Name")) {
					Log.info("First Name field in Personal Details section getting displayed");
					Test.log(LogStatus.PASS, "First Name field in Personal Details section getting displayed");
				} else {
					Log.info("Incorrect First Name field label in Personal Details section getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect First Name field in Personal Details section getting displayed");
				}

			} else {
				Log.info("First Name field in Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "First Name field in Personal Details section not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC34_fnCheck_RegisterAccount_Page_PersonalDetails_section_LastName_label() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.LastName_label)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementText(R_Acc.LastName_label),
						"Last Name")) {
					Log.info("Last Name field label in Personal Details section getting displayed");
					Test.log(LogStatus.PASS, "Last Name field label in Personal Details section getting displayed");
				} else {
					Log.info("Incorrect Last Name field label in Personal Details section getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Last Name field label in Personal Details section getting displayed");
				}

			} else {
				Log.info("Last Name field label in Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "Last Name field label in Personal Details section not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC35_fnCheck_RegisterAccount_Page_PersonalDetails_section_LastName_field() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.LastName_field)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementAttribute(R_Acc.LastName_field, "placeholder"),
						"Last Name")) {
					Log.info("Last Name field in Personal Details section getting displayed");
					Test.log(LogStatus.PASS, "Last Name field in Personal Details section getting displayed");
				} else {
					Log.info("Incorrect Last Name field label in Personal Details section getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Last Name field in Personal Details section getting displayed");
				}

			} else {
				Log.info("Last Name field in Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "Last Name field in Personal Details section not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

}
