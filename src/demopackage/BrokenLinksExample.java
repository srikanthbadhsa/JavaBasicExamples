package demopackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinksExample {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\VINOD\\eclipse-workspace\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		List<WebElement> links=driver.findElements(By.cssSelector(".gf-li a"));
		SoftAssert a=new SoftAssert();
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode=conn.getResponseCode();
			System.out.println(respCode);
			//a.assertTrue(respCode<400, "The link with Text" +link.getText()+"Broken with respCode:"+respCode);
			a.assertFalse(respCode>400, "The link with Text" +link.getText()+"Broken with respCode:"+respCode);
			/*
			 * if(respCode>400) { System.out.println("The link with Text"
			 * +link.getText()+"Broken with respCode:"+respCode); }
			 */
		}
		a.assertAll();
		
		
		
		
		
		/*
		String url=driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode=conn.getResponseCode();
		System.out.println(respCode);
		*/
	}

}
