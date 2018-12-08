package usefulmethods;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import usefulmethods.GenericMethods;

public class GenericMethodsDemo {
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl2;
	private GenericMethods gm;
	
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
		WebElement element = gm.getElement("name", "id");
		element.sendKeys("Rafael");
		List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");
		int size = elementList.size();
		System.out.println("The size of the element is: " +size);
		
		boolean result1 = gm.isElementPresent("name", "id");
		System.out.println("Is element present? " +result1);
	
		boolean result2 = gm.isElementPresent("sou uma puta", "id");
		System.out.println("Is element present? " +result2);
		
	}

	@After
	public void tearDown() throws Exception {
	Thread.sleep(2000);
	driver.quit();
	}
	
	
}
