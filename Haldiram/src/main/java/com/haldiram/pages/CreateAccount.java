package com.haldiram.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.haldiram.base.BaseClass;

public class CreateAccount extends BaseClass {

	public CreateAccount(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "firstname")
	private WebElement firstName;

	@FindBy(id = "lastname")
	private WebElement lastname;

	@FindBy(id = "email_address")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "password-confirmation")
	private WebElement conformPassword;

	@FindBy(id = "action.submit.primary")
	private WebElement actionsubmitprimary;

	public CreateAccount firstName() {
		sendkeys(firstName, "Rohit");
		return this;
	}

	public CreateAccount lastName() {
		sendkeys(lastname, "Indapurkar");
		return this;
	}
	
	public CreateAccount enterEmail() {
		sendkeys(email, "Rohit@gmail.com");
		return this;
	}

	public CreateAccount enterPassword() {
		sendkeys(password, "Rohit@12345");
		return this;
	}

	public CreateAccount enterConformPassword() {
		sendkeys(conformPassword, "Rohit@12345");
		return this;
	}

	public CreateAccount clickOnButton() {
		click(actionsubmitprimary);
		return this;
	}
}