package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilities;

public class AddUserClass {
	
	WebDriver driver;
	WaitUtilities wait=new WaitUtilities();

		
		public AddUserClass(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);

}
		
		@FindBy(id = "first_name")
		WebElement firstName;
		
		@FindBy(id="email")
		WebElement email;
		
		@FindBy(id="password")
		WebElement password;
		
		@FindBy(id = "confirm_password")
		WebElement confirmPassword;
		
		@FindBy(id = "submit_user_button")
		WebElement submitButton;
		
		public UserPageClass addNewUser(String name,String emailId,String pass,String confirmPass) {
			
		
			
			firstName.sendKeys(name);
			email.sendKeys(emailId);
			password.sendKeys(pass);
			confirmPassword.sendKeys(confirmPass);
			submitButton.click();
			
			return new UserPageClass(driver);
			
		}
		
		
		
		
		
}
