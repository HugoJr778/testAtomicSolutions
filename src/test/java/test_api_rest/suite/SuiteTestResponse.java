package test_api_rest.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test_api_rest.test_response.TestResponseGET;

@RunWith(Suite.class)
@SuiteClasses ({
	
	TestResponseGET.class
	
}) 

public class SuiteTestResponse {
}