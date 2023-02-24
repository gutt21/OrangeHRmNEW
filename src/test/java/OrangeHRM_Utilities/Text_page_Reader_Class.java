package OrangeHRM_Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import OrangeHRm_Basclass.Base_class;

public class Text_page_Reader_Class extends Base_class{

	
	
      
	
	
	public static String []  text_read_test(String elementname) {
		
		
		String path=".\\text\\"+textfile;
		
		String match="";
		
		try {
			
			FileReader read=new FileReader(path);
			BufferedReader file=new BufferedReader(read);
		    String line=file.readLine();
	   
			while(line !=null) {
				
				if(line.split(":", 3)[0].equalsIgnoreCase(elementname)) {
					match=line;
					break;
					
				}
				
				line=file.readLine();
				
			}
		    
		    
		    
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		if(match.equals("")) {
			try {
	      	File file =new 	File(path);
	      	
	      	if(!file.exists()) {
	      		System.out.println("txt file not found");
	      	}
	      	else {
	      		FileReader read=new FileReader(path);
				BufferedReader file2=new BufferedReader(read);		
				String line=file2.readLine();


				while(line !=null) {
					if(line.split(":",3)[0].equalsIgnoreCase(elementname)) {
						match=line;
						break;
					}
					line=file2.readLine();
				}
	      	}
	      	
	      	Assert.assertTrue(!match.equals(""), 
					"locater name "+elementname+" is not presnt in txt file");
	      	
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return match.split(":",3);
		
	}
	
	
	
	
	
	
}
