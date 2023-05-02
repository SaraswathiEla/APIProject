package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforEmployeedata.CreateEmp;
import PojoClassForSerializationandDesrialzation.EmployeDetails;

public class SerializationWithArray {
@Test
public void serializationWithArray() throws JsonGenerationException, JsonMappingException, IOException


{
	
	int[] ph= {990295,929292};

	//Step1: Create Object of pojo class
	CreateEmp emp=new CreateEmp( ph);
	
	
	//Step2:Create Object for Object Mapper
	ObjectMapper objMap=new ObjectMapper();
	
	//Write the value to the jsonFile
	objMap.writeValue(new File("./CreateEmployeeDeatils.json"),emp);
	
	
}
}
