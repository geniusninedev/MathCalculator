package com.geniusnine.android.mathcalculators.HalfLifeCalci;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MeanHalfLifeCalci {

	public static final String RESULT_FORMAT = "#.####";


	public double calculatehalfTimeFromMeanLifeTime(double meanLifeTime){
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
		double result;
		result=Math.log(2)*meanLifeTime;
        return  Double.parseDouble(df.format(result));
				
	}
	public double calculatehalfTimeFromDecayConstant(double decayConstant){
		DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
		df.setRoundingMode(RoundingMode.HALF_UP);
        double result;
        result=Math.log(2)/decayConstant;
        return  Double.parseDouble(df.format(result));
				
	}
	
	
	public double calculateMeanLifeTimeFromhalfTime(double halfTime){

        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        double result;
        result=halfTime/Math.log(2);
        return  Double.parseDouble(df.format(result));
				
	}
	public double calculateMeanLifeTimeFromDecayConstant(double decayConstant){
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        double result;
        result=1/decayConstant;
        return  Double.parseDouble(df.format(result));
				
	}
	
public double calculateDecayconstantFromhalfTime(double halfTime){

    DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
    df.setRoundingMode(RoundingMode.HALF_UP);
    double result;
    result=Math.log(2)/halfTime;
    return  Double.parseDouble(df.format(result));
				
	}
	public double calculateDecayconstantFromMeanLifeTime(double meanLifeTime){
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        double result;
        result=1/meanLifeTime;
        return  Double.parseDouble(df.format(result));
				
	}
	
	
/*	public static void main(String args[])
	{
		MeanHalfLifeCalci ohm= new MeanHalfLifeCalci();
		double timefromlifetime,timefromdecay,lifetimeFormTime,lifetimeFormDecay;
		double decayFromhalfTime,decayFromLifeTime;
		timefromlifetime=ohm.calculatehalfTimeFromMeanLifeTime(10);
		 System.out.print("\n Time is:"+timefromlifetime);
		 timefromdecay=ohm.calculatehalfTimeFromDecayConstant(10);
			 System.out.print("\n Time  is:"+timefromdecay+"\n");
			 
			 lifetimeFormTime=ohm.calculateMeanLifeTimeFromhalfTime(10);
			 System.out.print("\n Mean Life Time  is:"+lifetimeFormTime);
			 lifetimeFormDecay=ohm.calculateMeanLifeTimeFromDecayConstant(10);
			 System.out.print("\n Mean Life Time  is:"+lifetimeFormDecay+"\n");
			 
			 decayFromhalfTime=ohm.calculateDecayconstantFromhalfTime(10);
			 System.out.print("\n Decay Constant is:"+decayFromhalfTime);
			 decayFromLifeTime=ohm.calculateDecayconstantFromMeanLifeTime(10);
			 System.out.print("\n Decay Constant is:"+decayFromLifeTime);
		 
	}*/
	
}
