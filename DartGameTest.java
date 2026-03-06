import static org.testng.Assert.*;
import org.testng.annotations.*;

public class DartGameTest {

	private static Object[][] testData1 = new Object[][] {
		// BV TCIs Driven
		// TC,		score,				expected output
		{"TC01",	Integer.MIN_VALUE,	new String[]{"Invalid score"}},
		{"TC02",	1,					new String[]{"Invalid score"}},
		{"TC03",	2,					new String[]{"D1", "", ""}},
		{"TC04",	50,					new String[]{"DB", "", ""}},
		{"TC05",	3,					new String[]{"S1", "D1", ""}},
		{"TC06",	70,					new String[]{"S20", "DB", ""}},
		{"TC07",	72,					new String[]{"D11", "DB", ""}},
		{"TC08",	90,					new String[]{"D20", "DB", ""}},
		{"TC09",	71,					new String[]{"T13", "D16", ""}},
		{"TC10",	110,				new String[]{"T20", "DB", ""}},
		{"TC11",	99,					new String[]{"S19", "T20", "D10"}},
		{"TC12",	130,				new String[]{"S20", "T20", "DB"}},
		{"TC13",	131,				new String[]{"D18", "T15", "DB"}},
		{"TC14",	150,				new String[]{"D20", "T20", "DB"}},
		{"TC15",	149,				new String[]{"T20", "T19", "D16"}},
		{"TC16",	170,				new String[]{"T20", "T20", "DB"}},
		{"TC17",	159,				new String[]{"No checkout possible"}},
		{"TC18",	169,				new String[]{"No checkout possible"}},
		{"TC19",	171,				new String[]{"Invalid score"}},
		{"TC20",	Integer.MAX_VALUE,	new String[]{"Invalid score"}},
		
		// EP TCIs Driven
		// TC,		score,				expected output
		{"TC21",	0,					new String[]{"Invalid score"}},
		{"TC22",	26,					new String[]{"D13", "", ""}},
		{"TC23",	43,					new String[]{"S3", "D20", ""}},
		{"TC24",	82,					new String[]{"D16", "DB", ""}},
		{"TC25",	95,					new String[]{"T15", "DB", ""}},
		{"TC26",	106,				new String[]{"S2", "T18", "DB"}},
		{"TC27",	140,				new String[]{"D15", "T20", "DB"}},
		{"TC28",	161,				new String[]{"D17", "T20", "DB"}},
		{"TC29",	166,				new String[]{"No checkout possible"}},
		{"TC30",	3000,				new String[]{"Invalid score"}},
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
