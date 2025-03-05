package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import utilities.Pageutilities;

public class QalegendUserpage {
WebDriver driver;
@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
WebElement addUserButton;
@FindBy(id="first_name")
WebElement firstNameField;
@FindBy(id="email")
WebElement emailField;
@FindBy(id="password")
WebElement passwordField;
@FindBy(id="confirm_password")
WebElement confirmPasswordField;
@FindBy(id="submit_user_button")
WebElement saveButton;
@FindBy(xpath = "//input[@class='form-control input-sm']")
WebElement searchUserTextBox;
@FindBy(xpath = "(//tr[@class='odd' or @class='even']//td)[2]")
WebElement nameCell;
@FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_user_button']")
WebElement userDeleteButton;
@FindBy(xpath = "//button[text()='OK']")
WebElement userDeleteConfirmationButton;
@FindBy(xpath = "//td[@class='dataTables_empty']")
WebElement emptyTable;
@FindBy(xpath="//a[@class='btn btn-xs btn-primary']")
WebElement userEditButton;
@FindBy(id="submit_user_button")
WebElement userUpdateButton;
@FindBy(xpath = "//button[@class='btn btn-primary btn-modal pull-right']")
WebElement addSCAgentButton;
@FindBy(id="first_name")
WebElement firstnameSCAField;
@FindBy(id="cmmsn_percent")
WebElement salesComsnPercentage;
@FindBy(xpath="//button[@class='btn btn-primary']")
WebElement saveButtonSCA;
@FindBy(xpath="(//tr[@class='odd' or @class='even']//td)[1]")
WebElement scaNamecell;


public QalegendUserpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


public WebElement addUserBtn() {
	return(addUserButton);//3rd method to call element by return the pageclass and call in testcase page
}
public QalegendUserpage addUser(String firstname, String email, String password) {
	Pageutilities.enterText(firstNameField, firstname);
	Pageutilities.enterText(emailField, email);
	Pageutilities.enterText(passwordField, password);
	Pageutilities.enterText(confirmPasswordField, password);
	Pageutilities.ClickOnAnElement(saveButton);
	return this;//chaining of objects	
}
public void searchUser(String username) {
	Pageutilities.clearText(searchUserTextBox);
	searchUserTextBox.sendKeys(username);
}
public String userNameFinder() {
	String name=Pageutilities.getText(nameCell);
	return name;
}
public QalegendUserpage deleteUser() {
	Pageutilities.ClickOnAnElement(userDeleteButton);
	Pageutilities.ClickOnAnElement(userDeleteConfirmationButton);
	return this;
}
public QalegendUserpage editUser() {
	Pageutilities.ClickOnAnElement(userEditButton);
	Pageutilities.ClickOnAnElement(userUpdateButton);
	return this;
	
}
public String getEmptyTableStatus() {
	return(Pageutilities.getText(emptyTable));
}
public WebElement addSCAgent() {
	return(addSCAgentButton);
}
public QalegendUserpage addSCAgent(String firstname, int percentage) {
	Pageutilities.enterText(firstnameSCAField, firstname);
	Pageutilities.enterText(salesComsnPercentage, Integer.toString(percentage));
	Pageutilities.ClickOnAnElement(saveButtonSCA);
	return this;
}
public String scANameFinder() {
	String name=Pageutilities.getText(scaNamecell);
	return name;
}


}
