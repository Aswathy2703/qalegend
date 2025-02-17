package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass {
	public WebDriver driver;
	public WebDriver initializemethod (String browser) throws Exception
	{
		if (browser.equalsIgnoreCase("Chrome"))
		{
			driver= new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("Edge")) 
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			throw new Exception("Invalid browser name");
		}
		return driver;
	}
}
