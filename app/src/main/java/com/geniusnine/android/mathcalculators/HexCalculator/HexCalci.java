package com.geniusnine.android.mathcalculators.HexCalculator;

public class HexCalci {
	 private static final int sizeOfIntInHalfBytes = 8;
	  private static final int numberOfBitsInAHalfByte = 4;
	  private static final int halfByte = 0x0F;
	  private static final char[] hexDigits = {
			    '0', '1', '2', '3', '4', '5', '6', '7',
			    '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
			  };
    public static String HEX_CHARACTERS="0123456789ABCDEF";



    public int HexSum(String a, String b){
        int left = Integer.parseInt(String.valueOf(a), 16);
        int right = Integer.parseInt(String.valueOf(b), 16);
        int sum = left + right;
       // String hex = decToHex(sum);

        return new Integer(sum);


    }
    public int HexDiff(String a, String b){
        int left = Integer.parseInt(String.valueOf(a), 16);
        int right = Integer.parseInt(String.valueOf(b), 16);
        int diff = left -right;
        return new Integer(diff);


    }

    public int HexProd(String a, String b){
        int left = Integer.parseInt(String.valueOf(a), 16);
        int right = Integer.parseInt(String.valueOf(b), 16);
        int prod = left * right;
        return new Integer(prod);


    }
    public int HexDiv(String a, String b){
        int left = Integer.parseInt(String.valueOf(a), 16);
        int right = Integer.parseInt(String.valueOf(b), 16);
        int div = left / right;
        return new Integer(div);


    }


    public double decimalToBinary(double number){

        Double num = Double.valueOf(number);
        //  int i = Integer.valueOf(D.intValue());

        int i = Integer.valueOf(num.intValue());
        String by = Integer.toBinaryString(i);
        //  System.out.println("Binary: " + by);

        //  System.out.println("Binary: " + by);
        return  Double.parseDouble(by);
    }

    public double dectoOctal(double number){
        Double num=Double.valueOf(number);
        int i=Integer.valueOf(num.intValue());
        String octalString = Integer.toOctalString(i);
        return Double.parseDouble(octalString);

    }

    public double hexToBinary(double number){

        Double num=Double.valueOf(number);

        int i=Integer.valueOf(num.intValue());

        String binary = Integer.toBinaryString(i);

        return Double.parseDouble(binary);

    }


    public String decToHex(double number){

        Double num=Double.valueOf(number);

        int i=Integer.valueOf(num.intValue());

        String hex = Integer.toHexString(i);

        return String.valueOf(hex);
    }

    public String binaryToHex(double number){

        Double num=Double.valueOf(number);

        int i=Integer.valueOf(num.intValue());
        String hexa = Integer.toHexString(i);

        return hexa;
    }

    public double binaryToDecimal(double number){

        Double num=Double.valueOf(number);

        int i=Integer.valueOf(num.intValue());
        int decimal=0,p=0;

        while(i!=0)
        {
            decimal+=((i%10)*Math.pow(2,p));
            i=i/10;
            p++;
        }


     return decimal;
    }


    public double binarytoOctal(double number){
        Double num=Double.valueOf(number);
        int i=Integer.valueOf(num.intValue());

        String octalString = Integer.toOctalString(i);
        return Double.parseDouble(octalString);

    }/* public static String hexToBin(String num) {


        String preBin = new BigInteger(num, 16).toString(2);
        Integer length = preBin.length();
        if (length < 8) {
            for (int i = 0; i < 8 - length; i++) {
                preBin = "0" + preBin;
            }
        }
        return preBin;
    }*/



  /*  public static int hex2Dec(String hex) {

        int counter = hex.length()-1;
        int sum = 0;

        for (char c:hex.toCharArray()) {
            int i = hex.indexOf(c);
            sum = (int) (sum + (Math.pow(16,counter))*i);
            counter--;
        }

        return sum;
    }*/



    public int hex2dec(String hexValue) {


        hexValue = hexValue.toUpperCase();

        int decimalResult = 0;

        for(int i=0;i<hexValue.length();i++) {

            char digit = hexValue.charAt(i);

            int digitValue = HEX_CHARACTERS.indexOf(digit);

            decimalResult = decimalResult*16+digitValue;

        }

        return decimalResult;

    }
    public static String getBinaryFromOctalNumber(String number) {

        // Convert Octal to Decimal
        int decimal = getDecimalFromOctalNumber(number);
        // Convert Decimal to Binary
        String binary = getBinaryFromDecimalNumber(decimal);
        return binary;
    }
    private static int getDecimalFromOctalNumber(String number) {

        // Converting String to StringBuilder.
        StringBuilder string = new StringBuilder(number);
        string = string.reverse();
        int length = string.length();
        int digit, power, sum = 0;
        for (int i = 0; i < length; i++) {
            digit = string.charAt(i) - 48;
            power = (int) Math.pow(8, i);
            sum = sum + digit * power;
        }
        return sum;
    }
    private static String getBinaryFromDecimalNumber(int decimal) {

        int remainder = 0;
        StringBuilder binary = new StringBuilder();
        while (decimal != 0) {
            remainder = decimal % 2;
            // Converting Integer to String and adding into StringBuilder.
            binary.append(String.valueOf(remainder));
            decimal = decimal / 2;
        }

        // Reverse String using library function of StringBuilder class.
        return binary.reverse().toString();
    }

/*
public  static  String octalToBin(String num){


    int dec = Integer.parseInt(num,8);
    String bin = Integer.toBinaryString(dec);
    return  bin;
}
*/

  /*  public static String convertHexToBinary(String hex) {

        StringBuilder binStrBuilder = new StringBuilder();
        int c = 1;
        for (int i = 0; i < hex.length() - 1; i += 2) {

            String output = hex.substring(i, (i + 2));

            int decimal = Integer.parseInt(output, 16);

            String binStr = Integer.toBinaryString(decimal);
            int len = binStr.length();
            StringBuilder sbf = new StringBuilder();
            if (len < 8) {

                for (int k = 0; k < (8 - len); k++) {
                    sbf.append("0");
                }
                sbf.append(binStr);
            } else {
                sbf.append(binStr);
            }

            c++;
            binStrBuilder.append(sbf.toString());
        }

        return binStrBuilder.toString();
    }*/
  /* public  static  String HexToBin(String num){


        int dec = Integer.parseInt(num,16);
        String bin = Integer.toBinaryString(dec);
        return String.valueOf(bin);
    }*/

 //   System.out.println("Octal " + num + " in Binary radix is "+ bin );

    public int octalToBinary(String octal) {
        int binary = 0;
        for (int i = 0; i < octal.length(); i++) {
            char octalDigit = octal.charAt(i);
            int octalDigitValue = octalDigit - '0';
            // Octal must be 0 - 7
            if (0 <= octalDigitValue && octalDigitValue <= 7) {
                binary = binary << 3 + octalDigitValue;
            } else {
               // throw new NumberFormatException("Invalid octal number " + octal);
            }
        }
        return binary;
    }
    /*public  static String  hex2Dec(String hex)
{
    int l = hex.length();
    char curDig;
    long dec = 0L;
    int d = 10, power = 0;
    for(int i=l-1; i>=0; i--) //Running loop backward to extract digits from the end
    {
        curDig = hex.charAt(i);
        if(curDig>='0' && curDig<='9')
            d = curDig-48;
        if(curDig>='A' && curDig<='F')
            d = curDig-55;

        dec = dec + d*(long)Math.pow(16,power);
        power++;
    }
    *//*System.out.println("The number in Decimal System = "+dec);*//*
return String.valueOf(dec);
}*/
public static  String hex2Octal(String number) {

    String num= String.valueOf(number);
    int dec = Integer.parseInt(num, 16);

    String oct = Integer.toOctalString(dec);
return  oct;
   // String num = "E";

}

   // System.out.println("Hexadecimal " + num + " in Octal radix is "+ oct );

}
