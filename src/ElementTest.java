import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementTest {
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafael\\workspace\\SeleniumAutomation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.google.com.br";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		WebElement e2 = driver.findElement(By.id("gs_taif0"));
		System.out.println("E2 is Enabled? " + e2.isEnabled());
		
		WebElement e3 = driver.findElement(By.id("gs_htif0"));
		System.out.println("E3 is Enabled? " + e3.isEnabled());
	
		WebElement e1 = driver.findElement(By.id("lst-ib"));
		System.out.println("E1 is Enabled? " + e1.isEnabled());
		
		e1.sendKeys("letskodeit");
	
	}
	
	@After
	public void tearDown() throws Exception {
	Thread.sleep(30000);
	driver.quit();
	}

	

}
