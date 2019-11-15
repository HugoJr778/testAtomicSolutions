package test_api_rest.test_response;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import rest_assured.SetupResponse;

public class TestResponseGET extends SetupResponse {
	
	@Test
	public void testResponse() {
		System.out.println("----------------------------------\n>>> INITIALIZED REQUEST <<<");
		ValidatableResponse response = RestAssured.
			given().
			when().
				get("/todos/1").
			then().
				assertThat().
				statusCode(200).
			and().
				contentType(ContentType.JSON).
			and().		
				body("userId", equalTo(1)).
				body("id", equalTo(1)).
				body("title", equalTo("delectus aut autem")).
				body("completed", equalTo(false));
		
		System.out.println(response.extract().asString() + "\n---------------------------------- > SUCCESSFUL VALIDATED ANSWER");
	}
}