package Day02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Dependency {

    // priority vs dependency
    // priority puts the test in a specific order and runs the next test whether or not the previous test is successful
    // dependency runs the tests in the dependent order and if the previous test fails it doesn't run the next test.
    // If a test depends on a test and that test also depends on another test,
    // all tests in the chain must be added to the dependencies of the last test

    @Test
    void startCar() {
        System.out.println("Engine is running");
    }

    @Test(dependsOnMethods = "startCar") // This test depends on the success of startCar test. if it fails testng
    // skip this test
    void driveCar() {
        System.out.println("Car is moving");
       //Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar", "driveCar"})
    void parkCar() { // This test depends on startCar and driveCar tests. If any of them fails testng will skip this test
        System.out.println("Car is stopped");
    }

    @Test(dependsOnMethods = {"startCar", "driveCar", "parkCar"})
    void stopCar() { // This test depends on startCar, driveCar and parkCar tests. If any of them fails testng will skip this test
        System.out.println("Engine is stopped");
    }
}
