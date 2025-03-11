package testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Fakerutility;
import utilities.RetryAnalyzer;

public class Qalegendroletest extends Baseclass{
	WebDriver driver;
@Test(retryAnalyzer = RetryAnalyzer.class, priority = 4)
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

@Test(retryAnalyzer = RetryAnalyzer.class, priority=5)
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


	
}
