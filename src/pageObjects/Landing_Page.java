package pageObjects;
        import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
        
      
    }
