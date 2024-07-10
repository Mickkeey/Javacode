package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		Actions act = new Actions(driver);
		
//		Hover on it, move cursor to particular element
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		act.moveToElement(move).build().perform();

//      Type in Capital letters
		WebElement enterCaps = driver.findElement(By.id("twotabsearchtextbox"));
		act.moveToElement(enterCaps)
		.click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
//      Type in Capital letters, other way
		enterCaps.clear();
		act.moveToElement(enterCaps)
		.click().clickAndHold().sendKeys("click and hold").build().perform();

//      Select whole text by double clicking on word		
		enterCaps.clear();
		act.moveToElement(enterCaps).doubleClick().build().perform();
		
		act.moveToElement(enterCaps)
		.click().keyDown(Keys.SHIFT).sendKeys("Double Click").doubleClick().build().perform();
		
//		Right click on Web Page
		act.moveToElement(move).contextClick().build().perform();
				
		
		driver.quit();

		
	}

		
}
