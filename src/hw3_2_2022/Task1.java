package hw3_2_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.navigate().to("https://www.google.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement e = driver.findElement(By.tagName("body"));


			js.executeScript("arguments[0].setAttribute('style', 'background: black');", e);

	}

}

//Napisati program koji:
//Ucitava stranicu https://www.google.com/
//Hvata body element sa stranicu i njemu setuje atribut 
//style na vrednost “background: nekaBoja”
//Skripta: arguments[0].style=”background: black”;

