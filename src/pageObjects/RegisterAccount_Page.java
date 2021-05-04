package pageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Log;
import utility.Utils;
public class RegisterAccount_Page extends Landing_Page {
	
           
	
	public RegisterAccount_Page(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[text()='Account']")
    public WebElement Account_menu;
	
	@FindBy(xpath="//a[text()='Register']")
    public WebElement Register_menu;
	
	@FindBy(xpath="//a[text()='Account']/parent::li/preceding-sibling::li/child::a")
    public WebElement Home_menu;
	
	@FindBy(xpath="//h1[text()='Register Account']")
    public WebElement Page_Header;
	
	@FindBy(xpath="//p[text()='If you already have an account with us, please login at the ']")
    public WebElement Register_Account_msg;
	
	@FindBy(xpath="//p[text()='If you already have an account with us, please login at the ']/child::a")
    public WebElement LoginPage_link;
	
	@FindBy(xpath="//legend[text()='Your Personal Details']/parent::fieldset")
    public WebElement PersonalDetails_section;
	
	@FindBy(xpath="//legend[text()='Your Personal Details']")
    public WebElement PersonalDetails_header;
	
	@FindBy(xpath="//legend[text()='Your Personal Details']/parent::fieldset/descendant::label[text()='First Name']")
    public WebElement FirstName_label;
	
	@FindBy(xpath="//legend[text()='Your Personal Details']/parent::fieldset/descendant::input[@id='input-firstname']")
    public WebElement FirstName_field;
	
	@FindBy(xpath="//legend[text()='Your Personal Details']/parent::fieldset/descendant::label[text()='Last Name']")
    public WebElement LastName_label;
	
	@FindBy(xpath="//legend[text()='Your Personal Details']/parent::fieldset/descendant::input[@id='input-lastname']")
    public WebElement LastName_field;
	
	@FindBy(xpath="//legend[text()='Your Personal Details']/parent::fieldset/descendant::label[text()='E-Mail']")
    public WebElement EMail_label;
	
	@FindBy(xpath="//legend[text()='Your Personal Details']/parent::fieldset/descendant::input[@id='input-email']")
    public WebElement EMail_field;
	
	@FindBy(xpath="//legend[text()='Your Personal Details']/parent::fieldset/descendant::label[text()='Telephone']")
    public WebElement Telephone_label;
	
	@FindBy(xpath="//legend[text()='Your Personal Details']/parent::fieldset/descendant::input[@id='input-telephone']")
    public WebElement Telephone_field;
	
	@FindBy(xpath="//legend[text()='Your Password']/parent::fieldset")
    public WebElement YourPassword_section;
	
	@FindBy(xpath="//legend[text()='Your Password']")
    public WebElement YourPassword_header;
	
	@FindBy(xpath="//legend[text()='Your Password']/parent::fieldset/descendant::label[text()='Password']")
    public WebElement Password_label;
	
	@FindBy(xpath="//legend[text()='Your Password']/parent::fieldset/descendant::input[@id='input-password']")
    public WebElement Password_field;
	
	@FindBy(xpath="//legend[text()='Your Password']/parent::fieldset/descendant::label[text()='Password Confirm']")
    public WebElement ConfirmPassword_label;
	
	@FindBy(xpath="//legend[text()='Your Password']/parent::fieldset/descendant::input[@id='input-confirm']")
    public WebElement ConfirmPassword_field;
	
	@FindBy(xpath="//legend[text()='Newsletter']/parent::fieldset")
    public WebElement Newsletter_section;
	
	@FindBy(xpath="//legend[text()='Newsletter']")
    public WebElement Newsletter_header;
	
	@FindBy(xpath="//legend[text()='Newsletter']/parent::fieldset/descendant::label[text()='Subscribe']")
	public WebElement Subscribe_label;
	
	@FindBy(xpath="//legend[text()='Newsletter']/parent::fieldset/descendant::label[@class='radio-inline']")
	public List<WebElement> Radio_buttons;
	
	@FindBy(xpath="//div[text()='I have read and agree to the ']")
    public WebElement Confirmation_msg;
	
	@FindBy(xpath="//div[text()='I have read and agree to the ']/descendant::b[text()='Privacy Policy']")
    public WebElement PrivacyPolicy_text;
	
	@FindBy(xpath="//div[text()='I have read and agree to the ']/descendant::b[text()='Privacy Policy']/parent::a")
    public WebElement PrivacyPolicy_link;
	
	@FindBy(xpath="//div[text()='I have read and agree to the ']/descendant::input[@class='btn btn-primary']")
    public WebElement Continue_button;
	
	@FindBy(xpath="//aside[@id='column-right']")
    public WebElement Menu_bar;
	
	@FindBy(xpath="//aside[@id='column-right']/descendant::a")
	public List<WebElement> Menubar_items;
	
	
	
	//*[@id="content"]/form/div/div/text()[1]
	
}
