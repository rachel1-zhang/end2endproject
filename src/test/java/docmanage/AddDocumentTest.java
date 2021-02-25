package docmanage;

import org.testng.annotations.Test;

import base.Base;
import pagelibraries.LoginPageLib;
import pageobjects.DocManagePO;
import pageobjects.HomePagePO;
import pageobjects.LoginPagePO;
import pageobjects.PortalPagePO;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AddDocumentTest extends Base{
	private static final Logger log =LogManager.getLogger(); 


  @BeforeClass
  public void beforeClass() throws IOException {
	  startBrowser();
	  log.info("start browser successfully!");
  }
	  	
  @Test
  public void addDocument() throws IOException, Exception {
	  HomePagePO homePage=new HomePagePO(driver);
	  homePage.loginBtn().click();
	  
	  LoginPageLib loginPagelib=new LoginPageLib(driver);
	  loginPagelib.login();
	  
	  log.info("login successfully!");
	  
	  PortalPagePO portalPage=new PortalPagePO(driver);
	  portalPage.invitePeopleClose().click();
	  
	  Actions action=new Actions(driver);
	  action.moveToElement(portalPage.moreApplication()).perform();
	  
	  WebDriverWait wait=new WebDriverWait(driver,60);
	  wait.until(ExpectedConditions.elementToBeClickable(portalPage.knowledgeDoc()));
	  action.moveToElement(portalPage.knowledgeDoc()).click().perform();
	  
	  log.info("open knowledgeDoc successfully!");

	  
	  DocManagePO docManage=new DocManagePO(driver);
	  wait.until(ExpectedConditions.elementToBeClickable(docManage.NewDocument()));

	  docManage.NewDocument().click();
	  docManage.DocTitle().sendKeys("wendang");
	  
	  //切换进入文档内容的第一层iframe
	  driver.switchTo().frame(docManage.iframe1());
	  log.info("get iframe1 successfully!");
	  
	  //wait.until(ExpectedConditions.elementToBeClickable(docManage.iframe2()));
	  Thread.sleep(10000);

	  //切换进入文档内容的第二层iframe
	  driver.switchTo().frame(docManage.iframe2());
	  
	  log.info("get iframe2 successfully!");
	  
	  docManage.DocContent().sendKeys("文档内容");
	  driver.switchTo().defaultContent();
	  
	  docManage.SaveDoc().click();
	  docManage.CloseDoc().click();
	  
	  try {
	      Assert.assertEquals("wendang", docManage.NewAddedDoc().getText());
	      log.info("verify successfully!");
	  }catch(AssertionError e) {
	      log.error("verify failed!"+e);

		  Assert.fail("verify failed!"+e);
	  }
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
