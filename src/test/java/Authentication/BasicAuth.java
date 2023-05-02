package Authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.http.ContentType;

public class BasicAuth {
	@Test
	public void basicAuth()
	{
		given().auth().basic("rmgyantra", "rmgy@9999")
 		
		//Step2: perform action
		.when()
		.get("http://localhost:8084/projects")
		
		//step3:validation
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	
	
 	}

	 	
	 	

}
