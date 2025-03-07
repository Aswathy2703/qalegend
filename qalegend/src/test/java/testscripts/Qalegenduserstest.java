package testscripts;

import org.testng.annotations.Test;

import Constants.Constants;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageclasses.QalegendContactpage;
import pageclasses.QalegendHomePage;
import pageclasses.QalegendUserpage;
import pageclasses.Qalegend_loginpage;
import utilities.ExcelUtilities;

import utilities.Fakerutility;

public class Qalegenduserstest extends Baseclass {
WebDriver driver;

@Test
public void createAUser() {
loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));	
homepage.endTourButtonClick();
homepage.clickOnUserManagementButton();
homepage.clickOnUserButton();
userpage.addUserBtn().click();
String name= Fakerutility.getFakeFirstName();
String emailId=name+Fakerutility.getRandomNumber()+"@gmail.com";
String password="abcde12";
userpage.addUser(name, emailId, password);
userpage.searchUser(name);

Assert.assertEquals(userpage.userNameFinder(), name);

}
@Test
public void deleteAUser() {
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));	
	homepage.endTourButtonClick();
	homepage.clickOnUserManagementButton();
	homepage.clickOnUserButton();
	userpage.addUserBtn().click();
	String name= Fakerutility.getFakeFirstName();
	String emailId=name+Fakerutility.getRandomNumber()+"@gmail.com";
	String password="abcde12";
	userpage.addUser(name, emailId, password);
	userpage.searchUser(name);
	userpage.deleteUser();
	userpage.searchUser(name);
	
	Assert.assertEquals(userpage.getEmptyTableStatus(), "No matching records found");

}
@Test 
public void editAUser() throws InterruptedException{
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.endTourButtonClick();
	homepage.clickOnUserManagementButton();
	homepage.clickOnUserButton();
	userpage.addUserBtn().click();
	String name= Fakerutility.getFakeFirstName();
	String emailId=name+Fakerutility.getRandomNumber()+"@gmail.com";
	String password="abcde12";
	userpage.addUser(name, emailId, password);
	userpage.searchUser(name);
	userpage.editUser();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Assert.assertEquals(userpage.userNameFinder(), name);
	
}
@Test
public void addSalesCommissionAgent() throws InterruptedException {
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));	
	homepage.endTourButtonClick();
	homepage.clickOnUserManagementButton();
	homepage.clickOnSalesCommissionAgentButton();
	userpage.addSCAgent().click();
	String firstName= Fakerutility.getFakeName();
	int randomNumber=Fakerutility.getRandomNumber();
	userpage.addSCAgent(firstName, randomNumber);
	userpage.searchUser(firstName);
	Assert.assertEquals(userpage.userNameFinder(), firstName);
}


}
