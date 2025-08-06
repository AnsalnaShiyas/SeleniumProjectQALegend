package testClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageClasses.AddUserClass;
import pageClasses.HomepageClass;
import pageClasses.LoginpageClass;
import pageClasses.PrinterPreferencePage;
import pageClasses.UserPageClass;
import utilities.ExcelReadUtility;

public class userTestClass extends BaseClass {
	
@Test

public void verifyUsercanNavigateToManageUserPageByClickingOnUsers() {
	  
	  LoginpageClass lp = new LoginpageClass(driver);
		HomepageClass hp = lp.validLogin("admin", "123456");
		hp.clickOnEndTourButton();
		UserPageClass us= hp.openManageUsersPage();
		String actualResult=us.getTextOfUsersPage();
		System.out.println(actualResult);
		String expectedResult="Users Manage users";
		AssertJUnit.assertEquals(actualResult, expectedResult);
}
		

  
  
  @Test
  
  public void verifyUserisAbleToAddSearchandDeleteUser() throws IOException, InterruptedException {
	  LoginpageClass lp = new LoginpageClass(driver);
		HomepageClass hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0,"loginPage"),ExcelReadUtility.getIntegerData(0, 1,"loginPage"));
		hp.clickOnEndTourButton();
		UserPageClass us=hp.openManageUsersPage();
	
		AddUserClass adu= us.clickOnAddButton();
        us=adu.addNewUser("Ansalna", "6786@rhjh", "yui876", "yui876");
		boolean searchStatuse=us.searchForUser("Ansalna");
		us=us.clickOndeleteUser();
		us.clearSearchBox();
		boolean searchStatuse2=us.searchForUser("Ansalna");
		System.out.println(searchStatuse2);
		AssertJUnit.assertFalse(searchStatuse2);
		
		
  }
}
