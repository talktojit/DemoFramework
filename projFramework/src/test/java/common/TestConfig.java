package common;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

public class TestConfig
{
	public static String browserEnv, driverPath;
	public static String baseDir, testConfigDir, testResourceDir, testDataDir, testResultDir;

	public static void SetTestConfig()
	{
		try
		{
			baseDir = System.getProperty("user.dir") + "\\..\\";
			testConfigDir = baseDir + "TestConfig\\";
			testResourceDir = baseDir + "TestResources\\";
			testDataDir = baseDir + "TestData\\";
			Properties testConfig = new Properties();
			testConfig.load(new FileInputStream(new File(testConfigDir + "TestConfig.properties")));
			browserEnv = testConfig.getProperty("browserName");
			driverPath = testResourceDir + testConfig.getProperty("driverPath_" + browserEnv);
			testResultDir = baseDir + "TestResults\\Run" + GetTimeStamp("yyyyMMdd_HHmmss") + "\\";
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String GetTimeStamp(String format)
	{
		String strCurrDate = "";
		try
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			strCurrDate = dateFormat.format(new Date());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return strCurrDate;
	}

}
