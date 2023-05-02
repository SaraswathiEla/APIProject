package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

 
public class PropertyUtility {

//	private Properties prop=null;
//	
//	public PropertyUtility() {
//	}
	/**
	 * this method is used to initialize property file using parameterized constructor
	 * @param filePath
	 * @throws IOException
	 */
	public PropertyUtility(String filePath) throws IOException {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	/**
	 * 	 * this method is used to initialize property file
	 * @param filePath
	 * @throws IOException
	 */
	@Deprecated
	public void initializePropertyFile(String filePath) throws IOException {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * * this method is used to get propertyData passing Key 
	 * @param key
	 * @return
	 */
   @Deprecated
	public String getPropertyData(String key) {
		return prop.getProperty(key,"Please give proper"+key+"").trim();
		
	}
	/**
	 * this method is used to get propertyData passing PropertyKey enum
	 * @param key
	 * @return
	 */
	public String  getPropertyData1(String key) {
		 
		String value = prop.getProperty(key);
		return value;
	} 
	/**
	 * this method is used to clear the property object
	 */
	public void clear() {
		prop.clear();
	}

}

 
