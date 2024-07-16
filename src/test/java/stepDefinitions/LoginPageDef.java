package stepDefinitions;

import org.junit.Assert;

import com.driver.factory.DriverFactory;
import com.pom.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageDef
{
	private static String pageTitle;
	private LoginPage loginPage= new LoginPage(DriverFactory.driver());
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		DriverFactory.driver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		
		pageTitle = loginPage.getLoginPageTitle();
		System.out.println("Page title is"+" "+pageTitle);
	   
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String actualPageTitle) {
		
		
		
		Assert.assertTrue(pageTitle.contains(actualPageTitle));
	   
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		
		Assert.assertTrue(loginPage.isForgotPassLinkExist());
	   
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		
		loginPage.enterUserName(username);
	   
	}

	@When("user enters password {string}")
	public void user_enters_password(String userPass) {
		loginPage.enterPassword(userPass);
	   
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLogin();
	    
	}

	
	
	

}
