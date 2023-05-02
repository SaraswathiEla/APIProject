package Authentication;

import static io.restassured.RestAssured.*;

public class Outh2Coops {
	public void outh2Coops()
	{
		 
		given().formParam("client_id","chickenShop")
		.formParam("client_secret","");
		.formParam("grant_type","");
		.formParam("redirect_uri","");
		.formParam("code","2934");
		
		
	
	
	}
	

}
