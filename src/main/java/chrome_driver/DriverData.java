package chrome_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import chrome_driver.elements_web.ElementsDataFilm;

public class DriverData {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private ElementsDataFilm elements;
	
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
	public ElementsDataFilm getElements() {
		if(elements == null) 
			setElements(PageFactory.initElements(getDriver(), ElementsDataFilm.class));
		return elements;
	}
	public void setElements(ElementsDataFilm elements) {
		this.elements = elements;
	}
}