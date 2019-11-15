package chrome_driver.elements_web;

import org.openqa.selenium.By;

public class ElementsDataFilm {
		
	public By inputGoogle() {return By.xpath("//input[@name='q']");}
	public By searchButton() {return By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]");}
	public By resultSearch() {return By.xpath("//div[@id='resultStats']");}
	public By buttonFigureGoogle() {return By.xpath("//a[@id='logo']//img");}
	
}