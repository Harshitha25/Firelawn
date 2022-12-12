package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address {
	public WebDriver driver;
	
	@FindBy(xpath="//span[text()='Add New Address']")
	private WebElement newaddress;
	
	@FindBy(name="address")
	private WebElement selectradio;
	
	@FindBy(xpath="//button[text()='Proceed']")
	private WebElement proceedbtn;
	
	public Address(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public Payment selecttb() {
		selectradio.click();
		proceedbtn.click();
		return new Payment(driver);
	}
}
