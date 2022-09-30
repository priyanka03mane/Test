package pagered;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageRed {
	
	@FindBy (xpath="//input[@data-message='Please enter a source city']") 
	private WebElement source;
	@FindBy (xpath="//input[@id='dest']") 
	private WebElement from;
	@FindBy (xpath="//input[@data-message='Please enter a destination city']")
	private WebElement destination ;
	@FindBy (xpath="//li[@class='selected']") private WebElement to;
	@FindBy (xpath="//input[@id='onward_cal']") private WebElement date;
	@FindBy (xpath="//td[text()='25']") private WebElement date1;
	@FindBy (xpath="//button[@id='search_btn']") private WebElement search;
	
	public HomepageRed(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void bookbus() {
		source.sendKeys("Thane West,Mumbai");
		from.click();
		destination.sendKeys("Swargate Pune");
		to.click();
		date.click();
		date1.click();
		search.click();
	}
	
	
	
	
	
}
//@FindBy (xpath="") private WebElement mi;