package hw3_2_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.navigate().to("https://www.wikipedia.org/");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			JavascriptExecutor js = (JavascriptExecutor) driver;

			List<WebElement> languages = driver.findElements(By.xpath("//body/div/div/a"));

			for (int i = 0; i < languages.size(); i++) {
				languages = driver.findElements(By.xpath("//body/div/div/a"));
				js.executeScript("window.open(arguments[0]);", languages.get(i));
			}
			

	}

}

//Napisati program koji:
//Ucitava stanicu https://www.wikipedia.org/
//Sa stranice sakuplja sve linkove (jezike) i svaki link otvara u novom prozoru pretrazivaca
//Svaki link potrebno je otvoriti u novom tabu.
//Skripta: window.open(arguments[0]);


