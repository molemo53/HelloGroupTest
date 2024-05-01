package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase1 {

	static WebDriver driver = null;
	
	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		
		 String projectPath = System.getProperty("user.dir");
		//	 System.out.println("projectPath"+projectPath);
				
		System.setProperty("webdriver.chrome.driver", projectPath+"//drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://automationpractice.pl/");
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Initialise Actions class object
		  Actions actions=new Actions(driver);
		//  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		  WebElement womenTab=driver.findElement(By.linkText("WOMEN"));
		  //Declare Tshirt to find
		  WebElement TshirtTab=driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul//a[@title='T-shirts']"));
		  actions.moveToElement(womenTab).moveToElement(TshirtTab).click().perform();
		  Thread.sleep(2000);
		  
		  // Get Product Name
		  String ProductName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();
		  System.out.println(ProductName);
		  driver.findElement(By.id("search_query_top")).sendKeys(ProductName);
		  driver.findElement(By.name("submit_search")).click();
		  
		  // Get Name of Searched Product
		  String SearchResultProductname=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();

		  // Verify that correct Product is displaying after search
		  if(ProductName.equalsIgnoreCase(SearchResultProductname)) {
		   System.out.println("Results Matched;Test Case Passed");
		  }else{
		   System.out.println("Results NotMatched;Test Case Failed");
		  }
		  
		  // Close the browser
		  driver.close();
		 }
}
	

	


