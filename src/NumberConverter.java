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

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int[] newNum = new int[digits.length];
        int sum = 0;
        for(int i = 0; i < digits.length; i++){
            newNum[i] = digits[i] * (int)(Math.pow(base, digits.length - (i + 1)));
            sum+= newNum[i];
        }
        String sumAsStr = sum + "";
        int[] result = new int[sumAsStr.length()];
        for(int i = 0; i < sumAsStr.length(); i++){
            result[i] = Integer.parseInt(String.valueOf(sumAsStr.charAt(i)));
        }
        return result;
    }

    public int[] convertToBinary() {
        String binaryNum = "";
        int[] newDigits = convertToDecimal();
        int decNum = 
        base = 2;
       return null;
    }

    public int[] convertToOctal() {
        return null;
    }

    private int returnNum(int[] numDigits){
        int sum = 0;
        for(int i = 0; i < numDigits.length; i++){
            sum+= numDigits[i] * (int)(Math.pow(base, numDigits.length - (i + 1)));
        }
        return sum;
    }
}


