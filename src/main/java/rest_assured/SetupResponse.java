package rest_assured;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public abstract class SetupResponse {

	@BeforeClass
	public static void setupResponse() {
		RestAssured.baseURI = (System.getProperty("server.host") == null ? "https://jsonplaceholder.typicode.com/"
				: System.getProperty("server.host"));
	}
}