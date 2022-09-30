package pagered;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpPage {
	@FindBy (xpath="//div[@class='fr config-wrapper ']")
	private WebElement help ;
	
	public HelpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickonhelp() {
		help.click();
	}

}
////@FindBy (xpath="") private WebElement mi;