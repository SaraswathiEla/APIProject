package Validation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
	@Test
	public void staticResponseValid()
	{
		 
		//Pre Request
		String espData="06/01/2023";
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//action
		  Response resp = when()
				.get("/projects");
		  
		  //valifdation
		  String actdata=resp.jsonPath().getString("[0].projectId");
		  Assert.assertEquals(actdata,espData);
		  System.out.println("data Verified");
		  resp.then().log().all();
		  
		
	}

}
