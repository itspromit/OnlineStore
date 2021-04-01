package pageObjects;
        import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;
    public class Landing_Page extends BaseClass{
            private static WebElement element = null;
            private static List<WebElement> list= null;
           
        public Landing_Page (WebDriver driver){
            	super(driver);
        }    
        public static WebElement Desktops_menu() throws Exception{
            try{ 
	        	 element = driver.findElement(By.xpath("//li[text()='Desktops']"));
	             
            }catch (Exception e){
           		String error=e.toString();
           		Log.info(error);
           		
           		}
           	return element;
        }
        
        public static WebElement LaptopsandNotebooks_menu() throws Exception{
            try{ 
	        	 element = driver.findElement(By.xpath("//li[text()='Laptops & Notebooks']"));
	             
            }catch (Exception e){
           		String error=e.toString();
           		Log.info(error);
           		
           		}
           	return element;
        }
        
        public static WebElement Components_menu() throws Exception{
            try{ 
	        	 element = driver.findElement(By.xpath("//li[text()='Components']"));
	             
            }catch (Exception e){
           		String error=e.toString();
           		Log.info(error);
           		
           		}
           	return element;
        }
        
        public static WebElement Tablets_menu() throws Exception{
            try{ 
	        	 element = driver.findElement(By.xpath("//li[text()='Tablets']"));
	             
            }catch (Exception e){
           		String error=e.toString();
           		Log.info(error);
           		
           		}
           	return element;
        }
        
        public static WebElement Software_menu() throws Exception{
            try{ 
	        	 element = driver.findElement(By.xpath("//li[text()='Software']"));
	             
            }catch (Exception e){
           		String error=e.toString();
           		Log.info(error);
           		
           		}
           	return element;
        }
        public static WebElement PhonesandPDAs_menu() throws Exception{
            try{ 
	        	 element = driver.findElement(By.xpath("//li[text()='Phones & PDAs']"));
	             
            }catch (Exception e){
           		String error=e.toString();
           		Log.info(error);
           		
           		}
           	return element;
        }
        public static WebElement lnk_LogOut() throws Exception{
            try{
	        	element = driver.findElement(By.id("account_logout"));
	        
	            Log.info("Log Out link is found on the Home Page");
            }catch (Exception e){
            	Log.error("Log Out link is not found on the Home Page");
           		throw(e);
           		}
           	return element;
        }
        
        

      
    }
