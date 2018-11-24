package Training3OOPS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ObjectClass {

	WebDriver driver;
	public ObjectClass (WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-email")
	public WebElement Emailid;

	@FindBy(id="input-password")
	public WebElement Password;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	public WebElement submit;

	public void Login(String ID, String PWD){
		Emailid.sendKeys(ID);
		Password.sendKeys(PWD);
		submit.click();
	
		
	}

	
}
	
	

