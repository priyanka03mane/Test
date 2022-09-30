package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.AddtoCart;
import Pages.Backtohome;
import Pages.HomePage;
import Pages.LoginPage;
import setup.Base;
import utilis.utility;

public class TstNgClass1  extends Base{
	private WebDriver driver;
	private LoginPage  loginpage;
	private HomePage homepage;
	private AddtoCart addtocart;
	private Backtohome backtohome;
	private SoftAssert soft;
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		if(browserName.equals("chrome")) {
		 		driver= openChromeBrowser();
			}
		if(browserName.equals("Firefox")) {
				driver= openFirefoxBrowser();
			}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@BeforeClass
	public void creatObject() {
		loginpage  = new LoginPage(driver);
		homepage = new HomePage(driver);
		addtocart = new AddtoCart(driver);
		backtohome  = new Backtohome(driver);
		}
	@BeforeMethod
	public void beforemethod() throws EncryptedDocumentException, IOException {
			driver.get("https://www.saucedemo.com/");
			String username = utility.getexcelsheet("Data", 0, 0);
			loginpage.sendusername(username);
			String password = utility.getexcelsheet("Data", 1, 0);
			loginpage.sendpassword(password);
			loginpage.clickloginbutton();
			homepage.clickshopingbag();
			String firstname = utility.getexcelsheet("Data", 3, 0);
			addtocart.sendFirstName(firstname);
			String lastname = utility.getexcelsheet("Data", 4, 0);
			addtocart.sendLastName(lastname);
			String zipcode = utility.getexcelsheet("Data", 5, 0);
			addtocart.sendZipcode(zipcode);
			addtocart.clickcontinew();	
			soft = new SoftAssert();
	}
	@Test
	public void verifybackbutton() throws IOException {
		backtohome.clicklogout();
		String url= driver.getCurrentUrl();
		String title=driver.getTitle();
		String currenturl = utility.getexcelsheet("Data", 0, 1);
		String currentTitle = utility.getexcelsheet("Data", 1, 1);
		soft.assertEquals(url, currenturl);
		soft.assertEquals(title, currentTitle);
		int TESTID=333;
		utility.getshot(driver,TESTID);
		soft.assertAll();
		}
	@AfterClass
	public void clearObjects() {
		loginpage  = null;
		homepage = null;
		addtocart = null;
		backtohome  = null;
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}

}
