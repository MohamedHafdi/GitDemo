package MohamedHafdi.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MohamedHafdi.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		
		//Initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//List<WebElement> products = driver.findElements(By.xpath("//div/h5"));
	
	@FindBy(xpath="//div/h5")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement sppiner;
	
	
	By productsBy = By.xpath("//div/h5");
	By addToCart = By.xpath("following-sibling::button[contains(text(),'Add')]");
	By toastMessage = By.id("toast-container");
	
	public List<WebElement> getProducts() {
		
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		
		WebElement prod = getProducts().stream().filter(p -> p.getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(sppiner);
	}



}
