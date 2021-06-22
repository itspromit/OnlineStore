package testCases;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.testng.annotations.DataProvider;
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

public class Registration {

	WebDriver driver;
	RegisterAccount_Page R_Acc;
	LandingPage LPage;
	int y;
	ExtentReports Report;
	ExtentTest Test;
	boolean Result;
	String Str;
	String[] S;
	JavascriptExecutor JS;
	String[][] Excel_data;
	MyAccount M_Acc;
	Logout L_out;

	@BeforeClass
	public void fnCheck_RegisterAccount_page() {

		try {

			if (driver == null) {
				driver = Utils.Return_driver();
				R_Acc = new RegisterAccount_Page(driver);
				M_Acc= new MyAccount(driver);
				L_out= new Logout(driver);
				// LPage= new LandingPage();
				Report = LandingPage.Return_Report();
				JS = CommonFunctionandEvents.JavaScript_Executor(driver);

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

			Excel_data = ExcelUtils.Return_table(Constant.Path_TestData, "Registration");
			for (int i=0; i<Excel_data.length;i++) {
				for (int j=0; j<Excel_data[0].length; j++) {
					System.out.println(Excel_data[i][j]);
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

	@Test(dataProvider = "Registration")
	public void TC80_fnCheck_RegisterAccount_Page_title(String FName, String LName, String E_Mail, String Phone,
			String Password, String Confirm_Password) {
		try {
			if (CommonFunctionandEvents.fnClickNEnterText(R_Acc.FirstName_field, FName)) {
				Log.info("First Name is entered");
				Test.log(LogStatus.INFO, "First Name is entered");
			} else {
				Log.info("First Name is not entered");
				Test.log(LogStatus.INFO, "First Name is not entered");
			}
			if (CommonFunctionandEvents.fnClickNEnterText(R_Acc.LastName_field, LName)) {
				Log.info("Last Name is entered");
				Test.log(LogStatus.INFO, "Last Name is entered");
			} else {
				Log.info("Last Name is not entered");
				Test.log(LogStatus.INFO, "Last Name is not entered");
			}
			if (CommonFunctionandEvents.fnClickNEnterText(R_Acc.EMail_field, E_Mail)) {
				Log.info("E-mail is entered");
				Test.log(LogStatus.INFO, "E-mail is entered");
			} else {
				Log.info("E-mail is not entered");
				Test.log(LogStatus.INFO, "E-mail is not entered");
			}
			if (CommonFunctionandEvents.fnClickNEnterText(R_Acc.Telephone_field, Phone)) {
				Log.info("Telepnone number is entered");
				Test.log(LogStatus.INFO, "Telepnone number  is entered");
			} else {
				Log.info("Telepnone number  is not entered");
				Test.log(LogStatus.INFO, "Telepnone number is not entered");
			}
			if (CommonFunctionandEvents.fnClickNEnterText(R_Acc.Password_field, Password)) {
				Log.info("Password is entered");
				Test.log(LogStatus.INFO, "Password is entered");
			} else {
				Log.info("Password is not entered");
				Test.log(LogStatus.INFO, "Password is not entered");
			}
			if (CommonFunctionandEvents.fnClickNEnterText(R_Acc.ConfirmPassword_field, Confirm_Password)) {
				Log.info("Confirm Password is entered");
				Test.log(LogStatus.INFO, "Confirm Password is entered");
			} else {
				Log.info("Confirm Password is not entered");
				Test.log(LogStatus.INFO, "Confirm Password is not entered");
			}

			if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, R_Acc.PrivacyPolicy_checkbox)) {
				Log.info("Privacy Policy required checkbox is checked");
				Test.log(LogStatus.INFO, "Privacy Policy required checkbox is checked");
			} else {
				Log.info("Privacy Policy required checkbox is not checked");
				Test.log(LogStatus.INFO, "Privacy Policy required checkbox is not checked");
			}

			if (CommonFunctionandEvents.fnCheckPresenceandClick(driver, R_Acc.Continue_button)) {
				Log.info("Continue button is clicked");
				Test.log(LogStatus.INFO, "Continue button is clicked");
			} else {
				Log.info("Continue button is not clicked");
				Test.log(LogStatus.INFO, "Continue button is not clicked");
			}

			if (CommonFunctionandEvents.fnTextContains(driver.getTitle(), Constant.Registration_msg)) {
				Result = true;
				Log.info(FName + LName + "Registered succesfully");
				Test.log(LogStatus.PASS, FName + LName + "Registered succesfully");
				M_Acc.MyAccount_menu.click();
				CommonFunctionandEvents.fnclickArray_Element(M_Acc.MyAccount_dropdown_options_MyAccount_Page, "Logout");
				L_out.Continue_button_LogoutPage.click();
				
			} else {
				Result = false;
				Log.info("Registration process failed");
				Test.log(LogStatus.FAIL, "Registration process failed");
				
			}
			driver.get(Constant.RegisterAccount_Page);

			if (Result == true) {
				JS.executeScript("document.body.style.backgroundColor = 'green';");

			} else {
				JS.executeScript("document.body.style.backgroundColor = 'red';");

			}

			Assert.assertEquals(Result, true);
			
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@DataProvider(name = "Registration")
	public Object[][] Registration() throws Exception {
		return (Excel_data);

	}

}
