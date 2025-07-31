package pageClasses;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.General_Utilities;
import utilities.TableUtility;
import utilities.WaitUtilities;

public class SuppliersPageClass {
	
	WebDriver driver;
	WaitUtilities wait = new WaitUtilities();
	General_Utilities gl=new General_Utilities();

	public SuppliersPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath =" (//button[text()='Actions'])[1]")
	WebElement actionButton;

	@FindBy(xpath ="(//a[text()=' View'])[1]")
	WebElement viewOption;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;
	
	
	public void clickOnActionButtonofthefirstSupplierRow() {
	    actionButton.click();
	    
	}
	public SupplierInfoClass clickOnViewOption() {
		viewOption.click();
		return new SupplierInfoClass(driver);
		
	}
public boolean searchForUser(String searchParameter) {
		
		String tableXpath="//table[@id='contact_table']/tbody/tr";
		searchBox.sendKeys(searchParameter);
		Boolean searchResult=TableUtility.isTextPresentInTable(driver, tableXpath, searchParameter);
		return searchResult;
}
}
