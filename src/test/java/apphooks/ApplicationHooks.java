package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.Driverfactory;
import com.utils.ConfigUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private Driverfactory df;
	private WebDriver driver;
	private ConfigUtil configUtil;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configUtil = new ConfigUtil();
		prop = configUtil.init_prop();
	}

	@Before(order=1)
	public void launchBrowser() {
		df = new Driverfactory();
		driver = df.init_driver(prop.getProperty("browser"));
	}
	
	@After (order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After (order = 1)
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}


