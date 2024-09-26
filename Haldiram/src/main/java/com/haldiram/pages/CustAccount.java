package com.haldiram.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.haldiram.base.BaseClass;

public class CustAccount extends BaseClass {

	public CustAccount(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
 
	@FindBy(css = "a.action.create.primary")
	private WebElement createAccount;

	public CustAccount clickOnCreateAccount() {
		click(createAccount);
		return this;
	}
}