package utility;
import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
public static ExtentReports getInstance() {
		
		Date date = new Date();		
		
		String originalDateFormat = date.toString();
		
		String modifiedDateFormat = originalDateFormat.replace(":","_").replace(" ","_");

		String FileName = modifiedDateFormat+".html";
		
		String FilePath = "E:\\Regression_Automation_Suite\\OnlineStore_Replica\\OnlineStore\\src\\Reports"+FileName;
		
		ExtentReports report = new ExtentReports(FilePath, true, DisplayOrder.NEWEST_FIRST);
		
		report.loadConfig(new File("ReportsConfig.xml"));

		report.addSystemInfo("Selenium Version", "4.0.0-alpha-7").addSystemInfo(
				"Environment", "QA");
		
		return report;
		
	}
}
