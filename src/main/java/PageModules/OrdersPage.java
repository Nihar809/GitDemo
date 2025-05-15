package PageModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends CommonModule {

	public WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr[@class='ng-star-inserted']/td[2]")
	List<WebElement> orderNames;
	By yourOrders = By.xpath("//h1[text()='Your Orders']");

	public boolean verifyOrderDisplay(String productName) {
		clickOnORDERSButton();
		waitForElement(yourOrders);
		return orderNames.stream().anyMatch(orderName -> orderName.getText().equalsIgnoreCase(productName));

	}

}
