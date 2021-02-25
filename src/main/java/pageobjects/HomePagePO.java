package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePagePO {
	public WebDriver driver;
	public HomePagePO(WebDriver driver) {
		this.driver=driver;
	}
	
	By loginBtn=By.id("top-btn-login");
	
	public WebElement loginBtn() {
		return driver.findElement(loginBtn);
	}

}
