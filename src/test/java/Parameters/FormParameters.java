package Parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class FormParameters {

	@Test
	public void formParameter()
	{
		//pre condition 
				baseURI="http://rmgtestingserver";
				port=8084;
				given()
				.formParam("creartedBy", "sachin")
				.formParam("projectName", "sachi")
				.formParam("status","Created")
				.formParam("treamSize",20)
				
				.when().post("/addProject")
				.then().log().all();
				
	}
	
}
