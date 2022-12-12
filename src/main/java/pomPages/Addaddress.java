package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addaddress {
		@FindBy(id="outlined-size-small")
		private WebElement nametb;
		
		@FindBy(id="outlined-size-small")
		private WebElement housetb;
		
		@FindBy(id="outlined-size-small")
		private WebElement streettb;
		
		@FindBy(id="outlined-size-small")
		private WebElement landmarktb;
		
		@FindBy(xpath="//option[text()='Country']")
		private WebElement countrydd;
		
		@FindBy(xpath="//option[text()='State']")
		private WebElement statedd;
		
		@FindBy(xpath="//option[text()='City']")
		private WebElement citydd;
		
		@FindBy(id="outlined-adornment-pincode")
		private WebElement pincodetb;
		
		@FindBy(id="outlined-size-small")
		private WebElement phonenotb;

		public Addaddress(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		public void addaddress(String name,String house, String street, String landmark) {
			nametb.sendKeys(name);
			housetb.sendKeys(house);
			streettb.sendKeys(street);
			landmarktb.sendKeys(landmark);
		}
		
		public void code(String pin, String number) {
			pincodetb.sendKeys(pin);
			phonenotb.sendKeys(number);
		}
}


