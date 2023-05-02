package CRUDOperationWithBDD;
 
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProject {
	
	
	@Test
	public void updateProject()
	{
		
		JSONObject jobj =new JSONObject();
		jobj.put("createdBy", "abcd");
		jobj.put("projectName", "sara7436464");
		jobj.put("status", "Created");
		jobj.put("teamSize", "25");
		
		baseURI="http://rmgtestingserver";
		port=8084;
		when()
		.put("/projects/")
		
		//step3:validation
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		
		
	}
	
	

}
