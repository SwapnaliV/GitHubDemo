package handson;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class dragNdrop {
	WebDriver driver;
  @Test
  public void TestDragDrop() {
	  driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	  /*
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)");
	  */
	  ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
	  
	  driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[4]/div[2]/div/a")).click();
	  
	//Element which needs to drag.    		
  	WebElement From=driver.findElement(By.xpath("//span[contains(text(),'1 Week Package')]"));	
  	
  	 //Element on which need to drop.		
    WebElement To=driver.findElement(By.xpath("//td[contains(text(),'Drag and drop packages here...')]"));
    
    //Using Action class for drag and drop.		
    Actions act=new Actions(driver);					

//Dragged and dropped.		
    act.dragAndDrop(From, To).build().perform();		
  	
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Testing\\Selenium\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

}
