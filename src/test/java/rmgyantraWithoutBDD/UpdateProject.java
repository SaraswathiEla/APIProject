package rmgyantraWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	public void updateProject()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "abcd");
		jobj.put("projectName", "sara7436464");
		jobj.put("status", "Created");
		jobj.put("teamSize", "25");
		
		//Precondition
		RequestSpecification reqspec = RestAssured.given();
		reqspec.body(jobj);
		reqspec.contentType(ContentType.JSON);
		
	//action
	Response resp = reqspec.put("http://rmgtestingserver:8084/projects/ty10");
	System.out.println(resp);
	int scode = resp.statusCode();
	System.out.println(scode);
	String contenttype = resp.getContentType();
	System.out.println(contenttype);
	
	resp.then().log().all();

 			//validation
//	ValidatableResponse validation = resp.then();
//	
//	validation.assertThat().statusCode(200).and().contentType(ContentType.JSON).log().all();
	}

}
