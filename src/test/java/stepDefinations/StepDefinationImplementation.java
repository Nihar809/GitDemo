package stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import PageModules.Base;
import PageModules.LoginPage;
import PageModules.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinationImplementation extends Base {
	public LoginPage login;
	public ProductsPage product;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {

		login = openUrl();

	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String userName, String password) {
		product = login.login(userName, password);
	}

	@When("^I add product (.+) to cart$")
	public void i_add_product_to_cart() {
		List<WebElement> products;
	}

}
