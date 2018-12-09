package com.syntax.cucumber.test.stepdefination;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep {
	WebDriver driver;
	
	@Given("^I open browser$")
	public void i_open_browser() throws Throwable {
		System.setProperty("Webdriver.chrome.drievr", "./src/test/resources/Drivers/chromedriver");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}

	@Given("^I navigate to the FreeCrm$")
	public void i_navigate_to_the_freeCrm() throws Throwable {
		driver.get("https://www.freecrm.com/index.html?e=1");
	}

	@When("^I enter username and password$")
	public void i_enter_udername_nad_password() throws Throwable {
		driver.findElement(By.name("username")).sendKeys("TananzNazar");
		driver.findElement(By.name("password")).sendKeys("Password12345@");
		Thread.sleep(4000);
	}

	@When("^I click login button$")
	public void i_click_login_button() throws Throwable {
		
		
		WebElement loginclick=driver.findElement(By.xpath("//input[@value='Login']"));
		Actions action = new  Actions(driver);
		action.moveToElement(loginclick).click();
		
		
		
	}

	@Then("^I succesfully logged in$")
	public void i_succesfully_logged_in() throws Throwable {
		
		String title="CRMPRO";
		driver.getTitle();
		assertEquals("CRMPRO", title);
		driver.quit();

	}
	@When("^I enter invalid username and password$")
	public void i_enter_invalid_username_and_password() throws Throwable {
		driver.findElement(By.name("username")).sendKeys("Sam seyed");
		driver.findElement(By.name("password")).sendKeys("pass123@");
	}

	@Then("^I see error msg$")
	public void i_see_error_msg() throws Throwable {
		WebElement logo = driver.findElement(By.xpath("//img[contains(@class,'img-responsive')][1]"));
		boolean verifyLogo=logo.isDisplayed();
		Assert.assertTrue(verifyLogo);
		driver.quit();
	}
}
