package Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pagered.FramePage;
import pagered.HelpPage;
import pagered.HomepageRed;

public class TestClassRd {
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://www.redbus.in/");
	
	HomepageRed home = new HomepageRed(driver);
	home.bookbus();
	HelpPage help = new HelpPage(driver);
	help.clickonhelp();
	ArrayList<String> add = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(add.get(1));
	FramePage helpline = new FramePage(driver);
	helpline.switchtoframe();
	helpline.clicktobookinghelp();
	helpline.clickontech();
}
}