package MohamedHafdi.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MohamedHafdi.TestComponents.BaseTest;
import MohamedHafdi.TestComponents.Retry;
import MohamedHafdi.pageobjects.Carts;
import MohamedHafdi.pageobjects.ConfirmationPage;
import MohamedHafdi.pageobjects.LandingPage;
import MohamedHafdi.pageobjects.PaymentOrder;
import MohamedHafdi.pageobjects.ProductCatalogue;

//@Listeners(MohamedHafdi.TestComponents.Listeners.class)
public class ErrorValidation extends BaseTest {

		@Test(groups= {"ErrorHandling", "Automation"})
		public void logingErrorValidation() throws IOException, InterruptedException {
			
		
		landingPage.LogingApplication("mohamed1234@gmail.com", "Mohamed1234");
		System.out.println(landingPage.getErrorMessage());
		//Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email  password.");
		Assert.assertFalse(landingPage.getErrorMessage().equalsIgnoreCase("Incorrect email or password."));

		}
		 
//		@Test
//		public void productErrorValidation() throws IOException, InterruptedException {
//			
//		String produtWanted = "adidas original";
//		String country = "Mor";
//		
//		ProductCatalogue productCatalogue = landingPage.LogingApplication("miguel1234@gmail.com", "Miguel1234");
//		List<WebElement> products = productCatalogue.getProducts();
//		productCatalogue.addProductToCart(produtWanted);
//		Carts cart = productCatalogue.goToCartPage();
//		Assert.assertTrue(cart.cartProductCheck("adidas"));
//	
//
//		}
}
