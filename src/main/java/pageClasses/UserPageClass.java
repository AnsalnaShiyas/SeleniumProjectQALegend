package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freemarker.core.ReturnInstruction.Return;
import utilities.General_Utilities;
import utilities.TableUtility;
import utilities.WaitUtilities;

public class UserPageClass {

	WebDriver driver;
	WaitUtilities wait = new WaitUtilities();
	General_Utilities gl=new General_Utilities();

	public UserPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h1[contains(text(),'Users')]")
	WebElement usersPageHeading;

	@FindBy(xpath = "//a[text()=' Add']")
	WebElement addButton;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;
	
	@FindBy(xpath = "//table/tbody/tr")
	List<WebElement> rows;
	
	
	@FindBy(xpath = "//span//i[contains(@class,'fa fa-list')]")
	WebElement actionButton;
	
	@FindBy(xpath = "//a[text()=' Print']")
	WebElement printButton;
	
	@FindBy(xpath = "//button[text()=' Delete']")
	WebElement deleteButton;
	
	@FindBy(xpath = "//button[text()='OK']")
	WebElement okButton;
	

	
	public String getTextOfUsersPage() {
		return usersPageHeading.getText();

	}

	public AddUserClass clickOnAddButton() {
		addButton.click();
		return new AddUserClass(driver);
	}
	
	public boolean searchForUser(String searchParameter) throws InterruptedException {
		
		gl.addSleep_Utility(2000);
		searchBox.sendKeys(searchParameter);
		//String tableXpath="//table[@id='users_table']/tbody/tr";
		
		boolean searchResult=TableUtility.isTextPresentInTable(driver, "//table[@id='users_table']/tbody/tr", searchParameter);
		return searchResult;
	}
	
	public void clickOnActionButton() {
		wait.waitForElementTobeVisible(driver, deleteButton, 5);
		actionButton.click();
	}
	
	public PrinterPreferencePage clickOnPrintButton() {
		printButton.click();
		return new PrinterPreferencePage(driver);
	}
	public UserPageClass clickOndeleteUser() {
		deleteButton.click();
		okButton.click();
		return this;
		
	}
	public void clearSearchBox() throws InterruptedException {
		gl.addSleep_Utility(2000);
		searchBox.clear();
	}
	
	}


