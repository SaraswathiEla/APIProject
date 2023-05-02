package wayTOCreatePost;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class CreateProjectWithJSONFile {

	@Test
	public void createProject() {
	    
		File fileNAme = new File("./Project.json");
		given()
		   .contentType(ContentType.JSON)
		   .body(fileNAme)
		.when()
		   .post("http://localhost:8084/addProject")
		.then()
		   .log().all();
		
 
	}

}
