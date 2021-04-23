package tescases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.read_excel_data;

public class Base_Test {

	WebDriver base_test_driver;

	@BeforeClass
	@Parameters({ "browser" }) // <<== Hier wird gesagt, dass Parameter im testng.xml eingelegt wurde.
	public void open_browser(String browser) {
		// Alte Methode für ChromePath
		// System.setProperty("webdriver.chrome.driver",
		// ".\\drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup(); // Neue Methode mit hilfe von WebDriverManager
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			// Cannot instantiate the type Webdriver, hence we have to put the reference
			// variable (Chromedriver)
			// Chromedriver is a Class which is implementing the WebDriver Interface.
			base_test_driver = new ChromeDriver();
			base_test_driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			base_test_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			base_test_driver.get("https://phptravels.net/");
			base_test_driver.manage().window().maximize();
		}
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\chromedriver.exe");
			base_test_driver = new ChromeDriver();
			base_test_driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			base_test_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			base_test_driver.get("https://phptravels.net/");
			base_test_driver.manage().window().maximize();
		}
	}

	@AfterClass
	public void close_browser() {
		// yasserdriver.close();
		// yasserdriver.quit();

	}

	// @DataProvider returns multidimensionel Array
	@DataProvider
	public String[][] test_data() throws InvalidFormatException, IOException {
		// InvalidFormatException => falls diese File nicht excelsheet
		// IOException => falls der Path der Excell sheet etwas nicht mit ihm stimmt.
		read_excel_data obj = new read_excel_data();
		return obj.read_sheet();
	}
}
