package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nyka {

	public static void main(String[] args) 
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions builder = new Actions(driver);
		
		WebElement brands = driver.findElement(By.xpath("//a[.='brands']"));
		
		WebElement searchBrands = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		
		builder.moveToElement(brands).moveToElement(searchBrands).click().sendKeys("L'Oreal Paris").perform();
		
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		
		String title = driver.getTitle();
				
		if(title.contains("L'Oreal Paris"))
		{
			System.out.println("Correct page");
		}
		
		
		builder.moveToElement(driver.findElement(By.xpath("//button[@class=' css-n0ptfk']"))).click().perform();
		
		builder.moveToElement(driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]"))).click().perform();
		
		builder.moveToElement(driver.findElement(By.xpath("(//div[@class='filter-action'])[1]"))).click().perform();
		
		builder.moveToElement(driver.findElement(By.xpath("(//span[@class='side-count'])[1]"))).click().perform();
		
		builder.moveToElement(driver.findElement(By.xpath("(//span[@class='side-count'])[2]"))).click().perform();
		
		builder.moveToElement(driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]"))).click().perform();
		
		builder.moveToElement(driver.findElement(By.xpath("(//div[@class='css-xdicx1'])[6]"))).click().perform();
		
		builder.moveToElement(driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[6]"))).click().perform();
		
		String filter = driver.findElement(By.xpath("(//span[@class='filter-value'])[1]")).getText();
		
		if(filter.equals("Shampoo"))
		{
			System.out.println("Filter is applied with shampoo successfully");
		}
		
		
		builder.moveToElement(driver.findElement(By.xpath("(//div[@class='css-1rd7vky'])[1]"))).click().perform();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> windowList = new ArrayList<>(windowHandles);
		
		String newWindow = windowList.get(1);
	    driver.switchTo().window(newWindow);
	    //System.out.println(driver.getTitle());
	    
	    WebElement size = driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
	    Select dd = new Select(size);
	    dd.selectByIndex(1);
	    
	    String mrp = driver.findElement(By.xpath("(//div[@class='css-1d0jf8e']/span)[2]")).getText();
	    System.out.println("MRP of the product is " + mrp);
	    
	    builder.moveToElement(driver.findElement(By.xpath("//div[@class='css-6u29zb']"))).click().perform();
	    
	    builder.moveToElement(driver.findElement(By.xpath("//button[@class='css-g4vs13']"))).click().perform();
	    
        driver.switchTo().frame(0);        
        String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
        System.out.println("Grand Total is " + grandTotal);
	    
        builder.moveToElement(driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']"))).click().perform();
	  
        builder.moveToElement(driver.findElement(By.xpath("//button[@class='btn full big']"))).click().perform();
	    
        String grandTotalFinal = driver.findElement(By.xpath("(//div[@class='payment-details-tbl grand-total-cell prl20']//div)[2]")).getText();
        if(grandTotal.equals(grandTotalFinal))
        {
        	System.err.println("Grand total is same");
        	
        }
		
        driver.quit();
	}

}
