package ui.login;

import org.testng.annotations.Test;
import com.sample.base.BaseTest;
import com.sample.pom.LoginPage;

public class logintests extends BaseTest {

	/**
	 * This method is created for checking login functionality
	 * @author {darshandevanikar}
	 */
	@Test
	public void TC0001_login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
	}

}
