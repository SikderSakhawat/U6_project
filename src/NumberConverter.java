/**
 * This is where the methods to convert your number in between bases occur. You can convert from one base system to another,
 * with base systems of 2 to 64, inclusive. <p></p>
 * The digits of your necessary base systems can be modeled by the elements within String[] chars.
 */
public class NumberConverter {
    private final String[] digits;
    private int base;
    // Use a reference table to see which characters refer to the letters/numbers in a given number system
    private final String[] chars = {"0","1","2","3","4","5","6","7","8","9","A",
            "B","C","D","E","F","G","H","I","J","K","L",
            "M","N","O","P","Q","R","S","T","U","V","W",
            "X","Y","Z","a","b","c","d","e","f","g","h",
            "i","j","k","l","m","n","o","p","q","r","s",
            "t","u","v","w","x","y","z","+","/"};

    // CONSTRUCTOR
    /**
     * Initializes the array of digits by separating each character in "number" into elements. Initializes the value of your base system that is being used.
     * @param number is the number from the specific base system specified, which should accept digits that are available in that number system. <p></p>
     * @param base is the number of the base system. Accepts all base systems from base 2 to 64 (unary number system doesn't exist).
     */
    public NumberConverter(String number, int base) {
        digits = number.split(""); // split the string of the number with the number system chosen to
        // analyse each character in the given number
        this.base = base;
    }
    // PRIVATE METHODS

    /**
     * Displays a string of the original number, since the numbers you work with are found in String[], not String.
     * @param numList is the array that is separated into elements of a number
     * @return a String that contains all elements of the list in order.
     */
    private String displayOriginalNumber(String[] numList) {
        String o = "";
        for (String num : numList) {
            o += num;
        }
        return o;
    }

    /**
     * Finds the index of a given character within "chars", returns -1 if no character is found. <p></p>
     * It is essentially just a .indexOf() method but for arrays.
     * @param element is the character that is being searched for within "chars"
     * @return the index of the element that contains "element"
     */
    private int findIndex(String element){
        for(int i = 0; i < chars.length; i++){
            if(chars[i].equals(element)) return i;
        }
        return -1;
    }
    // GETTER METHODS

    /**
     * @return Returns the array of digits that has our current number in it.
     */
    public String[] getDigits() {
        return digits;
    }

    // BASE CONVERTER METHODS

    /**
     * Converts the number of our current base into a base 10 number system, or in decimal form.
     * @return A String array that contains the number in "digits" in decimal form.
     */
    public String[] convertToDecimal() {
        int[] newNum = new int[digits.length];
        int sum = 0;
        // Weighted multiplication that occurs with each place value based on the base number to get the decimal value
        for(int i = 0; i < digits.length; i++){
            newNum[i] = (int) (findIndex(digits[i]) * (Math.pow(base, digits.length - (i + 1)))); // increments through the list by making each place value the value in decimal.
            sum+= newNum[i];
        }
        // Just setting each character value to a String[] value so that it can be returned as a String[] in the main method
        String sumAsStr = sum + ""; // makes into a string to get the length, so you can increment through each digit
        String[] result = new String[sumAsStr.length()];
        for(int i = 0; i < sumAsStr.length(); i++){
            result[i] = String.valueOf(sumAsStr.charAt(i)); // sets each digit into its own element
        }
        return result;
    }

    /**
     * Converts the number of our current base into a base 2 number system, or in binary form.
     * @return A String array that contains the number in "digits" in binary form.
     */
    public String[] convertToBinary() {
        String binaryNum = "";
        String[] newDigits = convertToDecimal();
        String numStr = displayOriginalNumber(newDigits);
        int decNum = Integer.parseInt(numStr);
        base = 2; // Since this is binary our base number system is 2
        // Same weighted division and modding to receive our reversed string of converted numbers
        while(decNum != 0){
            binaryNum += decNum % base;
            decNum/= base;
        }
        // Reverse the string to get the correct conversion
        String[] digits = binaryNum.split("");
        for(int i = 0; i < digits.length / 2; i++){
            String temp = digits[i];
            digits[i] = digits[digits.length - (i + 1)];
            digits[digits.length - (i + 1)] = temp;
        }
        return digits;
    }

    /**
     * Converts the number of our current base into a base 8 number system, or in octal form.
     * @return A String array that contains the number in "digits" in octal form.
     */
    public String[] convertToOctal() {
        String num = "";
        String[] newDigits = convertToDecimal();
        String numStr = displayOriginalNumber(newDigits);
        int decNum = Integer.parseInt(numStr);
        base = 8;
        while(decNum != 0){
            num += decNum % base;
            decNum/= base;
        }
        String[] digits = num.split("");
        for(int i = 0; i < digits.length / 2; i++){
            String temp = digits[i];
            digits[i] = digits[digits.length - (i + 1)];
            digits[digits.length - (i + 1)] = temp;
        }
        return digits;
    }

    /**
     * Converts from the current base number system to a specified base number system.
     * @param baseNum The value of the base system that is being converted to. <p></p>
     * PRECONDITION: All values must be between 2 and 64, inclusive (base 1 isn't a possible base system)
     * @return A String array that contains the number in "digits" in the "baseNum" number system.
     */
    public String[] allBaseConverter(int baseNum){
        String num = "";
        // convert the number to decimal by calling the convertToDecimal() method
        // as a medium and set it to a new string of numbers
        String[] newDigits = convertToDecimal();
        String numStr = displayOriginalNumber(newDigits);
        int decNum = Integer.parseInt(numStr);
        base = baseNum;
        // the repeated division process happens here, where we append the correct number after
        // taking the mod of the number and then dividing it
        while(decNum != 0){
            num += chars[decNum % base];
            decNum/= base;
        }
        // Create a new digits variable that can reverse the characters of num, and produce the correct
        // conversion of a base number.
        String[] digits = num.split("");
        for(int i = 0; i < digits.length / 2; i++){
            String temp = digits[i];
            digits[i] = digits[digits.length - (i + 1)];
            digits[digits.length - (i + 1)] = temp;
        }
        return digits;
    }
}