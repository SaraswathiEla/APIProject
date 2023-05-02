package DataDrivenTestigUsingDataProvider;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoClassToCreateProject.ProjectLibrary;
import genericUtility.ExcelUtility;
import io.restassured.http.ContentType;

public class AddProjectUsingDataDrivenUsingExcelUtility {

	@Test(dataProvider="Testdata")

	public void addProject(String createdBy, String projectName, String status, String teamsize)
	{
		int teamSize=Integer.parseInt(teamsize);
		ProjectLibrary apj = new ProjectLibrary(createdBy, projectName, status, teamSize);

		
		baseURI = "http://rmgtestingserver";
		port = 8084;

		given().contentType(ContentType.JSON).body(apj)

				.when().post("/addProject")

				.then().assertThat().contentType(ContentType.JSON).and().log().all();

	}

 @DataProvider
 public Object[][] Testdata()
 {
	 ExcelUtility excelUtility=new ExcelUtility("./src/test/resources/sdet46excel.xlsx");
	 Object[][] obj=excelUtility.getExcelData("sdet46");
	 return obj;
	 
 }

}
