package genericUtility;

import static  io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class RestAssuredUtility {
	

public String getJsonPath(Response response,String path)
{
 	String jsonData = response.jsonPath().get(path);
	return jsonData;
 	
}
}
