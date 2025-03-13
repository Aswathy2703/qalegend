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
import utilities.RetryAnalyzer;

public class QalegendContacttest extends Baseclass {
		WebDriver driver;
		
@Test(retryAnalyzer = RetryAnalyzer.class, priority = 6,  groups = "smoke")
public void addSupplier() throws InterruptedException, IOException {
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.endTourButtonClick();
	homepage.clickOnContactButton();
	homepage.clickOnSupplierButton();
	contactpage.addSupplierBtn();
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
@Test(retryAnalyzer = RetryAnalyzer.class, priority = 7, groups = "smoke")
public void editAsupplier() throws InterruptedException, IOException {
	loginpage.loginToQalegend(prop.getProperty("username"),prop.getProperty("password"));	
	homepage.endTourButtonClick();
	homepage.clickOnUserManagementButton();
	homepage.clickOnUserButton();
	contactpage.addSupplierBtn();
	String name=ExcelUtilities.getStringData(1,0,Constants.EXCELFILEPATH,"Sheet1")+Fakerutility.getRandomNumber();
	String buisnessname=ExcelUtilities.getStringData(1, 1, Constants.EXCELFILEPATH, "Sheet1")+Fakerutility.getRandomNumber();
	String number=ExcelUtilities.getIntegerData(1, 2, Constants.EXCELFILEPATH, "Sheet1")+Fakerutility.getRandomNumber();
	contactpage.addsupplier(name, buisnessname, number);
	contactpage.searchSupplier(name);
	contactpage.ClickOnSupActionBtn();
	String supBuisnessname=ExcelUtilities.getStringData(1, 3, Constants.EXCELFILEPATH, "Sheet1")+Fakerutility.getRandomNumber();
	contactpage.editSupBuisnessName(buisnessname);
	contactpage.clickOnUpdateSupBtn();
	contactpage.searchSupplier(name);
	Assert.assertEquals(userpage.getEmptyTableStatus(), "No matching records found");

}
@Test(retryAnalyzer = RetryAnalyzer.class, priority = 8, groups = {"smoke","regression"})
public void createACustomer() throws InterruptedException {
	loginpage.loginToQalegend(prop.getProperty("username"), prop.getProperty("password"));
	homepage.endTourButtonClick();
	homepage.clickOnContactButton();
	homepage.clickOnCustomerButton();
	contactpage.addCustomerBtn();
	String name=Fakerutility.getFakeFirstName();
	String mobile="234567888";
	contactpage.addCustomer(name, mobile);
	contactpage.searchCustomer(name);
	Assert.assertEquals(contactpage.customerNameFinder(), name);
	}
@Test(retryAnalyzer = RetryAnalyzer.class, priority = 9, groups = {"smoke","regression"})
public void deleteACustomer() throws InterruptedException {
	loginpage.loginToQalegend(prop.getProperty("username"), prop.getProperty("password"));
	homepage.endTourButtonClick();
	homepage.clickOnContactButton();
	homepage.clickOnCustomerButton();
	contactpage.addCustomerBtn();
	String name=Fakerutility.getFakeFirstName();
	String mobile="234567888";
	contactpage.addCustomer(name, mobile);
	contactpage.searchCustomer(name);
	Assert.assertEquals(contactpage.customerNameFinder(), name);
	}







}
