package DataProvider;

import org.testng.annotations.Test;

import utilities.ExcelReadUtility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
  

  @DataProvider(name="unsuccessfullLogin")
  public Object[][] dp() throws IOException {
    return new Object[][] {
      new Object[] { ExcelReadUtility.getStringData(1, 0, "loginPage"),ExcelReadUtility.getIntegerData(1, 1, "loginPage") },
     // new Object[] { "adm", "123" },
    //  new Object[] { "Ansalna", "123" },
      };
    
    
  }
  
  @DataProvider(name="successfullLogin")
  public Object[][] dp1() throws IOException {
    return new Object[][] {
      new Object[] { ExcelReadUtility.getStringData(0, 0, "loginPage"),ExcelReadUtility.getIntegerData(1, 0, "loginPage") },
     
      };
    
    
  }
}
