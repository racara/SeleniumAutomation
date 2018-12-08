package pages.classes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;;



public class AubayPageFactory {
WebDriver driver;
	
	@FindBy(xpath="//*[@id='nav']/li[5]/a")
	WebElement opportunities;
	
	@FindBy(xpath="//*[@id='scrollDown']/i")
	WebElement scrolldown;
	
	@FindBy(xpath="//*[@id='services']/div[1]/a")
	WebElement spontaneous;
	
	@FindBy(xpath="//*[@id='vaga_3']/i")
	WebElement spontaneousCandidate;
	
	@FindBy(xpath="//*[@id='opp-modal']/div/div/div[3]/div[2]/button")
	WebElement sendSpontaneousCandidate;
	
	@FindBy(id="Name")
	WebElement name;
	
	@FindBy(id="NivelProfissionalId")
	WebElement seniority;
	
	@FindBy(id="TelemovelList")
	WebElement telefone;
	
	@FindBy(id="Mobile")
	WebElement mobile;
	
	@FindBy(id="Technologies")
	WebElement technology;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Linkedin")
	WebElement linkedin;
	
	@FindBy(id="AutorizeRecrut")
	WebElement autorizeRecruit;
	
	@FindBy(id="AutorizeJobOpp")
	WebElement autorizeJobOpp;
	
	@FindBy(id="AutorizePolicy")
	WebElement autorizePolicy;
	
	@FindBy(xpath="//*[@id='toast-container']/div[1]")
	WebElement errorMessage;
	
	@FindBy(id="Save")
	WebElement save;
	
	@FindBy(id="err_Name")
	WebElement errorName;
	
	@FindBy(id="err_Mobile")
	WebElement errorMobile;
	
	@FindBy(id="err_Technologies")
	WebElement errorTechnologies;
	
	@FindBy(id="err_Email")
	WebElement errorEmail;
	
	@FindBy(id="err_AutorizeRecrut")
	WebElement errorAutorizeRecrut;
	
	@FindBy(id="err_AutorizePolicy")
	WebElement errorAutorizePolicy;
	
	@FindBy(xpath="//*[@id='toast-container']/div/div")
	WebElement rememberReCaptcha;
	
	public AubayPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickopportunitie() throws InterruptedException  {
		scrolldown.click();
		Thread.sleep(3000);
		opportunities.click();
		Thread.sleep(3000);
		spontaneousCandidate.click();
		Thread.sleep(3000);
		sendSpontaneousCandidate.click();
		Thread.sleep(3000);
	}
	
	public void setName(String candidatename) {
		name.sendKeys(candidatename);	
	}

	
	public void setSeniority(int index) {
		Select sel = new Select(seniority);
		sel.selectByIndex(index);
	}
	
	public void setTelefone(int index) {
		Select sel = new Select(telefone);
		sel.selectByIndex(index);
	}
	
	public void setMobile(String numerocelular) {
		mobile.sendKeys(numerocelular);	
	}

	public void setTechnologies(String technologia1, String technologia2, String technologia3  ) {
		Select sel = new Select(technology);
		sel.selectByVisibleText(technologia1);
		sel.selectByVisibleText(technologia2);
		sel.selectByVisibleText(technologia3);		
	}

	public void setEmail(String candidateemail) {
		email.sendKeys(candidateemail);	
	}
	
	public void setLinkedin(String linkedincandidate) {
		email.sendKeys(linkedincandidate);	
	}

	public void clickAutorizeRecruit() {
		autorizeRecruit.click();	
	}
	
	public void clickAutorizeJobOppt() {
		autorizeJobOpp.click();	
	}
	
	public void clickAutorizePolicy() {
		autorizePolicy.click();	
	}


	
	public void menssageCaptcha() throws Exception  {
		String mensagemEsperada = "Please check the reCaptcha box to continue.";
		String mensagemDeErro = rememberReCaptcha.getText();	
		if(mensagemDeErro.equals(mensagemEsperada)){
			System.out.println("The message expected is: " + mensagemEsperada + 
					"The message found was: " + mensagemDeErro );
		} else{
			System.out.println("The correct message  is: " + mensagemDeErro );
			throw new Exception("Message different than expected.");
		}
	}
	
	public void requirimentField() throws Exception  {
		String mensagemEsperada = "Required fields: Name Mobile Email Technologies Candidate Integration Privacy Policy !";
		String mensagemDeErro = errorMessage.getText();	
		if(mensagemDeErro.equals(mensagemEsperada)){
			System.out.println("The message expected is: " + mensagemEsperada + 
					"The message found was: " + mensagemDeErro );
		} else{
			System.out.println("The correct message  is: " + mensagemDeErro );
			throw new Exception("Message different than expected.");
		}
	}
	
	public void invalidMobileNumber() throws Exception  {
		String mensagemEsperada = "Invalid mobile number. Check code and number.";
		String mensagemDeErro = errorMessage.getText();	
		if(mensagemDeErro.equals(mensagemEsperada)){
			System.out.println("The message expected is: " + mensagemEsperada + 
					"The message found was: " + mensagemDeErro );
		} else{
			System.out.println("The correct message  is: " + mensagemDeErro );
			throw new Exception("Message different than expected.");
		}
	}
	
	public void invalidEmail() throws Exception  {
		String mensagemEsperada = "Invalid email!";
		String mensagemDeErro = errorMessage.getText();	
		if(mensagemDeErro.equals(mensagemEsperada)){
			System.out.println("The message expected is: " + mensagemEsperada + 
					"The message found was: " + mensagemDeErro );
		} else{
			System.out.println("The correct message  is: " + mensagemDeErro );
			throw new Exception("Message different than expected.");
		}
	}
	
	public void verifyErroNameIsDisplayed() throws Exception {
		boolean errorNameDisplayed = errorName.isDisplayed();
		if(errorNameDisplayed){
			System.out.println("Name - The condition is : " + true); 
		}else{
			System.out.println("Name - The condition is false: " + false );
			throw new Exception("Name - The considion must be: " + true 
					+ "but was: " + false);}
		}
		
	public void verifyErrorTechnologiesIsDisplayed() throws Exception {
		boolean errorTechDisplayed = errorTechnologies.isDisplayed();
		if(errorTechDisplayed){
			System.out.println("Technology - The condition is : " + true); 
			}else{
			System.out.println("Technology - The condition is false: " + false );
			throw new Exception("Technology - The considion must be: " + true 
					+ "but was: " + false);
			}
	}
		
	public void verifyErrorEmailTechnologiesIsDisplayed() throws Exception {
		boolean errorEmailDisplayed = errorEmail.isDisplayed();
		if(errorEmailDisplayed){
			System.out.println("Email - The condition is : " + true); 
			}else{
			System.out.println("Email - The condition is false: " + false );
			throw new Exception("Email- The considion must be: " + true 
					+ "but was: " + false);
			}
	}	
	
	public void verifyErrorAutorizeRecruitIsDisplayed() throws Exception {
		boolean errorAutorizeRecruitDisplayed = errorAutorizeRecrut.isDisplayed();
		if(errorAutorizeRecruitDisplayed){
			System.out.println("AutorizeRecruit - The condition is : " + true); 
			}else{
			System.out.println("AutorizeRecruit - The condition is false: " + false );
			throw new Exception("AutorizeRecruit - The considion must be: " + true 
					+ "but was: " + false);
			}
	}
	
	public void verifyErrorAutorizePolicyIsDisplayed() throws Exception {
		boolean errorAutorizePolicyDisplayed = errorAutorizePolicy.isDisplayed();
		if(errorAutorizePolicyDisplayed){
			System.out.println("AutorizePolicy - The condition is : " + true); 
			}else{
			System.out.println("AutorizePolicy - The condition is false: " + false );
			throw new Exception("AutorizePolicy - The considion must be: " + true 
					+ "but was: " + false);
			}
	}
	
	public void verifyErrorMobileIsDisplayed() throws Exception {
		boolean errorMobileDisplayed = errorMobile.isDisplayed();
		if(errorMobileDisplayed){
			System.out.println("Mobile - The condition is : " + true); 
			}else{
			System.out.println("Mobile - The condition is false: " + false );
			throw new Exception("Mobile - The considion must be: " + true 
					+ "but was: " + false);
			}
	}
	
	/*	errorName.isDisplayed();	
		errorTechnologies.isDisplayed();
		errorEmail.isDisplayed();
		errorAutorizeRecrut.isDisplayed();
		errorAutorizePolicy.isDisplayed();
	*/	
	
	

	
	public void clickSave() {
		save.click();	
	}
}

