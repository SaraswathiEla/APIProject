package rmgyantraWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProject {
	@Test
	public void addProject()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "abcd");
		jobj.put("projectName", "abcd23332");
		jobj.put("status", "Created");
		jobj.put("teamSize", 25);
		
		
		
		//Precondition
		RequestSpecification reqspec = RestAssured.given();
		reqspec.body(jobj);
		reqspec.contentType(ContentType.JSON);
		
	//action
	Response resp = reqspec.post("http://rmgtestingserver:8084/addProject");
	int scode = resp.statusCode();
	System.out.println(scode);
	String abc = resp.getContentType();
	System.out.println(abc);
			//validation
	ValidatableResponse validation = resp.then();
	
	validation.assertThat().statusCode(201).and().contentType(ContentType.JSON).log().all();
	}

}
