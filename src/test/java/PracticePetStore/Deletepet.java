package PracticePetStore;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Deletepet {
	@Test
	public void displayPetDetails()
	
	{
	
		baseURI="https://petstore.swagger.io";
		given().header("accept","application/json").headers("Content-Type","application/json")
		
		
		.when().delete("/v2/pet/4")  // /v2/pet/2
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		
				 
 }
}

