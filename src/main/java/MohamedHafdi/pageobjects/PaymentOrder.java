package MohamedHafdi.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MohamedHafdi.AbstractComponents.AbstractComponent;

public class PaymentOrder extends AbstractComponent {
	
	WebDriver driver;
	
	public PaymentOrder(WebDriver driver) {
		
		//Initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	String countryName;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(xpath="//span[contains(text(),'Morocco')]")
	WebElement selectedCountry;
	
	By taResults = By.cssSelector(".ta-results");
	
	@FindBy(css="[class*='btnn']")
	WebElement placeOrder;
	
	
	
	
	
	public void chipping(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(selectCountry, countryName).build().perform();
		waitForElementToAppear(taResults);
		a.moveToElement(selectedCountry).click().build().perform();
		
		 
	}
	
	
	public ConfirmationPage submitOrder() {
		
		placeOrder.click();
		return new ConfirmationPage(driver);
		
	}


}
