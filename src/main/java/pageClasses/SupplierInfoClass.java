package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.General_Utilities;
import utilities.WaitUtilities;

public class SupplierInfoClass {
	
	WebDriver driver;
	WaitUtilities wait = new WaitUtilities();
	General_Utilities gl=new General_Utilities();

	public SupplierInfoClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//h1[text()='View Contact']")
	WebElement supplierContactHeading;
	
	public String getTextofSupplierContactPageHeading() {
		return supplierContactHeading.getText();
	}
	

}
