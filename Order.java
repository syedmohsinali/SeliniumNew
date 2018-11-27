package Main;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Order {

	WebDriver Driver;
	 public Order (WebDriver Driver){
		 this.Driver= Driver;
		 PageFactory.initElements(Driver, this);
	}
	
	//AddCart
	@FindBy (id="cart-total")
	public WebElement AddCartDrpdwn;
	
	@FindBy (xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong/i") 
	public WebElement AddCartClick;
	
	//BillingDetails	
	@FindBy (xpath="//*[contains(@name,'firstname')]")
	public WebElement FName;
	
	@FindBy (id="input-payment-lastname")
	public WebElement LName;
	
	@FindBy (id="input-payment-address-1")
	public WebElement Address;
	
	@FindBy (id="input-payment-city")
	public WebElement City;
	
	@FindBy (id="input-payment-postcode")
	public WebElement PostCode;
	
	@FindBy (xpath="//*[@name='country_id']")
	public WebElement Country;
	
	@FindBy (xpath="//*[@name='zone_id']")
	public WebElement Zone;
	
	@FindBy (xpath="//input[@value=\"Continue\"]")
	public WebElement Checkoutbtn;
	
	
	public void AddCart() throws InterruptedException {
			WebElement AddCartBtn  = Driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
			JavascriptExecutor jse1 = (JavascriptExecutor)Driver;
			jse1.executeScript("arguments[0].scrollIntoView()", AddCartBtn);		
			AddCartBtn.click();
			AddCartDrpdwn.click();
			// Thread sleep wait
			Thread.sleep(6000);
			AddCartClick.click();
	}
	
	public void BillingDetails(String FNames, String LNames, String Add, String Cty, String PCode, String CTR, String Region) {
	FName.sendKeys(FNames);
	LName.sendKeys(LNames);
	Address.sendKeys(Add);
	City.sendKeys(Cty);
	PostCode.sendKeys(PCode);
	Select CTR1= new Select(Country);
	CTR1.selectByValue("162");
	Select Region1= new Select(Zone);
	Region1.selectByValue("2462");
	Checkoutbtn.click();

	}
}
