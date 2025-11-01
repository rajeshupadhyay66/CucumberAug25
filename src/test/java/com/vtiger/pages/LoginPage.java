package com.vtiger.pages;

import com.vtiger.stepsdefinitions.baseSteps;
import com.vtiger.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        CommonMethods cm = new CommonMethods(driver);

    }

   /*
    String tb_username = "user_name";
    String tb_password = "user_password";
    String btn_login = "Login";



    By tb_username = By.name("user_name");
    By tb_password = By.name("user_password");
    By btn_login = By.name("Login");

    */

    @FindBy(name="user_name")
    private WebElement tb_username;

    @FindBy(xpath="//input[@name='user_password']")
    private WebElement tb_password;

    @FindBy(name="Login")
    private WebElement btn_login;

    @FindBy(xpath="//*[contains(text(),'1234You must specify a valid username and password.')]")
    private WebElement errorMsg;

    @FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']")
    private WebElement logo;



    public void login(String uid, String pwd) {
        setUsername(uid);
        setPassword(pwd);

        baseSteps.logger.info("capture screenshot "+CommonMethods.getScreenshot());

        clickLogin();
    }

    public void setUsername(String uid)
    {
        CommonMethods.setText(tb_username, uid, uid+" is set successfully");
    }

    public void setPassword(String pwd)
    {
       CommonMethods.setText(tb_password, pwd, pwd+" is set successfully");
    }

    public void clickLogin()
    {
       CommonMethods.clickElement(btn_login, "Login button clicked successfully");
    }

    public void verifyUsername()
    {
        CommonMethods.verifyElement(tb_username, "Username is verified successfully");
    }

    public void verifylogo()
    {
        CommonMethods.verifyElement(logo, "Logo is verified successfully");
    }

    public void verifyErrorMsg()
    {
        CommonMethods.verifyElement(errorMsg, "Error message is verified successfully");
    }



}