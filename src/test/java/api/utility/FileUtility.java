package api.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String readfrompropertyfile(String urlname) throws IOException {
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\Routes.properties");
		Properties p=new Properties();
		p.load(fis);
	 String value = p.getProperty(urlname);
		return value;
				
	}

}
