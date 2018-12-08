package actionClass;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class testDragAndDrop {
	private WebDriver driver;
	String baseUrl;
	private JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafael\\workspace\\SeleniumAutomation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://jqueryui.com/droppable/";
		js = (JavascriptExecutor) driver;
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
	}



	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(3000);
		driver.switchTo().frame(0);
	WebElement fromElement = driver.findElement(By.id("draggable"));
	WebElement toElement = driver.findElement(By.id("droppable"));
	Actions action = new Actions(driver);
	
	//Drag and Drop
//	action.dragAndDrop(fromElement, toElement).build().perform();
	
	//Click and hold, move to element, release, build and perform
	action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
	
	}

	@After
	public void tearDown() throws Exception {
	Thread.sleep(3000);
	driver.quit();
	}
	
}
