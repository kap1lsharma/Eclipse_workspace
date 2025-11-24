package rerunFailed;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunFailedTestcase implements IRetryAnalyzer {
	
	private int recount =0;
	private static final int maxcount=1;

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(recount < maxcount) {
			recount++;
			return true;
		}
		
		return false;
	}
		

}

