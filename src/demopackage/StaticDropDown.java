package demopackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class StaticDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\VINOD\\eclipse-workspace\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		//select 1
		/*
		 * WebElement staticDropDown=driver.findElement(By.id(
		 * "ctl00_mainContent_DropDownListCurrency")); Select s=new
		 * Select(staticDropDown); s.selectByValue("USD");
		 * System.out.println(s.getFirstSelectedOption().getText()); s.selectByIndex(2);
		 * System.out.println(s.getFirstSelectedOption().getText());
		 * s.selectByVisibleText("INR");
		 * System.out.println(s.getFirstSelectedOption().getText());
		 */
		
		
		//select 2
		driver.findElement(By.id("divpaxinfo")).click();;
		
		Thread.sleep(3000);
		
		
		WebElement adultsLocator=driver.findElement(By.id("hrefIncAdt"));
		for(int i=1;i<=3;i++)
		{
			adultsLocator.click();
		}
		WebElement childLocator=driver.findElement(By.id("hrefIncChd"));
		for(int i=1;i<=3;i++)
		{
			childLocator.click();
		}
		WebElement infantsLocator=driver.findElement(By.id("hrefIncInf"));
		for(int i=1;i<=3;i++)
		{
			infantsLocator.click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
