package base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestNGListener implements ITestListener {
	public WebDriver driver;
	Base base=new Base();

	public void onTestStart(ITestResult result) {
		  System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "...")); 
	      String testname = result.getMethod().getMethodName(); 
	      ExtentTestManager.startTest(testname); 

		
	}

	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, "Test passed"); 
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		this.driver=((Base)result.getInstance()).driver;
		String testCaseName=result.getName().toString().trim();
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    String screenshotname=testCaseName+"_"+timeStamp;
		
		try {
			base.takeScreenShot(screenshotname, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");      
	       ExtentTestManager.getTest().log(Status.FAIL, "Test Failed"); 
	       ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable()); 
	       
	       
	    // 将失败截图附到Extent Report中
           try {
                   ExtentTestManager.getTest().fail("Screenshot",
	 			   MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\ScreenShots\\"+screenshotname+".png").build());
               } catch (IOException e) {
	 	            System.out.println(e.getCause());
	 		                              
               }

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		  System.out.println(("*** Test Suite " + context.getName() + " ending ***")); 
	      ExtentTestManager.endTest(); 

		
	}

}
