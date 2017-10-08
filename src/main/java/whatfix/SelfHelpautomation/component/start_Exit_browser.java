package whatfix.SelfHelpautomation.component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class start_Exit_browser {
   
	static property prop = new property();
	
	public WebDriver startbrowser(WebDriver driver)
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions option = new ChromeOptions();
		option.addArguments("test-type");
		option.addArguments("--disable-geolocation");
		option.addArguments("--enable-strict-powerful-feature-restrictions");
		option.addArguments("--disable-infobars");
		option.addArguments("--disable-popup-blocking");
		option.setExperimentalOption("prefs",prefs);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, option);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
	return driver;
		
	}
	
	
	public void closebrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	public void Explicit(WebDriver driver,By selfhelpbtn) throws IOException
	{
		String explicttime = prop.getData("TimeinSec");
		long extime = Long.parseLong(explicttime);
		WebDriverWait wait = new WebDriverWait(driver,extime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selfhelpbtn));
	}
	public void isElementPresent(WebDriver driver,By xpath ,int time)
	{
		WebElement ele = null;
		for(int i=0;i<time;i++)
		{
			try{
				Thread.sleep(1000);
				ele = driver.findElement(xpath);
				break;
			}
			catch(Exception e)
			{
				try{
					Thread.sleep(1000);
				}
				catch(InterruptedException e1)
				{
					System.out.println("waiting for element to appear DOM");
				}
			}
		}
		
	}
	
}
