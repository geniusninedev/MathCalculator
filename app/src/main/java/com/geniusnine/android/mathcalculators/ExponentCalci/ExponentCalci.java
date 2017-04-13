package com.geniusnine.android.mathcalculators.ExponentCalci;

public class ExponentCalci {
/*
	public static void main(String[] args) {
   
		 Scanner in = new Scanner(System.in);
		 System.out.print("Please enter your base: ");
		 int base = in.nextInt();
		 System.out.print("Please enter your exponent: ");
		 int power = in.nextInt();

		     double result = mathPower(base, power);
		     System.out.println(base + " to the power of " + power  + " is " + result + ".");



		 }
*/

	public static double mathPower(double a, int b)
    {
        double result = 1.0;

        if (b == 0)
        {
            result = 1.0;
        }

        if (b < 0)
        {
            a = (1.0 / a);
            b = -b;
        }

        for (int i = 0; i < b; i++)
        {
            result = result * a;
        }

        return result;
    }
}
