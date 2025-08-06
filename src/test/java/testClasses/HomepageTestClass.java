package testClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageClasses.HomepageClass;
import pageClasses.LoginpageClass;
import utilities.ExcelReadUtility;

public class HomepageTestClass extends BaseClass {
  @Test (groups = {"group1"})
  public void verifyTooltipOfCalculatorIcon() throws IOException {
	  
	    LoginpageClass lp = new LoginpageClass(driver);
		HomepageClass hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0,"loginPage"),ExcelReadUtility.getIntegerData(0, 1,"loginPage"));
		hp.clickOnEndTourButton();
		String actualResult=hp.getTitleAttributeofcalculatorIcon("data-original-title");
		System.out.println(actualResult);
		String expectedResult="Calculator";
		Assert.assertEquals(actualResult, expectedResult);
		
		//create user management page and test class
		//action method: click on usermanagement in homepage and rturn to new page
		//usermanagement test class : verify to add a new user, click on add button(enter fname, lname, emailid,username,password)
		//save back to userpage, check the added name is there by searching in the search box
		
  }
}
