public class ReadScores {
    public static int[] inputScores (int[] scoresArray){
        int n = scoresArray.length;

        //Reads user scores
        for(int i=0; i<n; i++){
            scoresArray[i] = IOScanner.readInt("Enter the score for the " + OrdinalSuffix.displaySuffix(i) + " student ");
            if(scoresArray[i] < 0 || scoresArray[i] > 100) {
                System.out.println("Error - Input out of bound. Score can only be between 0  and 100.");
                i=i-1;
            }
        }
        //Outputs user scores
        System.out.println("Thank you for your input. Your entered scores are: ");
        for (int i = 0; i < n; i++) {
            if (i < (n - 1)) {
                System.out.print(scoresArray[i] + ", ");
            } else {
                System.out.print(scoresArray[i]);
            }
        }
        System.out.println();

        return scoresArray;
    }



}
