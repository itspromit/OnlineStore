package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount extends Landing_Page {

	public MyAccount(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/descendant::li")
    public List<WebElement> MyAccount_dropdown_options_MyAccount_Page;

}
