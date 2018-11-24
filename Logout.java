package Training3OOPS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {

	WebDriver driver;
	public Logout(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
	public WebElement Logout;
	
	public void Logout1() {
		driver.get("https://demo.opencart.com/index.php?route=account/logout");
	}

	}

