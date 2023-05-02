package CRUDOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*; //in order to fetch inbuilt variable in class level

public class CreateProject {
	@Test
	public void addProject()
	{
	
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "abwcd");
		jobj.put("projectName", "abcdw232");
		jobj.put("status", "Created");
		jobj.put("teamSize", 25);
		
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//Step1: Create Pre request
		given().body(jobj)
		.contentType(ContentType.JSON)
		
		//Step2: perform action
		.when()
		.post("/addProject")
		
		//step3:validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		
		
		
		
	}

}
