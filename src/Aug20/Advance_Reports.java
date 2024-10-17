package Aug20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Advance_Reports 
{
	ExtentReports reports;
	ExtentTest logger;
	WebDriver driver;

	@BeforeTest
	public void generateReports()
	{
		reports = new ExtentReports("./ExtentReports/Demo.html");
	}

	@BeforeMethod
	public void Setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
	}

	@Test
	public void firsttestcase()
	{
		logger = reports.startTest("Pass Test");
		logger.assignAuthor("Vineeth");
		String Expected = "Google";
		String Actual = driver.getTitle();
		if(Actual.equalsIgnoreCase(Expected))
		{
			logger.log(LogStatus.PASS, "Title is Matching::"+Expected+"  "+Actual);	
		}else
		{
			logger.log(LogStatus.FAIL, "Title is not Matching::"+Expected+" "+Actual);
		}

	}

	@Test
	public void secondTestcase()
	{
		logger = reports.startTest("Fail Test");
		logger.assignAuthor("vineeth");
		String Expected = "Gmail";
		String Actual = driver.getTitle();
		if(Actual.equalsIgnoreCase(Expected))
		{
			logger.log(LogStatus.PASS, "Title is matching::"+Expected+" "+Actual);
		}else
		{
			logger.log(LogStatus.FAIL, "Title is not matching::"+Expected+" "+Actual);
		}
	}	
	@AfterMethod
	public void tearDown()
	{
		reports.endTest(logger); 
		reports.flush();
		driver.quit();
	}

}







