package test_web_film.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test_web_film.test_film.TestDataFilm;

@RunWith(Suite.class)
@SuiteClasses ({
	
	TestDataFilm.class,
	
}) 

public class SuiteDataFilm {
}