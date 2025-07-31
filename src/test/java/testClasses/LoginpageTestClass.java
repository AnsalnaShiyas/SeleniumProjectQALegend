package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.DataProviderClass;
import baseClass.BaseClass;
import pageClasses.HomepageClass;
import pageClasses.LoginpageClass;
import pageClasses.ResetPasswordClass;
import utilities.ExcelReadUtility;

public class LoginpageTestClass extends BaseClass {
	
	@Test
	public void verifySuccessfullLogin() throws IOException {
		LoginpageClass lp = new LoginpageClass(driver);
		HomepageClass hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0,"loginPage"),ExcelReadUtility.getIntegerData(0, 1,"loginPage"));
		hp.clickOnEndTourButton();
		String actualResult = hp.getTextOfWelcomeheading();
		String expectedResult = ExcelReadUtility.getStringData(7, 1, "loginPage");
		Assert.assertTrue(actualResult.contains(expectedResult));

	}

	@Test(dataProviderClass = DataProviderClass.class,dataProvider = "unsuccessfullLogin")
	public void verifyUnsuccessfullLogin(String uname,String pass) {
		LoginpageClass lp = new LoginpageClass(driver);
		lp = lp.invalidLogin(uname,pass);

		String actualResult = lp.getTextofInvalidErrormsg();
		String expectedResult = "These credentials do not match";
		Assert.assertTrue(actualResult.contains(expectedResult));

	}
	@Test
	public void verifyUsernameTextboxShowingHintorNot() {
		LoginpageClass lp = new LoginpageClass(driver);
		Boolean actualResult=lp.getPlaceholderattributeofUsername("placeholder").isEmpty();
		Assert.assertEquals(actualResult,true);
	}
	@Test
	public void  verifyCorrectApplicationisLaunchingWhileHitingURL() {
		LoginpageClass lp = new LoginpageClass(driver);
		String actualResult=lp.getTextofLoginPage();
		String expectedResult="Demo POS";
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	@Test
	public void verifyRemembermeCheckBoxisUncheckedByDefault() {
		LoginpageClass lp = new LoginpageClass(driver);
		Boolean actualResult=lp.rememberMeCheckBox();
		Assert.assertEquals(actualResult, false);
	}
	@Test
	public void verifyResetPasswordPageisComingWhileClickingonForgetyourPassword() {
		LoginpageClass lp = new LoginpageClass(driver);
		ResetPasswordClass rp= lp.clickonForgetPasswordButton();
		String actualResult=rp.getTextofRestPasswordWindow();
		String expectedResult="Reset Password";
		Assert.assertEquals(actualResult, expectedResult);
		
	}

}

