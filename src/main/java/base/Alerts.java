package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("alertbtn")).click();

		// click on accept on window alert
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		// click on cancel/decline on window alert
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

		driver.close();

	}
}