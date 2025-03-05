package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtilities {
public void captureFailureScreenshot(WebDriver driver, String name) throws IOException{
	TakesScreenshot scrshot=(TakesScreenshot)driver;//convert the current driver to driver to take screenshot interface is takescreenshot
	File screenshot=scrshot.getScreenshotAs(OutputType.FILE);//take screenshot in file format and store in tempory space
	File f1=new File(System.getenv("user.dir")+"\\Outputscreenshot");//create a folder to store screenshot
	if(!f1.exists()) {
		f1.mkdirs();//check if folder is exist
	}
	String timeStamp=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(new Date(0));//date of system is fetch and store in timestamp
	File finalDestination=new File(System.getProperty("user.dir")+"\\Outputscreenshot\\"+name+"_"+timeStamp+".png"); //capture screenshot and store in given format (in virtual space)
	FileHandler.copy(screenshot, finalDestination);//save the screenshot from virtual space(RAM)	
	
}
}
