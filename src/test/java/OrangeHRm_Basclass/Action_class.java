package OrangeHRm_Basclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import OrangeHRM_Utilities.Text_page_Reader_Class;


public class Action_class extends Base_class {

	Text_page_Reader_Class text=new Text_page_Reader_Class();
	
	
	
	public By getlocators(String locatortype,String locatorvalue) {
		switch(Locators.valueOf(locatortype)) {
		
		case id:
			return By.id(locatorvalue);
		case name:
			return By.name(locatorvalue);
		case classname:
		    return By.className(locatorvalue);
		case xpath:
			return By.xpath(locatorvalue);
		case css:
			return By.cssSelector(locatorvalue);
		case linktext:
			return By.linkText(locatorvalue);
		default:
			return By.id(locatorvalue);
		
		
		}
	}
	
	
	
	
	
	protected By getlocator(String elementname) {
		String locator[]=text.text_read_test(elementname);
		return getlocators(locator[1].trim(), locator[2].trim());
	}
	
	protected By getlocator(String elementname,String replacement) {
		String [] locator= text.text_read_test(elementname);
		locator[2]=locator[2].replaceAll("\\$\\{.+?\\}", replacement);
		return getlocators(locator[1].trim(),locator[2].trim());
	}

	protected By getlocator(String elementname,String replacement1,String replacement2) {
		String [] locator= text.text_read_test(elementname);
		locator[2]=locator[2].replaceFirst("\\$\\{.+?\\}", replacement1);
		locator[2]=locator[2].replaceFirst("\\$\\{.+?\\}", replacement2);
		return getlocators(locator[1].trim(),locator[2].trim());
	}


	protected By getlocator(String elementname,String replacement1,String replacement2,String replacement3) {
		String [] locator= text.text_read_test(elementname);
		locator[2]=locator[2].replaceFirst("\\$\\{.+?\\}", replacement1);
		locator[2]=locator[2].replaceFirst("\\$\\{.+?\\}", replacement2);
		locator[2]=locator[2].replaceFirst("\\$\\{.+?\\}", replacement3);
		return getlocators(locator[1].trim(),locator[2].trim());
	}


	
	
	public WebElement elements(String elementlocater,String replacement1,String replacement2,String replacement3) {

		if(replacement1.isEmpty()&& replacement2.isEmpty()) {
			return driver.findElement(getlocator(elementlocater));
		}
		else if(!replacement1.isEmpty()|| replacement2.isEmpty()) {
			return driver.findElement(getlocator(elementlocater, replacement1));
		}
		else if(!replacement1.isEmpty()|| !replacement2.isEmpty()) {
			return driver.findElement(getlocator(elementlocater, replacement1, replacement2));
		}
		else if(!replacement1.isEmpty() || !replacement2.isEmpty() || !replacement3.isEmpty()) {
			return driver.findElement(getlocator(elementlocater, replacement1, replacement2, replacement3));
		}
		else {
			logger.info("Invalide elements enter");
		}
		
		
		return driver.findElement(getlocator(elementlocater));
		
		
	}
	
	
	public WebElement element(String elementlocator) {
		return elements(elementlocator, "", "", "");
	}
	
	
	public WebElement element(String elementlocator,String replacement1) {
		return elements(elementlocator, replacement1, "", "");
	}
	
	
	
	public WebElement element(String elementlocator,String replacement1,String replacement2) {
		return elements(elementlocator, replacement1, replacement2, "");
	}
	
	
	
	public WebElement element(String elementlocator,String replacement1,String replacement2,String replacement3) {
		return elements(elementlocator, replacement1, replacement2, replacement3);
	}
	
	
	
	public void click(String element) {
		String name=element(element).getText();
		element(element).click();
		logger.info("successfully click on "+name);
		Reporter.log("successfully click on "+name);
	}
	
	public void click(String element,String replacement1) {
		String name=element(element,replacement1).getText();
		element(element,replacement1).click();
		logger.info("successfully click on "+name);
		Reporter.log("successfully click on "+name);
	}
	
	
	public void clickbyjavaScript(String elementname) {
		String name=element(elementname).getText();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element(elementname));
		logger.info("successfully click on "+name);
		Reporter.log("successfully click on "+name);
	}
	
	
	public void clickbyjavaScript(String elementname,String replacement1) {
		String name=element(elementname,replacement1).getText();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element(elementname,replacement1));
		logger.info("successfully click on "+name);
		Reporter.log("successfully click on "+name);
	}
	
	
	public void click(String element,String replacement1,String replacement2) {
		element(element,replacement1,replacement2).click();
	}
	
	public void click(String element,String replacement1,String replacement2,String replacement3) {
		element(element,replacement1,replacement2,replacement3).click();
	}
	
	public void waitforelementvisible(String elementlocater ) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(getlocator(elementlocater)));
		logger.info("element is visible");
		Reporter.log("element is visible");
	}
	
	
	public List<WebElement> elements(String elementname){
		   String [] locator= text.text_read_test(elementname);
			return driver.findElements(getlocators(locator[1].trim(),locator[2].trim()));
		
			
	}


	   public List<WebElement> elements(String elementname,String replacement){
		   String [] locator= text.text_read_test(elementname);
		   locator[2]=locator[2].replaceAll("\\$\\{.+?\\}", replacement);
		   return driver.findElements(getlocators(locator[1].trim(),locator[2].trim()));
		
			
	}

	   public List<WebElement> elements(String elementname,String replacement,String replacement2){
		   String [] locator= text.text_read_test(elementname);
		   locator[2]=locator[2].replaceFirst("\\$\\{.+?\\}", replacement);
		   locator[2]=locator[2].replaceFirst("\\$\\{.+?\\}", replacement2);
		   return driver.findElements(getlocators(locator[1].trim(),locator[2].trim()));
		
	
	
	   }
	
	   
	   
	   
	   public void verifycolorvalue(String locator,String cssname,String expected) {
		   logger.info("checking color matched the expected value");
		   Reporter.log("checking color matched the expected value"); 
		   String colorvalue=element(locator).getCssValue(cssname);
		   String colorhex=Color.fromString(colorvalue).asHex(); 
		   logger.info("expected color ==>"+expected);
		   Reporter.log("expected color ==>"+expected);
		   logger.info("actual color ==>"+colorhex);
		   Reporter.log("actual color ==>"+colorhex);
		   Assert.assertEquals(colorhex.trim().toUpperCase(), expected.toUpperCase(),"Assertion failed:color is not verified");   
		  logger.info("color is matched successfully passed"); 
		  Reporter.log("color is matched successfully passed"); 
		  
	   }
	
	   
	   public void verifycolorhexfromrbg(String locator,String cssname,String expected) {
		   logger.info("checking color matched the expected value");
		   String colorvalue=element(locator).getCssValue(cssname);
		   int i;
		   for(i=0;i<colorvalue.length();i++) {
			   Character ch=colorvalue.charAt(i);
			   if(!ch.equals('('))continue;
			   break;
		   }
		   String rbga[]=colorvalue.substring(i+1, colorvalue.length()-1).split(",");
		   String hex=String.format("#%02x%02x%02x", Integer.parseInt(rbga[0].trim()),Integer.parseInt(rbga[1].trim()),
				   Integer.parseInt(rbga[2].trim()));
		   Assert.assertEquals(hex.trim(), expected,"Assertion failed:color not verified");   
			  logger.info("color is matched successfully passed");
		 
	   }
	   
	   
	public void hardwait(int mseconds) {
		
		try {
			Thread.sleep(mseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	   
	   
	public void sendkeys(String locatorname,String sendkeysname) {	
		element(locatorname).clear();
		element(locatorname).sendKeys(sendkeysname);
		hardwait(1000);
		logger.info("Text entered successfully passed ==> "+sendkeysname);
		Reporter.log("Text entered successfully passed ==> "+sendkeysname);
		
		
	}
	   
	
	public void sendkeys(String locatorname,String replacement1,String sendkeysname) {	
		element(locatorname,replacement1).clear(); 
		element(locatorname,replacement1).sendKeys(sendkeysname);
		hardwait(1000);
		logger.info("Text entered successfully passed ==> "+sendkeysname);
		Reporter.log("Text entered successfully passed ==> "+sendkeysname);
		
	}
	
	public void sendkeys(String locatorname,String replacement1,String replacement2,String sendkeysname) {	
		 element(locatorname,replacement1,replacement2).clear(); 
		 element(locatorname,replacement1,replacement2).sendKeys(sendkeysname);
		 hardwait(1000);
		logger.info("Text entered successfully passed ==> "+sendkeysname);
		Reporter.log("Text entered successfully passed ==> "+sendkeysname);
		
	}
	   
	
	   public void checkelementisdisplayed(String locatorname) {
		boolean display=element(locatorname).isDisplayed();
		Assert.assertTrue(display);
		logger.info("Element is Displayed successdully");
		Reporter.log("Element is Displayed successdully");
		
	}
	
	   public void checkelementisdisplayed(String locatorname,String replacement1) {
			boolean display=element(locatorname,replacement1).isDisplayed();
			Assert.assertTrue(display);
			logger.info("Element is Displayed successdully");
			Reporter.log("Element is Displayed successdully");
			
		} 
	   
	   
	   public void uploadfilebyrobot(String uploadfile) {
			Robot r;
			try {
				r = new Robot();
			r.setAutoDelay(2000);
			StringSelection ss=new StringSelection(uploadfile);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

	   
	   
	   public void MoveToElement(String elementname) {
		  Actions action=new Actions(driver);
		  action.moveToElement(element(elementname));
		  
	   }
	   public void MoveToElement(String elementname,String replacement1) {
			  Actions action=new Actions(driver);
			  action.moveToElement(element(elementname,replacement1));
			  
		   }
	   public void ScreenShot(String name,String time) {
		   TakesScreenshot tc=(TakesScreenshot)driver;
		   File file=tc.getScreenshotAs(OutputType.FILE);
		   try {
			FileUtils.copyFile(file, new File(".\\screenshot\\"+name+""+time+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }
	   
	   
	   public void ListElementsclickspecificvalue(String elementpath,String valuename) {
		   List<WebElement> list=action.elements(elementpath);
		    for (WebElement webElement : list) {
			String name=webElement.getText();
		    	if(name.contains(valuename)) {
		    		webElement.click();
		    		break;
		    	}
			}
	   }
	   
	   
}
