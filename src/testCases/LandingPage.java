package testCases;

import java.util.LinkedList;
import java.util.List;
import pageObjects.Landing_Page;
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

	@BeforeSuite
	public void fnCheckforActiveBrowser() {
		try {
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
				System.out.println("User on landing page");
			} else {
				System.out.println("User not on landing page");
				driver.get(Constant.URL);

			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}

	}

	@BeforeMethod
	//public void InitializingPage_Elements() {
		//LP = new Landing_Page(driver);
	//}

	@Test(priority = 0)
	public void fnCheckPage_title() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.YourStore)) {
				if (CommonFunctionandEvents.fnTextContains(CommonFunctionandEvents.fnGetElementText(LP.YourStore),
						"Your Store")) {
					System.out.println("Page title is being displyed correctly");
				} else {
					System.out.println("Incorrect Page title is being displyed");
				}
			} else {
				System.out.println("Page title is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	@Test(priority = 1)
	public void fnCheckPage_elements() {
		try {
			if (CommonFunctionandEvents.fnIsElementDisplayed(LP.Menu_bar)) {
				System.out.println("Menu bar is being displyed");
			} else {
				System.out.println("Menu bar is not getting displayed");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}
	
	@AfterClass
	public void fnDelete_PageObject() {
		LP= null;
	}
	
	@AfterSuite
	public void Browser_Close() {
		driver.quit();
	}
}
