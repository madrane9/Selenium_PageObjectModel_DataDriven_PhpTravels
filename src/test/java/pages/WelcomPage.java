package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomPage extends Base_page{

	public WelcomPage(WebDriver driver) {
		super(driver);
	}
	
	private By logout_link= By.linkText("Logout");
	private By welcome_mesage= By.xpath("/html/body/div/div[1]/div[1]/div/div/div[1]/div/div[2]/h3");
	
	//Hier werden deren Interaktion eingetragen
		public void logout_from_myaccount(String name) {
			
			base_page_driver.findElement(By.linkText(name.toUpperCase())).click();  //Den Namen mit großen Buchstaben oben rechts clicken
			base_page_driver.findElement(logout_link).click();
		}
		//function wait_elements generic can we apply for all
	public String expected_result() {
		wait_elements(base_page_driver, 50,welcome_mesage);
		return base_page_driver.findElement(welcome_mesage).getText();
	}
	
}
