package guipages.mercury;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MercuryLoginPageFactory
{
	WebDriver driver;
	@FindBy(name="userName")
	WebElement txtUserName;
	@FindBy(name="password")
	WebElement txtPassword;
	@FindBy(name="login")
	WebElement btnSignIn;

	public MercuryLoginPageFactory(WebDriver driver)
	{
		this.driver = driver;
		//Initialize all WebElements defined in this class
		PageFactory.initElements(driver, this);
		
		//On demand WebElements initialization as per usage
		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
		//PageFactory.initElements(factory, this);
	}

	// Set user name in textbox
	private void setTxtUserName(String strUserName)
	{
		txtUserName.sendKeys(strUserName);
	}

	// Set password in password textbox
	private void setTxtPassword(String strPassword)
	{
		txtPassword.sendKeys(strPassword);
	}

	// Click on Sign-In button
	private void clickBtnSignIn()
	{
		btnSignIn.click();
	}

	//Login to Mercury page
	public void MercuryLogin(String strUserName, String strPasword)
	{
		this.setTxtUserName(strUserName);
		this.setTxtPassword(strPasword);
		this.clickBtnSignIn();
	}

}
