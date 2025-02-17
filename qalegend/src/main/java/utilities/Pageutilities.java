package utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Pageutilities {
//Generic methods
	WebDriver driver;
	//click an element if selenium change the click 
	public static void ClickOnAnElement(WebElement element) {
		element.click();
	}
	// handle drop element by select class
	public static void SelectByValue(WebElement element, String Value) {
		Select select=new Select(element);
		select.selectByValue(Value);
	}
	public static void SelectByVisibleText(WebElement element, String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	public static void SelectByIndex(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	// enter a text
	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}
	public static void dragAndDrop(WebElement source, WebElement destination, WebDriver driver) {
		Actions action =new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();			
		}
	public static void rightClickOnanElement(WebElement element, WebDriver driver) {
		Actions action =new Actions(driver);
		action.contextClick(element).build().perform();
	}
	public static void rightClick(WebDriver driver) {
		Actions action =new Actions(driver);
		action.contextClick().build().perform();
	}
	public static void mouseOver(WebElement element, WebDriver driver) {
		Actions action =new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public static void clickUsingJavascriptExcecution(WebElement element, WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
		}
	public static void scrollTillElementVisibile(WebElement element, WebDriver driver)	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
		}
	public static boolean isElementVisible(WebElement element) {
		return(element.isDisplayed());
	}
	public static boolean  isElementEnabled(WebElement element) {
		return(element.isEnabled());
	}
	public static void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}
	public static void navigateTo(WebElement element, WebDriver driver, String value) {
		driver.navigate().to(value);
	}
	public static void navigateForward(WebDriver driver) {
		driver.navigate().forward();
	}
	public static void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	public static void alertToAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public static void alertToDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public static String getText(WebElement element, WebDriver driver, String text) {
		return(element.getText());
	}
	public static String getAttribute(WebElement element, WebDriver driver, String text) {
		return(element.getAttribute(text));
	}
	
	
	
	
	
}
//is enable, getattribute, 
//get text, 
