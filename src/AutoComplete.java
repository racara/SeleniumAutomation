import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulmethods.GenericMethods;
public class AutoComplete {
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl2;
	GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafael\\workspace\\SeleniumAutomation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl1 = "https://www.southwest.com/";
		baseUrl2 = "https://www.expedia.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		gm = new GenericMethods(driver);
	}



	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl1);
		String searchingText = "New York/Newark, NJ - EWR";
		String partialText = "New York";

		WebElement text = driver.findElement(By.id("air-city-departure"));
		text.sendKeys(partialText);

		WebElement element = driver.findElement(By.id("air-city-departure-menu"));
		List<WebElement> results = element.findElements(By.tagName("li"));
		int size = results.size();

		System.out.println("The size of the list is: " + size);

		for (int i = 0; i < size; i++) {
			System.out.println(results.get(i).getText());
		}

		Thread.sleep(3000);
		for (WebElement result : results) {
			if (result.getText().equals(searchingText)) {
				result.click();
				System.out.println("Selected: " + result.getText());
				break;
			}
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	
}
