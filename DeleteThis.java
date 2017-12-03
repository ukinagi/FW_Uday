package generic;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DeleteThis {

	public static void main(String[] args) throws IOException {
		/*java.util.Date d=new java.util.Date();
		System.out.println(d);
		SimpleDateFormat s=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		String strDate=s.format(d);
		System.out.println(strDate);
		
*/
    
		//create extent reports
		ExtentReports e=new ExtentReports();
		
		//create extent report type and attach it to ExtentReport
		ExtentHtmlReporter h=new ExtentHtmlReporter("./res/Report.html");
		
		e.attachReporter(h);
		//create test and say Pass/Fail
		
		ExtentTest test = e.createTest("ValidLogin");
		
		test.pass("This test is pass");
		
		//create test and say Pass/Fail
		
ExtentTest test2 = e.createTest("InValidLogin");
		
		test.pass("This test is pass");
		
		test2.info("here we hav diff methods like v hv in log4j");
		test2.warning("waring msg...loke log4j");
		test.fail("this test is failed...");
		
		File f=new File("./photo/ForFailure/Sheet1_15_11_17_02_48_15.png");
		String p = f.getAbsolutePath();
		test2.addScreenCaptureFromPath(p);
		
		//Finally publish the report
		e.flush();
		
		
		
		
	}

}
