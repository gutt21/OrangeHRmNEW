package OrangeHRm_Basclass;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.compress.harmony.pack200.NewAttributeBands.Integral;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import OrangeHRM_Test_Run.OrangeHRm_001_loginpage_test;
import OrangeHRM_Utilities.Text_page_Reader_Class;
import OrangeHRM_Utilities.config_read;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {

	//Text_page_Reader_Class text=new Text_page_Reader_Class();
	static config_read read=new config_read();
	
	String Url=read.url();
	public static String textfile=read.text_file();
	public static WebDriver driver;
	public static Logger logger;
	String browsername=read.browser();
	public String username=read.username();
	public String password=read.userassword();
	
    public static Action_class action=new Action_class();
    public static OrangeHRm_001_loginpage_test login=new OrangeHRm_001_loginpage_test();
	
    
    
    
	@BeforeTest
	public void Set_up() {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
           WebDriverManager.edgedriver().setup();
           driver=new EdgeDriver();
		}
		else {
		
		System.out.println("Enter Invalide browsername");
			
		}
		
		logger=Logger.getLogger("OrangeHRM_Full__Test");
		PropertyConfigurator.configure("log4j.properties");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(Url);
	
	}
	
	
	
	
	
	//@AfterTest
	public void Tear_Down() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	
	
	
	public String RandomString(int alpnumber) {
		String name=RandomStringUtils.randomAlphabetic(alpnumber);
		return name;
		
	}
	
	
	public String Randomnumerical(int number) {
		if(number==2) {
		Random random=new Random();
		int value=random.nextInt(90)+10;
		String numbers=String.valueOf(value);
		return numbers;
		}else {
		String numbers=RandomStringUtils.randomNumeric(number);
		return numbers;
		}
	}
		
	
	
	
	
	
	
}
