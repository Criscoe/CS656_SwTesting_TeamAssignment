import static org.testng.Assert.*;
import org.testng.annotations.*;

public class DartGameTest {

   // EP test data
   private static Object[][] testData1 = new Object[][] {
      // TC,		score,	expected output
      {"DEMO_01",	40,		new String[]{"D20","",""}},
	  {"DEMO_02",	171,	new String[]{"Invalid score"}},
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
