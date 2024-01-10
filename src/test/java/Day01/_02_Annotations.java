package Day01;

import org.testng.annotations.*;

public class _02_Annotations {

    // @BeforeClass -> This code is run before everything in a class. It is a class level annotation. It has no effects on other classes
        // @BeforeMethod -> This code is run before all your @Test annotations(Before your tests). It is a method level annotation. It can affect only @Test annotations
            // @Test -> to write our tests
            // @Test -> to write our tests
        // @AfterMethod -> This code is run after all your @Test annotations(After your tests). It is a method level annotation. It can affect only @Test annotations
    // @AfterClass -> This code is run after everything in a class. It is a class level annotation. It has no effects on other classes

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class is running");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method is running");
    }

    @Test
    void test1(){
        System.out.println("Test 1 is running");
    }

    @Test
    void test2(){
        System.out.println("Test 2 is running");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method is running");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class is running");
    }


}
