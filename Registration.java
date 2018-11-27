package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
	
	WebDriver Driver;
	
	public Registration (WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}
	
	@FindBy(id="input-firstname")
	public WebElement Firstname;
	
	@FindBy(id="input-lastname")
	public WebElement Lastname;
	
	@FindBy(id="input-email")
	public WebElement Email;
	
	@FindBy(id="input-telephone")
	public WebElement Telephone;
	
	@FindBy(id="input-password")
	public WebElement Password;
	
	@FindBy(id="input-confirm")
	public WebElement ConPassword; 
	
	@FindBy (xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	public WebElement Checkbox;
	
	@FindBy (xpath="//input[starts-with(@value,'Continue') and @type=\"submit\"]")
	public WebElement Continue;
	
	
	public void Regist(String FirstName, String LastName, String ID, String Phone, String PWD, String ConPWD) {
		
		Firstname.sendKeys(FirstName);
		Lastname.sendKeys(LastName);
		Email.sendKeys(ID);
		Telephone.sendKeys(Phone);
		Password.sendKeys(PWD);
		ConPassword.sendKeys(ConPWD);
		Checkbox.click();
		Continue.click();
		}
	
}
