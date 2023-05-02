package Authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Outh2 {

	@Test
	public void outh2()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/repos/SaraswathiEla/postman1")
		.then()
		.assertThat().log().all();
	
	}
}
