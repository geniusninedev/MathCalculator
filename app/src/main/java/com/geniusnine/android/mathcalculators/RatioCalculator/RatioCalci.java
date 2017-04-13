package com.geniusnine.android.mathcalculators.RatioCalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Dev on 23-03-2017.
 */

public class RatioCalci {


    public static final String RESULT_FORMAT = "#.#####";

    public double calculateFirstValueFrom(double valueTwo, double valueThree,double valueFour){

        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);

        double result;
        result=(valueTwo*valueThree)/valueFour;

        return  Double.parseDouble(df.format(result));

    }

    public double calculateSecondValueFrom(double valueOne,double valueThree,double valueFour){
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        double result;
        result= (valueOne*valueFour)/valueThree;
        return  Double.parseDouble(df.format(result));


    }

    public double calculateThirdValueFrom(double valueOne,double valueTwo, double valueFour){
    /*    DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);*/
        double cur;
        cur=(valueOne*valueFour)/valueTwo;

        return Double.valueOf(cur) ;
        /*Double.parseDouble(df.format(cur));*/
    }


    public double calculateFourthValueFrom(double valueOne,double valueTwo,double valueThree)
    {
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        double result;
        result=(valueTwo*valueThree)/valueOne;
        return  Double.parseDouble(df.format(result));

    }


    public  double calculateShrinkage(int ValueOne,double ValueThree){
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
    double result;
    result=ValueOne/ValueThree;
    return  Double.parseDouble(df.format(result));
}

    public  double calculateShrinkageOne(int ValueTwo,double ValueThree){
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        double result;
        result=ValueTwo/ValueThree;
        return   Double.parseDouble(df.format(result));
    }


    public  double calculateEnlarge(int ValueOne,double ValueThree){
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        double result;
        result=ValueOne*ValueThree;
        return  Double.parseDouble(df.format(result));
    }
    public  double calculateEnlargeOne(int ValueTwo,double ValueThree){
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        df.setRoundingMode(RoundingMode.HALF_UP);
        double result;
        result=ValueTwo*ValueThree;
        return  Double.parseDouble(df.format(result));
    }
}
