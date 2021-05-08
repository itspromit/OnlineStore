package utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	public static WebDriver existing_driver;
		
	public static WebDriver OpenBrowser(WebDriver driver) throws Exception{
		try{
		//sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
		//if(sBrowserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Regression Automation Suite\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			Log.info("New driver instantiated");
			System.out.println("New driver instantiated");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    Log.info("Implicit wait applied on the driver for 20 seconds");
		    driver.get(Constant.URL);
		    driver.manage().window().maximize();
		    existing_driver= driver;
		    
		    Log.info("Web application launched successfully");
		    System.out.println("Web application launched successfully");
			//}
		}catch (Exception e){
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		}
		return driver;
	}
	
	public static WebDriver Return_driver() {
		return existing_driver;
	}
	
	public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
				}catch (Exception e){
			Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
					}
			}
	
	
	 public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
			try{
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName +".jpg"));	
			} catch (Exception e){
				Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
				throw new Exception();
			}
		}
	 
	 
	}
