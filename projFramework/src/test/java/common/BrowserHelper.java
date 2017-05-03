package common;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserHelper
{
	public static WebDriver LaunchBrowser(WebDriver driver)
	{
		try
		{
			if (driver == null)
			{
				switch (TestConfig.browserEnv)
				{
				case "firefox32":
					System.setProperty("webdriver.gecko.driver", TestConfig.driverPath);
					driver = new FirefoxDriver();
					break;
				case "firefox64":
					System.setProperty("webdriver.gecko.driver", TestConfig.driverPath);
					driver = new FirefoxDriver();
					break;
				case "chrome32":
					System.setProperty("webdriver.chrome.driver", TestConfig.driverPath);
					driver = new ChromeDriver();
					break;
				case "internetExplorer32":
					System.setProperty("webdriver.ie.driver", TestConfig.driverPath);
					driver = new InternetExplorerDriver();
					break;
				case "internetExplorer64":
					System.setProperty("webdriver.ie.driver", TestConfig.driverPath);
					driver = new InternetExplorerDriver();
					break;
				default:
					System.setProperty("webdriver.gecko.driver", TestConfig.driverPath);
					driver = new FirefoxDriver();
					break;
				}
			}
			else
			{
				System.out.println("Driver already launched");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (!(driver == null))
			driver.manage().window().maximize();
		return driver;
	}
	
	public static void SaveDriverScreenshot(WebDriver driver, String tcName)
	{
		try
		{
			File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String dirName = TestConfig.testResultDir + tcName;
			String fileName = dirName + "\\" + TestConfig.GetTimeStamp("yyyyMMddHHmmssSSS") + ".png";
			Files.createDirectories(Paths.get(dirName));
			FileUtils.copyFile(ss, new File(fileName));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
