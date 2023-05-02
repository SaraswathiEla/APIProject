package Validation;
 

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;


public class ResponseTimeValidation {
	@Test
	public void responseTimeValid()
	{
		//Step:1 Pre condition
		
		//step2:actions
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//Step 3:validation
		when()
		.get("/projects")
		.then()
		.assertThat().time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
	}

	 
}
