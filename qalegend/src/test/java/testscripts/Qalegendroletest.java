package testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Fakerutility;
import utilities.RetryAnalyzer;

public class Qalegendroletest extends Baseclass{
	WebDriver driver;
@Test(retryAnalyzer = RetryAnalyzer.class, priority = 4, groups = {"smoke","regression"})
	public void createRoleName() throws InterruptedException 
	{
		loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.endTourButtonClick();
		homepage.clickOnUserManagementButton();
		homepage.clickOnRoleButton();
		rolepage.addRoleBtn().click();
		String rolename=Fakerutility.getFakeFirstName();
		rolepage.addRole(rolename);
		rolepage.searchRole(rolename);
		Assert.assertEquals(rolepage.roleNameFinder(), rolename);

	}

@Test(retryAnalyzer = RetryAnalyzer.class, priority=5,groups = {"smoke","regression"})
    public void deleteRoleName() throws InterruptedException
    {
		loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.endTourButtonClick();
		homepage.clickOnUserManagementButton();
		homepage.clickOnRoleButton();
		rolepage.addRoleBtn().click();
		String rolename=Fakerutility.getFakeFirstName();
		rolepage.addRole(rolename);
		rolepage.searchRole(rolename);
		rolepage.deleteRole();
		rolepage.searchRole(rolename);
		Assert.assertEquals(rolepage.getRoleTableStatus(), "No matching records found");
    }
@Test
public void TC01() throws AWTException {
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.endTourButtonClick();
	driver.navigate().to("https://qalegend.com/billing/public/products/create");
	driver.findElement(By.id("upload_image"));
	Robot rb=new Robot();
	StringSelection ss=new StringSelection("C:\\Users\\asus\\Downloads\\flower.jpg");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	//paste action
	rb.keyPress(KeyEvent.VK_CONTROL);
	rb.keyPress(KeyEvent.VK_V);
	rb.keyRelease(KeyEvent.VK_V);
	rb.keyRelease(KeyEvent.VK_CONTROL);
	rb.keyPress(KeyEvent.VK_ENTER);//click enter key
	rb.keyRelease(KeyEvent.VK_ENTER);//
}
	
}
