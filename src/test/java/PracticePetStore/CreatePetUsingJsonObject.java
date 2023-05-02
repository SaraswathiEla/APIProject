package PracticePetStore;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreatePetUsingJsonObject {

	@Test
	public void createPet() {
		JSONObject	 jobj=new JSONObject();
		jobj.put("id", "123");
		
		JSONObject	 jobj2=new JSONObject();
		jobj2.put("id","1");
		jobj2.put("name","puppy");
		jobj.put("category", jobj2);
	
		jobj.put("name", "doggie");
		
		JSONArray jobj4=new JSONArray();
		jobj4.add("www.xyz.com");
		
		jobj.put("photoUrls", jobj4);
		
		JSONArray jobj5=new JSONArray();

		JSONObject	 jobj3=new JSONObject();
		jobj3.put("id","321");
		jobj3.put("name","sara");
		jobj5.add(jobj3);
		
		jobj.put("tags", jobj5);
		
		jobj.put("status","available");
		
baseURI="https://petstore.swagger.io";
		
		given().header("accept","application/json").headers("Content-Type","application/json")
		.body(jobj)
		
		.when().post("/v2/pet")
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		
		

		
		
	}
}
