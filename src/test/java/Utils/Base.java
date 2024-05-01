package Utils;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
		
public static WebDriver driver = null;	

public static WebDriver setup(WebDriver driver) {
	
	
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath"+projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"//drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.get("http://www.automationpractice.pl/");
		return driver;

	}
	

}
