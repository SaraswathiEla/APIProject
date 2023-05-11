package PracticePetStore;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import files.PetPayload;
import io.restassured.http.ContentType;

public class createPetStoreUsingfilePayload {
	@Test
	public void postPet()
	{
//		String json="{"
//				+ "  \"id\": 9222968140491042000,"
//				+ "  \"category\": {"
//				+ "    \"id\": 0,"
//				+ "    \"name\": \"string\""
//				+ "  },"
//				+ "  \"name\": \"doggie\","
//				+ "  \"photoUrls\": ["
//				+ "    \"string\""
//				+ "  ],"
//				+ "  \"tags\": ["
//				+ "    {"
//				+ "      \"id\": 0,"
//				+ "      \"name\": \"string\""
//				+ "    }"
//				+ "  ],"
//				+ "  \"status\": \"available\""
//				+ "}";
//		
		System.out.println(PetPayload.addPetStore());
		baseURI="https://petstore.swagger.io";
		
		given().log().all().header("accept","application/json").headers("Content-Type","application/json")
		.body(PetPayload.addPetStore())
		
		.when().post("/v2/pet")
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		  

		
 	
	}

}
