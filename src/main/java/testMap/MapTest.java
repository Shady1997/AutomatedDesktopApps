package testMap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class MapTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO get app name(get-startApps&&developermode=on&&https://github.com/microsoft/WinAppDriver/blob/master/Docs/AuthoringTestScripts.md&&start winappdriver server && start inspect)
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "Microsoft.WindowsMaps_8wekyb3d8bbwe!App");
		capabilities.setCapability("platformName", "Windows");
		capabilities.setCapability("platformVersion", "1.0");
		
		WindowsDriver driver= new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println(driver.getSessionId());
		
		driver.findElementByAccessibilityId("TextBox").sendKeys("Egypt");
		driver.findElementByAccessibilityId("TextBox").sendKeys(Keys.ENTER);
		
		

	}

}
