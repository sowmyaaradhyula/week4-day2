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

public class LeafgroundDisappear {

	public static void main(String[] args) throws IOException
	{
	
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			
			// Launch URL
			
			driver.get("http://www.leafground.com/pages/disapper.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			WebElement element = driver.findElement(By.xpath("//button[@id='btn']/b"));
			System.out.println(element.getText());
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			Boolean until = wait.until(ExpectedConditions.invisibilityOf(element));
			System.out.println(until);
			
			File screenshot = driver.getScreenshotAs(OutputType.FILE);
			
			File disappear = new File("./snapshots/disappear.png");
			
			FileUtils.copyFile(screenshot, disappear);
			
			driver.close();
			
	}

}
