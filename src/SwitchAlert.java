import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SwitchAlert {
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
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
	}


	@Test
	public void test1() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.id("name")).sendKeys("Rafinha");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();	
	}
	
	@Test
	public void test2() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.id("name")).sendKeys("Rafinha");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();	
	}
	
	@After
	public void tearDown() throws Exception {
	driver.quit();
	}

}
