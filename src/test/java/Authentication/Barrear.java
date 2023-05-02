package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Barrear{
	@Test
	public void barear()
	{
		
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/repos/SaraswathiEla/postman1")
		.then()
		.assertThat().log().all();
		
		
		
	}

	 	
	}


