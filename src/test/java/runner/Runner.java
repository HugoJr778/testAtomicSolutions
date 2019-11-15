package runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import test_api_rest.suite.SuiteTestResponse;
import test_web_film.suite.SuiteDataFilm;

public class Runner {

	public static void main(String[] args) {
		final Result result = JUnitCore.runClasses(SuiteDataFilm.class, SuiteTestResponse.class);
				
		for(final Failure fail : result.getFailures()) {
			System.out.println("FAIL ---> " + fail.toString());
		}
		System.out.println("\nSUCCESSFUL ALL TESTS ? --- " + result.wasSuccessful());
	}
}