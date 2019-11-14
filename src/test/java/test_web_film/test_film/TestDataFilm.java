package test_web_film.test_film;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import inicialize_chrome_driver.SetupChrome;
import test_web_film.entities.DataFilm;

public class TestDataFilm extends SetupChrome {
	
	private List<DataFilm> list = new ArrayList<>();
	
	@Before
	public void begin() {
		list.add(new DataFilm("Quentin Tarantino", LocalDate.of(1963, 02, 27), "Pulp Fiction: Tempo de Violência", LocalDate.of(1995, 02, 18)));
		list.add(new DataFilm("Woody Allen", LocalDate.of(1935, 12, 01), "Noivo Neurótico, Noiva Nervosa", LocalDate.of(1997, 04, 20)));
		list.add(new DataFilm("Anthony Russo", LocalDate.of(1970, 02, 03), "Vingadores: Ultimato", LocalDate.of(2019, 04, 25)));
		startSetup();
	}
	
	@Test
	public void start() {
		for (DataFilm dataFilm : list) {
			sendKeys(getElements().inputGoogle(), dataFilm.getnameDirector() + " " + dataFilm.getFilm());
			click(getElements().buttonSearch());
			String resultSearch = getDataWeb(getElements().resultSearch());
			assertTrue(resultSearch.toLowerCase().contains("aproximadamente"));
			System.out.println("----------------------------------" + 
					"\nFILM: " + dataFilm.getFilm() +
					"\nLAUNCH: " + dataFilm.getLaunch() +
					"\nDIRECTOR: " + dataFilm.getnameDirector() + 
					"\nDIRECTOR BIRTH: " + dataFilm.getbirthDirector() +
					"\nRESULT SEARCH: " + resultSearch); 
			click(getElements().buttonFigureGoogle());
		}
	}
	
	@After
	public void end() {
		finalizeChrome();
	}
	
}