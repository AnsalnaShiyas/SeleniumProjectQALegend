package baseClass;

import org.testng.annotations.Test;

import constants.ConstantsClass;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
  
	public WebDriver driver;
	public static Properties property; 
	
	public static void readProperty() throws IOException {
		
		property=new Properties();// instantiate property class using class object
		FileInputStream file=new FileInputStream(ConstantsClass.filepath); //user.dir applies to make same path for all OS, replace the path u to project name
		property.load(file);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		
        readProperty(); // call static method
		driver = new ChromeDriver();
		driver.get(property.getProperty("Base_URL"));//read the property of URL by passing variable
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConstantsClass.implicitWaitTimeDuration));
	}

	@AfterMethod
	public void afterMethod() {

		// driver.quit();
	}
}
