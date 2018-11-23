package SeliniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Registration {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("disable-infobars");
		driver.get("https://demo.opencart.com/index.php?route=account/register");
	// Registration
				WebElement Firstname;
				Firstname = driver.findElement(By.id("input-firstname"));
				Firstname.sendKeys("Syed Mohsin");

				WebElement Lastname;
				Lastname = driver.findElement(By.id("input-lastname"));
				Lastname.sendKeys("Ali");
				
				WebElement Emails;
				Emails = driver.findElement(By.id("input-email"));
				Emails.sendKeys("syed.mohxin@gmail.com");
				
				WebElement Telephone;
				Telephone = driver.findElement(By.id("input-telephone"));
				Telephone.sendKeys("03462482724");
				
				WebElement Password;
				Password = driver.findElement(By.id("input-password"));
				Password.sendKeys("1234567");
				
				WebElement ConPassword;
				ConPassword = driver.findElement(By.id("input-confirm"));
				ConPassword.sendKeys("1234567");
				
				// Check box
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
				
				// ContinueButton
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();	
			 
		driver.close();		
		driver.quit();
	}

}
