package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocManagePO {
    public WebDriver driver;
	
	public DocManagePO(WebDriver driver) {
		this.driver=driver;
	}
	//新建文档按钮
		By NewDocument = By.xpath("//div[@id='js_search']/ul/li/a[@id='document-html-create']");
		
		//文档标题输入框
		By DocTitle = By.xpath("//input[@id='document-title']");
		//文档内容所在的第一层iframe：needit
		By iframe1 = By.id("needit");
		
		//文档内容所在的第二层iframe：ueditor_0	
		By iframe2 = By.id("ueditor_0");
		
		
		//iframe中文档内容输入框
		By DocContent = By.xpath("//body[@class='view']");
		
		//保存文档按钮
		By SaveDoc = By.id("new-save");
		
		//关闭文档按钮
		By CloseDoc = By.id("btn-close");
		

		//新增的文档记录
		By NewAddedDoc = By.xpath("//ul[@id='document-list']/li[1]/div/div");
		
		//要删除的记录
		By DocToBeDelete = By.xpath("//ul[@id='document-list']/li/div/div[@title='wendang']");
			
			
		//文档详情，操作菜单
		By operateBtn = By.linkText("操作");	
			
		//操作菜单的删除选项
		By DeleteDoc = By.id("btn-delete");	
			
		//确认删除按钮	
		By ConfirmDelete = By.linkText("确认");
		
		//文档记录组，用于判断文档已删除
	    By DeleteDocs = By.xpath("//ul[@id='document-list']/li/div/div[@title='wendang']");
			
		
		//元素对应的方法
		public WebElement NewDocument() {
			
			return driver.findElement(NewDocument);
		}

		public WebElement DocTitle() {
			
			return driver.findElement(DocTitle);
		}
		
		public WebElement iframe1() {
			
			return driver.findElement(iframe1);
		}
		
		public WebElement iframe2() {
			
			return driver.findElement(iframe2);
		}

		
		public WebElement DocContent() {
			
			return driver.findElement(DocContent);
		}
		
		
		public WebElement SaveDoc() {
			
			return driver.findElement(SaveDoc);
		}
		
		
		public WebElement CloseDoc() {
			
			return driver.findElement(CloseDoc);	
	      
		}
		
	   public WebElement NewAddedDoc() {
			
			return driver.findElement(NewAddedDoc);	
	      
		}
		
	   

	  //要删除的记录
	  public WebElement docToBeDelete() {
		
		  return driver.findElement(DocToBeDelete);	
	  
	  }
	 
	  //文档详情，操作菜单
	   public WebElement operateBtn() {
		
		   return driver.findElement(operateBtn);	
	  
	   }

	  //操作菜单的删除选项
	   public WebElement deleteDoc() {
		
		   return driver.findElement(DeleteDoc);	
	  
	   }

	  //确认删除按钮
	   public WebElement confirmDelete() {
		
		   return driver.findElement(ConfirmDelete);	
	  
	   }
	   
	   //被删除的特定文档记录集合
	   public  List<WebElement> deletedDocs() {
		   
		   return driver.findElements(DeleteDocs);
	   }
	  
}
