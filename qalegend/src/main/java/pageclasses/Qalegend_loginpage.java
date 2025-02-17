package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Pageutilities;

public class Qalegend_loginpage {
WebDriver driver;
@FindBy(id ="username")        //find web element annotation
WebElement usernamefield;
@FindBy(id="password")
WebElement passwordfield;
@FindBy(xpath = "//button[@class='btn btn-primary']")
WebElement loginbutton;

public void loginToQalegend(String username, String password) {
	//usernamefield.sendKeys(username);
	//passwordfield.sendKeys(password);
	//loginbutton.click();
	Pageutilities.enterText(usernamefield,username);
	Pageutilities.enterText(passwordfield,password);
	Pageutilities.ClickOnAnElement(loginbutton);
	
}







}
