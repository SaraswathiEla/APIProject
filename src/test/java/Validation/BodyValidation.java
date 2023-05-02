package Validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class BodyValidation {
	@Test()
	public void bodyvalidation()
	{
		//pre condition

		String expected="TY_PRO3_2964";
		String expData="06/01/2023";
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//Action
		Response resp = when().get("/projects");	
		ResponseBody respbody = resp.body();
		System.out.println(respbody);//it will return the  response body address
		//o/p:- io.restassured.internal.RestAssuredResponseImpl@108d55c4
		
		System.out.println("=======================================================");
		ResponseBody respbody1=resp.getBody();
		System.out.println(respbody1);//it will return the  response body address
		//o/p:- io.restassured.internal.RestAssuredResponseImpl@108d55c4
		
		System.out.println("=======================================================");
		String resBody=resp.getBody().prettyPrint();
		System.out.println(resBody);//it will return the  response body 
		
		System.out.println("=======================================================");
		ResponseBody resBody1=resp.getBody().prettyPeek();
		System.out.println(resBody1);//it will return the  response header ,body and respone body address
		
		System.out.println("=======================================================");
		String body=resp.getBody().asString();//it will return the responsebody
		String body1=resp.getBody().toString();//it returns the address of response
		System.out.println(body);
		System.out.println(body1);
		
		
		Boolean flag=false;
		
		if(body.contains(expected))
		{
			flag=true;
			System.out.println("found");
		}
	Assert.assertTrue(flag);
	
	}

}
