package whatfix.SelfHelpautomation.TestCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import whatfix.SelfHelpautomation.Pages.SelfHelpPage;
import whatfix.SelfHelpautomation.component.property;
import whatfix.SelfHelpautomation.component.start_Exit_browser;

public class LoginPageSelfHelpTag_TC001 {
	WebDriver driver;
	static property prop = new property();
	start_Exit_browser se = new start_Exit_browser();
	ExtentReports report;
	ExtentTest logger; 
	String Testcasename = "LoginPageSelfHelpTag_TC001";

	@Test
	public void AutomateSelfHelp() throws InterruptedException, IOException
	{
		//instantiation for extent report
		report=new ExtentReports(System.getProperty("user.dir")+"\\Reports\\"+Testcasename+".html");
		logger=report.startTest("check Whatfix project");

		//starting the browser with url
		driver = se.startbrowser(driver);
		SelfHelpPage shp = new SelfHelpPage(driver);
		driver.get(prop.getData("URL"));
		logger.log(LogStatus.PASS, "Able to open Browser");

		//Implicit wait for page loading
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        se.Explicit(driver,shp.selfhelpbtn);
		

		//Clicked self help button
		shp.clkselfhelpbtn();
		logger.log(LogStatus.PASS, "clicked on self Help");
		WebElement iframe = shp.getiframe_selfhelp();
		driver.switchTo().frame(iframe);
		logger.log(LogStatus.PASS, "Switched to iframe after clicking self help button");
		se.Explicit(driver,shp.selectselfhelptxt);

		//clicked the data inside first iframe of self help
		shp.clkselectselfhelptxt();
		logger.log(LogStatus.PASS, "clicked on How to embed flows in my website or application");
		driver.switchTo().defaultContent();
		System.out.println(shp.gettxttooltipembed());

		//check prompt message for embed prompt
		Assert.assertEquals(shp.gettxttooltipembed(), prop.getData("embedprompt"));
		logger.log(LogStatus.PASS, "Get the test of the tooltip");
		shp.strbtn_Embed();
		System.out.println(shp.strbtn_Embed());

		//clicked on the drop down
		se.isElementPresent(driver,shp.btn_Embed ,5);
		shp.clkbtn_Embed();
		se.isElementPresent(driver,shp.dropdownoption ,5);
		se.Explicit(driver,shp.dropdownoption);
		logger.log(LogStatus.PASS, "Clicked on tooltip dropdown embed");

		//clicked on dropdown option slideshare by action class
		Actions action = new Actions(driver);
		
		List<WebElement> dropslideshow = shp.strbtndropdwnoptn();
		for(int i=0;i<dropslideshow.size();i++)
		{
			System.out.println(dropslideshow.get(i).getText());
			if(dropslideshow.get(i).getText().contains("slideshow"))
			{
				action.moveToElement(dropslideshow.get(i)).click().build().perform();
				logger.log(LogStatus.PASS, "Clicked on dropdown slideshare");
				i=dropslideshow.size();
				break;
			}

		}

		//clicked next and close button on tooltip
		se.isElementPresent(driver,shp.nxtbtn ,5);
		shp.clknxtbtn();
		logger.log(LogStatus.PASS, "Clicked next on ToolTip");
		se.Explicit(driver,shp.closebtn);
		se.isElementPresent(driver,shp.closebtn ,5);
		shp.clkclosebtn();
		logger.log(LogStatus.PASS, "Clicked on close. ");

		//se.isElementPresent(driver,shp.iframe2closeprmpt ,20);
		WebElement iframe2 = shp.getiframe_closeprmpt();
		driver.switchTo().frame(iframe2);
		logger.log(LogStatus.PASS, "Switched to iframe2 after clicking close");
		se.isElementPresent(driver,shp.stroncloseprmpt ,20);
		se.Explicit(driver,shp.stroncloseprmpt);
		System.out.println(shp.strCloseprmpt());

		//verifying close prompt and clicking on close button
		Assert.assertEquals(shp.strCloseprmpt(), prop.getData("closeprmpt"));
		logger.log(LogStatus.PASS, "prompt is coming correctly");
		shp.clkclosebtnprmpt();
		logger.log(LogStatus.PASS, "Clicked on last close button");
		driver.switchTo().defaultContent();
		se.closebrowser(driver);
	}

	@AfterMethod
	public void teardown(ITestResult result)
	{

		try{
			
			if(result.getStatus()==ITestResult.FAILURE)
			{
				String screenshot_path =prop.getscreenshot(driver,result.getName());
				String image = logger.addScreenCapture(screenshot_path);
				logger.log(LogStatus.FAIL, "Test case got failed check screenshot "+result.getName(), image);
				System.out.println("Test case got failed check screenshot..."+result.getName());
			} 
			report.endTest(logger);
			report.flush();
			driver.quit();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
