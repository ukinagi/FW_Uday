package executor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import generic.Excel;
import generic.Property;
import generic.Screenshot;

public class Driver implements IAutoConst {
	

public static Logger log=Logger.getLogger("Driver");
public static int pCount=0,fCount=0,tCount=0;
public static WebDriver driver;

static {
   	
   	log.info("set path of driver execuatble");
	 System.setProperty(CHROME_KEY,CHROME_VALUE);
}
public static void executeScript(String scriptName)
{
	log.info("open Chrome browser");
	driver=new ChromeDriver();
    String sITO=Property.getValue(SETTINGS_PATH,"ITO");
    long ITO=Long.parseLong(sITO);
    log.info("Set ITO:"+ITO+"Sec");
    driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
    String url=Property.getValue(SETTINGS_PATH,"URL");
	log.info("Ener the url:"+url);
	driver.get(url);
	log.info("Executing script:"+scriptName);
	
	Steps.executeSteps(log, driver,SCRIPT_PATH,scriptName);

	}
	
	
	

public static void executeSuite()
{
    ExtentReports extent=new ExtentReports();
    ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(EXTENT_REPORT_PATH);
    extent.attachReporter(htmlReport);
	int scriptCount=Excel.getRowCount(SUITE_PATH,SUITE_SHEET);
	log.info("ScriptCount:"+scriptCount);
	for(int j=1;j<=scriptCount;j++){
		
		String scriptName=Excel.getCellValue(SUITE_PATH,SUITE_SHEET, j, 0);
		ExtentTest test=extent.createTest(scriptName);
		String scriptStatus=Excel.getCellValue(SUITE_PATH,SUITE_SHEET, j, 1);
		log.info("Script:"+scriptName+"Execute:"+scriptStatus);
		if(scriptStatus.equalsIgnoreCase("yes")){
			try{
			executeScript(scriptName);
			log.info("Script is PASSED"+scriptName);
			pCount++;
			test.pass("Script is passed");
			}
			catch(Exception e)
			{
				log.error("Script is Failed:"+scriptName);
				fCount++;
				e.printStackTrace();
				String imgName=Screenshot.generateImageName();
				String imgPath=FAIL_PHOTO_PATH+"/"+scriptName+"_"+imgName;;
				log.info("Taking Screenshot:"+imgPath);
				Screenshot.get(driver, imgPath);
				test.fail("Script is failed");
				String aImagePath=new File(imgPath).getAbsolutePath();
				try{
					test.addScreenCaptureFromPath(aImagePath);
				}catch(Exception e1)
				{
					
				}
			}
			finally{
				driver.quit();
				log.info("Quit the browser");
			}
			}
		else{
			log.info("NOT EXECUTING SCRIPT"+scriptName);
			test.skip("Not Executing script....");
			
		}
	}
	
	log.info("------------------------------------------------------------------");
	log.info("Total PASS:"+pCount);
	log.info("Total failed:"+fCount);
	tCount=pCount+fCount;
	log.info("Total scripts executed:"+tCount);
	log.info("-------------------------------------------------------------------");
	extent.flush();
}

	public static void main(String[] args){
		log.info("Suite Execution Started");
		executeSuite();
		log.info("Suite Execution Completed");		
		
		}	
		

	}


