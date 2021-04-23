package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Base_page{

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Hier werden die Webelements eingetragen
	private By first_name=By.name("firstname");
	private By last_name=By.name("lastname");
	private By phone_number= By.name("phone");
	private By email= By.name("email");
	private By password =By.name("password");
	private By confirm_password =By.name("confirmpassword");
	private By submit_bttn = By.xpath("//*[@id=\"headersignupform\"]/div[8]/button");
	
	
	//Hier werden deren Interaktion eingetragen
	public void insert_first_name(String fname) {
		wait_elements(base_page_driver, 20, first_name);
		base_page_driver.findElement(first_name).clear();
		base_page_driver.findElement(first_name).sendKeys(fname);
	}
	
	
	public void insert_last_name(String lname) {
		wait_elements(base_page_driver, 20, last_name);
		base_page_driver.findElement(last_name).clear();
		base_page_driver.findElement(last_name).sendKeys(lname);
	}
	
	public void insert_phone_number(String phonnr) {
		wait_elements(base_page_driver, 20, phone_number);
		base_page_driver.findElement(phone_number).clear();
		base_page_driver.findElement(phone_number).sendKeys(phonnr);
	}
	
	public void insert_email(String eml) {
		wait_elements(base_page_driver, 20, email);
		base_page_driver.findElement(email).clear();
		base_page_driver.findElement(email).sendKeys(eml);
	}
	
	public void insert_password(String passw) {
		wait_elements(base_page_driver, 20, password);
		base_page_driver.findElement(password).clear();
		base_page_driver.findElement(password).sendKeys(passw);
	}
	
	
	public void confirm_password(String confpassw) {
		base_page_driver.findElement(confirm_password).clear();
		base_page_driver.findElement(confirm_password).sendKeys(confpassw);
	}
	
	public void click_on_submit_bttn() {
		wait_elements(base_page_driver, 20, submit_bttn);
		base_page_driver.findElement(submit_bttn).click();
	}
	
}
