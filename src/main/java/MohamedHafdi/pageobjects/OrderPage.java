package MohamedHafdi.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import MohamedHafdi.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		
		//Initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> products;
	
	
	
	public Boolean verifyOrderProduct(String productName) {
		
		System.out.println("the product name: " +productName);
		Boolean match = products.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	


}
