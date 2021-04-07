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
    public class Landing_Page {
           
    	
        //WebDriver driver;   
        
        @FindBy(xpath="//a[text()='Desktops']")
        public WebElement Desktops_menu;
        
        @FindBy(xpath="//a[text()='Laptops & Notebooks']")
        public WebElement LaptopsandNotebooks_menu;
        
        @FindBy(xpath="//a[text()='Components']")
        public WebElement Components_menu;
        
        @FindBy(xpath="//a[text()='Tablets']")
        public WebElement Tablets_menu;
       
        
        @FindBy(xpath="//a[text()='Software']")
        public WebElement Software_menu;
        
        @FindBy(xpath="//a[text()='Phones & PDAs']")
        public WebElement PhonesandPDAs_menu;
        
        @FindBy(xpath="//a[text()='Cameras']")
        public WebElement Cameras_menu;
        
        
        @FindBy(xpath="//a[text()='MP3 Players']")
        public WebElement MP3Players_menu;
        
        @FindBy(xpath="//a[text()='Your Store']")
        public WebElement YourStore;
        
        @FindBy(xpath="//span[text()='123456789']")
        public WebElement Contact_No;
        
        @FindBy(xpath="//a[@class='fa fa-phone']")
        public WebElement Contact_Us;
        
        @FindBy(xpath="//a[@class='dropdown-toggle']")
        public WebElement MyAccount_menu;
        
        @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']")
        public WebElement MyAccount_dropdown;
        
        @FindBy(id="wishlist-total")
        public WebElement WishList_menu;
        
        @FindBy(xpath="//a[text()='Shopping Cart']")
        public WebElement ShoppingCart_menu;
        
        @FindBy(xpath="//a[text()='Checkout']")
        public WebElement Checkout_menu;
        
        @FindBy(xpath="//input[@class='form-control input-lg']")
        public WebElement Search_txtbox;
        
        
        @FindBy(xpath="//button[@class='form-control input-lg']")
        public WebElement Search_button;
        
        @FindBy(id="cart")
        public WebElement Cart;
        
        @FindBy(xpath="//div[@class='collapse navbar-collapse navbar-ex1-collapse']")
        public WebElement Menu_bar;
        
        @FindBy(xpath="//a[text()='Desktops']/following-sibling::div[1]")
        public WebElement Desktop_dropdown;
        
        @FindBy(xpath="//a[text()='Laptops & Notebooks']/following-sibling::div[1]")
        public WebElement LaptopsandNotebooks_dropdown;
        
        @FindBy(xpath="//a[text()='Components']/following-sibling::div[1]")
        public WebElement Components_dropdown;
        
        @FindBy(xpath="//a[text()='MP3 Players']/following-sibling::div[1]")
        public WebElement MP3Players_dropdown;
        
        @FindBy(xpath="//a[text()='Desktops']/following-sibling::div[1]")
        List<WebElement> Menu_bar_elements;
        
        @FindBy(xpath="//a[text()='Desktops']/following-sibling::div[1]/descendant::a")
        List<WebElement> Desktop_dropdown_elements;
        
        @FindBy(xpath="//a[text()='Laptops & Notebooks']/following-sibling::div[1]/descendant::a")
        List<WebElement> LaptopsandNotebooks_dropdown_elements;
        
        @FindBy(xpath="//a[text()='Components']/following-sibling::div[1]/descendant::a")
        List<WebElement> Components_dropdown_elements;
        
        @FindBy(xpath="//a[text()='MP3 Players']/following-sibling::div[1]/descendant::a")
        List<WebElement> MP3Players_elements;
        
        @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/descendant::a")
        public WebElement MyAccount_dropdown_options;
    }
    
  //*[@id="menu"]/div[2]/ul/li[1]/a
  //*[@id="menu"]/div[2]/ul/li[1]/div
  //*[@id="menu"]/div[2]/ul/li[1]/div/div/ul
