package Day01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Assertions {

    @Test
    void test1(){
        String str1 = "John";
        String str2 = "John";

        Assert.assertEquals(str1,str2, "Test is failed");
        // Checks if actual and expected are the same. If they are not the same it throws an exception
        // then prints the message
    }

    @Test
    void test2(){
        String str1 = "John";
        String str2 = "Snow";

        Assert.assertEquals(str1,str2,"Test is not successful");
        // Checks if actual and expected are the same. If they are not the same it throws an exception
        // then prints the message
    }

    @Test
    void test3(){
        int num1 = 5;
        int num2 = 7;

        Assert.assertNotEquals(num1,num2,"Test is not successful");
        // Checks if actual and expected are different. If they are not different test is not successful
        // It throws an exception and prints the message
    }

    @Test
    void test4(){
        int num1 = 7;
        int num2 = 7;

        Assert.assertNotEquals(num1,num2,"Test is not successful");
        // Checks if actual and expected are different. If they are not different test is not successful
        // It throws an exception and prints the message
    }

    @Test
    void test5(){
        int num1 = 23;
        int num2 = 23;

        Assert.assertTrue(num1==num2, "Test is not successful");
        // Checks if the result of the condition is true.
        // If it is not true throws an exception and prints the message
    }

    @Test
    void test6(){
        int num1 = 23;
        int num2 = 2;

        Assert.assertTrue(num1==num2, "Test is not successful");
        // Checks if the result of the condition is true.
        // If it is not true throws an exception and prints the message
    }

    @Test
    void test7(){
        int num1 = 23;
        int num2 = 2;

        Assert.assertFalse(num1==num2, "Test is not successful");
        // Checks if the result of the condition is false.
        // If it is not false it throws an exception and prints the message
    }

    @Test
    void test8(){
        String str1 = null;
        String str2 = "John";

        Assert.assertNull(str1, "Test is not successful");
        Assert.assertNull(str2, "Test is not successful");
    }

    @Test
    void test9(){
        Assert.fail("Test is not successful");
        //Fails no matter what
    }

}
