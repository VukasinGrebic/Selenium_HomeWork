package hw7_2_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NavigationPage {
	private WebDriver driver;

	public NavigationPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public WebElement getCartButton() {
		return driver.findElement(By.xpath("//*[@class=' nav-menu']//li"));
	}
	
	public WebElement getCheckoutButton() {
		return driver.findElement(By.xpath("//*[@class=' nav-menu']//li[2]"));
	}
	
	
	public WebElement getMyAccButton() {
		return driver.findElement(By.xpath("//*[@class=' nav-menu']//li[3]"));
	}
	
	public WebElement getSamplePageButton() {
		return driver.findElement(By.xpath("//*[@class=' nav-menu']//li[4]"));
	}
	
	public WebElement getShopButton() {
		return driver.findElement(By.xpath("//*[@class=' nav-menu']//li[5]"));
	}

}
