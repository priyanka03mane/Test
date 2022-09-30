package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.AddtoCart;
import Pages.Backtohome;
import Pages.HomePage;
import Pages.LoginPage;


public class TestClass1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		 driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickloginbutton();
		Thread.sleep(3000);
		HomePage homepage = new HomePage(driver);
		homepage.clickshopingbag();
		Thread.sleep(3000);
		AddtoCart addtocart = new AddtoCart(driver);
		addtocart.clickcontinew();
		Thread.sleep(5000);
		Backtohome backtohome  = new Backtohome(driver);
		backtohome.clicklogout();
		
		
		
		
		
		
		
	}

}
