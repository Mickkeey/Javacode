package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesAndDragDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
//		Switch to iFrame
		System.out.print(driver.findElements(By.tagName("iframe")).size());
		
//		Switch to iFrame with index
//		driver.switchTo().frame(0);
		
//		Switch to iFrame with WebElement
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.id("draggable")).click();

		Actions act = new Actions(driver);
		WebElement dragSource = driver.findElement(By.id("draggable"));
		WebElement dropTarget = driver.findElement(By.id("droppable"));

//		Drag and Drop
		act.dragAndDrop(dragSource, dropTarget).build().perform();
		
//		Switch to default frame 
		driver.switchTo().defaultContent();
		driver.quit();
		

	}

}
