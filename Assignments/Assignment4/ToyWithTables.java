package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyWithTables {

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//find table by id
		
		WebElement table = driver.findElement(By.id("table_id"));
		
		//find the number of rows
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowSize = rows.size();
		System.out.println("Number of Rows are " + rowSize);
		
		//find the number of columns
		
		WebElement row = rows.get(1);		
		List<WebElement> col = row.findElements(By.tagName("td"));		
		int colSize = col.size();
		System.out.println("Number Of Columns are " + colSize);
		
		String progress = driver.findElement(By.xpath("//table[@id='table_id']//tr[3]/td[2]")).getText();
		System.out.println("The Progress Value of Learn to interact with elements is " +progress);
		
		System.out.println(driver.findElement(By.xpath("//table[@id='table_id']//tr[2]/td[2]")).getText());
		
		driver.findElement(By.xpath("(//tr[@class='even'])[2]//input")).click();
				
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		
		File table1 = new File("./snapshots/table.jpg");
		
		FileUtils.copyFile(screenshot, table1);
		
		driver.close();
		
		
		
		

	}

}
