package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilities;

public class ResetPasswordClass {
	
	WebDriver driver;
	WaitUtilities wait=new WaitUtilities();
		
		public ResetPasswordClass(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
			
		}
			
		@FindBy(xpath = "//div[text()='Reset Password']")
		WebElement resetPasswordText;
		
		public String getTextofRestPasswordWindow() {
			return resetPasswordText.getText();
		}

}
