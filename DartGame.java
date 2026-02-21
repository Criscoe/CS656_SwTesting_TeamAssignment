// Java method created by ChatGPT based on the following input. 
// Write a Java method that will return the one, two or three dart throws necessary to end the round of 501 darts. 
//
// Input: Current score which is in the range of 2 to 170. 
//
// Output: array throws[3] which are enumerated types of valid dart throws. If it starts with an S it is a single 
// a D is a double and T is a triple. The numbers are 1 through 20 plus Bull. Bull is worth 25 and double bull 
// is worth 50. There is no triple Bull only a Bull and a double Bull. 
//
// Calculation: When there are 170 or less points remaining, the method is to calculate the winning throws. 
// The largest double possible should be the suggested last throw. This is in case there is a miss there are 
// many remaining doubles to try for. It is also a rule that the last throw must be a double. If only one or 
// two darts are needed to reach zero the unnecessary throws in the return array are put at blank. 

public class DartGame {
    public static String[] checkout(int score) {
        if (score > 170 || score < 2) {
            return new String[]{"Invalid score"};
        }
        
        String[] throwsArray = {"", "", ""};
        
        // Possible double values
        for (int d = 20; d >= 1; d--) {
            int doubleValue = d * 2;
            if (doubleValue > score) continue;
            
            // If exactly the double value is needed
            if (doubleValue == score) {
                throwsArray[0] = "D" + d;
                return throwsArray;
            }
            
            // Check for a two-dart finish
            for (int first = 20; first >= 1; first--) {
                for (String prefix : new String[]{"S", "T"}) {
                    int firstValue = (prefix.equals("T") && first == 25) ? 0 : first * (prefix.equals("T") ? 3 : 1);
                    if (firstValue > score - doubleValue) continue;
                    if (firstValue + doubleValue == score) {
                        throwsArray[0] = prefix + first;
                        throwsArray[1] = "D" + d;
                        return throwsArray;
                    }
                }
            }
            
            // Check for a three-dart finish
            for (int first = 20; first >= 1; first--) {
                for (String prefix1 : new String[]{"S", "T"}) {
                    int firstValue = (prefix1.equals("T") && first == 25) ? 0 : first * (prefix1.equals("T") ? 3 : 1);
                    if (firstValue >= score - doubleValue) continue;
                    for (int second = 20; second >= 1; second--) {
                        for (String prefix2 : new String[]{"S", "T"}) {
                            int secondValue = (prefix2.equals("T") && second == 25) ? 0 : second * (prefix2.equals("T") ? 3 : 1);
                            if (firstValue + secondValue + doubleValue == score) {
                                throwsArray[0] = prefix1 + first;
                                throwsArray[1] = prefix2 + second;
                                throwsArray[2] = "D" + d;
                                return throwsArray;
                            }
                        }
                    }
                }
            }
        }
        return new String[]{"No checkout possible"};
    }
    
    public static void main(String[] args) {
        int score = 170;
        String[] result = checkout(score);
        for (String throwDart : result) {
            System.out.println(throwDart);
        }
    }
}

