package com.sample.pom;

import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}
	
	/**
	 * this method will login
	 * @author {darshandevanikar}
	 */
	public void login() {
		System.out.println("Login function called...");
		driver.get("https://google.com");
	}
}
