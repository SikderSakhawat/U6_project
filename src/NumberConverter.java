public class NumberConverter {
    private int[] digits;
    private int base;
    private String[] chars = {"0","1","2","3","4","5","6","7","8","9","A",
            "B","C","D","E","F","G","H","I","J","K","L",
            "M","N","O","P","Q","R","S","T","U","V","W",
            "X","Y","Z","a","b","c","d","e","f","g","h",
            "i","j","k","l","m","n","o","p","q","r","s",
            "t","u","v","w","x","y","z","+","/"};
    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber(int[] numList) {
        String o = "";
        for (int i = 0; i < numList.length; i++) {
            o = o + numList[i];
        }
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int[] newNum = new int[digits.length];
        int sum = 0;
        for(int i = 0; i < digits.length; i++){
            newNum[i] = digits[i] * (int)(Math.pow(base, digits.length - (i + 1))); // increments through the list by making each place value the value in decimal.
            sum+= newNum[i];
        }
        String sumAsStr = sum + ""; // makes into a string to get the length, so you can increment through each digit
        int[] result = new int[sumAsStr.length()];
        for(int i = 0; i < sumAsStr.length(); i++){
            result[i] = Integer.parseInt(String.valueOf(sumAsStr.charAt(i))); // sets each digit into its own element
        }
        return result;
    }

    public String[] convertToBinary() {
        String binaryNum = "";
        int[] newDigits = convertToDecimal();
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
        int[] newDigits = convertToDecimal();
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

    private int returnNum(int[] numDigits){
        int sum = 0;
        for(int i = 0; i < numDigits.length; i++){
            sum+= numDigits[i] * (int)(Math.pow(base, numDigits.length - (i + 1)));
        }
        return sum;
    }
}


