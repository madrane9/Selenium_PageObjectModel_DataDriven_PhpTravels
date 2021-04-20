package PHP_register;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class register_testcase {
	// WebDriver here is an interface
	WebDriver yasserdriver;

	@Test(dataProvider="test_data")  // hier tragen wir den Namen unserer methode der dataProvider
	public void register_firsttestcase(String first_name, String last_name, String phone, String email, String password, String confirm ) {


		yasserdriver.findElement(By.xpath("//*[@id='dropdownCurrency']/i")).click();
		yasserdriver.findElement(By.linkText("Sign Up")).click();
		yasserdriver.findElement(By.name("firstname")).sendKeys(first_name);
		yasserdriver.findElement(By.name("lastname")).sendKeys(last_name);
		yasserdriver.findElement(By.name("phone")).sendKeys(phone);
		yasserdriver.findElement(By.name("email")).sendKeys(email);
		yasserdriver.findElement(By.name("password")).sendKeys(password);
		yasserdriver.findElement(By.name("confirmpassword")).sendKeys(confirm);
		WebElement submit_btn =  yasserdriver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[8]/button"));
		//wenn man scrollen will, man soll ein JavaScriptExecutor bauen
		//JavascriptExecutor java = (JavascriptExecutor)yasserdriver;
		//java.executeScript("scroll(0,250");
		
		submit_btn.click();
		
		//wir können hier eine ExpilicitWait aufbauen
		WebDriverWait wait = new WebDriverWait (yasserdriver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/div[1]/div[1]/div/div/div[1]/div/div[2]/h3")));
		
		String welcome_mesage = yasserdriver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div/div[1]/div/div[2]/h3")).getText();
		Assert.assertEquals(welcome_mesage, "Hi, "+first_name+" "+last_name);
		
		//Den Namen mit großen Buchstaben oben rechts clicken
		yasserdriver.findElement(By.linkText(first_name.toUpperCase())).click();
		//Logout
		yasserdriver.findElement(By.linkText("Logout")).click();

	}

	@BeforeClass
	public void open_browser() {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		// Cannot instantiate the type Webdriver, hence we have to put the reference
		// variable (Chromedriver)
		// Chromedriver is a Class which is implementing the WebDriver Interface.
		yasserdriver = new ChromeDriver();
		yasserdriver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		yasserdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		yasserdriver.get("https://phptravels.net/");
		yasserdriver.manage().window().maximize();
		
		
	}

	@AfterClass
	public void close_browser() {
		//yasserdriver.close();
		//yasserdriver.quit();

	}
	
	// @DataProvider returns multidimensionel Array
	@DataProvider
	public String[][] test_data () throws InvalidFormatException, IOException {
		//InvalidFormatException => falls diese File nicht excelsheet 
		//IOException => falls der Path der Excell sheet etwas nicht mit ihm stimmt.
		read_excel_data obj = new read_excel_data();
		return obj.read_sheet();
	}
}
