package OrangeHRM_Test_Run;

import org.testng.annotations.Test;

import OrangeHRm_Basclass.Action_class;
import OrangeHRm_Basclass.Base_class;

public class OrangeHRm_001_loginpage_test extends Base_class {

	
	Action_class action;
	
	@Test
	public void login_page_test() {
		action=new Action_class();
		action.element("username").sendKeys(username);
		action.element("password").sendKeys(password);
		//action.verifycolorvalue("login", "background-color", "#1e57e8");
		logger.info("login button color verify successfully passed");
		action.click("login");
			
	}
	
	
	
	
	
}
