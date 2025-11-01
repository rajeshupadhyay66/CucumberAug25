package com.vtiger.pages;

import com.vtiger.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        CommonMethods cm = new CommonMethods(driver);
    }

    @FindBy(linkText="New Lead")
    private WebElement lnk_NewLead;

    @FindBy(linkText="Leads")
    private WebElement lnk_Leads;

    @FindBy(linkText="Logout")
    private WebElement lnk_logout;

    @FindBy(linkText="Home")
    private WebElement lnk_Home;


   public void clickOnNewLead()
   {

       CommonMethods.clickElement(lnk_NewLead, "New Lead clicked successfully");
   }

   public void clickOnLeads()
   {

       CommonMethods.clickElement(lnk_Leads, "Leads clicked successfully");
   }

   public void clickOnLogout()
   {

       CommonMethods.clickElement(lnk_logout, "Logout clicked successfully");
   }

   public void clickOnHome()
   {

       CommonMethods.clickElement(lnk_Home, "Home clicked successfully");
   }

   public void verifyLogout()
   {

       CommonMethods.verifyElement(lnk_logout, "Logout is verified successfully");
   }

   public void verifyHome()
   {

       CommonMethods.verifyElement(lnk_Home, "Home is verified successfully");
   }

   public void verifyLeads()
   {
       CommonMethods.verifyElement(lnk_Leads, "Leads is verified successfully");

   }

   public void verifyNewLead()
   {
       CommonMethods.verifyElement(lnk_NewLead, "New Lead is verified successfully");
   }


}
