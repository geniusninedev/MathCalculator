package com.geniusnine.android.mathcalculators.QuadraticCalci;

public class QuadraticFormulaCalci {



    public double QuadraticFormula(int a, int b, int c) {
        double d;
        //System.out.println("Given quadratic equation:" + a + "x^2 + " + b + "x + " + c);

        d = b * b - 4 * a * c;


        return d;

    }

    public double RootsEquation(int a, int b, int c) {

        double d;
       double root1,root2;
        d = b * b - 4 * a * c;
        if (d > 0) {
            // System.out.println("Roots are real and un1equal");
            root1 = (double) ((-b + Math.sqrt(d)) / (2 * a));
            root2 = (double) ((-b - Math.sqrt(d))/(2*a));
            // System.out.println("First root is:"+root1);
            //System.out.println("Second root is:"+root2);


        }
        else if(d == 0)
        {
          //  System.out.println("Roots are real and equal");
            root1 = (int) ((-b+Math.sqrt(d))/(2*a));

        }
        else
        {

        }


        return (double) ((-b + Math.sqrt(d))/(2*a));
    }



    public double RootsEquationTwo(int a, int b, int c) {
        double d;
        double  root2;
        d = b * b - 4 * a * c;
        if (d > 0) {
            // System.out.println("Roots are real and un1equal");
           // root1 = (int) ((-b + Math.sqrt(d)) / (2 * a));
            root2 = (double) (-b - Math.sqrt(d)) / (2 * a);
            // System.out.println("First root is:"+root1);
            //System.out.println("Second root is:"+root2);


        } else if (d == 0) {
            //  System.out.println("Roots are real and equal");
            root2 = (double) ((-b + Math.sqrt(d)) / (2 * a));
             return (double) root2;
        } else {

        }

        return (double) (-b - Math.sqrt(d)) / (2 * a);
    }
}