package base;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		// Implicit wait for 5 seconds, It will wait and check for each steps no need to
		// provide
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("eeeee");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Mohit");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("mohitsharma21132@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

		// last type of css selector should be used with array
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("mohitsharma232@gmail.com");

		driver.findElement(By.xpath("//form/input[3]")).sendKeys("981298829");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[text()='Go to Login']")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Mohit");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		driver.quit();
	}
}
