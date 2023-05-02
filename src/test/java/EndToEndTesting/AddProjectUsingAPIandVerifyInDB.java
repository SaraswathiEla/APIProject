package EndToEndTesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import genericUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddProjectUsingAPIandVerifyInDB {
	@Test
	public void createProject() throws SQLException
	{
		JavaUtility jlib=new JavaUtility();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "abwcd");
		jobj.put("projectName", "abcd"+jlib.getRandomNumber(100));
		jobj.put("status", "Created");
		jobj.put("teamSize", 25);
		
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//Step1: Create Pre request
		Response resp = given().body(jobj)
		.contentType(ContentType.JSON)
		
		//Step2: perform action
		.when()
		.post("/addProject");
		
		String acId = resp.jsonPath().get("projectId");
		System.out.println(acId);
		given().pathParam("projectId", acId)
		.when().get("/projects/{projectId}").then().statusCode(200).log().all();
		
		
		System.out.println(acId);
		String expId=acId;
		
		
		
		//VerifyIn DataBase
		
		//Step1:create instance and register to databasemanager
		Driver dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		Connection	connection = null;
		
		 
		 try {
    //Step2:connect to jdbc\
			
		 connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");//rmg databse connection
		
	//Step3:create statement
		
		Statement statement = connection.createStatement();
		
    //Step4:execuet Query
        
        //	int result =statement.executeUpdate("insert into project values(projectId,manager,createdOndate,projectName,status,teamSize)");
		 
	
		
		String query="select * from project where project_id='"+expId+"'";
		ResultSet result = statement.executeQuery(query);
	//System.out.println(result.getString("project_id"));
//		if(expId.equals(result.getString("project_id")))
//		{
//			System.out.println("Project is there in DataBase");
//		
//		}
		while(result.next())
			{
				String actprojectId = result.getString("project_id");
				System.out.println(actprojectId);
				if(expId.equals( actprojectId))
				{
					System.out.println("Project is there in DataBase");
					break;
				}
				
			}
		
//		String query="select * from project";
//
//		ResultSet result = statement.executeQuery(query);
//		System.out.println(result);//it will return the address
//		//int size=result.getMetaData().getColumnCount();
////				for(int i=1;i<=size;i++)
////				{
////					System.out.println(result.getMetaData().getColumnName(i));
////				}
////				
//				while(result.next())
//				{
//					String actprojectId = result.getString("project_id");
//					System.out.println(actprojectId);
//					if(expId==actprojectId)
//					{
//						System.out.println("Project is there in DataBase");
//						break;
//					}
//					
//				}
		 }

		

				finally {
				connection.close();
					System.out.println("connection closed");
				} 
				
				

		

}
}
