package com.vtiger.pages;

import com.vtiger.stepsdefinitions.baseSteps;
import com.vtiger.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {

    private WebDriver driver;

    public LeadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        CommonMethods cm = new CommonMethods(driver);
    }

    @FindBy(name="lastname")
    private WebElement tb_lastname;

    @FindBy(xpath="//input[@name='company']")
    private WebElement tb_company;

    @FindBy(name="button")
    private WebElement btn_save;


    public void createlead(String lname, String company)
    {
        setLastName(lname);
        setCompany(company);
        baseSteps.logger.info("capture screenshot "+CommonMethods.getScreenshot());
        clickSave();
    }


    public void setLastName(String lname)
    {

        CommonMethods.setText(tb_lastname, lname, lname+" is set successfully in lastname field");
    }

    public void setCompany(String company)
    {
       CommonMethods.setText(tb_company, company, company+" is set successfully in company field");
    }

    public void clickSave()
    {
        CommonMethods.clickElement(btn_save, "Save button clicked successfully");
    }

}
