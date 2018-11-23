package SeliniumTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	public static void main(String[] arg) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions(); 		//Driver's option
		options.addArguments("start-mazimized");
		options.addArguments("disable-infobars");
		
		
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
	// Login Form
	WebElement username;
	username =driver.findElement(By.id("input-email"));
	username.clear();
	username.sendKeys("syed.mohxin@gmail.com");

	WebElement Loginpassword;
	Loginpassword= driver.findElement(By.id("input-password"));
	Loginpassword.click();
	Loginpassword.sendKeys("1234567");

	WebElement Button;
	Button = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
	Button.click();
	
	//Verification of Successful Login
	String actualpagetitle = driver.getTitle();
	String expectedTitle = "My Account";
	 
	 if (actualpagetitle.contentEquals(expectedTitle)){
           System.out.println("Test Passed!");
       } else {
           System.out.println("Test Failed");
       }

	Thread.sleep(5000);
	
	WebElement Search;
	Search = driver.findElement(By.xpath("//input [@type='text' and @class='form-control input-lg']"));
	Search.sendKeys("hp");
	
	WebElement SearchBtn;
	SearchBtn = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
	SearchBtn.click();
	
	WebElement HPclck;
	HPclck =driver.findElement(By.cssSelector("#content > div:nth-child(8) > div > div > div:nth-child(2) > div.caption > h4 > a"));
	HPclck.click();
	
	//Explicit Wait
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[starts-with(@name,'option[225]')]")));				//xpath- start with clause
	System.out.println("Found Date-calender");
	
	//Scroll down
	WebElement AddCartScroll  = driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
	JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	jse1.executeScript("arguments[0].scrollIntoView()", AddCartScroll);		
	AddCartScroll.click();
	
	WebElement AddCartBtn;
	AddCartBtn= driver.findElement(By.xpath("(//input[starts-with(@name,'option[225]')]|//*[contains(@data-loading-text,'Loading')])[4]"));    //xpath with 'OR' operator
	AddCartBtn.click();
	System.out.println("Success");
	
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	
	WebElement dropdownCart;
	dropdownCart=driver.findElement(By.xpath("//*[@id=\"cart\"]/button"));
	dropdownCart.click();
	
	WebElement Checkout;
	Checkout = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong"));
	Checkout.click();
	
	WebElement Billing_details  = driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]"));
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].scrollIntoView()", Billing_details);		
	Billing_details.click();
	
	WebElement FirstName;
	FirstName = driver.findElement(By.xpath("//*[contains(@name,'firstname')]"));			//xpath- contains with clause
	FirstName.sendKeys("Syed Mohsin");
	
	WebElement LastName;
	LastName = driver.findElement(By.id("input-payment-lastname"));
	LastName.sendKeys("Ali");
	
	WebElement Address;
	Address = driver.findElement(By.id("input-payment-address-1"));
	Address.sendKeys("House XYZ, 123 Street");
	
	WebElement City;
	City = driver.findElement(By.id("input-payment-city"));
	City.sendKeys("Karachi");
	
	WebElement PostCode;
	PostCode = driver.findElement(By.id("input-payment-postcode"));
	PostCode.sendKeys("1234567890");
	
	WebElement Country;
	Country = driver.findElement(By.xpath("//*[@id=\"input-payment-country\"]"));
	Country.click();
	
	
	Select CtryDrpdwn = new Select(driver.findElement(By.xpath("//*[@name='country_id']")));		//xpath with dropdown
	CtryDrpdwn.selectByVisibleText("Pakistan");
	
	Select CtryDrpdwn1 = new Select(driver.findElement(By.xpath("//*[@name='zone_id']")));
	CtryDrpdwn1.selectByVisibleText("Sindh");
	
	WebElement Checkoutbtn;
	Checkoutbtn= driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
	Checkoutbtn.click();
	
	// Logout
	WebElement dropdown;
	dropdown = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
	dropdown.click();
	
	WebElement Logout;
	Logout = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a"));
	Logout.click();
	
	driver.close();
	driver.quit();
	}

}
