package assignment3;

/**  Truncates a double value to second decimal place. */

public class Calc {
    public static double truncate(double value){
        return Math.floor(value*100)/100;
    }
}
