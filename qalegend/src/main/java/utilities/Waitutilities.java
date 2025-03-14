package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.Constants;

public class Waitutilities {
//handle explicit wait
	public WebDriver driver;
	public static void waitForClickingElement(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	public static void waitForTexttobePresentInElement(WebDriver driver, WebElement element, String text) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		}
	public static void waitForElementtobeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		}
	public static void waitForVisibilityofElement(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	public static void waitForanAlert(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.alertIsPresent());	
	}
	public static void waitForanElementAttributetobe(WebElement element, WebDriver driver, String attributevalue, String attributename) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.attributeToBe(element, attributename, attributevalue));	
	}
	public static void waitForElementtobeInvisible(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
}
