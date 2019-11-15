package test_web_film.test_film;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;

import chrome_driver.SetupChrome;
import chrome_driver.elements_web.ElementsDataFilm;
import test_web_film.entities.DataFilm;

public class TestDataFilm extends SetupChrome {
	
	private List<DataFilm> list = new ArrayList<>();
	
	@Before
	public void begin() {
		setElements(PageFactory.initElements(getDriver(), ElementsDataFilm.class));
		list.add(new DataFilm("Quentin Tarantino", LocalDate.of(1963, 02, 27), "Pulp Fiction: Tempo de Violência", LocalDate.of(1995, 02, 18)));
		list.add(new DataFilm("Woody Allen", LocalDate.of(1935, 12, 01), "Noivo Neurótico, Noiva Nervosa", LocalDate.of(1997, 04, 20)));
		list.add(new DataFilm("Anthony Russo", LocalDate.of(1970, 02, 03), "Vingadores: Ultimato", LocalDate.of(2019, 04, 25)));
		startSetup();
	}
	
	@Test
	public void testDataFilm() {
		String resultSearch = null;
		try {
			for(DataFilm dataFilm : list) {
				sendKeys(getElements().inputGoogle(), dataFilm.getnameDirector() + " " + dataFilm.getFilm());
				click(getElements().searchButton());
				resultSearch = getDataWeb(getElements().resultSearch());
				assertTrue(resultSearch.toLowerCase().contains("aproximadamente"));
				System.out.println("----------------------------------\n<Assertion Successfully>" + 
						"\nFILM: " + dataFilm.getFilm() +
						"\nLAUNCH: " + dataFilm.getLaunch() +
						"\nDIRECTOR: " + dataFilm.getnameDirector() + 
						"\nDIRECTOR BIRTH: " + dataFilm.getbirthDirector() +
						"\nRESULT SEARCH: " + resultSearch); 
				click(getElements().buttonFigureGoogle());
			}
		} catch (TimeoutException | IllegalStateException | ElementNotVisibleException | NoSuchElementException e) {
			System.out.println(e.getMessage() + e);
		}
		System.out.println("---------------------------------- > TEST COMPLETED");
	}
	
	@After
	public void end() {
		finalizeChrome();
	}
}