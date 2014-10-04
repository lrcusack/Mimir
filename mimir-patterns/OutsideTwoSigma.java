//package io.kd.lrcusack.mimir;

public class OutsideTwoSigma implements PatternRule {
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