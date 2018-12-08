
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicActions {
	WebDriver driver;
	String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafael\\workspace\\SeleniumAutomation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//*[@id='navbar']/div/div/div/ul/li[2]/a")).click();
		System.out.println("Inserindo Login e Senha");
		driver.findElement(By.id("user_email")).sendKeys("rafael");
		driver.findElement(By.id("user_password")).sendKeys("123456");
		driver.findElement(By.id("user_email")).clear();
		driver.findElement(By.id("user_password")).clear();
	}
	
	
	@After
	public void tearDown() throws Exception {
	driver.quit();
	}
	
	

}
