package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	WebDriver driver;

	@FindBy(id="buynow_fl")
	private WebElement buybtn;
	
		
	public Cart(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public Address buynow() {
		buybtn.click();
		return new Address(driver);
	}

	
	
}
