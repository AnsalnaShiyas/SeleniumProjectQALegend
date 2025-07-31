package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.General_Utilities;
import utilities.WaitUtilities;

public class LoginpageClass {

	WebDriver driver;
	General_Utilities gl = new General_Utilities();
	WaitUtilities wait = new WaitUtilities();

	public LoginpageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement loginButton;

	@FindBy(xpath = "//strong[text()='These credentials do not match our records.']")
	WebElement invalidErrorMsg;

	@FindBy(xpath = "//h1[text()='Demo POS']")
	WebElement homePageText;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement remembermeCheckBbox;
	
	@FindBy(xpath = "//a[contains(text(),' Forgot Your Password? ')]")
	WebElement forgetPasswordButton;

	public HomepageClass validLogin(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomepageClass(driver);
	}

	public LoginpageClass invalidLogin(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		return this; // return LoginpageClass.this;
	}

	public String getTextofInvalidErrormsg() {
		return invalidErrorMsg.getText();
	}

	public String getPlaceholderattributeofUsername(String attribute) {
		return gl.getAttributeof_Element(username, attribute);

	}

	public String getTextofLoginPage() {
		wait.waitForElementTobeVisible(driver, homePageText, 5);
		return homePageText.getText();
}
	public boolean rememberMeCheckBox() {
		return gl.is_Element_selected(remembermeCheckBbox);
	}
	public ResetPasswordClass clickonForgetPasswordButton() {
		forgetPasswordButton.click();
		return new ResetPasswordClass(driver);
	}
}
