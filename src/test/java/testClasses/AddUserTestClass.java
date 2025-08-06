package testClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageClasses.AddUserClass;
import pageClasses.HomepageClass;
import pageClasses.LoginpageClass;
import pageClasses.UserPageClass;
import utilities.ExcelReadUtility;
import utilities.RandonDataGenerator;

public class AddUserTestClass extends BaseClass {
  @Test
  public void verifyUserIsAbletoAddNewUserDetailsAndSearchForuser() throws IOException, InterruptedException {
	  
	  LoginpageClass lp = new LoginpageClass(driver);
		HomepageClass hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0,"loginPage"),ExcelReadUtility.getIntegerData(0, 1,"loginPage"));
		hp.clickOnEndTourButton();
		UserPageClass us=hp.openManageUsersPage();
        AddUserClass adu= us.clickOnAddButton();
        String firstName=RandonDataGenerator.getFirstName(); // Random data generator to get firstName
		String email=RandonDataGenerator.getEmail();
		String password=RandonDataGenerator.getPassword();
        us=adu.addNewUser(firstName, email, password,password);
		boolean searchStatuse=us.searchForUser(firstName);
		AssertJUnit.assertTrue(searchStatuse);
	
	}
}
