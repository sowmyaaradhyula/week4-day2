package week4.day2;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundSelectable {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement item1 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[1]"));
		
		WebElement item7 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[7]"));
		
		WebElement item3 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[3]"));
		
		Actions builder = new Actions(driver);
		
		builder.keyDown(Keys.CONTROL).click(item1).click(item7).click(item3).keyUp(Keys.CONTROL).perform();
		
		

	}

}
