package inicialize_chrome_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverData {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private ElementsWeb elements;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public WebDriverWait getWait() {
		return wait;
	}
	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}
	public ElementsWeb getElements() {
		if(elements == null) 
			setElements(PageFactory.initElements(getDriver(), ElementsWeb.class));
		return elements;
	}
	public void setElements(ElementsWeb elements) {
		this.elements = elements;
	}
}