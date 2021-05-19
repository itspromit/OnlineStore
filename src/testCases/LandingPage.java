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

//import utility.CommonFunctionandEvents;
//import utility.ExtentManager;
import utility.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import utility.Log;
//import utility.Constant;

public class LandingPage {

	WebDriver driver;
	Landing_Page LP;
	WebDriver existing_driver;
	ExtentReports Report;
	ExtentTest Test;
	boolean Result = false;
	static ExtentReports Report_old;
	String Str;
	String[] S;

	@BeforeSuite
	public void fnCheckforActiveBrowser() {
		try {
			Report = ExtentManager.getInstance();
			Report_old = Report;
			DOMConfigurator.configure("log4j.xml");
			driver = Utils.OpenBrowser(driver);

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}

	}

	public static ExtentReports Return_Report() {
		return Report_old;
	}

	@BeforeClass
	public void fnCheck() {
		try {
			LP = new Landing_Page(driver);
			if (driver.getTitle().contains("Your Store")) {
			} else {
				driver.get(Constant.URL);
			}
			ExcelUtils.setExcelFile(Constant.Path_TestData, "Landing Page");
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
			Test = Report.startTest(test_method.getName());
			if (driver.getTitle().contains("Your Store")) {
				Log.info("User on landing page");
				Test.log(LogStatus.INFO, "User on Landing page");

			} else {
				Log.info("User not on landing page");
				Test.log(LogStatus.INFO, "User not on landing page");
				driver.get(Constant.URL);
				Log.info("User navigating to landing page");
				Test.log(LogStatus.INFO, "User not on landing page");

			}
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Log.startTestCase(test_method.getName());

			for (int i = 0; i < ExcelUtils.getRowUsed(); i++) {
				if (ExcelUtils.getCellData(i, Constant.Col_TestCaseName).contentEquals(test_method.getName())) {
					Str = ExcelUtils.getCellData(i, Constant.Col_Test_Data);
					break;
				}
			}

			if (Str.contains(",")) {
				S = CommonFunctionandEvents.fnStringSplit(Str, ",");
			}

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@AfterMethod
	public void After_method(Method test_method) {
		try {
			Thread.sleep(3000);
			Utils.takeScreenshot(driver, test_method.getName());
			Log.endTestCase(test_method.getName());
			Report.endTest(Test);
			Report.flush();
			driver.navigate().refresh();
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
						Str)) {
					Result = true;
					Log.info("Page title is being displyed correctly");
					Test.log(LogStatus.PASS, "Page title is being displyed correctly");
				} else {
					Result = false;
					Log.info("Incorrect Page title is being displyed");
					Test.log(LogStatus.FAIL, "Incorrect Page title is being displyed");
				}
			} else {
				Result = false;
				Log.info("Page title is not getting displayed");
				Test.log(LogStatus.FAIL, "Page title is not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.YourStore);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.YourStore);
			}

			Assert.assertEquals(Result, true);

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC02_fnCheck_LandingPage_SystemMenu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Menu_bar)) {
				Result = true;
				Log.info("Menu bar is being displyed");
				Test.log(LogStatus.PASS, "Menu bar is being displyed");

			} else {
				Result = false;
				Log.info("Menu bar is not getting displayed");
				Test.log(LogStatus.FAIL, "Menu bar is not getting displayed");
			}
			if (Result) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Menu_bar);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');", LP.Menu_bar);
			}
			
			Assert.assertEquals(Result, true);
			

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC03_fnCheck_LandingPage_SystemMenu_Elements() {
		String[] S1 = null;
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Menu_bar)) {
				if (CommonFunctionandEvents
						.fnValidateArray(CommonFunctionandEvents.fncreateArray_Elements(LP.Menu_bar_elements, S1), S)) {
					Result = true;
					Log.info("All System Menu bar elements are getting correctly displayed");
					Test.log(LogStatus.PASS, "All System Menu bar elements are getting correctly displayed");
				} else {
					Result = false;
					Log.info("All System Menu bar elements are not getting correctly displayed");
					Test.log(LogStatus.FAIL, "All System Menu bar elements are not getting correctly displayed");
				}

			} else {
				Result = false;
				Log.info("Menu bar is not getting displayed");
				Test.log(LogStatus.FAIL, "Menu bar is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Menu_bar);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.Menu_bar);
			}
			
			Assert.assertEquals(Result, true);
			

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
						Str)) {
					Result = true;
					Log.info("Contact No is getting displayed correctly");
					Test.log(LogStatus.PASS, "Contact No is getting displayed correctly");
				} else {
					Result = false;
					Log.info("Incorrect Contact No getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Contact No getting displayed");
				}

			} else {
				Result = false;
				Log.info("Contact No is not getting displayed");
				Test.log(LogStatus.FAIL, "Contact No is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Contact_No);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.Contact_No);
			}
			
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC05_fnCheck_LandingPage_ContactNo_icon() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Contact_No_icon)) {
				Result = true;
				Log.info("Contact No icon getting displayed");
				Test.log(LogStatus.PASS, "Contact No icon getting displayed");
			} else {
				Result = false;
				Log.info("Contact No icon is not getting displayed");
				Test.log(LogStatus.FAIL, "Contact No icon is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Contact_No_icon);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.Contact_No_icon);
			}
			Assert.assertEquals(Result, true);
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
							Result = true;
							Log.info("Correct tab is opened");
							Test.log(LogStatus.PASS, "Correct tab is opened");
						} else {
							Result = false;
							Log.info("Incorrect tab is opened");
							Test.log(LogStatus.FAIL, "Incorrect tab is opened");
						}
					} else {
						if (CommonFunctionandEvents.fnTextContains(driver.getCurrentUrl(), Constant.Contact_No)) {
							Result = true;
							Log.info("User Navigated to Contact No page");
							Test.log(LogStatus.PASS, "User Navigated to Contact No page");
						} else {
							Result = false;
							Log.info("User navigated to incorrect page");
							Test.log(LogStatus.FAIL, "User navigated to incorrect page");

						}
					}

				} else {
					Result = false;
					Log.info("User not navigated to Contact No page");
					Test.log(LogStatus.FAIL, "User not navigated to Contact No page");
				}

			} else {
				Result = false;
				Log.info("Contact No icon is not getting displayed");
				Test.log(LogStatus.FAIL, "Contact No icon is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						driver.getCurrentUrl());
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						driver.getCurrentUrl());
			}
			
			Assert.assertEquals(Result, true);
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
						Str)) {
					Result = true;
					Log.info("My Account menu is getting displayed correctly");
					Test.log(LogStatus.PASS, "My Account menu is getting displayed correctly");
				} else {
					Result = false;
					Log.info("Incorrect name for My Account menu getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect name for My Account menu getting displayed");
				}

			} else {
				Result = false;
				Log.info("My Account menu is not getting displayed");
				Test.log(LogStatus.FAIL, "My Account menu is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.MyAccount_menu);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.MyAccount_menu);
			}
			
			Assert.assertEquals(Result, true);
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
						Result = true;
						Log.info("My Account menu dropdown is getting displayed correctly");
						Test.log(LogStatus.PASS, "My Account menu dropdown is getting displayed correctly");
					} else {
						Result = false;
						Log.info("My Account menu dropdown not getting displayed");
						Test.log(LogStatus.FAIL, "My Account menu dropdown is getting displayed correctly");
					}
				} else {
					Result = false;
					Log.info("My Account menu is not clickable");
					Test.log(LogStatus.FAIL, "My Account menu is not clickable");
				}

			} else {
				Result = false;
				Log.info("My Account menu is not getting displayed");
				Test.log(LogStatus.FAIL, "My Account menu is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.MyAccount_dropdown);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.MyAccount_dropdown);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
		driver.navigate().refresh();
	}

	@Test
	public void TC09_fnCheck_LandingPage_MyAccount_Elements() {
		String[] S1 = null;
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.MyAccount_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, LP.MyAccount_menu)) {
					if (CommonFunctionandEvents.fnValidateArray(
							CommonFunctionandEvents.fncreateArray_Elements(LP.MyAccount_dropdown_options, S1), S)) {
						Result = true;
						Log.info("All My Account dropdown options are getting correctly displayed");
						Test.log(LogStatus.PASS, "All My Account dropdown options are getting correctly displayed");
					} else {
						Result = false;
						Log.info("All System Menu bar elements are not getting correctly displayed");
						Test.log(LogStatus.FAIL, "All System Menu bar elements are not getting correctly displayed");
					}
				} else {
					Result = false;
					Log.info("My Account menu is not clickable");
					Test.log(LogStatus.FAIL, "My Account menu is not clickable");

				}

			} else {
				Result = false;
				Log.info("My Account menu is not getting displayed");
				Test.log(LogStatus.FAIL, "My Account menu is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.MyAccount_dropdown_options);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: yellow; border: 2px solid black;');",
						LP.MyAccount_dropdown_options);
			}
			Assert.assertEquals(Result, true);
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
						Str)) {
					Result = true;
					Log.info("Wish List menu is getting displayed correctly");
					Test.log(LogStatus.PASS, "Wish List menu is getting displayed correctly");
				} else {
					Result = false;
					Log.info("Incorrect name for Wish List menu getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect name for Wish List menu getting displayed");
				}

			} else {
				Result = false;
				Log.info("Wish List menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Wish List menu is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.WishList_menu);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: yellow; border: 2px solid black;');",
						LP.WishList_menu);
			}
			
			Assert.assertEquals(Result, true);
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
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result = true;
						Log.info("User navigated to the correct page i.e. Login page");
						Test.log(LogStatus.PASS, "User navigated to the correct page i.e. Login page");
					} else {
						Result = false;
						Log.info("User navigated to incorrect page");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page");
					}
				} else {
					Result = false;
					Log.info("Wish List menu is not clickable");
					Test.log(LogStatus.FAIL, "Wish List menu is not clickable");

				}

			} else {
				Result = false;
				Log.info("Wish List menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Wish List menu is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						driver.getTitle());
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: yellow; border: 2px solid black;');",
						driver.getTitle());
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC12_fnCheck_LandingPage_ShoppingCart_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.ShoppingCart_menu)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(LP.ShoppingCart_menu), Str)) {
					Result = true;
					Log.info("Shopping Cart menu is getting displayed correctly");
					Test.log(LogStatus.PASS, "Shopping Cart menu is getting displayed correctly");
				} else {
					Result = false;
					Log.info("Incorrect name for Shopping Cart menu getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect name for Shopping Cart menu getting displayed");
				}

			} else {
				Result = false;
				Log.info("Shopping Cart menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Shopping Cart menu is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.ShoppingCart_menu);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: yellow; border: 2px solid black;');",
						LP.ShoppingCart_menu);
			}
			Assert.assertEquals(Result, true);
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
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result = true;
						Log.info("User navigated to the Shopping Cart page");
						Test.log(LogStatus.PASS, "User navigated to the Shopping Cart page");
					} else {
						Result = false;
						Log.info("User navigated to incorrect page");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page");
					}
				} else {
					Result = false;
					Log.info("Shopping Cart menu is not clickable");
					Test.log(LogStatus.FAIL, "Shopping Cart menu is not clickable");
				}

			} else {
				Result = false;
				Log.info("Shopping Cart menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Shopping Cart menu is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						driver.getTitle());
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: yellow; border: 2px solid black;');",
						driver.getTitle());
			}
			Assert.assertEquals(Result, true);
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
						Str)) {
					Result = true;
					Log.info("Checkout menu is getting displayed correctly");
					Test.log(LogStatus.PASS, "Checkout menu is getting displayed correctly");
				} else {
					Result = false;
					Log.info("Incorrect name for Checkout menu getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect name for Checkout menu getting displayed");
				}

			} else {
				Result = false;
				Log.info("Checkout menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Checkout menu is not getting displayed");
			}
			if (Result) {
				System.out.println(Result);
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Checkout_menu);
			} else {
				System.out.println(Result);
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.Checkout_menu);
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Checkout_menu);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: yellow; border: 2px solid black;');",
						LP.Checkout_menu);
			}
			Assert.assertEquals(Result, true);

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
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result = true;
						Log.info("User navigated to correct page i.e. the Shopping Cart page");
						Test.log(LogStatus.PASS, "User navigated to correct page i.e. the Shopping Cart page");
					} else {
						Result = false;
						Log.info("User navigated to incorrect page");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page");
					}
				} else {
					Result = false;
					Log.info("Checkout Cart menu is not clickable");
					Test.log(LogStatus.FAIL, "Checkout Cart menu is not clickable");
				}

			} else {
				Result = false;
				Log.info("Checkout Cart menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Checkout Cart menu is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						driver.getTitle());
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: yellow; border: 2px solid black;');",
						driver.getTitle());
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

}
