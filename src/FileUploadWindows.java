import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
//import tutorialselenium.EnterPassword;

import usefulmethods.GenericMethods;

public class FileUploadWindows {
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl2;
	GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafael\\workspace\\SeleniumAutomation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl1 = "https://www.gmail.com/";
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
	public void fileUpload() throws AWTException, InterruptedException {
		driver.get(baseUrl1);
		Thread.sleep(7000);
		driver.findElement(By.name("identifier")).sendKeys("rzdasil@gmail.com");
		driver.findElement(By.xpath("//*[@id='identifierNext']/div[2]")).click();
		 driver.findElement(By.name("password")).sendKeys("Jaxude26"); // Enter your password
		//EnterPassword.enterPassword(driver); // Comment this
		driver.findElement(By.xpath("//*[@id='passwordNext']/content")).click();
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		driver.findElement(By.xpath("//div[@class='wO nr l1']//textarea")).sendKeys("rzdasil@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test File Upload");
		WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
		fileInput.click();
		
		StringSelection ss = new StringSelection("C:\\Users\\Anil Tomar\\Desktop\\testfile.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		// Ctrl + v
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	}
		

	}
	

