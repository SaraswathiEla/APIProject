package CRUDOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*; //in order to fetch inbuilt variable in class level


public class GetSingleProject {

 @Test
 public void getProject()
 {
	 
 

	baseURI="http://rmgtestingserver";
	port=8084;
	when()
	.get("/projects/ty_200")
	
	//step3:validation
	.then()
	.assertThat()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	
	
}
 
}
 

