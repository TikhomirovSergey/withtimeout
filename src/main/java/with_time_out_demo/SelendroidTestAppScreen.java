package with_time_out_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;

public class SelendroidTestAppScreen {
	
	@WithTimeout(time = 20, unit = TimeUnit.SECONDS) //with this 
	//time out it works
    //@WithTimeout(time = 10, unit = TimeUnit.SECONDS) //The exception is
	//being caught
	@AndroidFindBy(id="io.selendroid.testapp:id/inputUsername")
	private MobileElement inputUsername;
	private final WebDriverWait wait;
	
	public SelendroidTestAppScreen(WebDriverWait wait) {
		this.wait = wait;
	}
	
	@AndroidFindBy(accessibility = "waitingButtonTestCD")
	private MobileElement waitingButtonTest;
	
	public void waitingButtonTestClick(){
		waitingButtonTest.click();
	}
	
	public void inputUsername(String userName){
		//there are many cases where a splash appears
		//we're waiting for element is visible here
		wait.until(ExpectedConditions.visibilityOf(inputUsername));
		inputUsername.sendKeys(userName);
	}

}
