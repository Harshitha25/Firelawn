package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {
	public WebDriver driver;

	@FindBy(xpath="//button[text()='add to cart'][1]")
	private WebElement addtocartbtn;
	
	@FindBy(id="cart_fl")
	private WebElement cart;
	
	public Product(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public Cart addtocart() {
		addtocartbtn.click();
		cart.click();
		return new Cart(driver);
		
	}

	public WebElement getAddtocartbtn() {
		return addtocartbtn;
	}

	public WebElement getCart() {
		return cart;
	}
}
