package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions builder = new Actions(driver);
		
		WebElement mensFashion = driver.findElement(By.xpath("(//a[@class='menuLinks leftCategoriesProduct ']/span)[2]"));
		
		WebElement mensSportsShoes = driver.findElement(By.xpath("(//span[.='Sports Shoes'])[1]"));
		
		builder.moveToElement(mensFashion).moveToElement(mensSportsShoes).click().perform();
		
		String text = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText();
		System.out.println("Number Of Sports Shoes are " +text);
		
		builder.moveToElement(driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]"))).click().perform();
		
		
		
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		driver.findElement(By.xpath("(//ul[@class='sort-value']/li)[2]")).click();
		
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("500");
		
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1000");
		
		builder.moveToElement(driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']"))).click().perform();
		
		Thread.sleep(5000);
		
		WebElement one = driver.findElement(By.xpath("//p[@class='product-title']"));
		
		builder.moveToElement(one).perform();
		
		driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])[1]/div")).click();
		
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Price of first resulting shoe is " + price);
		
		
		String percentage = driver.findElement(By.xpath("//span[@class='payBlkBig']/following-sibling::span")).getText();
		System.out.println("Percentagece of first resulting shoe is " + percentage);
		
		File snapshot = driver.getScreenshotAs(OutputType.FILE);
		
		File snapdeal = new File("./snapshots/snapdeal.jpg");
		
		FileUtils.copyFile(snapshot, snapdeal);
		
		driver.close();
		
		
		
		

	}

}
