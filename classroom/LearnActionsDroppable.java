package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnActionsDroppable {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//switch to frame where draggable is
		
		driver.switchTo().frame(0);
		
		//find the x path of source
		
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
	
		//find the xpath of target
		
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(source, target).perform();

	}

}
