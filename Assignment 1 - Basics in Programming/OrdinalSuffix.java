public class OrdinalSuffix {
    public static String displaySuffix(int number){

        number = number + 1;

        int lastDigit = number % 10;
        String ordinalIndicator = "";
        String fullNumber = "";

        if((number >= 4 && number <= 20) || (number >= 104 && number <= 120)){
            ordinalIndicator = "th";
        }else{
            switch (lastDigit) {
                case 1: ordinalIndicator = "st";
                break;
                case 2: ordinalIndicator = "nd";
                break;
                case 3: ordinalIndicator = "rd";
                break;
                default: ordinalIndicator = "th";
            }
        }
        fullNumber = number + ordinalIndicator;
        return fullNumber;
    }
}
