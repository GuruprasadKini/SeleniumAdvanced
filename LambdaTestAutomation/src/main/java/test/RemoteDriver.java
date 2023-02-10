package test;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriver {
	String username = "guruprasadpkini";
	String accesskey = "fWmEYaZiEgBhZAs0swEPvZtHBU2dTN9mBZJDR3H8cf83btpVf5";
	RemoteWebDriver driver = null;
	String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;
	public void testCase1(String platform, String browser, String browserVersion) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if(browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		}
		else if(browser.equals("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			capabilities.setCapability(EdgeOptions.CAPABILITY, options);
		}
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("version", browserVersion);
		capabilities.setCapability("platform", platform); // If this cap isn't specified, it will just get any available one.
		capabilities.setCapability("build", "LambdaTestSampleApp");
		capabilities.setCapability("name", "LambdaTestJavaSample");
		capabilities.setCapability("network", true);// To enable network logs
		capabilities.setCapability("visual", true);// To enable step by step screenshot
		capabilities.setCapability("video",true);// To enable video recording
		capabilities.setCapability("console", true);// To capture console logs
		try {
			driver = new RemoteWebDriver(new java.net.URL("https://" + username + ":" + accesskey + gridURL), capabilities);
		}
		catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}
}
