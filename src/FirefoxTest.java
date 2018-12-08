import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {

	public static void main(String[] args) throws InterruptedException {
		//btnK
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rafael\\Desktop\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
	/*	String baseURL = "http://demostore.x-cart.com";
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.findElement(By.partialLinkText("Shipping")).click();;
		*/
		driver.manage().window().maximize();
		String baseURL = "https://www.google.com.br";
		Thread.sleep(2000);
		driver.findElement(By.linkText("Gmail")).click();;
		//driver.findElement(By.id("lst-ib")).sendKeys("letskodeit");
		//driver.findElement(By.name("btnK")).click();
	}
}
