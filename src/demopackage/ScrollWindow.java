package demopackage;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.asserts.Assertion;





public class ScrollWindow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\VINOD\\eclipse-workspace\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,600)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		List<WebElement> coloumValuesLocator=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		Iterator<WebElement> coloumnValues=coloumValuesLocator.iterator();
		int sum=0;
		while(coloumnValues.hasNext())
		{
			WebElement values=coloumnValues.next();
			String value=values.getText();
			int a=Integer.valueOf(value);
			sum=sum+a;
		}
		System.out.println(sum);
		
String totalAmount=driver.findElement(By.className("totalAmount")).getText().split(":").clone()[1].trim();
		int expected=Integer.valueOf(totalAmount);
		Assert.assertEquals(sum,expected);
	}

}
