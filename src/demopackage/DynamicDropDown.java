package demopackage;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DynamicDropDown {

	public static void main(String[] args) {
		
		String expectedCityNmae="Hyderabad (hyd)";
		String expectedToCityNmae="jodhpur (jdh)";
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\VINOD\\eclipse-workspace\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		/*
		driver.findElement(By.cssSelector("[value='Departure City']")).click();

		driver.findElement(By.xpath("//a[text()=' Hyderabad (HYD)']")).click();
		
		driver.findElement(By.xpath("(//a[text()=' Delhi (DEL)'])[2]")).click();
		*/
		
		driver.findElement(By.cssSelector("[value='Departure City']")).click();
		
		List<WebElement> ulsLocator=driver.findElements(By.xpath("(//div[@class='dropdownDiv'])[1]/ul"));
		Iterator<WebElement>uls=ulsLocator.iterator();
		while(uls.hasNext())
		{
			WebElement ul=uls.next();
			List<WebElement> lisLocator=ul.findElements(By.xpath("(//div[@class='dropdownDiv'])[1]/ul/li"));
			Iterator<WebElement> lis=lisLocator.iterator();
			while(lis.hasNext())
			{
				WebElement li=lis.next();
				String actualCityName=li.getText();
				if(actualCityName.equalsIgnoreCase(expectedCityNmae))
				{
					li.click();
				}
			}
		}
		
		List<WebElement> toUlsLocator=driver.findElements(By.xpath("(//div[@class='dropdownDiv'])[3]/ul"));
		Iterator<WebElement> toUls=toUlsLocator.iterator();
		while(toUls.hasNext())
		{
			WebElement toUl=toUls.next();
			List<WebElement> toLisLocator=toUl.findElements(By.xpath("(//div[@class='dropdownDiv'])[3]/ul/li"));
			Iterator<WebElement> toLis=toLisLocator.iterator();
			while(toLis.hasNext())
			{
				WebElement toLi=toLis.next();
				String actualToCityNmae=toLi.getText();
				if(actualToCityNmae.equalsIgnoreCase(expectedToCityNmae))
				{
					toLi.click();
				}
			}
		}
	}

}
