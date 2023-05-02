package CRUDOperationWithBDD;

import static io.restassured.RestAssured.*; 

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllProject {

	 @Test
	 public void getAllProject()
	 {
		 
	 

		baseURI="http://rmgtestingserver";
		port=8084;
		when()
		.get("/projects")
		
		//step3:validation
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}
	 
	}
	 
