package com.geniusnine.android.mathcalculators.PercentErrorCalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PercentageErrorCalci {


	public static final String RESULT_FORMAT = "#.####";
	    public double calculatePercentageError(double ObservedValue, double TrueValue){
			double result;
            DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
            df.setRoundingMode(RoundingMode.HALF_UP);

			result=(ObservedValue-TrueValue)/(TrueValue/100);
            return  Double.parseDouble(df.format(result));

			
		}


}
