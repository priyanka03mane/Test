package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
		// Initialize the variable
		@FindBy (xpath="(//button[text()='Add to cart'])[1]") private WebElement addtocard;
		@FindBy (xpath="//a[@class='shopping_cart_link']") private WebElement shopingbag ;
		@FindBy (xpath="//button[@id='checkout']") private WebElement checkout;
		
		//  Declare the variable i.e. constructor call
		public HomePage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		// use of variable
		public void clickshopingbag() {
			addtocard.click();
			shopingbag.click();
			checkout.click();
		}
		
	
}
