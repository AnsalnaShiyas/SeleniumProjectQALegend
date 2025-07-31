package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyser implements IRetryAnalyzer{
 
	private int initialRetryCount=0;
	private static final int maximum_Data_Count=3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}
  
	
	
}
