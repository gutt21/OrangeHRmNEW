package OrangeHRM_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class config_read {

	Properties prop;
	
	public config_read() {

		String file=".\\configuration\\config.properties";
		
		
		try {
			FileInputStream input=new FileInputStream(file);
		prop=new Properties();
		prop.load(input);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public String url() {
		return prop.getProperty("url");
	}
	
	public String text_file() {
		return prop.getProperty("TextFile");
	}
	
	public String browser() {
		return prop.getProperty("Browser");
	}
	
	public String username() {
		return prop.getProperty("email");
	}
	
	public String userassword() {
		return prop.getProperty("password");
	}
	
	
}
