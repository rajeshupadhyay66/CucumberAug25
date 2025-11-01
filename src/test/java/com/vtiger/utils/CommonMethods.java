package com.vtiger.utils;

import com.vtiger.stepsdefinitions.baseSteps;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods {

    private static WebDriver driver;
    private static WebDriverWait wait ;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public static void setText(WebElement elm,String value, String msg)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(value);
            System.out.println(msg);
            baseSteps.logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println("Failed to set text due to error "+e.getMessage());
            //capture screenshot
            baseSteps.logger.fail("Failed to set text due to error "+e.getMessage()+getScreenshot());
        }
    }

    public static void clickElement(WebElement elm, String msg)
    {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.click();
            System.out.println(msg);
            baseSteps.logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println("Failed to click element due to error "+e.getMessage());
            //capture screenshot
            baseSteps.logger.fail("Failed to click element due to error "+e.getMessage()+getScreenshot());
        }
    }

    public static void verifyElement(WebElement elm, String msg)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
            System.out.println(msg);
            baseSteps.logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println("Failed to verify element due to error "+e.getMessage());
            //capture screenshot
            baseSteps.logger.fail("Failed to verify element due to error "+e.getMessage()+getScreenshot());
        }
    }

    public static String getScreenshot()
    {
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        String path = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png";
        TakesScreenshot ts = ((TakesScreenshot)baseSteps.driver);
        File SrcFile=ts.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(path);
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String imagepath = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='"+path+"'><span class='label time-taken grey lighten-1 white-text'>Screenshot</span><a>";
        return imagepath;
    }



}