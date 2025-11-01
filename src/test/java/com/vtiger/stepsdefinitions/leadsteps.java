package com.vtiger.stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class leadsteps extends baseSteps {




    @Given("user need to click on new lead link and fill the mandatory fields and save")
    public void user_need_to_click_on_new_lead_link_and_fill_the_mandatory_fields_and_save(io.cucumber.datatable.DataTable dataTable) {
       List<Map<String,String>> dt = dataTable.asMaps(String.class, String.class);
       for(int i=0;i<dt.size();i++)
       {

           homePage.clickOnNewLead();
           leadPage.createlead(dt.get(i).get("lastname"), dt.get(i).get("company"));

       }
    }
    @Then("click on logout and close the browser")
    public void click_on_logout_and_close_the_browser() {
        homePage.clickOnLogout();
        driver.quit();
    }

    @When("user need to click on new lead link and enters the mandatory fields and save")
    public void createlead() {
        homePage.clickOnNewLead();
        leadPage.createlead(dt.get(TCName).get("lastname"), dt.get(TCName).get("company"));

    }
}
