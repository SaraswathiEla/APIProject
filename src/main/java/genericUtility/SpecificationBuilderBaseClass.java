package genericUtility;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationBuilderBaseClass {

	//public PropertyUtility propertyUtility=new PropertyUtility(Iconstants.filepath);
	public JavaUtility javaUtility=new JavaUtility();
	  public  ExcelUtility excelUtility=new ExcelUtility();

	public RequestSpecification requestSpec;
   public ResponseSpecification responseSpec;
   
   
   @BeforeSuite
   public void bsConfig()
   {
	   RequestSpecBuilder builder=new  RequestSpecBuilder();
	   String baseURI="http://localhost:8084/";//propertyUtility.getPropertyData1("baseURI");
	   builder.setBaseUri(baseURI);
	   builder.setPort(8084);
	   builder.setContentType(ContentType.JSON);
	   requestSpec=builder.build();

	   ResponseSpecBuilder builder1=new  ResponseSpecBuilder();
	   builder1.expectContentType(ContentType.JSON);
	   builder1.expectResponseTime(Matchers.lessThan(100L),TimeUnit.SECONDS);
	   //builder.expectStatusLine("HTTP/1.1 409");
	   //builder.expectStatusCode(200);
	   responseSpec=builder1.build();
	   
	   
	   
	   
   }
   @AfterSuite
   public void asConfig()
   {
	   
	   
	   
   }
   
   
}
