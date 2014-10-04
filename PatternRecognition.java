package PatternRecognition;

public class PatternRecognition{

	public static void main(String[] args){
		
	}

	

	interface PatternRule{
		//check returns true if the pattern is recognized, i.e. process is out of control
		public boolean check(double value);
	}

	class AltIncDec implements PatternRule {
		//Fourteen points in a row alternating up and down
		int count;
		int n = 14;
		double last;
		boolean up;
		public AltIncDec(double cl){
			this.count = 0;
			this.last = cl;
			this.up = true;
		}
		public boolean check(double value){
			if (this.up){
				if(value<= this.last){
					this.count++;
					up = false;
				} else {
					this.count = 1;
				}
			} else {
				if(value > this.last){
					this.count++;
					up = true;
				} else {
					this.count = 1;
				}
			}
			this.last = value;
			if(count>=n) return true;
			else return false;
		}
	
	}
	
	class ConstIncDec implements PatternRule {
		//Six points in a row steadily increasing or decreasing
		int count;
		int n = 6;
		double last;
		boolean up;
		public ConstIncDec(double cl){
			this.count = 0;
			this.last = cl;
			this.up = true;
		}
		public boolean check(double value){
			if (this.up){
				if(value > this.last){
					this.count++;
				} else {
					this.count = 1;
					up = false;
				}
			} else {
				if(value<=this.last){
					this.count++;
				} else {
					this.count = 1;
					up = true;
				}
			}
			this.last = value;
			if(count>=n) return true;
			else return false;
		}
	
	}
	
	class OutsideTwoSigma implements PatternRule {
		//Two of three consecutive points outside the two-sigma warning limits but still within control (3 sigma)  limits
		int nextIndex;
		boolean[] three;
		double cl;
		double sigma;
	
		public OutsideTwoSigma(double c, double s){
			this.cl = c;
			this.sigma = s;
			this.nextIndex = 0;
			this.three = new boolean[3];
		}
	
		public boolean check(double value){
			three[nextIndex] = (Math.abs(value-cl)>=2*sigma);
			nextIndex = (nextIndex + 1) % 3;
			return ((three[1]&&three[2]) || (three[2]&&three[3]) || (three[3]&&three[1]));
		}
	
	}
	
	class InsideOneSigma implements PatternRule {
		//Fifteen points in a row within one-sigma limits
		int count;
		int n = 15;
		double cl;
		double sigma;
		public InsideOneSigma(double c, double s){
			this.cl = c;
			this.sigma = s;
			this.count=0;
		}
		public boolean check(double value){
			if (Math.abs(value-cl) >= sigma){
				count++;
			} else {
				count = 0;
			}
			return (count>=n);
		}
	
	}
	
	class OutsideLimits implements PatternRule {
		//One or more points outside of control limits
		double cl;
		double ucl;
		public OutsideLimits(double c, double s){
			this.cl = c;
			this.ucl = c + 3*s;
		}
		public boolean check(double value){
			return (Math.abs(value-cl) >= ucl);
		}
	
	}
	
	class OutsideOneSigma implements PatternRule {
		//Four of five consecutive points beyond the one-sigma limits but still inside of control limits
		int nextIndex;
		boolean[] five;
		double cl;
		double sigma;
	
		public OutsideOneSigma(double c, double s){
			this.cl = c;
			this.sigma = s;
			this.nextIndex = 0;
			this.five = new boolean[5];
		}
	
		public boolean check(double value){
			five[nextIndex] = (Math.abs(value-cl)>=sigma);
			nextIndex = (nextIndex + 1) % 5;
			int count=0;
			for(int ii=0; ii<5; ii++){
				if(five[ii]) count++;
			}
			return (count>=4);
		}
	
	}
	
	class OneSide implements PatternRule {
		//A run of eight consecutive points on one side of the center line
		double cl;
		int count;
		boolean above;
		int n = 8;
		public OneSide(double c){
			this.cl = c;
			this.count=0;
			this.above=true;
		}
		public boolean check(double value){
			if(above && (value>=this.cl)){
				count++;
			} else if (!above && (value<=this.cl)){
				count++;
			} else {
				count = 1;
				above = !above;
			}
			return (count>=n);
		}
	}
	
	class BetweenOneTwo implements PatternRule {
		//Eight points in a row between the one-sigma and two-sigma limits
		double cl;
		double sigma;
		int count;
		int n = 8;
		public BetweenOneTwo(double c, double s){
			this.cl = c;
			this.sigma = s;
			this.count=0;
		}
		public boolean check(double value){
			if((Math.abs(value-this.cl)<= 2*sigma) && (Math.abs(value-this.cl)>=sigma)){
				count++;
			} else {
				count = 0;
			}
			return (count>=n);
		}
	
	}


}