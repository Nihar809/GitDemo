package PageModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonModule {
	private WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"infoWrap\"]")
	List<WebElement> cartlists;

	public WebElement selectCart(String productName) {
		WebElement element = cartlists.stream()
				.filter(cart -> cart.findElement(By.tagName("h3")).getText().equals(productName)).findFirst()
				.orElse(null);
		return element;
	}

	public PaymentPage clickOnBuyNow(String productName) {
		WebElement element = selectCart(productName);
		element.findElement(By.xpath(".//div[3]/button[1]")).click();
		return new PaymentPage(driver);
	}

	public boolean isProductNameAvailableInCart(String productName) {
		WebElement element = selectCart(productName);
		return element.getText().contains(productName);
	}

}
