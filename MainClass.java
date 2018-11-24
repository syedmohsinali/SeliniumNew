package MainClass;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import Training3OOPS.ObjectClass;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import Training3OOPS.Logout;

public class MainClass {
	
	public static void main(String[] args) throws InterruptedException, BiffException, IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\labit\\Downloads\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions(); 		//Driver's option
		options.addArguments("start-mazimized");
		options.addArguments("disable-infobars");
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		System.out.println(":D ");
		
		FileInputStream fs= new FileInputStream("C:\\Users\\labit\\Desktop\\New folder\\Test1.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet AddressSheet = wb.getSheet("User_login");
		System.out.println(AddressSheet.getCell(0,1).getContents() + AddressSheet.getCell(1,1).getContents());


		System.out.println(":D ");
		
		ObjectClass Log1=new ObjectClass(driver);
		System.out.println(AddressSheet.getCell(0,1).getContents() + AddressSheet.getCell(1,1).getContents());
		
		Log1.Login(AddressSheet.getCell(0,1).getContents(),AddressSheet.getCell(1,1).getContents());

		//System.out.println(AddressSheet.getCell(0,1).getContents());
		//Log1.Login("syed.mohxin@gmail.com", "1234567" );
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"column-right\"]/div/a[13]")));				//xpath- start with clause
		
		Logout Log2= new Logout(driver);
		Log2.Logout1();
		
		driver.close();
		driver.quit();
	}

}
