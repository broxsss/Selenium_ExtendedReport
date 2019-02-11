package whatfix.SelfHelpautomation.component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class property {

	Properties  prop ;
	public void loaddata() throws IOException
	{
		prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"//src//main//java//whatfix//SelfHelpautomation//resources//resources.properties");
		FileReader fr = new FileReader(file);
		prop.load(fr);			
	}
	
	public String getData(String Data) throws IOException
	{
		loaddata();
		String data = prop.getProperty(Data);
		return data;
		
	}
	
	 public String getscreenshot(WebDriver driver,String Testcasename) throws IOException 
     {
             
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File DestFile= new File(System.getProperty("user.dir")+"//screenshots//"+Testcasename+"_"+System.currentTimeMillis()+".png"); 
             try {
            	   
            	 FileUtils.copyFile(scrFile, DestFile);
            	      }
            	 
            	catch (IOException e)
            	 
            	{
            	 
            	System.out.println(e.getMessage());
            	 
            	    }
             
         return  System.getProperty("user.dir")+"\\screenshots\\"+Testcasename+"_"+System.currentTimeMillis()+".png";   
     }

	
	
}
