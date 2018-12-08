package waittypes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.WaitTypes;

import usefulmethods.GenericMethods;


public class ExplicitWaitWithUtilityDemo {
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl2;
	GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafael\\workspace\\SeleniumAutomation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl1 = "http://letskodeit.teachable.com/pages/practice";
		baseUrl2 = "https://www.expedia.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		gm = new GenericMethods(driver);
	
	}
	@Test
	public void test() {
		driver.get(baseUrl1);
		WebElement loginLink = driver.findElement(By.linkText("Login"));
		loginLink.click();
		
		WebElement emailField = gm.waitForElement(By.id("user_email"), 3);
		emailField.sendKeys("test");
		
		gm.clickWhenReady(By.name("commit"), 3);
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	

}
