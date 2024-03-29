package testCases;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pageObjects.Landing_Page;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
import org.testng.annotations.Parameters;
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
	String[][] Excel_data;

	@Parameters("browser")
	@BeforeTest
	public void fnCheckforActiveBrowser(String browser) {
		try {
			if (CommonFunctionandEvents.fnCheck_Connection()) {
				Report = ExtentManager.getInstance();
				Report_old = Report;
				DOMConfigurator.configure("log4j.xml");
				driver = Utils.OpenBrowser(driver, browser);
				if (CommonFunctionandEvents.fnCheck_Page_Links(Constant.URL)) {
					Log.info("The website url is valid");
					System.out.println("The website url is valid");
				} else {
					Log.info("The website url is invalid");
					System.out.println("The website url is invalid");
				}
			} else {
				Log.info("Execution couldn't continue due to no internet connectivity");
				System.out.println("Execution couldn't continue due to no internet connectivity");
				System.exit(1);
			}

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
			if (CommonFunctionandEvents.fnCheck_Connection()) {
				LP = new Landing_Page(driver);
				if (driver.getTitle().contains("Your Store")) {
				} else {
					driver.get(Constant.URL);
				}
				Excel_data = ExcelUtils.Return_table(Constant.Path_TestData, "Landing Page");
				for (int i = 0; i < Excel_data.length; i++) {
					System.out.println(Excel_data[i][0]);
				}
			} else {
				driver.quit();
				Log.info("Execution couldn't continue due to no internet connectivity");
				System.out.println("Execution couldn't continue due to no internet connectivity");
				System.exit(1);
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

	@AfterTest
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
			if (CommonFunctionandEvents.fnCheck_Connection()) {
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

				for (int i = 0; i < Excel_data.length; i++) {
					if (Excel_data[i][0].contentEquals(test_method.getName())) {
						Str = Excel_data[i][1];
						break;
					}
				}

				if (Str.contains(",")) {
					S = CommonFunctionandEvents.fnStringSplit(Str, ",");
				}
			} else {
				driver.quit();
				Log.info("Execution couldn't continue due to no internet connectivity");
				System.out.println("Execution couldn't continue due to no internet connectivity");
				System.exit(1);
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
			Test.log(LogStatus.INFO, Test.addScreenCapture(Constant.Path_ScreenShot));
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
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.SystemMenu_bar)) {
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
						LP.SystemMenu_bar);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.SystemMenu_bar);
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
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.SystemMenu_bar)) {
				if (CommonFunctionandEvents.fnValidateArray(
						CommonFunctionandEvents.fncreateArray_Elements(LP.SystemMenu_bar_elements, S1), S)) {
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
						LP.SystemMenu_bar);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.SystemMenu_bar);
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
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'green';");
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'red';");
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
						LP.MyAccount_dropdown);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: yellow; border: 2px solid black;');",
						LP.MyAccount_dropdown);
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
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'green';");
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'red';");
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
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'green';");
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'red';");
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
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
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
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'green';");
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'red';");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC16_fnCheck_LandingPage_Desktop_menu_functionality() {
		String[] S1 = null;
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Desktops_menu)) {
				if (CommonFunctionandEvents.fnMenuHover(driver, LP.Desktops_menu)) {
					if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Desktop_dropdown)) {
						if (CommonFunctionandEvents.fnValidateArray(
								CommonFunctionandEvents.fncreateArray_Elements(LP.Desktop_dropdown_elements, S1), S)) {
							Result = true;
							Log.info("All items within Desktop menu displaying correctly");
							Test.log(LogStatus.PASS, "All items within Desktop menu displaying correctly");
						} else {
							Result = false;
							Log.info("All items within Desktop menu not displaying correctly");
							Test.log(LogStatus.FAIL, "All items within Desktop menu not displaying correctly");
						}
					} else {
						Result = false;
						Log.info("Desktop menu dropdown not displaying");
						Test.log(LogStatus.FAIL, "Desktop menu dropdown not displaying");
					}

				} else {
					Result = false;
					Log.info("Desktop menu is not hoverable");
					Test.log(LogStatus.FAIL, "Desktop menu is not hoverable");
				}
			} else {
				Result = false;
				Log.info("Desktop menu is not displaying");
				Test.log(LogStatus.FAIL, "Desktop menu is not displaying");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Desktops_menu);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.Desktops_menu);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC17_fnCheck_LandingPage_LaptopsNotebooks_menu_functionality() {
		String[] S1 = null;
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.LaptopsandNotebooks_menu)) {
				if (CommonFunctionandEvents.fnMenuHover(driver, LP.LaptopsandNotebooks_menu)) {
					if (CommonFunctionandEvents.fnIsElementDisplayed(LP.LaptopsandNotebooks_dropdown)) {
						if (CommonFunctionandEvents.fnValidateArray(CommonFunctionandEvents
								.fncreateArray_Elements(LP.LaptopsandNotebooks_dropdown_elements, S1), S)) {
							Result = true;
							Log.info("All items within Laptops&Desktops menu displaying correctly");
							Test.log(LogStatus.PASS, "All items within Laptops&Desktops menu displaying correctly");
						} else {
							Result = false;
							Log.info("All items within Laptops&Desktops menu not displaying correctly");
							Test.log(LogStatus.FAIL, "All items within Laptops&Desktops menu not displaying correctly");
						}
					} else {
						Result = false;
						Log.info("Laptops&Desktops menu dropdown not displaying");
						Test.log(LogStatus.FAIL, "Laptops&Desktops menu dropdown not displaying");
					}

				} else {
					Result = false;
					Log.info("Laptops&Desktops menu is not hoverable");
					Test.log(LogStatus.FAIL, "Laptops&Desktops menu is not hoverable");
				}
			} else {
				Result = false;
				Log.info("Laptops&Desktops menu is not displaying");
				Test.log(LogStatus.FAIL, "Laptops&Desktops menu is not displaying");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.LaptopsandNotebooks_menu);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.LaptopsandNotebooks_menu);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC18_fnCheck_LandingPage_Components_menu_functionality() {
		String[] S1 = null;
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Components_menu)) {
				if (CommonFunctionandEvents.fnMenuHover(driver, LP.Components_menu)) {
					if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Components_dropdown)) {
						if (CommonFunctionandEvents.fnValidateArray(
								CommonFunctionandEvents.fncreateArray_Elements(LP.Components_dropdown_elements, S1),
								S)) {
							Result = true;
							Log.info("All items within Components menu displaying correctly");
							Test.log(LogStatus.PASS, "All items within Components menu displaying correctly");
						} else {
							Result = false;
							Log.info("All items within Components menu not displaying correctly");
							Test.log(LogStatus.FAIL, "All items within Components menu not displaying correctly");
						}
					} else {
						Result = false;
						Log.info("Laptops&Desktops menu dropdown not displaying");
						Test.log(LogStatus.FAIL, "Components menu dropdown not displaying");
					}

				} else {
					Result = false;
					Log.info("Laptops&Desktops menu is not hoverable");
					Test.log(LogStatus.FAIL, "Components menu is not hoverable");
				}
			} else {
				Result = false;
				Log.info("Laptops&Desktops menu is not displaying");
				Test.log(LogStatus.FAIL, "Laptops&Desktops menu is not displaying");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Components_menu);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.Components_menu);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC19_fnCheck_LandingPage_MP3Players_menu_functionality() {
		String[] S1 = null;
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.MP3Players_menu)) {
				if (CommonFunctionandEvents.fnMenuHover(driver, LP.MP3Players_menu)) {
					if (CommonFunctionandEvents.fnIsElementDisplayed(LP.MP3Players_dropdown)) {
						if (CommonFunctionandEvents.fnValidateArray(
								CommonFunctionandEvents.fncreateArray_Elements(LP.MP3Players_elements, S1), S)) {
							Result = true;
							Log.info("All items within MP3Players menu displaying correctly");
							Test.log(LogStatus.PASS, "All items within MP3Players menu displaying correctly");
						} else {
							Result = false;
							Log.info("All items within MP3Players menu not displaying correctly");
							Test.log(LogStatus.FAIL, "All items within MP3Players menu not displaying correctly");
						}
					} else {
						Result = false;
						Log.info("MP3Players menu dropdown not displaying");
						Test.log(LogStatus.FAIL, "MP3Players menu dropdown not displaying");
					}

				} else {
					Result = false;
					Log.info("MP3Players menu is not hoverable");
					Test.log(LogStatus.FAIL, "MP3Players menu is not hoverable");
				}
			} else {
				Result = false;
				Log.info("Laptops&Desktops menu is not displaying");
				Test.log(LogStatus.FAIL, "Laptops&Desktops menu is not displaying");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.MP3Players_menu);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.MP3Players_menu);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC20_fnCheck_LandingPage_SystemMenu_Tablets_Submenu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Tablets_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, LP.Tablets_menu)) {
					Log.info("Tablets submenu option in the System Menu is clicked");
					Test.log(LogStatus.INFO, "Tablets submenu option in the System Menu is clicked");
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result = true;
						Log.info("User navigated to correct page i.e. the Tablets page");
						Test.log(LogStatus.PASS, "User navigated to correct page i.e. the Tablets page");
					} else {
						Result = false;
						Log.info("User navigated to incorrect page");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page");
					}
				} else {
					Result = false;
					Log.info("Tablets submenu option in System Menu is not clickable");
					Test.log(LogStatus.FAIL, "Tablets submenu option in System Menu is not clickable");
				}

			} else {
				Result = false;
				Log.info("Tablets submenu option in System Menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Tablets submenu option in System Menu is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'green';");
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'red';");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC21_fnCheck_LandingPage_SystemMenu_Software_Submenu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Software_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, LP.Software_menu)) {
					Log.info("Software submenu option in the System Menu is clicked");
					Test.log(LogStatus.INFO, "Software submenu option in the System Menu is clicked");
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result = true;
						Log.info("User navigated to correct page i.e. the Software page");
						Test.log(LogStatus.PASS, "User navigated to correct page i.e. the Software page");
					} else {
						Result = false;
						Log.info("User navigated to incorrect page");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page");
					}
				} else {
					Result = false;
					Log.info("Software submenu option in System Menu is not clickable");
					Test.log(LogStatus.FAIL, "Software submenu option in System Menu is not clickable");
				}

			} else {
				Result = false;
				Log.info("Software submenu option in System Menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Software submenu option in System Menu is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'green';");
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'red';");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC22_fnCheck_LandingPage_SystemMenu_PhonesandPDAs_Submenu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.PhonesandPDAs_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, LP.PhonesandPDAs_menu)) {
					Log.info("Phones & PDAs submenu option in the System Menu is clicked");
					Test.log(LogStatus.INFO, "Phones & PDAs submenu option in the System Menu is clicked");
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result = true;
						Log.info("User navigated to correct page i.e. the Phones & PDAs page");
						Test.log(LogStatus.PASS, "User navigated to correct page i.e. the Phones & PDAs page");
					} else {
						Result = false;
						Log.info("User navigated to incorrect page");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page");
					}
				} else {
					Result = false;
					Log.info("Phones & PDAs submenu option in System Menu is not clickable");
					Test.log(LogStatus.FAIL, "Phones & PDAs submenu option in System Menu is not clickable");
				}

			} else {
				Result = false;
				Log.info("Phones & PDAs submenu option in System Menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Phones & PDAs submenu option in System Menu is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'green';");
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'red';");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC23_fnCheck_LandingPage_SystemMenu_Cameras_Submenu_functionality() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Cameras_menu)) {
				if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, LP.Cameras_menu)) {
					Log.info("Cameras submenu option in the System Menu is clicked");
					Test.log(LogStatus.INFO, "Cameras submenu option in the System Menu is clicked");
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result = true;
						Log.info("User navigated to correct page i.e. the Cameras page");
						Test.log(LogStatus.PASS, "User navigated to correct page i.e. the Cameras page");
					} else {
						Result = false;
						Log.info("User navigated to incorrect page");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page");
					}
				} else {
					Result = false;
					Log.info("Phones & PDAs submenu option in System Menu is not clickable");
					Test.log(LogStatus.FAIL, "Phones & PDAs submenu option in System Menu is not clickable");
				}

			} else {
				Result = false;
				Log.info("Phones & PDAs submenu option in System Menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Phones & PDAs submenu option in System Menu is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'green';");
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver)
						.executeScript("document.body.style.backgroundColor = 'red';");
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC24_fnCheck_LandingPage_Swiper_Content_Box() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Swipe_Content_Box)) {
				Result = true;
				Log.info("Swiper Content box is getting displayed");
				Test.log(LogStatus.PASS, "Swiper Content box is getting displayed");
			} else {
				Result = false;
				Log.info("Swiper Content box is not getting displayed");
				Test.log(LogStatus.FAIL, "Swiper Content box is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Swipe_Content_Box);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.Swipe_Content_Box);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC25_fnCheck_LandingPage_Swiper_Content_Box_Next_button() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Swipe_Content_Box)) {
				if (CommonFunctionandEvents.fnMenuHover(driver, LP.Swipe_Content_Box)) {
					Test.log(LogStatus.PASS, "Mouse is hovered over the Swiper Content box ");
					if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Swipe_button_Next)) {
						Result = true;
						Log.info("Next button within Swiper Content box is getting displayed");
						Test.log(LogStatus.PASS, "Next button within Swiper Content box is getting displayed");
					} else {
						Result = false;
						Log.info("Next button within Swiper Content box is not getting displayed");
						Test.log(LogStatus.FAIL, "Next button within Swiper Content box is not getting displayed");
					}
				} else {
					Result = false;
					Log.info("Swiper Content box is not hoverable");
					Test.log(LogStatus.FAIL, "Swiper Content box is not hoverable");
				}

			} else {
				Result = false;
				Log.info("Swiper Content box is not getting displayed");
				Test.log(LogStatus.FAIL, "Swiper Content box is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Swipe_button_Next);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.Swipe_Content_Box);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC26_fnCheck_LandingPage_Swiper_Content_Box_Previous_button() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Swipe_Content_Box)) {
				if (CommonFunctionandEvents.fnMenuHover(driver, LP.Swipe_Content_Box)) {
					Test.log(LogStatus.PASS, "Mouse is hovered over the Swiper Content box ");
					if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Swipe_button_Previous)) {
						Result = true;
						Log.info("Previous button within Swiper Content box is getting displayed");
						Test.log(LogStatus.PASS, "Previous button within Swiper Content box is getting displayed");
					} else {
						Result = false;
						Log.info("Previous button within Swiper Content box is not getting displayed");
						Test.log(LogStatus.FAIL, "Previous button within Swiper Content box is not getting displayed");
					}
				} else {
					Result = false;
					Log.info("Swiper Content box is not hoverable");
					Test.log(LogStatus.FAIL, "Swiper Content box is not hoverable");
				}

			} else {
				Result = false;
				Log.info("Swiper Content box is not getting displayed");
				Test.log(LogStatus.FAIL, "Swiper Content box is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Swipe_button_Previous);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.Swipe_Content_Box);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC27_fnCheck_LandingPage_Swiper_Content_Box_Bullet_options() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Swipe_Content_Box)) {
				if (CommonFunctionandEvents.fnIsElementDisplayed(LP.SwipeContent_Box_Bullet_options_menu)) {
					Result = true;
					Log.info("Bullet options below Swiper Content box is getting displayed");
					Test.log(LogStatus.PASS, "Bullet options below Swiper Content box is getting displayed");
				} else {
					Result = false;
					Log.info("Bullet options below Swiper Content box is not getting displayed");
					Test.log(LogStatus.FAIL, "Bullet options below Swiper Content box is getting displayed");
				}

			} else {
				Result = false;
				Log.info("Swiper Content box is not getting displayed");
				Test.log(LogStatus.FAIL, "Swiper Content box is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.SwipeContent_Box_Bullet_options_menu);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.SwipeContent_Box_Bullet_options_menu);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC28_fnCheck_LandingPage_Swiper_Content_Box_FirstBullet_option_displaying_correct_image_onclick() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.SwipeContent_Box_Bullet_options_menu)) {
				LP.SwipeContent_Box_Bullet_options.get(0).click();
				if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Swipe_Content_Box_MacBook_image)) {
					Result = true;
					Log.info("MacBook Air image is getting displayed within Swipe Content box");
					Test.log(LogStatus.PASS, "MacBook Air image is getting displayed within Swipe Content box");
				} else {
					Result = false;
					Log.info("Incorrect image is getting displayed within Swipe Content box");
					Test.log(LogStatus.FAIL, "Incorrect image is getting displayed within Swipe Content box");
				}

			} else {
				Result = false;
				Log.info("Bullet options below Swiper Content box is not getting displayed");
				Test.log(LogStatus.FAIL, "Bullet options below Swiper Content box is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Swipe_Content_Box_MacBook_image);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.Swipe_Content_Box);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}
	
	@Test
	public void TC29_fnCheck_LandingPage_Swiper_Content_Box_SecondBullet_option_displaying_correct_image_onclick() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.SwipeContent_Box_Bullet_options_menu)) {
				LP.SwipeContent_Box_Bullet_options.get(1).click();
				if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Swipe_Content_Box_IPhone_image)) {
					Result = true;
					Log.info("IPhone image is getting displayed within Swipe Content box");
					Test.log(LogStatus.PASS, "IPhone image is getting displayed within Swipe Content box");
				} else {
					Result = false;
					Log.info("Incorrect image is getting displayed within Swipe Content box");
					Test.log(LogStatus.FAIL, "Incorrect image is getting displayed within Swipe Content box");
				}

			} else {
				Result = false;
				Log.info("Bullet options below Swiper Content box is not getting displayed");
				Test.log(LogStatus.FAIL, "Bullet options below Swiper Content box is not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						LP.Swipe_Content_Box_IPhone_image);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						LP.Swipe_Content_Box);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

}
