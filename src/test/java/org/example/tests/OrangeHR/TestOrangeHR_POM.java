package org.example.tests.OrangeHR;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Base.CommonToAllPages;
import org.example.driver.DriverManager;
import org.example.pageObjectModel.orangehr.DashBoardPage_POM_OHR;
import org.example.pageObjectModel.orangehr.LoginPage_POM_OHR;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestOrangeHR_POM extends CommonToAllPages {

    @Owner("omsfuke")
    @Description("Verify that the login to the OrangeeHR ")
    @Test
    public void testLoginPositive() {
        LoginPage_POM_OHR loginPagePomOhr = new LoginPage_POM_OHR(DriverManager.getDriver());
        loginPagePomOhr.loginToHRCreds(PropertiesReader.readKey("ohr_username"), PropertiesReader.readKey("ohr_password"));


        DashBoardPage_POM_OHR dashboardPagePom = new DashBoardPage_POM_OHR(DriverManager.getDriver());
        String loggedInUserName = dashboardPagePom.loggedInUserName();

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName, PropertiesReader.readKey("ohr_expected_username"));



    }
}
