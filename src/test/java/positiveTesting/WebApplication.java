package positiveTesting;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageModules.Base;
import PageModules.CartPage;
import PageModules.OrdersPage;
import PageModules.PaymentPage;
import PageModules.ProductsPage;

public class WebApplication extends Base {
//	String productName = "IPHONE 13 PRO";
	String countryName = "ind";

	ProductsPage product;
	CartPage cart;
	PaymentPage payment;
	String orderStatus;

	@Test(dataProvider = "getData", groups = { "purchase" })
	public void runWebApplication(HashMap<String, String> input) throws IOException {
		product = login.login(input.get("email"), input.get("password"));
		cart = product.addProductToCart(input.get("productName"));
		payment = cart.clickOnBuyNow(input.get("productName"));
		orderStatus = payment.selectCountry(countryName);
		System.out.println(orderStatus);
		Assert.assertEquals(orderStatus, "THANKYOU FOR THE ORDER.");

	}

	@Test(dependsOnMethods = { "runWebApplication" }, dataProvider = "getData", groups = { "purchase" })
	public void orderHistoryTest(HashMap<String, String> input) {
		product = login.login(input.get("email"), input.get("password"));
		OrdersPage order = new OrdersPage(driver);
		Assert.assertTrue(order.verifyOrderDisplay(input.get("productName")));
	}

	@DataProvider
	public Object getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\readData\\purchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

	public String getScreenshot(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reoprts//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reoprts//" + testCaseName + ".png";
	}

//	@DataProvider
//	public Object getData() {
//
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "kt@gmail.com");
//		map.put("password", "Dummy@12345");
//		map.put("productName", "IPHONE 13 PRO");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "anshika@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("productName", "ADIDAS ORIGINAL");
//
//		return new Object[][] { { map }, { map1 } };
//	}

//	@DataProvider
//	public Object getData1() {
//		return new Object[][] { { "kt@gmail.com", "Dummy@12345", "IPHONE 13 PRO" },
//				{ "anshika@gmail.com", "Iamking@000", "ADIDAS ORIGINAL" } };
//
//	}

}
