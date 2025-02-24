package testscripts;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageclasses.QalegendHomePage;
import pageclasses.QalegendUserpage;
import pageclasses.Qalegend_loginpage;
import utilities.Fakerutility;

public class Qalegenduserstest extends Baseclass {
WebDriver driver;
Qalegend_loginpage loginpage;
QalegendHomePage homepage;
QalegendUserpage userpage;


@BeforeMethod
public void browserInitialization() throws Exception
{
	driver= initializemethod("Chrome");
	driver.get("https://qalegend.com/billing/public/login");
	driver.manage().window().maximize();//page maximize
	loginpage=new Qalegend_loginpage(driver);//call login page by creating object
	homepage= new QalegendHomePage(driver);
	userpage=new QalegendUserpage(driver);
}
@Test
public void createAUser() {
loginpage.loginToQalegend("admin", "123456");	
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
	loginpage.loginToQalegend("admin", "123456");	
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
public void editAUser() {
	loginpage.loginToQalegend("admin", "123456");	
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
	
}
@Test
public void addSalesCommissionAgent() {
	loginpage.loginToQalegend("admin", "123456");	
	homepage.endTourButtonClick();
	homepage.clickOnUserManagementButton();
	homepage.clickOnSalesCommissionAgentButton();
	userpage.addSCAgent().click();
	String name= Fakerutility.getFakeFirstName();
	String emailId=name+Fakerutility.getRandomNumber()+"@gmail.com";
	String password="abcde12";
	userpage.addUser(name, emailId, password);
	userpage.searchUser(name);
	Assert.assertEquals(userpage.userNameFinder(), name);
}

}
