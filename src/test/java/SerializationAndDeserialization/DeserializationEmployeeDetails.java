package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassForSerializationandDesrialzation.EmployeDetails;

 
public class DeserializationEmployeeDetails {
	@Test
	public void deserializationEmployeeDetails() throws JsonParseException, JsonMappingException, IOException
	{
		//Step1:create a object for ObjectMapper
		ObjectMapper objMap=new ObjectMapper();
		
		//Read the Value from the Object Mapper
		EmployeDetails e1=objMap.readValue(new File("./EmployeeDeatils.json"), EmployeDetails.class);
		System.out.println(e1.geteName());
		e1.getEmail();
		e1.getPhno();
		e1.geteID();

	}

}
