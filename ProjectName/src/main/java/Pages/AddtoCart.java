package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart {
			// Initialize the variable
			@FindBy(xpath="//input[@id='first-name']") private WebElement firstName ;
			@FindBy (xpath="//input[@id='last-name']") private WebElement lastName;
			@FindBy (xpath="//input[@id='postal-code']") private WebElement zipcode;
			@FindBy (xpath="//input[@id='continue']") private WebElement continew;
			@FindBy (xpath="//button[@name='finish']") private WebElement finish;
			// Declare the variable i.e constructor call
			
			public AddtoCart( WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			// use of variable 
			public void sendFirstName(String firstname) {
				firstName.sendKeys(firstname);	
				
			}
			public void sendLastName(String lastname) {
				lastName.sendKeys(lastname);
				
			}
			public void sendZipcode(String zip) {
				zipcode.sendKeys(zip);
			}
			
			public  void clickcontinew() {
					
				continew.click();
				finish.click();
			}

}
