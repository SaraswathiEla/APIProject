package Validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class HeaderValidation {
	@Test()
	public void headervalidation()
	{
		//pre condition

		String expected="TY_PRO3_2947";
		String expData="06/01/2023";
		
		
		String expContentType="application/json";
		String expVary="Access-Control-Request-Headers";
		String expPragma="no-cache";
 		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//Action
		Response resp = when().get("/projects");	
		String actContentType = resp.getContentType();
		String actRespVary = resp.getHeader("Vary");
		String actRespPragma = resp.getHeader("Pragma");
 		
		//validation
		resp.then().log().all();
		Assert.assertEquals(actContentType,expContentType);
		Assert.assertEquals(actRespVary,expVary);
		Assert.assertEquals(actRespPragma,expPragma);
 }
}