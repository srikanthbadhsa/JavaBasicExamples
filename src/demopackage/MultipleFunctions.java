package demopackage;



import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class MultipleFunctions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\VINOD\\eclipse-workspace\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//prints number of links in the web page
		//limiting web driver
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//print number of links in footer section
		WebElement footerSection=driver.findElement(By.cssSelector("#gf-BIG"));
		int numberOfLinksInFooter=footerSection.findElements(By.tagName("a")).size();
		System.out.println(numberOfLinksInFooter);
		
		WebElement columnSection=footerSection.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
		System.out.println(columnSection.findElements(By.tagName("a")).size());
		
		//opening multiple links in new tab
		
		/*List<WebElement> columnLinks=columnSection.findElements(By.tagName("a"));
		Iterator<WebElement> links=columnLinks.iterator();
		while(links.hasNext())
		{
			String click=Keys.chord(Keys.CONTROL,Keys.ENTER);
			WebElement clickLink=links.next();
			clickLink.sendKeys(click);
		}*/
		
		for(int i=1;i<columnSection.findElements(By.tagName("a")).size();i++)
		{
			String click=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnSection.findElements(By.tagName("a")).get(i).sendKeys(click);
			Thread.sleep(5000);
		}
			
			Set<String> windows=driver.getWindowHandles();
			Iterator<String> it=windows.iterator();
		
			while(it.hasNext())
			{
				
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			
			}
		
	}

}
