package mimir.patterns;
public class OutsideOneSigma implements PatternRule {
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