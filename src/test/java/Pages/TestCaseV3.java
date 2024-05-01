package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCaseV3 {
	
	 static WebDriver driver = null;
	 
	 @Test(dataProvider ="Credentials")
	public void loginTest(String username, String password) {
		
		 System.out.println(username+"----"+password);
		 
		 String projectPath = System.getProperty("user.dir");
			//	 System.out.println("projectPath"+projectPath);
				
		 System.setProperty("webdriver.chrome.driver", projectPath+"//drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
				 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://automationpractice.pl/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
				
		driver.findElement(By.linkText("Sign in")).click();
		//Login
		driver.findElement(By.id("email")).sendKeys( username);
		driver.findElement(By.id("passwd")).sendKeys( password);
		
		 driver.findElement(By.id("SubmitLogin")).click();
	}

	 @DataProvider(name= "Credentials")
	public Object[][] dataSupplier() throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("C://Users//Molemo3//Documents//SeleniumWen//Testdata.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		Object Data[][] = new Object[rowCount][columnCount];
		for(int i=0; i<rowCount; i++)
		{
			XSSFRow row=sheet.getRow(i+1);
			for(int j=0; j<columnCount; j++)
			{
				XSSFCell cell = row.getCell(j);
				CellType cellType =  cell.getCellType();
				
				switch(cellType) {
				
				case STRING:
				 Data[i][j]=cell.getStringCellValue();	
				 break;
				 
				case NUMERIC:
				 Data[i][j]=Integer.toString((int)cell.getNumericCellValue());
				 break;
				 
				case BOOLEAN:
				Data[i][j]=cell.getBooleanCellValue();	
				
				}	
				
		}
	
		}
	
			
			 
			return Data;
	}

}
	
	
