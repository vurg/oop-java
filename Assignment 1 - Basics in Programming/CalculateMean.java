public class CalculateMean {
    public static void meanValue (int[] scoresArray){
        int n = scoresArray.length;
        double meanValue = 0.0;

        // adding up the scores of students
        for(int i=0; i<n; i++){
            meanValue += scoresArray[i];
        }

        // dividing by number of students, casting from type int to double for number of students
        meanValue = meanValue / (double) n;

        System.out.printf("The mean of the numbers is %.2f", meanValue); //truncating to two decimal digits
        System.out.println();
    }
}
