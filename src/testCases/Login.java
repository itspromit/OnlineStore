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

public class Login {

	WebDriver driver;
	LogIn_Page Login;
	LandingPage LPage;
	int y;

	@BeforeClass
	public void fnCheck_RegisterAccount_page() {

		try {

			if (driver == null) {
				driver = Utils.Return_driver();
				Login = new LogIn_Page(driver);

				if (driver.getTitle().contains("Account Login")) {
					Log.info("User on Login page");
				} else {
					Log.info("User not on Login page");
					driver.navigate().to(Constant.Login_Page);

				}
			} else {
				if (driver.getTitle().contains("Account Login")) {
					Log.info("User on Login page");
				} else {
					Log.info("User not on Login page");
					driver.navigate().to(Constant.Login_Page);

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
			Login = null;
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}

	}

	@BeforeMethod
	public void Before_method(Method test_method) {
		try {
			if (driver.getTitle().contains("Account Login")) {

			} else {

				driver.navigate().to(Constant.Login_Page);

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
						CommonFunctionandEvents.fnGetElementAttribute(Login.Home_menu, "class"), "fa fa-home")) {
					Log.info("Home menu is being displyed correctly");
				} else {
					Log.info("Incorrect name of Home menu is being displyed");
				}
			} else {
				Log.info("Home menu is not getting displayed");
			}
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
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), "Your Store")) {
						Log.info("User navigated to Landing page upon clicking on Home menu");
					} else {
						Log.info("User navigated to incorrect page upon clicking on Home menu");
					}
				} else {
					Log.info("Shopping Cart menu is not clickable");
				}
			} else {
				Log.info("Home menu is not getting displayed");
			}
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
						"Account")) {
					Log.info("Account menu is being displyed correctly");
				} else {
					Log.info("Incorrect name of Account menu is being displyed");
				}
			} else {
				Log.info("Account menu is not getting displayed");
			}
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
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), "Account Login")) {
						Log.info("User navigated to Login page upon clicking on Account menu");
					} else {
						Log.info("User navigated to incorrect page upon clicking on Account menu");
					}
				} else {
					Log.info("Account menu is not clickable");
				}
			} else {
				Log.info("Account menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC45_fnCheck_Login_Page_Login_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.Login_menu)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(Login.Login_menu), "Login")) {
					Log.info("Login menu is being displyed correctly");
				} else {
					Log.info("Incorrect name of Login menu is being displyed");
				}
			} else {
				Log.info("Login menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC26_fnCheck_Login_Page_Home_menu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(Login.Login_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, Login.Login_menu)) {
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), "Account Login")) {
						Log.info("User navigated to Login page upon clicking on Login menu");
					} else {
						Log.info("User navigated to incorrect page upon clicking on Login menu");
					}
				} else {
					Log.info("Login menu is not clickable");
				}
			} else {
				Log.info("Login menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

}
