package PageModules;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonModule {
	private WebDriver driver;

	@FindBy(css = "button[routerlink=\"/dashboard/cart\"]")
	WebElement cartButon;
	
	@FindBy(css = "button[routerlink=\"/dashboard/myorders\"]")
	WebElement orderButon;
	
	public CommonModule(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElement(By elementBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
	}

	public void waitForInvisibleOfAnElement(By elementBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
	}

	public void clickOnCartButton() {
		cartButon.click();
	}

	public void clickOnORDERSButton() {
		orderButon.click();
	}
}
