import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KodProjectDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		driver.manage().window().maximize();
//		driver.close();
		//driver.findElement(By.name("q")).sendKeys("Kodnest");
		//WebElement link = driver.findElement(By.linkText("onlytestingblog"));
		//link.click();
		//Thread.sleep(5000);
		//driver.findElement(By.id("textbox1")).clear();
		//String text = driver.findElement(By.id("pah")).getText();
		//System.out.println(text);
		//String title = driver.getTitle();
		//System.out.println(title);
		//String url = driver.getCurrentUrl();
		//System.out.println(url);
		driver.findElement(By.partialLinkText("jqueryui")).click();
		
		
	}

}
