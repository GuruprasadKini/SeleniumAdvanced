package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LambdaTest {
	@Test(timeOut = 60000)
	@Parameters({"platform", "browser", "browserVersion"})
	public void runTest(String platform, String browser, String browserVersion) {
		LambdaTestScenarios runScenario = new LambdaTestScenarios();
		if(platform.equals("win10")) {
			runScenario.testScenario1(platform, browser, browserVersion);
		}
		else if(platform.equals("macOS Sierra")) {
			runScenario.testScenario2(platform, browser, browserVersion);
		}
	}
}
