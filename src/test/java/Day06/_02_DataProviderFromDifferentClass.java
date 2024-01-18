package Day06;

import org.testng.annotations.Test;

public class _02_DataProviderFromDifferentClass {

    @Test(dataProvider = "loginData" ,dataProviderClass = _01_DataProvider.class)
    void test1(String str1, String str2){
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
    }
}
