package testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import pageclasses.QaLegendRolePage;
import pageclasses.QalegendContactpage;
import pageclasses.QalegendHomePage;
import pageclasses.QalegendUserpage;
import pageclasses.Qalegend_loginpage;
import utilities.ScreenshotUtilities;

public class Baseclass {
	WebDriver driver;
	Qalegend_loginpage loginpage;
	QalegendHomePage homepage;
	QalegendUserpage userpage;
	QalegendContactpage contactpage;
	Properties prop;
	FileInputStream fis;
	QaLegendRolePage rolepage;
	
	
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	
	}
	

	@BeforeMethod(groups = {"smoke","regression"})//to run groups
	@Parameters({"browser"})
		
	public void browserInitialization(String browserName) throws Exception
	{
		driver= initializemethod(browserName);
		//driver.get("https://qalegend.com/billing/public/login");
		prop=new Properties();
		String path=System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\data.properties";//to set dynamic path
		fis=new FileInputStream(path);
		prop.load(fis);//to load property file
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();//page maximize
		loginpage=new Qalegend_loginpage(driver);//call login page by creating object
		homepage= new QalegendHomePage(driver);
		userpage=new QalegendUserpage(driver);
		contactpage=new QalegendContactpage(driver);
		rolepage = new QaLegendRolePage(driver);
		
	}
	//screenshot if test fail and store in 
	@AfterMethod(groups = {"smoke","regression"})
	public void afterMethod(ITestResult itResult) throws IOException {
		if(itResult.getStatus()==ITestResult.FAILURE) {
			ScreenshotUtilities sc=new ScreenshotUtilities();
			sc.captureFailureScreenshot(driver, itResult.getName());
		}
		if(driver!=null) {
			driver.quit();//after each testcase the browser will close 
		}
		
	}
}
