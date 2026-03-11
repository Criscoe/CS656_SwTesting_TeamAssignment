package NathanLoo;

import static org.testng.Assert.*;
import org.testng.annotations.*;

public class DartGameTest {

	private static Object[][] testData1 = new Object[][] {
		// BV TCIs Driven
		// TC,		score,				expected output
		{"TC1.01",	Integer.MIN_VALUE,	new String[]{"Invalid score"}},
		{"TC1.02",	1,					new String[]{"Invalid score"}},
		{"TC1.03",	2,					new String[]{"D1", "", ""}},
		{"TC1.04",	50,					new String[]{"DB", "", ""}},
		{"TC1.05",	3,					new String[]{"S1", "D1", ""}},
		{"TC1.06",	70,					new String[]{"S20", "DB", ""}},
		{"TC1.07",	72,					new String[]{"D11", "DB", ""}},
		{"TC1.08",	90,					new String[]{"D20", "DB", ""}},
		{"TC1.09",	71,					new String[]{"T13", "D16", ""}},
		{"TC1.10",	110,				new String[]{"T20", "DB", ""}},
		{"TC1.11",	99,					new String[]{"S19", "T20", "D10"}},
		{"TC1.12",	130,				new String[]{"S20", "T20", "DB"}},
		{"TC1.13",	131,				new String[]{"D18", "T15", "DB"}},
		{"TC1.14",	150,				new String[]{"D20", "T20", "DB"}},
		{"TC1.15",	149,				new String[]{"T20", "T19", "D16"}},
		{"TC1.16",	170,				new String[]{"T20", "T20", "DB"}},
		{"TC1.17",	159,				new String[]{"No checkout possible"}},
		{"TC1.18",	169,				new String[]{"No checkout possible"}},
		{"TC1.19",	171,				new String[]{"Invalid score"}},
		{"TC1.20",	Integer.MAX_VALUE,	new String[]{"Invalid score"}},
		
		// EP TCIs Driven
		// TC,		score,				expected output
		{"TC2.01",	0,					new String[]{"Invalid score"}},
		{"TC2.02",	26,					new String[]{"D13", "", ""}},
		{"TC2.03",	43,					new String[]{"S3", "D20", ""}},
		{"TC2.04",	82,					new String[]{"D16", "DB", ""}},
		{"TC2.05",	95,					new String[]{"T15", "DB", ""}},
		{"TC2.06",	106,				new String[]{"S2", "T18", "DB"}},
		{"TC2.07",	140,				new String[]{"D15", "T20", "DB"}},
		{"TC2.08",	161,				new String[]{"D17", "T20", "DB"}},
		{"TC2.09",	166,				new String[]{"No checkout possible"}},
		{"TC2.10",	3000,				new String[]{"Invalid score"}},
	};

    // Method to return the EP test data
    @DataProvider(name="dataset1")
    public Object[][] getTestData() {
       return testData1;
    }

    // Method to execute the EP tests
    @Test(dataProvider="dataset1")
    public void test_premium(String id, int score, String[] expected)
    {
       assertEquals(DartGame.checkout(score), expected);
    }

}
