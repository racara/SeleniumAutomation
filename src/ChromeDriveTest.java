import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriveTest {

	public static void main(String[] args) throws InterruptedException {
		// http://chromedriver.storage.googleapis.com/index.html
		String baseURL = "https://stackoverflow.com/";
		//DesiredCapabilities caps = DesiredCapabilities.firefox();
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafael\\workspace\\SeleniumAutomation\\libs\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("a[href$=redirect][class^=login][rel*=no]")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("path[d^=M9]")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("a[href*=tour][class^=js]")).click();
	}

}
