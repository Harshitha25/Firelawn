package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	public WebDriver driver;
	
	@FindBy(id="search")
	private WebElement searchtb;
	
	
	@FindBy(id="search_prod")
	private WebElement searchbtn;
	
	public Home(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getSearchtb() {
		return searchtb;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	
	public Product searchelement(String productname) {
		searchtb.sendKeys(productname);
		searchbtn.click();
		return new Product(driver);
	}
}
