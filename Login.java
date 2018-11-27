package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver Driver;
	public  Login (WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}
	
	@FindBy(id="input-email")
	public WebElement Emailid;

	@FindBy(id="input-password")
	public WebElement Password;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	public WebElement submit;
	
	@FindBy(xpath="//input [@type='text' and @class='form-control input-lg']")
	public WebElement Searchtxt;
	
	@FindBy (xpath="//*[@id=\"search\"]/span/button")
	public WebElement SearchBtn;
	
	@FindBy (css="#content > div:nth-child(8) > div > div > div:nth-child(2) > div.caption > h4 > a")
	public WebElement HPclck;
	
	public void Login(String ID, String PWD){
		Emailid.sendKeys(ID);
		Password.sendKeys(PWD);
		submit.click();
	}
	
	public void Search(String Searchbox) {
		Searchtxt.sendKeys(Searchbox);
		SearchBtn.click();
		HPclck.click();
	}
	
	
}
