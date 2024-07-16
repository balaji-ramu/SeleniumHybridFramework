package com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By userName = By.cssSelector("input[name='username']");
	private By password = By.cssSelector("input[name='password']");
	private By signInButton = By.cssSelector("button[type='submit']");
	private By forgotPwdLink = By.cssSelector("p[class$='forgot-header']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getLoginPageTitle()

	{
		return driver.getTitle();
	}
	
	public boolean isForgotPassLinkExist()
	{
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username)
	{
		driver.findElement(userName).sendKeys(username);
	}
	
	public void enterPassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLogin()
	{
		driver.findElement(signInButton).click();
	}
	
	public DashboardPage login(String uname, String upass)
	{
		driver.findElement(userName).sendKeys(uname);
		driver.findElement(password).sendKeys(upass);
		driver.findElement(signInButton).click();
		return new DashboardPage(driver);
	}

}
