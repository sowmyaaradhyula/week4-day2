package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortTable {

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//String text = driver.findElement(By.xpath("//table[@id='table_id']//tr[1]/td[2]")).getText();
		//System.out.println(text);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		int rowSize = rows.size();
		
		List<String> list1 = new ArrayList<String>();
		
		for (int i = 1; i < rowSize; i++) 
		{
			String text1 = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			list1.add(text1);
		}
		
		System.out.println("Size of list is " + list1.size());
		System.out.println(list1);
		
		Collections.sort(list1);	
		System.out.println("Sorted list names are " +list1);
		
		driver.findElement(By.xpath("//th[text()='Name']")).click();
		
		List<String> list2 = new ArrayList<String>();
		
		for (int i = 1; i < rowSize; i++) 
		{
			String text2 = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			list2.add(text2);
		}
		
		System.out.println("Size of list is " + list2.size());
		System.out.println(list2);
		
		
		if(list1.equals(list2))
		{
			System.out.println("Names are sorted");			
		}
		else
		{
			System.out.println("Names are not sorted");
		}
		
		
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		
		File sorttable = new File("./snapshots/sorttable.png");
		
		FileUtils.copyFile(screenshot, sorttable);

	}

}
