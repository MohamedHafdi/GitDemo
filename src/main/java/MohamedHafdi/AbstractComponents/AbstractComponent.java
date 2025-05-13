package MohamedHafdi.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MohamedHafdi.pageobjects.Carts;
import MohamedHafdi.pageobjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement ordersButton;

	
	public Carts goToCartPage() {
		
		cartButton.click();
		Carts cart = new Carts(driver);
		return cart;
	}
	
	public OrderPage goToOrdersPage() {
		
		ordersButton.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	

	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	public void waitForElementToDisappear(WebElement element) throws InterruptedException {
		
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
	
	
}
