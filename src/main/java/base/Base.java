package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {
	public WebDriver driver;
	public void startBrowser() throws IOException {
		FileInputStream file=new FileInputStream("C:\\eclipse-workspace\\end2endproject\\Configs\\GlobalData.properties");
		
		Properties prop=new Properties();
		
		prop.load(file);

		
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		String driverpath="C:\\driver\\";
		if(browser.equals("chrome")) {
	    	//define chrome driver, get url
	    	System.setProperty("webdriver.chrome.driver", driverpath+"chromedriver.exe");
	    	//creat driver object,start chrome broswer
	    	driver=new ChromeDriver(); 
	    }else if(browser.equals("firefox")) {
	    	System.setProperty("webdriver.gecko.driver", driverpath+"geckodriver.exe");  
	    	driver = new FirefoxDriver(); 
	    }else if(browser.equals("ie")) {
	    	System.setProperty("webdriver.ie.driver",driverpath+ "IEDriverServer.exe"); 
	    	driver = new InternetExplorerDriver();  
	    }
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void takeScreenShot(String screenshotname,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File desFile=new File(System.getProperty("user.dir")+"//Screenshots//"+screenshotname+".png");
		
		
		FileHandler.copy(srcFile, desFile);
		
		
		
	}

}
