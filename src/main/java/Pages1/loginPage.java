package Pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

    private WebDriver driver;

    private By userName=By.xpath("//input[@placeholder='Email Address']");
    private By password=By.xpath("//input[@placeholder='Password']");
    private By login =By.xpath("//input[@type='submit']");

    public loginPage(WebDriver driver){
    this.driver=driver;
    }

    public void enterUserName(String UserNameField){
        driver.findElement(userName).sendKeys(UserNameField);
    }

    public void enterPassword(String passwordField){
        driver.findElement(password).sendKeys(passwordField);
    }

    public void clickLogin(){
        driver.findElement(login).click();
    }


}
