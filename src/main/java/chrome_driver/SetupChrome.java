package chrome_driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class SetupChrome extends DriverData {
	
	private final String URL = "https://www.google.com/";
	
	public void startSetup() {
		System.out.println(">>> INITIALIZED CHROME DRIVER <<<");
		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\chrome_driver\\chromedriver.exe");
		setDriver( new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		setWait(new WebDriverWait(getDriver(), 30));
		getDriver().get(URL);
	}
	
	public void finalizeChrome() {
		if(getDriver() != null) {
			System.out.println(">>> ERODING CHROME DRIVER <<<");
			getDriver().close();
			getDriver().quit();
		}
	}
	
	public void visibilityTimeouts(By locator) {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void click(By element) {
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		visibilityTimeouts(element);
		getDriver().findElement(element).click();
	}
	
	public void sendKeys(By element, String key) {
		visibilityTimeouts(element);
		getDriver().findElement(element).sendKeys(key);
	}
	
	public String getDataWeb(By element) {
		visibilityTimeouts(element);
		String data = getDriver().findElement(element).getText();
		return (data == null || data.isEmpty() ? "" : data);
	}
}