package utility;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

	public static boolean fnValidateArray_Elements(List<WebElement> list, String[] s) {
		try {
			int a = 0;
			String[] arr = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				arr[i] = list.get(i).getText();
			}

			for (int j = 0; j < arr.length; j++) {
				if (arr[j].contentEquals(s[j])) {
					a = a + 1;
				}
			}
			if ((a==arr.length) && (a==s.length)) {
				bstatus= true;
			}
			else {
				bstatus= false;
			}
		} catch (Exception e) {
			String Ex = e.toString();
			System.out.println(Ex);
			bstatus= false;
		}

		return bstatus;

	}
}
