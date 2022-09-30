package pagered;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {
	
	@FindBy (xpath="(//div[@title='close'])[2]") private WebElement close ;
	@FindBy (xpath="//iframe[@width='380']") private WebElement ifr;
	@FindBy (xpath="(//div[@class='listitems'])[1]") private WebElement  bookinghelp;
	@FindBy (xpath="(//div[@class='listitems'])[2]") private WebElement techissue;
	private WebDriver driver;
	
	public FramePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		 this.driver=driver;
	}
	public void switchtoframe() {
		 close.click();
		driver.switchTo().frame(ifr);
		
		 
	}
	public void clicktobookinghelp() {
		 bookinghelp.click();
	}
	public void clickontech() throws InterruptedException {
		Thread.sleep(3000);
		 techissue.click();
	}

}
