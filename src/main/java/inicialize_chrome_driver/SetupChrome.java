package inicialize_chrome_driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class SetupChrome extends DriverData {
	
	private final String URL = "https://www.google.com/";
	
	public void startSetup() {
		System.out.println(">>> INITIALIZED CHROME DRIVER <<<");
		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\inicialize_chrome_driver\\chromedriver.exe");
		setDriver( new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		setElements(PageFactory.initElements(getDriver(), ElementsWeb.class));
		setWait(new WebDriverWait(getDriver(), 60));
		getDriver().get(URL);
	}
	
	public void finalizeChrome() {
		if(getDriver() != null) {
			System.out.println(">>> ERODING... <<<");
			getDriver().close();
			getDriver().quit();
		}
	}
	
	public void timeouts(By locator) {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void click(By element) {
		timeouts(element);
		getDriver().findElement(element).click();
	}
	
	public void sendKeys(By element, String key) {
		timeouts(element);
		getDriver().findElement(element).sendKeys(key);
	}
	
	public String getDataWeb(By element) {
		timeouts(element);
		String data = getDriver().findElement(element).getText();
		return (data == null || data.isEmpty() ? "" : data);
	}
}