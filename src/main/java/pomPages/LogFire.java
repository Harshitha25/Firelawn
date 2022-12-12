package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogFire {
	public WebDriver driver;
	@FindBy(id="fl_email")
	private WebElement emailtb;
	
	@FindBy(id="fl_password")
	private WebElement pwdtb;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement logintb;
	
	public LogFire(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public Home logindetails(String email, String pwd) {
		emailtb.sendKeys(email);
		pwdtb.sendKeys(pwd);
		logintb.click();
		return new Home(driver);
		
	}

	public WebElement getEmailtb() {
		return emailtb;
	}

	public WebElement getPwdtb() {
		return pwdtb;
	}

	public WebElement getLogintb() {
		return logintb;
	}
	
}
