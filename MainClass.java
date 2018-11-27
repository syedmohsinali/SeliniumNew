package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import Main.Registration;
import Main.Login;
import Main.Order;
import Main.Logout;


public class MainClass {
	
	public static void main(String[] args) throws InterruptedException, IOException, BiffException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		
		//************ Chrome Options *************
		ChromeOptions options= new ChromeOptions(); 
		options.addArguments("start-mazimized");
		options.addArguments("disable-infobars");
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
	
		//Registration
		Registration Reg =new Registration(driver);
		Reg.Regist("Syed Mohsin", "Ali", "syed.mohxxin@gmail.com", "03462482724", "1234567", "1234567");
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//Login from Excel Sheet
		File F= new File("C:\\Users\\syed.mohsin\\Desktop\\Credentials.xls");
		FileInputStream fs= new FileInputStream(F);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet AddressSheet = wb.getSheet("User_Login");
		
		Login Log=new Login(driver);
		Log.Login(AddressSheet.getCell(0,1).getContents(),AddressSheet.getCell(1,1).getContents());
		
		//Login from Login Class
		/*driver.get("https://demo.opencart.com/index.php?route=account/login");
		Log.Login("syed.mohxxin@gmail.com", "1234567");	*/
		
		//Search
		Log.Search("hp");
		
		//**************** Explicit Wait ******************
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[starts-with(@name,'option[225]')]")));				//xpath- start with clause
		System.out.println("Found Date-calender");
		
		//AddtoCart
				Order Ord= new Order(driver);
				Ord.AddCart();
		

		//***************** Implicit Wait *********************
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		//**************** Scroll Down *********************
			/*WebElement Billing_details  = driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]"));
			JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			jse2.executeScript("arguments[0].scrollIntoView()", Billing_details);		
			Billing_details.click();
			
			Ord.BillingDetails("Syed Mohsin", "Ali", "House abc, Karachi", "Karachi", "XYZ", "162", "2462");
*/
			Logout Logt= new Logout(driver);
			Logt.Logout();		
		
	}


}
