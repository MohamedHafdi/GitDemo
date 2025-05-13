package MohamedHafdi.Tests;

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

import MohamedHafdi.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String produtWanted = "adidas original";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		LandingPage landingPage = new LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("miguel1234@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Miguel1234");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/h5")));
		List<WebElement> products = driver.findElements(By.xpath("//div/h5"));
		
		List<String> productsName = products.stream().map(s-> s.getText()).toList();
		System.out.println(productsName);
		WebElement product = products.stream().filter(p -> p.getText().equalsIgnoreCase(produtWanted)).findFirst().orElse(null);
		product.findElement(By.xpath("following-sibling::button[contains(text(),'Add')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		//.ng-animating
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3")); 
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(produtWanted));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "Morocco").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Mor')]"))).click().build().perform();		
		driver.findElement(By.cssSelector("[class*='btnn']")).click();
		String confirmMessage = driver.findElement(By.cssSelector("h1")).getText();
		System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.quit();
		
	

	}
}
