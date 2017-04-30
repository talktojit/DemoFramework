package common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestConfig
{
	public static String browserEnv, driverPath;
	public static String baseDir, testConfigDir, testResourceDir, testDataDir;

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
			
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
