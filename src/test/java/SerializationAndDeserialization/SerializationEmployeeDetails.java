package SerializationAndDeserialization;

 
import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassForSerializationandDesrialzation.EmployeDetails;

public class SerializationEmployeeDetails {
	@Test
	public void serializationEmployeeDetails() throws JsonGenerationException, JsonMappingException, IOException
	{

	
	//Step1: Create Object of pojo class
	EmployeDetails emp=new EmployeDetails("sara","emp123",990295778,"sara@gmail.com","Bangalore");
	
	
	//Step2:Create Object for Object Mapper
	ObjectMapper objMap=new ObjectMapper();
	
	//Write the value to the jsonFile
	objMap.writeValue(new File("./EmployeeDeatils.json"),emp);
	
	
	
}
}

