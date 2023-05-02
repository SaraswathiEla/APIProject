package EndToEndTesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddProjectIntoDBandVerifiAPI{
	
	@Test
	public void endToendTesting() throws SQLException
	{
			//Step1:create instance and register to databasemanager
						Driver dbDriver=new Driver();
						DriverManager.registerDriver(dbDriver);
						Connection	connection = null;
						
						 
						String manager="raju"+new Random().nextInt(100);
						String projectName="selenium"+new Random().nextInt(100);
						String projectId="ty13"+new Random().nextInt(100);
						try {
				    //Step2:connect to jdbc\
							
						 connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");//rmg databse connection
						
					//Step3:create statement
						
						Statement statement = connection.createStatement();
						
				    //Step4:execuet Query
				        
				        //	int result =statement.executeUpdate("insert into project values(projectId,manager,createdOndate,projectName,status,teamSize)");
						 
					
						
						String query="insert into project values('"+projectId+"','"+manager+"','7/2/2023','"+projectName+"','planning',10)";
						ResultSet resp = statement.executeQuery("select * from project");
						System.out.println(resp);//it will return the address
						int result =statement.executeUpdate(query);
						
						
						if(result==1)
						{
							System.out.println("data added sucessfully");
						}
					}
						
						finally {
						connection.close();
							System.out.println("connection closed");
						} 
						
						
//Try to fetch the project using API
						
						baseURI="http://rmgtestingserver";
						port=8084;
						
						
						given() 
						.when().get("/projects/"+projectId)
						
						.then().assertThat().statusCode(200).log().all();
						
//						WebDriverManager.chromedriver().setup();
//						WebDriver driver=new ChromeDriver();
//						driver.manage().window().maximize();
//						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
//						String un="rmgyantra";
//					    String pwd="rmgy@9999";	
//					    String projectid=projectId;
//						//driver.get(" http://rmgtestingserver:8084");
//						driver.get("http://localhost:8084/dashboard");
//						String titileRmg = driver.getTitle();
//						if(titileRmg.equals("React APP"))
//						{
//							System.out.println("rmg welcome page displayed");
//						}
//						driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(un);
//						driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(pwd);
//						driver.findElement(By.xpath("//button[text()='Sign in']")).click();
//						driver.findElement(By.xpath("//a[text()='Projects']")).click();
//						List<WebElement> list= driver.findElements(By.xpath("//th[text()='ProjectId']/../../following-sibling::tbody/tr/td[1]"));
//						for(WebElement ele:list)
//						{
//							String text = ele.getText();
//							if(text.equals(projectid))
//							{
//								System.out.println(projectid+" present in rmg Ui");
//								break;
//							}
//						}
//						
//					  driver.close();
//
//						
//						
		
	}
}
