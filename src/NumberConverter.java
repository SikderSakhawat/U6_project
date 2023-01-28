public class NumberConverter {
    private final String[] digits;
    private int base;
    private final String[] chars = {"0","1","2","3","4","5","6","7","8","9","A",
            "B","C","D","E","F","G","H","I","J","K","L",
            "M","N","O","P","Q","R","S","T","U","V","W",
            "X","Y","Z","a","b","c","d","e","f","g","h",
            "i","j","k","l","m","n","o","p","q","r","s",
            "t","u","v","w","x","y","z","+","/"};
    public NumberConverter(String number, int base) {
        digits = new String[number.length()];
        for (int i = 0; i < number.length(); i++) {
            String single = number.substring(i,i+1);
            digits[i] = single;
        }
        this.base = base;
    }
    // PRIVATE METHODS
    private String displayOriginalNumber(String[] numList) {
        String o = "";
        for (String num : numList) {
            o += num;
        }
        return o;
    }
    private int findIndex(String element){
        for(int i = 0; i < chars.length; i++){
            if(chars[i].equals(element)) return i;
        }
        return -1;
    }
    // GETTER METHODS
    public String[] getDigits() {
        return digits;
    }

    public String[] convertToDecimal() {
        int[] newNum = new int[digits.length];
        int sum = 0;
        for(int i = 0; i < digits.length; i++){
            newNum[i] = (int) (findIndex(digits[i]) * (Math.pow(base, digits.length - (i + 1)))); // increments through the list by making each place value the value in decimal.
            sum+= newNum[i];
        }
        String sumAsStr = sum + ""; // makes into a string to get the length, so you can increment through each digit
        String[] result = new String[sumAsStr.length()];
        for(int i = 0; i < sumAsStr.length(); i++){
            result[i] = String.valueOf(sumAsStr.charAt(i)); // sets each digit into its own element
        }
        return result;
    }

    public String[] convertToBinary() {
        String binaryNum = "";
        String[] newDigits = convertToDecimal();
        String numStr = displayOriginalNumber(newDigits);
        int decNum = Integer.parseInt(numStr);
        base = 2;
        while(decNum != 0){
            binaryNum += decNum % base;
            decNum/= base;
        }
        String[] digits = binaryNum.split("");
        for(int i = 0; i < digits.length / 2; i++){
            String temp = digits[i];
            digits[i] = digits[digits.length - (i + 1)];
            digits[digits.length - (i + 1)] = temp;
        }
        return digits;
    }

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

    public String[] allBaseConverter(int baseNum){
        return null;
    }

}


