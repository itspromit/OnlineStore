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
    public class LogIn_Page extends RegisterAccount_Page {
    	
    	 
    	@FindBy(xpath="//ul[@class='breadcrumb']/descendant::a[text()='Login']")
        public WebElement Login_menu;
    	
    	@FindBy(xpath="//h2[text()='New Customer']")
        public WebElement NewCustomer_header;
    	
    	@FindBy(xpath="//h2[text()='New Customer']/ancestor::div[@class='col-sm-6']")
        public WebElement NewCustomer_menu;
    	
    	@FindBy(xpath="//h2[text()='New Customer']/ancestor::div[@class='col-sm-6']/descendant::strong[text()='Register Account']")
    	public WebElement RegisterAccount_label;
    	
    	@FindBy(xpath="//h2[text()='New Customer']/ancestor::div[@class='col-sm-6']/descendant::p[2]")
        public WebElement NewCustomer_text;
    	
    	@FindBy(xpath="//h2[text()='New Customer']/ancestor::div[@class='col-sm-6']/descendant::a[text()='Continue']")
        public WebElement Continue_button;
    	
    	@FindBy(xpath="//h2[text()='Returning Customer']")
        public WebElement ReturningCustomer_header;
    	
    	@FindBy(xpath="//h2[text()='Returning Customer']/ancestor::div[@class='col-sm-6']")
    	public WebElement ReturningCustomer_menu;
    	
    	@FindBy(xpath="//h2[text()='Returning Customer']/ancestor::div[@class='col-sm-6']/descendant::strong[text()='I am a returning customer']")
    	public WebElement ReturningCustomer_text;
    	
    	@FindBy(xpath="//h2[text()='Returning Customer']/ancestor::div[@class='col-sm-6']/descendant::label[text()='E-Mail Address']")
    	public WebElement EmailAddress_label;
    	
    	@FindBy(xpath="//h2[text()='Returning Customer']/ancestor::div[@class='col-sm-6']/descendant::label[@id='input-email']")
    	public WebElement EmailAddress_field;
    	
    	@FindBy(xpath="//h2[text()='Returning Customer']/ancestor::div[@class='col-sm-6']/descendant::label[text()='Password']")
    	public WebElement Password_label;
    	
    	@FindBy(xpath="//h2[text()='Returning Customer']/ancestor::div[@class='col-sm-6']/descendant::label[@id='input-password']")
    	public WebElement Password_field;
    	
    	@FindBy(xpath="//h2[text()='Returning Customer']/ancestor::div[@class='col-sm-6']/descendant::a[text()='Forgotten Password']")
    	public WebElement ForgotPassword_link;
    	
    	@FindBy(xpath="//h2[text()='Returning Customer']/ancestor::div[@class='col-sm-6']/descendant::input[@class='btn btn-primary']")
    	public WebElement Login_button;
    	
    	public LogIn_Page(WebDriver driver) {
        	super(driver);
        	PageFactory.initElements(driver, this);
        }
        
    	
    }
