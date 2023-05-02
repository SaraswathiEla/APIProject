package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforEmployeedata.CreateEmp;
import POJOforEmployeedata.Spouse;

public class SerializationForObject {
@Test
	 	public void serializationForObject() throws JsonGenerationException, JsonMappingException, IOException
	 	{
	 		int[] ph= {990295,929292};
	 		String [] emailid= {"sara@gmail.com","raju@gmail.com"};
	 		Spouse spouse=new Spouse("sara","sara@gmail.com",990295);

	 		//Step1: Create Object of pojo class
	 		CreateEmp emp=new CreateEmp("sara",emailid,ph, 123, spouse);
	 		
	 		
	 		//Step2:Create Object for Object Mapper
	 		ObjectMapper objMap=new ObjectMapper();
	 		
	 		//Write the value to the jsonFile
	 		objMap.writeValue(new File("./CreateEmployeeDeatils1.json"),emp);
	 		
	 		


	    }

}
