package atmosoltest1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass1 
{
	static WebDriver driver;
	
	@Test
	public void initBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/index.php ");
	}
   @Test
	public void getTitle()
	{
		String titlevalidation = driver.findElement(By.xpath("//*[@class='container']/h1")).getText();
	    System.out.println(titlevalidation);
	   	    
	    
	    	if(titlevalidation.contains("Welcome to the Simple Travel Agency!"))
	    			
	    	{
	    		System.out.println("Title validate successfully");
	    	}
	    	else
	    	{
	    		System.out.println("Title cant validate successfully");
	    	}
	    
	}
   
   @Test
   public void newTab()
   {
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   
	   driver.findElement(By.xpath("//*[@href='vacation.html']")).click();
	   
	  String title = driver.getTitle();
	  System.out.println(title);
	  driver.navigate().back();
	   
   }
   @Test
   public void tickitPurchasing() throws InterruptedException
   {
	   WebElement departure = driver.findElement(By.xpath("(//*[@name='fromPort']//child::option)[6]"));
	   departure.click();
	   Thread.sleep(2000);
	   WebElement destination=driver.findElement(By.xpath("(//*[@name='toPort']//child::option)[3]"));
	   destination.click();
	  WebElement search = driver.findElement(By.xpath("//*[@type='submit']"));
	  search.click();
	}
	@Test   
   public void findFlight() throws InterruptedException
   {
	  double value = 200.98;
	  

	   
   }
	   
   
   
}
