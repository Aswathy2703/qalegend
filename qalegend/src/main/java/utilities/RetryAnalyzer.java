package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	private int retrycount=0;
	private static final int maxretrycount=4;
	
	@Override
	public boolean retry(ITestResult result) {//inbuilt method of IRetryAnalyzer
		
		if(retrycount<maxretrycount) {
			retrycount++;
			return true;
		}
		return false;
	}

}
