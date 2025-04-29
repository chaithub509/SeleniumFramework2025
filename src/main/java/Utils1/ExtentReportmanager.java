package Utils1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentReportmanager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());
            String report = "reports/ExtentReport_" + timestamp;
            ExtentSparkReporter exr = new ExtentSparkReporter((report));
            exr.config().setDocumentTitle("Chaitanya Automation Report");
            exr.config().setReportName("Orange HRM Automation Test Execution Report");
            extent = new ExtentReports();
            extent.attachReporter(exr);
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = getReportInstance().createTest(testName);
        return test;
    }

    public static String captureScreenshot(WebDriver driver, String screenShot) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path =System.getProperty("user.dir")+  "/screenshots/" + screenShot + ".png";
            FileUtils.copyFile(src,new File(path));
            return path;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
