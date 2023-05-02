package EndToEndTesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Endpoint;

import genericUtility.Endpoints;
import genericUtility.SpecificationBuilderBaseClass;
import io.restassured.http.ContentType;

public class AddProjcts extends SpecificationBuilderBaseClass{

	@Test
	public void addProject()
	{
	
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "abwcd");
		jobj.put("projectName", "abcdw232");
		jobj.put("status", "Created");
		jobj.put("teamSize", 25);
		
		
		 
		//Step1: Create Pre request
		given().spec(requestSpec)
		.body(jobj)
		.contentType(ContentType.JSON)
		
		//Step2: perform action
		.when()
		.post(Endpoints.project_addProject)
		
		//step3:validation
		.then().spec(responseSpec).and().log().all();
		 
		
		
		
		
	}

}


