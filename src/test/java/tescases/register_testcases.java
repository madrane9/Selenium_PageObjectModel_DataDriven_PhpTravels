package tescases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;
import pages.WelcomPage;

public class register_testcases extends Base_Test {
	//hier definieren wir ein Object für jeden Class der Pages, damit ich deren funktionen benutzen kann. 
	// das nennt man Page Object Model = d.h ich erstelle pages danach definiere ich objecte von diesen Pages.
	HomePage hp;
	RegisterPage rp;
	WelcomPage wp;
	
	@Test(dataProvider="test_data")  // hier tragen wir den Namen unserer methode der dataProvider
		public void register_firsttestcase(String first_name, String last_name, String phone, String email, String password, String confirm ) {
		hp=new HomePage(base_test_driver);
		hp.click_on_myaccount_link();
		hp.click_on_signup_link();
		rp=new RegisterPage(base_test_driver);
		rp.insert_first_name(first_name);
		rp.insert_last_name(last_name);
		rp.insert_phone_number(phone);
		rp.insert_email(email);
		rp.insert_password(password);
		rp.confirm_password(password);
		rp.scroll_down(base_test_driver);
		rp.click_on_submit_bttn();
		wp=new WelcomPage(base_test_driver);
		Assert.assertEquals(wp.expected_result(), "Hi, "+first_name+ " "+ last_name);
		wp.logout_from_myaccount(first_name);
		
		
  }
}
