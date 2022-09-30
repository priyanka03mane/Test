package Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import pagered.FramePage;
import pagered.HelpPage;
import pagered.HomepageRed;
import setuprd.Base;
 
public class TestNgClassRdbus extends Base {
	private WebDriver driver;
	private HomepageRed home;
	private HelpPage help;
	private FramePage helpline;
	private ArrayList<String> add ;
	@Parameters("browser")
	@BeforeTest
	public void openbrowser(String browserName) {
		if(browserName.equals("Chrome")) {
			driver= openChromeBrowser();
		}
		if(browserName.equals("Firefox")) {
			driver=openFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
		@BeforeClass
		public void creatPomObjects() {
			home = new HomepageRed(driver);
			help = new HelpPage(driver);
			helpline = new FramePage(driver);
	
	}
	@BeforeMethod
	public void openhomepage() {
		driver.get("https://www.redbus.in/");
		home.bookbus();
		help.clickonhelp();
		add = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		helpline.switchtoframe();
	}
	@Test 
	public void checkbooking() throws InterruptedException {
		Thread.sleep(3000);
		helpline.clicktobookinghelp();
		
		
	}
	@Test 
	public void  clickontech() throws InterruptedException {
		helpline.clickontech();
		
	}
	@AfterMethod
	public void aftermethod() {
		driver.close();
		driver.switchTo().window(add.get(0));
		driver.navigate().back();
	}
	@AfterClass
	public void clearobject() {
		home = null ;
		help = null;
		helpline = null;
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}

}
