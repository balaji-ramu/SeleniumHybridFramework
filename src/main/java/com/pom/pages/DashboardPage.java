package com.pom.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	
private WebDriver driver;
private By dashboardMenu = By.cssSelector("span[class*='main-menu-item']");


public DashboardPage(WebDriver driver)
{
	this.driver = driver;
}

public String getDashboardPageTitle()
{
	return driver.getTitle();
	
}

public int getDashboardSize()
{
	return driver.findElements(dashboardMenu).size();
}


public List<String> getDashboardList()
{
	List<String> menuList = new ArrayList<>();
	List<WebElement> menu = driver.findElements(dashboardMenu);
	for(WebElement e : menu )
	{
		String text = e.getText();
		
		menuList.add(text);
	}
	
	return menuList;
	
	
}

	
	

}
