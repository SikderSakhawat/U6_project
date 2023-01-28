import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        String n = number;

        System.out.println("What base do you want to convert your number to? (2 to 64)");
        int baseFinal = s.nextInt();
        s.close();


        NumberConverter nc = new NumberConverter(n, base);
        String[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + Arrays.toString(nc.allBaseConverter(baseFinal)));
    }
}

