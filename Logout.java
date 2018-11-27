package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	
	WebDriver Driver;
	public Logout(WebDriver Driver)
	{
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}
	
	@FindBy (xpath=("//*[@id=\\\"top-links\\\"]/ul/li[2]/a"))
	public WebElement dropdown;
	
	@FindBy (xpath=("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a"))
	public WebElement LogOT;
	
	public void Logout() {
		dropdown.click();
		LogOT.click();
	}
	
}
