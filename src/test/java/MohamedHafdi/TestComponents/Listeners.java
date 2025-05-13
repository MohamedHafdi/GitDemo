package MohamedHafdi.TestComponents;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import MohamedHafdi.Resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>(); //Thread safe
	
	 // Called when a test STARTS
    @Override
    public void onTestStart(ITestResult result) {
        //System.out.println("Test started: " + result.getName());
    	if (Arrays.asList(result.getMethod().getGroups()).contains("Test")) {
    		test = extent.createTest(result.getMethod().getMethodName());
        	extentTest.set(test); //unique thread id
    	}
    	
    	test = extent.createTest(result.getMethod().getMethodName());
    	extentTest.set(test); //unique thread id
    }

    // Called when a test PASSES
    @Override
    public void onTestSuccess(ITestResult result) {
        //System.out.println("Test passed: " + result.getName());
    	extentTest.get().log(Status.PASS, "Test Passed");
    }

    // Called when a test FAILS
    @Override
    public void onTestFailure(ITestResult result) {
        //System.out.println("Test failed: " + result.getName());
    	//Take Screenshot of the fail
    	extentTest.get().fail(result.getThrowable());
    	try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    	
    	
    }

    // Called when a test is SKIPPED
    @Override
    public void onTestSkipped(ITestResult result) {
        
    	//System.out.println("Test skipped: " + result.getName());
    }

    // Called when a test fails but is within success percentage (rarely used)
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //System.out.println("Test failed but within success %: " + result.getName());
    }

    // Called when the test suite STARTS
    @Override
    public void onStart(ITestContext context) {
        //System.out.println("Test suite started: " + context.getName());
    }

    // Called when the test suite FINISHES
    @Override
    public void onFinish(ITestContext context) {
        //System.out.println("Test suite finished: " + context.getName());
    	extent.flush();
    }
	
}

