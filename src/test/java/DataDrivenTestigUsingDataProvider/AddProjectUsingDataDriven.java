package DataDrivenTestigUsingDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoClassToCreateProject.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
 
public class AddProjectUsingDataDriven {

	
	 @Test (dataProvider="Testbody")
	 
	 public void addProject(String createdBy,String projectName,String status,int teamSize)
	 {
		ProjectLibrary apj=new ProjectLibrary(createdBy,projectName,status,teamSize);
 		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		
		given()
		.contentType(ContentType.JSON)
		.body(apj)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.and()
		.log()
		.all();
		 
	 }
 
	 
	 @DataProvider
	 public Object[][] Testbody()
	 {
		 
		 Object[][] obj=new Object[3][4];
	
		 //1set
	 
	 obj[0][0]="saraRaju";
	 obj[0][1]="sararwaju123";
	obj[0][2]="Created";
	obj[0][3]=10;

	 //2nd set
	obj[1][0]="saRju";
	 obj[1][1]="sararraju12";
	obj[1][2]="Created";
	obj[1][3]=10;
	
	//3rd set
	obj[2][0]="sarju";
	 obj[2][1]="sararajwwu23";
	obj[2][2]="Created";
	obj[2][3]=10;
	
	 return obj;

	 }
}
