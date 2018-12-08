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

public class CalendarSelection {
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

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

/*	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl2);
		// Click flights tab
		driver.findElement(By.id("tab-flight-tab")).click();
		// Find departing field
		WebElement departingField = driver.findElement(By.id("flight-departing"));
		// Click departing field
		departingField.click();
		Thread.sleep(3000);
		// Find the date to be selected
		WebElement dateToSelect = driver.findElement(By.xpath("//*[@id='flight-departing-wrapper']//button[@data-day='31']"));
		// Click the date
		dateToSelect.click();
	}
*/
	@Test
	public void test2() throws InterruptedException {
		driver.get(baseUrl2);
		// Click flights tab
		driver.findElement(By.id("tab-flight-tab")).click();
		// Find departing field
		WebElement departingField = driver.findElement(By.id("flight-departing"));
		// Click departing field
		departingField.click();
		Thread.sleep(3000);
		// Find the date to be selected
		WebElement calMonth1 = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=1]"));
		calMonth1.click();
		Thread.sleep(3000);
		List<WebElement> allValidDates = calMonth1.findElements(By.tagName("button"));
		for (WebElement date : allValidDates){
			if (date.getText().equals("21")){
				date.click();
				break;	
			};
			
		}

	}}
	

