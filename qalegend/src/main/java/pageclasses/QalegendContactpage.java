package pageclasses;

import org.apache.commons.math3.ml.neuralnet.UpdateAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Pageutilities;

public class QalegendContactpage {
	WebDriver driver;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement addSupButton;
	@FindBy(id="name")
	WebElement supNameField;
	@FindBy(id="supplier_business_name")
	WebElement supBussinessNameField;
	@FindBy(id="mobile")
	WebElement supMobileNumField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement supSaveButton;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement supSearchButton;
	@FindBy(xpath ="(//tr[@class='odd' or @class='even']//td)[2]")
	WebElement supNamecell;
	@FindBy(xpath = "//span[@class='caret']")
	WebElement supActionButton;
	@FindBy(xpath = "//a[@class='delete_contact_button']")
	WebElement supDeleteButton;
	@FindBy(xpath = "//a[@class='edit_contact_button']")
	WebElement supEditButton;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement supUpdateButton;
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement addcustomerButton;
	@FindBy(id="name")
	WebElement CustNameField;
	@FindBy(id="mobile")
	WebElement custMobileField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement custSaveBtn;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement searchCustNameBox;
	@FindBy(xpath="(//tr[@class='odd' or @class='even']//td)[2]")
	WebElement custNamecell;
	
	public QalegendContactpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void addSupplierBtn() {
				addSupButton.click();
	}
	
public QalegendContactpage addsupplier(String name, String businessName, String number) {
		Pageutilities.enterText(supNameField, name);
		Pageutilities.enterText(supBussinessNameField, businessName);
		Pageutilities.enterText(supMobileNumField, number);
		Pageutilities.ClickOnAnElement(supSaveButton);
		return this;//chaining of objects	
	}
	
	public void searchSupplier(String firstname) {
		Pageutilities.clearText(supSearchButton);
		supSearchButton.sendKeys(firstname);
	}
	public String supplierNameFinder() {
		String name=Pageutilities.getText(supNamecell);
		return name;
	}
	public void ClickOnSupActionBtn() {
		Pageutilities.ClickOnAnElement(supActionButton);
	}
	public void clickOnEditSupBtn() {
		Pageutilities.ClickOnAnElement(supEditButton);
	}
public void clickOnUpdateSupBtn() {
	Pageutilities.ClickOnAnElement(supUpdateButton);
}
public void name() {
	
}
public void editSupBuisnessName(String buisnessname) {
	supUpdateButton.clear();
	supUpdateButton.sendKeys(buisnessname);
}
	
public QalegendContactpage editSupplier() {
	Pageutilities.ClickOnAnElement(supEditButton);
	Pageutilities.ClickOnAnElement(supUpdateButton);
	return this;
	}

public QalegendContactpage deleteSupplier(String name, String businessName, String number) {
		Pageutilities.enterText(supNameField, name);
		Pageutilities.enterText(supBussinessNameField, businessName);
		Pageutilities.enterText(supMobileNumField, number);
		Pageutilities.ClickOnAnElement(supSaveButton);
		return this;//chaining of objects	
	}
	public WebElement addCustomerBtn() {
		return(addCustomerBtn());	
	}
	public QalegendContactpage addCustomer(String name, String mob) {
		Pageutilities.enterText(CustNameField, name);
		Pageutilities.enterText(custMobileField, mob);
		Pageutilities.ClickOnAnElement(custSaveBtn);
		return this;
	}
	public void searchCustomer(String CustomerName) {
		Pageutilities.clearText(searchCustNameBox);
		searchCustNameBox.sendKeys(CustomerName);
	}
	public String customerNameFinder() {
		String name=Pageutilities.getText(custNamecell);
		return name;
	}
}
