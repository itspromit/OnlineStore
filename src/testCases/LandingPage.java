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
				 CommonFunctionandEvents.fncreateArray_Elements(LP.Menu_bar_elements);
					Log.info("All system menu options getting displayed correctly");
				
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
	public void TC05_fnCheck_LandingPage_ContactNo_icon() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Contact_No_icon)) {
				Log.info("Contact No icon getting displayed");
			} else {
				Log.info("Contact No icon is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC06_fnCheck_LandingPage_ContactNo_Page() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Contact_No_icon)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, LP.Contact_No_icon_link)) {
					if (CommonFunctionandEvents.Window_count(driver)) {
						if (CommonFunctionandEvents.New_Tab(driver, Constant.Contact_No)) {
							Log.info("Correct tab is opened");
						} else {
							Log.info("Incorrect tab is opened");
						}
					} else {
						if (CommonFunctionandEvents.fnTextContains(driver.getCurrentUrl(), Constant.Contact_No)) {
							Log.info("User Navigated to Contact No page");
						} else {
							Log.info("User navigated to incorrect page");
						}
					}

				} else {
					Log.info("User not navigated to Contact No page");
				}

			} else {
				Log.info("Contact No icon is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC07_fnCheck_LandingPage_MyAccount_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.MyAccount_menu)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(LP.MyAccount_menu),
						"My Account")) {
					Log.info("My Account menu is getting displayed correctly");
				} else {
					Log.info("Incorrect name for My Account menu getting displayed");
				}

			} else {
				Log.info("My Account menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC08_fnCheck_LandingPage_MyAccount_menu_dropdown() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.MyAccount_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, LP.MyAccount_menu)) {
					if (CommonFunctionandEvents.fnIsElementDisplayed(LP.MyAccount_dropdown)) {
						Log.info("My Account menu dropdown is getting displayed correctly");
					} else {
						Log.info("My Account menu dropdown not getting displayed");
					}
				} else {
					Log.info("My Account menu is not clickable");
				}

			} else {
				Log.info("My Account menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}
	
	@Test
	public void TC10_fnCheck_LandingPage_WishList_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.WishList_menu)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(LP.WishList_menu),
						"Wish List")) {
					Log.info("Wish List menu is getting displayed correctly");
				} else {
					Log.info("Incorrect name for Wish List menu getting displayed");
				}

			} else {
				Log.info("Wish List menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}
	
	@Test
	public void TC11_fnCheck_LandingPage_WishList_menu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.WishList_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, LP.WishList_menu)) {
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), "Account Login")) {
						Log.info("User navigated to the correct page i.e. Login page");
					} else {
						Log.info("User navigated to incorrect page");
					}
				} else {
					Log.info("Wish List menu is not clickable");
				}

			} else {
				Log.info("Wish List menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}
	
	@Test
	public void TC12_fnCheck_LandingPage_ShoppingCart_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.ShoppingCart_menu)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(LP.ShoppingCart_menu),
						"Shopping Cart")) {
					Log.info("Shopping Cart menu is getting displayed correctly");
				} else {
					Log.info("Incorrect name for Shopping Cart menu getting displayed");
				}

			} else {
				Log.info("Shopping Cart menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}
	
	@Test
	public void TC13_fnCheck_LandingPage_ShoppingCart_menu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.ShoppingCart_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, LP.ShoppingCart_menu)) {
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), "Shopping Cart")) {
						Log.info("User navigated to the Shopping Cart page");
					} else {
						Log.info("User navigated to incorrect page");
					}
				} else {
					Log.info("Shopping Cart menu is not clickable");
				}

			} else {
				Log.info("Shopping Cart menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC14_fnCheck_LandingPage_Checkout_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Checkout_menu)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(LP.Checkout_menu),
						"Checkout")) {
					Log.info("Checkout menu is getting displayed correctly");
				} else {
					Log.info("Incorrect name for Checkout menu getting displayed");
				}

			} else {
				Log.info("Checkout menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}
	
	@Test
	public void TC15_fnCheck_LandingPage_Checkout_menu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Checkout_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, LP.Checkout_menu)) {
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), "Shopping Cart")) {
						Log.info("User navigated to correct page i.e. the Shopping Cart page");
					} else {
						Log.info("User navigated to incorrect page");
					}
				} else {
					Log.info("Checkout Cart menu is not clickable");
				}

			} else {
				Log.info("Checkout Cart menu is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}


}
