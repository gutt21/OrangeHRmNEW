package OrangeHRM_Test_Run;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import OrangeHRm_Basclass.Action_class;
import OrangeHRm_Basclass.Base_class;

public class OrangeHRm_001_Myinfo extends Base_class {



	

	@Test
	public void MYI_01_Personal_details() {
		login.login_page_test();
		action.click("Myinfo");
		action.sendkeys("EmployeeFullName","First Name","akash");
		action.hardwait(2000);
		action.sendkeys("EmployeeFullName","Middle Name","asg");
		action.hardwait(2000);
		action.sendkeys("EmployeeFullName","Last Name","guttedar");
		action.hardwait(2000);
		action.sendkeys("EmployeeId","974959");
		action.sendkeys("OtherId","886699");
		action.sendkeys("driverlicense","98756948974");
		action.click("MarialStatus");
		action.hardwait(2000);
		action.click("MaritalStatusselect","Married");
		action.click("FileAttachement");
		action.click("browderfile");
		action.uploadfilebyrobot("C:\\Users\\akash\\Downloads\\Sneha_Test Automation_Jan16th2023.docx");
		action.hardwait(3000);
		action.click("FileSave");

	}


	@Test
	public void MYI_02_Contact_Details() {
		//login.login_page_test();
		//action.click("Myinfo");
		action.hardwait(3000);
		action.MoveToElement("ContactDetails");
		action.clickbyjavaScript("ContactDetails");
		action.sendkeys("Address", "Street 1", RandomString(10));
		action.sendkeys("Address", "Street 2", RandomString(10));
		action.sendkeys("Address", "City", RandomString(10));
		action.sendkeys("Address", "State/Province", RandomString(10));
		action.sendkeys("Address", "Zip/Postal Code", RandomString(10));
		action.click("country");
		action.click("countrydrop", "India");
		action.sendkeys("Telephone", "Home", Randomnumerical(10));
		action.sendkeys("Telephone", "Mobile",Randomnumerical(10));
		action.sendkeys("Telephone", "Work",Randomnumerical(10));
		action.sendkeys("Email", "Other Email", RandomString(10)+"@gamil.com");
		action.click("Save");


	}

	@Test
	public void MYI_03_Emergency_Contacts() {
		action.hardwait(3000);
		action.MoveToElement("EmergencyContacts");
		action.clickbyjavaScript("EmergencyContacts");
		action.hardwait(1000);
		action.click("ECAdd");
		String name=RandomString(12);
		action.sendkeys("SaveEmergencyContact", "Name", name);
		action.sendkeys("SaveEmergencyContact", "Relationship", RandomString(12));
		action.sendkeys("SaveEmergencyContact", "Home Telephone", Randomnumerical(10));
		action.sendkeys("SaveEmergencyContact", "Mobile", Randomnumerical(10));
		action.sendkeys("SaveEmergencyContact", "Work Telephone", Randomnumerical(10));
		action.click("ECSave");
		List<WebElement>elements=action.elements("RecordsFound");
		for(WebElement element:elements) {
			String elementname=element.getText();
			if(elementname.equals(name)) {
				action.click("boxcheck", name);
				action.hardwait(2000);
				action.click("Delete", name);
				action.hardwait(3000);
				action.click("YesDelete");
				break;
			}else {

			}


		}


	}


	@Test
	public void MYI_04_Dependents() {
		action.hardwait(3000);
		action.MoveToElement("Dependents");
		action.clickbyjavaScript("Dependents");
		action.hardwait(1000);
		action.click("DPAdd");
		String name=RandomString(10);
		action.sendkeys("AddDependent", "Name",name);
		action.click("Relationship");
		action.click("Relationshipdrop", "Other");
		action.sendkeys("AddDependent", "Please Specify",RandomString(6));
		action.sendkeys("AddDependent", "Date of Birth","2023-01-25");
		action.click("DpSave");
		List<WebElement>elements=action.elements("RecordsFound");
		for(WebElement element:elements) {
			String elementname=element.getText();
			if(elementname.equals(name)) {
				action.click("boxcheck", name);
				action.hardwait(2000);
				action.click("Delete", name);
				action.hardwait(3000);
				action.click("YesDelete");
				break;
			}else {

			}

		}

	}


	@Test
	public void MYI_05_Immigration_passport() {
		action.hardwait(3000);
		action.MoveToElement("Immigration");
		action.clickbyjavaScript("Immigration");
		action.hardwait(1000);
		action.click("IMAdd");
		String name=RandomString(10);
		action.sendkeys("Passport", "Number",name);
		action.sendkeys("Passport", "Issued Date","2023-01-25");
		action.sendkeys("Passport", "Expiry Date","2025-01-25");
		action.sendkeys("Passport", "Eligible Status","passed");
		action.click("PassportIssuedBy");
		action.click("PassportIssuedByDrop", "India");
		action.sendkeys("Passport", "Eligible Review Date","2023-01-30");
		action.sendkeys("passportComment","Successfully passed test case ");
		action.click("IMSave");
	}

	@Test
	public void MYI_06_Immigration_vice() {
		action.hardwait(3000);
		action.MoveToElement("Immigration");
		action.clickbyjavaScript("Immigration");
		action.hardwait(1000);
		action.click("IMAdd");
		action.click("visa");
		String name=RandomString(10);
		action.sendkeys("Passport", "Number",name);
		action.sendkeys("Passport", "Issued Date","2023-01-25");
		action.sendkeys("Passport", "Expiry Date","2025-01-25");
		action.sendkeys("Passport", "Eligible Status","passed");
		action.click("PassportIssuedBy");
		action.click("PassportIssuedByDrop", "India");
		action.sendkeys("Passport", "Eligible Review Date","2023-01-30");
		action.sendkeys("passportComment","Successfully passed test case ");
		action.click("IMSave");
	}



}
