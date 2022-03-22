package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTable {

	public static void main(String[] args) 
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//clear the existing name and passing value as tpj
		
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys("tpj",Keys.TAB);
		
		//clear the existing name and passing value as ms
		
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).sendKeys("ms",Keys.TAB);
		
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		
		//find the number of trains/rows
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		System.out.println("Number Of Trains are " + rows);
		
		for (int i = 1; i < rows.size(); i++) 
		{
			String trainName = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
			if(trainName.contains("CHENNAI"))
			{
				System.out.println(trainName);
			}
		
		}
		
		
		
		
		
		
		
	}
	

}
