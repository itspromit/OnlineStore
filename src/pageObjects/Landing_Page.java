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
        
        @FindBy(xpath="//i[@class='fa fa-phone']/parent::a")
        public WebElement Contact_No_icon_link;
        
        @FindBy(xpath="//i[@class='fa fa-phone']")
        public WebElement Contact_No_icon;
        
        @FindBy(xpath="//a[@class='dropdown-toggle']")
        public WebElement MyAccount_menu;
        
        @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']")
        public WebElement MyAccount_dropdown;
        
        @FindBy(xpath="//i[@class='fa fa-heart']/parent::a")
        public WebElement WishList_menu;
        
        @FindBy(xpath="//i[@class='fa fa-shopping-cart']/parent::a")
        public WebElement ShoppingCart_menu;
        
        @FindBy(xpath="//i[@class='fa fa-share']/parent::a")
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
        
        @FindBy(xpath="//div[@class='collapse navbar-collapse navbar-ex1-collapse']/child::ul/child::li")
        public List<WebElement> Menu_bar_elements;
        
        @FindBy(xpath="//a[text()='Desktops']/following-sibling::div[1]/descendant::a")
        public List<WebElement> Desktop_dropdown_elements;
        
        @FindBy(xpath="//a[text()='Laptops & Notebooks']/following-sibling::div[1]/descendant::a")
        public List<WebElement> LaptopsandNotebooks_dropdown_elements;
        
        @FindBy(xpath="//a[text()='Components']/following-sibling::div[1]/descendant::a")
        public List<WebElement> Components_dropdown_elements;
        
        @FindBy(xpath="//a[text()='MP3 Players']/following-sibling::div[1]/descendant::a")
        public List<WebElement> MP3Players_elements;
        
        @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/descendant::li")
        public List<WebElement> MyAccount_dropdown_options;
        
        @FindBy(xpath="//h3[text()='Featured']")
        public WebElement Featured_option;
        
        @FindBy(xpath="//a[text()='MacBook']")
        public WebElement MacBook_title;
        
        @FindBy(xpath="//a[text()='MacBook']/ancestor::div[1]/preceding-sibling::div/child::a")
        public WebElement MacBook_option;
        
        @FindBy(xpath="//a[text()='iPhone']")
        public WebElement iPhone_title;
        
        @FindBy(xpath="//a[text()='iPhone']/ancestor::div[1]/preceding-sibling::div/child::a")
        public WebElement iPhone_option;
        
        @FindBy(xpath="//a[contains(text(),'Apple Cinema 30')]")
        public WebElement AppleCinema_title;
        
        @FindBy(xpath="//a[contains(text(),'Apple Cinema 30')]/ancestor::div[1]/preceding-sibling::div/child::a")
        public WebElement AppleCinema_option;
        
        @FindBy(xpath="//a[contains(text(),'Canon EOS 5D')]")
        public WebElement CanonEOS5D_title;
        
        @FindBy(xpath="//a[contains(text(),'Canon EOS 5D')]/ancestor::div[1]/preceding-sibling::div/child::a")
        public WebElement CanonEOS5D_option;
        
        @FindBy(xpath="//h5[text()='Information']")
        public WebElement Information_section_header;
        
        @FindBy(xpath="//h5[text()='Information']/parent::div")
        public WebElement Information_section;
        
        @FindBy(xpath="//h5[text()='Information']/parent::div/child::ul[@class='list-unstyled']")
        public WebElement Information_section_menu;
        
        @FindBy(xpath="//h5[text()='Information']/parent::div/descendant::a")
        public List<WebElement> Information_section_menu_items;
        
        @FindBy(xpath="//h5[text()='Customer Service']")
        public WebElement CustomerService_section_header;
        
        @FindBy(xpath="//h5[text()='Customer Service']/parent::div")
        public WebElement CustomerService_section;
        
        @FindBy(xpath="//h5[text()='Customer Service']/parent::div/child::ul[@class='list-unstyled']")
        public WebElement CustomerService_section_menu;
        
        @FindBy(xpath="//h5[text()='Customer Service']/parent::div/descendant::a")
        public List<WebElement> CustomerService_section_menu_items;
        
        @FindBy(xpath="//h5[text()='Extras']")
        public WebElement Extras_section_header;
        
        @FindBy(xpath="//h5[text()='Extras']/parent::div")
        public WebElement Extras_section;
        
        @FindBy(xpath="//h5[text()='Extras']/parent::div/child::ul[@class='list-unstyled']")
        public WebElement Extras_section_menu;
        
        @FindBy(xpath="//h5[text()='Extras']/parent::div/descendant::a")
        public List<WebElement> Extras_section_menu_items;
        
        @FindBy(xpath="//h5[text()='My Account']")
        public WebElement MyAccount_section_header;
        
        @FindBy(xpath="//h5[text()='My Account']/parent::div")
        public WebElement MyAccount_section;
        
        @FindBy(xpath="//h5[text()='My Account']/parent::div/child::ul[@class='list-unstyled']")
        public WebElement MyAccount_section_menu;
        
        @FindBy(xpath="//h5[text()='My Account']/parent::div/descendant::a")
        public List<WebElement> MyAccount_section_menu_items;
        
        public Landing_Page(WebDriver driver) {
        	
        	PageFactory.initElements(driver, this);
        }
        
        
    }
    
  //*[@id="menu"]/div[2]/ul/li[1]/a
  //*[@id="menu"]/div[2]/ul/li[1]/div
  //*[@id="menu"]/div[2]/ul/li[1]/div/div/ul
