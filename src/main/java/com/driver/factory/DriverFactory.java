package com.driver.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser)
	
	{
	
	System.out.println("Browser is:"+ browser);
	
	if(browser.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		tlDriver.set(new ChromeDriver());
	}
	
	else if(browser.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		tlDriver.set(new FirefoxDriver());
	}
	
	driver().manage().deleteAllCookies();
	driver().manage().window().maximize();
	driver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	return driver();
	
	}
	public static synchronized WebDriver driver()
	{
		return tlDriver.get();
	}
	
	
	}

