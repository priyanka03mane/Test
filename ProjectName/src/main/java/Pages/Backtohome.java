package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Backtohome {//initialize the variable
			
			@FindBy (xpath="//button[text()='Back Home']") private WebElement backhome;
			
			// Declare the variable i.e. constructor
			public Backtohome(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			// use of variable
			
			public void clicklogout() {
				
				backhome.click();
				
				
			}
}
