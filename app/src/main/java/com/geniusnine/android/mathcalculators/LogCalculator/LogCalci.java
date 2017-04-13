package com.geniusnine.android.mathcalculators.LogCalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class LogCalci {

	public static final String RESULT_FORMAT = "#.#####";

	public static double logb( double a, double b )
	{

		/*DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
		df.setRoundingMode(RoundingMode.HALF_UP);*/
	return (Math.log(a) / Math.log(b));
	}

	public static double log2( double a )
	{
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);

        return Double.parseDouble(df.format(logb(a,2)));
	}

	public static double loge( double a )
	{
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
		df.setRoundingMode(RoundingMode.HALF_UP);
		return  Double.parseDouble(df.format(Math.log(a)));
		/*return Math.log(a);*/
	}

    public static double log10( double a )
    {
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);

        return Double.parseDouble(df.format(logb(a,10)));
    }
}
