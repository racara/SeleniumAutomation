package usefulmethods;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeDemo {
	WebDriver driver;
	String baseUrl1;
	String baseUrl2;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafael\\workspace\\SeleniumAutomation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl1 = "http://letskodeit.teachable.com/pages/practice";
		baseUrl2 = "https://www.expedia.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void test() {
		driver.get(baseUrl1);
		WebElement element = driver.findElement(By.id("name"));
		String elementAttribute = element.getAttribute("class");
		System.out.println("The Attribute of this field is: " + elementAttribute);
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}



}
