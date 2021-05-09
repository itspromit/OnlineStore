package testCases;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pageObjects.Landing_Page;
import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
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

public class LandingPage {

	WebDriver driver;
	Landing_Page LP;
	WebDriver existing_driver;
	int x = 0;

	@BeforeSuite
	public void fnCheckforActiveBrowser() {
		try {

			DOMConfigurator.configure("log4j.xml");
			driver = Utils.OpenBrowser(driver);

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}

	}

	@BeforeClass
	public void fnCheck() {
		try {
			LP = new Landing_Page(driver);
			if (driver.getTitle().contains("Your Store")) {
				Log.info("User on landing page");

			} else {

				driver.get(Constant.URL);
				Log.info("User navigating to landing page");

			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}

	}

	@AfterClass
	public void fnDelete_PageObject() {
		try {
			LP = null;
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}

	}

	@AfterSuite
	public void Browser_Close() {
		try {
			driver.quit();
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@BeforeMethod
	public void Before_method(Method test_method) {
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
	public void TC01_fnCheck_LandingPage_title() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.YourStore)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(LP.YourStore),
						"Your Store")) {
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
	public void TC02_fnCheck_LandingPage_SystemMenu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Menu_bar)) {
				Log.info("Menu bar is being displyed");
			} else {
				Log.info("Menu bar is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC03_fnCheck_LandingPage_SystemMenu_Elements() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Menu_bar)) {
				if (CommonFunctionandEvents.fnValidateArray_Elements(LP.Menu_bar_elements,
						Constant.SystemMenu_elements)) {
					Log.info("All system menu options getting displayed correctly");
				} else {
					Log.info("All system menu options are not getting displayed correctly");
				}

			} else {
				Log.info("Menu bar is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC04_fnCheck_LandingPage_ContactNo_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Contact_No)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(LP.Contact_No),
						"123456789")) {
					Log.info("Contact No is getting displayed correctly");
				} else {
					Log.info("Incorrect Contact No getting displayed");
				}

			} else {
				Log.info("Contact No is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC05_fnCheck_LandingPage_ContactNo_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Contact_No)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(LP.Contact_No),
						"123456789")) {
					Log.info("Contact No is getting displayed correctly");
				} else {
					Log.info("Incorrect Contact No getting displayed");
				}

			} else {
				Log.info("Contact No is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC06_fnCheck_LandingPage_ContactNo_Page() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Contact_No)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, LP.Contact_No)) {
					if (CommonFunctionandEvents.Window_count(driver)) {
						if (CommonFunctionandEvents.New_Tab(driver, Constant.Contact_No)) {
							Log.info("Correct tab is opened");
						} else {
							Log.info("Incorrect tab is opened");
						}
					}
					Log.info("Contact No is getting displayed correctly");
				} else {
					Log.info("Incorrect Contact No getting displayed");
				}

			} else {
				Log.info("Contact No is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

}
