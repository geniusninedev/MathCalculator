package com.geniusnine.android.mathcalculators.GCFCalculator;

public class gcf {
/*	public static void main(String[] args) {
		
		        // TODO Auto-generated method stub
		
		 
		
		        Scanner input = new Scanner(System.in);
		
		         
		
		        System.out.print("Enter the first integer: ");
		
		        int n1 = input.nextInt();
		
		        System.out.print("Enter the second integer: ");
		
		        int n2 = input.nextInt();
		
		        System.out.print("Enter the third integer: ");
		
		        int n3 = input.nextInt();
		
		        System.out.print("Enter the fourth integer: ");
		
		        int n4 = input.nextInt();
		
		        System.out.print("Enter the fifth integer: ");
		
		        int n5 = input.nextInt();
		
		         
		
		        System.out.println("The greatest common divisor for " + n1 + " and " + n2 + " and " +
		
		                n3 + " and " +" and " + n4 + " and " + n5 + " is " + gcd(n1,n2,n3, n4, n5));
		
		        }*/
		
		        public static int gcd(int n1, int n2, int n3, int n4, int n5){
		
		            int gcd = 1;
		
		            int k = 2;
		         
		
		        while (k <= n1 && k <= n2 && k <= n3 && k <= n4 && k <= n5){
		
		            if (n1 % k == 0 && n2 % k == 0 && n3 % k == 0 && n4 % k == 0 && n5 % k == 0)
		
		                gcd = k;
		
		            k++;
		
		        }
		
		        return gcd;
		
		        }

	public  static  int gcdOne(int n1,int n2){
		int gcd = 1;

		int k = 2;


		while (k <= n1 && k <= n2 ){

			if (n1 % k == 0 && n2 % k == 0)

				gcd = k;

			k++;

		}

		return gcd;

	}
	public  static  int gcdTwo(int n1,int n2,int n3){
		int gcd = 1;

		int k = 2;


		while (k <= n1 && k <= n2 && k <= n3){

			if (n1 % k == 0 && n2 % k == 0 && n3 % k == 0)

				gcd = k;

			k++;

		}

		return gcd;

	}
	public  static  int gcdThree(int n1,int n2,int n3,int n4){
		int gcd = 1;

		int k = 2;


		while (k <= n1 && k <= n2 && k <= n3 && k <= n4 ){

			if (n1 % k == 0 && n2 % k == 0 && n3 % k == 0 && n4 % k == 0)

				gcd = k;

			k++;

		}

		return gcd;

	}
	public  static  int gcdFour(int n1,int n2,int n3,int n4,int n5,int n6){
		int gcd = 1;

		int k = 2;


		while (k <= n1 && k <= n2 && k <= n3 && k <= n4 && k <= n5 && k <= n6){

			if (n1 % k == 0 && n2 % k == 0 && n3 % k == 0 && n4 % k == 0 && n5 % k == 0 && n6 % k == 0)

				gcd = k;

			k++;

		}

		return gcd;

	}
	public  static  int gcdFive(int n1,int n2,int n3,int n4,int n5,int n6,int n7){
		int gcd = 1;

		int k = 2;


		while (k <= n1 && k <= n2 && k <= n3 && k <= n4 && k <= n5 && k <= n6 && k <= n7){

			if (n1 % k == 0 && n2 % k == 0 && n3 % k == 0 && n4 % k == 0 && n5 % k == 0 && n6 % k == 0 && n7 % k == 0)

				gcd = k;

			k++;

		}

		return gcd;

	}
	public  static  int gcdSix(int n1,int n2,int n3,int n4,int n5,int n6,int n7,int n8){
		int gcd = 1;

		int k = 2;


		while (k <= n1 && k <= n2 && k <= n3 && k <= n4 && k <= n5 && k <= n6 && k <= n7 && k <= n8){

			if (n1 % k == 0 && n2 % k == 0 && n3 % k == 0 && n4 % k == 0 && n5 % k == 0 && n6 % k == 0 && n7 % k == 0 && n8 % k == 0)

				gcd = k;

			k++;

		}

		return gcd;

	}
	public  static  int gcdSeven(int n1,int n2,int n3,int n4,int n5,int n6,int n7,int n8,int n9){
		int gcd = 1;

		int k = 2;


		while (k <= n1 && k <= n2 && k <= n3 && k <= n4 && k <= n5 && k <= n6 && k <= n7 && k <= n8 && k <= n9){

			if (n1 % k == 0 && n2 % k == 0 && n3 % k == 0 && n4 % k == 0 && n5 % k == 0 && n6 % k == 0 && n7 % k == 0 && n8 % k == 0 && n9 % k == 0)

				gcd = k;

			k++;

		}

		return gcd;

	}
	public  static  int gcdEight(int n1,int n2,int n3,int n4,int n5,int n6,int n7,int n8,int n9,int n10){
		int gcd = 1;

		int k = 2;


		while (k <= n1 && k <= n2 && k <= n3 && k <= n4 && k <= n5 && k <= n6 && k <= n7 && k <= n8 && k <= n9 && k <= n10){

			if (n1 % k == 0 && n2 % k == 0 && n3 % k == 0 && n4 % k == 0 && n5 % k == 0 && n6 % k == 0 && n7 % k == 0 && n8 % k == 0 && n9 % k == 0 && n10 % k == 0)

				gcd = k;

			k++;

		}

		return gcd;

	}
}
