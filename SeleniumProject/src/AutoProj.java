import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoProj {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demowebshop.tricentis.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		// # REGISTER-button
		driver.get("https://demowebshop.tricentis.com/register");
		driver.findElement(By.id("gender-male")).click();

		driver.findElement(By.id("FirstName")).sendKeys("mehul");

		driver.findElement(By.id("LastName")).sendKeys("vaghasiya");

		driver.findElement(By.id("Email")).sendKeys("kodtest1@gmail.com");

		driver.findElement(By.id("Password")).sendKeys("test123");

		driver.findElement(By.id("ConfirmPassword")).sendKeys("test123");
//		driver.findElement(By.id("register-button")).click();

		WebElement registerButton = driver.findElement(By.id("register-button"));
		if (registerButton.isEnabled()) {
			System.out.println("Register button is enabled.");
		} else {
			System.out.println("Register button is disabled.");
		}

		
		
		// # LOGIN-button
		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.id("Email")).sendKeys("kodtest1@gmail.com");

		driver.findElement(By.id("Password")).sendKeys("test1234");

		driver.findElement(By.id("RememberMe")).click();

		driver.findElement(By.xpath("//input[@value='Log in']")).click();

		
		
		// # addProductToCart
		driver.get("https://demowebshop.tricentis.com/books");
		driver.findElement(By.xpath("//img[@alt='Picture of Health Book']"));
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
//		 Thread.sleep(2000); 

		
		
		// # checkoutAndConfirmOrder
		driver.get("https://demowebshop.tricentis.com/cart");

		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("BillingNewAddress.FirstName")))
				.sendKeys("ankit");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("BillingNewAddress.LastName")))
				.sendKeys("savaliya");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("BillingNewAddress.Email")))
				.sendKeys("kodtest1@gmail.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("BillingNewAddress.CountryId")))
				.sendKeys("india");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("BillingNewAddress.City"))).sendKeys("surat");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("BillingNewAddress.Address1")))
				.sendKeys("motavarachha");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("BillingNewAddress.ZipPostalCode")))
				.sendKeys("520012");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("BillingNewAddress.FaxNumber")))
				.sendKeys("563201235");

//	     driver.findElement(By.xpath("//input[@value='Continue']")).click();

		// Check if "Continue" button is visible
		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		if (continueButton.isDisplayed()) {
			continueButton.click();
		} else {
			System.out.println("Continue button not found or not visible!");
		}

		// Select shipping method
		driver.findElement(By.id("shippingoption_1")).click();

		// Select payment method
		driver.findElement(By.id("paymentmethod_1")).click();

		// Confirm order
		driver.findElement(By.xpath("//input[@value='Confirm Order']")).click();

		driver.findElement(By.id("PickUpInStore")).click();
		driver.findElement(By.xpath("//input[@class='button-1 new-address-next-step-button']")).click();

		driver.findElement(By.id("paymentmethod_0")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']")).click();

		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		driver.quit();

	}

}
