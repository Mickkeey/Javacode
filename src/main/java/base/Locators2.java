package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		String name = "Rahul";

//		Locators2 o = new Locators2();
//		String newp = o.passwordReset(driver);

		String setNewPassword = passwordReset(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(setNewPassword);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + name + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}

	public static String passwordReset(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordRemaining = passwordText.split("'");
		String setNewPassword = passwordRemaining[1].split("'")[0];
		return setNewPassword;

	}

}
