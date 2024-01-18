public class Extremes {
    public static void twoHighest(int[] scoresArray){
        // finding two highest scores
        int highestScore = 0;
        int secondHighestScore = 0;

        for(int i=0; i < scoresArray.length ; i++){
            if (scoresArray[i] >= highestScore){
                secondHighestScore = highestScore;
                highestScore = scoresArray[i];
            }else if(scoresArray[i] >= secondHighestScore){
                secondHighestScore = scoresArray[i];
            }
        }

        System.out.println("The two highest scores provided are " + highestScore + ", and " + secondHighestScore);
    }
    public static void twoLowest(int[] scoresArray){
        //finding two lowest scores
        int lowestScore = 100;
        int secondLowestScore = 100;

        for(int i=0; i < scoresArray.length; i++) {
            if (scoresArray[i] <= lowestScore) {
                secondLowestScore = lowestScore;
                lowestScore = scoresArray[i];
            } else if (scoresArray[i] <= secondLowestScore) {
                secondLowestScore = scoresArray[i];
            }
        }

        System.out.println("The two lowest scores provided are " + lowestScore + ", and " + secondLowestScore);
    }
}
