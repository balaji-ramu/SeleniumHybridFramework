package com.selenium.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/DashboardPage.feature"},
		glue = {"stepDefinitions", "hooks"},
		plugin = {"pretty"
				
		}
		
		)


public class MyTestRunner {

}
