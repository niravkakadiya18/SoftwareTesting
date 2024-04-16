import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		
		//Invoking Browser
		//Chrome - ChromeDriver ->Methods close get
		//Firefox - FirefoxDriver ->Methods close get
		//safari - safariDeiver ->Methods close get
		//WebDriver - close get
		//WebDriver Methods + class Methods
		
		//step to invoke chrome driver
		//Selenium Manager
		//chromedriver.exe -> Chrome Browser
	
		
		//System.setProperty("webdriver.chrome.driver","/Users/kakad.chromedriver.exe");
		
        //webdriver.chrome.driver->value of path
		//WebDriver driver = new ChromeDriver();
		
		//Firefox launch
		//System.setProperty("webdriver.gecko.driver","/Users/kakad.geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		  System.setProperty("webdriver.edge.driver", "C:\\Users\\kakad\\msedgedriver.exe");
	      WebDriver driver = new EdgeDriver();

		
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.close();
		//driver.quit();
	}

}
