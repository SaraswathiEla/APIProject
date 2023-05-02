package PracticePetStore;

 import org.testng.annotations.Test;

 import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetPet {
	
	@Test
	public void displayPetDetails()
	
	{
	
		baseURI="https://petstore.swagger.io";
		given().header("accept","application/json").headers("Content-Type","application/json")
		
		
		.when().get("/v2/pet/findByStatus?status=available")
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		
				 
 }
}