package hw7_2_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public ProductPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		
	}
	
	public WebElement getProduct(int index) {
		return driver.findElement(By.xpath("//*[@class='products columns-3']/li[" + index + "]/a"));
	}
	
	public WebElement getAddCartButton () {
		return driver.findElement(By.name("add-to-cart"));
	}
	
	public WebElement getNumber () {
		return driver.findElement(By.className("input-text qty text"));
	}
	
	public void waitForMessage() {
		wait.until(
				ExpectedConditions
				.numberOfElementsToBe(By.xpath("//*[@class='woocommerce-message']"), 1));
	}
	
	public WebElement getViewCart () {
		return driver.findElement(By.xpath("//*[@class='woocommerce-message']/a"));
		
	}
	
	public boolean enoughProducts () {
		try {
			driver.findElement(By.xpath("//*[@value='2']"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public WebElement getRemoveButton () {
		return driver.findElement(By.className("remove"));
	}
	
	public boolean isDeleted () {
		try {
			driver.findElement(By.className("cart-empty woocommerce-info"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
