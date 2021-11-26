package testCalculator;

//import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;

public class CalculatorTest {

	public  WindowsDriver CalculatorSession = null;
	public  WebElement CalculatorResult = null;
	public DesiredCapabilities capabilities;

	@BeforeClass
	public void setup() {
		try {
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
			capabilities.setCapability("platformName", "Windows");
			capabilities.setCapability("platformVersion", "1.0");
			
			
			CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
			Assert.assertNotNull(CalculatorResult);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	@Test
	public void Clear() {
		CalculatorSession.findElementByAccessibilityId("clearEntryButton").click();
		Assert.assertEquals("0", _GetCalculatorResultText());
	}

	@AfterClass
	public void TearDown() {
		CalculatorResult = null;
		if (CalculatorSession != null) {
			CalculatorSession.quit();
		}
		CalculatorSession = null;
	}

	@Test
	public void Addition() {
		CalculatorSession.findElementByAccessibilityId("num1Button").click();
		CalculatorSession.findElementByAccessibilityId("plusButton").click();
		CalculatorSession.findElementByAccessibilityId("num7Button").click();
		CalculatorSession.findElementByAccessibilityId("equalButton").click();
		Assert.assertEquals("8",_GetCalculatorResultText());
	}

	@Test
	public void Combination() {
		CalculatorSession.findElementByAccessibilityId("num7Button").click();
		CalculatorSession.findElementByAccessibilityId("multiplyButton").click();
		CalculatorSession.findElementByAccessibilityId("num9Button").click();
		CalculatorSession.findElementByAccessibilityId("plusButton").click();
		CalculatorSession.findElementByAccessibilityId("num1Button").click();
		CalculatorSession.findElementByAccessibilityId("equalButton").click();
		CalculatorSession.findElementByAccessibilityId("divideButton").click();
		CalculatorSession.findElementByAccessibilityId("num8Button").click();
		CalculatorSession.findElementByAccessibilityId("equalButton").click();
		Assert.assertEquals("8", _GetCalculatorResultText());
	}

	@Test
	public void Division() {
		CalculatorSession.findElementByAccessibilityId("num8Button").click();
		CalculatorSession.findElementByAccessibilityId("num8Button").click();
		CalculatorSession.findElementByAccessibilityId("divideButton").click();
		CalculatorSession.findElementByAccessibilityId("num1Button").click();
		CalculatorSession.findElementByAccessibilityId("num1Button").click();
		CalculatorSession.findElementByAccessibilityId("equalButton").click();
		Assert.assertEquals("8", _GetCalculatorResultText());
	}

	@Test
	public void Multiplication() {
		CalculatorSession.findElementByAccessibilityId("num9Button").click();
		CalculatorSession.findElementByAccessibilityId("multiplyButton").click();
		CalculatorSession.findElementByAccessibilityId("num9Button").click();
		CalculatorSession.findElementByAccessibilityId("equalButton").click();
		Assert.assertEquals("81", _GetCalculatorResultText());
	}

	@Test
	public void Subtraction() {
		CalculatorSession.findElementByAccessibilityId("num9Button").click();
		CalculatorSession.findElementByAccessibilityId("minusButton").click();
		CalculatorSession.findElementByAccessibilityId("num1Button").click();
		CalculatorSession.findElementByAccessibilityId("equalButton").click();
		Assert.assertEquals("8", _GetCalculatorResultText());
	}

	protected String _GetCalculatorResultText() {
		// trim extra text and whitespace off of the display value
		return CalculatorResult.getText().replace("«·‰« Ã", "").trim();
	}

}
