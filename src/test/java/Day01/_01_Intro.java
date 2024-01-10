package Day01;

import org.testng.annotations.Test;

public class _01_Intro {

//    public static void main(String[] args) {
//        go to page
//        login
//        add to cart
//        check out
//    }

//   @Test
//   public void test(){
//      go to page
//      login
//      add to cart
//      check out
//   }


    // priority -> We can run our test in a specific order with priority. Smaller number means higher priority.
    // Without priority TestNG runs the tests in alphabetical order
    @Test(priority = 1)
    void goToPageTest(){
        System.out.println("Going to the page");
    }

    @Test(priority = 2)
    void loginTest(){
        System.out.println("Logging in");
    }

    @Test(priority = 2)
    void addToCartTest(){
        System.out.println("Adding the products to the cart");
    }

    @Test(priority = 4)
    void checkOutTest(){
        System.out.println("Checking out");
    }













}
