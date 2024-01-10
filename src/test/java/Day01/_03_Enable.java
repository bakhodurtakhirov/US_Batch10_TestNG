package Day01;

import org.testng.annotations.Test;

public class _03_Enable {

    // if you use enabled = false TestNG will not run those tests and run the others
    // enabled = true is the default value. All @Test s have enabled = true by default. So you don't need to use it

    @Test
    void test1(){
        System.out.println("Test 1 is running");
    }

    @Test(enabled = true)
    void test2(){
        System.out.println("Test 2 is running");
    }

    @Test(enabled = false)
    void test3(){
        System.out.println("Test 3 is running");
    }

    @Test
    void test4(){
        System.out.println("Test 4 is running");
    }

    @Test(enabled = false)
    void test5(){
        System.out.println("Test 5 is running");
    }

}
