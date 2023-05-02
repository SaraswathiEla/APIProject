package RequestChainig;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class crudOperation_chaingRequest {
	@Test
	public void getandDeleteProject()
	{

		JavaUtility jlib=new JavaUtility();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "abwcd");
		jobj.put("projectName", "abcd"+jlib.getRandomNumber(100));
		jobj.put("status", "Created");
		jobj.put("teamSize", 25);
		
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//Step1: Create Pre request
		Response resp = given().body(jobj)
		.contentType(ContentType.JSON)
		
		//Step2: perform action
		.when()
		.post("/addProject");
		
		String acId = resp.jsonPath().get("projectId");
		System.out.println(acId);
		given().pathParam("projectId", acId)
		.when().get("/projects/{projectId}").then().log().all();
		
		
		
			
		}
		
		
	}
	
 	



