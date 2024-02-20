package atmosoltest1;
	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;

	public class NewClass 
	{

		static WebDriver driver;

		public static void main(String[] args) 
		{
			driver = new ChromeDriver();
			driver.get("https://blazedemo.com/reserve.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			By rows = By.xpath("//table/tbody/tr");
			bookingTicketOnMinimunFare(rows);
		}
		
		public static List<WebElement> getElements(By locator) 
		{
			return driver.findElements(locator);
		}

		public static int rowCount(By locator) 
		{
			List<WebElement> noOfRow = getElements(locator);
			int totalRow = noOfRow.size();
			return totalRow;
		}
		
		public static void bookingTicketOnMinimunFare(By locator) 
		{
			//Using a List is to store all the fare in ArrayList
			
			List<Double> priceList = new ArrayList<>();
			List<WebElement> allSearchBtn = driver.findElements(By.xpath("//input[@value='Choose This Flight']"));
			for (int i = 1; i <= rowCount(locator); i++) {
				String price = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + i + "]/td[6]")).getText();
				Double dprice = Double.parseDouble(price.replace("$", ""));
				priceList.add(dprice);
			}
			//Finding minimum fare
			
			Double minFare = Collections.min(priceList);
			System.out.println("Minimun fare is::" + minFare);
			for (int j = 0; j < priceList.size(); j++) 
			{
				if (priceList.get(j) == minFare) 
				{
					allSearchBtn.get(j).click();
					break;
				}
			}
		}
	}



