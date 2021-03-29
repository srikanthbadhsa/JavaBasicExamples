package demopackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class WindowSwitch {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\VINOD\\eclipse-workspace\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.findElement(By.className("blinkingText")).click();
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> window=windows.iterator();
		String parendWindow=window.next();
		String childWindow=window.next();
		
		driver.switchTo().window(childWindow);
		String userName=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(parendWindow);
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys("123456");
		
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		
		WebElement selectMenu=driver.findElement(By.cssSelector(".form-control"));
		Select s=new Select(selectMenu);
		s.selectByVisibleText("Consultant");
		driver.findElement(By.cssSelector("#terms")).click();
		
		driver.findElement(By.cssSelector("#signInBtn")).click();
		

	}

}
