package testCases;

import java.util.LinkedList;
import java.util.List;

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

	@BeforeClass
	public void fnCheck_RegisterAccount_page() {

		try {

			if (driver == null) {
				driver=Utils.Return_driver();
				R_Acc = new RegisterAccount_Page(driver);
				
				if (driver.getTitle().contains("Register Account")) {
					Log.info("User on landing page");
				} else {
					Log.info("User not on RegisterAccount page");
					driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

				}
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}

	}

	@Test(priority = 0)
	public void fnCheckPage_title() {
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

}
