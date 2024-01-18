/**
* Program asks user to register scores for 7 students.
* User can choose to calculate mean, highest two and lowest two scores, and index of highest score.
* User can also choose to collect hashtags from a given sentence.
 */
import java.util.Locale;

public class Menu {
    // global array containing n=7 student scores
    public static int[] studentScores = new int[7];

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        //take scores from user
        ReadScores.inputScores(studentScores);

        //MENU
        //Interactive menu
        int selectOption = 0; // variable used for user selection in menu

        while (selectOption != 6) {
            System.out.println("Welcome to the menu. Choose one of the options below:");
            System.out.println("1. Register new scores for students.");
            System.out.println("2. Calculate the mean of the entered scores.");
            System.out.println("3. Find the two highest and two lowest scores.");
            System.out.println("4. Find the highest score and its position.");
            System.out.println("5. Collect hashtags from a post.");
            System.out.println("6. To exit.");
            System.out.print("");
            selectOption = IOScanner.readInt("Type your option: ");

            if (selectOption == 1) {
                // User wants to input new scores
                ReadScores.inputScores(studentScores);
            }else if (selectOption == 2){
                // User wants to calculate mean score
                CalculateMean.meanValue(studentScores);
            }else if (selectOption == 3){
                // User wants to determine two highest and two lowest scores
                Extremes.twoLowest(studentScores);
                Extremes.twoHighest(studentScores);
            }else if (selectOption == 4){
                // User wants to calculate maximum score and which student it belongs to
                HighestScore.studentNumber(studentScores);
            }else if (selectOption == 5){
                // User wants to find hashtags in a text
                HashTags.findHashTagsInText();
            }else if (selectOption == 6){
                // User wants to exit
                System.out.println("Thank you for using our grading system. Have a nice day!");
            }else{
                // User has selected an invalid option
                System.out.println("Error - Invalid value. Please type between 1 and 6");
            }
        }
        IOScanner.close();
    }
}
