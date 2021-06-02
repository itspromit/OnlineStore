package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout extends Landing_Page{

	public Logout(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='pull-right']//descendant::a")
    public WebElement Continue_button_LogoutPage;

}
