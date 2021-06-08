package utility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctionandEvents {

	public static boolean bstatus = false;

	public static boolean fnIsElementDisplayed(WebElement element) {
		try {
			if (element.isDisplayed()) {
				bstatus = true;
			} else {
				bstatus = false;
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
			bstatus = false;
		}

		return bstatus;
	}

	public static boolean fnCheckPresenceandClick(WebDriver driver, WebElement element) {

		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			if (fnIsElementDisplayed(element)) {
				element.click();
				bstatus = true;
			} else {
				bstatus = false;
			}

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
			bstatus = false;
		}
		return bstatus;

	}

	public static boolean fnDrpDwnSelect(WebElement Dropdown, String option) {
		try {
			if (fnIsElementDisplayed(Dropdown)) {
				Select select = new Select(Dropdown);
				select.selectByVisibleText(option);
				bstatus = true;
			} else {
				bstatus = false;
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
			bstatus = false;
		}
		return bstatus;

	}

	public static boolean fnMenuHover(WebDriver driver, WebElement element1) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(element1).build().perform();
			

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
			bstatus = false;
		}
		return bstatus;

	}
	
	public static boolean fnMenuHoverClick(WebDriver driver, WebElement element1, WebElement element2) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(element1).build().perform();
			builder.moveToElement(element2).click().build().perform();
			

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
			bstatus = false;
		}
		return bstatus;

	}

	public static void fnWaitForElement(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50000);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
	}

	public static String fnGetElementText(WebElement element) {
		String text = null;
		try {
			if (fnIsElementDisplayed(element)) {
				text = element.getText();
			} else {
				text = "";
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
		return text;
	}

	public static String fnGetElementAttribute(WebElement element, String value) {
		String text = null;
		try {
			if (fnIsElementDisplayed(element)) {
				text = element.getAttribute(value);
			} else {
				text = "";
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
		return text;
	}

	public static boolean fnTextContains(String text1, String text2) {

		try {
			if (text1.contains(text2)) {
				bstatus = true;
			} else {
				bstatus = false;
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
			bstatus = false;
		}
		return bstatus;
	}

	public static boolean fnTextEquals(String text1, String text2) {

		try {
			if (text1.equals(text2)) {
				bstatus = true;
			} else {
				bstatus = false;
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
			bstatus = false;
		}
		return bstatus;
	}

	public static boolean fnClickNEnterText(WebElement element, String text) {
		try {
			if (fnIsElementDisplayed(element)) {
				element.sendKeys(text);
				bstatus = true;
			} else {
				bstatus = false;
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
			bstatus = false;
		}
		return bstatus;
	}

	public static String[] fnStringSplit(String text, String symbol) {
		String[] msg = null;

		try {
			if (text.contains(symbol)) {
				msg = text.split(symbol);
			} else {
				msg = new String[] { text };
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
		return msg;
	}

	public static String[] fncreateArray_Elements(List<WebElement> list, String[] arr) {
		try {

			arr = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				arr[i] = list.get(i).getText();
				Log.info(list.get(i).getText());

			}

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);

		}
		return arr;

	}

	public static void fnclickArray_Element(List<WebElement> list, String Text) {
		try {

			for (int i = 0; i < list.size(); i++) {
				if (Text.contentEquals(list.get(i).getText())) {
					list.get(i).click();
					break;
				}

			}

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);

		}

	}

	public static boolean fnValidateArray(String[] Arr, String[] Arr1) {
		int a = 0;
		for (int i = 0; i < Arr.length; i++) {
			for (int j = 0; j < Arr1.length; j++) {
				if (Arr[i].contentEquals(Arr1[j])) {
					a = a + 1;
				}
			}
		}
		if ((a == Arr.length) && (a == Arr1.length)) {
			bstatus = true;
			Log.info("Both arrays are equal");
		} else {
			bstatus = false;
			if (Arr.length > Arr1.length) {
				int x = 0;
				Log.info("The following Array1 elements missing in Array2:-");
				for (int b = 0; b < Arr.length; b++) {
					for (int c = 0; c < Arr1.length; c++) {
						if (Arr[b].contentEquals(Arr1[c])) {
							x = x + 1;
						}
					}
					if (x == 0) {
						Log.info(Arr[b]);
					}
					x = 0;
				}
			} else if (Arr1.length > Arr.length) {
				int y = 0;
				Log.info("The following Array2 elements missing in Array1 :-");
				for (int d = 0; d < Arr1.length; d++) {
					for (int e = 0; e < Arr.length; e++) {
						if (Arr1[d].contentEquals(Arr[e])) {
							y = y + 1;
						}
					}
					if (y == 0) {
						Log.info(Arr1[d]);
					}
					y = 0;
				}
			} else {
				int x = 0;
				Log.info("The following Array1 elements missing in Array2:-");
				for (int b = 0; b < Arr.length; b++) {
					for (int c = 0; c < Arr1.length; c++) {
						if (Arr[b].contentEquals(Arr1[c])) {
							x = x + 1;
						}
					}
					if (x == 0) {
						Log.info(Arr[b]);
					}
					x = 0;
				}
				int y = 0;
				Log.info("The following Array2 elements missing in Array1 :-");
				for (int d = 0; d < Arr1.length; d++) {
					for (int e = 0; e < Arr.length; e++) {
						if (Arr1[d].contentEquals(Arr[e])) {
							y = y + 1;
						}
					}
					if (y == 0) {
						Log.info(Arr1[d]);
					}
					y = 0;
				}

			}
		}

		return bstatus;

	}

	public static boolean Window_count(WebDriver driver) {

		try {
			ArrayList<String> Tabs = new ArrayList<String>(driver.getWindowHandles());
			if (Tabs.size() > 1) {
				bstatus = true;
				Log.info("New tab is opened");
			} else {
				bstatus = false;
				Log.info("No new tab is opened");
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
			bstatus = false;
		}

		return bstatus;
	}

	public static boolean New_Tab(WebDriver driver, String url) {
		try {
			String currentWindowHandle = driver.getWindowHandle();
			ArrayList<String> WindowHandles = new ArrayList<String>(driver.getWindowHandles());
			for (String handle : WindowHandles) {
				if (!currentWindowHandle.equals(handle)) {
					driver.switchTo().window(handle);
				}
			}

			if (fnTextEquals(driver.getCurrentUrl(), url)) {
				Log.info("User navigated to correct page");
			} else {
				Log.info("User navigated to incorrect page");
			}
			driver.close();
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
		}
		return bstatus;
	}

	public static JavascriptExecutor JavaScript_Executor(WebDriver driver) {

		JavascriptExecutor Jse = (JavascriptExecutor) driver;
		return Jse;

	}

	public static Alert fnValidate_Alert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
}
