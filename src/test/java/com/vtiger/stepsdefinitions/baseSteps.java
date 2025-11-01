package com.vtiger.stepsdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class baseSteps {

    public static String  TCName;
    public static Map<String,Map<String,String>> dt;
    public static  Properties prop;
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static LeadPage leadPage;

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;





    public void initConfig()
    {
        getdata();
        createExtentReport();

        prop = new Properties();
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config.properties");
            prop.load(file);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }


    public void createExtentReport()
    {
        //report_13042025104034.html
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport_"+fileName+".html");
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Automation Test Hub");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("User Name", "Rajesh U");
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here ");
        // Name of the report
        htmlReporter.config().setReportName("Name of the Report Comes here ");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);

    }




    public void getdata()
    {
        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(System.getProperty("user.dir")+"/src/test/resources/Data/testdata.xlsx");
            String strQuery = "Select * from Sheet1";
            Recordset recordset = connection.executeQuery(strQuery);
            List<String> lst = recordset.getFieldNames();
            dt = new HashMap<>();

            while (recordset.next()) {
                Map<String,String> m = new HashMap<>();

                for(int i=0;i<lst.size();i++)
                {
                    String columname = lst.get(i);
                    String columnvalue = recordset.getField(columname).trim();
                    m.put(columname,columnvalue);
                }

                dt.put(m.get("TCName"),m);


            }
            System.out.println(dt);
            recordset.close();
            connection.close();
        }
        catch (Exception e)
        {
            System.out.println("Failed to get data due to error "+e.getMessage());
        }
    }
}
