package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTesr {

	public static void main(String[] args) throws InterruptedException {
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo(); 
		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage =	productCatalogue.goToCartPage();
		CartPage cartPage1 = new	CartPage(driver);
		Boolean match = cartPage1.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkoutPage = cartPage1.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage =  checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();

		
		
	}

}
