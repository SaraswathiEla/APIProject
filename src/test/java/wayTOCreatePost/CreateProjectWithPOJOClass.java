package wayTOCreatePost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import PojoClassToCreateProject.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateProjectWithPOJOClass {
	
	@Test
	public void createProject()
	{
		ProjectLibrary proj=new ProjectLibrary("sara432","sar","Created",2);
		

		baseURI="http://rmgtestingserver";
		port=8084;
		
		//Step1: Create Pre request
		given().body(proj)
		.contentType(ContentType.JSON)
		
		//Step2: perform action
		.when()
		.post("/addProject")
		
		.then().assertThat().statusCode(201).log().all();
		
	}

}
