package MainPackage;

public class Engine {
		
		public static double HousePayment(double GrossIncome){
			double housePayment = (GrossIncome/12)* 0.18;
			return housePayment;
		
		}

		public static double DebtPayment(double GrossIncome, double monthlyDebt){
			double debtPayment = ((GrossIncome/12)*0.36)-monthlyDebt;
			return debtPayment;
			
		}
		
		public static double Payment(double debtPayment, double housePayment){
			if(debtPayment<housePayment){
				return debtPayment;
				
			}
			else{
				return housePayment;
			}
		}
		//took from lab1 
		public static double pv(double r, double n, double Payment, double f, boolean t) {
	        double retval = 0;
	        if (r == 0) {
	            retval = -1*((n*Payment)+f);
	        }
	        else {
	            double r1 = r + 1;
	            retval =(( ( 1 - Math.pow(r1, n) ) / r ) * (t ? r1 : 1)  * Payment - f)
	                     /
	                    Math.pow(r1, n);
	        }
	        return -retval;
	    }

		}
	


