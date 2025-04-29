package tests1;

import Actions.fileActions;
import Actions.textFile;
import Base1.BaseTest;
import Pages1.loginPage;
import Utils1.ExtentReportmanager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class loginTest  extends BaseTest {


    @Test

    public void testvalidlogin(){
        test= ExtentReportmanager.createTest("testvalidlogin");
        loginPage lp = new loginPage(driver);
        test.info("Enter username and password");
        lp.enterUserName("Chaitanya");
        lp.enterPassword("Annu");
        lp.clickLogin();
        Assert.assertEquals(driver.getTitle(),"Dashboard");
    }


    @Test
    public void folderTest(){
        String folderPath = "C:\\IntelliChaitanya";
        textFile.createFolder(folderPath);
        test.info("Folder Creation");

    }
    @Test
    public void renameTest(){
        String oldPath = "C:\\IntelliChaitanya";
        String newPath = "C:\\IntelliChaitanyaAnnu";
        boolean folderExits = textFile.checkFolderExits(oldPath);
        test.info("folderExits " + folderExits);
        textFile.renamefolder(oldPath, newPath);
        test.info("new folder path is created " + oldPath + newPath);
    }
   @Test
    public  void deleteTest(){
        String path = "C:\\IntelliChaitanya";
        textFile.deleteFolder(path);
    }

    @Test
    public void createTextFile() throws IOException {
        String pathFile = "C:\\Selenium\\ChaitanyaFile.txt";
        fileActions.createFile(pathFile);
        //test.info("File Created sucessfully " + pathFile);
    }

    @Test
    public void writeFile() throws IOException {
        String pathFile = "C:\\Selenium\\ChaitanyaFile.txt";
        fileActions.fileWriter(pathFile);
    }

    @Test
    public void readTheData() throws FileNotFoundException {
        String pathFile = "C:\\Selenium\\ChaitanyaFile.txt";
        fileActions.readFile(pathFile);
    }
}
