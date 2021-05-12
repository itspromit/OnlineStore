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
	int y;

	@BeforeClass
	public void fnCheck_RegisterAccount_page() {

		try {

			if (driver == null) {
				driver = Utils.Return_driver();
				R_Acc = new RegisterAccount_Page(driver);

				if (driver.getTitle().contains("Register Account")) {
					Log.info("User on Register Account page");
				} else {
					Log.info("User not on RegisterAccount page");
					driver.navigate().to(Constant.RegisterAccount_Page);

				}
			} else {
				if (driver.getTitle().contains("Register Account")) {
					Log.info("User on RegisterAccount page");
				} else {
					Log.info("User not on RegisterAccount page");
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
			if (driver.getTitle().contains("Register Account")) {

			} else {

				driver.navigate().to(Constant.RegisterAccount_Page);

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
	public void TC20_fnCheck_RegisterAccount_Page_title() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Page_Header)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Page_Header),
						"Register Account")) {
					Log.info("Page title is being displyed correctly");
				} else {
					Log.info("Incorrect Page title is being displyed");
				}
			} else {
				Log.info("Page title is not getting displayed");
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
	public void TC22_fnCheck_RegisterAccount_Page_Home_menu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Home_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, R_Acc.Home_menu)) {
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
	public void TC23_fnCheck_RegisterAccount_Page_Account_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Account_menu)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Account_menu),
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
	public void TC24_fnCheck_RegisterAccount_Page_Account_menu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Account_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, R_Acc.Account_menu)) {
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
	public void TC25_fnCheck_RegisterAccount_Page_Register_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Register_menu)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Register_menu), "Register")) {
					Log.info("Register menu is being displyed correctly");
				} else {
					Log.info("Incorrect name of Register menu is being displyed");
				}
			} else {
				Log.info("Register menu is not getting displayed");
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
					} else {
						Log.info("User navigated to incorrect page upon clicking on Register menu");
					}
				} else {
					Log.info("Register menu is not clickable");
				}
			} else {
				Log.info("Register menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

}
