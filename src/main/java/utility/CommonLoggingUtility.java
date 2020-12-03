package utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CommonLoggingUtility implements ITestListener
{

	private static final Logger LOG= LoggerFactory.getLogger(CommonLoggingUtility.class);
	
	public void onTestStart(ITestResult result)
	{
		LOG.info("Test has started.....");
	}

	public void onTestSuccess(ITestResult result)
	{
		LOG.info("Test has passed successfully");
	}

	public void onTestFailure(ITestResult result)
	{
		LOG.info("Test has failed");
	}

	public void onTestSkipped(ITestResult result)
	{
		LOG.info("Test has been skipped");
	}

}
