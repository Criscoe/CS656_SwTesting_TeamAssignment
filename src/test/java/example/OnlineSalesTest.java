/*
 * OnlineSalesTest
 *
 * Version 3 (EP testing, all testcases)
 *
 * Date: 1/1/2021
 *
 * Copyright (c) Authors of the Essentials of Software Testing - all rights reserved.
 */
package example;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import example.OnlineSales.Status;
import static example.OnlineSales.Status.*;

public class OnlineSalesTest {

   // EP test data
   private static Object[][] testData1 = new Object[][] {
   // test, bonuspoints, goldCustomer, expected output
      { "T1.1", 40L, true, FULLPRICE },
      { "T1.2", 100L, false, FULLPRICE },
      { "T1.3", 200L, false, DISCOUNT },
      { "T1.4", -100L, false, ERROR },
    };

    // Method to return the EP test data
    @DataProvider(name="dataset1")
    public Object[][] getTestData() {
       return testData1;
    }

    // Method to execute the EP tests
    @Test(dataProvider="dataset1")
    public void test_giveDiscount( String id, long bonusPoints,
          boolean goldCustomer, Status expected)
    {
       assertEquals(
       OnlineSales.giveDiscount(bonusPoints, goldCustomer),
             expected );
    }

}
