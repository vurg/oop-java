public class HighestScore {
    public static void studentNumber(int[] scoresArray){
        int highestScore = scoresArray[0];
        int studentNumber = 0;
        for (int i = 0; i < scoresArray.length; i++) {
            if (scoresArray[i] > highestScore) {
                highestScore = scoresArray[i];
                studentNumber = i;
            }
        }
        System.out.println("The Highest score is "+ highestScore + " and belongs to the " + OrdinalSuffix.displaySuffix(studentNumber) + " student" );
    }
}
