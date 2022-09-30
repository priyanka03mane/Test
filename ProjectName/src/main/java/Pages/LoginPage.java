package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {// Initialize the variable
		@FindBy (xpath="//input[@type='text']") private WebElement userName;
		@FindBy (xpath="//input[@id='password']") private WebElement passWord;
		@FindBy (xpath="//input[@type='submit']") private WebElement loginButton;
	
		// Declare variable i.e. constructor call
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);	
		}
		// use of variable i.e. methods
		
		public void sendusername(String username) {
			userName.sendKeys(username);
			
		}
		public void sendpassword(String password) {
			passWord.sendKeys(password);
		}
		public void clickloginbutton() {
				
				loginButton.click();
		}
}
