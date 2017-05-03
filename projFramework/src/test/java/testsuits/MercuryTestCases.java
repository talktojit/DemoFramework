package testsuits;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.BrowserHelper;
import common.ExcelHelper;
import common.TestConfig;
import guipages.mercury.MercuryLoginPage;
import guipages.mercury.MercuryLoginPageFactory;

public class MercuryTestCases
{
	ExcelHelper objExcel;
	WebDriver driver = null;
	MercuryLoginPage objMercuryLogin;
	MercuryLoginPageFactory objMercuryLoginFactory;
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("@BeforeTest");
		TestConfig.SetTestConfig();
		objExcel = new ExcelHelper();
		objExcel.SetExcelHeader();
	}

	@AfterTest
	public void afterTest()
	{
		System.out.println("@AfterTest");
		if(!(driver==null))
			driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("@BeforeMethod");
	}

	@AfterMethod
	public void afterMethod()
	{
		System.out.println("@AfterMethod");
		objExcel.ClearExcelData();
	}
	
	@Test
	public void TC01_Mercury_Login_Success()
	{
		try
		{
			String tcName = "TC01_Mercury_Login_Success";
			System.out.println("@Test=" + tcName);
			objExcel.SetExcelData(tcName);
			String xlUserName = objExcel.GetValue(0, "UserName");
			String xlPassword = objExcel.GetValue(0, "Password");
			String xlTitle = objExcel.GetValue(0, "ExpTitle");
			
			driver = BrowserHelper.LaunchBrowser(driver);
			driver.get("http://newtours.demoaut.com/");
			
			objMercuryLogin = new MercuryLoginPage(driver);
			objMercuryLogin.MercuryLogin(xlUserName, xlPassword);
			BrowserHelper.SaveDriverScreenshot(driver,tcName);
			Assert.assertEquals(driver.getTitle(), xlTitle);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void TC02_Mercury_Login_Failure_Factory()
	{
		try
		{
			String tcName = "TC02_Mercury_Login_Failure";
			System.out.println("@Test=" + tcName);
			objExcel.SetExcelData(tcName);
			String xlUserName = objExcel.GetValue(0, "UserName");
			String xlPassword = objExcel.GetValue(0, "Password");
			String xlTitle = objExcel.GetValue(0, "ExpTitle");
			
			driver = BrowserHelper.LaunchBrowser(driver);
			driver.get("http://newtours.demoaut.com/");
			
			objMercuryLoginFactory = new MercuryLoginPageFactory(driver);
			objMercuryLoginFactory.MercuryLogin(xlUserName, xlPassword);
			BrowserHelper.SaveDriverScreenshot(driver,tcName);
			Assert.assertEquals(driver.getTitle(), xlTitle);
			objExcel.ClearExcelData();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}
