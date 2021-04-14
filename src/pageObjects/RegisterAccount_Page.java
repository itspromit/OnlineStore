package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Log;
import utility.Utils;
public class RegisterAccount_Page {
	
           
	@FindBy(xpath="//a[text()='Account']")
    public WebElement Account_menu;
	
	@FindBy(xpath="//a[text()='Register']")
    public WebElement Register_menu;
	
	@FindBy(xpath="//a[text()='Account']/parent::li/preceding-sibling::li/child::a")
    public WebElement Home_menu;
	
	@FindBy(xpath="//h1[text()='Register']")
    public WebElement Page_Header;
	
	@FindBy(xpath="//p[text()='If you already have an account with us, please login at the ']")
    public WebElement Register_Account_msg;
	
	@FindBy(xpath="//p[text()='If you already have an account with us, please login at the ']/child::a")
    public WebElement LoginPage_link;
	
	@FindBy(xpath="//fieldset[@id='account']")
    public WebElement PersonalDetails_section;
	
	@FindBy(xpath="//fieldset[@id='account']/child::legend")
    public WebElement PersonalDetails_header;
	
	@FindBy(xpath="//fieldset[@id='account']/descendant::label[text()='First Name']")
    public WebElement FirstName_label;
	
	@FindBy(xpath="//fieldset[@id='account']/descendant::input[@id='input-firstname']")
    public WebElement FirstName_field;
	
	@FindBy(xpath="//fieldset[@id='account']/descendant::label[text()='Last Name']")
    public WebElement LastName_label;
	
	@FindBy(xpath="//fieldset[@id='account']/descendant::input[@id='input-lastname']")
    public WebElement LastName_field;
	
	@FindBy(xpath="//fieldset[@id='account']/descendant::label[text()='E-Mail']")
    public WebElement EMail_label;
	
	@FindBy(xpath="//fieldset[@id='account']/descendant::input[@id='input-email']")
    public WebElement EMail_field;
	
	@FindBy(xpath="//fieldset[@id='account']/descendant::label[text()='Telephone']")
    public WebElement Telephone_label;
	
	@FindBy(xpath="//fieldset[@id='account']/descendant::input[@id='input-telephone']")
    public WebElement Telephone_field;
	
}
