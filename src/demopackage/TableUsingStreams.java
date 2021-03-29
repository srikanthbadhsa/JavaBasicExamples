package demopackage;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TableUsingStreams {
	
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\VINOD\\eclipse-workspace\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void test2()
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> heads=driver.findElements(By.cssSelector("thead"));
		for(WebElement head:heads)
		{
			String headName=head.getText();
			if(headName.contains("Discount Price"))
			{
				List<WebElement> prices=driver.findElements(By.xpath("//tr/td[3]"));
				for(WebElement price:prices)
				{
					String priceValue=price.getText();
					System.out.println(priceValue);
				}
			} 
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//@Test
	public void test()
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("[role='columnheader']")).click();
		
		List<WebElement> listOfTds=driver.findElements(By.xpath("//tr//td[1]"));
		for(WebElement tds:listOfTds)
		{
			String tdName=tds.getText();
			if(tdName.contains("Apple"))
			{
				System.out.println(tdName);
			}
		}
		
		
	}
}
