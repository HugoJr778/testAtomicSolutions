package inicialize_chrome_driver;

import org.openqa.selenium.By;

public class ElementsWeb {
		
	public By inputGoogle() {return By.xpath("//input[@name='q']");}
	public By buttonSearch() {return By.xpath("");}
	public By resultSearch() {return By.xpath("//div[@id='resultStats']");}
	public By buttonFigureGoogle() {return By.xpath("//a[@id='logo']//img");}
	
}