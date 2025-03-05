package testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Constants.Constants;
import pageclasses.QalegendContactpage;
import pageclasses.QalegendHomePage;
import pageclasses.QalegendUserpage;
import pageclasses.Qalegend_loginpage;
import utilities.ExcelUtilities;
import utilities.Fakerutility;

public class QalegendContacttest extends Baseclass {
		WebDriver driver;
		
@Test
public void addSupplier() throws InterruptedException, IOException {
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.endTourButtonClick();
	homepage.clickOnContactButton();
	homepage.clickOnSupplierButton();
	contactpage.addSupplierBtn();
	Thread.sleep(3000);
			//String name=Fakerutility.getFakeFirstName();
	String name=ExcelUtilities.getStringData(1,0,Constants.EXCELFILEPATH,"Sheet1")+Fakerutility.getRandomNumber();
	String buisnessname=ExcelUtilities.getStringData(1, 1, Constants.EXCELFILEPATH, "Sheet1")+Fakerutility.getRandomNumber();
	String number=ExcelUtilities.getIntegerData(1, 2, Constants.EXCELFILEPATH, "Sheet1")+Fakerutility.getRandomNumber();
			//String buisnessname= Fakerutility.getFakeFirstName()+Fakerutility.getRandomNumber();
			//int number= Fakerutility.getRandomNumber();
	contactpage.addsupplier(name, buisnessname, number);	
	contactpage.searchSupplier(name);
	Assert.assertEquals(contactpage.supplierNameFinder(), name);
				
		}	
@Test
public void editAsupplier() throws InterruptedException, IOException {
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));	
	homepage.endTourButtonClick();
	homepage.clickOnUserManagementButton();
	homepage.clickOnUserButton();
	contactpage.addSupplierBtn();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	String name=ExcelUtilities.getStringData(1,0,Constants.EXCELFILEPATH,"Sheet1")+Fakerutility.getRandomNumber();
	String buisnessname=ExcelUtilities.getStringData(1, 1, Constants.EXCELFILEPATH, "Sheet1")+Fakerutility.getRandomNumber();
	String number=ExcelUtilities.getIntegerData(1, 2, Constants.EXCELFILEPATH, "Sheet1")+Fakerutility.getRandomNumber();
	contactpage.addsupplier(name, buisnessname, number);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	contactpage.searchSupplier(name);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	contactpage.
	Assert.assertEquals(userpage.getEmptyTableStatus(), "No matching records found");

}
@Test
public void createACustomer() throws InterruptedException {
	loginpage.loginToQalegend(prop.getProperty("username"), prop.getProperty("password"));
	homepage.endTourButtonClick();
	homepage.clickOnContactButton();
	homepage.clickOnCustomerButton();
	contactpage.addCustomerBtn();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	String name=Fakerutility.getFakeFirstName();
	String mobile="234567888";
	contactpage.addCustomer(name, mobile);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	contactpage.searchCustomer(name);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Assert.assertEquals(contactpage.customerNameFinder(), name);
	}

public void deleteACustomer() throws InterruptedException {
	loginpage.loginToQalegend(prop.getProperty("username"), prop.getProperty("password"));
	homepage.endTourButtonClick();
	homepage.clickOnContactButton();
	homepage.clickOnCustomerButton();
	contactpage.addCustomerBtn();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	String name=Fakerutility.getFakeFirstName();
	String mobile="234567888";
	contactpage.addCustomer(name, mobile);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	contactpage.searchCustomer(name);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Assert.assertEquals(contactpage.customerNameFinder(), name);
	}







}
