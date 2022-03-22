package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundTextchange {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("http://www.leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		WebElement element = driver.findElement(By.xpath("//button[@id='btn']"));
		
		Boolean until = wait.until(ExpectedConditions.domPropertyToBe(element, "innerText", "Click ME!"));
		System.out.println(until);
		element.click();
		Thread.sleep(10000);
		
		driver.switchTo().alert().accept();
		
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		
		File textChange = new File("./snapshots/textChange.jpg");
		
		FileUtils.copyFile(screenshot, textChange);	
		
		
		driver.close();
	}

}
