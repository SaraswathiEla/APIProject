package Parameters;

import static io.restassured.RestAssured.*;
 
import org.testng.annotations.Test;

public class PathParameters {
	@Test
	public void pathparameter()
	{
		//pre condition 
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.pathParam("pID", "TY_PROJ_2702")
		
		//action
		.when()
		.get("/projects/{pID}")
		
		//validation
		.then().log().all();
	
	}

}
