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

public class RegisterAccount {

	WebDriver driver;
	RegisterAccount_Page R_Acc;
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
			ExcelUtils.setExcelFile(Constant.Path_TestData, "Register Account");

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
	public void TC20_fnCheck_RegisterAccount_Page_title() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Page_Header)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Page_Header),
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
						R_Acc.Page_Header);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Page_Header);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC21_fnCheck_RegisterAccount_Page_Home_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Home_menu)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementAttribute(R_Acc.Home_menu, "class"), Str)) {
					Result = true;
					Log.info("Home menu is being displyed correctly");
					Test.log(LogStatus.PASS, "Home menu is being displyed correctly");
				} else {
					Result = false;
					Log.info("Incorrect name of Home menu is being displyed");
					Test.log(LogStatus.FAIL, "Incorrect name of Home menu is being displyed");
				}
			} else {
				Result = false;
				Log.info("Home menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Home menu is not getting displayed");
			}

			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.Home_menu);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Home_menu);
			}
			Assert.assertEquals(Result, true);
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
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result = true;
						Log.info("User navigated to Landing page upon clicking on Home menu");
						Test.log(LogStatus.PASS, "User navigated to Landing page upon clicking on Home menu");
					} else {
						Result = false;
						Log.info("User navigated to incorrect page upon clicking on Home menu");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page upon clicking on Home menu");
					}
				} else {
					Result = false;
					Log.info("Home menu is not clickable");
					Test.log(LogStatus.FAIL, "Home menu is not clickable");
				}
			} else {
				Result = false;
				Log.info("Home menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Home menu is not getting displayed");
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
	public void TC23_fnCheck_RegisterAccount_Page_Account_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Account_menu)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Account_menu),
						Str)) {
					Result = true;
					Log.info("Account menu is being displyed correctly");
					Test.log(LogStatus.PASS, "Account menu is being displyed correctly");
				} else {
					Result = false;
					Log.info("Incorrect name of Account menu is being displyed");
					Test.log(LogStatus.FAIL, "Incorrect name of Account menu is being displyed");
				}
			} else {
				Result = false;
				Log.info("Account menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Account menu is not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.Account_menu);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Account_menu);
			}
			Assert.assertEquals(Result, true);
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
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result = true;
						Log.info("User navigated to Login page upon clicking on Account menu");
						Test.log(LogStatus.PASS, "User navigated to Login page upon clicking on Account menu");
					} else {
						Result = false;
						Log.info("User navigated to incorrect page upon clicking on Account menu");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page upon clicking on Account menu");
					}
				} else {
					Result = false;
					Log.info("Account menu is not clickable");
					Test.log(LogStatus.FAIL, "Account menu is not clickable");
				}
			} else {
				Result = false;
				Log.info("Account menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Account menu is not getting displayed");
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
	public void TC25_fnCheck_RegisterAccount_Page_Register_menu() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Register_menu)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Register_menu), Str)) {
					Result = true;
					Log.info("Register menu is being displyed correctly");
					Test.log(LogStatus.PASS, "Register menu is being displyed correctly");
				} else {
					Result = false;
					Log.info("Incorrect name of Register menu is being displyed");
					Test.log(LogStatus.FAIL, "Incorrect name of Register menu is being displyed");
				}
			} else {
				Result = false;
				Log.info("Register menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Register menu is not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.Register_menu);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Register_menu);
			}
			Assert.assertEquals(Result, true);
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
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result = true;
						Log.info("User navigated to Register Account page upon clicking on Register menu");
						Test.log(LogStatus.PASS,
								"User navigated to Register Account page upon clicking on Register menu");
					} else {
						Result = false;
						Log.info("User navigated to incorrect page upon clicking on Register menu");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page upon clicking on Register menu");
					}
				} else {
					Result = false;
					Log.info("Register menu is not clickable");
					Test.log(LogStatus.FAIL, "Register menu is not clickable");
				}
			} else {
				Result = false;
				Log.info("Register menu is not getting displayed");
				Test.log(LogStatus.FAIL, "Register menu is not getting displayed");
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
	public void TC27_fnCheck_RegisterAccount_Page_RegisterAccount_msg() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Register_Account_msg)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementText(R_Acc.Register_Account_msg),
						Constant.RegisterAccount_msg)) {
					Result = true;
					Log.info("Register Account message getting displayed");
					Test.log(LogStatus.PASS, "Register Account message getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect Register Account message getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Register Account message getting displayed");
				}

			} else {
				Result = false;
				Log.info("Register Account message not getting displayed");
				Test.log(LogStatus.FAIL, "Register Account message not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.Register_Account_msg);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Register_Account_msg);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC28_fnCheck_RegisterAccount_Page_LoginPage_Link() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.LoginPage_link)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.LoginPage_link), Str)) {
					Result = true;
					Log.info("Login Page link getting displayed");
					Test.log(LogStatus.PASS, "Login Page link getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect name of Login Page link getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect name of Login Page link getting displayed");
				}

			} else {
				Result = false;
				Log.info("Login Page link not getting displayed");
				Test.log(LogStatus.FAIL, "Login Page link not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.LoginPage_link);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.LoginPage_link);
			}
			Assert.assertEquals(Result, true);
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
					if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Str)) {
						Result = true;
						Log.info("User navigated to Login page upon clicking on Login Page link");
						Test.log(LogStatus.PASS, "User navigated to Login page upon clicking on Login Page link");
					} else {
						Result = false;
						Log.info("User navigated to incorrect page upon clicking on Login Page link");
						Test.log(LogStatus.FAIL, "User navigated to incorrect page upon clicking on Login Page link");
					}
				} else {
					Result = false;
					Log.info("Login Page link is not clickable");
					Test.log(LogStatus.FAIL, "Login Page link is not clickable");
				}
			} else {
				Result = false;
				Log.info("Login Page link is not getting displayed");
				Test.log(LogStatus.FAIL, "Login Page link is not getting displayed");
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
	public void TC30_fnCheck_RegisterAccount_Page_PersonalDetails_section() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.PersonalDetails_section)) {
				Result = true;
				Log.info("Personal Details section getting displayed");
				Test.log(LogStatus.PASS, "Personal Details section getting displayed");
			} else {
				Result = false;
				Log.info("Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "Personal Details section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.PersonalDetails_section);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.PersonalDetails_section);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC31_fnCheck_RegisterAccount_Page_PersonalDetails_section_Header() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.PersonalDetails_header)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.PersonalDetails_header), Str)) {
					Result = true;
					Log.info("Personal Details section header getting displayed");
					Test.log(LogStatus.PASS, "Personal Details section header getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect Personal Details section header getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Personal Details section header getting displayed");
				}

			} else {
				Result = false;
				Log.info("Personal Details section header not getting displayed");
				Test.log(LogStatus.FAIL, "Personal Details section header not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.PersonalDetails_header);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.PersonalDetails_header);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC32_fnCheck_RegisterAccount_Page_PersonalDetails_section_FirstName_label() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.FirstName_label)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.FirstName_label), Str)) {
					Result = true;
					Log.info("First Name field label in Personal Details section getting displayed");
					Test.log(LogStatus.PASS, "First Name field label in Personal Details section getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect First Name field label in Personal Details section getting displayed");
					Test.log(LogStatus.FAIL,
							"Incorrect First Name field label in Personal Details section getting displayed");
				}

			} else {
				Result = false;
				Log.info("First Name field label in Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "First Name field label in Personal Details section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.FirstName_label);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.FirstName_label);
			}
			Assert.assertEquals(Result, true);
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
						CommonFunctionandEvents.fnGetElementAttribute(R_Acc.FirstName_field, "placeholder"), Str)) {
					Result = true;
					Log.info("First Name field in Personal Details section getting displayed");
					Test.log(LogStatus.PASS, "First Name field in Personal Details section getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect First Name field in Personal Details section getting displayed");
					Test.log(LogStatus.FAIL,
							"Incorrect First Name field in Personal Details section getting displayed");
				}

			} else {
				Result = false;
				Log.info("First Name field in Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "First Name field in Personal Details section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.FirstName_field);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.FirstName_field);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC34_fnCheck_RegisterAccount_Page_PersonalDetails_section_LastName_label() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.LastName_label)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.LastName_label), Str)) {
					Result = true;
					Log.info("Last Name field label in Personal Details section getting displayed");
					Test.log(LogStatus.PASS, "Last Name field label in Personal Details section getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect Last Name field label in Personal Details section getting displayed");
					Test.log(LogStatus.FAIL,
							"Incorrect Last Name field label in Personal Details section getting displayed");
				}

			} else {
				Result = false;
				Log.info("Last Name field label in Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "Last Name field label in Personal Details section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.LastName_label);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.LastName_label);
			}
			Assert.assertEquals(Result, true);
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
						CommonFunctionandEvents.fnGetElementAttribute(R_Acc.LastName_field, "placeholder"), Str)) {
					Result = true;
					Log.info("Last Name field in Personal Details section getting displayed");
					Test.log(LogStatus.PASS, "Last Name field in Personal Details section getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect Last Name field in Personal Details section getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Last Name field in Personal Details section getting displayed");
				}

			} else {
				Result = false;
				Log.info("Last Name field in Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "Last Name field in Personal Details section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.LastName_field);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.LastName_field);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC36_fnCheck_RegisterAccount_Page_PersonalDetails_section_Email_label() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.EMail_label)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.EMail_label),
						Str)) {
					Result = true;
					Log.info("E-Mail field label in Personal Details section getting displayed");
					Test.log(LogStatus.PASS, "E-Mail field label in Personal Details section getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect E-Mail field label in Personal Details section getting displayed");
					Test.log(LogStatus.FAIL,
							"Incorrect E-Mail field label in Personal Details section getting displayed");
				}

			} else {
				Result = false;
				Log.info("E-Mail field label in Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "E-Mail field label in Personal Details section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.EMail_label);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.EMail_label);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC37_fnCheck_RegisterAccount_Page_PersonalDetails_section_Email_field() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.EMail_field)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementAttribute(R_Acc.EMail_field, "placeholder"), Str)) {
					Result = true;
					Log.info("E-Mail field in Personal Details section getting displayed");
					Test.log(LogStatus.PASS, "E-Mail field in Personal Details section getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect E-Mail field in Personal Details section getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect E-Mail field in Personal Details section getting displayed");
				}

			} else {
				Result = false;
				Log.info("E-Mail field in Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "E-Mail field in Personal Details section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.EMail_field);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.EMail_field);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC38_fnCheck_RegisterAccount_Page_PersonalDetails_section_Telephone_label() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Telephone_label)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Telephone_label), Str)) {
					Result = true;
					Log.info("Telephone field label in Personal Details section getting displayed");
					Test.log(LogStatus.PASS, "Telephone field label in Personal Details section getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect Telephone field label in Personal Details section getting displayed");
					Test.log(LogStatus.FAIL,
							"Incorrect Telephone field label in Personal Details section getting displayed");
				}

			} else {
				Result = false;
				Log.info("Telephone field label in Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "Telephone field label in Personal Details section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.Telephone_label);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Telephone_label);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC39_fnCheck_RegisterAccount_Page_PersonalDetails_section_Telephone_field() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Telephone_field)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementAttribute(R_Acc.Telephone_field, "placeholder"), Str)) {
					Log.info("Telephone field in Personal Details section getting displayed");
					Test.log(LogStatus.PASS, "Telephone field in Personal Details section getting displayed");
				} else {
					Log.info("Incorrect Telephone field in Personal Details section getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Telephone field in Personal Details section getting displayed");
				}

			} else {
				Log.info("Telephone field in Personal Details section not getting displayed");
				Test.log(LogStatus.FAIL, "Telephone field in Personal Details section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.Telephone_field);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Telephone_field);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC40_fnCheck_RegisterAccount_Page_YourPassword_section() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.YourPassword_section)) {
				Result = true;
				Log.info("Your Password section getting displayed");
				Test.log(LogStatus.PASS, "Your Password section getting displayed");
			} else {
				Result = false;
				Log.info("Your Password section not getting displayed");
				Test.log(LogStatus.FAIL, "Your Password section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.YourPassword_section);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.YourPassword_section);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC41_fnCheck_RegisterAccount_Page_YourPassword_section_Header() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.YourPassword_header)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.YourPassword_header), Str)) {
					Result = true;
					Log.info("Your Password section header getting displayed");
					Test.log(LogStatus.PASS, "Your Password section header getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect Your Password section header getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Your Password section header getting displayed");
				}

			} else {
				Result = false;
				Log.info("Your Password section header not getting displayed");
				Test.log(LogStatus.FAIL, "Your Password section header not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.YourPassword_header);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.YourPassword_header);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC42_fnCheck_RegisterAccount_Page_YourPassword_section_Password_label() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Password_label)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Password_label), Str)) {
					Result = true;
					Log.info("Password field label in Your Password section getting displayed");
					Test.log(LogStatus.PASS, "Password field label in Your Password section getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect Password field label in Your Password section getting displayed");
					Test.log(LogStatus.FAIL,
							"Incorrect Password field label in Your Password section getting displayed");
				}

			} else {
				Result = false;
				Log.info("Password field label in Your Password section not getting displayed");
				Test.log(LogStatus.FAIL, "Password field label in Your Password section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.Password_label);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Password_label);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC43_fnCheck_RegisterAccount_Page_YourPassword_section_Password_field() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Password_field)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementAttribute(R_Acc.Password_field, "placeholder"), Str)) {
					Log.info("Password field in Your Password section getting displayed");
					Test.log(LogStatus.PASS, "Password field in Your Password section getting displayed");
				} else {
					Log.info("Password field in Your Password section getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Password field in Your Password section getting displayed");
				}

			} else {
				Log.info("Password field in Your Password section not getting displayed");
				Test.log(LogStatus.FAIL, "Password field in Your Password section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.Password_field);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Password_field);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC44_fnCheck_RegisterAccount_Page_YourPassword_section_ConfirmPassword_label() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.ConfirmPassword_label)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.ConfirmPassword_label), Str)) {
					Result = true;
					Log.info("Confirm Password field label in Your Password section getting displayed");
					Test.log(LogStatus.PASS, "Confirm Password field label in Your Password section getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect Confirm Password field label in Your Password section getting displayed");
					Test.log(LogStatus.FAIL,
							"Incorrect Confirm Password field label in Your Password section getting displayed");
				}

			} else {
				Result = false;
				Log.info("Confirm Password field label in Your Password section not getting displayed");
				Test.log(LogStatus.FAIL, "Confirm Password field label in Your Password section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.ConfirmPassword_label);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.ConfirmPassword_label);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC45_fnCheck_RegisterAccount_Page_YourPassword_section_ConfirmPassword_field() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.ConfirmPassword_field)) {
				if (CommonFunctionandEvents.fnTextContains(
						CommonFunctionandEvents.fnGetElementAttribute(R_Acc.ConfirmPassword_field, "placeholder"),
						Str)) {
					Log.info("Password field in Your Password section getting displayed");
					Test.log(LogStatus.PASS, "Password field in Your Password section getting displayed");
				} else {
					Log.info("Password field in Your Password section getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Password field in Your Password section getting displayed");
				}

			} else {
				Log.info("Password field in Your Password section not getting displayed");
				Test.log(LogStatus.FAIL, "Password field in Your Password section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.ConfirmPassword_field);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.ConfirmPassword_field);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC46_fnCheck_RegisterAccount_Page_Newsletter_section() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Newsletter_section)) {
				Result = true;
				Log.info("Newsletter section getting displayed");
				Test.log(LogStatus.PASS, "Newsletter section getting displayed");
			} else {
				Result = false;
				Log.info("Newsletter section not getting displayed");
				Test.log(LogStatus.FAIL, "Newsletter section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.Newsletter_section);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Newsletter_section);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC47_fnCheck_RegisterAccount_Page_Newsletter_section_Header() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Newsletter_header)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Newsletter_header), Str)) {
					Result = true;
					Log.info("Newsletter section header getting displayed");
					Test.log(LogStatus.PASS, "Newsletter section header getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect Newsletter section header getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Newsletter section header getting displayed");
				}

			} else {
				Result = false;
				Log.info("Newsletter section header not getting displayed");
				Test.log(LogStatus.FAIL, "Newsletter section header not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.Newsletter_header);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Newsletter_header);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC48_fnCheck_RegisterAccount_Page_Newsletter_section_Subscribe_label() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Subscribe_label)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.Subscribe_label), Str)) {
					Result = true;
					Log.info("Subscribe field label in Newsletter section getting displayed");
					Test.log(LogStatus.PASS, "Subscribe field label in Newsletter section getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect Subscribe field label in Newsletter section getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Subscribe field label in Newsletter section getting displayed");
				}

			} else {
				Result = false;
				Log.info("Subscribe label in Newsletter section not getting displayed");
				Test.log(LogStatus.FAIL, "Subscribe field label in Newsletter section not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.Subscribe_label);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Subscribe_label);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test
	public void TC49_fnCheck_RegisterAccount_Subscribe_Radiobutton_options() {
		String[] S1 = null;
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.Subscribe_field_options)) {
				if (CommonFunctionandEvents
						.fnValidateArray(CommonFunctionandEvents.fncreateArray_Elements(R_Acc.Radio_buttons, S1), S)) {
					Result = true;
					Log.info("All Subscribe radio button options are getting correctly displayed");
					Test.log(LogStatus.PASS, "All Subscribe radio button options are getting correctly displayed");
				} else {
					Result = false;
					Log.info("All Subscribe radio button options are not getting correctly displayed");
					Test.log(LogStatus.FAIL, "All Subscribe radio button options are not getting correctly displayed");
				}

			} else {
				Result = false;
				Log.info("Subscribe field options not getting displayed");
				Test.log(LogStatus.FAIL, "Subscribe field options not getting displayed");
			}
			if (Result == true) {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.Subscribe_field_options);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.Subscribe_field_options);
			}

			Assert.assertEquals(Result, true);

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}
	
	@Test
	public void TC50_fnCheck_RegisterAccount_Page_PrivacyPolicy_text() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(R_Acc.PrivacyPolicy_text)) {
				if (CommonFunctionandEvents
						.fnTextContains(CommonFunctionandEvents.fnGetElementText(R_Acc.PrivacyPolicy_text), Constant.Privacy_Policy)) {
					Result = true;
					Log.info("Privacy Policy text getting displayed");
					Test.log(LogStatus.PASS, "Privacy Policy text getting displayed");
				} else {
					Result = false;
					Log.info("Incorrect Privacy Policy text getting displayed");
					Test.log(LogStatus.FAIL, "Incorrect Privacy Policy text getting displayed");
				}

			} else {
				Result = false;
				Log.info("Privacy Policy text not getting displayed");
				Test.log(LogStatus.FAIL, "Privacy Policy text not getting displayed");
			}
			if (Result) {

				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: green; border: 2px solid black;');",
						R_Acc.PrivacyPolicy_text);
			} else {
				CommonFunctionandEvents.JavaScript_Executor(driver).executeScript(
						"arguments[0].setAttribute('style','background: red; border: 2px solid black;');",
						R_Acc.PrivacyPolicy_text);
			}
			Assert.assertEquals(Result, true);
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

}
