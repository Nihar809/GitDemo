package negativeTesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageModules.Base;
import PageModules.CartPage;
import PageModules.ProductsPage;

public class ErrorValidations extends Base {
	ProductsPage product;
	CartPage cart;
	String productName = "IPHONE 13 PRO";

	@Test(groups = {"ErorHandling"})
	public void loginErrorValidation() throws InterruptedException {

		login.login("kt@gmail.com", "Dummy@1245");
		Assert.assertEquals(login.getErrorMessage(), "Incorrect email or password.");
//		Thread.sleep(2000);
	}

	@Test
	public void productErrorValidation() throws IOException {
		product = login.login("kt@gmail.com", "Dummy@12345");
		Assert.assertTrue(product.isProductNameAvailable(productName));

	}

	@Test
	public void productInCartErrorValidation() {
		product = login.login("kt@gmail.com", "Dummy@12345");
		cart = product.addProductToCart(productName);
		Assert.assertTrue(cart.isProductNameAvailableInCart(productName));
	}

}
