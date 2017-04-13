package com.geniusnine.android.mathcalculators.HalfLifeCalci;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class halfLifeCalculator {
	 double QuantityRemains;
	    double InitialQuantity;
	double Time;
	double HalfTime;
    public static final String RESULT_FORMAT = "#.####";

	public double calculateQuantityRemainsFromInitial(double InitialQuantity, double Time,double HalfTime){

        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);

        double result;
		result=InitialQuantity*Math.pow(0.5, (Time/HalfTime));

        return  Double.parseDouble(df.format(result));
				
	}
	public double calculateInitialQuantityFromQuantityRemains(double QuantityRemains,double Time,double HalfTime){
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        double result;
        result= QuantityRemains*Math.pow(2, (Time/HalfTime));
        return  Double.parseDouble(df.format(result));


    }

	public double calculateTimeHalfFromInitial(double QuantityRemains,double InitialQuantity, double Time){
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        double cur;
		cur=Double.parseDouble(df.format(-(Time*0.3010299956639812)/Math.log10(QuantityRemains/InitialQuantity)));
		
		return cur;
	}
	
	
	public double calculateTimeFromQuantity(double HalfTime,double QuantityRemains,double InitialQuantity)
	{
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
		double result;
		result=-(HalfTime*Math.log10(QuantityRemains/InitialQuantity)/0.3010299956639812);
        return  Double.parseDouble(df.format(result));

    }
	
	/*public static void main(String args[])
	{
		halfLifeCalculator ohm= new halfLifeCalculator();
		double quantity,initial,halftime,time;
		quantity=ohm.calculateQuantityRemainsFromInitial(10,10,10);
		 System.out.print("\n Quantity Remains  is:"+quantity);
		 initial=ohm.calculateInitialQuantityFromQuantityRemains(10,10,10);
		System.out.print("\n Initial Quantity is:"+initial);
		halftime=ohm.calculateTimeHalfFromInitial(8,20,40);
		 System.out.print("\n Half Time is:"+halftime);
		 time=ohm.calculateTimeFromQuantity(10,8,10);
	  System.out.print("\n Time is:"+time);
		 
	}*/
	


}
