package whatfix.SelfHelpautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelfHelpPage {

	WebDriver driver;
	
	public By selfhelpbtn=By.xpath(".//*[@id='_widget_wfx_']/div/div");
	public By iframe_selfhelp=By.xpath("//iframe[@title='Get Started with Whatfix']");
	public By selectselfhelptxt=By.xpath("//a[@class='gwt-Anchor WFWIEW']");
	public By txttooltipembed =By.xpath("//div[@class='WFEMFU']");
	public By btn_Embed =By.xpath("//a[@class='WFMAAB WFMAMFB WFMAAL']");
	public By dropdownoption=By.xpath("//a[@class='WFMAAB WFMABK']");
	public By nxtbtn= By.xpath("//a[@class='WFEMLT']");
	public By closebtn = By.xpath("//td[@class='WFMANK WFMAFDB']/a");
	public By iframe2closeprmpt = By.xpath("//iframe[@class='WFEMHS WFEMNS']");
	public By stroncloseprmpt = By.xpath("//div[@class='WFENNH WFENHX WFENDS WFENDN']/p");
	public By closeprmpt =By.xpath("//button[@class='gwt-Button WFENOR']");
	
	WebElement SelfHelpiframe ;
	List<WebElement> dropdownoption1 ;
	WebElement iframe2wecloseprmpt;
	
	public SelfHelpPage(WebDriver driver)
	{
	this.driver=driver;
	}
	 
	public void clkselfhelpbtn()
	{
		driver.findElement(selfhelpbtn).click();
	}

	public WebElement getiframe_selfhelp()
	{
		SelfHelpiframe = driver.findElement(iframe_selfhelp);
		return SelfHelpiframe;
		}
	
	public void clkselectselfhelptxt()
	{
		driver.findElement(selectselfhelptxt).click();
	}
	
	public String gettxttooltipembed()
	{
		return driver.findElement(txttooltipembed).getText();
	}
	
	public String strbtn_Embed()
	{
		return driver.findElement(btn_Embed).getText();
		}
	
	public void clkbtn_Embed()
	{
		driver.findElement(btn_Embed).click();
		}

	
	public List<WebElement> strbtndropdwnoptn()
	{
		dropdownoption1 =  driver.findElements(dropdownoption); 
		return dropdownoption1;
		
		}
	
	public void clkbtndropdwnoptn()
	{
		driver.findElement(dropdownoption).click();
		}
	
	public void clknxtbtn()
	{
		driver.findElement(nxtbtn).click();
		}
	
	public void clkclosebtn()
	{
		driver.findElement(closebtn).click();
		}
	
	
	
	public WebElement getiframe_closeprmpt()
	{
		iframe2wecloseprmpt = driver.findElement(iframe2closeprmpt);
		return iframe2wecloseprmpt;
		}
	

	
	public String strCloseprmpt()
	{
		return driver.findElement(stroncloseprmpt).getText();
		}
	
	public void clkclosebtnprmpt()
	{
		driver.findElement(closeprmpt).click();
		}
	
}