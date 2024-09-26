package com.haldiram.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.haldiram.base.BaseClass;

public class Home extends BaseClass {

	public Home(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(css = "li.authorization-link")
	private WebElement custAccount;

	public Home clickOnCustomerAccount() {
		click(custAccount);
		System.out.println("clicked on customer Account");
		return this;
	}
}
