package com.qa.test;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.haldiram.base.BaseClass;
import com.haldiram.pages.CreateAccount;
import com.haldiram.pages.CustAccount;
import com.haldiram.pages.Home;

public class CreateAccountTest extends BaseClass {
	public static WebDriver driver;
	public static Home home;
	public static CustAccount custAccount;
	public static CreateAccount createAccount;

	@BeforeMethod
	public void beforeMethod(Method m) throws Exception {

		driver = setUp();
		System.out.println("******* starting Test" + m.getName() + " *******");
	}

	@Test
	public void createAccount() {
		home = new Home(driver);
		createAccount = new CreateAccount(driver);
		custAccount = new CustAccount(driver);

		home.clickOnCustomerAccount();
		custAccount.clickOnCreateAccount();
		createAccount.firstName();
		createAccount.lastName();
		createAccount.enterEmail();
		createAccount.enterPassword();
		createAccount.enterConformPassword();

	}

	@AfterMethod
	public void aftermethod() {
		tearDown();
	}
}