package com.vtiger.stepsdefinitions;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import com.vtiger.utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class loginsteps extends baseSteps {

    @Before
    public void initiation(Scenario scenario)
    {
        if(prop==null) {
            initConfig();
        }
        TCName = scenario.getName();
        System.out.println(TCName);
        logger = extent.createTest(TCName);
    }

    @After
    public void tearDown()
    {
        extent.flush();
        driver.quit();
    }



    @Given("user should be on login page")
    public void user_should_be_on_login_page() {
        if(prop.getProperty("browser").equals("chrome")) {
            driver = new ChromeDriver();
        }else if(prop.getProperty("browser").equals("firefox")) {
            driver = new FirefoxDriver();
        }else if(prop.getProperty("browser").equals("edge")) {
            driver = new EdgeDriver();
        }else if(prop.getProperty("browser").equals("headless")) {
           // driver = new ChromeDriver();
        }
        logger.info(prop.getProperty("browser")+" Browser is opened successfully");
        driver.get(prop.getProperty("url"));
        logger.info(prop.getProperty("url")+" URL is opened successfully "+ CommonMethods.getScreenshot());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        leadPage = new LeadPage(driver);
    }



    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.login(dt.get(TCName).get("userid"), dt.get(TCName).get("password"));
    }


    @Then("close browser")
    public void close_browser() {
      driver.quit();
    }

    @Then("user should navigated to home page")
    public void user_should_navigated_to_home_page() {

        homePage.verifyHome();
    }


    @Then("user can see the logout option")
    public void user_can_see_the_logout_option() {
        homePage.verifyLogout();
    }


    @When("user enters invalid credentials")
    public void user_enters_invalid_credentials() {
        loginPage.login(dt.get(TCName).get("userid"), dt.get(TCName).get("password"));

    }
    @Then("user should navigated to login page")
    public void user_should_navigated_to_login_page() {
        loginPage.verifyUsername();
    }
    @Then("user can see the error message")
    public void user_can_see_the_error_message() {
        loginPage.verifyErrorMsg();
    }


    @When("user enters invalid credentials userid as {string} and password as {string}")
    public void user_enters_invalid_credentials_userid_as_and_password_as(String uid, String pwd) {
        loginPage.login(uid, pwd);

    }






}
