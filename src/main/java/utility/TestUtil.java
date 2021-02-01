package utility;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.google.j2objc.annotations.Property;

public class TestUtil {
	
	static Property prop = null;

	public static Properties loadPropertyFile() throws IOException {		
		String projectPath = System.getProperty("user.dir");		
		FileReader reader=new FileReader(projectPath+"\\src\\main\\resources\\"+"config.properties"); 
	    Properties prop=new Properties();  
	    prop.load(reader); 		
		return prop;
	}
	
}
