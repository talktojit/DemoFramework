package guipages.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MercuryLoginPage
{
	WebDriver driver;

	By byTxtUserName = By.name("userName");
	By byTxtPassword = By.name("password");
	By byBtnSignIn = By.name("login");

	public MercuryLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	// Set user name in textbox
	private void setTxtUserName(String strUserName)
	{
		driver.findElement(byTxtUserName).sendKeys(strUserName);
	}

	// Set password in password textbox
	private void setTxtPassword(String strPassword)
	{
		driver.findElement(byTxtPassword).sendKeys(strPassword);
	}

	// Click on Sign-In button
	private void clickBtnSignIn()
	{
		driver.findElement(byBtnSignIn).click();
	}

	//Login to Mercury page
	public void MercuryLogin(String strUserName, String strPasword)
	{
		this.setTxtUserName(strUserName);
		this.setTxtPassword(strPasword);
		this.clickBtnSignIn();
	}

}
