package testClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageClasses.HomepageClass;
import pageClasses.LoginpageClass;
import pageClasses.SupplierInfoClass;
import pageClasses.SuppliersPageClass;
import utilities.ExcelReadUtility;

public class SupplierTestClass extends BaseClass {
  @Test
  public void verifyUserIsAbletoViewSuppliersList() throws IOException {
	  LoginpageClass lp = new LoginpageClass(driver);
		HomepageClass hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0,"loginPage"),ExcelReadUtility.getIntegerData(0, 1,"loginPage"));
		hp.clickOnEndTourButton();
		hp.clickOnContacts();
		SuppliersPageClass sp =hp.clickOnSuppliers();
		sp.clickOnActionButtonofthefirstSupplierRow();
		SupplierInfoClass spi= sp.clickOnViewOption();
	    String actualResult="View Contact";
	    String expectedResult=spi.getTextofSupplierContactPageHeading();
	    AssertJUnit.assertEquals(actualResult, expectedResult);
  }
  @Test 
  public void verifyUserIsAbletoSerachForaSupplier() throws IOException {
	  
	  LoginpageClass lp = new LoginpageClass(driver);
		HomepageClass hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0,"loginPage"),ExcelReadUtility.getIntegerData(0, 1,"loginPage"));
		hp.clickOnEndTourButton();
		hp.clickOnContacts();
		SuppliersPageClass sp =hp.clickOnSuppliers();
		boolean serchResult=sp.searchForUser("Ansalna");
	    AssertJUnit.assertTrue(serchResult);
  }
}
