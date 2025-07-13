package Base1;

import Utils1.ExtentReportmanager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setUpReport(){
       extent= ExtentReportmanager.getReportInstance();
    }

    @AfterSuite
    public void teardownReport(){
      extent.flush();
    }

   @BeforeMethod
    public void setUp(){
         log.info("Starting Webdriver");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         log.info("Open OrangeHRM WebSite ");
         driver.get("https://support.orangehrm.com/portal/en/signin");
         driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

    }

    private static ThreadLocal<WebDriver> driver1 =
            new ThreadLocal<>();

    @AfterMethod
    public void tearDown(ITestResult result){
       log.info("Closing the browser");
       if (result.getStatus()==ITestResult.FAILURE){
           String screenshotPath=ExtentReportmanager.captureScreenshot(driver,"LoginFailure");
           test.fail("Test Failed Screenshot attached", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

       }

       if(driver!=null){
           driver.quit();
       }

    }


}
