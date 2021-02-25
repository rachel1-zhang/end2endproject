package pagelibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageobjects.LoginPagePO;

public class LoginPageLib extends LoginPagePO{

	public LoginPageLib(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void login() throws IOException {
		
        FileInputStream file=new FileInputStream("C:\\eclipse-workspace\\end2endproject\\Configs\\GlobalData.properties");
		
		Properties prop=new Properties();
		
		prop.load(file);
		
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");

		
		userName().sendKeys(username);
		passWord().sendKeys(password);
		submitBtn().click();
		
	}
	

}
