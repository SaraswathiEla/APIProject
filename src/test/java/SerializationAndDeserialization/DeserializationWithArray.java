package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforEmployeedata.CreateEmp;
import PojoClassForSerializationandDesrialzation.EmployeDetails;

public class DeserializationWithArray {

	@Test
	public void deserializationWithArray() throws JsonParseException, JsonMappingException, IOException
	{
		//Step1:create a object for ObjectMapper
		ObjectMapper objMap=new ObjectMapper();
		
		//Read the Value from the Object Mapper
		CreateEmp e1=objMap.readValue(new File("./CreateEmployeeDeatils.json"), CreateEmp.class);
		int[] empph = e1.getPh();
		System.out.println(empph[1]);
		
	
}
}
