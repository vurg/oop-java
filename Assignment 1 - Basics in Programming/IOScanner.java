import java.util.Scanner;

public class IOScanner {
    public static Scanner input = new Scanner(System.in);

    public static String readString (String userMessage){
        System.out.println(userMessage);
        String stringValue = input.nextLine();
        return stringValue;
    }

    public static int readInt (String userMessage){
        System.out.print(userMessage);
        int intValue = input.nextInt();
        input.nextLine();
        return intValue;
    }

    public static double readDouble (String userMessage){
        System.out.println(userMessage);
        double doubleValue = input.nextDouble();
        input.nextLine();
        return doubleValue;
    }

    public static float readFloat (String userMessage){
        System.out.println(userMessage);
        float floatValue = input.nextFloat();
        input.nextLine();
        return floatValue;
    }

    public static byte readByte(String userMessage){
        System.out.println(userMessage);
        byte byteValue = input.nextByte();
        input.nextLine();
        return byteValue;
    }

    public static short readShort (String userMessage){
        System.out.println(userMessage);
        short shortValue = input.nextShort();
        input.nextLine();
        return shortValue;
    }

    public static long readLong (String userMessage){
        System.out.println(userMessage);
        long longValue = input.nextLong();
        input.nextLine();
        return longValue;
    }


    public static boolean readBoolean (String userMessage){
        System.out.println(userMessage);
        boolean booleanValue = input.nextBoolean();
        input.nextLine();
        return booleanValue;
    }

    public static void close(){
        input.close();
    }
}
