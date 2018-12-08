import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class javaScriptExecution {
	private WebDriver driver;
	String baseUrl;
	private JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafael\\workspace\\SeleniumAutomation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		js = (JavascriptExecutor) driver;
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

	

	@Test
	public void test() throws InterruptedException {
		// Navigation
				// driver.get(baseUrl);
				js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice';");
				
				// driver.get() method waits for the page to load completely before going to the next statement
				// Adding Thread.sleep() because we are opening URL using js.executeScript() and it does not wait for the page to load completely
				// If we do not add wait, then Selenium WebDriver will immediately try to find the element and it might have issues with just a little slow connection
				Thread.sleep(3000);
				// Finding element
				// WebElement textBox = driver.findElement(By.id("name"));
				WebElement textBox = (WebElement) js.executeScript("return document.getElementById('name');");
				textBox.sendKeys("test");
				
				//Scroll down
				js.executeScript("window.scrollBy(0, 1900);");
	
				// Scroll Up
				js.executeScript("window.scrollBy(0, -1900);");
				Thread.sleep(2000);
						
				// Scroll Element Into View
				WebElement element = driver.findElement(By.id("mousehover"));
				js.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0, -190);");
				
	}
	
	@After
	public void tearDown() throws Exception {
	
	
	}
}
