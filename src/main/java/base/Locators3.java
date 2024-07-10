package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// traverse from sibling
		String a = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();

		// traverse from child to parents
		String b = driver.findElement(By.xpath("//header/div/button[1]/parent::div//button[2]")).getText();

		Assert.assertEquals(a, b);

		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		// takes time to fully load the page, usually help in loading web page for first
		// time
		driver.get("https://google.com");

		// Navigate will work when even a small component of the
		// page is loaded, usually help when one time web page is loaded to navigate
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.navigate().back();
		driver.navigate().forward();

		driver.quit();
	}

}
