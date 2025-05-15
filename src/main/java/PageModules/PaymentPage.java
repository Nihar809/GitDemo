package PageModules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends CommonModule {
	private WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item list-group-item ng-star-inserted')])[2]")
	WebElement countryOption;

	@FindBy(xpath = "//h1[text()=' Thankyou for the order. ']")
	WebElement thankYouOrder;

	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement placeOrderButton;

	By placeOrder = By.xpath("//h1[text()=' Thankyou for the order. ']");

	@FindBy(xpath = "//h1[text()=' Thankyou for the order. ']")
	WebElement orderText;

	public String selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		a.moveToElement(countryOption).keyDown(Keys.ARROW_DOWN).click().build().perform();
		placeOrderButton.click();
		waitForElement(placeOrder);
		return orderText.getText();
	}

}
