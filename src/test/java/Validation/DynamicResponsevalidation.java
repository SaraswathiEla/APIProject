package Validation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class DynamicResponsevalidation {
	@Test
	public void dynamicRespValid()
	{
		
	
	 
	//pre condition
	String expData="06/01/2023";
	baseURI="http://rmgtestingserver";
	port=8084;
	
	//Action
	Response resp = when().get("/projects");	
	
	
	//validation
	boolean flag=false;
	List<String> pIDs=resp.jsonPath().get("projectId");
	
	for(String projectId:pIDs)
	{
		if(projectId.equalsIgnoreCase(expData))
		{
			flag=true;
			break;
		}
	}
	Assert.assertTrue(flag);
	System.out.println("data verified");
	resp.then().log().all();

}
}

