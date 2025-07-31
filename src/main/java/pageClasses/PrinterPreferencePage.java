package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.General_Utilities;
import utilities.WaitUtilities;

public class PrinterPreferencePage {
	WebDriver driver;
	General_Utilities gl = new General_Utilities();
	WaitUtilities wait = new WaitUtilities();

	public PrinterPreferencePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
	
	@FindBy(id = "destination-label")
	WebElement prinetDestinationText;
	
	public String getTextofPrinetrPreferencePage() {
	 return	prinetDestinationText.getText();
		
	}
}
