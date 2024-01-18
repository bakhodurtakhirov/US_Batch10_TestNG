package Day06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _04_SoftAssert {

    // Assert.asser... is called hard assert
    @Test
    void hardAssertTest(){

        String name = "Paul";

        System.out.println("Before Assert");

        Assert.assertEquals(name, "John"); // Hard Assert
        // it throws an exception and stops running the rest of the code
        // then TestNG starts running the next test method

        System.out.println("After Assert");
    }

    @Test
    void softAssertTest(){
        String name = "Paul";

        System.out.println("Before Soft Assert");

        SoftAssert softAssert = new SoftAssert();
        // SoftAssert: If expected and actual results are different soft assert doesn't stop the execution of the code
        // it saves the errors in the memory until we use assertAll method.

        softAssert.assertEquals(name,"John");

        System.out.println("After Soft Assert");

        System.out.println("Before Soft Assert");

        int num1 = 3;
        int num2 = 45;

        softAssert.assertEquals(num1,num2);
        System.out.println("After Soft Assert");

        softAssert.assertAll();

        // if the rest of the test depends on the value you are testing use hard assert because the rest of the code will not run correctly without that value
        // If the value you are testing is not important for the rest of the test use soft assert
    }

}
