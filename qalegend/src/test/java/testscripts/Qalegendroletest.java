package testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Fakerutility;

public class Qalegendroletest extends Baseclass{
	WebDriver driver;
@Test
	public void createRoleName() throws InterruptedException 
	{
		loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.endTourButtonClick();
		homepage.clickOnUserManagementButton();
		homepage.clickOnRoleButton();
		rolepage.addRoleBtn().click();
		String rolename=Fakerutility.getFakeFirstName();
		rolepage.addRole(rolename);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		rolepage.searchRole(rolename);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(rolepage.roleNameFinder(), rolename);

	}

	@Test
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		rolepage.searchRole(rolename);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(rolepage.getRoleTableStatus(), "No matching records found");
    }


	
}
