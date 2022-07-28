package tests.testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGHooks01 {



    @BeforeMethod
    public void beforeMethod(){

    }

    @Test(priority = 2, dependsOnMethods = {"testSth01"})
    public void testSth01(){

    }

    @Test(priority = 1, dependsOnMethods = {"testSth01"})
    public void testSth02(){

    }

    @Test()
    public void testSth03(){
        Assert.assertEquals("","","");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("a","b");
        softAssert.assertTrue(false);
        softAssert.assertFalse(true);
        softAssert.assertAll();
    }
}
