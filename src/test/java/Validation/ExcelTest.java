package Validation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;

public class ExcelTest {

	@Test
	public void PrintTest() throws EncryptedDocumentException, IOException {
//		ExcelUtility ex = new ExcelUtility("./src\\main\\resources\\data\\sdet46excel.xlsx");
//		Map<String, String> value = ex.getExcelData("a", "sdet46");
//		System.out.println(value);
//		Map<String, String> a = ex.getdatausingDataProvider("a","sdet46");
//		System.out.println(a);
//		//System.out.println(ex.getExcelData("a", "createdBy", "sdet46"));

		
String expTestScriptName="a";
	
		
		//Excel data fetch
		Map<String,String>data=new HashMap<String,String>();
		FileInputStream f=new FileInputStream("./src/main/resources/data/sdet46excel.xlsx");
		DataFormatter df=new DataFormatter();
		Workbook wb = WorkbookFactory.create(f);
		Sheet sheet = wb.getSheet("createdBy");
		int rowcount=sheet.getLastRowNum();
//		System.out.println(rowcount);
		for(int i=1;i<=rowcount;i++)
		{
			
			String tescriptName=df.formatCellValue(sheet.getRow(i).getCell(0));
//			System.out.println(tescriptName);
//			System.out.println(expTestScriptName);
			if(tescriptName.equals(expTestScriptName))
			{
			
			for(int j=1;j<sheet.getRow(i).getLastCellNum();j++)
			{
				String key=df.formatCellValue(sheet.getRow(i).getCell(j));
				String value=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				data.put(key,value);
			}
			break;
			}
			
		}
     /* String resName=data.get("ResturantName");
	 	String bEmail=data.get("BusinessEmail");
	 	String ph=data.get("Phone");
	 	String webUrl=data.get("WebsiteUrl");
	 	String  openH=data.get("Openhours");
	 	String closeH=data.get("closehours");
	 	String  opendays=data.get("opendays");
	 	String img=data.get("imagepath");
	 	String selectCat=data.get("SelectCategory");
	 	String restAdd=data.get("ResturantAddress");
	 	
		*/
      
      wb.close();
      f.close();

      
	}

		
	}

