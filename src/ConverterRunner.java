import java.util.Scanner;
import java.util.Arrays;

public class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        final String[] chars = {"0","1","2","3","4","5","6","7","8","9","A",
                "B","C","D","E","F","G","H","I","J","K","L",
                "M","N","O","P","Q","R","S","T","U","V","W",
                "X","Y","Z","a","b","c","d","e","f","g","h",
                "i","j","k","l","m","n","o","p","q","r","s",
                "t","u","v","w","x","y","z","+","/"};
        boolean badNumber = true;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the base of your number (2 to 64): ");
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);
        while(badNumber) {
            if(base >= 2 && base <= 64) badNumber = false;
            else {
                System.out.println("That isn't an available base system right now. Choose one in between 2 and 64, inclusive.");
                System.out.print("Enter the base of your number (2 to 64): ");
                choice = s.nextLine();
                base = Integer.parseInt(choice);
            }
        }
        System.out.print("Enter your number: ");
        badNumber = true;
        String number = s.nextLine();
        String n = number;
        while(badNumber){
            boolean wrongChar = false;
            for(int i = base; i < chars.length; i++){
                if(number.contains(chars[i])){
                    wrongChar = true;
                    break; // Breaks the for loop ONLY if there exists a digit that isn't supposed to be in the number system specified. Makes the loop end quicker.
                }
            }
            if(wrongChar){
                System.out.println("This is not a valid number! Please type in your number again.");
                number = s.nextLine();
                n = number;
            } else {
                badNumber = false;
            }
        }
        badNumber = true;
        System.out.println("What base do you want to convert your number to? (2 to 64)");
        int baseFinal = s.nextInt();
        while(badNumber) {
            if(baseFinal >= 2 && baseFinal <= 64) badNumber = false;
            else {
                System.out.println("That isn't an available base system right now. Choose one in between 2 and 64, inclusive.");
                System.out.print("Enter the base of your number you want to convert to (2 to 64): ");
                baseFinal = s.nextInt();
            }
        }
        s.close();


        NumberConverter nc = new NumberConverter(n, base);
        String[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + Arrays.toString(nc.allBaseConverter(baseFinal)));
    }
}

