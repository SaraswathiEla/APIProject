package PracticePetStore;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdatePet {
	@Test
	public void updatePet()
	{
		String json="{"
				+ "  \"id\": 9222968140491042000,"
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"string\""
				+ "  },"
				+ "  \"name\": \"doggie123\","
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
		//System.out.println(json);
		baseURI="https://petstore.swagger.io";
		
		given().header("accept","application/json").headers("Content-Type","application/json")
		.body(json)
		
		.when().put("/v2/pet")
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		  

		
 	
	}

}
