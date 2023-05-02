package PracticePetStore;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class createPetStore {
	@Test
	public void postPet()
	{
		String json="{"
				+ "  \"id\": 9222968140491042000,"
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"string\""
				+ "  },"
				+ "  \"name\": \"doggie\","
				+ "  \"photoUrls\": ["
				+ "    \"string\""
				+ "  ],"
				+ "  \"tags\": ["
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"string\""
				+ "    }"
				+ "  ],"
				+ "  \"status\": \"available\""
				+ "}";
		System.out.println(json);
		baseURI="https://petstore.swagger.io";
		
		given().header("accept","application/json").headers("Content-Type","application/json")
		.body(json)
		
		.when().post("/v2/pet")
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		  

		
 	
	}

}
