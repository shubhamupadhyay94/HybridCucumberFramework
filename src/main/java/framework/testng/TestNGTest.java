package framework.testng;


import io.cucumber.java.it.Data;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class TestNGTest {


    @Parameters({"Data1","Data2"})
    @Test(priority=1,retryAnalyzer = RetryTest.class)
    void test1( String Data1,String data) {
        System.out.println("name---" + Data1 +"----surname---" + data);
        Assert.assertEquals(true,false);
    }

    @DataProvider(name="creds")
    public Object[][] testData(){
    return new Object[][]{
            {"Test1", "Pass1"},
            {"Test2", "Pass2"}

    };
    }

    @Test(dataProvider = "creds",    priority=0)
    void test2(String n1, String n2) {

        System.out.println("n1----" + n1 +"------n2-----" +n2);
        Assert.assertEquals(n1,n2);
    }


//    @BeforeSuite
//    void test5() {
//        System.out.println("BeforeSuite");
//    }
//
//    @BeforeTest
//    void test6() {
//        System.out.println("BeforeTest");
//    }
//
//    @BeforeClass
//    void test7() {
//        System.out.println("BeforeClass");
//    }

    @BeforeMethod
    void test8() {
        System.out.println("BeforeMethod===========");
    }

//    @AfterSuite
//    void AfterSuite() {
//        System.out.println("AfterSuite");
//    }
//
    @AfterMethod
    void AfterMethod() {
        System.out.println("AfterMethod=============");
    }

//    @AfterTest
//    void AfterTest() {
//        System.out.println("AfterTest");
//    }
//
//    @AfterClass
//    void AfterClass() {
//        System.out.println("AfterClass");
//    }


}
