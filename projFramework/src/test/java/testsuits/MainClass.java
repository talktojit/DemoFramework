package testsuits;

import org.openqa.selenium.WebDriver;

import common.BrowserHelper;
import common.ExcelHelper;
import common.TestConfig;

public class MainClass
{
	public static void main(String[] args)
	{
		TestConfig.SetTestConfig();
		System.out.println(TestConfig.baseDir);
		System.out.println(TestConfig.testConfigDir);
		System.out.println(TestConfig.browserEnv);
		System.out.println(TestConfig.driverPath);
		WebDriver driver = null;
		driver = BrowserHelper.LaunchBrowser(driver);
		ExcelHelper objExcel = new ExcelHelper();
		objExcel.SetExcelHeader();
		objExcel.SetExcelData("TC02_Mercury_Login_Failure");
		String xlPass = objExcel.GetValue(0, "Password");
		System.out.println("Password=" + xlPass);
	}

}
