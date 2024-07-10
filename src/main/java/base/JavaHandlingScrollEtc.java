package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaHandlingScrollEtc {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		
		List<WebElement> allValues = driver.findElements
				(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum  = 0;
		
		for (WebElement allValue : allValues)
		{
			System.out.println(Integer.parseInt(allValue.getText()));
			 sum = sum+Integer.parseInt(allValue.getText());
		}
		 System.out.println(sum);
		
		System.out.println(driver.findElement
				(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		int actualSum = Integer.parseInt(driver.findElement
				(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, actualSum);
		driver.quit();

		
	}

}
