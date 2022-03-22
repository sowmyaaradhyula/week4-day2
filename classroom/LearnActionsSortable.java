package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnActionsSortable {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//switch to frame 
		
		driver.switchTo().frame(0);
		
		//find the xpath of the element
		
		WebElement item1 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[1]"));
		
		WebElement item4 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[4]"));
		
		Actions builder = new Actions(driver);
		
		builder.clickAndHold(item4).moveToElement(item1).release().perform();
		
	}

}
