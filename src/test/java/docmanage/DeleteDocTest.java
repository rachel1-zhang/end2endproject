package docmanage;

import org.testng.annotations.Test;

import base.Base;
import pagelibraries.LoginPageLib;
import pageobjects.DocManagePO;
import pageobjects.HomePagePO;
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

public class DeleteDocTest extends Base{
  private static final Logger log =LogManager.getLogger(); 

  @BeforeClass
  public void beforeClass() throws IOException {
	  startBrowser();
	  log.info("seccessfully!");
  }
  @Test
  public void deleteDocument() throws IOException, Exception {
	  HomePagePO homePage=new HomePagePO(driver);
	  homePage.loginBtn().click();
	  
	  LoginPageLib loginPagelib=new LoginPageLib(driver);
	  loginPagelib.login();
	  
	  PortalPagePO portalPage=new PortalPagePO(driver);
	  portalPage.invitePeopleClose().click();
	  
	  Actions action=new Actions(driver);
	  action.moveToElement(portalPage.moreApplication()).perform();
	  
	  WebDriverWait wait=new WebDriverWait(driver,60);
	  wait.until(ExpectedConditions.elementToBeClickable(portalPage.knowledgeDoc()));
	  action.moveToElement(portalPage.knowledgeDoc()).click().perform();
	  
	  DocManagePO docManage=new DocManagePO(driver);
	  
	  Thread.sleep(10000);
	  //wait.until(ExpectedConditions.elementToBeClickable(docManage.docToBeDelete()));

	  docManage.docToBeDelete().click();
	  
	  action.moveToElement(docManage.operateBtn()).perform();
	  log.info("get docManage.operateBtn() successfully!");
	  wait.until(ExpectedConditions.elementToBeClickable(docManage.deleteDoc()));
	  action.moveToElement(docManage.deleteDoc()).click().perform();
	  
	  docManage.confirmDelete().click();
	  
	  Assert.assertEquals(docManage.deletedDocs().size(), 1);


  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
