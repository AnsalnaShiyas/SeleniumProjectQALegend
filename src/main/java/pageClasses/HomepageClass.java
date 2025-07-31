package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.General_Utilities;
import utilities.WaitUtilities;

public class HomepageClass {
WebDriver driver;
WaitUtilities wait=new WaitUtilities();
General_Utilities gl = new General_Utilities();
	
	public HomepageClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endTourButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Welcome')]")
	WebElement welcomeHeading;
	
	@FindBy(id="btnCalculator")
	WebElement calculatorIcon;
	
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement userManagement;
	
	@FindBy(xpath = "//span[contains(text(),'Users')]")
	WebElement users;
	
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contacts;
	
	@FindBy(xpath = "//a[text()=' Suppliers']")
	WebElement suppliers;
	
	
	public UserPageClass openManageUsersPage() {
		userManagement.click();
		users.click();
		return  new UserPageClass(driver);
	}
	
	public void clickOnEndTourButton() {
		try {
			
			wait.waitForElementTobeVisible(driver, endTourButton, 5);
			if(endTourButton.isDisplayed()) {
				
				endTourButton.click();
				System.out.println("clicked on End tour buton");
			}
			else
			{
				System.out.println("End tour button is not visible");
			}
			
		} catch (Exception e) {
			System.out.println("Exception Ocuured "+e.getMessage());
		}
	}
	
	public String getTextOfWelcomeheading() {
		wait.waitForElementTobeVisible(driver, welcomeHeading, 5);
		return welcomeHeading.getText();
	}
	
	public String getTitleAttributeofcalculatorIcon(String attribute) {
		return gl.getAttributeof_Element(calculatorIcon, attribute);
	}
	public void clickOnContacts() {
		contacts.click();
	}
	public SuppliersPageClass clickOnSuppliers() {
		suppliers.click();
		return new SuppliersPageClass(driver);

	}

}
