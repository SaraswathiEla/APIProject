package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforEmployeedata.CreateEmp;
import POJOforEmployeedata.Spouse;

public class DeSerializationForObject {
	@Test
	public void deSerializationForObject() throws JsonParseException, JsonMappingException, IOException
	{
		//Step1:create a object for ObjectMapper
		ObjectMapper objMap=new ObjectMapper();
		
		//Read the Value from the Object Mapper
		CreateEmp e1=objMap.readValue(new File("./CreateEmployeeDeatils1.json"), CreateEmp.class);
		
		System.out.println(e1.getPh());//it will return the address of ph array
		int[] empph = e1.getPh();
		System.out.println(empph[1]);
		
		System.out.println(e1.getPh()[0]);//we should give index
		
		Spouse sp = e1.getSpouse();
		System.out.println(e1.getName());
		System.out.println(e1.getSpouse().getEmailId());
		

		
	
}
}



