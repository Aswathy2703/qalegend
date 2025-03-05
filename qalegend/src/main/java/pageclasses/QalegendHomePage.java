package pageclasses;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Pageutilities;

public class QalegendHomePage {
WebDriver driver;
@FindBy(xpath = "//span[text()='User Management']")
WebElement userManagementButton;
@FindBy(xpath = "//i[@class='fa fa-user']//following-sibling::span")
//@FindBy(xpath = "(//span[@class='title'])[2]")
WebElement userButton;
@FindBy (xpath="//button[@class='btn btn-default btn-sm']")
WebElement endTourButton;
@FindBy(xpath = "(//span[@class='title'])[4]")
WebElement salesCommissionAgentButton;
@FindBy(xpath = "//span[text()='Contacts']")
WebElement contactButton;
@FindBy(xpath = "(//i[@class='fa fa-star']//parent::a)[1]")
WebElement supplierButton;
@FindBy(xpath = "(//i[@class='fa fa-star']//parent::a)[2]")
WebElement customerButton;
@FindBy(xpath="(//span[@class='title'])[3]")
WebElement roleButton;



public QalegendHomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void clickOnUserManagementButton() {
	Pageutilities.ClickOnAnElement(userManagementButton);//pageutilities method
	}
public void clickOnUserButton() {
	userButton.click();//normal method; click by page class
	}
public void endTourButtonClick() {
	try {
		endTourButton.click();
	}catch(Exception e){
		System.out.println("End tour button is not visible");
			}
}
public void clickOnSalesCommissionAgentButton() {
	salesCommissionAgentButton.click();
	}
public void clickOnContactButton() {
	contactButton.click();	
}
public void clickOnSupplierButton() {
	supplierButton.click();
}
public void clickOnCustomerButton() {
	customerButton.click();
}
public void clickOnRoleButton() {
	roleButton.click();
	
}
}
