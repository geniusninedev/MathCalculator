package com.geniusnine.android.mathcalculators.MassCalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DensityCalci {
	double volume;
	double mass;
	double density;
	public static final String RESULT_FORMAT = "#.###";
	public double calculateDensityfromVolume(double volume,double mass){
		DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
		df.setRoundingMode(RoundingMode.HALF_UP);
		return  Double.parseDouble(df.format(mass/volume));
	}
	
public double calculateVolumefromDensity(double density,double mass){
	DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
	df.setRoundingMode(RoundingMode.HALF_UP);
		return Double.parseDouble(df.format(mass/density));
	}
	
	
public double calculateMassfromDensity(double density,double volume){
	DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
	df.setRoundingMode(RoundingMode.HALF_UP);
	return  Double.parseDouble(df.format(density*volume));
}

	
	

    public static void main(String args[])
    {

    	DensityCalci densityCalculator= new DensityCalci();

    	double densityfromvolume,volumefromdensity,massFromDensity;

    	densityfromvolume=densityCalculator.calculateDensityfromVolume(10,10);
    	System.out.print("\n Density is:"+densityfromvolume/1000+" kilogram/cubic meter");

    	volumefromdensity=densityCalculator.calculateVolumefromDensity(100,10);
    	System.out.print("\n Volume is:"+volumefromdensity/1000+" cubic meter");
    	
    	massFromDensity=densityCalculator.calculateMassfromDensity(100,10);
    	System.out.print("\n Mass is:"+massFromDensity+" kilogram");
}
}