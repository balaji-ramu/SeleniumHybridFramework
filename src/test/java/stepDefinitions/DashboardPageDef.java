package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.driver.factory.DriverFactory;
import com.pom.pages.DashboardPage;
import com.pom.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DashboardPageDef {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.driver());
	private DashboardPage dashboardPage;
	
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credentials) {
		
		List<Map<String, String>> credList = credentials.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.driver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		dashboardPage = loginPage.login(userName, password);	
	    
		
	}

	@Given("user is on Dashboard page")
	public void user_is_on_dashboard_page() {
		
		String title = dashboardPage.getDashboardPageTitle();
		System.out.println("Page title is: " + title);
	  
	}

	@Then("user views hamburger menu options")
	public void user_views_hamburger_menu_options(DataTable dataTable) {
		
		List<String> expectedMenuList = dataTable.asList();
		System.out.println("Expected menu is"+" "+expectedMenuList);
		
		List<String> actualMenuList = dashboardPage.getDashboardList();
		System.out.println("Actual menu is"+" "+actualMenuList);
		
		Assert.assertTrue(expectedMenuList.containsAll(actualMenuList));
		
		
	   
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer listCount) {
		
		Assert.assertTrue(dashboardPage.getDashboardSize()==listCount);
	   
		
	}

}
