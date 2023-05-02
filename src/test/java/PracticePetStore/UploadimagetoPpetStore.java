package PracticePetStore;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UploadimagetoPpetStore {

	@Test
	public void uploadimage()
	{	
		baseURI="https://petstore.swagger.io";
		
		
		given().multiPart("file",new File("C:\\Users\\Saraswathi B\\Desktop\\eclipse_workspace\\selenium_workspace\\ofosgitworspace\\rmgyantra\\src"
				+ "\\test\\resources\\food.png.jfif"),"image/jpeg")
		.header("accept","application/json").headers("Content-Type","multipart/form-data").formParam("additionalMetadata", "sara")
		.when().post("/v2/pet/7/uploadImage")
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();

 
	}
}
