package pages.classes;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.classes.AubayPageFactory;

public class PageFactoryTest {
	private WebDriver driver;
	String baseUrl;
	AubayPageFactory aubayPageFactory;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafael\\workspace\\SeleniumAutomation\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://www.aubay.pt/";
		aubayPageFactory = new AubayPageFactory(driver);
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void pressSubmitWithoutClickInRecaptcha() throws Exception {
		driver.get(baseUrl);
		aubayPageFactory.clickopportunitie();
		aubayPageFactory.setName("Rafael");
		aubayPageFactory.setSeniority(1);
		aubayPageFactory.setTelefone(30);
		aubayPageFactory.setMobile("11995681426");
		aubayPageFactory.setTechnologies("Selenium", ".Net", "JIRA");
		aubayPageFactory.setEmail("rafaelsilva9126@hotmail.com");
		aubayPageFactory.setLinkedin("rafael");
		aubayPageFactory.clickAutorizeRecruit();
		aubayPageFactory.clickAutorizeJobOppt();
		aubayPageFactory.clickAutorizePolicy();
		aubayPageFactory.clickSave();		
		aubayPageFactory.menssageCaptcha();
	}	
	@Test
	public void validateAllRequiredFields() throws Exception {
		driver.get(baseUrl);
		aubayPageFactory.clickopportunitie();
		aubayPageFactory.clickSave();		
	    aubayPageFactory.requirimentField();
	    aubayPageFactory.verifyErroNameIsDisplayed();
	    aubayPageFactory.verifyErrorMobileIsDisplayed();
	    aubayPageFactory.verifyErrorTechnologiesIsDisplayed();
	    aubayPageFactory.verifyErrorEmailTechnologiesIsDisplayed();
	    aubayPageFactory.verifyErrorAutorizeRecruitIsDisplayed();
	    aubayPageFactory.verifyErrorAutorizePolicyIsDisplayed();
		    
	}	
	@Test
	public void invalidMobilePhone() throws Exception {
		driver.get(baseUrl);
		aubayPageFactory.clickopportunitie();
		aubayPageFactory.setName("Rafael");
		aubayPageFactory.setSeniority(1);
		aubayPageFactory.setTelefone(0);
		aubayPageFactory.setMobile("11995681426");
		aubayPageFactory.setTechnologies("Selenium", ".Net", "JIRA");
		aubayPageFactory.setEmail("rafaelsilva9126@hotmail.com");
		aubayPageFactory.setLinkedin("rafael");
		aubayPageFactory.clickAutorizeRecruit();
		aubayPageFactory.clickAutorizeJobOppt();
		aubayPageFactory.clickAutorizePolicy();
		aubayPageFactory.clickSave();		
		aubayPageFactory.invalidMobileNumber();
		aubayPageFactory.verifyErrorMobileIsDisplayed();
	}	
	@Test
	public void invalidEmail() throws Exception {
		driver.get(baseUrl);
		aubayPageFactory.clickopportunitie();
		aubayPageFactory.setName("Rafael");
		aubayPageFactory.setSeniority(1);
		aubayPageFactory.setTelefone(30);
		aubayPageFactory.setMobile("11995681426");
		aubayPageFactory.setTechnologies("Selenium", ".Net", "JIRA");
		aubayPageFactory.setEmail("rafael");
		aubayPageFactory.setLinkedin("rafael");
		aubayPageFactory.clickAutorizeRecruit();
		aubayPageFactory.clickAutorizeJobOppt();
		aubayPageFactory.clickAutorizePolicy();
		aubayPageFactory.clickSave();		
		aubayPageFactory.invalidEmail();
		aubayPageFactory.verifyErrorEmailTechnologiesIsDisplayed();
	}	
		
}
