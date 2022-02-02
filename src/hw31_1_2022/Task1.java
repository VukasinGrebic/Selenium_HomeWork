package hw31_1_2022;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Task1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://s.bootsnipp.com/iframe/Dq2X");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		List <WebElement> windows= driver.findElements(By.className("close"));

		for (int i = 0; i < windows.size(); i++) {
			windows.get(i).click();
			try {
				windows.get(i).click();

			} catch (Exception e) {
				System.out.println("Closed");
			}
		}

	}

}

//Napisati program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI KORISCENJEM PETLJE)
//POMOC: Brisite elemente odozdo.
//(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
