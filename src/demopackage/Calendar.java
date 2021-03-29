package demopackage;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Calendar {
	static String expectedMonthName="aug";
	static String expectedDayDate="9";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\VINOD\\eclipse-workspace\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");
		
		driver.findElement(By.cssSelector("#travel_date")).click();
		driver.findElement(By.cssSelector(".datepicker-switch")).click();
		List<WebElement> months=driver.findElements(By.cssSelector("span.month"));
		Iterator<WebElement> month=months.iterator();
		while(month.hasNext())
		{
			WebElement monthNames=month.next();
			String actualMonthName=monthNames.getText();
			
			
			if(actualMonthName.equalsIgnoreCase(expectedMonthName))
			{
				Thread.sleep(3000);
				monthNames.click();
				break;
			}
			
		}
		List<WebElement> daysCount=driver.findElements(By.cssSelector(".day"));
		Iterator<WebElement> days=daysCount.iterator();
		while(days.hasNext())
		{
			WebElement day=days.next();
			String actualDayDate=day.getText();
			if(actualDayDate.equalsIgnoreCase(expectedDayDate))
			{
				day.click();
				break;
			}
		}
		
		//driver.findElement(By.cssSelector(".active.day")).click();

	}

}
