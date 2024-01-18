package Day06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.DriverClass;

public class _01_DataProvider {

    // Positive Test = Testing a function with valid data
    // Negative Test = Testing a function with invalid data

    // Data Provider runs the code in the test multiple times with different sets of data
    // It doesn't run BeforeMethod or BeforeClass ... codes for every data.
    @Test(dataProvider = "credentials")
    // To connect our test with DataProvider we can use data provider's method name.
    void loginTest(String username, String password) {

        // Valid username and password -> positive test
        // Valid username and invalid password -> Negative test
        // Invalid username and valid password -> Negative test
        // Invalid username and password -> Negative Test

        System.out.println("Test has started");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("Test has ended");
    }

    @Test(dataProvider = "loginData")
        // To connect our test with DataProvider we can give a name to data provider and use that name.
    void loginTest1(String username, String password) {

        // Valid username and password -> positive test
        // Valid username and invalid password -> Negative test
        // Invalid username and valid password -> Negative test
        // Invalid username and password -> Negative Test

        System.out.println("Test has started");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("Test has ended");
    }

    @DataProvider(name = "loginData")
    public Object[][] credentials() {
        Object[][] credentialsArray = {
                {"John", "John1234"},
                {"John", "@John12"},
                {"12John345", "John1234"},
                {"fgdJohn", "12John4567"}
        };
        return credentialsArray;
    }
}
