package PageModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonModule {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(css = "input[id=login]")
	WebElement login;

	@FindBy(css = ".ngx-toastr")
	WebElement errorMessage;

	By byErrorMessage = By.cssSelector(".ngx-toastr");

	public void goToUrl(String url) {
		driver.get(url);
	}

	public ProductsPage login(String email, String pass) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(pass);
		login.click();
		return new ProductsPage(driver);
	}

	public String getErrorMessage() {
		waitForElement(byErrorMessage);
		return errorMessage.getText();
	}

}
