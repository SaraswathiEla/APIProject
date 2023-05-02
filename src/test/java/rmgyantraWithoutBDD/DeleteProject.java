package rmgyantraWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteProject {
	@Test
	public void deleteProject()
	{
		RequestSpecification reqspec = RestAssured.given();
		Response resp = reqspec.delete("http://rmgtestingserver:8084/projects/ty10");
		
		ValidatableResponse validation = resp.then();
		
		validation.assertThat().statusCode(204).and().contentType(ContentType.JSON).log().all();
		
		
	}

}
