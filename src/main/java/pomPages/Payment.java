package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {
 @FindBy(name="radio-buttons-group")
 private WebElement paybtn;
 
 public Payment(WebDriver driver) {
	 PageFactory.initElements(driver,this);
 }
}
