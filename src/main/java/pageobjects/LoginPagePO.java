package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePO {
	public WebDriver driver;
	
	public LoginPagePO(WebDriver driver) {
		this.driver=driver;
	}
	
	By userName=By.id("username");
	By passWord=By.id("password");
	By submitBtn=By.xpath("//button[@type='submit']");
	
	public WebElement userName() {
		return driver.findElement(userName);
	}
	
	public WebElement passWord() {
		return driver.findElement(passWord);
	}
	
	public WebElement submitBtn() {
		return driver.findElement(submitBtn);
	}

}
