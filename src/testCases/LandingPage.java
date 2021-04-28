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
import org.apache.log4j.xml.DOMConfigurator;


public class LandingPage {
	
	WebDriver driver;
	Landing_Page LP;
	
	@BeforeSuite
	public void fnCheckforActiveBrowser() {
		try {
		driver= Utils.OpenBrowser(driver);
		}
		catch(Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
		
	}
	
	@BeforeClass
	public void fnCheck() {
		 
	}
	

}
