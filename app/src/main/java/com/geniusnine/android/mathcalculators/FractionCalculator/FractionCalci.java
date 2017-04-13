package com.geniusnine.android.mathcalculators.FractionCalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FractionCalci {
double value1;
double value2;
double value3;
double value4;

    public static final String RESULT_FORMAT = "#.#####";

public double CalculateAdditionFraction(double value1,double value2,double value3,double value4){
	double result1;
	
	//double result=value2*value4;

	result1=(value1*value4+value2*value3);

	return result1;
	
}

    public double CalculateAdditionFractionOne(double value2,double value4){
       // double result1;


        double result=value2*value4;

        return result;

    }


public double CalculateSubtractionFraction(double value1,double value2,double value3,double value4){
	double result1;

	
	result1=(value1*value4-value2*value3);

	return result1;
	
}
    public double CalculateSubtractionFractionOne(double value2,double value4){
        double result1;

        double result=value2*value4;

        //result1=(value1*value4-value2*value3)/result;

        return result;

    }

public double CalculateMultiplicationFraction(double value1,double value3){
	double result1;
	
	//double result;
	
//	result=value2*value4;
	
	result1=value1*value3;

	return result1;
	
}
    public double CalculateMultiplicationFractionOne(double value2, double value4){
        double result1;

        double result;

        result=value2*value4;

    //    result1=value1*value3/result;

        return result;

    }


public double CalculateDivisionFraction(double value1,double value4){
	double result1;

	result1=value1*value4;

	return result1;
	
}
    public double CalculateDivisionFractionOne(double value2,double value3){


        double result;

        result=value2*value3;

        return result;

    }

    public  double CalculateSimplifyFraction(double value1,double value2,double value3){
        double result;
        result=value1*value3+value2;
        return  result;
    }

    public  double CalculateSimplifyFractionOne(double value3){

        return  value3;
    }


    public int DecimalToFractionCalculate(double value1){
      //  value2=1;
        double result;

        result=value1;
        return (int) result;
    }

    public double FractionToDecimal(double value1, double value2){

        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);

        double result;
        result=value1/value2;
        return Double.parseDouble(df.format(result));
    }
/*public static void main(String args[])
{
	FractionCalci fraction=new FractionCalci();
	
	double resultAdd,resultSub,resultMult,resultDiv;
	
	resultAdd=fraction.CalculateAdditionFraction(30,10,30,10);
	System.out.print("Addition Of Fraction is:"+resultAdd);
	
	resultSub=fraction.CalculateSubtractionFraction(45,10,30,10);
	System.out.print("\n\nSubtraction Of Fraction is:"+resultSub);
	
	resultMult=fraction.CalculateMultiplicationFraction(45,10);
	System.out.print("\n\nSubtraction Of Fraction is:"+resultMult);
	
	resultDiv=fraction.CalculateDivisionFraction(45,10,30);
	
	
	System.out.print("\n\nSubtraction Of Fraction is:"+resultDiv);
	
	System.out.println ("\n\nThe time entered is:" +resultAdd + "/" + resultDiv );
	
}*/
}
