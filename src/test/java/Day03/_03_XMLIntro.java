package Day03;

import org.testng.annotations.*;

public class _03_XMLIntro {

    //@BeforeSuit --> Runs before each suit tag in xml file
        //@BeforeTest --> Runs before each test tag in xml file
            //@BeforeGroup Runs before each group --> It can affect multiple classes
                //@BeforeClass Runs before everything in the class
                    //@BeforeMethod Runs before each test method
                        //@Test we write our test methods
                        //@Test
                    //@AfterMethod Runs after each test method
                //@AfterClass Runs after everything in the class
            //@AfterGroup Runs after each group --> It can affect multiple classes
        //@AfterTest --> Runs after each test tag in xml file
    //AfterSuit --> Runs after each suit tag in xml file

    @BeforeSuite
    void beforeSuit(){
        System.out.println("Before Suit is running");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test is running");
    }


    @BeforeClass
    void beforeClass(){
        System.out.println("Before Class is running");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before Method is running");
    }

    @Test
    void test1(){
        System.out.println("Test 1 from class 1 is running");
    }

    @Test
    void test2(){
        System.out.println("Test 2 from class 1 is running");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("After Method is running");
    }

    @AfterClass
    void afterClass(){
        System.out.println("After Class is running");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test is running");
    }

    @AfterSuite
    void afterSuit(){
        System.out.println("After Suit is running");
    }
}
