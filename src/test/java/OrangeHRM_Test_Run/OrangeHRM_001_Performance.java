package OrangeHRM_Test_Run;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import OrangeHRm_Basclass.Base_class;

public class OrangeHRM_001_Performance extends Base_class{

	
	@Test
	public void PEM_001_Configure_Kpis() {
		login.login_page_test();
		action.click("Performance");
	    action.hardwait(2000);
	    action.click("Configure");
	    action.click("ConfigureDropdown", "KPIs");
	    action.click("KpisAdd");
	    String name=RandomString(10);
	    System.out.println(name);
	    action.sendkeys("KeyPerformanceIndicator", "Key Performance Indicator",name );
        action.click("JobTitleIcon", "Job Title");
	    action.click("Jobtitledropdown", "Head of Support");
	    //action.sendkeys("KeyPerformanceIndicator", "Minimum Rating", Randomnumerical(2));
	   // action.sendkeys("KeyPerformanceIndicator", "Maximum Rating", Randomnumerical(2));
	    action.click("MakeDefaultSwitch");
	    action.click("KpiSave");
	    //action.MoveToElement("JobTitleIcon", "Job Title");
	   // action.clickbyjavaScript("JobTitleIcon", "Job Title");
	   // action.click("Jobtitledropdown", "Head of Support");
	  //  action.click("Kpisearch");
	    List<WebElement>elements=action.elements("RecordsFound","Key Performance Indicator");
		for(WebElement element:elements) {
			//action.hardwait(1000);
			String elementname=element.getText();
			if(elementname.equals(name)) {
				action.MoveToElement("boxcheck",name);
				action.click("boxcheck", name);
				action.hardwait(2000);
				action.click("Delete", name);
				action.hardwait(3000);
				break;
			}else {

			}

		}

	    
	}
	
	@Test
	public void PEM_002_Configure_Trackers() {
		
		action.click("Configure");
	    action.click("ConfigureDropdown", "Trackers");
	    action.click("TrackerAdd");
	    action.sendkeys("TrackerPerfomance", "Tracker Name", RandomString(10));
	    action.sendkeys("TrackerPerfomance", "Employee Name", "Dipali");
	    action.hardwait(3000);
	    action.ListElementsclickspecificvalue("autosuggestion", "Dipali");
	    action.sendkeys("TrackerPerfomance", "Reviewers", "Dipali");
	    action.hardwait(3000);
	    action.ListElementsclickspecificvalue("autosuggestion", "Dipali");
	    action.click("Trackersave");
	    
	}
	
	
}
