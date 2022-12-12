package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginfire {
	public WebDriver driver;
	
	@FindBy(id="fl_login_btn")
	private WebElement loginbtn;
	
	public Loginfire(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public LogFire login() {
		loginbtn.click();
		return new LogFire(driver);
	}
}
