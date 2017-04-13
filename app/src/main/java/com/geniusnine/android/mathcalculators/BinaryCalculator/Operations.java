package com.geniusnine.android.mathcalculators.BinaryCalculator;

public class Operations {



	public int BinarySum(String a, String b){
        int left = Integer.parseInt(String.valueOf(a), 2);
        int right = Integer.parseInt(String.valueOf(b), 2);
        int sum = left + right;
        return new Integer(sum);


	}

	    public int GetBinaryDiff(String a, String b){
	        int left = Integer.parseInt(a, 2);
	        int right = Integer.parseInt(b, 2);
	        int diff = left - right;
            return new Integer(diff);
	    }

	    public int GetBinaryProd(String a, String b){
	        int left = Integer.parseInt(a, 2);
	        int right = Integer.parseInt(b, 2);
	        int prod = left * right;
	        return new Integer(prod);
	    }

	    public int GetBinaryQuotient(String a, String b){
	        int left = Integer.parseInt(a, 2);
	        int right = Integer.parseInt(b, 2);
	        int quotient = left / right;
	        return  new Integer(quotient);
	    }


	}
