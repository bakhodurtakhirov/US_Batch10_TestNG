package Day04;

import org.testng.annotations.Test;

public class _02_Groups2 {

    @Test(groups = "Smoke")
    void test1(){
        System.out.println("Test 1 from groups 2 is running");
    }

    @Test(groups = "Regression")
    void test2(){
        System.out.println("Test 2 from groups 2 is running");
    }
}
