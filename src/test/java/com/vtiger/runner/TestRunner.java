package com.vtiger.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(


        features="src/test/resources/Features/"
        ,glue="com.vtiger.stepsdefinitions"
        ,dryRun = false
        ,plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"}
        ,tags="@ab"
        ,monochrome = false





)
public class TestRunner extends AbstractTestNGCucumberTests {
}
