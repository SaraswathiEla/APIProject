package Parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QuerryParameters {
	@Test
	public void pathparameter()
	{
		//pre condition 
		baseURI="https://reqres.in";
		 
		given()
		.queryParam("page", "2")
		
		//action
		.when()
		.get("/api/users")
		
		//validation
		.then().log().all();
	
	}

}
