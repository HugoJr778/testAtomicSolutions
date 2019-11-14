package runner;

import org.junit.runner.JUnitCore;

import test_web_film.suite.SuiteDataFilm;

public class Runner {

	public static void main(String[] args) {
		
		new JUnitCore().run(SuiteDataFilm.class);
		
	}
}