package org.example.tests.vwoLogin.pagefactory_TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonToAllTets;
import org.example.listeners.RetryAnalyser;
import org.example.pages.pagefactory.LoginPage_PF;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.DriverManager;

@Test(retryAnalyzer = RetryAnalyser.class)
public class TestVWOLogin_PF extends CommonToAllTets {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);

    @Test
    public void testLoginNegativeVWO_PF() {

        logger.info("Starting the Testcases Page Factory");


        WebDriver driver = DriverManager.getDriver();
        driver.get(PropertiesReader.readKey("url"));
        LoginPage_PF loginPage_PF = new LoginPage_PF(driver);
        String error_msg = loginPage_PF.loginToVWOInvalidCreds();
        logger.info("End of the Testcase!!");

        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));



    }



}
