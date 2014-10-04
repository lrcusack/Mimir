package mimir.patterns;
public class InsideOneSigma implements PatternRule {
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