package com.geniusnine.android.mathcalculators.RootCalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RootCalci {
    public static final String RESULT_FORMAT = "#.####";


    public double nthroot(int n, double x)
    {  DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        return  Double.parseDouble(df.format(nthroot(n, x, .0001)));
    }
    public double nthroot(int n, double x, double p)
    {
        if(x < 0)
        {
           // System.out.println("Please Enter Positive Number!");
            return -1;
        }
        if(x == 0)
            return 0;


        double x1 = x;
        double x2 = x / n;
        while (Math.abs(x1 - x2) > p)
        {
            x1 = x2;
            x2 = ((n - 1.0) * x2 + x / Math.pow(x2, n - 1.0)) / n;
        }
        return x2;
    }

    public  double squareRoot(double x){
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        double result;
        result= (double) Math.sqrt(x);
        return   Double.parseDouble(df.format(result));
    }
    public  double cubeRoot(double x){
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        double result;
        result= (double) Math.cbrt(x);
        return   Double.parseDouble(df.format(result));
    }


	  /*  public double nthroot(int n, double x, double p)

	    
	   /* public static void main(String[] args)
	    {
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Nth Root Algorithm Test\n");
	        System.out.println("Enter root ");
	        int n = scan.nextInt();
	        System.out.println("Enter number ");
	        double x = scan.nextInt();
	        RootCalci nr = new RootCalci();
	        double root = nr.nthroot(n, x);
	        System.out.println("\nRoot Value: "+ root);
	    }    */
}
