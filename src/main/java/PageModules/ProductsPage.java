package PageModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends CommonModule {
	private WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='card']")
	List<WebElement> products;

	By productAddedToCartImage = By.id("toast-container");
	By filter = By.xpath("(//h4[text()='Filters'])[2]");

	public WebElement getProductByName(String productName) {
		waitForElement(filter);
		WebElement product = products.stream()
				.filter(card -> card.findElement(By.xpath(".//div/h5/b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return product;

	}

	public CartPage addProductToCart(String productName) {
		WebElement element = getProductByName(productName);
		element.findElement(By.xpath(".//../following-sibling::button[2]")).click();
		waitForElement(productAddedToCartImage);
		waitForInvisibleOfAnElement(productAddedToCartImage);
		clickOnCartButton();
		return new CartPage(driver);
	}

	public boolean isProductNameAvailable(String productName) {
		WebElement productElement = getProductByName(productName);
		return productElement.getText().contains(productName);

	}

}
