//package io.kd.lrcusack.mimir;

public class BetweenOneTwo implements PatternRule {
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
