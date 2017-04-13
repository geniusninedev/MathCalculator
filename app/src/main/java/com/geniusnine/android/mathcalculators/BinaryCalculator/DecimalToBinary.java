package com.geniusnine.android.mathcalculators.BinaryCalculator;

/**
 * Created by Dev on 21-03-2017.
 */

public class DecimalToBinary {
   /* public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      //  System.out.println("Enter the decimal value:");
       String hex = bf.readLine();
        int i = Integer.parseInt(hex);
        String by = Integer.toBinaryString(i);
        System.out.println("Binary: " + by);
    }*/


public double decimalToBinary(double number){

    Double num = Double.valueOf(number);
  //  int i = Integer.valueOf(D.intValue());

    int i = Integer.valueOf(num.intValue());
    String by = Integer.toBinaryString(i);
  //  System.out.println("Binary: " + by);
    return Double.parseDouble(by);
}

    public double dectoOctal(double number){
        Double num=Double.valueOf(number);
        int i=Integer.valueOf(num.intValue());

        String octalString = Integer.toOctalString(i);
        return Double.parseDouble(octalString);

    }

    public double decToHex(double number){

        Double num=Double.valueOf(number);

        int i=Integer.valueOf(num.intValue());

        String hex = Integer.toHexString(i);

        return Double.parseDouble(hex);

    }

    public String binaryToHex(double number){

        Double num=Double.valueOf(number);

        int i=Integer.valueOf(num.intValue());
        String hexa = Integer.toHexString(i);

        return hexa;
    }

}


