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
           
    	
        WebDriver driver;   
        
        @FindBy(xpath="//a[text()='Desktops']")
        WebElement Desktops_menu;
        
        @FindBy(xpath="//a[text()='Laptops & Notebooks']")
        WebElement LaptopsandNotebooks_menu;
        
        @FindBy(xpath="//a[text()='Components']")
        WebElement Components_menu;
        
        @FindBy(xpath="//a[text()='Tablets']")
        WebElement Tablets_menu;
       
        
        @FindBy(xpath="//a[text()='Software']")
        WebElement Software_menu;
        
        @FindBy(xpath="//a[text()='Phones & PDAs']")
        WebElement PhonesandPDAs_menu;
        
        @FindBy(xpath="//a[text()='Cameras']")
        WebElement Cameras_menu;
        
        
        @FindBy(xpath="//a[text()='MP3 Players']")
        WebElement MP3Players_menu;
        
        @FindBy(xpath="//a[text()='Your Store']")
        WebElement YourStore;
        
        @FindBy(xpath="//span[text()='123456789']")
        WebElement Contact_No;
        
        @FindBy(xpath="//a[@class='fa fa-phone']")
        WebElement Contact_Us;
        
        @FindBy(xpath="//a[@class='dropdown-toggle']")
        WebElement MyAccount_menu;
        
        @FindBy(xpath="//span[text()='My Account']")
        WebElement MyAccount_title;
        
        @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']")
        WebElement MyAccount_dropdown;
        
        @FindBy(id="wishlist-total")
        WebElement WishList_menu;
        
        @FindBy(xpath="//a[text()='Shopping Cart']")
        WebElement ShoppingCart_menu;
        
        @FindBy(xpath="//a[text()='Checkout']")
        WebElement Checkout_menu;
        
      
    }
