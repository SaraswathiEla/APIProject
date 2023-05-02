package rmgyantraWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetProject {
	@Test
	public void getProject()
	{
		RequestSpecification reqspec = RestAssured.given();
		Response resp = reqspec.get("http://rmgtestingserver:8084/projects/TY_PROJ_2702");
		
		ValidatableResponse validation = resp.then();
		
		validation.assertThat().statusCode(200).and().contentType(ContentType.JSON).log().all();
		
		

	}

}
