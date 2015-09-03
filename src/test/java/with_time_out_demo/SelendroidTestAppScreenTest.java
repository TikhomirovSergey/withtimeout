package with_time_out_demo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelendroidTestAppScreenTest {
	
	private SelendroidTestAppScreen selendroidTestAppScreen;
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		File app = new File("selendroid-test-app-0.10.0.apk");
		
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		 capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		 driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		 WebDriverWait wait = new WebDriverWait(driver, 5);
		 selendroidTestAppScreen = new SelendroidTestAppScreen(wait);
		 //we consider that an element is being rendered for about 1 second in general
		 PageFactory.initElements(new AppiumFieldDecorator(driver, 1, TimeUnit.SECONDS), selendroidTestAppScreen);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		selendroidTestAppScreen.waitingButtonTestClick();
		//Here splash appears
		//it blocks application for about 10-15 seconds
		//but we're trying to type some string
		selendroidTestAppScreen.inputUsername("Appium user");
		
	}

}
